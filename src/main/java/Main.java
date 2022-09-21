import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner keyb = new Scanner(System.in);
        String inputData = keyb.nextLine();
        keyb.close();

        System.out.println(calc(inputData));

    }

    /**
     * Method Main#calc(String input) calculates a user-entered math expression
     * @param input - math expression
     * @return - result
     */
    public static String calc(String input){

        Calculator calculator;
        String[] elemsOfMathOperation = input.toUpperCase().split(" ");

        if (elemsOfMathOperation.length != 3){
            throw new IllegalArgumentException("WARNING: The format of the mathematical operation does not satisfy the assignment - two operands and one operator (+, -, /, *)");
        }

        if (input.matches("^\\d+ [\\/|\\*|\\-|\\+] \\d+$")) {
            calculator = new DecimalCalculator();
        }else if (input.matches("^[M|D|C|L|X|V|I]+ [\\/|\\*|\\-|\\+] [M|D|C|L|X|V|I]+$")) {
            calculator = new RomanCalculator();
        } else {
            throw  new IllegalArgumentException("WARNING: Different number systems are used at the same time");
        }
        return calculator.calcExpression(elemsOfMathOperation[0], elemsOfMathOperation[1], elemsOfMathOperation[2]);
    }
}
