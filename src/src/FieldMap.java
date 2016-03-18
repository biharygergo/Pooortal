package src;

/**
 * 
 */
public class FieldMap {

    /**
     * Default constructor
     */
    public FieldMap() {
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
        // TODO implement here
        GameEngine.print("FieldMap.create - created a new Map");

    }

    /**
     * @return
     */
    public Field getstartField() {
        // TODO implement here
        GameEngine.print("FieldMap.getstartField - returned first Field of the Map");


        return null;
    }

    /**
     * @param field 
     * @return
     */
    public void setstartField(Field field) {
        GameEngine.print("FieldMap.getstartField - set first Field of the Map");

        // TODO implement here

    }

}