package newLearning.SlidingWindow.AtmostK;

public class Problem_2024 {

    public static int template(String s,int k,char ch){

        int[] need = new int[2];

        int right = 0;
        int left = 0;
        int n = s.length();
        int idx = 0;
        int maxFreq = 0;
        int result = 0;
        while(right <  n){
            idx = s.charAt(right) == ch ? 1 : 0;
            need[idx]++;
            maxFreq = Math.max(maxFreq, need[idx]);
            while((right - left + 1) - maxFreq > k && left <= right){
                idx = s.charAt(left) == ch ? 1 : 0;
                need[idx]--;
                left++;
            }
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }

}
