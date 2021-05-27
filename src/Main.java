import java.util.Locale;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        double amountIn, amountOut;
        String currency;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Target currency code: ");
        currency = scanner.nextLine();
        System.out.println("Type your amount (in EUR) using comma as decimal separator: ");
        amountIn = scanner.nextDouble();

        if (amountIn < 0)
        {
            System.out.println("The minimal amount of money is 0.00!");
            return;
        }

        Calculator calculator = new Calculator();
        amountOut = calculator.calculate(amountIn, currency);

        if (amountOut >= 0)
        {
            String result = "\n" + amountIn + " EUR = " + amountOut + ' ' + currency;
            System.out.println(result.toUpperCase(Locale.ROOT));
        }
    }
}
