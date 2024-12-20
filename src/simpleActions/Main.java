package simpleActions;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter operation what you want to do over the sets:");
        System.out.println("  * association -> enter 1");
        System.out.println("  * intersection -> enter 2");
        System.out.println("  * subtraction -> enter 3");
        System.out.println("  * addition -> enter 4");
        Operation operation = Parser.parseOperation(scan.nextLine());

        System.out.println("Enter A number set in format: 1:0.7 2:0.3");
        Map<Integer, Float> A = Parser.parseInput(scan.nextLine());

        if (!Operation.ADDITION.equals(operation)) {
            System.out.println("Enter B number set in format: 1:0.7 2:0.3");
            Map<Integer, Float> B = Parser.parseInput(scan.nextLine());

            Map<Integer, Float> result = Calculator.calculate(A, B, operation);

            final ChartDemo demo = new ChartDemo(operation.toString(), A, B, result);
            demo.pack();
            demo.setVisible(true);
        } else {

            Map<Integer, Float> result = Calculator.calculate(A, null, operation);

            final ChartDemo demo = new ChartDemo(operation.toString(), A, null, result);
            demo.pack();
            demo.setVisible(true);
        }
    }
}