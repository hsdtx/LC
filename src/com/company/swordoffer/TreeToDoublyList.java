package com.company.swordoffer;

import com.company.base.TreeNode;

public class TreeToDoublyList {

    TreeNode head, pre;

    public TreeNode treeToDoublyList(TreeNode root){
        if (root == null){
            return null;
        }

        dfs(root);

        //遍历所有节点之后，pre会指向最后一个节点
        pre.right = head;
        head.left = pre;

        return head;
    }

    private void dfs(TreeNode root){
        if (root == null){
            return;
        }

        dfs(root.left);
        //中序
        if (pre == null){
            head = root;
        }else {
            pre.right = root;
            root.left = pre;
        }
        pre = root;

        dfs(root.right);
    }
}
