package Alghorithm.Taklif;

import java.util.Scanner;

public class Price {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //input
        String in = scanner.nextLine();
        int x = Integer.parseInt(scanner.nextLine());

        String[] numStr = in.split(" ");
        int[] numbers = new int[numStr.length];
        //cast to integer
        for (int i = 0; i < numStr.length; i++)
            numbers[i] = Integer.parseInt(numStr[i]);

        if (checkAlgorithm(numbers, x))
            System.out.println("YES");
        else
            System.out.println("NO");

    }

    private static boolean checkAlgorithm(int[] numbers, int x) {

        //mergeSort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == x)
                return true;

            int sum = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {

                sum += numbers[j];
                if (sum == x)
                    return true;
                else if (sum > x)
                    sum -= numbers[j];
            }

        }
        return false;
    }

    private static void mergeSort(int[] list) {
        mergeSort(list, 0, list.length - 1);
    }

    private static int[] mergeSort(int[] list, int start, int end) {

        int[] temp = new int[end - start + 1];

        if (start == end) {
            temp[0] = list[start];
            return temp;
        }
        int mid = (start + end) / 2;
        int[] leftHalf = mergeSort(list, start, mid);
        int[] rightHalf = mergeSort(list, mid + 1, end);
        mergeHalf(leftHalf, rightHalf, temp);
        return temp;
    }

    private static void mergeHalf(int[] leftHalf, int[] rightHalf, int[] temp) {

        int i = 0, j = 0;
        for (int k = 0; i < temp.length; i++) {

            if (i > leftHalf.length) {
                temp[k] = rightHalf[j];
                j++;
            } else if (j > rightHalf.length || leftHalf[i] >= rightHalf[j]) {

                temp[k] = leftHalf[i];
                i++;
            } else {
                temp[k] = rightHalf[j];
                j++;
            }
        }
    }
}