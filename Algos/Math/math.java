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


    /**
     *
     * @param value number to be rounded (String)
     * @param precision number of decimal places
     * @return rounded number according to params (with trailing zeros) (String)
     */
    private static String decRoundString (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        String thing = String.valueOf((double) Math.round(value * scale) / scale);
        if (!thing.contains(".")){
            return thing;
        } else
        if (thing.indexOf(".") < thing.length()+precision){

            while (thing.length() - precision < thing.indexOf(".")+1){
                thing += "0";
            }
        }
        return thing;
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


}
