import java.io.*;
import java.util.Scanner;

public class Nepriatel extends Hrac {

    public File suborNepriatela;
    public Scanner hodnotaNepriatela;


    public Nepriatel(String meno, int hrac) throws FileNotFoundException {
        this.hrac = hrac;
        this.meno = meno;
        int oblast = 0;

        if(hrac == 1){
            suborNepriatela = new File("pralesKuzelnik.txt");
            hodnotaNepriatela = new Scanner(suborNepriatela);
            oblast = hodnotaNepriatela.nextInt();

        }
        if (oblast == 1) {
            this.zivot = 500;
            this.posNepr1 = 150;
            this.posNepr2 = 200;
            this.uroven = 1;
        } else if (oblast == 2) {
            this.zivot = 600;
            this.posNepr1 = 160;
            this.posNepr2 = 210;
            this.uroven = 2;
        } else if (oblast == 3) {
            this.zivot = 700;
            this.posNepr1 = 170;
            this.posNepr2 = 220;
            this.uroven = 3;
        } else if (oblast == 4) {
            this.zivot = 800;
            this.posNepr1 = 180;
            this.posNepr2 = 230;
            this.uroven = 4;
        } else if (oblast == 5) {
            this.zivot = 900;
            this.posNepr1 = 190;
            this.posNepr2 = 240;
            this.uroven = 5;
        }
        System.out.println("Vytvoril sa nepriateľ " + this.meno + " úrovne " + this.uroven);
        System.out.println("Život nepriateľa je: " + this.zivot);
        System.out.println("Úder nepriateľa je od " + this.posNepr1 + " do " + this.posNepr2);

    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public void bojSKuzelnikom() throws IOException {

        Kuzelnik mag = new Kuzelnik("Fero");
        Nepriatel nepr = new Nepriatel("Medved",1);

        while (mag.zivot > 0 && nepr.zivot > 0) {

            mag.poskodenie = getRandomNumber(mag.posMag1, mag.posMag2);
            nepr.poskodenie = getRandomNumber(posNepr1, posNepr2);

            nepr.zivot = nepr.zivot - mag.poskodenie;

            if(nepr.zivot <= 0){
                System.out.println("Život kúzelníka: " +mag.zivot +" "+"Úder: "+mag.poskodenie+" "+"Život bojovníka: " + nepr.zivot);
                System.out.println("Vyhral si! Kúzelník vyhral!");
                if(suborNepriatela.exists()){
                    hodnotaNepriatela = new Scanner(suborNepriatela);
                    int level = hodnotaNepriatela.nextInt();
                    int novyLevel = level + 1;
                    suborNepriatela.delete();
                    Writer wr = new FileWriter("pralesKuzelnik.txt");
                    wr.write(novyLevel +"");
                    wr.close();
                }
                break;
            }

            mag.zivot = mag.zivot - nepr.poskodenie;
            System.out.println("Život kúzelníka: " +mag.zivot +" "+"Úder: "+mag.poskodenie+" "+"Život bojovníka: " + nepr.zivot+" "+"Úder: "+nepr.poskodenie);
            if(mag.zivot <= 0){ System.out.println("Prehral si! Vyhral bojovník!"); }
        }
    }
}
