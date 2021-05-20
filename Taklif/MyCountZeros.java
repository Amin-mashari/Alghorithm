package Alghorithm.Taklif;

public class MyCountZeros {
    public static void main(String[] args) {
        int[] list = {1, 1, 1, 0};
        CountZero count = new CountZero(list);
        System.out.println(count.count());
    }
}

class CountZero {

    int[] list;

    public CountZero(int[] list) {
        this.list = list;
    }

    public int count() {
        int index = countZero(0, list.length - 1);

        return list.length  - index;
    }

    private int countZero(int start, int end) {

        if (start >= end) {

            if (list[start] == 1)
                return start + 1;
            else
                return start;
        }
        int mid = (start + end) / 2;

        if (list[mid] == 1)//go right
            return countZero(mid + 1, end);
        else
            return countZero(start, mid - 1);
    }
}