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

    private Player oNeill;
    private Player Jaffa;
    private Replicator replicator;
    private Modules activeModules = new Modules();
    private FieldMap map = new FieldMap();
    private Wormhole oNeillHole;
    private Wormhole JaffaHole;

    GameEngine() {

    }

    /**
     * Creeates the map and starts to run the program
     */
    public void start() {
        //loadMap("src/map.csv");
        //TODO ez egyelőre nem kell, mert a loadmap egy parancs most a protóban
        run();
    }

    /**
     * Ends the game
     */
    public void endGame() {
        // TODO implement here

    }

    private void loadMap(String filename) {
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
                String line;

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

    private void run(){
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

                    case "replicatorMove":
                        replicatorMove(elements[1]);
                        break;

                    case "oNeilMove":
                        oNeillMove(elements[1]);
                        break;

                    case "jaffaMove":
                        jaffaMove(elements[1]);
                        break;

                    case "oNeilShootBullet":
                        oNeillShootBullet(elements[1]);
                        break;

                    case "JaffaShootBullet":
                        jaffaShootBullet(elements[1]);
                        break;

                    case "oNeilDropBox":
                        oNeill.dropBox();
                        break;

                    case "jaffaDropBox":
                        Jaffa.dropBox();
                        break;

                    case "oNeilSetBox":
                        setBoxForPlayer(oNeill);
                        break;

                    case "jaffaSetBox":
                        setBoxForPlayer(Jaffa);
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
                        exit();
                        break;

                    default:
                        System.out.println("Not a valid statement.");
                }
                System.out.println();
            }catch (Exception e){
                System.out.println("Error in statement: " + e.toString());
            }

        }
    }

    private void replicatorMove(String element) {
        Dir replicatorMoveDir;

        switch (element){
            case "V":
                replicatorMoveDir = Dir.Left;
                break;
            case "G":
                replicatorMoveDir = Dir.Up;
                break;
            case "N":
                replicatorMoveDir = Dir.Right;
                break;
            case "B":
                replicatorMoveDir = Dir.Down;
                break;
            default:
                System.out.println("Incorrect direction parameter. Dir returned as null may cause problem");
                replicatorMoveDir = null;
                break;
        }

        moveReplicator(replicatorMoveDir);
        return;
    }

    private void oNeillMove(String element) {
        Dir oNeillMoveDir;

        switch (element){
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
    }

    private void jaffaMove(String element) {
        Dir JaffaMoveDir;

        switch (element){
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
    }

    private void oNeillShootBullet(String element) {
        switch (element){
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
    }

    private void jaffaShootBullet(String element) {
        switch (element){
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
    }

    private void exit() {
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
    }

    private void moveReplicator(Dir replicatorMoveDir) {
        if (replicator.getDir().equals(replicatorMoveDir)) {
            moveReplicatorTowardsHisActualDirIfNoBarrierAhead();
        } else {
            replicator.setDir(replicatorMoveDir);
        }
    }

    private void moveReplicatorTowardsHisActualDirIfNoBarrierAhead() {
        Field nextField = replicator.getNextField();

        if (!isBarrierAhead(nextField)) {
            replicator.setField(nextField);
        }
    }

    private void movePlayer(Player player, Dir playerMoveDir) {
        if (player.getDir().equals(playerMoveDir)) {
            movePlayerTowardsHisActualDirIfNoBarrierAhead(player);
        } else {
            player.setDir(playerMoveDir);
        }
    }

    private void movePlayerTowardsHisActualDirIfNoBarrierAhead(Player player) {
        Field nextField = player.getNextField();

        if (!isBarrierAhead(nextField)) {
            player.setField(nextField);
            nextField.onStep(player);
        }
    }

    private boolean isBarrierAhead(Field nextField) {
        boolean isBarrierAhead = false;

        if (!nextField.steppable() || nextFieldHasActiveBox(nextField)) {  //FIXME: egyéb?
            isBarrierAhead = true;
        }

        return isBarrierAhead;
    }

    private boolean nextFieldHasActiveBox(Field nextField) {
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

    private void setBoxForPlayer(Player player) {
        Field nextField = player.getNextField();

        if (player.getBox() == null && nextFieldHasActiveBox(nextField)) {
            player.setBox((Box) activeModules.searchModule(nextField));
        }
    }

}