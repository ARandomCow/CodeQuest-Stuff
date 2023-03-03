import java.util.*;

public class prob190{


    public static boolean isLetter(String thing){
        String alph = "qwertyuiopasdfghjklzxcvbnm1234567890";
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
            String convo;
            int index;
            String first;
            String last;
            boolean covered = true;
            boolean temp = false;


            for(int testcase = 0; testcase < testCases; testcase++) 
            {
                covered = true;

                convo = input.nextLine();
                index = convo.indexOf("|");
                first = convo.substring(0, index).toLowerCase();
                last = convo.substring(index+1, convo.length()).toLowerCase();



                for (int i = 0; i< last.length(); i++)
                {
                    temp = false;
                    for (int y = 0; y< first.length(); y++)
                    {
                        if (!(isLetter(last.substring(i, i+1)))){
                            temp = true;
                            break;
                        }
                        if (last.substring(i, i+1).equals(first.substring(y, y+1)))
                        {
                            temp = true;
                        }
                    }
                    if (temp == false)
                    {
                        covered = false;
                        System.out.println("You're not a secret agent!");
                        break;
                    }
                }
                if (covered == true)
                {
                    System.out.println("That's my secret contact!");
                }
            }
        }
    }
}