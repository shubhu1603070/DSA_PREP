package backTracking;


import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII_216 {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(1,k,n,new ArrayList<Integer>());
        return res;
    }

    private void dfs(int start,int k, int n, ArrayList<Integer> list) {
        if(list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int index = start;index<=9;index++){
            list.add(index);
            dfs(index+1,k,n-index,list);
            list.remove(list.size()-1);
        }
    }

}
