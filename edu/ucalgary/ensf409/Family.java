/**
 @author Jinsu Kwak <a href="mailto:jinsu.kwak@ucalgary.ca">
 jinsu.kwak@ucalgary.ca</a>
 @UCID 30097737
 @version 1.0
 @since 1.0
 */

package edu.ucalgary.ensf409;

//familyNumber added
public class Family {
    private int adultMale;
    private int adultFemale;
    private int childOver8;
    private int childUnder8;
    private int familyId;
    private NutritionalItems individualWeeklyNutritionalNeeds;
    private Hamper hamper;

    //UML arguments name should be changed
    public Family( int numAdultMale, int numAdultFemale, int numChildOver8, int numChildUnder8, int familyId){
        this.adultMale = numAdultMale;
        this.adultFemale = numAdultFemale;
        this.childOver8 = numChildOver8;
        this.childUnder8 = numChildUnder8;
        this.familyId = familyId;

        calcIndividualWeeklyNutritionalNeeds();
        this.hamper = new Hamper(this.individualWeeklyNutritionalNeeds);
    }

    // This method must be added in UML
    private NutritionalItems CaloriesToPercentage ( double[] actualCalories ) {
        double allCalories = actualCalories[4];
        double percentWholeGrains = (actualCalories[0]/actualCalories[4])*100;
        double percentFruitVeggies = (actualCalories[1]/actualCalories[4])*100;
        double percentProtein = (actualCalories[2]/actualCalories[4])*100;
        double percentOthers = (actualCalories[3]/actualCalories[4])*100;

        NutritionalItems IndividualWeeklyNutritionalNeeds = new NutritionalItems( percentWholeGrains,
                percentFruitVeggies, percentProtein,  percentOthers, allCalories);

        return IndividualWeeklyNutritionalNeeds;
    }

    public void calcIndividualWeeklyNutritionalNeeds(){
        double[] actualCalories = new double[5];

        for(int i = 0; i < this.adultMale; i++){
            for(int j = 0; j < 5; j++){
                double[] nutritionForAdultMale = NutritionalNeedsMap.TABLE.ADULTMALE.percentageToCalories();
                actualCalories[j] = actualCalories[j]+nutritionForAdultMale[j];
            }
        }

        for(int i = 0; i < this.adultFemale; i++){
            for(int j = 0; j < 5; j++){
                double[] nutritionForAdultFemale = NutritionalNeedsMap.TABLE.ADULTFEMALE.percentageToCalories();
                actualCalories[j] = actualCalories[j]+nutritionForAdultFemale[j];
            }
        }

        for(int i = 0; i < this.childOver8; i++){
            for(int j = 0; j < 5; j++){
                double[] nutritionForChildOver8 = NutritionalNeedsMap.TABLE.CHILDOVER8.percentageToCalories();
                actualCalories[j] = actualCalories[j]+nutritionForChildOver8[j];
            }
        }

        for(int i = 0; i < this.childUnder8; i++){
            for(int j = 0; j < 5; j++){
                double[] nutritionForChildUnder8 = NutritionalNeedsMap.TABLE.CHILDUNDER8.percentageToCalories();
                actualCalories[j] = actualCalories[j]+nutritionForChildUnder8[j];
            }
        }

        this.individualWeeklyNutritionalNeeds = CaloriesToPercentage(actualCalories);
    }

    //getters
    public Hamper getHamper(){ return this.hamper; }
    public int getAdultMale(){ return this.adultMale; }
    public int getAdultFemale(){ return this.adultFemale; }
    public int getChildOver8(){ return this.childOver8; }
    public int getChildUnder8(){ return this.childUnder8; }

    //setters
    public void setHamper( Hamper hamper ){ this.hamper = hamper; }
    public void setAdultMale( int num ){ this.adultMale = num; }
    public void setAdultFemale( int num ){ this.adultFemale = num; }
    public void setChildOver8( int num ){ this.childOver8 = num; }
    public void setChildUnder8( int num ){ this.childUnder8 = num; }


}
