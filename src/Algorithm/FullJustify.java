package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FullJustify {
    private static String spaces(int n) {
        if (n <= 0) return "";
        char[] arr = new char[n];
        Arrays.fill(arr, ' ');
        return new String(arr);
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        List<String> line = new ArrayList<>();
        int lineLen = 0; // 仅统计当前行“单词字符总长”（不含间隙空格）

        for (String w : words) {
            // 如果加入 w 后，单词长度 + 至少需要的空隙数 > maxWidth，则先结算当前行
            if (lineLen + line.size() + w.length() > maxWidth) {
                int spacesTotal = maxWidth - lineLen;   // 需要分配的空格总数
                int gaps = line.size() - 1;             // 间隙数量

                if (gaps == 0) { // 只有一个单词：左对齐，后面补空格
                    ans.add(line.get(0) + spaces(spacesTotal));
                } else {
                    int base = spacesTotal / gaps;       // 每个间隙至少的空格
                    int extra = spacesTotal % gaps;      // 多出的空格，从左到右依次 +1
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < line.size(); i++) {
                        sb.append(line.get(i));
                        if (i < gaps) {
                            sb.append(spaces(base + (i < extra ? 1 : 0)));
                        }
                    }
                    ans.add(sb.toString());
                }
                // 开启新行（注意：当前单词 w 还没加）
                line.clear();
                lineLen = 0;
            }

            // 把当前单词放到当前行
            line.add(w);
            lineLen += w.length();
        }

        // 最后一行：左对齐（单词之间 1 空格），末尾补空格
        String last = String.join(" ", line);
        ans.add(last + spaces(maxWidth - last.length()));

        return ans;
    }
    public static void main(String[] args){}
}
