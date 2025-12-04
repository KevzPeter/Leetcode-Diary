class Solution {
    public int countCollisions(String directions) {
        Stack<Character> stack = new Stack<>();
        int collisions = 0;
        for (char direction : directions.toCharArray()) {
            if (stack.isEmpty() || direction == 'R') {
                stack.push(direction);
            } else if (direction == 'L') {
                if (stack.peek() == 'R') {
                    stack.pop();
                    collisions += 2;
                    while (!stack.isEmpty() && stack.peek() == 'R') {
                        collisions += 1;
                        stack.pop();
                    }
                    stack.push('S');
                } else if (stack.peek() == 'S') {
                    collisions += 1;
                }
            } else {
                while (!stack.isEmpty() && stack.peek() == 'R') {
                    collisions += 1;
                    stack.pop();
                }
                stack.push(direction);
            }
        }
        return collisions;
    }
}