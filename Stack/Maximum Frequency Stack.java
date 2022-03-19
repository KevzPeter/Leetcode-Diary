class FreqStack {
    HashMap<Integer, Integer> map;
    List<Stack<Integer>> list;

    public FreqStack() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public void push(int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
        if (map.get(val) > list.size()) {
            list.add(new Stack<>());
        }
        list.get(map.get(val) - 1).push(val);
    }

    public int pop() {
        int maxFreqElement = list.get(list.size() - 1).pop();
        map.put(maxFreqElement, map.get(maxFreqElement) - 1);
        if (list.get(list.size() - 1).isEmpty()) {
            list.remove(list.size() - 1);
        }
        return maxFreqElement;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */