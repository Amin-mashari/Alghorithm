package Alghorithm.Taklif;

import java.util.Scanner;

class SolveMinShop {

    private int[] prices;
    private int[] A;// [1,2,3 ,....,n]

    public void setItems(int[] prices, int T) {
        this.prices = prices;
        A = new int[T + 1];
        System.out.println(minShopDP(T));
    }

    private int minShopDP(int n) {
        int min;
        int temp;
        int Border = 10000;

        for (int i = 1; i <= n; i++) {
            min = Border;

            for (int j = 1; j < prices.length; j++) {
                if (i >= prices[j])
                    temp = 1 + A[i - prices[j]];
                else
                    temp = Border;

                if (temp < min)
                    min = temp;
            }

            A[i] = min;
        }
        if (A[n] >= Border)
            return -1;

        return A[n];
    }
}

public class MinShop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SolveMinShop object = new SolveMinShop();

        int[] prices;
        int T;

        while (scanner.hasNextLine()) {

            T = Integer.parseInt(scanner.nextLine());

            String[] line = scanner.nextLine().split(" ");
            prices = new int[line.length + 1];

            for (int i = 0; i < line.length; i++)
                prices[i + 1] = Integer.parseInt(line[i]);

            object.setItems(prices, T);
        }
    }
}

