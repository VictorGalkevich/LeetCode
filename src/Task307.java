class NumArray {
    public static void main(String[] args) {
        NumArray array = new NumArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        array.update(2, 27);
        int i = array.sumRange(0, 2);
        System.out.println();
    }
    NumArray left;
    NumArray right;
    int lb, rb, sum;
    int[] nums;

    public NumArray(int[] nums) {
        NumArray arr = new NumArray(0, nums.length, nums);
        this.left = arr.left;
        this.right = arr.right;
        this.sum = arr.sum;
        this.nums = arr.nums;
        this.lb = arr.lb;
        this.rb = arr.rb;
    }

    public NumArray(int lb, int rb, int[] nums) {
        this.lb = lb;
        this.rb = rb;
        this.nums = nums;
        if (lb + 1 == rb) {
            this.sum = nums[lb];
        } else {
            int mid = (lb + rb) /2;
            this.left = new NumArray(lb, mid, nums);
            this.right = new NumArray(mid, rb, nums);
            this.sum = left.sum + right.sum;
        }
    }

    public void update(int index, int val) {
        int prevVal = nums[index];
        int diff = val - prevVal;
        add(index, diff);
        nums[index] = val;
    }

    public void add(int k, int x) {
        sum += x;
        if (left != null) {
            if (k < left.rb) {
                left.add(k, x);
            } else {
                right.add(k, x);
            }
        }
    }

    public int sumRange(int left, int right) {
        if (lb >= left && rb <= right + 1)
            return sum;
        if (Math.max(lb, left) >= Math.min(rb, right + 1))
            return 0;
        return this.left.sumRange(left, right) + this.right.sumRange(left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */