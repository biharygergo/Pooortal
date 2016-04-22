package src;

/**
 * Represents the map
 */
public class FieldMap {

    private int xSize = 4, ySize = 4;

    /**
     * Default constructor
     * @param s calls the create function
     */
    public FieldMap(String s) {
        create(s);
    }

    /**
     * The player is put on this field at the beginning
     */
    private Field startField;

    /**
     * Creates the map with fields and items and the player
     * @param string the path to the file which describes the map
     */
    public void create(String string) {
        GameEngine.tab++;
        GameEngine.print("FieldMap.create - FieldMap created");
        GameEngine.tab--;
    }

    /**
     * @return Returns the start field
     */
    public Field getstartField() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("FieldMap.getstartField - returned first Field of the Map");
        GameEngine.tab--;

        return null;
    }

    /**
     * Sets the start field
     * @param field the field where the start field should be
     */
    public void setstartField(Field field) {
        GameEngine.tab++;
        GameEngine.print("FieldMap.getstartField - set first Field of the Map");
        GameEngine.tab--;
        // TODO implement here

    }

    public void listFields(){
        Field current = startField, first = startField; //current: actual field, first: first field of current row
        for (int i = 0; i < ySize; i++) {

            for (int j = 0; j < xSize ; j++) {
                current.listField(i*xSize+j);
                current = current.getSide(Dir.Right);
            }

            current = first.getSide(Dir.Down);
            first = first.getSide(Dir.Down); //go one field down
        }

    }

    public void listScalesDoors(){}

    public void listSpecialWalls(){}

}