package com.company.swordoffer;

import com.company.base.TreeNode;
import sun.tools.jstat.JStatLogger;
import sun.tools.jstat.Jstat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder {

    public int[] v1(TreeNode root){
        if (root == null){
            return new int[0];
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        queue.addLast(root);
        while (!queue.isEmpty()){
            TreeNode head = queue.removeFirst();
            res.add(head.val);

            if (head.left != null){
                queue.addLast(head.left);
            }

            if (head.right != null){
                queue.addLast(head.right);
            }
        }

        int[] t = new int[res.size()];
        for (int i=0; i<res.size(); i++){
            t[i] = res.get(i);
        }

        return t;
    }

    public List<List<Integer>> v2(TreeNode root){
        if (root == null){
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        v2Recursive(res, root, 0);

        return res;
    }

    private void v2Recursive(List<List<Integer>> res, TreeNode root, int level){
        if (root == null){
            return ;
        }

        if (res.size() <= level){
            res.add(new ArrayList<>());
        }

        res.get(level).add(root.val);

        v2Recursive(res, root.left, level+1);
        v2Recursive(res, root.right, level+1);
    }

    public List<List<Integer>> v3(TreeNode root){
        if (root == null){
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        boolean reverse = false;
        while (!queue.isEmpty()){
            LinkedList<Integer> levelList = new LinkedList<>();
            int levelSize = queue.size();
            for (int i=0; i<levelSize; i++){
                TreeNode head = queue.removeFirst();
                if (reverse){
                    levelList.addFirst(head.val);
                }else{
                    levelList.addLast(head.val);
                }

                if (head.left != null){
                    queue.addLast(head.left);
                }

                if (head.right != null){
                    queue.addLast(head.right);
                }
            }

            res.add(new ArrayList<>(levelList));
            reverse = !reverse;
        }

        return res;
    }

}