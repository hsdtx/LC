package com.company.swordoffer;

import java.util.Arrays;
import java.util.Comparator;

public class MinNumber {

    public String minNumber(int[] nums){
        String[] sList = new String[nums.length];
        for (int i=0; i<nums.length; i++){
            sList[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(sList, new Comparator<String>() {
            public int compare(String o1, String o2) {
                if (o1.equals(o2)){
                    return 0;
                }

                int i=0, j=0;
                while (i < o1.length() && j < o2.length()){
                    if (o1.charAt(i) > o2.charAt(j)){
                        return 1;
                    }else if(o1.charAt(i) < o2.charAt(j)){
                        return -1;
                    }else {
                        i++;
                        j++;
                    }
                }

                int modI = i%o1.length(), modJ = j%o2.length();
                if (o1.charAt(modI) < o2.charAt(modJ)){
                    return -1;
                }else if(o1.charAt(modI) > o2.charAt(modJ)){
                    return 1;
                }

                return 0;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String s: sList){
            sb.append(s);
        }

        return sb.toString();
    }
}
