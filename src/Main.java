import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        byte MONTHS_IN_YEAR = 12;
        byte PERCENT = 100;
        int principal = 0;
        float interest = 0;
        float monthlyInterest = 0;
        int years = 0;
        int months = 0;

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        while(true) {
            System.out.print("Principal: ");
            principal = scanner.nextInt();
            if (principal > 1000 && principal <= 1000000)
                break;
            System.out.print("Please enter a number between 1,000 and 1,000,000 ");
        }

        while(true) {
            System.out.print("Annul Interest Rate: ");
            interest = scanner.nextFloat();
            if (interest > 0 & interest <= 30) {
                monthlyInterest = interest / MONTHS_IN_YEAR / PERCENT;
                break;
            }
            System.out.println("Please enter a value greater than 0 and less than 31");
        }

        while (true) {
            System.out.print("Period (Years): ");
            years = scanner.nextByte();
            if (years > 0 && years <=30) {
                months = years * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }
        double mortgage = principal
                * (monthlyInterest *(Math.pow((1 + monthlyInterest),months))) /
                ((Math.pow((1 + monthlyInterest),months)) - 1) ;

        String formatted = NumberFormat.getCurrencyInstance(Locale.US).format(mortgage);
        System.out.println("Mortgage: " + formatted);
    }
}