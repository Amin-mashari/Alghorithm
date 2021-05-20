package Alghorithm.classCodes;

import java.util.Random;

public class Quicksort {
    private int[] _list;

    public Quicksort() {
    }

    public void newList(int[] list) {
        _list = list;
    }

    public void printList() {
        System.out.print("{ ");
        for (int element : _list)
            System.out.print(element + " ");

        System.out.println("}");
    }

    public void sort() {
        quickSort(0, _list.length - 1);
    }

    public int getNumber(int index) {
        return _list[index];
    }

    private void quickSort(int start, int end) {
        if (start >= end)
            return;

        //find best pivot index in list randomly
        int pivot = findBestPivot(start, end);
        swap(start, pivot);
        //now pivot is in first
        pivot = start;

        int i = start + 1;
        for (int j = start + 1; j <= end; j++) {
            if (getNumber(j) < getNumber(pivot)) {
                if (i != j)
                    swap(i, j);
                i++;
            }
        }
        if (pivot != i - 1) {
            swap(pivot, i - 1);
            pivot = i - 1;
        }

        quickSort(start, pivot - 1);
        quickSort(pivot + 1, end);
    }

    private void swap(int first, int second) {
        int temp = _list[first];
        _list[first] = _list[second];
        _list[second] = temp;
    }

    public int findBestPivot(int start, int end) {

        Random random = new Random();
        int rand = random.nextInt(end + 1);

        if (rand < start)
            rand += (start - rand);

        return rand;
    }
}
