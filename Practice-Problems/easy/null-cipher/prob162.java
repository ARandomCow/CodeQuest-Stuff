import java.util.*;

public class prob162
{
    public static void main(String[] args)
    {



        try (Scanner input = new Scanner(System.in))
        {

            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                String line = input.nextLine().toLowerCase();
                int i = 0;
                while(i < line.length()){
                    if(isVowel(String.valueOf(line.charAt(i)))){
                        System.out.print(String.valueOf(line.charAt(i+1)));
                        i+=2;
                    } else{
                        i++;
                    }
                }
                System.out.println("");
            }
        }
    }


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
}