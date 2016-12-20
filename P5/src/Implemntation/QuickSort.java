package Implemntation;

import Interfaces.ISort;

/**
 * Quick Sort implements ISort.
 */
public class QuickSort implements ISort {


    /**
     * Input Array.
     */
    private Comparable[] inputArray;

    /**
     * Shifts.
     */
    private long shifts = 0l;

    /**
     * Get the total number of shifts.
     *
     * @return number of shifts.
     */
    public long getShifts() {
        return shifts;
    }

    /**
     * Quick sort.
     *
     * @param in array to be sorted
     */
    @Override
    public void sort(Comparable[] in) {
        this.inputArray = in;
        quickSort(0, in.length - 1);
    }

    /**
     * Divide the list and shift the items.
     *
     * @param lowerIndex Current index in left side of list
     * @param upperIndex Current index in right side of list
     */
    private void quickSort(int lowerIndex, int upperIndex) {
        int x = lowerIndex;
        int y = upperIndex;
        // Get the pivot element from the middle of the list
        Comparable pivot = inputArray[lowerIndex + (upperIndex - lowerIndex) / 2];
        // Divide into two lists
        while (x <= y) {
            // If the current value from the left list is smaller then the pivot
            while (inputArray[x].compareTo(pivot) < 0) {
                x++;
            }
            //If the current value from the right list is larger then the pivot
            while (inputArray[y].compareTo(pivot) > 0) {
                y--;
            }
            // Values in left list larger than pivot and values in right list smaller than pivot are moved to correct position
            if (x <= y) {
                shift(x++, y--);
            }
        }
        // Recursion
        if (lowerIndex < y)
            quickSort(lowerIndex, y);
        if (x < upperIndex)
            quickSort(x, upperIndex);
    }

    /**
     * Move the elements to the correct position in the list.
     *
     * @param x position in left side of list
     * @param y position in right side of list
     */
    private void shift(int x, int y) {
        //Swap elements
        Comparable temp = inputArray[x];
        inputArray[x] = inputArray[y];
        inputArray[y] = temp;
        ++shifts;
    }


}
