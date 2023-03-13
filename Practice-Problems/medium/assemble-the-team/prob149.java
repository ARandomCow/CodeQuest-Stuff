import java.util.*;
import java.util.stream.Stream;

public class prob149
{
    public static void main(String[] args)
    {



        try (Scanner input = new Scanner(System.in))
        {

            int testCases = Integer.parseInt(input.nextLine());


            for(int testcase = 0; testcase < testCases; testcase++)
            {
                String line = input.nextLine();
                String[] agents = Delimiters.delimitAllStrings(line, " ");
                char[] names = new char[agents.length];
                int[] scores = new int[agents.length];
                for (int i = 0; i< names.length; i++){
                    names[i] = agents[i].charAt(0);
                    scores[i] = Integer.parseInt(Delimiters.delimit(agents[i], "=", agents[i].length()));
                }
                
                // sorting algo
                for (int i = 0; i< scores.length; i++){
                    int tempNum = 0;
                    char tempName = 'a';
                    for (int y = i; y<scores.length; y++){
                        if (scores[y] < scores[i]){
                            tempNum = scores[y];
                            tempName = names[y];
                            scores[y] = scores[i];
                            names[y] = names[i];
                            scores[i] = tempNum;
                            names[i] = tempName;
                        }
                    }
                }
//              finds all the largest team sizes with score intervals less than 10
                List<int[]> bestTeams = new ArrayList<int[]>();
                List<Integer> startIndexes = new ArrayList<Integer>();
                List<char[]> bestTeamsNames = new ArrayList<char[]>();

                for (int i = 0; i<scores.length; i++)
                {
                    int[] team = numsInAnInterval(scores, i, 10);
                    if (bestTeams.size() == 0){
                        bestTeams.add(team);
                        startIndexes.add(i);
                        bestTeamsNames.add(Arrays.copyOfRange(names, i, team.length+i));
                    } else
                    if(team.length >= bestTeams.get(0).length){
                        bestTeams.add(team);
                        startIndexes.add(i);
                        bestTeamsNames.add(Arrays.copyOfRange(names, i, team.length+i));
                    }
                    while (bestTeams.get(0).length < team.length){
                        bestTeams.remove(0);
                        startIndexes.remove(0);
                        bestTeamsNames.remove(0);
                    }

                }
//              I officially have all the best teams, now I need to find the 1 best team based off of alphabetical bs
/* */
                for (int i = 0; i< bestTeamsNames.size(); i++){
                    Arrays.sort(bestTeamsNames.get(i));
                }

                char[] winner = (bestTeamsNames.get(0));
                
                if (bestTeamsNames.size() == 1){
                    printStringArr(winner, " ");
                } else 
                {
                    for (int i = 1; i< bestTeamsNames.size(); i++){
                        char[] competitor = (bestTeamsNames.get(i));
                        int winnerName = 0;
                        for (char name: competitor){
                            if ((int) name < (int) winner[winnerName]){
                            winner = competitor;
                            break;
                            } else if ((int) name > (int) winner[winnerName]){
                                break;
                            }
                            winnerName++;
                        }
                    }
                    printStringArr(winner, " ");
                }
            }
        }
    }



    public static String[] alphOrder(String[] stringArray){
        String[] str = Stream.of(stringArray)
        .sorted()
        .toArray(String[]::new);

        return str;
    }

    public static void printStringArr(char[] arr, String spacer){
        for (int i = 0; i< arr.length; i++){
            System.out.print(arr[i]);
            if (i!= arr.length-1){
                System.out.print(spacer);
            }
        }
        System.out.println("");
    }



    public static int[] numsInAnInterval(int[] intArray, int startIndex, int interval){
        int lastIndex = startIndex;
        while (intArray[lastIndex] <= intArray[startIndex]+interval){
            if (lastIndex == intArray.length-1){
                return Arrays.copyOfRange(intArray, startIndex, intArray.length);
            }
            lastIndex++;
        }
        return Arrays.copyOfRange(intArray, startIndex, lastIndex);
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
