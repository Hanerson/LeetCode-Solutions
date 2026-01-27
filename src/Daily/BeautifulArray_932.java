package Daily;

import java.util.*;

/* A 是漂亮数组，则 a * A + b 也是漂亮数组
 * A 为奇数漂亮数组，B 为偶数漂亮数组，A + B 为漂亮数组
 * 数组两两配对，左数组 * 2 - 1 一定是奇数组，右数组 * 2 一定为偶数组，合并一定为漂亮数组
 * 假设 [1] 是最小漂亮数组，按照上面规律递推得到的一定是漂亮数组。
 * |1|1|1|1|1|1|1|1|
 * |1 2|1 2|1 2|1 2|
 * |1 3 2 4|1 3 2 4|
 * |1 5 3 7 2 6 4 8|
 */

class BeautifulArray_932 {
    public int[] beautifulArray(int N) {
        int[] a = new int[N];
        Arrays.fill(a, 1);
        part(a, 0, N - 1);
        return a;
    }
    public void part(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        part(a, lo, mid);
        part(a, mid + 1, hi);
        for (int i = lo; i <= mid; i++) {
            a[i] = 2 * a[i] - 1;
        }
        for (int i = mid + 1; i <= hi; i++) {
            a[i] = 2 * a[i];
        }
    }
}