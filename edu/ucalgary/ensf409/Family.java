/**
 @author Jinsu Kwak <a href="mailto:jinsu.kwak@ucalgary.ca">
 jinsu.kwak@ucalgary.ca</a>
 @UCID 30097737
 @version 1.0
 @since 1.0
 */

package edu.ucalgary.ensf409;


public class Family {
    private int adultMale;
    private int adultFemale;
    private int childOver8;
    private int childUnder8;
    private int familyId;
    private NutritionalItems individualWeeklyNutritionalNeeds;
    private Hamper hamper;

    /**
     * Constructor for Family Class
     * @param numAM : number of adult male in single family
     * @param numAF : number of adult female in single family
     * @param numCO8 : number of child over 8 in single family
     * @param numCU8 : number of child under 8 in single family
     * @param familyId : family ID
     */
    public Family( int numAM, int numAF, int numCO8, int numCU8, int familyId ){
        this.adultMale = numAM;
        this.adultFemale = numAF;
        this.childOver8 = numCO8;
        this.childUnder8 = numCU8;
        this.familyId = familyId;

        calcIndividualWeeklyNutritionalNeeds();
        this.hamper = new Hamper(this.individualWeeklyNutritionalNeeds);
    }

    /**
     * helper method for calcIndividualWeeklyNutritionalNeeds() to store single family's calories to percentage form
     * @param actualCalories : calorie form of nutrition information
     * @return returns object NutritionalItems which store nutrition information with percentage form
     */
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

    /**
     *  calculate and stores NutritionalItems:individualWeeklyNutritionalNeeds for this.Family
     */
    public void calcIndividualWeeklyNutritionalNeeds(){
        double[] actualCalories = new double[5];

        for(int i = 0; i < this.adultMale; i++){
            for(int j = 0; j < 5; j++){
                NutritionalItems NutritionalNeedsMale = NutritionalNeedsMap.TABLE.get("ADULTMALE");
                double[] nutritionForAdultMale = NutritionalNeedsMale.percentageToCalories();
                actualCalories[j] = actualCalories[j]+nutritionForAdultMale[j];
            }
        }

        for(int i = 0; i < this.adultFemale; i++){
            for(int j = 0; j < 5; j++){
                NutritionalItems NutritionalNeedsFemale = NutritionalNeedsMap.TABLE.get("ADULTFEMALE");
                double[] nutritionForAdultFemale = NutritionalNeedsFemale.percentageToCalories();
                actualCalories[j] = actualCalories[j]+nutritionForAdultFemale[j];
            }
        }

        for(int i = 0; i < this.childOver8; i++){
            for(int j = 0; j < 5; j++){
                NutritionalItems NutritionalNeedsChildOver8 = NutritionalNeedsMap.TABLE.get("CHILDOVER8");
                double[] nutritionForChildOver8 = NutritionalNeedsChildOver8.percentageToCalories();
                actualCalories[j] = actualCalories[j]+nutritionForChildOver8[j];
            }
        }

        for(int i = 0; i < this.childUnder8; i++){
            for(int j = 0; j < 5; j++){
                NutritionalItems NutritionalNeedsChildUnder8 = NutritionalNeedsMap.TABLE.get("CHILDUNDER8");
                double[] nutritionForChildUnder8 = NutritionalNeedsChildUnder8.percentageToCalories();
                actualCalories[j] = actualCalories[j]+nutritionForChildUnder8[j];
            }
        }

        this.individualWeeklyNutritionalNeeds = CaloriesToPercentage(actualCalories);
    }

    /**
     * ---------------------- getters ------------------------
     * getHamper(): Hamper
     * getAdultMale(): int
     * getAdultFemale(): int
     * getChildOver8(): int
     * getChildUnder8(): int
     * getIndividualWeeklyNutritionalNeeds(): NutritionalItems
     */
    public Hamper getHamper(){ return this.hamper; }
    public int getAdultMale(){ return this.adultMale; }
    public int getAdultFemale(){ return this.adultFemale; }
    public int getChildOver8(){ return this.childOver8; }
    public int getChildUnder8(){ return this.childUnder8; }
    public int getFamilyId(){ return this.familyId; }
    public NutritionalItems getIndividualWeeklyNutritionalNeeds() { return this.individualWeeklyNutritionalNeeds; }

    /**
     *  ---------------------- setters ------------------------
     *  void setHamper( Hamper: hamper )
     *  setAdultMale( int: num )
     *  setAdultFemale( int: num )
     *  setChildOver8( int: num )
     *  setChildUnder8( int: num )
     *  setIndividualWeeklyNutritionalNeeds( NutritionalItems: individualWeeklyNutritionalNeeds )
     */
    public void setHamper( Hamper hamper ){ this.hamper = hamper; }
    public void setAdultMale( int num ){ this.adultMale = num; }
    public void setAdultFemale( int num ){ this.adultFemale = num; }
    public void setChildOver8( int num ){ this.childOver8 = num; }
    public void setChildUnder8( int num ){ this.childUnder8 = num; }
    public void setFamilyId( int Id ){ this.familyId = Id; }
    public void setIndividualWeeklyNutritionalNeeds( NutritionalItems individualWeeklyNutritionalNeeds ) {
        this.individualWeeklyNutritionalNeeds = individualWeeklyNutritionalNeeds; }
}
