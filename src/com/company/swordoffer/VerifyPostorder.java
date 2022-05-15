package com.company.swordoffer;

import com.sun.crypto.provider.PBEWithMD5AndDESCipher;
import sun.lwawt.macosx.CSystemTray;

public class VerifyPostorder {

    public boolean v1(int[] postorder){
        return v2Rec(postorder, 0, postorder.length-1);
    }

    /**
     * 这个写的有点差，啰嗦了
     */
    public boolean v1Rec(int[] postorder, int start, int end){
        if (start >= end){
            //null或者单节点
            return true;
        }

        int split = end; //有可能没有右子树
        for (int i=0; i<end; i++){
            if (postorder[i] > postorder[end]){
                split = i;
                break;
            }
        }

        for (int i=split+1; i<end; i++){
            if (postorder[i] < postorder[end]){
                return false;
            }
        }

        return v1Rec(postorder, start, split-1)
                && v1Rec(postorder, split, end-1)
                && (start >= split || postorder[end] > postorder[split-1])
                && (split >= end || postorder[end] < postorder[end-1]);
    }

    public boolean v2Rec(int[] postorder, int start, int end){
        if (start >= end){
            return true;
        }

        int split = end;
        for (int i=start; i<end; i++){
            if (postorder[i] > postorder[end]){
                split = i;
                break;
            }
        }

        int mark = split;
        for (; mark < end; mark++){
            if (postorder[mark] < postorder[end]){
                break;
            }
        }

        return mark == end && v2Rec(postorder, start, split-1) && v2Rec(postorder, split, end-1);
    }
}