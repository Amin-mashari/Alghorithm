package Alghorithm.Taklif;

import java.util.Scanner;

public class brokenHouse {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbersStr = scanner.nextLine().split(" ");
        int[] numbers = new int[numbersStr.length];

        for (int i = 0; i < numbersStr.length; i++)
            numbers[i] = Integer.parseInt(numbersStr[i]);

        Solve solve = new Solve(numbers);
        int brokenIndex = solve.get_index();
        System.out.println(brokenIndex + ", " + (brokenIndex + 1));

        //* debug
/*
        int[][] allNumbers = {
                {0, 0, 1, 0, 1},
                {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1},
                {0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
                {0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0, 1, 0, 0},//1
                {0, 1, 0, 1, 0, 1, 1, 0},//2
                {0, 1, 0, 1, 0, 0, 1, 0},//3
                {0, 1, 0, 1, 1, 0, 1, 0},//4
                {0, 1, 0, 0, 1, 0, 1, 0},//5
                {0, 1, 1, 0, 1, 0, 1, 0},//6
                {1, 1, 0, 1, 0, 1, 0, 1},//7
                {1, 0, 0, 1, 0, 1, 0, 1},//8
                {1, 0, 1, 1, 0, 1, 0, 1},//9
                {1, 0, 1, 0, 0, 1, 0, 1},//10
                {1, 0, 1, 0, 1, 1, 0, 1},//11
                {1, 0, 1, 0, 1, 0, 0, 1},//12
                {1, 0, 1, 0, 1, 0, 1, 1},//13

                //{1, 0, 1, 0, 1, 0, 1, 1},

                //  {0, 1, 0, 1, 0, 1, 1},
                // {0, 0, 1},//0, 1
                //  {0, 1, 1},//1, 2
                {0, 1, 1, 0},//1, 2
                {0, 1, 1, 0, 1, 0},//1, 2
                {1, 1, 0},//0, 1
                {1, 0, 0, 1, 0, 1}, //1, 2
                {1, 0, 1, 0, 0, 1, 0},//3, 4
                {1, 0, 1, 1, 0, 1, 0, 1, 0, 1},//2, 3
                {1, 0, 1, 1, 0, 1, 0},//2, 3
                {1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0},//4, 5
                {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1},//16, 17
                {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1},//14, 15
                {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0},
                {1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1},
        };

       for (
                int[] numbers : allNumbers) {

            Solve solve = new Solve(numbers);
            int brokenIndex = solve.get_index();
            System.out.print("end:" + (numbers.length - 1) + "\t ");
            System.out.println(brokenIndex + ", " + (brokenIndex + 1));

        }*/

    }
}

class Solve {

    int[] _numbers;
    int _index;
    int even = 1;
    int odd = 0;

    public Solve(int[] numbers) {
        _numbers = numbers;
        if (numbers[0] == 0) {
            even = 0;
            odd = 1;
        }
        _index = findBrokenIndex(0, numbers.length - 1);
    }

    public int get_index() {
        return _index;
    }

    private int getNumber(int index) {
        return _numbers[index];
    }

    private int findBrokenIndex(int start, int end) {
        int mid = (start + end) / 2;

        if (start == end)
            return start;

        // broken is in leftBehind of mid
        if (mid != 0)
            if (getNumber(mid) == getNumber(mid - 1))
                return mid - 1;

        // broken is in rightBehind of mid
        if (getNumber(mid) == getNumber(mid + 1))
            return mid;

        /**
         * if :numbers[0] == 1
         * should be:
         * index: even -> number: 1
         * index: odd  -> number: 0
         *
         * if numbers[0] == 0
         * should be:
         * index: even -> number: 0
         * index: odd  -> number: 1
         */

        if (isEven(mid)) {
            if (getNumber(mid) == even)
                return findBrokenIndex(mid + 1, end);
            else
                return findBrokenIndex(start, mid - 1);

        }
        //mid is odd
        else {
            if (getNumber(mid) == odd)
                return findBrokenIndex(mid + 1, end);
            else
                return findBrokenIndex(start, mid - 1);
        }
    }

    private boolean isEven(int number) {
        return number % 2 == 0;
    }

}