package Implemntation;

import Interfaces.ISort;

/**
 * Bubble sort implements ISort.
 */
public class BubbleSort implements ISort {

    /**
     * Shifts.
     */
    private long shifts = 0l;


    public static void main(String[] args) {
        for (int i = 1; i < 27; i++) {
            System.out.println("Input size: "+(int)Math.pow(2, i));
        }
    }

    /**
     * Get the total number of shifts.
     *
     * @return number of shifts.
     */
    public long getShifts() {
        return shifts;
    }

    /**
     * Bubble sort.
     *
     * @param in array to be sorted
     */
    @Override
    public void sort(Comparable[] in) {
        int x;
        // set flag to true to begin first pass
        boolean swapsMade = true;
        //holding variable
        Comparable temp;
        while (swapsMade) {
            //set flag to false awaiting a possible swap
            swapsMade = false;
            for (x = 0; x < in.length - 1; x++) {
                if (in[x].compareTo(in[x + 1]) > 0) {
                    //swap elements
                    temp = in[x];
                    in[x] = in[x + 1];
                    in[x + 1] = temp;
                    //shows a swap occurred
                    swapsMade = true;
                    shifts++;
                }
            }
        }
    }

}

