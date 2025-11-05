package Structures.HighLevelStructures.BTree;

/**
 * BTree（B-树）实现（只含查找与插入逻辑）
 * <p>
 * 约定：
 * - degree 表示最小度数 t（t >= 2）
 * - 每个节点最多包含 2*t - 1 个 key，最多 2*t 个 children
 * - 每个非根节点至少包含 t - 1 个 key（删除时需维护，此实现不包含删除）
 * <p>
 * 备注：
 * - 该类依赖同包下的 BTreeNode（应包含：List<Integer> keys, List<BTreeNode> children, boolean isLeaf）
 * - insert 返回当前根节点（可选），也可以改为 void。
 */
public class BTree {
    private final int degree;      // 最小度数 t，决定节点最大/最小容量
    private BTreeNode root;        // 树的根节点

    /**
     * 构造一颗空的 B 树，根为叶子节点
     *
     * @param degree 最小度数 t，必须 >= 2
     */
    public BTree(int degree) {
        if (degree < 2) {
            throw new IllegalArgumentException("BTree degree must be >= 2");
        }
        this.degree = degree;
        this.root = new BTreeNode(true);
    }

    /**
     * 使用指定根初始化 B 树（测试用）
     *
     * @param degree 最小度数 t
     * @param root   初始根节点
     */
    public BTree(int degree, BTreeNode root) {
        if (degree < 2) {
            throw new IllegalArgumentException("BTree degree must be >= 2");
        }
        this.degree = degree;
        this.root = root;
    }

    /**
     * 在整棵树中查找 key 是否存在（对外接口）
     *<p>
     * 时间复杂度：O(t * height) ≈ O(height * t)，通常视为 O(height)（height 与树中 key 个数的对数相关）
     *
     * @param key 要查找的关键字
     * @return 如果存在返回 true，否则 false
     */
    public boolean search(int key) {
        return search(root, key);
    }

    /**
     * 在节点 node 中递归查找 key
     *<p>
     * 算法要点：
     * - 在 node.keys 中顺序查找合适的位置 i，使得 keys[i-1] < key <= keys[i]
     * - 若在当前节点命中则返回 true
     * - 若是叶节点且未命中则返回 false
     * - 否则递归到 children.get(i)
     */
    private boolean search(BTreeNode node, int key) {
        int i = 0;
        // 找到第一个 keys[i] >= key 的下标（或到达末尾）
        while (i < node.keys.size() && key > node.keys.get(i)) {
            i++;
        }

        // 如果找到并且相等，则命中
        if (i < node.keys.size() && key == node.keys.get(i)) {
            return true;
        }

        // 如果是叶子节点，未命中
        if (node.isLeaf) {
            return false;
        }

        // 否则到对应子节点继续查找（children.size() == keys.size() + 1）
        return search(node.children.get(i), key);
    }

    /**
     * 插入关键字的入口（对外接口）
     *<p>
     * 说明：
     * - 如果根节点已满（2*t - 1 个 key），需先分裂根，使树高 +1，然后在新的根（未满）上调用 insertNonFull。
     * - 否则直接在根上调用 insertNonFull。
     *<p>
     * 返回值：
     * - 返回当前根节点（插入后根可能变化，因为根分裂会生成新根）
     *<p>
     * 时间复杂度：
     * - 平均 O(t * height)，最坏（分裂序列）也在 O(t * height) 量级
     *
     * @param key 要插入的关键字
     * @return 插入后（可能更新的）根节点
     */
    public BTreeNode insert(int key) {
        BTreeNode r = root;

        // 根已满时：创建新根 s，把原根 r 作为 s 的第一个孩子，
        // 然后分裂 r（把 r 的中间键上移到 s），此时 s 非满，接着在 s 上插入。
        if (r.keys.size() == 2 * degree - 1) {
            BTreeNode s = new BTreeNode(false);   // 新根（内部节点）
            s.children.add(r);                    // 原根成为新根的第一个子节点
            splitChild(s, 0, r);                  // 分裂原根 r，调整 s 的 keys/children
            root = s;                             // 更新树的根
            insertNonFull(s, key);                // 在非满节点 s 上插入
        } else {
            // 根未满，直接在根上进行插入（递归到未满节点）
            insertNonFull(r, key);
        }

        return root;
    }

    /**
     * 将 parent.children[index]（即 fullChild）进行分裂
     *<p>
     * 前置条件（调用者需要保证）：
     * - fullChild 是一个满节点，fullChild.keys.size() == 2*t - 1
     *<p>
     * 分裂结果：
     * - fullChild 保留前 t-1 个 key
     * - 新节点 newNode（与 fullChild.isLeaf 相同）取得后 t-1 个 key
     * - fullChild 的中间 key（位于 index t-1）被上移到 parent.keys 的位置 i
     * - parent.children 在 i+1 插入 newNode
     *<p>
     * 实现细节要点：
     * - 在从 fullChild 中搬移 key/children 时，使用 remove() 将元素移出，避免重复引用
     * - 操作顺序要小心：当从索引 degree 开始 remove 时，原 fullChild 的结构在变化，remove 的索引是基于当时的列表长度
     *
     * @param parent    父节点
     * @param i         parent 中 children 的下标（fullChild 在 parent.children 的位置）
     * @param fullChild 要分裂的满子节点
     */
    private void splitChild(BTreeNode parent, int i, BTreeNode fullChild) {
        // newNode 将保存 fullChild 的后半部分 key/children
        BTreeNode newNode = new BTreeNode(fullChild.isLeaf);

        // 将 fullChild 的后 t-1 个 key 移动到 newNode
        // 注意：fullChild.keys 当前长度为 2*t - 1，索引从 0..2*t-2
        // 我们要把索引 t .. 2*t-2 （共 t-1 个）移动到 newNode
        for (int j = 0; j < degree - 1; j++) {
            // 每次都移除 degree 位置的元素（因为前半部分元素会依次被移走）
            newNode.keys.add(fullChild.keys.remove(degree));
        }

        // 如果 fullChild 不是叶子，还需要把后 t 个子节点移动到 newNode
        if (!fullChild.isLeaf) {
            for (int j = 0; j < degree; j++) {
                // 同理，每次移除 degree 索引位置的 child 并添加到 newNode.children
                newNode.children.add(fullChild.children.remove(degree));
            }
        }

        // 把 fullChild 的中间 key（索引 degree-1）上移到 parent
        int middleKey = fullChild.keys.remove(degree - 1);

        // 在 parent 中插入中间 key，并把 newNode 放在 parent.children 的 i+1 位置
        parent.keys.add(i, middleKey);
        parent.children.add(i + 1, newNode);

        // 分裂完成后：
        // - fullChild.keys.size() == degree - 1
        // - newNode.keys.size() == degree - 1
        // - 若非叶子：fullChild.children.size() == degree, newNode.children.size() == degree
    }

    /**
     * 在一个未满节点 node 中插入 key（递归函数）
     *<p>
     * 前提：
     * - node.keys.size() < 2*t - 1
     *<p>
     * 算法：
     * - 若 node 是叶子，直接将 key 插入 keys 中的合适位置（保持有序）
     * - 否则找到应进入的子节点 children[i]：
     *      - 若该子节点已满，先 splitChild(node, i, child)，
     *        然后根据中间上移的 key 决定应该进入哪个子节点（i 或 i+1）
     *      - 在最终选定的孩子上递归调用 insertNonFull
     *
     * @param node 当前（未满）节点
     * @param key  要插入的关键字
     */
    private void insertNonFull(BTreeNode node, int key) {
        int i = node.keys.size() - 1;

        if (node.isLeaf) {
            // 在叶子节点中找到插入位置并插入（保持 keys 有序）
            // 先在末尾插入一个占位（扩容），然后向右移动直到找到位置
            node.keys.add(0); // 占位（随后会覆盖）
            while (i >= 0 && key < node.keys.get(i)) {
                node.keys.set(i + 1, node.keys.get(i)); // 向右移动
                i--;
            }
            node.keys.set(i + 1, key); // 插入新键
        } else {
            // 在内部节点中定位应进入的子树索引 i+1（因为 i 从 keys.size()-1 开始）
            while (i >= 0 && key < node.keys.get(i)) {
                i--;
            }
            i++; // i 是目标子节点索引（children 中）

            // 如果目标子节点已满，先分裂该子节点
            BTreeNode child = node.children.get(i);
            if (child.keys.size() == 2 * degree - 1) {
                splitChild(node, i, child);
                // 分裂后，node.keys.get(i) 是上移的中间键
                // 如果要插入的 key 大于该上移键，则应进入右边的新子节点
                if (key > node.keys.get(i)) {
                    i++;
                }
            }

            // 递归到选定的子节点继续插入（此时该子节点必为未满）
            insertNonFull(node.children.get(i), key);
        }
    }
}
