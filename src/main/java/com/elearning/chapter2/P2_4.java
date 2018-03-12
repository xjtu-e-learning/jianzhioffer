package com.elearning.chapter2;

public class P2_4 {
    public String replace_blank(String str) {
        StringBuilder sb = new StringBuilder();
        char c;

        for (int i = 0; i < str.length(); ++i) {
            c = str.charAt(i);
            if (c != ' ') {
                sb.append(c);
                continue;
            }
            sb.append("%20");

        }
        return sb.toString();
    }
}
