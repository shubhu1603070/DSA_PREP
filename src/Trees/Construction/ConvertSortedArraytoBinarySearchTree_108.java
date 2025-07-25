package Trees.Construction;

import Trees.TreeNode;

public class ConvertSortedArraytoBinarySearchTree_108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(0,nums.length-1,nums);
    }

    private TreeNode dfs(int start, int end, int[] nums) {
        if(start > end) return null;
        int mid = (start+end)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = dfs(start,mid-1,nums);
        node.right = dfs(mid+1,end,nums);
        return node;
    }

}
