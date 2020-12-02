import java.util.*;

public class RunningAverage {

    private Double currentAverage;
    private Integer populationSize;

    /**
     * Default Constructor.
     */
    public RunningAverage() {

        this.currentAverage = 0.0;
        this.populationSize = 0;
    }

    /**
     * Explicit Value Constructor.
     */
    public RunningAverage(double lastAverage, int lastPopulationSize) {

        this.currentAverage = lastAverage;
        this.populationSize = lastPopulationSize;
    }

    /**
     * Copy Constructor.
     */
    public RunningAverage(RunningAverage lastAverage) {

        this.currentAverage = lastAverage.currentAverage;
        this.populationSize = lastAverage.populationSize;
    }

    /**
     * Getter for currentAverage
     */
    public Double getCurrentAverage() {

        return this.currentAverage;
    }

    /**
     * Getter for populationSize
     */
    public Integer getPopulationSize() {

        return this.populationSize;
    }

    /**
     * Adds elements to the population and returns the new average.
     */
    public Double addElements(List<Double> addedPopulation) {

        if (addedPopulation.size() == 0){
            return 0.0;
        }
        double sum = 0.0;
        this.populationSize = 0;
        for (double element : addedPopulation) {
            sum += element;
            this.populationSize++;
        }
        this.currentAverage = sum / this.populationSize;
        return this.currentAverage;
    }

    /**
     * Removes elements to the population and returns the new average.
     */
    public Double removeElements(List<Double> removedPopulation) {

        if (removedPopulation.size() == 0) {
            return this.currentAverage;
        }
        double sum = this.currentAverage * this.populationSize;
        for (double element : removedPopulation) {
            sum -= element;
            this.populationSize--;
        }
        this.currentAverage = sum / this.populationSize;
        return this.currentAverage;
    }

    /**
     * Combines two running averages and returns a new running average
     */
    static public RunningAverage combine(final RunningAverage avg1, final RunningAverage avg2)
    {
        return new RunningAverage
                (
                        (avg1.getCurrentAverage() * avg1.getPopulationSize() +
                                avg2.getCurrentAverage() * avg2.getPopulationSize())
                                / (avg1.getPopulationSize() + avg2.getPopulationSize()),
                        avg1.getPopulationSize() + avg2.getPopulationSize()
                );
    }
}