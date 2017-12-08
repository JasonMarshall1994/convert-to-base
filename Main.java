import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        System.out.println("BASE CONVERSION PROGRAM");

        Scanner in = new Scanner(System.in);
        Stack process = new Stack();

        int num;
        int quit = 0;

        while(quit != -1) {
            try {

                menu();
                num = in.nextInt();
                switch (num) {
                    case 1:
                        conversion(process);
                        break;
                    case 2:
                        quit = -1;
                        System.out.println("END OF BASE CONVERSION PROGRAM");
                        break;
                    default:
                        System.out.println("Please enter one of the choices.");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void menu(){
        System.out.print("\nPress 1 to start conversion \n" +
                         "Press 2 to quit \n");
    }

    private static void conversion(Stack process) throws Exception{
        Scanner in = new Scanner(System.in);
        int num = 0;
        int newBase = 0;
        int tmp;
        int stop = 0;
        int counter = 1;

        while(stop != -1){
            switch (counter){
                case 1:
                    System.out.print("Enter a number with base 10: ");
                    tmp = in.nextInt();
                    if(tmp <=0){
                        throw new Exception("The number must be greater than 0.");
                    }else{
                        num = tmp;
                    }
                    counter++;
                    break;
                case 2:
                    System.out.print("Enter the base you would like to convert to: ");
                    tmp = in.nextInt();
                    if(tmp < 2 || tmp > 9){
                        throw new Exception ("The new base must be between 2 and 9.");
                    }else{
                        newBase = tmp;
                    }
                    counter++;
                    break;
                case 3:
                    convert(num, newBase, process);
                case 4: stop = -1;
                    break;
            }
        }
    }

    private static void convert(int num, int newBase, Stack process){
        int orig = num;
        int remainder;
        do {
            remainder = num % newBase;
            num = num / newBase;

            process.push(remainder);
        } while (num != 0);

        System.out.println("\nYour original number in decimal notation was: " + orig);
        System.out.print("Your original number in base " + newBase + " is: ");

        while(process.size() > 0){
            System.out.print(process.pop());
        }
        System.out.println();
    }
}
