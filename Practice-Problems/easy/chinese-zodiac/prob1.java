import java.util.*;

public class prob1
{
    public static void main(String[] args)
    {

        try (Scanner input = new Scanner(System.in))
        {
            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                int bYear = input.nextInt();
                System.out.print(bYear + " ");
                String yinYang = "";

                if (bYear % 2 == 0){
                    yinYang = "Yang";
                }else{
                    yinYang = "Yin";
                }

                System.out.print(yinYang + " ");
                int test = bYear;
                String element = "";
                test = (int) (((test-4)%10)/2);
                if (test ==0){
                    element = "Wood";
                } else
                if (test ==1){
                    element = "Fire";
                } else
                if (test ==2){
                    element = "Earth";
                } else
                if (test ==3){
                    element = "Metal";
                } else
                if (test ==4){
                    element = "Water";
                } 

                System.out.print(element + " ");

                test = bYear;
                test = ((test-4)%12);
                String animal = "";
                String[] animals = {"Rat", "Ox", "Tiger", "Rabbit", "Dragon", "Snake", "Horse", "Goat", "Monkey", "Rooster", "Dog", "Pig"};
                for (int i = 0; i<animals.length; i++){
                    if (test == i){
                        animal = animals[i];
                    }
                }
                System.out.print(animal);
                System.out.println("");
            }
        }
    }
}