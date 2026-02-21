package newLearning.TwoPointer;

public class Problem_125 {

    public boolean isPalindrome(String s) {

        String finalString = "";
        for(Character c : s.toCharArray()){
            if(Character.isAlphabetic(c)){
                finalString = finalString.concat(Character.toString(c).toLowerCase());
            }else if(Character.isDigit(c)){
                finalString = finalString.concat(Character.toString(c));
            }
        }

        // System.out.println(finalString);

        int i = 0,j = finalString.length()-1;

        while(i < j){
            if(finalString.charAt(i) != finalString.charAt(j)){
                // System.out.println("i : "+finalString.charAt(i)+" j : "+finalString.charAt(j));
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
