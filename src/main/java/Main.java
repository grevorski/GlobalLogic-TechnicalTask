import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args){

    Solution solution = new Solution();


        System.out.println("enter the letters you are looking for");
        String uniqueCharactersToLookFor = sc.nextLine();

        System.out.println("enter input text");
        String s = sc.nextLine();

        // String s = "I love to work in global logic!";
        //String s = "level plate";

    solution.solution(s,uniqueCharactersToLookFor);

    }


}
