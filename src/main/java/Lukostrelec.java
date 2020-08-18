import java.io.*;
import java.util.Scanner;

public class Lukostrelec extends Hrac {
    private File suborCisel;
    private Scanner vstupnaHodnota;

    public Lukostrelec(String meno) throws FileNotFoundException {
        this.meno = meno;
        suborCisel = new File("levelLukostrelec.txt");
        vstupnaHodnota = new Scanner(suborCisel);
        int level = vstupnaHodnota.nextInt();

        if(level >= 0 && level <= 99){
            this.zivot = 650;
            this.posLuk1 = 65;
            this.posLuk2 = 105;
            this.uroven = 1;
        }else if(level >= 100 && level <= 299){
            this.zivot = 750;
            this.posLuk1 = 85;
            this.posLuk2 = 125;
            this.uroven = 2;
        }else if(level >= 300 && level <= 599){
            this.zivot = 850;
            this.posLuk1 = 105;
            this.posLuk2 = 145;
            this.uroven = 3;
        }else if(level >= 600 && level <= 999){
            this.zivot = 950;
            this.posLuk1 = 125;
            this.posLuk2 = 165;
            this.uroven = 4;
        }else if(level >= 1000 && level <= 9999){
            this.zivot = 1050;
            this.posLuk1 = 145;
            this.posLuk2 = 185;
            this.uroven = 5;
        }

        System.out.println("Vytvoril sa lukostrelec "+this.meno+" úrovne "+this.uroven);
        System.out.println("Život lukostrelca je: " + this.zivot);
        System.out.println("Úder lukostrelca je od "+this.posLuk1+" do "+this.posLuk2);
    }

    public int getRandomNumber(int min, int max){
        return (int) ((Math.random() * (max - min)) + min);
    }

    public void bojSKuzelnikom() throws IOException {

        Lukostrelec luk = new Lukostrelec("Miso");
        Kuzelnik mag = new Kuzelnik("Jardo");

        while(luk.zivot > 0 && mag.zivot > 0){

            luk.poskodenie = getRandomNumber(posLuk1,posLuk2);
            mag.poskodenie = getRandomNumber(mag.posMag1,mag.posMag2);

            mag.zivot = mag.zivot - luk.poskodenie;

            if(mag.zivot <= 0){
                System.out.println("Život lukostrelca: " +luk.zivot +" "+"Úder: "+luk.poskodenie+" "+"Život kúzelnika: " + mag.zivot);
                System.out.println("Vyhral si! Lukostrelec vyhral!");
                if(suborCisel.exists()){
                    vstupnaHodnota = new Scanner(suborCisel);
                    int level = vstupnaHodnota.nextInt();
                    int novyLevel = level + 10;
                    suborCisel.delete();
                    Writer wr = new FileWriter("levelLukostrelec.txt");
                    wr.write(novyLevel +"");
                    wr.close();
                }
                break;
            }

            luk.zivot = luk.zivot - mag.poskodenie;
            System.out.println("Život lukostrelca: " +luk.zivot +" "+"Úder: "+luk.poskodenie+" "+"Život kúzelnika: " + mag.zivot+" "+"Úder: "+mag.poskodenie);
            if(luk.zivot <= 0) {System.out.println("Prehral si! Kúzelník vyhral!");}
        }
    }

    public void bojSBojovnikom() throws IOException {

        Lukostrelec luk = new Lukostrelec("Miso");
        Bojovnik war = new Bojovnik("Ferko");

        while(luk.zivot > 0 && war.zivot > 0){

            luk.poskodenie = getRandomNumber(posLuk1,posLuk2);
            war.poskodenie = getRandomNumber(war.posWar1,war.posWar2);

            war.zivot = war.zivot - luk.poskodenie;

            if(war.zivot <= 0){
                System.out.println("Život lukostrelca: " +luk.zivot +" "+"Úder: "+luk.poskodenie+" "+"Život bojovníka: " + war.zivot);
                System.out.println("Vyhral si! Lukostrelec vyhral!");
                if(suborCisel.exists()){
                    vstupnaHodnota = new Scanner(suborCisel);
                    int level = vstupnaHodnota.nextInt();
                    int novyLevel = level + 10;
                    suborCisel.delete();
                    Writer wr = new FileWriter("levelLukostrelec.txt");
                    wr.write(novyLevel +"");
                    wr.close();
                }
                break;
            }

            luk.zivot = luk.zivot - war.poskodenie;
            System.out.println("Život lukostrelca: " +luk.zivot +" "+"Úder: "+luk.poskodenie+" "+"Život bojovníka: " + war.zivot+" "+"Úder: "+war.poskodenie);
            if(luk.zivot <= 0){ System.out.println("Prehral si! Bojovník vyhral!"); }
        }
    }
}
