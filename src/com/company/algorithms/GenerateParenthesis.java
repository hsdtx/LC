package com.company.algorithms;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(new StringBuilder(), n, n, res);
        return res;
    }

    private void dfs(StringBuilder sb, int left, int right, List<String> res){
        if (left > right) return; //剪枝

        if (left == 0 && right == 0){
            res.add(sb.toString());
        }

        if (left > 0){
            dfs(sb.append('('), left-1, right, res);
            sb.deleteCharAt(sb.length()-1); //回溯
        }

        if (right > 0){
            dfs(sb.append(')'), left, right-1, res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
