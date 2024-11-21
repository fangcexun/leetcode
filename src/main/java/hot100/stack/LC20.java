package hot100.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LC20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();

        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            char pop = stack.pop();

            if (map.get(pop) != c) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
