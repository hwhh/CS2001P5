package Implemntation;

import Interfaces.ISort;

/**
 * Merge Sort class implements ISort.
 */
public class MergeSortOptimization extends MergeSort implements ISort {

    private static final int CUTOFF = 7;
    /**
     * Temporary, input and output arrays.
     */
    private static Comparable[] inArray;
    private static Comparable[] tmpArray;
    /**
     * Uses for array's of size 7 or less.
     */
    private InsertionSort insertionSort = new InsertionSort();

    /**
     * Get the total number of shifts.
     *
     * @return number of shifts.
     */
    public long getShifts() {
        return super.getShifts();
    }

    /**
     * Merge sort.
     *
     * @param in array to be sorted
     */
    @Override
    public void sort(Comparable[] in) {
        inArray = in;
        tmpArray = new Comparable[in.length];
        divide(0, in.length - 1);
    }

    /**
     * Divide the up into single elements.
     *
     * @param lowerIndex index of the first item
     * @param upperIndex index of last item
     */
    private void divide(int lowerIndex, int upperIndex) {
        //Check if array size is greater than one
        if (lowerIndex < upperIndex) {
            //If size under threshold use insertion sort
            if (upperIndex - lowerIndex <= CUTOFF) {
                insertionSort.insertionSort(inArray, lowerIndex, upperIndex);
            } else {
                //Get the index of the middle item in the array (round down)
                int middle = (int) Math.floor((lowerIndex + upperIndex) / 2);
                //Recursive calls to split up the array in the segments
                divide(lowerIndex, middle);
                divide(middle + 1, upperIndex);
                //If the list is already sorted
                if ((inArray[middle + 1].compareTo(inArray[middle]) > 0)) return;
                //Merge the segments
                super.merge(inArray, tmpArray, lowerIndex, middle, upperIndex);
            }
        }
    }
}