package codeforces;

import java.util.Scanner;
//question link : https://codeforces.com/problemset/problem/1470/F

public class strangeCovering {
    /**
     * t (1 <= t <= 2.10^5) the number of test cases
     * n (1 <= n <= 2.10^5) the number of points
     * xi , yi ( 0<= x , y <= 10^9)
     */
    private static class Coordinate {
        private int x;
        private int y;

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void add(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++)
            getPoints(scanner);

    }

    private static void getPoints(Scanner scanner) {
        int n = scanner.nextInt();
        Coordinate[] coordinatesList = new Coordinate[n];
        int x, y;

        for (int i = 0; i < n; i++) {
            x = scanner.nextInt();
            y = scanner.nextInt();
            coordinatesList[i].add(x, y);
        }
        System.out.println(solve(coordinatesList));
    }

    //todo
    private static int solve(Coordinate[] coordinatesList) {

        // not rectangles
        if (coordinatesList.length < 4)
            return 0;
        return 4;
    }
}
