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

    public void endGame() {
        // TODO implement here

    }
    public static void print(String s){
        for(int i=0;i<tab;i++)
            System.out.print("\t");
        System.out.println(s);
    }
    public static void main(String[] args){
        Modules modules = new Modules();

        Player p=new Player();

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
                    FieldMap map= new FieldMap(null);

                    Field startField;

                    print("Van beolvasható térképfájl?");
                    String line=scan.nextLine();

                    if(line.equals("Y")) {
                        map.create("proba.txt");
                        startField = map.getstartField();
                        modules.initializeModules("proba.txt", startField);
                        Player p1 = new Player();
                        Wormhole wormhole = new Wormhole();
                        p1.setField(startField);
                    }

                    input="0";
                    break;
                case "2":
                    Field f2=p.getField();
                    Dir dir2=p.getDir();

                    Field nextField=p.getNextField();

                    Item m=modules.searchModule(nextField);

                    if(m==null){
                        if(nextField.steppable()) {
                            p.setField(nextField);
                            nextField.onStep(p);
                        }
                        else{
                            p.setField(f2);
                            nextField.onStep(p);
                        }
                    }
                    else{
                        m.onStep(p);
                    }
                    input="0";
                    break;
                case "3":
                    Gap gap=new Gap();
                    p.setField(gap);
                    gap.onStep(p);

                    p.isAlive();

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

                case "7":

                    Field f=p.getField();
                    Dir dir=p.getDir();
                    f=p.getNextField();

                    if(f.steppable()){
                        Modules mod=new Modules();
                        Item m7=mod.searchModule(f);

                        if(m7!=null){
                            Box pBox=p.getBox();
                            if(pBox!=null){
                                Box b=p.dropBox();

                            }
                        }
                    }
                    else{
                        break;
                    }
                    input="0";
                    break;

            }

      }
    }

}