package Trees.PathProblems;

import Trees.TreeNode;

public class SumRootToLeafNumbers_129 {

    int totalSum = 0;

    public int sumNumbers(TreeNode node) {
        dfs(node,"");
        return totalSum;
    }

    private void dfs(TreeNode node, String str) {
        if(node!=null){
            str = str.concat(String.valueOf(node.val));
            System.out.println("Before : "+str);
            if(node.left == null && node.right == null && !str.isEmpty()){
                totalSum+=Integer.parseInt(str);
            }
            dfs(node.left,str);
            dfs(node.right,str);
            str = str.substring(0,str.length()-1);
            System.out.println("After : "+str);
        }
    }

}
