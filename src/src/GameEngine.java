package src;

import java.util.HashMap;
import java.util.Scanner;


/**
 * 
 */
public class GameEngine {

    static int tab;

    public GameEngine() {
        GameEngine.tab=0;
    }

    private Player oNeill;

    private Modules activeModules;

    private FieldMap map;

    private Wormhole wormhole;

    public void start() {
        // TODO implement here



    }

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

        String input = "0";
        Scanner scan= new Scanner(System.in);

        while (true){
            switch (input){
                case "0":
                   // input=scan.nextLine();
                    System.out.println("1. Játék indítása");
                    System.out.println("2. Mezőre lépés");
                    System.out.println("3. Szakadékba lépés");
                    System.out.println("4. Falra lövés");
                    System.out.println("5. Specfalra lövés");
                    System.out.println("6. Doboz felvétele");
                    System.out.println("7. Doboz lerakása");
                    System.out.println("8. Doboz szakadékba esik");
                    System.out.println("9. ZPM felvétele");
                    System.out.println("11. Ajtó nyitása");
                    System.out.println("12. Féregjáraton átjárás");
                    System.out.println("13. Kilépés");
                    System.out.println("14. Játék indítása");

                    input=scan.nextLine();

                    break;
                case "1":
                    FieldMap map = new FieldMap("proba.txt");

                    Field startField;

                    print("Van beolvasható térképfájl? Y/N");
                    String line=scan.nextLine();

                    if(line.equals("Y")) {
                        startField = map.getstartField();
                        modules.initializeModules("proba.txt", startField);
                        Player p1 = new Player();
                        Wormhole wormhole = new Wormhole();
                        p1.setField(startField);
                    }

                    input="0";
                    break;
                case "2":

                    Field f2 = player.getField();

                    Dir dir2 = player.getDir();

                    Field nextField = player.getNextField();

                    Item m = modules.searchModule(nextField);

                    if(m==null){
                        if(nextField.steppable()) {
                            player.setField(nextField);
                            nextField.onStep(player);
                        }
                        else{
                            player.setField(f2);
                            nextField.onStep(player);
                        }
                    }
                    else{
                        m.onStep(player);
                    }

                    input="0";
                    break;
                case "3":


                    Gap gap = new Gap();
                    player.setField(gap);
                    gap.onStep(player);

                    player.isAlive();

                    input="0";


                    break;

                case "4":


                    Bullet bullet4=new Bullet();
                    Wall wall=new Wall();
                    wall.onShoot(bullet4, new Wormhole());


                    input="0";
                    break;
                case "5":
                    Bullet bullet5=new Bullet();
                    SpecialWall specialWall=new SpecialWall();
                    specialWall.onShoot(bullet5, new Wormhole());
                    input="0";
                    break;
                case "6":
                    Field f6=player.getField();
                    Dir dir6=player.getDir();
                    Field nextf6=player.getNextField();
                    Box box6=player.getBox();

                    if(box6==null) {
                        Item m6 = modules.searchModule(nextf6);

                        if (m6 != null) {
                            m6.onUse(player);

                        }
                    }
                    input="0";
                    break;
                case "7":

                    Field f=player.getField();
                    Dir dir=player.getDir();
                    f=player.getNextField();

                    if(f.steppable()){
                        Modules mod=new Modules();
                        Item m7=mod.searchModule(f);

                        if(m7==null){
                            Box pBox=player.getBox();
                            if(pBox!=null){
                                Box b=player.dropBox();

                            }
                        }
                    }
                    else{
                        break;
                    }
                    input="0";
                    break;
                case "8":
                    Field f8=player.getField();
                    Dir dir8=player.getDir();

                    Field nextf8=new Gap();
                    Box hasBox=player.getBox();
                    //Nincs jobb ötletem: a szakadékra úgy teszünk, mintha rálépnénk,
                    //szakadékban ledobjuk a dobozt, ha a player nem rajta áll
                    //a korábban megkérdezett dobozt pedig szépen kitöröljük a listából
                    if(hasBox!=null) {
                        nextf8.onStep(player);
                        //if(player.getBox())

                        modules.removeBox(hasBox);
                        // Box b8=player.dropBox();


                    }
                    input="0";
                    break;


                case "9":

                    Field f9=player.getField();
                    Dir dir9=player.getDir();
                    Field nextf9=player.getNextField();

                    Item m9=modules.searchModule(nextf9);
                    if(m9!=null){
                        player.setField(nextf9);
                        m9.onStep(player);
                    }
                    input="0";
                    break;
                case "11":
                    Scale scale = new Scale();
                    scale.onStep(player);
                    input="0";
                    break;
                case "12":
                    SpecialWall sw = new SpecialWall();

                    if (sw.steppable())
                        sw.onStep(player);


                    input="0";
                    break;

                case "13":

                    GameEngine.print("Kilépést nyomtunk? Y/N");
                    Scanner scan13 = new Scanner(System.in);
                    String line13 = scan.nextLine();

                    if (line13.equals("Y"))
                        GameEngine.endGame();
                    else {
                        player.isAlive();
                        GameEngine.endGame();
                    }
                    input="0";
                    break;

            }

            System.out.println();
      }
    }

}