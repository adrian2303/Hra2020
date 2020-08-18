import java.io.*;
import java.util.Scanner;

public class Bojovnik extends Hrac {
    private File suborCisel;
    private Scanner vstupnaHodnota;

    public Bojovnik(String meno) throws FileNotFoundException {
        this.meno = meno;
        suborCisel = new File("levelBojovnik.txt");
        vstupnaHodnota = new Scanner(suborCisel);
        int level = vstupnaHodnota.nextInt();

        if(level >= 0 && level <= 99){
            this.zivot = 1100;
            this.posWar1 = 30;
            this.posWar2 = 70;
            this.uroven = 1;
        }else if(level >= 100 && level <= 299){
            this.zivot = 1300;
            this.posWar1 = 40;
            this.posWar2 = 80;
            this.uroven = 2;
        }else if(level >= 300 && level <= 599){
            this.zivot = 1500;
            this.posWar1 = 50;
            this.posWar2 = 90;
            this.uroven = 3;
        }else if(level >= 600 && level <= 999){
            this.zivot = 1700;
            this.posWar1 = 60;
            this.posWar2 = 100;
            this.uroven = 4;
        }else if(level >= 1000 && level <= 9999){
            this.zivot = 1900;
            this.posWar1 = 70;
            this.posWar2 = 110;
            this.uroven = 5;
        }
        System.out.println("Vytvoril sa bojovník "+this.meno+" úrovne "+this.uroven);
        System.out.println("Život bojovníka je: " + this.zivot);
        System.out.println("Úder bojovníka je od "+this.posWar1+" do "+this.posWar2);

    }

    public int getRandomNumber(int min, int max){
        return (int) ((Math.random() * (max - min)) + min);
    }

    public void bojSKuzelnikom() throws IOException {

        Bojovnik war = new Bojovnik("Ferdo");
        Kuzelnik mag = new Kuzelnik("Jardo");

        while(war.zivot > 0 && mag.zivot > 0){

            war.poskodenie = getRandomNumber(posWar1,posWar2);
            mag.poskodenie = getRandomNumber(mag.posMag1,mag.posMag2);

            mag.zivot = mag.zivot - war.poskodenie;

            if(mag.zivot <= 0){
                System.out.println("Život bojovnika: " +war.zivot +" "+"Úder: "+war.poskodenie+" "+"Život kúzelnika: " + mag.zivot);
                System.out.println("Vyhral si! Bojovník vyhral!");
                if(suborCisel.exists()){
                    vstupnaHodnota = new Scanner(suborCisel);
                    int level = vstupnaHodnota.nextInt();
                    int novyLevel = level + 10;
                    suborCisel.delete();
                    Writer wr = new FileWriter("levelBojovnik.txt");
                    wr.write(novyLevel +"");
                    wr.close();
                }
                break;
            }

            war.zivot = war.zivot - mag.poskodenie;
            System.out.println("Život bojovnika: " +war.zivot +" "+"Úder: "+war.poskodenie+" "+"Život kúzelnika: " + mag.zivot+" "+"Úder: "+ mag.poskodenie);
            if(war.zivot <=0 ){ System.out.println("Prehral si! Kúzelník vyhral!"); }
        }
    }

    public void bojSLukostrelcom() throws IOException {

        Bojovnik war = new Bojovnik("Ferdo");
        Lukostrelec luk = new Lukostrelec("Lukas");

        while(war.zivot > 0 && luk.zivot > 0) {

            war.poskodenie = getRandomNumber(posWar1,posWar2);
            luk.poskodenie = getRandomNumber(luk.posLuk1,luk.posLuk2);

            luk.zivot = luk.zivot - war.poskodenie;

            if(luk.zivot <= 0){
                System.out.println("Život bojovnika: " + war.zivot + " "+"Úder: "+war.poskodenie+" "+ "Život lukostrelca: " + luk.zivot);
                System.out.println("Vyhral si! Bojovník vyhral!");
                if(suborCisel.exists()){
                    vstupnaHodnota = new Scanner(suborCisel);
                    int level = vstupnaHodnota.nextInt();
                    int novyLevel = level + 10;
                    suborCisel.delete();
                    Writer wr = new FileWriter("levelBojovnik.txt");
                    wr.write(novyLevel +"");
                    wr.close();
                }
                break;
            }

            war.zivot = war.zivot - luk.poskodenie;
            System.out.println("Život bojovnika: " + war.zivot + " "+"Úder: "+war.poskodenie+" "+ "Život lukostrelca: " + luk.zivot+" "+"Úder: "+luk.poskodenie);
            if(war.zivot <=0 ){ System.out.println("Prehral si! Lukostrelec vyhral!");}
        }
    }
}
