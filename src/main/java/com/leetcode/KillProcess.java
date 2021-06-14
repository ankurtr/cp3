package com.leetcode;

import java.util.*;

//https://leetcode.com/problems/kill-process/solution/
public class KillProcess {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        int bound = ppid.size();
        for (int index = 0; index < bound; index++) {
            if (ppid.get(index) > 0) {
                List<Integer> l = map.getOrDefault(ppid.get(index), new ArrayList<>());
                l.add(pid.get(index));
                map.put(ppid.get(index), l);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> l = new ArrayList<>();

        queue.add(kill);

        while (!queue.isEmpty()) {
            int id = queue.remove();

            l.add(id);

            if (map.containsKey(id)) {
                queue.addAll(map.get(id));
            }
        }
        return l;
    }
}
