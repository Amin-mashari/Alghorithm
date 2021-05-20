package Alghorithm.Taklif;

import java.util.Scanner;

public class CountDistance {
    public static void main(String[] args) {

        MyNumber[] numbers = read();

        MergeSort sorted = new MergeSort(numbers);
        sorted.printDistance();

    }

    public static MyNumber[] read() {
        Scanner scanner = new Scanner(System.in);

        String[] nums = scanner.nextLine().split(" ");
        MyNumber[] numbers = new MyNumber[nums.length];

        for (int i = 0; i < nums.length; i++) {
            numbers[i] = new MyNumber(Integer.parseInt(nums[i]));
            numbers[i].setFirstIndex(i);
        }

        return numbers;
    }
}

class MyNumber {

    private int data;
    private int firstIndex;

    public MyNumber(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getFirstIndex() {
        return firstIndex;
    }

    public void setFirstIndex(int firstIndex) {
        this.firstIndex = firstIndex;
    }

}

class MergeSort {

    private int sum;

    public MergeSort(MyNumber[] numbers) {
        sort(numbers, 0, numbers.length - 1);
    }

    private MyNumber[] sort(MyNumber[] numbers, int start, int end) {

        if (start >= end)
            return getAloneArray(numbers, start);

        int mid = (start + end) / 2;

        //merge left side and right side
        MyNumber[] left = sort(numbers, start, mid);
        MyNumber[] right = sort(numbers, mid + 1, end);

        return merge(left, right);

    }

    private MyNumber[] getAloneArray(MyNumber[] numbers, int start) {
        MyNumber[] temp = new MyNumber[1];
        temp[0] = numbers[start];
        return temp;
    }

    private MyNumber[] merge(MyNumber[] left, MyNumber[] right) {

        MyNumber[] merged = new MyNumber[left.length + right.length];
        int i = 0;
        int j = 0;
        sum = 0;

        for (int index = 0; index < merged.length; index++) {

            if (i < left.length && j < right.length) {
                if (left[i].getData() < right[j].getData()) {
                    merged[index] = left[i];
                    i++;
                } else {
                    merged[index] = right[j];
                    j++;
                }

            } else if (i < left.length) {
                merged[index] = left[i];
                i++;
            } else {
                merged[index] = right[j];
                j++;
            }

            //calculate distance of each element and add to sum
            calculateSum(merged[index], index);
        }

        return merged;
    }

    private void calculateSum(MyNumber myNumber, int lastIndex) {
        int dis = myNumber.getFirstIndex() - lastIndex;
        if (dis < 0)
            dis = -dis;
        sum += dis;
    }

    public void printDistance() {
        System.out.println(sum);
    }

}