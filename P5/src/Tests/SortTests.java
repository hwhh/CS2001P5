package Tests;

import Implemntation.*;
import Interfaces.ISort;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

/**
 * General functionality tests.
 */
@RunWith(Parameterized.class)
public class SortTests {

    /**
     * Max size of list and largest number.
     */
    private final static int SIZE = 1000;
    private final static int MAX = SIZE;
    /**
     * List containing test data.
     */
    private static Comparable[] numbers;
    /**
     * Current class being tested.
     */
    private Class sortClass;
    /**
     * Current object being tested.
     */
    private ISort sort;
    /**
     * Constructor.
     *
     * @param cl the current class being tested
     */
    public SortTests(Class cl) {
        sortClass = cl;
    }

    /**
     * Add all the classes to be tested to a list.
     *
     * @return A list containing all the classes to be tested.
     * @throws NoSuchMethodException if class doesnt exists.
     */
    @Parameterized.Parameters
    public static Collection classesAndMethods() throws NoSuchMethodException {
        List<Class> list = new ArrayList<>();
        list.add(MergeSort.class);
        list.add(InsertionSort.class);
        list.add(QuickSort.class);
        list.add(HeapSort.class);
        list.add(BubbleSort.class);
        list.add(MergeSortOptimization.class);
        list.add(ShellSort.class);
        return list;
    }

    /**
     *Populate the test lists with numbers.
     */
    @BeforeClass
    public static void setTestData() {
        //Populate a list with random numbers
        numbers = new Comparable[SIZE];
        Random generator = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(MAX);
        }
    }

    /**
     * Create a new instance of each class to be tested.
     */
    @Before
    public void setUp() {
        try {
            //Get a new instance of the current class
            sort = (ISort) sortClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * Check the result is the same produces by the Java sort algorithm.
     */
    @Test
    public void testStandardSort() {
        //Copy test array and sort it
        Comparable[] javaNumbers = numbers;
        Arrays.sort(javaNumbers);
        //Preform sort
        sort.sort(numbers);
        //Check the numbers list is in ascending order
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i].compareTo(numbers[i + 1]) > 0) {
                System.out.println(numbers[i] + "   " + numbers[i + 1]);
                fail("The elements aren't in order");
            }
        }
        //Check the output of both sorts are the same
        assertArrayEquals(javaNumbers, numbers);

    }

    /**
     * Check the sort produces correct output many times.
     */
    @Test
    public void itWorksRepeatably() {
        for (int i = 0; i < 100; i++) {
            //Populate a list with random numbers
            numbers = new Comparable[SIZE];
            Random generator = new Random();
            for (int a = 0; a < numbers.length; a++) {
                numbers[a] = generator.nextInt(MAX);
            }
            //Preform sort
            sort.sort(numbers);
            //Check the numbers list is in ascending order
            for (int j = 0; j < numbers.length - 1; j++) {
                if (numbers[j].compareTo(numbers[j + 1]) > 0) {
                    System.out.println(numbers[j] + " " + numbers[j + 1]);
                    fail("The elements aren't in order");
                }
            }
        }
    }


}