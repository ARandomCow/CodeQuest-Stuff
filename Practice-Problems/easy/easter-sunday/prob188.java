import java.util.*;

public class prob188 
{
    public static void main(String[] args)
    {

        try (Scanner input = new Scanner(System.in))
        {

            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                double year = Double.parseDouble(input.nextLine());
                int a = (int) year%19;
                int b = (int) year%4;
                int c = (int) year%7;
                int k = (int) (year/100);
                int p = (int) (((13) + (8*k))/25);
                int q = (int)  k/4;
                int m = (15-p+k-q)%30;
                int n = (4+k-q)%7;
                int d = ((19*a) + m)%30;
                int e = ((2*b) + (4*c) + (6*d) + n)%7;
                int f = ((11*m) + 11)%30;

                int date = 22 + d + e;
                String month = "03";

                if (date>31){
                    date -= 31;
                    month = "04";
                }

                if ((month.equals("04")) && (date==25) && (d==28) && (e==6) && (f<19)){
                    date = 18;
                }
                if ((month.equals("04")) && (date==26) && (d==29) && (e==6)){
                    date = 19;
                }

                String yearThing = String.valueOf(year);
                String yearString = yearThing.substring(0, yearThing.length()-2);
                String dateString = String.valueOf(date);
                if (date< 10){
                    dateString = "0" + String.valueOf(date);
                }
                System.out.println(yearString + "/" + month + "/" + dateString);
            }
        }
    }
}