import Exceptions.IncorrectNumberException;

public class Operand {
    public static final int ROMANIAN = 1;
    public static final int ARABIAN = 2;
    private int number;
    private int type;
    private String inArg;

    public Operand(String arg) throws IncorrectNumberException {
        inArg = arg;
        convertArgument();
    }

    private void convertArgument() throws IncorrectNumberException {
        if (Converter.isRomanianNumber(inArg)) {
            number = Converter.convertRomanToArab(inArg);
            type = ROMANIAN;
        } else if (Converter.isCorrectArabianNumber(inArg)) {
            number = Integer.parseInt(inArg);
            type = ARABIAN;
        } else {
            throw new IncorrectNumberException();
        }
    }

    public int getNumber() {
        return number;
    }

    public int getType() {
        return type;
    }

}
