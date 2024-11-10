package hot100.slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LC3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("aa"));
        System.out.println(lengthOfLongestSubstring(" "));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        // init
        Set<Character> hashSet = new HashSet<>();
        int result = 1;

        int leftIndex = 0;
        int rightIndex = 0;


        while(rightIndex < s.length()) {
            hashSet.add(s.charAt(leftIndex));

            if (!hashSet.contains(s.charAt(rightIndex))) {
                hashSet.add(s.charAt(rightIndex));
                int currentLength = rightIndex - leftIndex + 1;
                result = result >  currentLength ? result : currentLength;
                rightIndex++;
                continue;
            }

            hashSet.remove(s.charAt(leftIndex));

            if (leftIndex == rightIndex) {
                rightIndex++;
            } else {
                leftIndex++;
            }
        }
        return result;
    }

    public static int lengthOfLongestSubstringTemplate(String s) {
        if (s.length() == 0) {
            return 0;
        }

        // init
        int result = 1;
        int length = s.length();
        Set<Character> hashSet = new HashSet<>();

        for (int left = 0, right = 0; right < length; right++) {
            // 当前需要判断的元素
            char rightChar = s.charAt(right);

            while (hashSet.contains(rightChar)) {
                hashSet.remove(s.charAt(left));
                left++;
            }

            hashSet.add(s.charAt(right));
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
