import java.util.Scanner;

public class bradySolution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int testCases = Integer.parseInt(input.nextLine());

        for (int i = 0; i<testCases; i++) {
            int first = input.nextInt();
            int second = input.nextInt();

            System.out.println(first + second + " " + first * second);
        }
    }
    
}
