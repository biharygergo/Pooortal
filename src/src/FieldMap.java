package src;

/**
 * Represents the map
 */
public class FieldMap {

    /**
     * The player is put on this field at the beginning
     */
    private Field startField;

    /**
     * Default constructor
     */
    public FieldMap() {

    }

    /**
     * @return Returns the start field
     */
    public Field getstartfield() {
        return startField;
    }

    /**
     * Sets the start field
     * @param field the field where the start field should be
     */
    public void setStartField(Field field) {
       startField = field;
    }

    /**
     * Get field at the given position (x, y)
     * @param x
     * @param y
     * @return
     */
    public Field getFieldAtPos(int x, int y){
        Field current = startField;
        for (int i = 0; i < x-1; i++) {
            current = current.getSide(Dir.Down);
        }

        for (int i = 0; i < y-1; i++) {
            current = current.getSide(Dir.Right);
        }

        return  current;
    }
}