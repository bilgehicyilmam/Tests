import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class RunningAverageTest {

    @Test
    void addElements() {

        RunningAverage runningAverage = new RunningAverage();

        assertAll(
                () -> assertEquals(0, runningAverage.addElements(Collections.emptyList())),
                () -> assertEquals(2, runningAverage.addElements(Arrays.asList(1.0, 2.0, 3.0))),
                () -> assertEquals(0, runningAverage.addElements(Collections.emptyList())),
                () -> assertEquals(3, runningAverage.addElements(Arrays.asList(3.0, 3.0))),
                () -> assertEquals(15.25, runningAverage.addElements(Arrays.asList(10.25, 15.25, 20.25)))
        );
    }

    @Test
    void getCurrentAverage() {

        RunningAverage runningAverage = new RunningAverage();
        runningAverage.addElements(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.5));
        assertEquals(3.1, runningAverage.getCurrentAverage());
    }

    @Test
    void getPopulationSize() {

        RunningAverage runningAverage = new RunningAverage();
        runningAverage.addElements(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.5));
        assertEquals(5, runningAverage.getPopulationSize());
    }

    @Test
    void removeElements() {

        RunningAverage runningAverage = new RunningAverage();

        assertAll(
                () -> assertEquals(3.1, runningAverage.addElements(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.5))),
                () -> assertEquals(3.1, runningAverage.removeElements(Collections.emptyList())),
                () -> assertEquals(2, runningAverage.removeElements(Arrays.asList(4.0, 5.5)))
        );
    }


    @Test
    void combine() {

        RunningAverage runningAverage1 = new RunningAverage();
        RunningAverage runningAverage2 = new RunningAverage();

        runningAverage1.addElements(Arrays.asList(3.0, 3.0));
        runningAverage2.addElements(Arrays.asList(1.0,2.0,3.0));

        assertEquals(2.4, RunningAverage.combine(runningAverage1, runningAverage2).getCurrentAverage());
        assertEquals(5, RunningAverage.combine(runningAverage1, runningAverage2).getPopulationSize());
    }
}
