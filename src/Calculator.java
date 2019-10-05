import Exceptions.*;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in;
        while (!(in = sc.nextLine()).equals("")) {
            String[] str = in.split("\\s");
            Operation operation = new Operation(str);
            try {
                operation.checkArguments();
                System.out.println(operation.getResult());
            } catch (IllegalMembersNumberException e) {
                System.out.println("Enter correct number of members");
            } catch (IllegalOperationException e) {
                System.out.println("Enter correct operation");
            } catch (NumberOutOfRangeException e) {
                System.out.println("Numbers must be in range of 1 to 10");
            } catch (IncorrectNumberException e) {
                System.out.println("Enter valid numbers");
            } catch (DifferentTypesOfDigitsException e) {
                System.out.println("Numbers must be of one type");
            } catch (SomethingWentWrongException e) {
                e.printStackTrace();
            } catch (RomanianHasNoZeroException e) {
                System.out.println("Result is zero, but romanian has not this number");
            }
        }
        sc.close();


    }
}
