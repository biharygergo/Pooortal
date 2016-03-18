package src;

import java.util.Scanner;

/**
 * 
 */
public class GameEngine {

    static int tab;

    /**
     * Default constructor
     */
    public GameEngine() {
        GameEngine.tab=2;
    }

    /**
     * 
     */
    private Player oNeill;

    /**
     * 
     */
    private Modules activeModules;

    /**
     * 
     */
    private FieldMap map;

    /**
     * 
     */
    private Wormhole wormhole;

    /**
     * 
     */








    /**
     * @return
     */
    public void start() {
        // TODO implement here

    }

    /**
     * @return
     */
    public void endGame() {
        // TODO implement here

    }
    public static void print(String s){
        for(int i=0;i<tab;i++)
            System.out.print("\t");
        System.out.println(s);
    }
    public static void main(String[] args){

        String input = "0";
        Scanner scan= new Scanner(System.in);

        while (true){
            switch (input){
                case "0":
                   // input=scan.nextLine();
                    System.out.println("1.Játék indítása");
                    System.out.println("2.Mezőre lépés");
                    System.out.println("3.Szakadékba lépés");
                    System.out.println("4.Falra lövés");
                    System.out.println("5.Specfalra lövés");
                    System.out.println("6.Doboz felvétele");
                    System.out.println("7.Doboz lerakása");
                    System.out.println("8.Doboz szakadékba esik");
                    System.out.println("9.ZPM felvétele");
                    System.out.println("11.Ajtó nyitása");
                    System.out.println("12.Féregjáraton átjárás");
                    System.out.println("13.Kilépés");
                    System.out.println("14.Játék indítása");

                    input=scan.nextLine();

                    break;
                case "1":


                    break;
                case "3":
                    break;
            }

      }
    }

}