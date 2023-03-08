import java.util.*;

public class prob99{

    public static void main(String[] args)
    {
        try (Scanner input = new Scanner(System.in))
        {
            int testCases = Integer.parseInt(input.nextLine());

            for(int testcase = 0; testcase < testCases; testcase++) 
            {
                int bits = input.nextInt();
                int num = (int) (Math.pow(2, bits) - 1);

                int bit = 0;

                for (int i = 0; i<=num; i++){
                    int[] bitsArray = new int[bits];
                    int number = i;
                    bit = 0;
                    while (number > 0)
                    {

                        // storing remainder in binary array
                        bitsArray[bit] = number % 2;
                        number /= 2;
                        bit++;
                    }

                    for(int y = bits-1; y>=0; y--){
                        System.out.print(bitsArray[y]);   
                    }
                    System.out.println("");
                }
            }
        }
    }
}