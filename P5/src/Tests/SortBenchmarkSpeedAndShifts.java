package Tests;

import Implemntation.*;
import com.carrotsearch.junitbenchmarks.AbstractBenchmark;
import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.BenchmarkRule;
import com.carrotsearch.junitbenchmarks.annotation.AxisRange;
import com.carrotsearch.junitbenchmarks.annotation.BenchmarkHistoryChart;
import com.carrotsearch.junitbenchmarks.annotation.LabelType;
import com.carrotsearch.junitbenchmarks.h2.H2Consumer;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.Random;

/**
 * Automatically record test results, run tests 20 times + 3 warm up.
 */
@AxisRange(min = 0, max = 0.002)
@BenchmarkOptions(callgc = false, benchmarkRounds = 20, warmupRounds = 3)
@BenchmarkHistoryChart(labelWith = LabelType.CUSTOM_KEY, maxRuns = 20)
public class SortBenchmarkSpeedAndShifts extends AbstractBenchmark {

    /**
     * Size of the list.
     */
    private static int size = 1000;

    /**
     * Set up the database.
     */
    private static H2Consumer consumer = new H2Consumer(
            new File("target/charts/sortSpeedSorted-db"),
            new File("target/charts"), "Input size: " + String.valueOf(size));
    /**
     * Number of shifts preformed in each sort.
     */
    private static long mergeSortShifts = 0L;
    private static long quickSortShifts = 0L;
    private static long insertionSortShifts = 0L;
    private static long bubbleSortShifts = 0L;
    private static long heapSortShifts = 0L;
    private static long mergeSortOptimisedShifts = 0L;
    private static long shellSortShifts = 0L;
    /**
     * Add the database to the benchmark rule
     */
    @Rule
    public BenchmarkRule benchmarkRun = new BenchmarkRule(consumer);
    /**
     * List containing the test data for each sort.
     */
    private Comparable[] mergeSortNumbers;
    private Comparable[] mergeSortOptNumbers;
    private Comparable[] insertionSortNumbers;
    private Comparable[] javaSortNumbers;
    private Comparable[] quickSortNumbers;
    private Comparable[] heapSortNumbers;
    private Comparable[] bubbleSortNumbers;
    private Comparable[] mergeSortOptimisedNumbers;
    private Comparable[] shellSortNumbers;

    /**
     * Find the average swaps by each sort.
     */
    @AfterClass
    public static void setAverage() {
        //23 runs
        mergeSortShifts = mergeSortShifts / 23;
        insertionSortShifts = insertionSortShifts / 23;
        quickSortShifts = quickSortShifts / 23;
        bubbleSortShifts = bubbleSortShifts / 23;
        heapSortShifts = heapSortShifts / 23;
        mergeSortOptimisedShifts = mergeSortOptimisedShifts / 23;
        shellSortShifts = shellSortShifts / 23;
    }


    /**
     * Populate the test lists with numbers.
     */
    @Before
    public void setTestData(){
        //Populate a list with random numbers
        Comparable[] nums = new Comparable[size];
        Random generator = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = generator.nextInt(size);
        }
        //Copy list to all test lists
        insertionSortNumbers = nums;
        mergeSortNumbers = nums;
        mergeSortOptNumbers = nums;
        javaSortNumbers = nums;
        heapSortNumbers = nums;
        bubbleSortNumbers = nums;
        quickSortNumbers = nums;
        mergeSortOptimisedNumbers = nums;
        shellSortNumbers = nums;
    }

    /**
     * Merge sort test.
     */
    @Test
    public void MergeSortTest() {
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(mergeSortNumbers);
        mergeSortShifts += mergeSort.getShifts();
    }



    /**
     * Java sort test.
     */

    @Test
    public void JavaSort() {
        Arrays.sort(javaSortNumbers);
    }

    /**
     * Insertion sort test.
     */
    @Test
    public void InsertionSortTest() {
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(insertionSortNumbers);
        insertionSortShifts += insertionSort.getShifts();
    }

    /**
     * Quick sort test.
     */
    @Test
    public void QuickSortTest() {
        QuickSort quickSort = new QuickSort();
        quickSort.sort(quickSortNumbers);
        quickSortShifts += quickSort.getShifts();
    }

    /**
     * Heap sort test.
     */
    @Test
    public void HeapSortTest() {
        HeapSort heapSort = new HeapSort();
        heapSort.sort(heapSortNumbers);
        heapSortShifts += heapSort.getShifts();
    }

    /**
     * Bauble sort test.
     */
    @Test
    public void BaubleSortTest() {
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(bubbleSortNumbers);
        bubbleSortShifts += bubbleSort.getShifts();
    }

    /**
     * Optimised merge sort test.
     */
    @Test
    public void MergeSortOptimisedTest() {
        MergeSortOptimization mergeSortOptimization = new MergeSortOptimization();
        mergeSortOptimization.sort(mergeSortOptimisedNumbers);
        mergeSortOptimisedShifts += mergeSortOptimization.getShifts();
    }

    /**
     * Shell sort test.
     */
    @Test
    public void ShellSortTest() {
        ShellSort shellSort = new ShellSort();
        shellSort.sort(shellSortNumbers);
        shellSortShifts += shellSort.getShifts();
    }


}