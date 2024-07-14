import java.util.Random;
import java.util.Scanner;

public class GuessingNumbers {
    private static String num1, num2, num3, num4;
    private static int A = 0, B = 0;
    private static  int gussCount = 0;
    private static boolean bg = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        beginGame(random);

        System.out.println("Please enter 4 digits:");
        while(true){
            String input = scanner.nextLine();
            if("exit".equals(input))
                break;
            if(input.length() == 4 && bg){
                String n1 = input.substring(0, 1);
                String n2 = input.substring(1, 2);
                String n3 = input.substring(2, 3);
                String n4 = input.substring(3, 4);

                if(n1.equals(n2) || n1.equals(n3) || n1.equals(n4)
                        || n2.equals(n3) || n2.equals(n4)
                        || n3.equals(n4)){
                    System.out.println("Please re-enter: (Number repetition cannot be entered)");
                    continue;
                }

                if(n1.equals("0")
                        || n2.equals("0") || n3.equals("0")
                        || n4.equals("0")){
                    System.out.println("Please re-enter: (Number 0 cannot be entered)");
                    continue;
                }

                if (n1.matches("[a-zA-Z]") || n2.matches("[a-zA-Z]")
                        || n3.matches("[a-zA-Z]") || n4.matches("[a-zA-Z]")) {
                    System.out.println("Please re-enter: (Letters cannot be entered)");
                    continue;
                }

                calculateAB(n1, n2, n3, n4);

                System.out.println("A: " + A + "\tB: " + B);
                gussCount++;
                if (A == 4) {
                    System.out.print("bingo！" + "\tgussCount:" +gussCount);
                    break;
                }
                A = 0;
                B = 0;
            }else{
                System.out.println("Please re-enter: (Number of 4 digits)");
            }
        }

    }

    public static void beginGame(Random random){
        num1 = (random.nextInt(9) + 1) + "";
        num2 = (random.nextInt(9) + 1) + "";
        while(num1.equals(num2))
            num2 = (random.nextInt(9) + 1) + "";
        num3 = (random.nextInt(9) + 1) + "";
        while(num1.equals(num2) || num1.equals(num3)
            || num2.equals(num3))
            num3 = (random.nextInt(9) + 1) + "";
        num4 = (random.nextInt(9) + 1) + "";
        while(num1.equals(num2) || num1.equals(num3)
            || num1.equals(num4) || num2.equals(num3)
            || num2.equals(num4) || num3.equals(num4))
            num4 = (random.nextInt(9) + 1) + "";
        System.out.println("答案：" + num1 + num2 + num3 + num4);
        bg = true;
    }

    public static void calculateAB(String n1, String n2, String n3, String n4) {
        // A
        if (n1.equals(num1)) A++;
        if (n2.equals(num2)) A++;
        if (n3.equals(num3)) A++;
        if (n4.equals(num4)) A++;

        // B
        if (n1.equals(num2) || n1.equals(num3) || n1.equals(num4)) B++;
        if (n2.equals(num1) || n2.equals(num3) || n2.equals(num4)) B++;
        if (n3.equals(num2) || n3.equals(num1) || n3.equals(num4)) B++;
        if (n4.equals(num2) || n4.equals(num3) || n4.equals(num1)) B++;
    }
}
