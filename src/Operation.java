import Exceptions.*;

public class Operation {
    private Operand operand1;
    private Operand operand2;
    private String operator;
    private String result;
    private String[] arguments;

    public Operation(String[] strings) {
        arguments = strings;
    }

    public void checkArguments() throws IllegalOperationException, IllegalMembersNumberException, DifferentTypesOfDigitsException, IncorrectNumberException, NumberOutOfRangeException {
        if (arguments.length != 3) {
            throw new IllegalMembersNumberException();
        }
        if (!arguments[1].matches("[\\+\\-\\*\\/]")) {
            throw new IllegalOperationException();
        }
        operand1 = new Operand(arguments[0]);
        operand2 = new Operand(arguments[2]);
        operator = arguments[1];

        if (operand1.getType() != operand2.getType()) {
            throw new DifferentTypesOfDigitsException();
        }

        if ((operand1.getNumber() > 10) || (operand1.getNumber() < 0) || (operand2.getNumber() > 10) || (operand2.getNumber() < 0)) {
            throw new NumberOutOfRangeException();
        }
    }

    public String getResult() throws SomethingWentWrongException, RomanianHasNoZeroException {
        int res = 0;
        switch (operator) {
            case ("+"):
                res = operand1.getNumber() + operand2.getNumber();
                break;
            case ("-"):
                res = operand1.getNumber() - operand2.getNumber();
                break;
            case ("*"):
                res = operand1.getNumber() * operand2.getNumber();
                break;
            case ("/"):
                res = operand1.getNumber() / operand2.getNumber();
                break;
        }
        if (operand1.getType() == Operand.ARABIAN){
            result = Integer.toString(res);
        }else if(operand1.getType() == Operand.ROMANIAN){
            result = Converter.convertArabToRoman(res);
        }else{
            throw new SomethingWentWrongException();
        }
        return result;
    }
}
