import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.Collections;

class RunningAverageVersion2Test {

    @Test
    void addElements() {

        RunningAverageVersion2 runningAverage = new RunningAverageVersion2();

        assertAll(
                () -> assertEquals(0, runningAverage.addElements(Collections.emptyList())),
                () -> assertEquals(2, runningAverage.addElements(Arrays.asList(1.0, 2.0, 3.0))),
                () -> assertEquals(3, runningAverage.addElements(Arrays.asList(3.0, 3.0))),
                () -> assertEquals(15.25, runningAverage.addElements(Arrays.asList(10.25, 15.25, 20.25)))
        );
    }

    @Test
    void getCurrentAverage() {

        RunningAverageVersion2 runningAverage = new RunningAverageVersion2();
        runningAverage.addElements(Arrays.asList(10.25, 15.25, 20.25));
        assertEquals(15.25, runningAverage.getCurrentAverage());
    }

    @Test
    void getPopulationSize() {

        RunningAverageVersion2 runningAverage = new RunningAverageVersion2();
        runningAverage.addElements(Arrays.asList(10.25, 15.25, 20.25));
        assertEquals(3, runningAverage.getPopulationSize());
    }

    @Test
    void removeElements() {

        RunningAverageVersion2 runningAverage = new RunningAverageVersion2();

        assertAll(
                () -> assertEquals(2, runningAverage.addElements(Arrays.asList(1.0, 2.0, 3.0))),
                () -> assertEquals(2, runningAverage.removeElements(Collections.emptyList())),
                () -> assertEquals(1.5, runningAverage.removeElements(Collections.singletonList(3.0)))
        );
    }


    @Test
    void combine() {

        RunningAverageVersion2 runningAverage1 = new RunningAverageVersion2();
        RunningAverageVersion2 runningAverage2 = new RunningAverageVersion2();

        runningAverage1.addElements(Arrays.asList(3.0, 3.0));
        runningAverage2.addElements(Arrays.asList(1.0,2.0,3.0));

        assertEquals(2.4, RunningAverageVersion2.combine(runningAverage1, runningAverage2).getCurrentAverage());
        assertEquals(5, RunningAverageVersion2.combine(runningAverage1, runningAverage2).getPopulationSize());

    }
}
