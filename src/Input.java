import java.util.Scanner;

public class Input {
    static final String naturalIntFailMess = "Proszę wpisać prawidłową liczbę naturalną";
    static final String numberTooBigMess = "Podano za dużą liczbę";

    static Scanner in = new Scanner(System.in);

    public static int ReadPositiveInt(String message, int maxValue) {
        System.out.print(message);

        int value = 0;
        while(value <= 0) {
            while(!in.hasNextInt()) {
                System.out.println(naturalIntFailMess);
                in.nextLine();
            }
            value = in.nextInt();
            if(value <= 0){ 
                System.out.println(naturalIntFailMess);
                in.nextLine();
            }
            if(value > maxValue) {
                value = 0;
                System.out.println(numberTooBigMess); 
                in.nextLine();
            }
        }

        return value;
    }
}
