import java.util.InputMismatchException;
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
        System.out.println("Type your amount (in EUR): ");
        try {
            amountIn = scanner.nextDouble();
        } catch (InputMismatchException e)
        {
            System.out.println("ERROR: Input number format is incorrect, try changing the decimal separator.");
            e.printStackTrace();
            return;
        }

        if (amountIn < 0)
        {
            System.out.println("ERROR: The minimal amount of money is 0.00!");
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
