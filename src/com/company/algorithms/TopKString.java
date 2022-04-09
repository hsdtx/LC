package com.company.algorithms;

import java.util.HashMap;
import java.util.Set;

public class TopKString {

    private class Node{
        public String str;
        public int times;

        @Override
        public String toString() {
            return "Node{" +
                    "str='" + str + '\'' +
                    ", times=" + times +
                    '}';
        }
    }

    public String sol(String[] strs, int k){
        if (strs == null || strs.length == 0 || strs.length < k){
            return null;
        }

        HashMap<String, Integer> map = new HashMap<>();
        for (String str: strs){
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        //维护一个小顶堆，大于堆顶入堆，小于堆顶淘汰
        Node[] heap = new Node[k];
        int numInHeap = 0;
        Set<String> keySet = map.keySet();
        for (String s: keySet){

            if (numInHeap < k){
                Node node = new Node();
                node.str = s;
                node.times = map.get(s);
                heap[numInHeap] = node;
                numInHeap ++;

                if (numInHeap == k){
                    //建堆
                    buildMinimumHeap(heap);
                }
            }else if(map.get(s) > heap[0].times){
                Node node = new Node();
                node.str = s;
                node.times = map.get(s);
                heap[0] = node;
                heapify(heap, 0);
            }
        }

        return heap[0].str;
    }

    private void buildMinimumHeap(Node[] heap){
        int lastNonLeafIndex = heap.length/2-1;
        for (; lastNonLeafIndex>=0; lastNonLeafIndex--){
            heapify(heap, lastNonLeafIndex);
        }
    }

    private void heapify(Node[] heap, int index){
        int len = heap.length;
        int left = index*2+1;
        int right = index*2+2;
        int minimumIndex = index;

        if (left < len && heap[left].times < heap[minimumIndex].times){
            minimumIndex = left;
        }

        if (right < len && heap[right].times < heap[minimumIndex].times){
            minimumIndex = right;
        }

        if (minimumIndex != index){
            swap(heap, minimumIndex, index);
            heapify(heap, minimumIndex);
        }
    }

    private void swap(Node[] heap, int i, int j){
        Node temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
