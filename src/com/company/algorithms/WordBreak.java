package com.company.algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        return recursive(s, 0, wordDict);
    }

    public boolean recursive(String s, int beginIndex, List<String> wordDict){
        if (beginIndex >= s.length()) return true;

        boolean flag = false;
        for (String pattern: wordDict){
            if (beginIndex + pattern.length() <= s.length() && pattern.equals(s.substring(beginIndex, beginIndex + pattern.length()))){
                flag = recursive(s, beginIndex + pattern.length(), wordDict);
            }

            if (flag){
                return flag;
            }
        }

        return flag;
    }

    /**
     * 动态规划
     * 构建一个dp数组，dp[i]代表s[0~i-1]可以通过dict里的单词组合而成
     * 状态转移矩阵: dp[j] = dp[i] && check(s[i~j-1] in dict)
     * @return
     */
    public boolean dp(String s, List<String> wordDict){
        boolean dp[] = new boolean[s.length() + 1];
        dp[0] = true; //初始化一下

        for (int i=0; i<s.length(); i++){
            for (int j=0; j<wordDict.size(); j++){
                int beginIndex = i+1-wordDict.get(j).length();
                if (beginIndex >= 0){
                    int length = wordDict.get(j).length();
                    dp[i+1] = dp[beginIndex] && wordDict.get(j).equals(s.substring(beginIndex, beginIndex+length));
                    if (dp[i+1]){
                        break;
                    }
                }
            }
        }

        return dp[s.length()];
    }
}
