public interface Calculator {

    String calcExpression (String firstOperand, String sign, String secondOperand);

    /**
     * Method Calculator#calculate(int firstOperand, String sign, int secondOperand) evaluates the expression
     * if the sign does not match '-', '/', '*', '+', method will throw IllegalArgumentException
     * @param firstOperand - first operand
     * @param operator - operator ('/', '*', '-', '+')
     * @param secondOperand - second operand
     * @return result of calculation
     */
    default int calculate (int firstOperand, String operator, int secondOperand){

        if (!operator.matches("[\\/|\\*|\\-|\\+]")){
            throw new IllegalArgumentException("Wrong type of operator! It must be \'*\', \'/\', \'+\', \'-\'");
        }

        int result = 0;

        switch (operator){
            case "+": result = firstOperand + secondOperand;
                      break;
            case "-": result = firstOperand - secondOperand;
                      break;
            case "*": result = firstOperand * secondOperand;
                      break;
            case "/": result = firstOperand / secondOperand;
        }

        return result;
    }
}
