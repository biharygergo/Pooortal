package src;
import java.util.Scanner;

/**
 * The engine of the game. Creeates the map with list of items, handles the player movement.
 */
public class GameEngine {

    static int tab;

    public GameEngine() {
        GameEngine.tab=0;
    }

    private static Player oNeill;
    private static Player Jaffa;
    private static Replicator replicator;
    private static Modules activeModules;
    private static FieldMap map;
    private static Wormhole oNeillHole;
    private static Wormhole JaffaHole;

    /**
     * Creeates the map and starts to run the program
     */
    public void start() {
        // TODO implement here

    }

    /**
     * Ends the game
     */
    public static void endGame() {
        // TODO implement here
        GameEngine.print("GameEngine.endGame - Game has ended");

    }

    public static void loadMap(String filename) {


    }

    public static void print(String s){
        for(int i=0;i<tab;i++)
            System.out.print("\t");
        System.out.println(s);
    }

    public static void main(String[] args){
        Player player=new Player();

        String line = "0";
        Scanner scan= new Scanner(System.in);
        String elements[] = new String[10];

        while (true){

            line = scan.nextLine();
            elements = line.split(" ");

            try {
                switch (elements[0]) {
                    case "loadMap":
                       loadMap(elements[1]);
                        break;

                    case "randomizeReplicator":
                        boolean value;
                        if (elements[1].equals("true"))
                            value = true;
                        else if (elements[1].equals("false"))
                            value = false;
                        else {
                            System.out.println("Incorrect parameter");
                            break;
                        }

                        replicator.randomizeReplicator(value);
                        break;

                    case "oNeilMove":
                        Dir oNeillMoveDir;
                        Field oNeillNewField = new Road(); //TODO: comment it out

                        switch (elements[1]){
                            case "J":
                                oNeillMoveDir = Dir.Left;
                                break;
                            case "I":
                                oNeillMoveDir = Dir.Up;
                                break;
                            case "L":
                                oNeillMoveDir = Dir.Right;
                                break;
                            case "K":
                                oNeillMoveDir = Dir.Down;
                                break;
                            default:
                                System.out.println("Incorrect direction parameter. Dir returned as null may cause problem");
                                oNeillMoveDir = null;
                                break;
                        }

                        //TODO: write the moving logic
                        oNeill.setField(oNeillNewField);

                        break;

                    case "jaffaMove":
                        Dir JaffaMoveDir;
                        Field JaffaNewField = new Road(); //TODO: comment it out

                        switch (elements[1]){
                            case "A":
                                JaffaMoveDir = Dir.Left;
                                break;
                            case "W":
                                JaffaMoveDir = Dir.Up;
                                break;
                            case "D":
                                JaffaMoveDir = Dir.Right;
                                break;
                            case "S":
                                JaffaMoveDir = Dir.Down;
                                break;
                            default:
                                System.out.println("Incorrect direction parameter. Dir returned as null may cause problem");
                                JaffaMoveDir = null;
                                break;
                        }

                        //TODO: write the moving logic
                        Jaffa.setField(JaffaNewField);

                        break;

                    case "oNeilShootBullet":
                        switch (elements[1]){
                            case "B":
                                oNeill.shootColor1();
                                break;
                            case "Y":
                                oNeill.shootColor2();
                                break;
                            default:
                                System.out.println("Incorrect color parameter for oNeill. Valid parameters are 'B' or 'Y'");
                                break;
                        }
                        break;

                    case "JaffaShootBullet":
                        switch (elements[1]){
                            case "R":
                                Jaffa.shootColor1();
                                break;
                            case "G":
                                Jaffa.shootColor2();
                                break;
                            default:
                                System.out.println("Incorrect color parameter for Jaffa. Valid parameters are 'R' or 'G'");
                                break;
                        }
                        break;

                    case "oNeilDropBox":
                        oNeill.dropBox();
                        break;

                    case "jaffaDropBox":
                        Jaffa.dropBox();
                        break;

                    case "oNeilSetBox":
                        Box oNeillBox = new Box(); //TODO: comment it out

                        //TODO: write the logic

                        oNeill.setBox(oNeillBox);
                        break;

                    case "jaffaSetBox":
                        Box JaffaBox = new Box(); //TODO: comment it out

                        //TODO: write the logic

                        Jaffa.setBox(JaffaBox);
                        break;

                    case "listBoxes":
                        activeModules.listBoxes();
                        break;

                    case "listZPM":
                        activeModules.listZPM();
                        break;

                    case "listFields":
                        map.listFields();
                        break;

                    case "listScalesDoors":
                        map.listFields();
                        break;

                    case "listSpecialWalls":
                        map.listSpecialWalls();
                        break;

                    case "listBullets":
                        activeModules.listBullets();
                        break;

                    case "listWormholes":
                        oNeillHole.listWormhole();
                        JaffaHole.listWormhole();
                        break;

                    case "listPlayers":
                        oNeill.listPlayer();
                        Jaffa.listPlayer();
                        break;

                    case "listReplicator":
                        replicator.listReplicator();
                        break;

                    default:
                        System.out.println("Not a valid statement.");
                }
            }catch (Exception e){
                System.out.println("Error in statement: " + e);
            }

        }
    }
}