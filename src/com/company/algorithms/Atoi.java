package com.company.algorithms;


public class Atoi {

    /**
     * 状态机
     * @param s
     * @return
     */
    public int myAtoi(String s) {
        char[] chs = s.toCharArray();
        long res = 0;
        int index = 0;
        int negative = 1;
        String state = "start";
        for (int i = 0; i < chs.length; i++){
            state = getState(state, chs[i]);
            System.out.println(state);
            if ("signed".equals(state) && chs[i] == '-'){
                negative = -1;
            }else if ("number".equals(state)){
                res = (long) (res * (index >= 1? 10: 1)) + (chs[i] - '0');
                index ++;
                if (res >= (long)Integer.MAX_VALUE && negative == 1){
                    res = Integer.MAX_VALUE;
                    state = "end";
                }else if(res >= (long)Integer.MAX_VALUE + 1 && negative == -1){
                    res = (long)Integer.MAX_VALUE + 1;
                    state = "end";
                }
            }else if ("end".equals(state)){
                break;
            }
        }
        System.out.println(res);

        return (int) res * negative;
    }

    private String getState(String previousState, char currentChar){

        if ("start".equals(previousState)){
            if (currentChar == ' '){
                return "start";
            }else if(currentChar == '+' || currentChar == '-'){
                return "signed";
            }else if(currentChar >= '0' && currentChar <= '9'){
                return "number";
            }else{
                return "end";
            }
        }else if("signed".equals(previousState)){
            if (currentChar >= '0' && currentChar <= '9'){
                return "number";
            }else{
                return "end";
            }
        }else if("number".equals(previousState)){
            if (currentChar >= '0' && currentChar <= '9'){
                return "number";
            }else{
                return "end";
            }
        }else{
            return "end";
        }
    }
}
