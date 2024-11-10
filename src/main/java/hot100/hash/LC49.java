package hot100.hash;

import java.util.*;

public class LC49 {
    public static void main(String[] args) {
        System.out.println("yes");
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] currentStrAlphabet = new int[26];

            for (int i = 0; i < str.length(); i++) {
                currentStrAlphabet[(str.charAt(i) - 'a')]++;
            }

            String symbol = "";

            for (int i = 0; i < currentStrAlphabet.length; i++) {
                symbol = symbol + ((char) ('a' + i)) + currentStrAlphabet[i];
            }


            List<String> symbolList = map.getOrDefault(symbol, new ArrayList<>());
            symbolList.add(str);
            map.put(symbol, symbolList);
        }

        return new ArrayList<>(map.values());
    }
}
