package Tests;

import Implemntation.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;


/**
 * This class is used to SortBenchmarkSpeedAndShifts the functionality of every sort class implantation.
 */
@RunWith(Parameterized.class)
public class SortBenchmarksMemory {

    /**
     * The current size of the list.
     */
    private int size;

    /**
     * The application environment.
     */
    private Runtime runtime = Runtime.getRuntime();


    /**
     * Current class being tested.
     */
    private Comparable[] mergeSortNumbers;
    private Comparable[] insertionSortNumbers;
    private Comparable[] quickSortNumbers;
    private Comparable[] heapSortNumbers;
    private Comparable[] bubbleSortNumbers;
    private Comparable[] mergeSortOptimisationNumbers;
    private Comparable[] shellSortNumbers;
    private Comparable[] javaSortNumbers;

    /**
     * The memory used by each algorithm
     */
    private long mergeSortMemory = 0L;
    private long quickSortMemory = 0L;
    private long insertionSortMemory = 0L;
    private long bubbleSortMemory = 0L;
    private long heapSortMemory = 0L;
    private long mergeSortOptimisationMemory = 0L;
    private long shellSortMemory = 0L;

    /**
     * Constructor for each test.
     *
     * @param size a list size.
     */
    public SortBenchmarksMemory(int size) {
        this.size = size;
    }

    /**
     * Set up the test data for each test run.
     * @return a list size.
     */
    @Parameterized.Parameters
    public static Collection data() {
        List<Integer> sizes = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            sizes.add((int) Math.pow(2, i));
        }
        return sizes;
    }

    /**
     *Populate the test lists with numbers.
     */
    @Before
    public void setTestData() {
        //Populate a list with random numbers
        Comparable[] nums = new Comparable[size];
        Random generator = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = generator.nextInt(size);
        }
        //Copy list to all test lists
        insertionSortNumbers = nums;
        mergeSortNumbers = nums;
        javaSortNumbers = nums;
        heapSortNumbers = nums;
        bubbleSortNumbers = nums;
        quickSortNumbers = nums;
        mergeSortOptimisationNumbers = nums;
        shellSortNumbers = nums;
        runtime.gc();

    }

    /**
     * Get the memory usage of a method
     * @return the memory used by a method
     */
    private long getMemoryUsage() {
        // Run the garbage collector
        runtime.gc();
        // Calculate the used memory
        return runtime.totalMemory() - runtime.freeMemory();
    }

    /**
     * Merge sort test.
     */
    @Test
    public void MergeSortTest() {
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(mergeSortNumbers);
        mergeSortMemory = getMemoryUsage();
    }

    /**
     * Insertion sort test.
     */
    @Test
    public void InsertionSortTest() {
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(insertionSortNumbers);
        insertionSortMemory = getMemoryUsage();
    }

    /**
     * Quick sort test.
     */
    @Test
    public void QuickSortTest() {
        QuickSort quickSort = new QuickSort();
        quickSort.sort(quickSortNumbers);
        quickSortMemory = getMemoryUsage();
    }

    /**
     * Heap sort test.
     */
    @Test
    public void HeapSortTest() {
        HeapSort heapSort = new HeapSort();
        heapSort.sort(heapSortNumbers);
        heapSortMemory = getMemoryUsage();
    }

    /**
     * Bubble sort test.
     */
   @Test
    public void BubbleSortTest() {
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(bubbleSortNumbers);
        bubbleSortMemory = getMemoryUsage();
   }

    /**
     * Java sort test.
     */
    @Test
    public void JavaSort() {
        Arrays.sort(javaSortNumbers);
    }


    /**
     * Optimised merge sort test.
     */
    @Test
    public void MergeSortOptimisationTest() {
        MergeSortOptimization mergeSortOptimization = new MergeSortOptimization();
        mergeSortOptimization.sort(mergeSortOptimisationNumbers);
        mergeSortOptimisationMemory = getMemoryUsage();
    }

    /**
     * Shell sort test.
     */
    @Test
    public void ShellSortTest() {
        ShellSort shellSort = new ShellSort();
        shellSort.sort(shellSortNumbers);
        shellSortMemory = getMemoryUsage();
    }




}

