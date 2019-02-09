package com.cp3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ankur on 31/3/18.
 */
public class PowerSet {

    public Set<String> powerSet(List<?> set) {

        HashSet<String> result = new HashSet<>();
        int total = 1 << set.size();

        for (int i = 0; i < total; i++) {
            StringBuilder element = new StringBuilder();
            for (int j = 0; j < set.size(); j++) {

                boolean isBitSet = ((i >> j) & 1) == 1;
                if (isBitSet) {
                    element.append(set.get(j)).append(",");
                }
            }
            if (element.length() > 1 && element.substring(element.length() - 1, element.length()).equals(",")) {
                element = new StringBuilder(element.substring(0, element.length() - 1));
            }
            result.add(element.toString());
        }
        return result;
    }
}
