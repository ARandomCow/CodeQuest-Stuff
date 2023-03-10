import java.util.*;

public class prob95 
{
    public static void main(String[] args)
    {

        try (Scanner input = new Scanner(System.in))
        {
            int testCases = Integer.parseInt(input.nextLine());

            for(int testcase = 0; testcase < testCases; testcase++)
            {
                int values = input.nextInt();
                double[] nums = new double[values];

                for (int value = 0; value < values; value++)
                {
                    double num = input.nextDouble();
                    nums[value] = num;
                }
                double max = nums[maxIndex(nums)];
                double min = nums[minIndex(nums)];

                for (double num: nums){
                    int thing = (int) decRound((((num - min)/(max - min))*255), 0);
                    System.out.println(thing);
                }

            }
        }
    }

    public static int minIndex(double[] arr){
        double temp = arr[0];
        int index = 0;
        for (int i =0; i< arr.length; i++){
            if (temp > arr[i]){
                temp = arr[i];
                index = i;
            }
        }
        return index;
    }

    public static int maxIndex(double[] arr){
        double temp = arr[0];
        int index = 0;
        for (int i =0; i< arr.length; i++){
            if (temp < arr[i]){
                temp = arr[i];
                index = i;
            }
        }
        return index;
    }


    public static double decRound (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }


}