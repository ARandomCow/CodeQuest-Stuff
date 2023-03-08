import java.util.*;

public class prob3
{
    public static void main(String[] args)
    {

        try (Scanner input = new Scanner(System.in))
        {
            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                int correctNum = input.nextInt();
                int incorrectNum = input.nextInt();
                String ignore = input.nextLine();

                String[] corrects = new String[correctNum];
                String[] incorrects = new String[incorrectNum];
                int[] errors = new int[correctNum];

                for (int i =0; i< correctNum; i++){
                    corrects[i] = input.nextLine();
                }

                for (int i = 0; i<incorrectNum; i++){
                    incorrects[i] = input.nextLine(); 
                }

                for (String incorrect: incorrects){
                    int i = 0;
                    
                    for (String correct: corrects){
                        int count = 0;
                        if (correct.length() != incorrect.length()){
                            errors[i] = Integer.MAX_VALUE;
                            i++;
                            continue;
                        }
                        for (int letter = 0; letter<correct.length(); letter++){
                            if (correct.charAt(letter) != (incorrect.charAt(letter))){
                                count++;
                            }
                        }

                        errors[i] = count;
                        i++;
                    }
                    int index = minIndex(errors);
                    System.out.println(corrects[index]);
                }
            }
        }
    }
    public static int minIndex(int[] arr){
        int temp = arr[0];
        int index = 0;
        for (int i =0; i< arr.length; i++){
            if (temp > arr[i]){
                temp = arr[i];
                index = i;
            }
        }
        return index;
    }
}