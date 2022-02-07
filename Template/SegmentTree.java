class NumArray {
    private class SegmentTreeNode {
        private SegmentTreeNode left, right;
        private int sum, start, end;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.sum = 0;
            this.left = this.right = null;
        }
    }

    SegmentTreeNode root = null;

    public NumArray(int[] nums) {
        root = buildSegmentTree(nums, 0, nums.length - 1);
    }

    public void update(int index, int val) {
        updateSegmentTree(root, index, val);
    }

    public int sumRange(int left, int right) {
        return sumRangeHelper(root, left, right);
    }

    private SegmentTreeNode buildSegmentTree(int[] arr, int start, int end) {
        if (start > end)
            return null;
        else {
            SegmentTreeNode ret = new SegmentTreeNode(start, end);
            if (start == end) {
                ret.sum = arr[start];
            } else {
                int mid = start + (end - start) / 2;
                ret.left = buildSegmentTree(arr, start, mid);
                ret.right = buildSegmentTree(arr, mid + 1, end);
                ret.sum = ret.left.sum + ret.right.sum;
            }
            return ret;
        }
    }

    private void updateSegmentTree(SegmentTreeNode root, int pos, int val) {
        if (root.start == root.end) {
            root.sum = val;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (pos <= mid)
                updateSegmentTree(root.left, pos, val);
            else
                updateSegmentTree(root.right, pos, val);
            root.sum = root.left.sum + root.right.sum;
        }
    }

    private int sumRangeHelper(SegmentTreeNode root, int start, int end) {
        if (root.start == start && root.end == end) {
            return root.sum;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (end <= mid)
                return sumRangeHelper(root.left, start, end);
            else if (start > mid)
                return sumRangeHelper(root.right, start, end);
            else
                return sumRangeHelper(root.left, start, mid) + sumRangeHelper(root.right, mid + 1, end);
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */