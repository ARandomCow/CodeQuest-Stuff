import java.util.*;


public class prob56{

    public static int factorial(int n){
        int result = n;
        for (int i = n-1; i>0; i--){
            result *= i;
        }
        return result;
    }

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

    public static Integer minNum(Integer num1, Integer num2){
        if (num1 < num2){
            return num1;
        } else {
            return num2;
        }
    }

    public static class intListAlgos {
        int number;
        Integer[][] allPerms;
        int size;

        public intListAlgos(int size){
            allPerms = new Integer[factorial(size)][];
            this.size = size;
            number = 0;
        }
        // Generates all permutations -- EXAMPLE IN listAlgoTesting.java
        public void permutations(List<Integer> items, List<Integer> permutation) {

            /* permutation stack has become equal to size that we require */
            if(permutation.size() == size) {
                /* print the permutation */
//                System.out.println(Arrays.toString(permutation.toArray(new Integer[0])));
                allPerms[number] = permutation.toArray(new Integer[0]);
                number++;
            }

            /* items available for permutation */
            Integer[] availableItems = items.toArray(new Integer[0]);
            for(Integer i : availableItems) {
                /* add current item */
                permutation.add(i);

                /* remove item from available item set */
                items.remove(i);

                /* pass it on for next permutation */
                permutations(items, permutation);

                /* pop and put the removed item back */
                items.add(permutation.remove(permutation.size()-1));
            }
        }

        public Integer[][] getAllPerms(){
            return allPerms;
        }

    }


    public static class stringListAlgos {
        int number;
        String[][] allPerms;
        int size;

        public stringListAlgos(int size){
            this.size = size;
            allPerms = new String[factorial(size)][];
        }
        // Generates all permutations -- EXAMPLE IN listAlgoTesting.java
        public void permutations(List<String> items, List<String> permutation) {

            /* permutation stack has become equal to size that we require */
            if(permutation.size() == size) {
                /* print the permutation */
//                System.out.println(Arrays.toString(permutation.toArray(new String[0])));
                allPerms[number] = permutation.toArray(new String[0]);
                number++;
            }

            /* items available for permutation */
            String[] availableItems = items.toArray(new String[0]);
            for(String s : availableItems) {
                /* add current item */
                permutation.add(s);

                /* remove item from available item set */
                items.remove(s);

                /* pass it on for next permutation */
                permutations(items, permutation);

                /* pop and put the removed item back */
                items.add(permutation.remove(permutation.size() - 1));
            }
        }

        public String[][] getAllPerms(){
            return allPerms;
        }
    }

    public static class orderOps
    {
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


        public void orderOfOperations(List<Double> mums, List<String> bops)
        {
            nums = new ArrayList<>(mums);
            ops = new ArrayList<>(bops);
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


    public static class delimiters
    {
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
    }
    public static void main(String[] args)
    {
        try (Scanner input = new Scanner(System.in))
        {
            int testCases = Integer.parseInt(input.nextLine());

            for(int testcase = 0; testcase < testCases; testcase++)
            {

                ArrayList<String> stuff = new ArrayList<String>();
                String line = input.nextLine();
                int result = Integer.parseInt(delimiters.delimit(line, 0, ":"));

                stuff.add(delimiters.delimit(line, ":", " "));
                line = line.substring(line.indexOf(" ")+1, line.length());

                while(line.indexOf(" ") != -1){
                    stuff.add(delimiters.delimit(line, 0, " "));
                    line = line.substring(line.indexOf(" ")+1, line.length());
                }
                stuff.add(line);
/*
                for (int i = 0; i<stuff.size(); i++){
                    System.out.print(stuff.get(i) + " | ");
                }
/* */

                int[] ints = new int[(stuff.size()/2) +1];
                String[] operators = new String[stuff.size()/2];
                int intsLength = 0;
                int operatorsLength = 0;
                for (String thing : stuff){
                    if (isLetter(thing)){
                        ints[intsLength] = Integer.parseInt(thing);
                        intsLength++;
                    }
                }

                for (String thing : stuff){
                    if (!isLetter(thing)){
                        operators[operatorsLength] = thing;
                        operatorsLength++;
                    }
                }
/*
                for (int i =0; i<ints.length; i++){
                    System.out.println(ints[i] + " | ");
                }

                for (int y = 0; y< operators.length; y++){
                    System.out.println(operators[y]);
                }
/* */

                List<Integer> intsList = new ArrayList<Integer>();
                List<String> stringList = new ArrayList<String>();

                for(int element: ints){
                    intsList.add(element);
                }

                for(String element: operators){
                    stringList.add(element);
                }
/*
                for (int i =0; i<intsList.size(); i++){
                    System.out.println(intsList.get(i) + " | ");
                }

                for (int y = 0; y< stringList.size(); y++){
                    System.out.println(stringList.get(y));
                }
/* */
                intListAlgos intPerms = new intListAlgos(intsList.size());
                stringListAlgos stringPerms = new stringListAlgos(stringList.size());

                intPerms.permutations(intsList, new ArrayList<Integer>());
                stringPerms.permutations(stringList, new ArrayList<String>());

                Integer[][] allIntPerms = intPerms.getAllPerms();
                String[][] allStringPerms = stringPerms.getAllPerms();

/*
                for (Integer[] intPerm: allIntPerms){
                    for (Integer item: intPerm){
                        System.out.print(item + " | ");
                    }
                    System.out.println("");
                }
/* */


                boolean isGood = false;

                for (Integer[] intPerm: allIntPerms){
                    for(String[] stringPerm: allStringPerms){

                        List<Integer> intPermList = Arrays.asList(intPerm);
                        List<String> stringPermList = Arrays.asList(stringPerm);

                        orderOps equation = new orderOps(intPermList, stringPermList);
                        if (equation.solve() == result){
/* 
                            for (int i = 0; i< intPerm.length-1; i++){
                                System.out.print(intPerm[i] + " " + stringPerm[i] + " ");
                            }
                            System.out.print(intPerm[intPerm.length-1] + " = " +  equation.solve() + " = " + result);            
                            System.out.println("");
/* */

                              isGood = true;
                      }
                        //move the shit around to make it a string in the form
                        // 4 * 3 / 2 or whatever
                        //and the make a function that interprets the string into actual math
                        //USING ORDER OF OPERATIONS
                        //and check if it yields the result, and if so, isGood= true.
                    }
                }

                if (isGood){
                    System.out.println("TRUE");
                } else{
                    System.out.println("FALSE");
                }
            }
        }
    }
}
