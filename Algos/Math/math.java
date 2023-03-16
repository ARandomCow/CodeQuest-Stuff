package Algos.Math;

public class math {


    /**
     *
     * @param value number to be rounded
     * @param precision number of decimal places
     * @return rounded number according to params
     */
    public static double decRound (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }



    /*
    * @param num - double you want in a specified format
    * @param leading - number of digits before decimal place. Can be any number greater than or equal to 0
    * @param trailing - number of digits after decimal place. 
    * Should be as big as the number of digits in your largest number (if that's 999, then trailing should equal 3)
    * set trailing to 0 if you don't care about trailing zeros
    * @result a string of your number with the specified number of leading and trailing zeros
    */
    public static String trailingAndLeadingZeroes(double num, int trailing, int leading){
        int scale = (int) Math.pow(10, trailing);
        String result = String.valueOf((double) Math.round(num * scale) / scale);
        if (trailing == 0){
            result = result.substring(0, result.length()-2);
        } else 
        {
            while (result.length() - trailing< result.indexOf(".")+1){
                result += "0";
            }
        }
        while (leading> result.indexOf(".")){
            result = "0" + result;
        }
        return result;
    }



    /**
     *
     * @param n
     * @return n!
     */
    public static int factorial(int n){
        int result = n;
        for (int i = n-1; i>0; i--){
            result *= i;
        }
        return result;
    }


    public static String fraction(double decimal, double tolerance) {
        int sign = (decimal < 0.0) ? -1 : 1;
        decimal = Math.abs(decimal);

        if (decimal == (int) decimal) {
            return (sign * (int) decimal + "");
        }

        double res = decimal, num = 0.0, denom = 1.0, lastdenom = 0.0, temp;
        do {
            res = 1.0 / (res - (int) res);
            temp = denom;
            denom = denom * (int) res + lastdenom;
            lastdenom = temp;

            num = Math.round(decimal * denom);
        } while (res != (int) res && Math.abs(decimal - (num / denom)) > tolerance);

        return (sign * (int) num + "/" + (int) denom);
    }


/*
 * @param self explanatory
 * @result the largest number that divides the two integers
 */
    public static int greatestCommonFactor(int num1, int num2) {
        int larger = num2;
        int smaller = num1;
        if (num1 > num2){
            larger = num1;
            smaller = num2;
        }

        while (smaller != larger)
        {
//            System.out.println(larger+ "-" + smaller + "=" + (larger - smaller));
            int temp = larger - smaller;
            if (temp > smaller){
                larger = temp;
            } else {
                larger = smaller;
                smaller = temp;
            }
        }
        return larger;
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
