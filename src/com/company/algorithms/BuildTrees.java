package com.company.algorithms;

import com.company.base.TreeNode;

public class BuildTrees {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0){
            return null;
        }

        return recursive(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    private TreeNode recursive(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){
        if (preStart > preEnd || inStart > inEnd){
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int i=inStart;
        while (i<=inEnd && inorder[i] != preorder[preStart]){
            i++;
        }

        int leftCount = i-inStart;
        root.left = recursive(preorder, inorder, preStart+1, preStart+leftCount, inStart, i-1);
        root.right = recursive(preorder, inorder, preStart+leftCount+1, preEnd, i+1, inEnd);
        return root;
    }
}
