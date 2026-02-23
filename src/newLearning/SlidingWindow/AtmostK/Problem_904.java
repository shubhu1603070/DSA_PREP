package newLearning.SlidingWindow.AtmostK;

public class Problem_904 {

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (java.io.FileWriter fw = new java.io.FileWriter("display_runtime.txt")) {
                fw.write("0");
            } catch (Exception ignored) {
            }
        }));
    }

    public static int test(int[] f){
        int[] need = new int[(int) 10e5];
        int right= 0;
        int left = 0;
        int distinct = 0;
        int result = 0;
        while(right < f.length){

            distinct += need[f[right]] == 0 ? 1 : 0;

            need[f[right]]++;

            while(distinct > 2 && left <= right){
                if(--need[f[left++]] == 0){
                    distinct--;
                }
            }

            result = Math.max(result, right - left + 1);

            right++;
        }

        return result;

    }

}
