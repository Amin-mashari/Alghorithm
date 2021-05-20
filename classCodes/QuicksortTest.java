package Alghorithm.classCodes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QuicksortTest {

    Quicksort list;

    @BeforeEach
    public void setUp() {
        list = new Quicksort();
    }

    @Test
    public void newList() {

    }

    @Test
    public void sort() {
        int[] list1 = {1, 4, 6, 8, 9, 10, 3, 5};
        int[] list2 = {1, 3, 5, 7, 8, 2, 10};
        int[] list3 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        list.newList(list3);
        list.sort();
        list.printList();

        list.newList(list2);
        list.sort();
        list.printList();
    }

    @Test
    public void random() {
        System.out.println(list.findBestPivot(0, 9));
        System.out.println(list.findBestPivot(0, 9));
        System.out.println(list.findBestPivot(3, 9));
        System.out.println(list.findBestPivot(0, 2));

    }

}