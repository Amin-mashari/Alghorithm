package Alghorithm.Taklif;

import java.util.Scanner;

public class FollowTheRules {

    public static int firstNumber;
    public static int secondNumber;

    static void letsFindOurselvesTwoSameNumbers(int numbers[], int start, int end) {
        if (end == start) {
            return;
        }
        int mid = (start + end) / 2;
        int leftLength = mid - start + 1;
        int rightlength = end - (mid + 1) + 1;
        /*
         * // ! // Explanaition:
         * // ! // Let's take a lock at the possibilities;
         * // ! // First of all, we need to check the lengths,
         * // ! // if the left length is even, the start and the ending of the array
         * // ! // must not be equal, and if the left length is odd,
         * // ! // the start and the ending of the array must be equal.
         * // ! // the same thing applies for the right side.
         * // ! // If none of the above happened, then mid has a problem.
         */

        // ? Debug tool ? //
        // System.out.println("$$$$$$$$$$$$$$$$");
        // System.out.printf("Left Length : %d\tRight length : %d\n", leftLength,
        // rightlength);
        // System.out.println("$$$$$$$$$$$$$$$$");

        if ((leftLength % 2 == 0 && numbers[start] == numbers[mid])
                || (leftLength % 2 == 1 && numbers[start] != numbers[mid])) {
            // ? Debug tool ? //
            // System.out.println("----------------");
            // System.out.printf("Going Left!\nMid Index : %d\tNumbers[%d] : %d\n", mid,
            // mid, numbers[mid]);
            // System.out.printf("Left Length is %s\n", (leftLength % 2 == 0) ? "Even" :
            // "Odd");
            // System.out.printf("numbers[%d] %s= numbers[%d])\n", start, (numbers[start] ==
            // numbers[mid]) ? "=" : "!", mid);
            // System.out.println("----------------");

            letsFindOurselvesTwoSameNumbers(numbers, start, mid);

        } else if ((rightlength % 2 == 0 && numbers[mid + 1] == numbers[end])
                || (rightlength % 2 == 1 && numbers[mid + 1] != numbers[end])) {
            // ? Debug tool ? //
            // System.out.println("----------------");
            // System.out.printf("Going Right!\nMid Index : %d\tNumbers[%d] : %d\n", mid,
            // mid, numbers[mid]);
            // System.out.printf("Right Length is %s\n", (rightlength % 2 == 0) ? "Even" :
            // "Odd");
            // System.out.printf("numbers[%d] %s= numbers[%d])\n", mid + 1, (numbers[mid +
            // 1] == numbers[end]) ? "=" : "!", end);
            // System.out.println("----------------");

            letsFindOurselvesTwoSameNumbers(numbers, mid + 1, end);

        } else {
            // ? Debug tool ? //
            // System.out.println("----------------");
            // System.out.printf("Right ones!\n");
            // System.out.printf("Mid Index : %d\tMid Number: %d\n",mid , numbers[mid]);
            // System.out.printf("Mid + 1 Index : %d\tMid + 1 Number: %d\n",mid + 1 ,
            // numbers[mid + 1]);
            // System.out.println("----------------");

            firstNumber = mid;
            secondNumber = mid + 1;
        }
    }

    // ! // Simple read function:
    private static int[] read(Scanner input) {
        String[] numbersTemp = input.nextLine().trim().split(" ");
        int[] numbers = new int[numbersTemp.length];
        for (int i = 0; i < numbersTemp.length; i++) {
            numbers[i] = Integer.parseInt(numbersTemp[i]);
        }
        return numbers;
    }

    public static void main(String[] args) {
        // ! // Getting basic elements:
        Scanner input = new Scanner(System.in);
        int numbers[] = read(input);

        // ! // Let's do the math and them print it:
        letsFindOurselvesTwoSameNumbers(numbers, 0, numbers.length - 1);
        System.out.println(firstNumber + ", " + secondNumber);

        input.close();
    }
}
