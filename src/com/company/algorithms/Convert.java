package com.company.algorithms;

public class Convert {

    public String convert(String s, int numRows){
        if (numRows == 1){
            return s;
        }

        int len = s.length();
        StringBuilder sb = new StringBuilder();
        int gap = numRows+numRows-2;
        for (int i=0; i<numRows; i++){
            if (i<len){
                sb.append(s.charAt(i));
            }

            for (int index = i; index < len; index += gap){
                if (i!=0 && i!=numRows-1){
                    int subGap = gap-i*2;
                    if (index+subGap < len){
                        sb.append(s.charAt(index + subGap));
                    }
                }

                if (index+gap < len){
                    sb.append(s.charAt(index+gap));
                }
            }
        }

        return sb.toString();
    }
}
