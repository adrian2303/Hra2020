import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bojovnik extends Hrac {

    public Bojovnik(String meno) throws FileNotFoundException {
        this.meno = meno;
        File suborCisel = new File("levelBojovnik.txt");
        Scanner s = new Scanner(suborCisel);
        float level = s.nextFloat();

        if(level >= 1.0 && level <= 1.99){
            this.zivot = 1100;
            this.posWar1 = 30;
            this.posWar2 = 70;

        }else if(level >= 2.0 && level <= 2.99){
            this.zivot = 1300;
            this.posWar1 = 40;
            this.posWar2 = 80;
        }else if(level >= 3.0 && level <= 3.99){
            this.zivot = 1500;
            this.posWar1 = 50;
            this.posWar2 = 90;
        }else if(level >= 4.0 && level <= 4.99){
            this.zivot = 1700;
            this.posWar1 = 60;
            this.posWar2 = 100;
        }else if(level >= 5.0 && level <= 9.99){
            this.zivot = 1900;
            this.posWar1 = 70;
            this.posWar2 = 110;
        }
        System.out.println("Vytvoril sa bojovník s menom "+this.meno);
        System.out.println("Život bojovníka je: " + this.zivot);
        System.out.println("Úder bojovníka je od "+this.posWar1+" do "+this.posWar2);

    }

    public int getRandomNumber(int min, int max){
        return (int) ((Math.random() * (max - min)) + min);
    }

    public void bojSKuzelnikom() throws FileNotFoundException {

        Bojovnik war = new Bojovnik("Ferdo");
        Kuzelnik mag = new Kuzelnik("Jardo");

        while(war.zivot > 0 && mag.zivot > 0){

            war.poskodenie = getRandomNumber(posWar1,posWar2);
            mag.poskodenie = getRandomNumber(mag.posMag1,mag.posMag2);

            mag.zivot = mag.zivot - war.poskodenie;

            if(mag.zivot <= 0){
                System.out.println("Život bojovnika: " +war.zivot +" "+"Úder: "+war.poskodenie+" "+"Život kúzelnika: " + mag.zivot);
                System.out.println("Vyhral si! Bojovník vyhral!");
                break;
            }

            war.zivot = war.zivot - mag.poskodenie;
            System.out.println("Život bojovnika: " +war.zivot +" "+"Úder: "+war.poskodenie+" "+"Život kúzelnika: " + mag.zivot+" "+"Úder: "+ mag.poskodenie);
            if(war.zivot <=0 ){ System.out.println("Prehral si! Kúzelník vyhral!"); }
        }
    }

    public void bojSLukostrelcom() throws FileNotFoundException {

        Bojovnik war = new Bojovnik("Ferdo");
        Lukostrelec luk = new Lukostrelec("Lukas");

        while(war.zivot > 0 && luk.zivot > 0) {

            war.poskodenie = getRandomNumber(posWar1,posWar2);
            luk.poskodenie = getRandomNumber(luk.posLuk1,luk.posLuk2);

            luk.zivot = luk.zivot - war.poskodenie;

            if(luk.zivot <= 0){
                System.out.println("Život bojovnika: " + war.zivot + " "+"Úder: "+war.poskodenie+" "+ "Život lukostrelca: " + luk.zivot);
                System.out.println("Vyhral si! Bojovník vyhral!");
                break;
            }

            war.zivot = war.zivot - luk.poskodenie;
            System.out.println("Život bojovnika: " + war.zivot + " "+"Úder: "+war.poskodenie+" "+ "Život lukostrelca: " + luk.zivot+" "+"Úder: "+luk.poskodenie);
            if(war.zivot <=0 ){ System.out.println("Prehral si! Lukostrelec vyhral!");}
        }
    }
}
