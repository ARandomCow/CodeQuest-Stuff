import java.util.*;

public class prob44{

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int testCases = Integer.parseInt(input.nextLine());

        for (int i = 0; i < testCases; i++){
            int first = input.nextInt();
            int second = input.nextInt();

            System.out.print(first + second + " ");
            System.out.println(first * second);
        }
    }
}