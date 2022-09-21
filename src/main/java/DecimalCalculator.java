public class DecimalCalculator implements Calculator{

    /**
     * Method DecimalCalculator#calcExpression(String firstOperand, String sign, String secondOperand) evaluates an expression where both operands are decimal integers
     * if one or both of the operands doesn't consist decimal numerals, method will throw IllegalArgumentException
     * if operands are less than 1 or greater than 10, method will throw IllegalArgumentException
     * @param firstOperand - first operand
     * @param operator - operator ('/', '*', '-', '+')
     * @param secondOperand - second operand
     * @return result of calculation
     */
    @Override
    public String calcExpression (String firstOperand, String operator, String secondOperand){


        if (!firstOperand.matches("^\\d+$") || !secondOperand.matches("^\\d+$")){
            throw new IllegalArgumentException("WARNING: One or both of the operands doesn't consist of decimal numerals or they are floating point numbers!");
        }

        int firstOperandToInt = Integer.parseInt(firstOperand);
        int secondOperandToInt = Integer.parseInt(secondOperand);

        if ((firstOperandToInt < 1 || firstOperandToInt > 10) || (secondOperandToInt < 1 || secondOperandToInt > 10)){
            throw new IllegalArgumentException("WARNING: The calculator must accept numbers from 1 to 10 inclusive!");
        }
        return Integer.toString(calculate(firstOperandToInt, operator, secondOperandToInt));
    }
}
