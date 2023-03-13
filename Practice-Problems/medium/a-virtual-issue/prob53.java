import java.util.*;


public class prob53
{
    public static void main(String[] args)
    {

        final double targetFrameTime = 1000.0/90.0;
        final double lowThreshHold = targetFrameTime * 0.70;
        final double ExtrapolateThreshHold = targetFrameTime * 0.85;
        final double highThreshHold = targetFrameTime * 0.9;

        try (Scanner input = new Scanner(System.in))
        {

            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                double frame0 = input.nextDouble();
                double frame1 = input.nextDouble();
                double frame2 = input.nextDouble();
                int quality = input.nextInt();

                double extrapolatedValue = 0;
                if (frame0+((3.0/2.0)*(frame2-frame0)) >  frame1+(2.0*(frame2-frame1))){
                    extrapolatedValue = frame0+(3.0/2.0)*(frame2-frame0);
                } else{
                    extrapolatedValue = frame1+(2.0*(frame2-frame1));
                }


                if (frame2 > highThreshHold){
                    quality -=2;
                } else 
                if (extrapolatedValue > highThreshHold && frame2>ExtrapolateThreshHold){
                    quality -=2;
                } else 
                if (frame0 < lowThreshHold && frame1 < lowThreshHold && frame2 < lowThreshHold){
                    quality++;
                }
                if (quality < 1){
                    quality =1;
                } 
                if (quality > 10){
                    quality = 10;
                }
                System.out.println(quality);
            }
        }
    }
}
