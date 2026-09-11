/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int count = 0;

    public int averageOfSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = getSum(root);
        int nodeCount = getCount(root);

        if (root.val == sum / nodeCount) {
            count++;
        }

        averageOfSubtree(root.left);
        averageOfSubtree(root.right);

        return count;
    }

    public int getSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.val + getSum(node.left) + getSum(node.right);
    }

    public int getCount(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + getCount(node.left) + getCount(node.right);
    }
}