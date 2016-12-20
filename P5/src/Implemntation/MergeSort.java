package Implemntation;

import Interfaces.ISort;

/**
 * Merge Sort class implements ISort.
 */
public class MergeSort implements ISort{


    /**
     * Temporary, input and output arrays.
     */
    private static Comparable[] inArray;
    private static Comparable[] tmpArray;

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
     * Merge sort.
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
     * @param lowerIndex index of the first item
     * @param upperIndex index of last item
     */
    private void divide(int lowerIndex, int upperIndex) {
        //Check if array size is greater than one
        if (lowerIndex < upperIndex) {
            //Get the index of the middle item in the array (round down)
            int middle = (int) Math.floor((lowerIndex + upperIndex)/2);
            //Recursive calls to split up the array in the segments
            divide(lowerIndex, middle);
            divide(middle + 1, upperIndex);
            //Merge the segments
            merge(inArray, tmpArray, lowerIndex, middle, upperIndex);
        }
    }

    /**
     * Sort and merge the input arrays.
     * @param lowerIndex the lowest index of the array
     * @param middle the index of the middle
     * @param upperIndex the highest index in the array
     */
    void merge(Comparable[] inArray, Comparable[] tmpArray, int lowerIndex, int middle, int upperIndex) {
        //Save the input array to a temporary array
        System.arraycopy(inArray, lowerIndex, tmpArray, lowerIndex, upperIndex + 1 - lowerIndex);
        //Save the indexes
        int x = lowerIndex;
        int y = middle+1;
        //Move the the smallest values to the front
        while (x <= middle && y <= upperIndex) {
            //Compare items at the front of the array with those past the middle
            if (tmpArray[x].compareTo(tmpArray[y]) <= 0){
                //Move larger items back
                inArray[lowerIndex] = tmpArray[x++];
            } else {
                //Move smaller items forward
                inArray[lowerIndex] = tmpArray[y++];
            }
            ++shifts;
            lowerIndex++;
        }
        //Copy the rest of the array over
        while (x <= middle) {
            inArray[lowerIndex++] = tmpArray[x++];
        }

    }
}