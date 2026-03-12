package Daily;

import java.util.ArrayList;
import java.util.List;

/**
 * 并查集数据结构 (Disjoint Set Union)
 * 用于高效地管理和合并连通分量
 */
class DSU {
    int[] parent;

    /**
     * 构造函数，初始化并查集
     * @param parent 父节点数组，parent[i] 表示节点 i 的父节点
     */
    DSU(int[] parent) {
        this.parent = parent.clone();
    }

    /**
     * 查找节点 x 的根节点（代表元）
     * 使用路径压缩优化：将查找路径上的所有节点直接连接到根节点
     * @param x 要查找的节点
     * @return 节点 x 所在集合的根节点
     */
    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // 路径压缩
        }
        return parent[x];
    }

    /**
     * 合并两个节点所在的集合
     * @param x 第一个节点
     * @param y 第二个节点
     */
    void join(int x, int y) {
        int px = find(x); // 找到 x 的根节点
        int py = find(y); // 找到 y 的根节点
        parent[px] = py;  // 将一个根节点连接到另一个根节点下
    }
}

public class MaxStability_3600 {
    // 最大稳定性值的上限，用于初始化和边界判断
    private static final int MAX_STABILITY = 200000;

    /**
     * 计算图的最大稳定性值
     * 
     * 问题描述：
     * - 给定一个无向图，每条边有一个稳定性值 s
     * - 必须选择所有标记为"必需"的边（edge[3] == 1）
     * - 可以选择最多 k 条非必需边，将其稳定性值翻倍
     * - 目标：找到一棵生成树，使得树中所有边的最小稳定性值最大
     * 
     * @param n 节点数量
     * @param edges 边的数组，每条边格式：[u, v, s, isMust]
     *              u, v: 连接的两个节点
     *              s: 稳定性值
     *              isMust: 是否为必需边（1-是，0-否）
     * @param k 最多可以翻倍的边的数量
     * @return 最大化的最小稳定性值，如果无法形成生成树则返回 -1
     */
    public int maxStability(int n, int[][] edges, int k) {
        int ans = -1; // 存储最终答案
        
        // 剪枝：如果边的总数小于 n-1，无法形成生成树（生成树需要恰好 n-1 条边）
        if (edges.length < n - 1) {
            return -1;
        }
        
        // 将边分为必需边和可选边两类
        List<int[]> mustEdges = new ArrayList<>();
        List<int[]> optionalEdges = new ArrayList<>();

        for (int[] edge : edges) {
            if (edge[3] == 1) {
                mustEdges.add(edge);
            } else {
                optionalEdges.add(edge);
            }
        }

        // 剪枝：如果必需边超过 n-1 条，必然会形成环，无法构成生成树
        if (mustEdges.size() > n - 1) {
            return -1;
        }

        // 将可选边按稳定性值从大到小排序
        // 贪心策略：优先选择稳定性值大的边
        optionalEdges.sort((a, b) -> b[2] - a[2]);
        
        int selectedInit = 0;           // 已选择的必需边数量
        int mustMinStability = MAX_STABILITY; // 必需边中的最小稳定性值

        // 初始化并查集，每个节点自成一个集合
        int[] initParent = new int[n];
        for (int i = 0; i < n; i++) {
            initParent[i] = i;
        }
        DSU dsuInit = new DSU(initParent);

        // 处理所有必需边，构建生成树的初始部分
        for (int[] e : mustEdges) {
            int u = e[0], v = e[1], s = e[2];
            // 如果两个节点已经连通，说明形成了环，无法构成生成树
            if (dsuInit.find(u) == dsuInit.find(v) || selectedInit == n - 1) {
                return -1;
            }
            dsuInit.join(u, v);        // 合并两个节点所在的集合
            selectedInit++;            // 已选边数 +1
            mustMinStability = Math.min(mustMinStability, s); // 更新必需边的最小稳定性
        }

        // 使用二分法寻找最大的最小稳定性值
        // 二分的范围：[0, mustMinStability]
        // 因为最终答案不能超过必需边的最小稳定性值
        int l = 0, r = mustMinStability;
        while (l < r) {
            // 假设当前要验证的最小稳定性值为 mid
            int mid = l + (r - l + 1) / 2;

            // 复制初始并查集状态，用于本次验证
            DSU dsu = new DSU(dsuInit.parent);
            int selected = selectedInit;  // 已选择的边数
            int doubledCount = 0;         // 已翻倍的边数

            // 贪心地选择可选边，尝试构建生成树
            for (int[] e : optionalEdges) {
                int u = e[0], v = e[1], s = e[2];
                
                // 如果两个节点已经连通，跳过这条边（避免形成环）
                if (dsu.find(u) == dsu.find(v)) {
                    continue;
                }
                
                // 情况 1: 边的稳定性值 >= mid，可以直接使用
                if (s >= mid) {
                    dsu.join(u, v);
                    selected++;
                } 
                // 情况 2: 边的稳定性值 < mid，但翻倍后 >= mid，且还有翻倍次数
                else if (doubledCount < k && s * 2 >= mid) {
                    doubledCount++;  // 使用一次翻倍机会
                    dsu.join(u, v);
                    selected++;
                } 
                // 情况 3: 边的稳定性值即使翻倍也达不到 mid，由于已排序，后续边也不用考虑
                else {
                    break;
                }
                
                // 如果已经选择了 n-1 条边，生成树构建完成
                if (selected == n - 1) {
                    break;
                }
            }

            // 判断是否能形成完整的生成树
            if (selected != n - 1) {
                // 无法形成生成树，说明 mid 太大，需要减小右边界
                r = mid - 1;
            } else {
                // 可以形成生成树，记录答案并尝试更大的值
                ans = l = mid;
            }
        }

        return ans;
    }
}