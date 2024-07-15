import java.util.*;

public class NumberOfAtoms {
    public String countOfAtoms(String formula) {
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < formula.length(); i++) {
            char c = formula.charAt(i);
            if (Character.isLetter(c) || Character.isDigit(c)) {
                sb.append(c);
            } else if (c == '(') {
                stack.push(sb.toString());
                stack.push("(");
                sb = new StringBuilder();
            } else {
                String curr = sb.toString();
                if (curr.length() == 0) {
                    sb = new StringBuilder();
                    while (!stack.peek().equals("(")) {
                        sb.append(stack.pop());
                    }
                    curr = sb.toString();
                }
                if (stack.peek().equals("(")) {
                    stack.pop();
                }
                sb = new StringBuilder();
                if (i + 1 < formula.length() && Character.isDigit(formula.charAt(i + 1))) {
                    int j = i + 1;
                    while (j < formula.length() && Character.isDigit(formula.charAt(j))) {
                        j++;
                    }
                    long count = Long.parseLong(formula.substring(i + 1, j));
                    for (int k = 0; k < count; k++) {
                        sb.append(curr);
                    }
                    stack.push(parser(sb.toString()));
                    sb = new StringBuilder();
                    i = j - 1;
                } else {
                    stack.push(curr);
                }
            }
        }
        if (sb.length() > 0) {
            stack.push(sb.toString());
        }
        sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return parser(sb.toString());
    }

    private String parser(String formula) {
        TreeMap<String, Long> tMap = new TreeMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < formula.length(); i++) {
            char c = formula.charAt(i);
            if (Character.isLetter(c) && Character.isUpperCase(c)) {
                if (i + 1 < formula.length() && Character.isLowerCase(formula.charAt(i + 1))) {
                    String element = formula.substring(i, i + 2);
                    if (!tMap.containsKey(element)) {
                        tMap.put(element, 0L);
                    }
                    if (i + 2 < formula.length() && Character.isDigit(formula.charAt(i + 2))) {
                        int j = i + 2;
                        while (j < formula.length() && Character.isDigit(formula.charAt(j))) {
                            j++;
                        }
                        long count = Long.parseLong(formula.substring(i + 2, j));
                        tMap.put(element, tMap.get(element) + count);
                    } else {
                        tMap.put(element, tMap.get(element) + 1L);
                    }
                } else if (i + 1 < formula.length() && Character.isDigit(formula.charAt(i + 1))) {
                    String element = formula.substring(i, i + 1);
                    if (!tMap.containsKey(element)) {
                        tMap.put(element, 0L);
                    }
                    int j = i + 1;
                    while (j < formula.length() && Character.isDigit(formula.charAt(j))) {
                        j++;
                    }
                    long count = Long.parseLong(formula.substring(i + 1, j));
                    tMap.put(element, tMap.get(element) + count);
                } else {
                    String element = formula.substring(i, i + 1);
                    if (!tMap.containsKey(element)) {
                        tMap.put(element, 0L);
                    }
                    tMap.put(element, tMap.get(element) + 1);
                }
            }
        }
        for (Map.Entry<String, Long> e : tMap.entrySet()) {
            sb.append(e.getKey());
            if (e.getValue() > 1)
                sb.append(String.valueOf(e.getValue()));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        NumberOfAtoms sol = new NumberOfAtoms();
        String result = sol.countOfAtoms("K4(ON(SO3)2)2");
        System.out.println(result);
    }
}