package edu.ucalgary.ensf409;


// I implemented this Class because I wanted to remove red lines (errors) while I'm implementing my Class
// feel free to remove this one and reconstruct yours if you don't like it
// Also I think we should change these variables values int to double because
// since we have to add all and convert into percentage in future calculations, int division may lead inaccurate values
public class NutritionalItems {
    private final double WHOLEGRAINS;
    private final double FRUITVEGGIES;
    private final double PROTEIN;
    private final double OTHERS;
    private final double CALORIE;

    //UML argument name have to be changed
    public NutritionalItems( double wholeGrain, double fruitVeggies, double protein, double others, double calories ){
        this.WHOLEGRAINS = wholeGrain;
        this.FRUITVEGGIES = fruitVeggies;
        this.PROTEIN = protein;
        this.OTHERS = others;
        this.CALORIE = calories;
    }

    // different input and output variable type compare to UML
    // but I prefer this version
    // since this method changed into public this has to be tested in future test codes
    public double[] percentageToCalories() {
        double[] actualCalories = new double[5];
        actualCalories[0] = (WHOLEGRAINS/100)*CALORIE;
        actualCalories[1] = (FRUITVEGGIES/100)*CALORIE;
        actualCalories[2] = (PROTEIN/100)*CALORIE;
        actualCalories[3] = (OTHERS/100)*CALORIE;
        actualCalories[4] = CALORIE;
        return actualCalories;
    }

    public double getWholeGrains() {return this.WHOLEGRAINS;}
    public double getFruitVeggies() {return this.FRUITVEGGIES;}
    public double getProtein() {return this.PROTEIN;}
    public double getOthers() {return this.OTHERS;}
    public double getCalorie() {return this.CALORIE;}

}
