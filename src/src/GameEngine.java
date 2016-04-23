package src;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
    private static Modules activeModules = new Modules();
    private static FieldMap map = new FieldMap();
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
        Field startField;
        Field current = null;
        boolean startFieldsetted = false;
        String cells[] = new String[10];

        Map<Dir, Field> sides = new HashMap<>();
        sides.put(Dir.Up, null);
        sides.put(Dir.Down, null);
        sides.put(Dir.Left, null);
        sides.put(Dir.Right, null);

        int xSize = 6;
        int ySize = 6;
        int currentRow = 0;

        ArrayList<Field> first = new ArrayList<>();
        ArrayList<Field> second = new ArrayList<>();

        for (int i = 0; i < xSize; i++) {
            first.add(null);
        }

        try(
            BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String line = " ";

                while (currentRow < ySize) { //végig a sorokon

                    line = br.readLine();
                    cells = line.split(";");

                    for (int i = 0; i < xSize; i++) { // végig az oszlopokon
                        switch (cells[i]){
                            case "Wall":
                                current = new Wall();
                                break;
                            case "Road":
                                current = new Road();
                                break;
                            case "Scale":
                                current = new Scale();
                                break;
                            case "Gap":
                                current = new Gap();
                                break;
                            case "Door":
                                current = new Door();
                                break;
                            case "SpecialWall":
                                current = new SpecialWall();
                                break;
                            case "Box":
                                current = new Road();
                                Box box = new Box(current, 0);
                                activeModules.addBox(box);
                                break;
                            default:
                                System.out.println("Error in input map file!");
                                break;
                        }

                        if (!startFieldsetted){
                            map.setstartField(current);
                            startFieldsetted = true;
                        }

                        second.add(current);

                    }

                    for (int i = 0; i < xSize; i++) {
                        sides.clear();
                        sides.put(Dir.Up, first.get(i));

                        sides.put(Dir.Down, null);

                        if (i > 0)
                            sides.put(Dir.Left, second.get(i - 1));
                        else
                            sides.put(Dir.Left, null);

                        if (i < xSize-1)
                            sides.put(Dir.Right, second.get(i + 1));
                        else
                            sides.put(Dir.Right, null);

                        if (first.get(i) != null) {
                            first.get(i).setSide(Dir.Down, second.get(i));
                        }
                        second.get(i).setPos(currentRow+1, i+1);
                        second.get(i).setSides(sides);
                    }


                    currentRow++;

                    first.clear();

                    for (int i = 0; i < second.size(); i++) {
                        first.add(second.get(i));
                    }


                    second.clear();

                }

            //Pálya további elemei:
            activeModules.getBox(0).setWeight(5);
            activeModules.getBox(1).setWeight(10);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void print(String s){
        for(int i=0;i<tab;i++)
            System.out.print("\t");
        System.out.println(s);
    }

    public static void main(String[] args){
        Player player=new Player();
        boolean inGame = true;

        String line = "loadMap d";
        Scanner scan= new Scanner(System.in);
        String elements[] = new String[10];

        Field randomField = new Road(); //TODO: just for testing

        while (inGame){

            line = scan.nextLine();

            elements = line.split(" ");

            try {
                switch (elements[0]) {
                    case "loadMap":
                       elements[1] = "src/map.csv"; //TODO: ez majd kiszedhető, csak akkor nem kell mindig beírni
                        loadMap(elements[1]);
                        map.listFields();
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

                        movePlayer(oNeill, oNeillMoveDir);
                        break;

                    case "jaffaMove":
                        Dir JaffaMoveDir;

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

                        movePlayer(Jaffa, JaffaMoveDir);
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
                        Box oNeillBox = new Box(randomField, 5); //TODO: comment it out

                        //TODO: write the logic

                        oNeill.setBox(oNeillBox);
                        break;

                    case "jaffaSetBox":
                        Box JaffaBox = new Box(randomField, 5); //TODO: comment it out

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
                        oNeillHole.listWormhole(1);
                        JaffaHole.listWormhole(2);
                        break;

                    case "listPlayers":
                        oNeill.listPlayer(1);
                        Jaffa.listPlayer(2);
                        break;

                    case "listReplicator":
                        replicator.listReplicator(1);
                        break;

                    //Todo: document: exittel lehet kilépni és kapunk egy ajándék verset
                    case "Exit":
                        inGame = false;
                        System.out.println("Megtiszteltetés volt, hogy velünk játszottál!\n" +
                                "Engedd meg, hogy Tóth Beáta Mária Viszlát! című versével búcsúzzunk és köszönjük meg az együtt töltött perceket:\n");
                        System.out.println("Viszlát! Ha menned kell, menj! \n" +
                                "De holnap ugyanitt találkozunk \n" +
                                "Reggel újra itt leszel \n" +
                                "S addig mint álom, elém tárul \n" +
                                "\n" +
                                "Viszlát! Tudom, hogy menned kell... \n" +
                                "De várj még egy percet! \n" +
                                "Még egy érintés, egy pillantás \n" +
                                "Mert messze van a reggel \n" +
                                "\n" +
                                "Viszlát! Indulj végre el! \n" +
                                "Úgyis fáj látnom \n" +
                                "Ahogy távolodsz tőlem \n" +
                                "Fáj, és már hiányzol!\n");
                        break;

                    default:
                        System.out.println("Not a valid statement.");
                }
                System.out.println();
            }catch (Exception e){
                System.out.println("Error in statement: " + e);
            }

        }
    }

    private static void movePlayer(Player player, Dir playerMoveDir) {
        if (player.getDir().equals(playerMoveDir)) {
            movePlayerTowardsHisActualDirIfNoBarrierAhead(player);
        } else {
            oNeill.setDir(playerMoveDir);
        }
    }

    private static void movePlayerTowardsHisActualDirIfNoBarrierAhead(Player player) {
        Field nextField = player.getNextField();

        if (!isBarrierAhead(nextField)) {
            player.setField(nextField);
            nextField.onStep(player);
        }
    }

    private static boolean isBarrierAhead(Field nextField) {
        boolean isBarrierAhead = false;

        if (!nextField.steppable() || nextFieldHasActiveBox(nextField)) {  //FIXME: egyéb?
            isBarrierAhead = true;
        }

        return isBarrierAhead;
    }

    private static boolean nextFieldHasActiveBox(Field nextField) {
        boolean nextFieldHasActiveBox = false;

        Item itemOnNextField = activeModules.searchModule(nextField);
        if (itemOnNextField != null && itemOnNextField instanceof Box) {
            if (((Box) itemOnNextField).isAlive()) {
                nextFieldHasActiveBox = true;
            }
        }

        return nextFieldHasActiveBox;

        //FIXME: Elég lenne ez, mert úgyis fixen előbb vesszük ki a dobozt a listából, mint hogy ez lefut? Egyelőre sztem maradjon.
        //return (activeModules.searchModule(nextField) instanceof Box) ? true : false;
    }

}