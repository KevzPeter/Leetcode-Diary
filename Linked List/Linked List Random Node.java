class Solution {
    List<Integer> list;
    int size;
    Random random;

    public Solution(ListNode head) {
        list = new ArrayList<>();
        random = new Random();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        size = list.size();
    }

    public int getRandom() {
        return list.get(random.nextInt(size));
    }
}