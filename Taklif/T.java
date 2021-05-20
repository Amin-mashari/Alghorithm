package Alghorithm.Taklif;

import java.util.Scanner;

public class T {

    private static int distance = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int[] numbers = new int[input.length];

        for (int i = 0; i < numbers.length; i++)
            numbers[i] = Integer.parseInt(input[i]);

        findMaxIndex(numbers, 0, numbers.length - 1, true);
        System.out.println(distance);

    }

    private static int findMaxIndex(int[] numbers, int start, int end, boolean leftState) {
        if (start == end)
            return start;

        int mid = (start + end) / 2;
        int leftMaxIndex = findMaxIndex(numbers, start, mid, true);
        int rightMaxIndex = findMaxIndex(numbers, mid + 1, end, false);


        //count distance between leftMax and right max
        int tempDistance = 0;
        for (int i = leftMaxIndex; i <= rightMaxIndex; i++)
            tempDistance++;

        //set bigger distance
        if (distance < tempDistance)
            distance = tempDistance;

        while (numbers[leftMaxIndex] < numbers[leftMaxIndex + 1] && leftMaxIndex + 1 != numbers.length-1) {
            leftMaxIndex++;
        }
        // find the max left max or right
        if (numbers[leftMaxIndex] > numbers[rightMaxIndex])
            return leftMaxIndex;


        else if (numbers[leftMaxIndex] < numbers[rightMaxIndex])
            return rightMaxIndex;
        else//numbers [left] == numbers[right]
        {
            if (leftState)
                return leftMaxIndex;
            return rightMaxIndex;
        }
    }
}
