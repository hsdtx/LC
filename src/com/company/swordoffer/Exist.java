package com.company.swordoffer;
import java.util.Arrays;
import java.util.Stack;
import java.util.function.ToIntFunction;

public class Exist {

    public boolean exist(char[][] board, String word){

        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                if (board[i][j] == word.charAt(0)){
                    return dfs(board, i, j, word, 0);
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, int i, int j, String word, int index){
        if (i<0 || i>=board.length || j<0 || j>=board[0].length){
            return false;
        }
        if (board[i][j] != word.charAt(index)){
            return false;
        }

        if (index == word.length()-1){
            return true;
        }

        board[i][j] = '-'; //标记已经访问过了
//        boolean up = dfs(board, i+1, j, word, index+1);
//        boolean down = dfs(board, i-1, j, word, index+1);
//        boolean left = dfs(board, i, j-1, word, index+1);
//        boolean right = dfs(board, i, j+1, word, index+1);
        //上面的写法不好，没有利用到短路，耗时会长很多
        boolean res = dfs(board, i+1, j, word, index+1)||
                        dfs(board, i-1, j, word, index+1)||
                        dfs(board, i, j-1, word, index+1)||
                        dfs(board, i, j+1, word, index+1);
        board[i][j] = word.charAt(index); //回溯

        return res;
    }
}
