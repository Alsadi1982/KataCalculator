public class RomanCalculator implements Calculator{

    /**
     * Method RomanCalculator#calcExpression(String firstOperand, String sign, String secondOperand) evaluates an expression where both operands are Roman numerals
     * if one or both of the operands doesn't consist Roman numerals, method will throw IllegalArgumentException
     * if operands are less than I or greater than X, method will throw IllegalArgumentException
     * if the result of the operation is a negative number, method will throw ArithmeticException
     * @param firstOperand - first operand
     * @param operator - operator ('/', '*', '-', '+')
     * @param secondOperand - second operand
     * @return result of calculation
     */
    @Override
    public String calcExpression(String firstOperand, String operator, String secondOperand) {

        if (!firstOperand.matches("^[M|D|C|L|X|V|I]+$") || !secondOperand.matches("^[M|D|C|L|X|V|I]+$")){
            throw new IllegalArgumentException("WARNING: One or both of the operands doesn't consist of Roman numerals!");
        }

        int firstOperandToInt = RomanTOIntegerAndBackConverter.romanToInt(firstOperand);
        int secondOperandToInt = RomanTOIntegerAndBackConverter.romanToInt(secondOperand);

        if ((firstOperandToInt < 1 || firstOperandToInt > 10) || (secondOperandToInt < 1 || secondOperandToInt > 10)){
            throw new IllegalArgumentException("WARNING: The calculator must accept numbers from I to X inclusive!");
        }

        int result = calculate(firstOperandToInt, operator, secondOperandToInt);

        if (result < 1){
            throw new ArithmeticException("WARNING: There are no negative numbers in the Roman system!");
        }

        return RomanTOIntegerAndBackConverter.intToRoman(result);
    }
}