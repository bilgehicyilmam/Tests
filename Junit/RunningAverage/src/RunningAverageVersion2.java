import java.util.List;

public class RunningAverageVersion2 {

    private Double currentAverage;
    private Double sum;
    private Integer populationSize;

    /**
     * Default Constructor.
     */
    public RunningAverageVersion2() {

        this.currentAverage = 0.0;
        this.populationSize = 0;
        this.sum = 0.0;

    }
    /**
     * Explicit Value Constructor.
     */
    public RunningAverageVersion2(double lastAverage, int lastPopulationSize) {

        this.currentAverage = lastAverage;
        this.populationSize = lastPopulationSize;
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

        if (addedPopulation.isEmpty()){
            return 0.0;
        }
        this.sum = addedPopulation.stream().reduce(Double::sum).get();
        this.populationSize = addedPopulation.size();
        this.currentAverage = this.sum / this.populationSize;
        return this.currentAverage;
    }

    /**
     * Removes elements to the population and returns the new average.
     */
    public Double removeElements(List<Double> removedPopulation) {

        if (removedPopulation.isEmpty()) {
            return this.currentAverage;
        }

        double total = removedPopulation.stream().reduce(Double::sum).get();
        this.populationSize = this.populationSize - removedPopulation.size();
        this.sum = this.sum - total;
        this.currentAverage = this.sum / this.populationSize;
        return this.currentAverage;
    }

    /**
     * Combines two running averages and returns a new running average
     */
    static public RunningAverageVersion2 combine(final RunningAverageVersion2 avg1, final RunningAverageVersion2 avg2)
    {
        return new RunningAverageVersion2
                (
                        (avg1.sum + avg2.sum)/ (avg1.populationSize + avg2.populationSize),
                        avg1.populationSize + avg2.populationSize
                );
    }
}
