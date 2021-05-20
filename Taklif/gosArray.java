package Alghorithm.Taklif;

import java.util.Scanner;

public class gosArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int[] numbers = new int[input.length];

        for (int i = 0; i < numbers.length; i++)
            numbers[i] = Integer.parseInt(input[i]);

        Index f = findMaxIndex(numbers, 0, numbers.length - 1, true, 0);
        //System.out.println("left: " + f.getLeftIndex() + "\nright: " + f.getRightIndex());
        System.out.println(f.getRightIndex() - f.getLeftIndex() + 1);
    }

    private static Index findMaxIndex(int[] numbers, int start, int end, boolean leftState, int deep) {
        if (start == end)
            return new Index(start, end);

        //debugTool
/*      System.out.print(deep + ":[ ");
        for (int i = start; i <= end; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.print("] distance = " + distance + "\n");*/

        int mid = (start + end) / 2;
        Index lMaxIndex = findMaxIndex(numbers, start, mid, true, deep + 1);
        Index rMaxIndex = findMaxIndex(numbers, mid + 1, end, false, deep + 1);

        Index middle = set(numbers, lMaxIndex, rMaxIndex);

        return middle;

    }

    private static Index set(int[] numbers, Index L, Index R) {

        // ll lR
        int leftIndex = L.getLeftIndex();
        int rightIndex = R.getLeftIndex();


        if (numbers[leftIndex] < numbers[L.getRightIndex()])
            leftIndex = L.getRightIndex();

        if (numbers[rightIndex] < numbers[R.getRightIndex()])//|| leftMax < numbers[R.getLeftIndex()]
            rightIndex = R.getLeftIndex();


        

/*        if (leftMax < numbers[R.getLeftIndex()] && rightMax == numbers[R.getRightIndex()]) {
            if (R.getRightIndex() - R.getLeftIndex() == L.getRightIndex() - L.getLeftIndex())
                return new Index(R.getLeftIndex(), R.getRightIndex());
        }*/


        //arrays could not match
        // example 100 2 3 4 5 6 98 3 4 5 93 8 74  4 3 1 3 5 6 6 5 7 55 4 3 91
        // if LR > RL
        if (L.getRightIndex() != L.getLeftIndex() || R.getLeftIndex() != R.getRightIndex())
            if (numbers[L.getRightIndex()] > numbers[R.getLeftIndex()]) {
                int disLeft = L.getRightIndex() - L.getLeftIndex();
                int disRight = R.getRightIndex() - R.getLeftIndex();
                int middleDis = R.getLeftIndex() - L.getRightIndex();

                if (disLeft > middleDis && disLeft > disRight)
                    return new Index(L.getLeftIndex(), L.getRightIndex());
                if (disRight > middleDis && disRight > disLeft)
                    return new Index(R.getLeftIndex(), R.getRightIndex());
                if (middleDis > disLeft && middleDis > disRight)
                    return new Index(L.getRightIndex(), R.getLeftIndex());
            }

        return new Index(leftIndex, rightIndex);
    }

}

class Index {
    int leftIndex;
    int rightIndex;

    public Index(int leftIndex, int rightIndex) {
        this.leftIndex = leftIndex;
        this.rightIndex = rightIndex;
    }

    public int getLeftIndex() {
        return leftIndex;
    }

    public void setLeftIndex(int leftIndex) {
        this.leftIndex = leftIndex;
    }

    public int getRightIndex() {
        return rightIndex;
    }

    public void setRightIndex(int rightIndex) {
        this.rightIndex = rightIndex;
    }
}
