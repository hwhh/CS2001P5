package Implemntation;

import Interfaces.ISort;

/**
 * Insertion Sort implements ISort.
 */
public class InsertionSort implements ISort {

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
     * Insertion sort.
     *
     * @param inputArray array to be sorted
     */
    @Override
    public void sort(Comparable[] inputArray) {
        shifts = 0;
        insertionSort(inputArray, 0, inputArray.length - 1);

    }

    /**
     * Preforms sort on the data
     *
     * @param inputArray the array to be sorted.
     * @param lowerIndex the beginning of the array.
     * @param upperIndex the end of the array.
     */
    void insertionSort(Comparable[] inputArray, int lowerIndex, int upperIndex) {
        //Loop through the entire array
        for (int x = lowerIndex; x < upperIndex; x++) {
            //Get the element at current index
            Comparable tempVal = inputArray[x + 1];
            int y = x + 1;
            //While the element to left of the current element is lower
            while (y > lowerIndex && inputArray[y - 1].compareTo(tempVal) > 0) {
                //Swap elements
                inputArray[y] = inputArray[y - 1];
                y--;
                ++shifts;
            }
            // Put the key in its proper location
            inputArray[y] = tempVal;
        }
    }

}
