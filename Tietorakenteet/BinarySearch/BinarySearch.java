package BinarySearch;

import java.util.Arrays;

public class BinarySearch {
    private int[] list = new int[10];
    private int index = 0;

    public void add(int i) {
        if (index != 9) {
            list[index] = i;
            index++;
        }else{
            System.out.println("Taulukko on täynnä, ei voida lisätä enempää");
        }

    }

    public int Search(
            int[] sortedArray, int key, int low, int high) {
        Arrays.sort(list);
        int middle = low + ((high - low) / 2);

        if (high < low) {
            return -1;
        }
        System.out.println("\nSearching... " + sortedArray[middle]);
        if (key == sortedArray[middle]) {
            return middle;
        } else if (key < sortedArray[middle]) {
            return Search(
                    sortedArray, key, low, middle - 1);
        } else {
            return Search(
                    sortedArray, key, middle + 1, high);
        }
    }

    public int[] getList() {
        return list;
    }

    public int getIndex() {
        return index;
    }
}
