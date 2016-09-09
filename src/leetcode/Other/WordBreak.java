package leetcode.Other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by RI01796 on 2016/8/22.
 */
public class WordBreak {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        return wordBreakHelper(s,dict,map);
    }

    public ArrayList<String> wordBreakHelper(String s, Set<String> dict, Map<String, ArrayList<String>> listMap){
        if(listMap.containsKey(s)) return listMap.get(s);
        ArrayList<String> result = new ArrayList<>();
        int n = s.length();
        if(n <= 0) return result;
        for(int len = 1; len <= n; ++len){
            String sub_fix = s.substring(0,len);
            if(dict.contains(sub_fix)){
                if(len == n){
                    result.add(sub_fix);
                }else{
                    String prefix = s.substring(len);
                    ArrayList<String> tmp = wordBreakHelper(prefix, dict, listMap);
                    for(String item:tmp){
                        item = sub_fix + " " + item;
                        result.add(item);
                    }
                }
            }
        }
        listMap.put(s, result);
        return result;
    }

}
