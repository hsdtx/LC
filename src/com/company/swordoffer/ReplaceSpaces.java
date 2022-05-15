package com.company.swordoffer;

public class ReplaceSpaces {

    /**
     * 额外空间
     */
    public String v1(String s){
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for (int i=0; i<len; i++){
            if (s.charAt(i) == ' '){
                sb.append("%20");
            }else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    /**
     * 开辟一个长度*3的数组，用来放新的字符串，避免写入新的字符时间复杂度是O(n)
     * 有点脱裤子放屁，不过思路可能在别的地方可以用到
     */
    public String v2(String s){
        int len = s.length();
        char[] newChars = new char[len*3];

        int newCharIndex = 0;
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) == ' '){
                newChars[newCharIndex++] = '%';
                newChars[newCharIndex++] = '2';
                newChars[newCharIndex++] = '0';
            }else{
                newChars[newCharIndex++] = s.charAt(i);
            }
        }

        return new String(newChars, 0, newCharIndex);
    }
}
