package Tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Run all the SortBenchmarkSpeedAndShifts classes.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({SortTests.class, SortBenchmarksMemory.class, SortBenchmarkSpeedAndShifts.class})
public class Tests {

}
