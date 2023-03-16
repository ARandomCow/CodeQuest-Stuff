import java.util.*;


public class prob197 {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for (int testcase = 0; testcase < testCases; testcase++) {
                double litres = input.nextDouble();
                int tankNum = input.nextInt();
                int notFullTanks = tankNum;
                double[] tankSizes = new double[tankNum];
                double[] fillTanks = new double[tankNum];
                boolean[] isFull = new boolean[tankNum];
                for (int t = 0; t < tankNum; t++) {
                    tankSizes[t] = input.nextDouble();
//                    System.out.println("tank " + t + "initialized");
                }
/*
what this algo does:

 */
                while(litres > 0.000001) {

                    double amountToGive = litres / notFullTanks;
                    for (int i = 0; i < tankNum; i++) {
                        double tank = tankSizes[i] - fillTanks[i];
                        if (amountToGive > tank && !isFull[i]) {
                            amountToGive = tank;
//                            System.out.println("amountToGive = " + amountToGive);
                        }
                    }
                    for (int i = 0; i < tankNum; i++) {
                        if (!isFull[i]) {
//                            System.out.println("filling tank");
//                            System.out.println("amountToGive = " + amountToGive);
                            fillTanks[i] += amountToGive;
//                            System.out.println(fillTanks[i]);
                            litres -= amountToGive;
                            if (fillTanks[i] == tankSizes[i]) {
                                isFull[i] = true;
                                notFullTanks--;
                            }
                        }
                    }


                }
                for (int i = 0; i < fillTanks.length; i++) {
                    double tank = fillTanks[i];
//                    System.out.print(tank);
                    System.out.print(fraction(tank, 0.00001));
                    if (i != fillTanks.length - 1) {
                        System.out.print(" ");
                    }
                }
                System.out.println("");
            }
        }
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


}
