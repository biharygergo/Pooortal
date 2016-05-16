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

    ArrayList<Scale> scales = new ArrayList<>();

    public static int xSize = 17;
    public static int ySize = 17;

    GameEngine() {}

    /**
     * Ends the game
     */
    public boolean endGame() {
        if(oNeill!=null && Jaffa!=null) {
            if (!oNeill.isAlive() || !Jaffa.isAlive() || activeModules.noMoreZPM()) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param filename
     */
    public void loadMap(String filename) {
        activeModules.clearAll();
        Field current = null;
        boolean startFieldSetted = false;
        String cells[];

        Map<Dir, Field> sides = new HashMap<>();
        sides.put(Dir.Up, null);
        sides.put(Dir.Down, null);
        sides.put(Dir.Left, null);
        sides.put(Dir.Right, null);


        int currentRow = 0;

        ArrayList<Field> first = new ArrayList<>();
        ArrayList<Field> second = new ArrayList<>();

        ArrayList<Door> doors = new ArrayList<>();

        for (int i = 0; i < xSize; i++) {
            first.add(null);
        }

        try(
            BufferedReader br = new BufferedReader(new FileReader(filename))) {
                String line;

                while (currentRow < ySize) { /* végig a sorokon */

                    line = br.readLine();
                    cells = line.split(",");

                    for (int i = 0; i < xSize; i++) { // végig az oszlopokon
                        //System.out.println(cells[i]);
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
                                break;
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
                        int test = currentRow+1;
                        int test2 = i+1;
                       // System.out.println(test + " " + test2);
                        second.get(i).setSides(sides);
                    }

                    currentRow++;

                    first.clear();

                    first.addAll(second);
                    second.clear();


                }

            activeModules.initializeModules("res/csv/modules_2.csv", map.getstartField());
            JaffaHole.primaryColor=Color.Red;
            JaffaHole.secondaryColor=Color.Red.next();

            oNeillHole.primaryColor=Color.Blue;
            oNeillHole.secondaryColor=Color.Yellow;

        } catch (IOException e) {
            e.printStackTrace();
        }

        initiatePlayersAndReplicator(first, currentRow);
        initializeScales("res/csv/scale.csv",  doors);
    }

    /**
     *
     * @param filename
     * @param doors
     */
    private void initializeScales(String filename, ArrayList<Door> doors){
        try(
                BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            String cells[] = new String[10];
            int i = 0;
            while (line != null) { //végig a sorokon

                cells = line.split(",");
                scales.get(i).setDoor(doors.get(Integer.parseInt(cells[1])-1));
                doors.get(Integer.parseInt(cells[1])-1).setScale(scales.get(i));
                scales.get(i).setMinWeight(Integer.parseInt(cells[2]));
               // doors.get(i).setRotated(Integer.parseInt(cells[3]) == 1 ? true : false);

                if(cells[3].equals('1')){
                    doors.get(Integer.parseInt(cells[1])).setRotated(true);
                }


                i++;
                line = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     *
     * @param fieldListInARow
     * @param currentRow
     */
    private void initiatePlayersAndReplicator(ArrayList<Field> fieldListInARow, int currentRow) {

            Jaffa = new Player(map.getFieldAtPos(2,2), Dir.Up, 6, Color.Red);

            oNeill = new Player(map.getFieldAtPos(16,16), Dir.Up, 5, Color.Blue);

            replicator = new Replicator(map.getFieldAtPos(14,2), Dir.Up);

    }

    /**
     *
     */
    public void updateBullets(){

        List<Bullet> bullets = activeModules.getBullets();


            for (Bullet bullet:bullets
                    ) {
                Field nextField = bullet.getNextField();
                Field oldField = bullet.getField();
                if(replicator.getField().equals(nextField) && replicator.isAlive()) {

                        replicator.onShoot(bullet);
                        activeModules.checkBullets();


                }
                else {

                    Field oldWall = JaffaHole.getColor1();
                    Field oldWall2 = JaffaHole.getColor2();
                    Field oldWall3 = oNeillHole.getColor1();
                    Field oldWall4 = oNeillHole.getColor2();

                    nextField.onShoot(bullet,oNeillHole,JaffaHole);
                    activeModules.checkBullets();

                    if(oldWall!=null){
                        AnimateOneField(oldWall);
                    }
                    if(oldWall2!=null){
                        AnimateOneField(oldWall2);
                    }
                    if(oldWall3!=null){
                        AnimateOneField(oldWall3);
                    }
                    if(oldWall4!=null){
                        AnimateOneField(oldWall4);
                    }

                }

                AnimateOneField(oldField);
                AnimateOneField(nextField);


            }

        activeModules.checkBullets();
        
    }

    /**
     *
     * @param element
     */
    public void oNeillMove(String element) {
        Dir oNeillMoveDir = null;
        element = element.toUpperCase();
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
                System.out.println("Incorrect direction parameter. Valid parameters are 'I' or 'J' or 'K' or 'L'");
                break;
        }

        movePlayer(oNeill, oNeillMoveDir);


    }

    /**
     *
     * @param element
     */
    public void jaffaMove(String element) {
        Dir JaffaMoveDir = null;
        element = element.toUpperCase();
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
                System.out.println("Incorrect direction parameter. Valid parameters are 'W' or 'A' or 'S' or 'D'");
                break;
        }

        movePlayer(Jaffa, JaffaMoveDir);
    }

    /**
     *
     * @param element
     */
    public void oNeillShootBullet(String element) {
        Bullet shot;
        element = element.toUpperCase();
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

    /**
     *
     * @param element
     */
    public void jaffaShootBullet(String element) {
        Bullet shot;
        element = element.toUpperCase();
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

    /**
     *
     */
    public void oNeilDropBox(){
        if (oNeill.getBox() != null) {
            Field maybeGap = oNeill.getNextField();
            //Kvazi-Ralepunk de a player fieldjet nem allitottuk at!
            if(maybeGap.steppable() || maybeGap.getDescription().equals("Scale")) {
                maybeGap.onStep(oNeill);
                Box box = oNeill.dropBox();
                activeModules.checkBoxes();

                if(box!=null) {
                    if (box.getField().getDescription().equals("Scale")) {
                        Scale scale = (Scale) box.getField();
                        AnimateOneField(scale.getDoor());
                    }
                }
            }
        }

        AnimateOneField(oNeill.getField());
        AnimateOneField(oNeill.getNextField());
    }

    /**
     *
     */
    public void oNeilGetBox(){
        setBoxForPlayer(oNeill);


    }

    /**
     *
     */
    public void jaffaDropBox(){
        if (Jaffa.getBox() != null) {

            Field maybeGapJaffa = Jaffa.getNextField();
            if(maybeGapJaffa.steppable() || maybeGapJaffa.getDescription().equals("Scale")) {
                maybeGapJaffa.onStep(Jaffa);
                Box box = Jaffa.dropBox();
                activeModules.checkBoxes();

                if(box!=null) {
                    if (box.getField().getDescription().equals("Scale")) {
                        Scale scale = (Scale) box.getField();
                        AnimateOneField(scale.getDoor());
                    }
                }
            }

        }

        AnimateOneField(Jaffa.getField());
        AnimateOneField(Jaffa.getNextField());
    }

    /**
     *
     */
    public void jaffaGetBox(){
        setBoxForPlayer(Jaffa);
    }

    public Modules getActiveModules() {
        return activeModules;
    }

    public String getExitString() {
        return "Megtiszteltetés volt, hogy velünk játszottál!\n" +
                "Engedd meg, hogy Tóth Beáta Mária Viszlát! című versével búcsúzzunk és köszönjük meg az együtt töltött perceket:\n\n" +

                "Viszlát! Ha menned kell, menj! \n" +
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
                "Fáj, és már hiányzol!\n\n" +
                "Kattints az OK gombra a kilépéshez!";
    }

    /**
     *
     * @param replicatorMoveDir
     */
    public void moveReplicator(Dir replicatorMoveDir) {
        if (replicatorMoveDir != null) {
            if (replicator.isAlive()) {
                if (replicator.getDir().equals(replicatorMoveDir)) {
                    Field old = replicator.getField();
                    moveReplicatorTowardsHisActualDirIfNoBarrierAhead();
                    AnimateOneField(old);
                    AnimateOneField(replicator.getField());
                } else {
                    replicator.setDir(replicatorMoveDir);
                    AnimateOneField(replicator.getField());
                }
            }
        }
    }

    /**
     *
     */
    private void moveReplicatorTowardsHisActualDirIfNoBarrierAhead() {
        Field nextField = replicator.getNextField();

        if (!isBarrierAheadReplicator(nextField,replicator)) {
            replicator.setField(nextField);
            nextField.onReplicatorStep(replicator);
        }
    }

    /**
     *
     * @param player
     * @param playerMoveDir
     */
    private void movePlayer(Player player, Dir playerMoveDir) {
        int oldZPM = activeModules.getCollectedZPMs();
        if (playerMoveDir != null) {
            if (player.getDir().equals(playerMoveDir)) {
                Field old = player.getField();
                Scale scale= player.onThisScale;


                movePlayerTowardsHisActualDirIfNoBarrierAhead(player);
                AnimateOneField(old);
                AnimateOneField(player.getField());
                if (scale != null)
                    AnimateOneField(scale.getDoor());

            } else {
                player.setDir(playerMoveDir);
                AnimateOneField(player.getField());
            }
        }

        if (player.onThisScale != null)
            AnimateOneField(player.onThisScale.getDoor());

        if (oldZPM != activeModules.getCollectedZPMs()){
            for (ZPM zpm : activeModules.getZPMs()) {
                AnimateOneField(zpm.getField());
            }
        }
    }

    /**
     *
     * @param player
     */
    private void movePlayerTowardsHisActualDirIfNoBarrierAhead(Player player) {
        Field nextField = player.getNextField();

        if (!isBarrierAhead(nextField, player)) {

            player.setField(nextField);
            nextField.onStep(player);
        }
    }

    /**
     *
     * @param nextField
     * @param replicator
     * @return
     */
    private boolean isBarrierAheadReplicator(Field nextField, Replicator replicator) {
        boolean isBarrierAhead = false;

        if (!nextField.steppable() || nextFieldHasActiveBoxReplicator(nextField, replicator)) {
            isBarrierAhead = true;
        }

        return isBarrierAhead;
    }

    /**
     *
     * @param nextField
     * @param replicator
     * @return
     */
    private boolean nextFieldHasActiveBoxReplicator(Field nextField, Replicator replicator) {
        boolean nextFieldHasActiveBox = false;

        Item itemOnNextField = activeModules.findBox(nextField);
        if (itemOnNextField != null && itemOnNextField instanceof Box) {
            if (((Box) itemOnNextField).isAlive()) {
                nextFieldHasActiveBox = true;
            }
        }


        return nextFieldHasActiveBox;
    }

    /**
     *
     * @param nextField
     * @param player
     * @return
     */
    private boolean isBarrierAhead(Field nextField, Player player) {
        boolean isBarrierAhead = false;

        if (!nextField.steppable() || nextFieldHasActiveBox(nextField, player)) {
            isBarrierAhead = true;
        }

        return isBarrierAhead;
    }

    /**
     *
     * @param nextField
     * @param player
     * @return
     */
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
                activeModules.addNewZPMToRandomFieldIfNeccessary((ZPM) itemOnNextField);
                activeModules.removeZPM((ZPM) itemOnNextField);
            }
        }

        return nextFieldHasActiveBox;
    }

    /**
     *
     * @param player
     */
    private void setBoxForPlayer(Player player) {
        Field nextField = player.getNextField();


        if (player.getBox() == null && nextFieldHasActiveBox(nextField,player)) {
            if(nextField instanceof Scale){
                Scale scale = (Scale) nextField;
                Box removal = scale.getBoxOnTop();

                scale.removeBox(removal);

                removal.onUse(player);
                AnimateOneField(scale.getDoor());
                AnimateOneField(scale);
            }
            else {
                Box steppedOn = (Box) activeModules.searchModule(nextField);
                steppedOn.onUse(player);
            }
        }

        AnimateOneField(nextField);
        AnimateOneField(player.getField());

    }

    /**
     *
     */
    public void Animate() {
        Field currentField;

        View view = View.getInstance();
        view.Invalidate();
        for(int i = 1; i<=ySize; i++){
            for ( int j = 1 ; j<=xSize; j++) {
                // System.out.print("\t\t");
                currentField = map.getFieldAtPos(i, j);

                view.setFieldImage(currentField);

                if (activeModules.findBox(currentField) != null)
                    view.setBoxImage(activeModules.findBox(currentField));


                if (activeModules.findZPM(currentField) != null)
                    view.setZPMImage(activeModules.findZPM(currentField));

                for (Scale scale: scales) {
                    if (scale == currentField){
                        if (scale.getCurrentWeight() > 0) {
                            view.writeScaleWeight(scale);
                        }
                    }
                }


                if (replicator.getField().equals(currentField) && replicator.isAlive())
                    view.setReplicatorImage(replicator);


                if (Jaffa.getField().equals(currentField) && Jaffa.isAlive())
                    view.setPlayerImage(Jaffa);


                if (oNeill.getField().equals(currentField) && oNeill.isAlive())
                    view.setPlayerImage(oNeill);

            }
           // System.out.print("\n");
            }


    }

    /**
     *
     * @param thisField
     */
    public void AnimateOneField(Field thisField) {

        View view = View.getInstance();
        //view.Invalidate();

        // System.out.print("\t\t");
        Field currentField = thisField;
        view.invalidateField(thisField);

        view.setFieldImage(currentField);

        if (activeModules.findBox(currentField) != null)
            view.setBoxImage(activeModules.findBox(currentField));


        if (activeModules.findZPM(currentField) != null)
            view.setZPMImage(activeModules.findZPM(currentField));

        for (Scale scale: scales) {
            if (scale == currentField){
                view.writeScaleWeight(scale);
            }
        }

        if (replicator.getField().equals(currentField) && replicator.isAlive())
            view.setReplicatorImage(replicator);

        if (Jaffa.getField().equals(currentField) && Jaffa.isAlive())
            view.setPlayerImage(Jaffa);


        if (oNeill.getField().equals(currentField) && oNeill.isAlive())
            view.setPlayerImage(oNeill);

        if (activeModules.findBullet(currentField) != null)
            view.setBulletImage(activeModules.findBullet(currentField));

       // System.out.println(oNeill.getBox());
        // System.out.print("\n");


    }

    /**
     *
     */
    public void moveRandomReplicator(){
        moveReplicator(replicator.setNewRandomField());
    }
}