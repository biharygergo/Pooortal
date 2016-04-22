package src;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.Scanner;

/**
 * The engine of the game. Creeates the map with list of items, handles the player movement.
 */
public class GameEngine {

    static int tab;

    public GameEngine() {
        GameEngine.tab=0;
    }

    /**
     * The player in the game
     */
    private Player oNeill;

    /**
     * The list items in the game
     */
    private Modules activeModules;

    /**
     * Reference to the map
     */
    private FieldMap map;

    /**
     * The wormhole in the game
     */
    private Wormhole wormhole;

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
    public static void print(String s){
        for(int i=0;i<tab;i++)
            System.out.print("\t");
        System.out.println(s);
    }

    public static void main(String[] args){
        Modules modules = new Modules();

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
                        System.out.println("loadmap");
                        System.out.println(elements[1]);
                        break;

                    case "randomizeReplicator":
                        break;

                    case "oNeilMove":
                        break;

                    case "jaffaMove":
                        break;

                    case "oNeilShootBullet":
                        break;

                    case "JaffaShootBullet":
                        break;

                    case "oNeilDropBox":
                        break;

                    case "jaffaDropBox":
                        break;

                    case "oNeilSetBox":
                        break;

                    case "jaffaSetBox":
                        break;

                    case "listBoxes":
                        break;

                    case "listZPM":
                        break;

                    case "listFields":
                        break;

                    case "listScalesDoors":
                        break;

                    case "listSpecialWalls":
                        break;

                    case "listBullets":
                        break;

                    case "listWormholes":
                        break;

                    case " listPlayers":
                        break;

                    case "listReplicator":
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