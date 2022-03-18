class Solution {
    public String removeDuplicateLetters(String s) {
        int lastSeen[] = new int[26];
        for(int i = 0; i < s.length(); i++){
            int curr = s.charAt(i) - 'a';
            lastSeen[curr] = i;
        }
        boolean[] seen = new boolean[26];
        Stack<Character> stack = new Stack();
        for(int i = 0; i < s.length(); i++){
            int curr = s.charAt(i) - 'a';
            if(seen[curr]) continue;
            while(!stack.isEmpty() && stack.peek() > s.charAt(i) && i < lastSeen[stack.peek() - 'a']){
                seen[stack.pop() - 'a'] = false;
            }
            stack.push(s.charAt(i));
            seen[curr] = true;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}