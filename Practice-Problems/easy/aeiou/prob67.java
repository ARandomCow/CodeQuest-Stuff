import java.util.*;

public class prob67{

    public static boolean isVowel(String thing){
        String alph = "aeiou";
        boolean temp = false;
        for (int i = 0; i < thing.length(); i++){
            for (int y = 0; y < alph.length(); y++){
                if(thing.substring(i, i+1).equals(alph.substring(y, y+1))){
                    temp = true;
                }
            }
        }
        if (temp == true){
            return true;
        }
        return false;
    }

public static void main(String[] args)
    {
        try (Scanner input = new Scanner(System.in))
        {
            int testCases = Integer.parseInt(input.nextLine());

            for(int testcase = 0; testcase < testCases; testcase++)
            {
                int count = 0;
                String line = input.nextLine().toLowerCase();
                for (int index = 0; index < line.length(); index++){
                    if (isVowel(line.substring(index, index+1))){
                        count++;
                    }
                }
                System.out.println(count);

            }
        }
    }
}