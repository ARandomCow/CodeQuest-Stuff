import java.util.*;

public class prob1
{
    public static void main(String[] args)
    {



        try (Scanner input = new Scanner(System.in))
        {

            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                String School = input.nextLine();
                int kids = Integer.parseInt(input.nextLine());
                String[] kidNames = new String[kids];
                double[] kidGPAS = new double[kids];
                int[] kidCredits = new int[kids];

                for (int k = 0; k<kids; k++){
                    int gradePoints = 0;
                    int creditHours = 0;
                    String line = input.nextLine();
                    kidNames[k] = Delimiters.delimit(line, 0, ":");

                    line = line.substring(line.indexOf(":")+1);

                    String[] kidGrades = Delimiters.delimitAllStrings(line, ",");

                    for (String grade: kidGrades){
                        creditHours += Integer.parseInt(grade.substring(grade.length()-1));
                        if (grade.charAt(0) == 'A'){
                            gradePoints += 4 * Integer.parseInt(grade.substring(grade.length()-1));
                        } else
                        if (grade.charAt(0) == 'B'){
                            gradePoints += 3 * Integer.parseInt(grade.substring(grade.length()-1));
                        } else
                        if (grade.charAt(0) == 'C'){
                            gradePoints += 2 * Integer.parseInt(grade.substring(grade.length()-1));
                        } else
                        if (grade.charAt(0) == 'D'){
                            gradePoints += 1 * Integer.parseInt(grade.substring(grade.length()-1));
                        }
                        
                    }
                    kidCredits[k] = creditHours;
                    kidGPAS[k] = (double)gradePoints/(double)creditHours;
//                    System.out.print(creditHours);
//                    System.out.println(" | " + gradePoints);
                }
                int max = maxIndex(kidGPAS);
                int temp = 0;
                double maxGPA = kidGPAS[max];
                int maxCredits = kidCredits[max];
                List<Double> gpaList = new ArrayList<Double>();
                for (double gpa: kidGPAS){
                    gpaList.add(gpa);
                }
                
                while (gpaList.contains(maxGPA)){
                    temp = gpaList.indexOf(maxGPA);
                    if (kidCredits[temp]> maxCredits){
                        maxCredits = kidCredits[temp];
                        max = temp;
                    }
                    gpaList.remove(temp);
                }
                String valedictorian = kidNames[max];
                System.out.println(School + " = " + valedictorian);

            }
        }
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