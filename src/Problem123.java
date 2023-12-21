public class Problem123 {
    static int maxSum = Integer.MIN_VALUE;
    public static void main(String[] args) {
        System.out.println(maxPathSum(new TreeNode(0)));
    }
    public static int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    public static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int val1 = dfs(root.left);
            int val2 = dfs(root.right);
            int sum = root.val + (Math.max(val1, 0)) + (Math.max(val2, 0));
            maxSum = Math.max(maxSum, sum);
            return sum;
        }

    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
