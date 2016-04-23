package src;

/**
 * Represents the map
 */
public class FieldMap {

    private int xSize = 6, ySize = 6;

    /**
     * Default constructor
     *  calls the create function
     */
    public FieldMap() {

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
     //TODO rekurziv letrehozo algoritmust írni! Beallitani elkeszules utan egy startfieldet!
    }

    /**
     * @return Returns the start field
     */
    public Field getstartField() {

        return startField;
    }

    /**
     * Sets the start field
     * @param field the field where the start field should be
     */
    public void setstartField(Field field) {
       startField = field;

    }

    public void listFields(){
        Field current = startField, first = startField; //current: actual field, first: first field of current row
        int number = 1;

        for (int i = 0; i < ySize; i++) {

            for (int j = 0; j < xSize ; j++) {
                //System.out.println(current.getSides());
                current.listField(number);
                current = current.getSide(Dir.Right);
                number++;
            }

            current = first.getSide(Dir.Down);
            first = first.getSide(Dir.Down); //go one field down
        }

    }

    public void listScalesDoors(){
        Field current = startField, first = startField; //current: actual field, first: first field of current row
        int number = 0;

        for (int i = 0; i < ySize; i++) {

            for (int j = 0; j < xSize ; j++) {
                if (current.getDescription().equals("Scale")) {
                    Scale scale = (Scale) current;
                    scale.listScale(number);
                    number++;
                }
                current = current.getSide(Dir.Right);
            }

            current = first.getSide(Dir.Down);
            first = first.getSide(Dir.Down); //go one field down
        }
    }

    public void listSpecialWalls(){
        Field current = startField, first = startField; //current: actual field, first: first field of current row
        int number = 0;

        for (int i = 0; i < ySize; i++) {

            for (int j = 0; j < xSize ; j++) {
                if (current.getDescription().equals("SpecialWall")) {
                    SpecialWall specialwall = (SpecialWall) current;
                    specialwall.listSpecialWall(number);
                    number++;
                }
                current = current.getSide(Dir.Right);
            }

            current = first.getSide(Dir.Down);
            first = first.getSide(Dir.Down); //go one field down
        }
    }

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