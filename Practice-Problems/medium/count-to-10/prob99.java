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


                for (int i = 0; i<=num; i++){
                    String binaryNum = toBits(i, bits);

                    System.out.println(binaryNum);
                }
            }
        }
    }
/*
 * @param num - number you want converted to binary
 * @param bits - number of bits you want your binary number to have (important for trailing zeroes)
 * make sure you have enough bits for your number (for n bits, num < 2^n)
 * @result binaryNum - a string of 1's and 0's representing num in binary
 */
    public static String toBits(int num, int bits)
    {
        int bit = 0;
        int[]bitsArray = new int[bits];
        String binaryNum = "";
        while (num > 0)
        {
            // storing remainder in binary array
            bitsArray[bit] = num % 2;
            num /= 2;
            bit++;
        }
        for(int y = bits-1; y>=0; y--){
            binaryNum += bitsArray[y];   
        }
        return binaryNum;
    }
}