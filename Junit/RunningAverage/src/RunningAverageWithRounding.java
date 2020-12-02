import java.util.List;

public class RunningAverageWithRounding {

    private Double currentAverage;
    private Integer populationSize;

    /**
     * Default Constructor.
     */
    public RunningAverageWithRounding() {

        this.currentAverage = 0.0;
        this.populationSize = 0;
    }

    /**
     * Explicit Value Constructor.
     */
    public RunningAverageWithRounding(double lastAverage, int lastPopulationSize) {

        this.currentAverage = lastAverage;
        this.populationSize = lastPopulationSize;
    }

    /**
     * Copy Constructor.
     */
    public RunningAverageWithRounding(RunningAverageWithRounding lastAverage) {

        this.currentAverage = lastAverage.currentAverage;
        this.populationSize = lastAverage.populationSize;
    }

    /**
     * Getter for currentAverage
     */
    public Double getCurrentAverage() {

        return this.round(this.currentAverage);
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
        this.currentAverage = this.round(this.currentAverage);
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
        this.currentAverage = this.round(this.currentAverage);
        return this.currentAverage;
    }

    /**
     * Returns rounding off of the currentAverage to three decimal places.
     */
    public double round(double value) {

        return Math.round(value * 1000.0) / 1000.0;
    }

    /**
     * Combines two running averages and returns a new running average
     */
    static public RunningAverageWithRounding combine(final RunningAverageWithRounding avg1, final RunningAverageWithRounding avg2)
    {
        return new RunningAverageWithRounding

                (
                        (avg1.getCurrentAverage() * avg1.getPopulationSize() + avg2.getCurrentAverage() * avg2.getPopulationSize())
                                / (avg1.getPopulationSize() + avg2.getPopulationSize()),
                        avg1.getPopulationSize() + avg2.getPopulationSize()
                );

    }
}