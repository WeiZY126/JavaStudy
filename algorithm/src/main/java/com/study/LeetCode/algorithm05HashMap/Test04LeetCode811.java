package com.study.LeetCode.algorithm05HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 子域名访问计数
 */
public class Test04LeetCode811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        ArrayList<String> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String cpdomain : cpdomains) {
            String[] s = cpdomain.split(" ");
            int num = Integer.valueOf(s[0]);
            Integer integer = map.getOrDefault(s[1], 0);
            map.put(s[1], integer + num);
            for (int i = 0; i < s[1].length(); i++) {
                if (s[1].charAt(i) == '.') {
                    String domain = s[1].substring(i + 1);
                    integer = map.getOrDefault(domain, 0);
                    map.put(domain, integer + num);
                }
            }
        }

        map.forEach((domain, num) -> {
            res.add(num + " " + domain);
        });
        return res;
    }
}
