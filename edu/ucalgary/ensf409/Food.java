package edu.ucalgary.ensf409;

public class Food {

    private final int ITEMID;
    private final String NAME;
    private final NutritionalItems NUTRITIONALITEMS;

    /**
     * Food class constructor which needs 7 arguments.
     * usually, we will provide these arguments from the
     * sql table, but in testing.
     * @param id
     * @param name
     * @param wG
     * @param fV
     * @param p
     * @param o
     * @param c
     */
    Food(int id, String name, int wG, int fV, int p, int o, int c){
        ITEMID = id;
        NAME = name;
        NUTRITIONALITEMS = new NutritionalItems(wG, fV, p, o, c);
    }

    /**
     * get item id
     * @return
     */
    public int getItemId() {
        return ITEMID;
    }

    /**
     * get item name
     * @return
     */
    public String getName() {
        return NAME;
    }

    /**
     * get the nutritional needs of each item as a
     * NutritionalItems object
     * @return
     */
    public NutritionalItems getNutritionalItems() {
        return NUTRITIONALITEMS;
    }
}
