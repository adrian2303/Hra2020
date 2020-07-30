import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lukostrelec extends Hrac {

    public Lukostrelec(String meno) throws FileNotFoundException {
        this.meno = meno;
        File suborCisel = new File("levelLukostrelec.txt");
        Scanner s = new Scanner(suborCisel);
        float level = s.nextFloat();

        if(level >= 1.0 && level <= 1.9){
            this.zivot = 650;
            this.posLuk1 = 65;
            this.posLuk2 = 105;

        }

        System.out.println("Vytvoril sa lukostrelec s menom "+this.meno);
        System.out.println("Život lukostrelca je: " + this.zivot);
        System.out.println("Úder lukostrelca je od "+this.posLuk1+" do "+this.posLuk2);
    }

    public int getRandomNumber(int min, int max){
        return (int) ((Math.random() * (max - min)) + min);
    }

    public void bojSKuzelnikom() throws FileNotFoundException {

        Lukostrelec luk = new Lukostrelec("Miso");
        Kuzelnik mag = new Kuzelnik("Jardo");

        while(luk.zivot > 0 && mag.zivot > 0){

            luk.poskodenie = getRandomNumber(posLuk1,posLuk2);
            mag.poskodenie = getRandomNumber(mag.posMag1,mag.posMag2);

            mag.zivot = mag.zivot - luk.poskodenie;

            if(mag.zivot <= 0){
                System.out.println("Život lukostrelca: " +luk.zivot +" "+"Úder: "+luk.poskodenie+" "+"Život kúzelnika: " + mag.zivot);
                System.out.println("Vyhral si! Lukostrelec vyhral!");
                break;
            }

            luk.zivot = luk.zivot - mag.poskodenie;
            System.out.println("Život lukostrelca: " +luk.zivot +" "+"Úder: "+luk.poskodenie+" "+"Život kúzelnika: " + mag.zivot+" "+"Úder: "+mag.poskodenie);
            if(luk.zivot <= 0) {System.out.println("Prehral si! Kúzelník vyhral!");}
        }
    }

    public void bojSBojovnikom() throws FileNotFoundException {

        Lukostrelec luk = new Lukostrelec("Miso");
        Bojovnik war = new Bojovnik("Ferko");

        while(luk.zivot > 0 && war.zivot > 0){

            luk.poskodenie = getRandomNumber(posLuk1,posLuk2);
            war.poskodenie = getRandomNumber(war.posWar1,war.posWar2);

            war.zivot = war.zivot - luk.poskodenie;

            if(war.zivot <= 0){
                System.out.println("Život lukostrelca: " +luk.zivot +" "+"Úder: "+luk.poskodenie+" "+"Život bojovníka: " + war.zivot);
                System.out.println("Vyhral si! Lukostrelec vyhral!");
                break;
            }

            luk.zivot = luk.zivot - war.poskodenie;
            System.out.println("Život lukostrelca: " +luk.zivot +" "+"Úder: "+luk.poskodenie+" "+"Život bojovníka: " + war.zivot+" "+"Úder: "+war.poskodenie);
            if(luk.zivot <= 0){ System.out.println("Prehral si! Bojovník vyhral!"); }
        }
    }
}
