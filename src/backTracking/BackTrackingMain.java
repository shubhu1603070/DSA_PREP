package backTracking;

public class BackTrackingMain {

    public static void main(String[] args) {
        CombinationSumIV_377 cms = new CombinationSumIV_377();
//        int size1 = cms.combinationSum4(new int[]{1,2,3}, 4);
//        System.out.println("Size1 : "+size1);
//        int size = cms.combinationSum4(new int[]{3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25}, 10);
//        System.out.println("Size : "+size);
//        int dfs1 = cms.dfs1(new int[]{3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25}, 10);
        int dfs1 = cms.dfs1(new int[]{2,1,3}, 35);
        System.out.println(dfs1);
    }

}
