package com.company.swordoffer;

import com.company.base.TreeNode;

import java.util.Stack;

public class IsSubStructure {

    public boolean isSubStructure(TreeNode a, TreeNode b){
        if (b == null){
            return false;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(a);

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (isSame(node, b)){
                return true;
            }

            if (node.left != null){
                stack.push(node.left);
            }

            if (node.right != null){
                stack.push(node.right);
            }

        }

        return false;
    }

    private boolean isSame(TreeNode a, TreeNode b){
        if (a == null && b == null){
            return true;
        }else if(a == null){
            return false;
        }else if(b == null){
            return true;
        }else if(a.val != b.val){
            return false;
        }

        return isSame(a.left, b.left) && isSame(a.right, b.right);
    }
}
