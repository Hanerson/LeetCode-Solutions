package Daily;

import java.util.*;

public class RotateBox_1861 {
    //整体来说。就是先做最少判断，原先的旋转会带来大量的位置以及状态更新，所以我们先让重力方向改为向右，先处理下落，在处理旋转
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;    // 原矩阵行数
        int n = boxGrid[0].length; // 原矩阵列数

        // 第一步：让每一行的石头受重力下落（靠右对齐，障碍物分隔）
        for (int i = 0; i < m; i++) {
            // 从右往左遍历每一行
            int dropPos = n - 1; // 石头下落的目标位置
            for (int j = n - 1; j >= 0; j--) {
                if (boxGrid[i][j] == '*') {
                    // 遇到障碍物，更新下落位置为障碍物左侧
                    dropPos = j - 1;
                } else if (boxGrid[i][j] == '#') {
                    // 遇到石头，移动到下落位置
                    if (j != dropPos) {
                        boxGrid[i][dropPos] = '#';
                        boxGrid[i][j] = '.';
                    }
                    dropPos--; // 下一个石头落在左边
                }
            }
        }

        // 第二步：顺时针旋转90度
        char[][] res = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][m - 1 - i] = boxGrid[i][j];
            }
        }

        return res;
    }
}
