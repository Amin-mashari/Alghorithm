package codeforces;

import java.util.Scanner;
//question link: https://codeforces.com/problemset/problem/448/C

public class paintingFence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] list = new int[len];

        for (int i = 0; i < len; i++)
            list[i] = scanner.nextInt();

        //System.out.println(countPainting(list));

    }

    //todo
    private static int countPainting(int[] list, int start, int end) {
        if (start == end)
            return 1;

        int mid = start + end / 2;

        int leftSide = countPainting(list, start, mid);
        int rightSide = countPainting(list, mid + 1, end);

        //int brushCount = brush();
        return 0;
    }

    private int brush(int[] list) {

        return 0;
    }
}
