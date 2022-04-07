package com.company.algorithms;

public class LongestCommonPrefix {

    /*
     * 最长公共子前缀
     */
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        while (len > 1){
            for (int i=0; i<len; i+=2){
                String prefix = strs[i];
                if (i+1 < len){
                    StringBuilder sb = new StringBuilder();
                    int strLimit = Math.min(strs[i].length(), strs[i+1].length());
                    for (int j=0; j<strLimit; j++){
                        if (strs[i].charAt(j) == strs[i+1].charAt(j)){
                            sb.append(strs[i].charAt(j));
                        }else{
                            break;
                        }
                    }
                    prefix = sb.toString();
                }

                strs[i/2] = prefix;
            }

            len = (int)Math.ceil((float)len/2);
        }

        return strs[0];
    }
}
