import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Project {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);

        System.out.print("Principal: ");
        double principal = sn.nextDouble();

        System.out.print("Anual interest rate: ");
        double interestRate = sn.nextDouble();

        System.out.print("Period (Years): ");
        double period = sn.nextDouble();

        interestRate /= 100.0 * 12;
        period *= 12;
        double mortage = principal * interestRate * Math.pow(1 + interestRate, period)
                / (Math.pow(1 + interestRate, period) - 1);
        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.FRANCE);

        System.out.println(currency.format(mortage));

        sn.close();

    }
}
