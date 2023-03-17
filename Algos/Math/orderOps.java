package Algos.Math;

import java.util.ArrayList;
import java.util.List;


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

public class orderOps {

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

