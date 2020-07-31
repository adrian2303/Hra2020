import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Kuzelnik extends Hrac {

    public Kuzelnik(String meno) throws FileNotFoundException {
        this.meno = meno;
        File suborCisel = new File("levelKuzelnik.txt");
        Scanner s = new Scanner(suborCisel);
        float level = s.nextFloat();

        if(level >= 1.0 && level <= 1.99){
            this.zivot = 350;
            this.posMag1 = 145;
            this.posMag2 = 185;
        }else if(level >= 2.0 && level <=2.99){
                this.zivot = 400;
                this.posMag1 = 175;
            this.posMag2 = 215;
        }else if(level >= 3.0 && level <=3.99){
            this.zivot = 450;
            this.posMag1 = 205;
            this.posMag2 = 245;
        }else if(level >= 4.0 && level <=4.99){
            this.zivot = 500;
            this.posMag1 = 235;
            this.posMag2 = 275;
        }else if(level >= 5.0 && level <=9.99){
            this.zivot = 550;
            this.posMag1 = 265;
            this.posMag2 = 305;
        }
        System.out.println("Vytvoril sa kúzelník s menom "+ this.meno);
        System.out.println("Život kúzelníka je "+ this.zivot);
        System.out.println("Úder kúzelníka je od "+this.posMag1+" do "+this.posMag2);
    }

    public int getRandomNumber(int min, int max){
        return (int) ((Math.random() * (max - min)) + min);
    }

    public void bojSBojovnikom() throws FileNotFoundException {

        Kuzelnik mag = new Kuzelnik("Jano");
        Bojovnik war = new Bojovnik("Ferko");

        while(mag.zivot > 0 && war.zivot > 0){

            mag.poskodenie = getRandomNumber(posMag1,posMag2);
            war.poskodenie = getRandomNumber(war.posWar1,war.posWar2);

            war.zivot = war.zivot - mag.poskodenie;

            if(war.zivot <= 0){
                System.out.println("Život kúzelníka: " +mag.zivot +" "+"Úder: "+mag.poskodenie+" "+"Život bojovníka: " + war.zivot);
                System.out.println("Vyhral si! Kúzelník vyhral!");
                break;
            }

            mag.zivot = mag.zivot - war.poskodenie;
            System.out.println("Život kúzelníka: " +mag.zivot +" "+"Úder: "+mag.poskodenie+" "+"Život bojovníka: " + war.zivot+" "+"Úder: "+war.poskodenie);
            if(mag.zivot <= 0){ System.out.println("Prehral si! Vyhral bojovník!"); }
        }
    }

    public void bojSLukostrelcom() throws FileNotFoundException {

        Kuzelnik mag = new Kuzelnik("Jano");
        Lukostrelec luk = new Lukostrelec("Ferko");

        while(mag.zivot > 0 && luk.zivot > 0){

            mag.poskodenie = getRandomNumber(posMag1,posMag2);
            luk.poskodenie = getRandomNumber(luk.posLuk1,luk.posLuk2);

            luk.zivot = luk.zivot - mag.poskodenie;

            if(luk.zivot <= 0){
                System.out.println("Život kúzelníka: " +mag.zivot +" "+"Úder: "+mag.poskodenie+" "+"Život lukostrelca: " + luk.zivot);
                System.out.println("Vyhral si! Kúzelník vyhral!");
                break;
            }

            mag.zivot = mag.zivot - luk.poskodenie;
            System.out.println("Život kúzelníka: " +mag.zivot +" "+"Úder: "+mag.poskodenie+" "+"Život lukostrelca: " + luk.zivot+" "+"Úder: "+luk.poskodenie);
            if(mag.zivot <= 0){ System.out.println("Prehral si! Lukostrelec vyhral!"); }
        }
    }
}
