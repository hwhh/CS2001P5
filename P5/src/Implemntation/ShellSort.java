package Implemntation;

import Interfaces.ISort;

/**
 * Shell Sort implements ISort - is optimised Insertion Sort.
 */
public class ShellSort implements ISort {

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
        insertionSort(inputArray, 0, inputArray.length);

    }

    /**
     * Preforms sort on the data
     *
     * @param inputArray the array to be sorted.
     * @param lowerIndex the beginning of the array.
     * @param upperIndex the end of the array.
     */
    private void insertionSort(Comparable[] inputArray, int lowerIndex, int upperIndex) {
        int x = 1;
        //Define the gaps
        while (x <= inputArray.length / 3) {
            x = 3 * x + 1;
        }
        while (x > 0) {
            //similar to insertion sort below
            for (int i = lowerIndex; i < upperIndex; i++) {
                Comparable temp = inputArray[i];
                int y;

                for (y = i; y > x - 1 && inputArray[y - x].compareTo(temp) >= 0; y = y - x) {
                    inputArray[y] = inputArray[y - x];
                    ++shifts;
                }
                inputArray[y] = temp;
            }
            x = (x - 1) / 3;
        }
    }

}
