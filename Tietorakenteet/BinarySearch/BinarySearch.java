package BinarySearch;

import java.util.Arrays;

public class BinarySearch {
    private int[] list = new int[20];
    private int index = 0;

    public void add(int i){
        list[index] = i;
        index++;
        System.out.println(list[index-1]);
        Arrays.sort(list);
    }

    public int Search(
            int[] sortedArray, int key, int low, int high) {
        int middle = low + ((high - low) / 2);

        if (high < low) {
            return -1;
        }

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

    public int[] getList(){
        return list;
    }

    public int getIndex() {
        return index;
    }
}
