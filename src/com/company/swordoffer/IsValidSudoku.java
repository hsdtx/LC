package com.company.swordoffer;

import java.util.HashMap;

public class IsValidSudoku {

    /**
     * 想不到和官方思路一样，计数还得是哈希表
     */
    public boolean v1(char[][] board){
        HashMap<Integer, HashMap<Integer, Integer>> rowCount = new HashMap<>();
        HashMap<Integer, HashMap<Integer, Integer>> columnCount = new HashMap<>();
        HashMap<Integer, HashMap<Integer, Integer>> fieldCount = new HashMap<>();
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board[0].length; j++){
                if (board[i][j] != '.'){
                    int mark = board[i][j] - '0';

                    if (rowCount.get(i) == null){
                        rowCount.put(i, new HashMap<>());
                    }

                    if (columnCount.get(j) == null){
                        columnCount.put(j, new HashMap<>());
                    }

                    int index = (i/3)*10+(j/3);
                    if (fieldCount.get(index) == null){
                        fieldCount.put(index, new HashMap<>());
                    }

                    rowCount.get(i).put(mark, rowCount.get(i).getOrDefault(mark, 0)+1);
                    columnCount.get(j).put(mark, columnCount.get(j).getOrDefault(mark, 0)+1);
                    fieldCount.get(index).put(mark, fieldCount.get(index).getOrDefault(mark, 0)+1);

                    if (rowCount.get(i).get(mark) > 1 || columnCount.get(j).get(mark) > 1 || fieldCount.get(index).get(mark) > 1){
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
