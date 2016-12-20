package Implemntation;

import Interfaces.ISort;

/**
 * Heap Sort implements ISort.
 */
public class HeapSort implements ISort {

    /**
     * Input Array.
     */
    private Comparable[] inputArray;
    /**
     * Size of the input array.
     */
    private int size;

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
     * Heap sort.
     *
     * @param in array to be sorted
     */
    @Override
    public void sort(Comparable[] in) {
        inputArray = in;
        //Build the heap
        buildHeap(inputArray);
        for (int i = size; i > 0; i--) {
            //Move elements to front of the heap
            exchange(0, i);
            //Decrease the size
            size = size - 1;
            //Sort the data
            maxHeap(inputArray, 0);
        }
    }

    /**
     * Build the heap from the input array.
     *
     * @param a the input array
     */
    private void buildHeap(Comparable[] a) {
        size = a.length - 1;
        //Iterate from the midpoint of the array towards 0
        for (int i = size / 2; i >= 0; i--) {
            maxHeap(a, i);
        }
    }

    /**
     * Swaps the largest element in the heap.
     *
     * @param in the input array
     * @param i  the position
     */
    private void maxHeap(Comparable[] in, int i) {
        //Get index of the left and right child of non leaf elements
        int left = 2 * i;
        int right = 2 * i + 1;
        //Set largest value to 0
        int largest;
        //If the left node is the largest
        if (left <= size && in[left].compareTo(in[i]) > 0) {
            largest = left;
        } else {
            //If the last element in the heap
            largest = i;
        }
        //If the right node is the larger than the left node
        if (right <= size && in[right].compareTo(in[largest]) > 0) {
            largest = right;
        }
        //Recursion
        if (largest != i) {
            exchange(i, largest);
            maxHeap(in, largest);
        }
    }

    /**
     * Move the elements to the correct position in the list.
     *
     * @param x position in left side of list
     * @param y position in right side of list
     */
    private void exchange(int x, int y) {
        //Swap elements
        Comparable t = inputArray[x];
        inputArray[x] = inputArray[y];
        inputArray[y] = t;
        ++shifts;
    }

}
