package src;//import src.Field;
//package src;

import java.util.Scanner;

/**
 * 
 */
public class Player {

    /**
     * Default constructor
     */
    public Player(){
    }

    /**
     * 
     */
    private Field field;

    /**
     * 
     */
    private Dir dir;

    /**
     * 
     */

    private boolean alive;

    /**
     * 
     */
    int collectedZPMs;


    /**
     * 
     */
    private Box box;


    /**
     * @return
     */
    public Box dropBox() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Player.dropBox - Box dropped");
        //Box box=new Box();
        box = null;
        GameEngine.tab--;
        return null;
    }

    /**
     * @return
     */
    public Bullet shootBlue() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Player.shootBlue - Blue bullet shot");
        GameEngine.tab--;
        return null;
    }

    /**
     * @return
     */
    public Bullet shootYellow() {
        // TODO implement here
        GameEngine.tab--;
        GameEngine.print("Player.shootYellow - Yellow bullet shot");
        GameEngine.tab--;
        return null;
    }

    /**
     * @return
     */
    public Field getField() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Player.getField - Returned field");

        Field f=new Road();
        GameEngine.tab--;
        return f;
    }

    /**
     * @param field 
     * @return
     */
    public void setField(Field field) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Player.setField - Field set");
        GameEngine.tab--;
    }

    /**
     * @return
     */
    public Dir getDir() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Player.getDir - Returned direction");
        GameEngine.tab--;
        return Dir.Down;
    }

    /**
     * @param dir 
     * @return
     */
    public void setDir(Dir dir) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Player.setDir - Direction set");
        GameEngine.tab--;

    }

    /**
     * @return
     */
    public Box getBox() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Player.getBox - Returned box");
        GameEngine.print("Van a játékosnál doboz? ");
        Scanner scan=new Scanner(System.in);
        String input=scan.nextLine();

        if(input.equals("Y")){
            Box box=new Box();
            GameEngine.tab--;
            return box;
        }
        GameEngine.tab--;
        return null;
    }

    /**
     * @param box 
     * @return
     */
    public void setBox(Box box) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Player.setBox - Box set");
        GameEngine.tab--;
    }

    /**
     * @return
     */
    public boolean isAlive() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Player.isAlive - Returned player state");
        GameEngine.tab--;
        return false;
    }

    /**
     * @param alive 
     * @return
     */
    public void setAlive(boolean alive) {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Player.setAlive - Player state set");
        GameEngine.tab--;
    }

    /**
     * @return
     */
    public Field getNextField() {
        // TODO implement here
        GameEngine.tab++;
        GameEngine.print("Player.getNextField - Returned next field");

        GameEngine.print("Lehet a következő mezőre lépni? Y / N");
        Scanner scan=new Scanner(System.in);

       String input= scan.nextLine();
        if(input.equals("Y")) {
            Road r=new Road();
            GameEngine.tab--;
            return r;
        }
        else {
            Wall r=new Wall();
            GameEngine.tab--;
            return r;
        }

    }

}