import java.util.Stack;
import java.util.Scanner;

public class PalindroneCheckerApp{

    // Method 1: Iterative Two-Pointer
    public static boolean iterativeCheck(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end))
                return false;

            start++;
            end--;
        }
        return true;
    }

    // Method 2: Stack Based
    public static boolean stackCheck(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            stack.push(c);
        }

        for (char c : str.toCharArray()) {
            if (c != stack.pop())
                return false;
        }

        return true;
    }

    // Method 3: Recursive
    public static boolean recursiveCheck(String str, int start, int end) {

        if (start >= end)
            return true;

        if (str.charAt(start) != str.charAt(end))
            return false;

        return recursiveCheck(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Iterative timing
        long start1 = System.nanoTime();
        boolean result1 = iterativeCheck(input);
        long end1 = System.nanoTime();

        // Stack timing
        long start2 = System.nanoTime();
        boolean result2 = stackCheck(input);
        long end2 = System.nanoTime();

        // Recursive timing
        long start3 = System.nanoTime();
        boolean result3 = recursiveCheck(input, 0, input.length() - 1);
        long end3 = System.nanoTime();

        // Display results
        System.out.println("\n--- Performance Comparison ---");

        System.out.println("Iterative Method: " + result1 +
                " | Time: " + (end1 - start1) + " ns");

        System.out.println("Stack Method: " + result2 +
                " | Time: " + (end2 - start2) + " ns");

        System.out.println("Recursive Method: " + result3 +
                " | Time: " + (end3 - start3) + " ns");

        scanner.close();
    }
}