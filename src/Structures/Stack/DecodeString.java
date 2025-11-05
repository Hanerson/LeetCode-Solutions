package Structures.Stack;

import static java.lang.Character.isDigit;

class DecodeString {
    private int index = 0;
    public String decodeString(String s) {
        index = 0;
        return helper(s);
    }
    private String helper(String s) {
        StringBuilder result = new StringBuilder();
        while (index < s.length()) {
            char c = s.charAt(index);
            if (Character.isLetter(c)) {
                result.append(c);
                index++;
            } else if (Character.isDigit(c)) {
                int num = 0;
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    num = num * 10 + (s.charAt(index) - '0');
                    index++;
                }
                index++;
                String sub = helper(s);
                for (int i = 0; i < num; i++) {
                    result.append(sub);
                }
            } else if (c == ']') {
                index++;
                break;
            }
        }
        return result.toString();
    }
}