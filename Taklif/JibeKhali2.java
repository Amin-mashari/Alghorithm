package Alghorithm.Taklif;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JibeKhali2 {

    static boolean checkSubsets (ArrayList<Integer> set, int max) {
        int n = set.size();
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < Math.pow(2, n); i++) {
            arr.clear();
            for (int j = 0; j < n; j++)
                if ((i & (1 << j)) > 0)
                    arr.add(set.get(j));

            if (getSumOfList(arr, max) == max)
                return true;
        }
        return false;
    }

    // Utils Method
    // "max" added for optimization
    static int getSumOfList (List<Integer> list, int max) {
        int sum = 0;
        for (int a : list) {
            sum += a;
            if (sum > max)
                return -1;
        }
        return sum;
    }

    public static void main (String[] args) {
        Scanner scn = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        //input
        String input = scn.nextLine();
        int max = scn.nextInt();
        String[] inputList = input.split(" ");
        for (String s : inputList) {
            list.add(Integer.parseInt(s));
        }

        //exceptions
        if (max == 0) {
            System.out.println("NO");
            return;
        }
        if (list.size() == 0) {
            System.out.println("NO");
            return;
        }
        /////////////

        if (checkSubsets(list, max))
            System.out.println("YES");
        else
            System.out.println("NO");
    }

}
