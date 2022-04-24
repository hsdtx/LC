package com.company.swordoffer;

import com.company.base.TreeNode;
public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder){
        return recursive(
                preorder,
                inorder,
                0,
                preorder.length-1,
                0,
                inorder.length-1);
    }

    private TreeNode recursive(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){
        if (preStart > preEnd || inStart > inEnd ||
        preStart < 0 || preEnd >= preorder.length ||
        inStart < 0 || inEnd >= inorder.length){
            return null;
        }

        int val = preorder[preStart];
        TreeNode node = new TreeNode(val);

        int inSplit=inStart;
        for (int i=inStart; i<=inEnd; i++){
            if (inorder[i] == val){
                inSplit = i;
                break;
            }
        }
        int leftInStart = inStart;
        int leftInEnd = inSplit-1;
        int rightInStart = inSplit+1;
        int rightInEnd = inEnd;

        int leftPreStart = preStart+1;
        int leftPreEnd = leftPreStart+(inSplit-inStart)-1;
        int rightPreStart = leftPreEnd+1;
        int rightPreEnd = preEnd;

        node.left = recursive(preorder, inorder, leftPreStart, leftPreEnd, leftInStart, leftInEnd);
        node.right = recursive(preorder, inorder, rightPreStart, rightPreEnd, rightInStart, rightInEnd);

        return node;
    }
}
