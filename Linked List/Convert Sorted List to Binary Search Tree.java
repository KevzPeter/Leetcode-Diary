class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        ListNode temp = head;
        int count = 0;
        List<Integer> list = new ArrayList<>();
        while(temp != null){
            ++count;
            list.add(temp.val);
            temp = temp.next;
        }
        return convertToTree(list, 0, count);
    }
    private TreeNode convertToTree(List<Integer> list, int low, int high){
        TreeNode temp = null;
        if(low < high){
            int mid = low + (high - low) / 2;
            temp = new TreeNode(list.get(mid));
            temp.left = convertToTree(list, low, mid);
            temp.right = convertToTree(list, mid + 1, high);
        }
        return temp;
    }
}