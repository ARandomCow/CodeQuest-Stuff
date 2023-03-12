import java.util.*;

public class prob114
{
    public static void main(String[] args)
    {



        try (Scanner input = new Scanner(System.in))
        {

            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                for (int i = 0; i<3; i++){
                    int num = input.nextInt();
                    if (num%2==0){
                        System.out.print(num+2);
                    } else{
                        System.out.print(num+1);
                    }
                    if (i!=2){
                        System.out.print(" ");
                    }
                }
                System.out.println("");


            }
        }
    }
}