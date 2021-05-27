import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        double amountIn, amountOut;
        String currency;

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nTarget currency code: ");
        currency = scanner.nextLine();
        System.out.println("Type your amount (in EUR) using comma as decimal separator: ");
        amountIn = scanner.nextDouble();

        Calculator calculator = new Calculator();
        amountOut = calculator.calculate(amountIn, currency);

        System.out.println("\n" + amountIn + " EUR = " + amountOut + ' ' + currency);
    }
}
