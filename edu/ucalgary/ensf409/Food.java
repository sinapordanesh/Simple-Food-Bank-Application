package edu.ucalgary.ensf409;

public class Food {

    private final int ITEMID;
    private final String NAME;
    private final NutritionalItems NUTRITIONALITEMS;

    Food(int id, String name, int wG, int fV, int p, int o, int c){
        ITEMID = id;
        NAME = name;
        NUTRITIONALITEMS = new NutritionalItems(wG, fV, p, o, c);
    }

    public int getItemId() {
        return ITEMID;
    }

    public String getName() {
        return NAME;
    }

    public NutritionalItems getNutritionalItems() {
        return NUTRITIONALITEMS;
    }
}
