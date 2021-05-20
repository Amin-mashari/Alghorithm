package Alghorithm.Taklif;

import java.util.Scanner;

public class Arch {

    static int isThereAnyArch_questionMark(int numbers[], int start, int end) {
        if (end == start) {
            return 1;
        }
        int mid = (start + end) / 2;

        int leftArch = isThereAnyArch_questionMark(numbers, start, mid);
        int rightArch = isThereAnyArch_questionMark(numbers, (mid + 1), end);

        // ! // Let's just forget about left or right for a minute,
        // ! // and find ourselves a rightMax and a leftMax:

        // ? Debug tool ? //
        // System.out.println("----------------");
        // System.out.printf("Check it out!!!!!!\nLeft Arch : %d\nRight Arch : %d\n", leftArch, rightArch);
        // System.out.println("----------------");

        int leftMax = numbers[mid];
        int leftIndex = mid;
        for (int i = mid - 1; i >= start; i--) {
            if (leftMax <= numbers[i]) {
                leftMax = numbers[i];
                leftIndex = i;
            }
        }

        int rightMax = numbers[mid + 1];
        int rightIndex = mid + 1;
        for (int i = mid + 1; i <= end; i++) {
            if (rightMax <= numbers[i]) {
                rightMax = numbers[i];
                rightIndex = i;
            }
        }

        // ? Debug tool ? //
        // System.out.println("----------------");
        // System.out.printf("Befor double cheking!!\nLeft Index : %d\tLeft Max : %d\n", leftIndex, leftMax);
        // System.out.printf("Right Index : %d\tRight Max : %d\n", rightIndex, rightMax);
        // System.out.println("----------------");
        // int temp[][] = new int[2][2];
        // temp[0][0] = leftIndex;
        // temp[0][1] = leftMax;
        // temp[1][0] = rightIndex;
        // temp[1][1] = rightMax;

        // ! // Is there a new rightMax or leftMax along the road?
        int i = mid + 1;
        if (rightMax > leftMax) {
            while (leftMax >= numbers[i]) {
                i++;
            }
            rightIndex = i;
        } else if (rightMax < leftMax) {
            i = mid;
            while (rightMax >= numbers[i]) {
                i--;
            }
            leftIndex = i;
        }

        // ? Debug tool ? //
        // if ((temp[0][0] != leftIndex) || (temp[1][0] != rightIndex)) {
        //     System.out.println("----------------");
        //     System.out.printf("After double cheking!!\nLeft Index : %d\tLeft Max : %d\n", leftIndex, numbers[leftIndex]);
        //     System.out.printf("Right Index : %d\tRight Max : %d\n", rightIndex, numbers[rightIndex]);
        //     System.out.println("----------------");
        // }

        return Math.max(leftArch, Math.max(rightArch, rightIndex - leftIndex + 1));
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

        int number = isThereAnyArch_questionMark(numbers, 0, numbers.length - 1);
        System.out.println(number);

        input.close();
    }
}
