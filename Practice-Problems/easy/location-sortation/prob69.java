import java.util.*;
import java.util.stream.Stream;

public class prob69 
{
    public static void main(String[] args)
    {

        try (Scanner input = new Scanner(System.in))
        {

            int testCases = Integer.parseInt(input.nextLine());
            String[] countries = new String[testCases];

            for(int testcase = 0; testcase < testCases; testcase++)
            {
                
                String line = input.nextLine();
                countries[testcase] = line;

                


            }

            countries = Stream.of(countries)
            .sorted()
            .toArray(String[]::new);

            for (String country: countries){
                System.out.println(country);
            }
        }
    }
}