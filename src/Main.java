import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter A number set in format: 1:0.7 2:0.3");
        Map<Integer, Double> A = Parser.parseInput(scan.nextLine());

        System.out.println("Enter B number set in format: 1:0.7 2:0.3");
        Map<Integer, Double> B = Parser.parseInput(scan.nextLine());

        System.out.println("Enter operation what you want to do over the sets:");
        System.out.println("  * association -> enter 1");
        System.out.println("  * intersection -> enter 2");

        Operation operation = Parser.parseOperation(scan.nextLine());

        Map<Integer, Double> result = Calculator.calculate(A, B, operation);

        float[] ints = {0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.4f, 0.8f};

        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new Draw(ints, ints.length, Color.blue));
        f.setSize(400, 400);
        f.setLocation(200, 200);
        f.setVisible(true);

    }
}