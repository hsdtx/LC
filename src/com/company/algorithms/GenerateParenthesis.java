package com.company.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        char[] chs = new char[n*2];
        //初始化一个字符串
        for (int i=0; i<n; i++){
            chs[i] = '(';
            chs[2*n-i-1] = ')';
        }
        res.add(new String(chs));

        for (int i=1; i<n; i++){
            //从第二个左括号开始互换
            for (int j=n; j<2*n-1; j++){
                //最后一个右括号不互换
                swap(chs, i, j);
                res.add(new String(chs));
                swap(chs, i, j);
            }
        }

        return res;
    }

    private void swap(char[] chs, int i, int j){
        char temp = chs[i];
        chs[i] = chs[j];
        chs[j] = temp;
    }
}
