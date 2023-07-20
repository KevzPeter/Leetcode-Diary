class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0)
            return new int[0];

        Stack<Integer> stack = new Stack();

        for (int i = 0; i < asteroids.length; i++) {
            if (stack.isEmpty() || !(asteroids[i] < 0 && stack.peek() > 0)) {
                stack.push(asteroids[i]);
            } else {
                boolean keepAsteroid = false;
                int currentAsteroidSize = Math.abs(asteroids[i]);
                while (!stack.isEmpty() && (asteroids[i] < 0 && stack.peek() > 0)) {
                    int previousAsteroidSize = Math.abs(stack.peek());
                    if (previousAsteroidSize == currentAsteroidSize) {
                        stack.pop();
                        keepAsteroid = false;
                        break;
                    }
                    if (previousAsteroidSize > currentAsteroidSize) {
                        keepAsteroid = false;
                        break;
                    } else {
                        keepAsteroid = true;
                        stack.pop();
                    }
                }
                if (keepAsteroid) {
                    stack.push(asteroids[i]);
                }
            }
        }
        int sz = stack.size();
        int[] res = new int[sz];
        while (!stack.isEmpty()) {
            res[--sz] = stack.pop();
        }
        return res;
    }
}