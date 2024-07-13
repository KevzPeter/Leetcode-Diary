class Solution {
    private class Robot {
        int position;
        int health;
        Character direction;

        Robot(int p, int h, Character d) {
            position = p;
            health = h;
            direction = d;
        }
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Robot> robots = new ArrayList<>();
        int len = positions.length;
        for (int i = 0; i < len; i++) {
            robots.add(new Robot(positions[i], healths[i], directions.charAt(i)));
        }
        Collections.sort(robots, (a, b) -> a.position - b.position);
        Stack<Robot> stack1 = new Stack<>();
        Stack<Robot> stack2 = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < robots.size(); i++) {
            Robot currRobot = robots.get(i);
            if (currRobot.direction == 'R')
                stack1.push(currRobot);
            else
                stack2.push(currRobot);
            while (!stack1.isEmpty() && !stack2.isEmpty() && stack1.peek().health <= stack2.peek().health) {
                stack1.pop();
                if (stack1.peek().health == stack2.peek().health) {
                    stack2.pop();
                } else {
                    Robot r2 = stack2.pop();
                    r2.health--;
                    stack2.push(r2);
                }
            }
            while (stack1.isEmpty() && !stack2.isEmpty()) {
                Robot bot = stack2.pop();
                map.put(bot.position, bot.health);
            }
            while (!stack1.isEmpty() && !stack2.isEmpty() && stack1.peek().health >= stack2.peek().health) {
                stack2.pop();
                if (stack1.peek().health == stack2.peek().health) {
                    stack1.pop();
                } else {
                    Robot r1 = stack1.pop();
                    r1.health--;
                    stack1.push(r1);
                }
            }
        }
        while (!stack1.isEmpty()) {
            Robot bot = stack1.pop();
            map.put(bot.position, bot.health);
        }
        for (int i = 0; i < len; i++) {
            if (map.get(positions[i]) != null) {
                res.add(map.get(positions[i]));
            }
        }
        return res;
    }
}