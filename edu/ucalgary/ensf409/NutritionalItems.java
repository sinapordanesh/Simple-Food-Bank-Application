/**
 @author Jinsu Kwak <a href="mailto:jinsu.kwak@ucalgary.ca">
 jinsu.kwak@ucalgary.ca</a>
 @UCID 30097737
 @version 1.0
 @since 1.0
 */

package edu.ucalgary.ensf409;

public class NutritionalItems {
    private final double WHOLEGRAINS;
    private final double FRUITVEGGIES;
    private final double PROTEIN;
    private final double OTHERS;
    private final double CALORIE;

    /**
     * Constructor for NutritionalItem Class
     * @param wholeGrain: WholeGrain in percentage form
     * @param fruitVeggies: FruitVeggies in percentage form
     * @param protein: Protein in percentage form
     * @param others: Others in percentage form
     * @param calories: Total Calories
     */
    public NutritionalItems( double wholeGrain, double fruitVeggies, double protein, double others, double calories ){
        this.WHOLEGRAINS = wholeGrain;
        this.FRUITVEGGIES = fruitVeggies;
        this.PROTEIN = protein;
        this.OTHERS = others;
        this.CALORIE = calories;
    }

    /**
     * double[] percentageToCalories()
     * function that convert percentage form of nutrition to actual Calorie form
     */
    public double[] percentageToCalories() {
        double[] actualCalories = new double[5];
        actualCalories[0] = (WHOLEGRAINS/100)*CALORIE;
        actualCalories[1] = (FRUITVEGGIES/100)*CALORIE;
        actualCalories[2] = (PROTEIN/100)*CALORIE;
        actualCalories[3] = (OTHERS/100)*CALORIE;
        actualCalories[4] = CALORIE;
        return actualCalories;
    }

    /**
     * ---------------------- getters ------------------------
	 *	getWholeGrains(): double
	 *	getFruitVeggies(): double
	 *	getProtein(): double
	 *  getOthers(): double
	 *  getCalories(): double
     */
    public double getWholeGrains() {return this.WHOLEGRAINS;}
    public double getFruitVeggies() {return this.FRUITVEGGIES;}
    public double getProtein() {return this.PROTEIN;}
    public double getOthers() {return this.OTHERS;}
    public double getCalories() {return this.CALORIE;}

}
