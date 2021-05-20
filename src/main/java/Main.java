import java.io.IOException;
import java.util.*;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final FileInputAndOutput fileInputAndOutput = new FileInputAndOutput();
    public static void main(String[] args) throws IOException {

    Solution solution = new Solution();

        System.out.println("do you want to pass input as a file? press 1 if yes, press 2 if no");
        String i = sc.nextLine();
        String uniqueCharactersToLookFor;
        switch(i){
            case "1":

                System.out.println("enter the path to the file:");
                String path = sc.nextLine();
                String fileInput = fileInputAndOutput.readInput(path);
                System.out.println("enter the letters you are looking for:");
                uniqueCharactersToLookFor = sc.nextLine();

                String result = solution.solution(fileInput,uniqueCharactersToLookFor);
                System.out.println(result);
                System.out.println("Do you want to save result to the output.txt? press 1 if yes, press 2 if no");
                String string = sc.nextLine();
                switch(string){
                    case "1":
                        fileInputAndOutput.writeOutput(result);
                        System.out.println("File saved");
                        break;
                    case "2":
                        break;
                }
                break;

            case "2":
                System.out.println("enter input text:\n");
                String s = sc.nextLine();
                System.out.print("enter the letters you are looking for:\n");
                uniqueCharactersToLookFor = sc.next();
                String result1 = solution.solution(s,uniqueCharactersToLookFor);
                System.out.println(result1);
                String string1 = sc.nextLine();
                switch(string1){
                    case "1":
                        fileInputAndOutput.writeOutput(solution.solution(s,result1));
                        System.out.println("File saved");
                        break;
                    case "2":
                        break;
                }
                break;
            default:
                System.out.println("Wrong option choice");

        }








    }


}
