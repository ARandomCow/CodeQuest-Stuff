import java.util.*;

public class prob119 {
    public static void main(String[] args) {


        try (Scanner input = new Scanner(System.in)) {

            int testCases = Integer.parseInt(input.nextLine());


            for (int testcase = 0; testcase < testCases; testcase++) {
		String line = input.nextLine();
		String[] equationStuff = Delimiters.delimitAllStrings(line, " ");
		List<Integer> numbers = new ArrayList<Integer>();
		List<String> operators = new ArrayList<String>();
		numbers.add(Integer.parseInt(equationStuff[0]));
		numbers.add(Integer.parseInt(equationStuff[2]));
		operators.add(equationStuff[1]);
        orderOps equation = new orderOps(numbers, operators);
        double solution = equation.solve();
        System.out.print(trailingAndLeadingZeroes(solution, 1, 0) + " ");
        numbers.set(0, Integer.parseInt(equationStuff[2]));
        numbers.set(1, Integer.parseInt(equationStuff[0]));
//		wow vim sucks
        equation = new orderOps(numbers, operators);
        solution = equation.solve();
        System.out.println(trailingAndLeadingZeroes(solution, 1, 0));
            }
        }
    }

    /**
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
     * @param numbers - a list of your doubles that you want in the equation
     * @param operators - a list of your operators as strings ("+", "-", "/", "*")
     * @result - whatever the answer to that thing if you iterate through the ints and strings in order
     * example: nums = {2, 5, 3}, ops = {*, -}, result = 2 * 5 - 3 solved using order of operations
     * WARNING: it'll probably break if you don't have exactly 1 less operator than number
     *
     * how to use
     *
     * orderOps equation = new orderOps(numbers, operators);
     * double solution = equation.solve();
     */

    public static class orderOps {

        int opIndex = 0;
        double result = 0.0;
        List<Double> nums = new ArrayList<Double>();
        List<String> ops = new ArrayList<String>();

        public orderOps(List<Integer> nums, List<String> ops)
        {
            for (Integer thing: nums){
                this.nums.add(Double.valueOf(thing));
            }
//            nums = new ArrayList<>(nums);
            this.ops = ops;
        }


        public double solve()
        {
            while (ops.size() > 0){
                orderOfOperations(nums, ops);
            }
            return result;
        }


        private void orderOfOperations(List<Double> numbers, List<String> operators)
        {
            nums = new ArrayList<>(numbers);
            ops = new ArrayList<>(operators);
            if (ops.indexOf("/") > ops.indexOf("*"))
            {
                opIndex = ops.indexOf("/");

                result = nums.get(opIndex) / nums.get(opIndex+1);
//                System.out.println(nums.get(opIndex) + " / " + nums.get(opIndex+1) + " = " + result);
                nums.set(opIndex, result);
                nums.remove(opIndex+1);
                ops.remove(opIndex);
            } else
            if (ops.indexOf("/") < ops.indexOf("*"))
            {
                opIndex = ops.indexOf("*");

                result = nums.get(opIndex) * nums.get(opIndex+1);
//                System.out.println(nums.get(opIndex) + " * " + nums.get(opIndex+1) + " = " + result);
                nums.set(opIndex, result);
                nums.remove(opIndex+1);
                ops.remove(opIndex);
            } else
            if (ops.indexOf("+") < ops.indexOf("-"))
            {

                opIndex = ops.indexOf("-");

                result = nums.get(opIndex) - nums.get(opIndex+1);
//                System.out.println(nums.get(opIndex) + " - " + nums.get(opIndex+1) + " = " + result);
                nums.set(opIndex, result);
                nums.remove(opIndex+1);
                ops.remove(opIndex);
            } else
            {
                opIndex = ops.indexOf("+");

                result = nums.get(opIndex) + nums.get(opIndex+1);
//                System.out.println(nums.get(opIndex) + " + " + nums.get(opIndex+1) + " = " + result);
                nums.set(opIndex, result);
                nums.remove(opIndex+1);
                ops.remove(opIndex);
            }

        }
    }



    public static class Delimiters {


    /*
    returns whatever is in between the start and end (can use either delimiter strings or indexes)
    */

    public static String delimit(String string, String start, String end){
        int startIndex = string.indexOf(start);
        int endIndex = string.indexOf(end);
        return string.substring(startIndex+1, endIndex);
    }

    public static String delimit(String string, int startIndex, String end){
        int endIndex = string.indexOf(end);
        return string.substring(startIndex, endIndex);
    }

    public static String delimit(String string, String start, int endIndex){
        int startIndex = string.indexOf(start);
        return string.substring(startIndex+1, endIndex);
    }

    /*
returns all the things separated by a space but the string probably has to be of a certain format
string cannot have a delimiter at the very beginning or very end (i think)
for example:
B1,B2,BB,K returns ["B1", "B2", "BB", "K"] and all is good
if it looks like ,B1,B2, then youre probably not as happy

change it from int[] to String or whatever just by getting rid of all the parseInts and making resultList List<String> and resultArray String[].
*/
    public static int[] delimitAllInts(String line, String spacer){
        List<Integer> resultList = new ArrayList<Integer>();

        while(line.contains(spacer)){
            resultList.add(Integer.parseInt(delimit(line, 0, spacer)));
            line = line.substring(line.indexOf(spacer)+spacer.length());
        }
        resultList.add(Integer.parseInt(line));

        int[] resultArray = new int[resultList.size()];
        int i = 0;
        for (Integer result: resultList){
            resultArray[i] = result;
            i++;
        }
        return resultArray;
    }


    public static String[] delimitAllStrings(String line, String spacer){
        List<String> resultList = new ArrayList<String>();

        while(line.contains(spacer)){
            resultList.add(delimit(line, 0, spacer));
            line = line.substring(line.indexOf(spacer)+spacer.length());
        }
        resultList.add(line);

        String[] resultArray = new String[resultList.size()];
        int i = 0;
        for (String result: resultList){
            resultArray[i] = result;
            i++;
        }
        return resultArray;
    }
}

}
