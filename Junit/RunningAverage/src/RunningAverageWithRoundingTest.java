import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.Collections;


class RunningAverageWithRoundingTest {

    @Test
    void addElements() {

        RunningAverageWithRounding runningAverage = new RunningAverageWithRounding();

        assertAll(
                () -> assertEquals(0, runningAverage.addElements(Collections.emptyList())),
                () -> assertEquals(2.126, runningAverage.addElements(Arrays.asList(1.1256, 2.1256, 3.1256))),
                () -> assertEquals(3.459, runningAverage.addElements(Arrays.asList(3.45895, 3.45895)))
        );
    }

    @Test
    void getCurrentAverage() {

        RunningAverageWithRounding runningAverage = new RunningAverageWithRounding();
        runningAverage.addElements(Arrays.asList(1.1256, 2.1256, 3.1256));
        assertEquals(2.126, runningAverage.getCurrentAverage());
    }

    @Test
    void getPopulationSize() {

        RunningAverageWithRounding runningAverage = new RunningAverageWithRounding();
        runningAverage.addElements(Arrays.asList(1.1256, 2.1256, 3.1256));
        assertEquals(3, runningAverage.getPopulationSize());
    }

    @Test
    void removeElements() {

        RunningAverageWithRounding runningAverage = new RunningAverageWithRounding();

        assertAll(
                () -> assertEquals(2.126, runningAverage.addElements(Arrays.asList(1.1256, 2.1256, 3.1256))),
                () -> assertEquals(2.126, runningAverage.removeElements(Collections.emptyList())),
                () -> assertEquals(2.126, runningAverage.removeElements(Collections.singletonList(2.1256)))
        );
    }


    @Test
    void combine() {
///
        RunningAverageWithRounding runningAverage1 = new RunningAverageWithRounding();
        RunningAverageWithRounding runningAverage2 = new RunningAverageWithRounding();

        runningAverage1.addElements(Arrays.asList(1.1256, 2.1256, 3.1256));
        runningAverage2.addElements(Arrays.asList(4.1256, 5.1256));

        assertEquals(3.126, RunningAverageWithRounding.combine(runningAverage1, runningAverage2).getCurrentAverage());
        assertEquals(5, RunningAverageWithRounding.combine(runningAverage1, runningAverage2).getPopulationSize());

    }

    @Test
    void round() {

        RunningAverageWithRounding runningAverage = new RunningAverageWithRounding();
        double actual = runningAverage.addElements(Arrays.asList(1.1256, 2.1256, 3.1256));
        assertEquals(2.126, runningAverage.round(actual));
    }
}
