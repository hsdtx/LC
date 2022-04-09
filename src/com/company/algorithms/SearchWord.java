package com.company.algorithms;

import java.util.HashMap;

public class SearchWord {

    public boolean exist(char[][] board, String word) {
        if (board.length == 1 && board[0].length == 1 && word.length() == 1){
            return board[0][0] == word.charAt(0);
        }

        boolean[][] used = new boolean[board.length][board[0].length];
        char[] chs = word.toCharArray();
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                //找到首字母
                if (board[i][j] == chs[0] && recursive(board, i, j, used, chs, 0)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean recursive(char[][] board, int i, int j, boolean[][] used, char[] chs, int beginIndex){
        if (beginIndex >= chs.length){
            return true;
        }

        if (board[i][j] == chs[beginIndex] && (!used[i][j])){
            used[i][j] = true;
            //向上
            if (i >= 1 && recursive(board, i-1, j, used, chs, beginIndex + 1)){
                return true;
            }

            //向下
            if (i < board.length-1 && recursive(board, i + 1, j, used, chs, beginIndex + 1)){
                return true;
            }

            //向左
            if (j >= 1 && recursive(board,i, j-1, used,chs, beginIndex + 1)){
                return true;
            }

            //向下
            if (j < board[0].length-1 && recursive(board, i, j+1, used, chs, beginIndex+1)){
                return true;
            }
            used[i][j] = false; //回溯
        }

        return false;
    }

}
