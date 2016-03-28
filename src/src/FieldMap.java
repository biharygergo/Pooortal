package src;

/**
 * 
 */
public class FieldMap {

    /**
     * Default constructor
     */
    public FieldMap(String s) {
        create(s);
    }

    /**
     * 
     */
    private Field startField;

    /**
     * 
     */
    private Field fields;

    /**
     * @param string 
     * @return
     */
    public void create(String string) {
        GameEngine.tab++;
        GameEngine.print("FieldMap.create - FieldMap created");
        GameEngine.tab--;
    }

    /**
     * @return
     */
    public Field getstartField() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("FieldMap.getstartField - returned first Field of the Map");
        GameEngine.tab--;

        return null;
    }

    /**
     * @param field 
     * @return
     */
    public void setstartField(Field field) {
        GameEngine.tab++;
        GameEngine.print("FieldMap.getstartField - set first Field of the Map");
        GameEngine.tab--;
        // TODO implement here

    }

}