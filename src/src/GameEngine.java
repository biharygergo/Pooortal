package src;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * The engine of the game. Creeates the map with list of items, handles the player movement.
 */
public class GameEngine {

    private Player oNeill;
    private Player Jaffa;
    private Replicator replicator;
    private Modules activeModules = new Modules();
    private FieldMap map = new FieldMap();
    private Wormhole oNeillHole = new Wormhole();
    private Wormhole JaffaHole = new Wormhole();

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
    public boolean endGame() {
        // TODO implement here
        if(oNeill!=null && Jaffa!=null) {
            if (!oNeill.isAlive() || !Jaffa.isAlive() || activeModules.noMoreZPM()) {
                return true;
            }
        }
        return false;
    }

    private void loadMap(String filename) {
        Field startField;
        Field current = null;
        boolean startFieldSetted = false;
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
        ArrayList<Scale> scales = new ArrayList<>();
        ArrayList<Door> doors = new ArrayList<>();

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
                                scales.add((Scale) current);
                                ((Scale) current).setMinWeight(8); //TODO: ez sem az igazi
                                break;                              //átírtam minWeight settelésre
                            case "Gap":
                                current = new Gap();
                                break;
                            case "Door":
                                current = new Door();
                                doors.add((Door) current);
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

                        if (!startFieldSetted){
                            map.setStartField(current);
                            activeModules.setStartField(current);
                            startFieldSetted = true;
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

                    initiatePlayersAndReplicator(first, currentRow);
                }

           activeModules.initializeModules("src/modules.csv", map.getstartField());
            JaffaHole.primaryColor=Color.Red;
            JaffaHole.secondaryColor=Color.Red.next();

            oNeillHole.primaryColor=Color.Blue;
            oNeillHole.secondaryColor=Color.Yellow;

        } catch (IOException e) {
            e.printStackTrace();
        }

        //Todo: ezt is ki lehetne valahogy írni file-ba. Kérdés hogy érdemes e, mert túl sok ajtó amúgy sincs a pályán
        int i = 0;
        for (Scale scale : scales){
            scale.setDoor(doors.get(i));
            doors.get(i).setScale(scale);
            i++;
        }
    }

    private void initiatePlayersAndReplicator(ArrayList<Field> fieldListInARow, int currentRow) {
        //TODO: rendes programban is valami fix helyre kéne tenni, de map függő, hogy hova!
        if (currentRow == 2) {
            Jaffa = new Player(fieldListInARow.get(1), Dir.Up, 6, Color.Green);
        } else if(currentRow == 3) {
            oNeill = new Player(fieldListInARow.get(3), Dir.Up, 5, Color.Blue);
        } else if (currentRow == 4) {
            replicator = new Replicator(fieldListInARow.get(1), Dir.Up);
        }
    }

    private void run(){
        boolean inGame = true;
        boolean endgame;

        String line = "loadMap d";
        Scanner scan= new Scanner(System.in);
        String elements[] = new String[10];

        Field randomField = new Road(); //TODO: just for testing

        while (inGame){
            endgame = endGame();
            if(endgame){
                inGame = false;
                exit();
            }
            line = scan.nextLine();
            elements = line.split(" ");

           //try {
                switch (elements[0]) {
                    case "loadMap":
                        //elements[1] = "src/map.csv"; //TODO: ez majd kiszedhető, csak akkor nem kell mindig beírni
                        loadMap("src/map.csv"); //Todo: mi lenne ha mégsem kéne beírni a filenevet? úgysem változik soha
                        break;

                    case "replicatorMove":
                        if(elements.length==1) {
                            System.out.println("Missing second parameter!");
                        }
                        else
                            replicatorMove(elements[1]);
                        break;

                    case "oNeilMove":
                        if(elements.length==1) {
                            System.out.println("Missing second parameter!");
                        }
                        else {
                            oNeillMove(elements[1]);
                        }
                        break;

                    case "jaffaMove":
                        if(elements.length==1) {
                            System.out.println("Missing second parameter!");
                        }
                        else
                            jaffaMove(elements[1]);
                        break;

                    case "oNeilShootBullet":
                        if(elements.length==1) {
                            System.out.println("Missing second parameter!");
                        }
                        else
                            oNeillShootBullet(elements[1]);
                        break;

                    case "JaffaShootBullet":
                        if(elements.length==1) {
                            System.out.println("Missing second parameter!");
                        }
                        else
                            jaffaShootBullet(elements[1]);
                        break;

                    case "oNeilDropBox":
                        Field maybeGap = oNeill.getNextField();
                        //Kvazi-Ralepunk de a player fieldjet nem allitottuk at!
                        maybeGap.onStep(oNeill);
                        oNeill.dropBox();
                        break;

                    case "jaffaDropBox":
                        Field maybeGapJaffa = Jaffa.getField();
                        maybeGapJaffa.onStep(Jaffa);
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
                        map.listScalesDoors();
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
                        oNeill.listPlayer(1, "o'Neil");
                        Jaffa.listPlayer(2, "Jaffa");
                        break;

                    case "listReplicator":
                        replicator.listReplicator(1);
                        break;

                    //Todo: document: exittel lehet kilépni és kapunk egy ajándék verset
                    case "Exit":
                        inGame = false;
                        exit();
                        break;

                    case "showMap":
                        Animate();
                        break;
                    //todo: document
                    case "updateBullets":
                        updateBullets();
                        break;

                    case "listGameOver":
                        isGameOver();
                        break;

                    default:
                        System.out.println("Not a valid statement.");
                }
                System.out.println();
            //}catch (Exception e){
             //   System.out.println("Error in statement: " + e.toString());
            //}

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

    private void updateBullets(){

        List<Bullet> bullets = activeModules.getBullets();

            for (Bullet bullet:bullets
                    ) {
                Field nextField = bullet.getNextField();
                if(replicator.getField().equals(nextField)) {
                    replicator.onShoot(bullet);
                }
                else {
                    nextField.onShoot(bullet,oNeillHole,JaffaHole);
                }
            }

        activeModules.checkBullets();
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
        Bullet shot;
        switch (element){
            case "B":
                shot = oNeill.shootColor1();
                activeModules.addBullet(shot);
                break;
            case "Y":
               shot =  oNeill.shootColor2();
                activeModules.addBullet(shot);

                break;
            default:
                System.out.println("Incorrect color parameter for oNeill. Valid parameters are 'B' or 'Y'");
                break;
        }
    }

    private void jaffaShootBullet(String element) {
        Bullet shot;
        switch (element){
            case "R":
                shot = Jaffa.shootColor1();
                activeModules.addBullet(shot);

                break;
            case "G":
                shot = Jaffa.shootColor2();
                activeModules.addBullet(shot);

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

        if (!isBarrierAhead(nextField,null)) {
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

        if (!isBarrierAhead(nextField, player)) {

            player.setField(nextField);
            nextField.onStep(player);
        }
    }

    private boolean isBarrierAhead(Field nextField, Player player) {
        boolean isBarrierAhead = false;

        if (!nextField.steppable() || nextFieldHasActiveBox(nextField, player)) {  //FIXME: egyéb?
            isBarrierAhead = true;
        }

        return isBarrierAhead;
    }

    private boolean nextFieldHasActiveBox(Field nextField, Player player) {
        boolean nextFieldHasActiveBox = false;

        Item itemOnNextField = activeModules.searchModule(nextField);
        if (itemOnNextField != null && itemOnNextField instanceof Box) {
            if (((Box) itemOnNextField).isAlive()) {
                nextFieldHasActiveBox = true;
            }
        }
        else if (itemOnNextField != null && itemOnNextField instanceof ZPM) {
            if (player != null) {
                player.collectedZPMs++;
                if (activeModules.noMoreZPM())
                    exit();
            }
        }


            return nextFieldHasActiveBox;

        //FIXME: Elég lenne ez, mert úgyis fixen előbb vesszük ki a dobozt a listából, mint hogy ez lefut? Egyelőre sztem maradjon.
        //return (activeModules.searchModule(nextField) instanceof Box) ? true : false;
    }

    private void setBoxForPlayer(Player player) {
        Field nextField = player.getNextField();


        if (player.getBox() == null && nextFieldHasActiveBox(nextField,player)) {
            if(nextField instanceof Scale){
                Scale scale = (Scale) nextField;
                scale.removeBox((Box) activeModules.searchModule(nextField));
            }
            Box steppedOn = (Box) activeModules.searchModule(nextField);
            steppedOn.onUse(player);

        }

    }

    private void Animate(){
        Field currentField;
        int maxwidth = 6;
        int maxheight = 6;

        for(int i = 1; i<=maxheight; i++){
            for ( int j = 1 ; j<=maxwidth; j++){
                System.out.print("\t\t");
                currentField = map.getFieldAtPos(i, j);

                 if (oNeill.getField().equals(currentField)) {
                    if(oNeill.isAlive())
                    System.out.print(String.format("%15s","Oneill "+oNeill.getDir().toString().substring(0,1)));

                    continue;
                }
                else if(Jaffa.getField().equals(currentField)) {
                    if(Jaffa.isAlive()) {
                        System.out.print(String.format("%15s", "Jaffa "+Jaffa.getDir().toString().substring(0,1)));
                        continue;
                    }
                }
                else if(replicator.getField().equals(currentField) && replicator.isAlive()) {

                        System.out.print(String.format("%15s", "Replicator "+replicator.getDir().toString().substring(0,1)));
                        continue;

                }

                else if(activeModules.findBox(currentField)!=null) {
                    System.out.print(String.format("%15s","Box "));
                    continue;
                }
                else if (activeModules.findZPM(currentField)!=null) {
                    System.out.print(String.format("%15s","ZPM "));
                    continue;
                }
                else{
                    System.out.print(String.format("%15s",currentField.getDescription()+" "));
                    }
                }

            System.out.print("\n");
            }
        }

    private void isGameOver() {
        if (activeModules.noMoreZPM()) {
            System.out.println("1. True");
        }
        else {
            System.out.println("1. False");
        }
    }



}