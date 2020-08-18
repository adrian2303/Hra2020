import java.io.*;
import java.util.Scanner;

public class Kuzelnik extends Hrac {
    private File suborCisel;
    private Scanner vstupnaHodnota;

    public Kuzelnik(String meno) throws FileNotFoundException {
        this.meno = meno;
        suborCisel = new File("levelKuzelnik.txt");
        vstupnaHodnota = new Scanner(suborCisel);
        int level = vstupnaHodnota.nextInt();

        if(level >= 0 && level <= 99){
            this.zivot = 350;
            this.posMag1 = 145;
            this.posMag2 = 185;
            this.uroven = 1;
        }else if(level >= 100 && level <= 299){
            this.zivot = 400;
            this.posMag1 = 175;
            this.posMag2 = 215;
            this.uroven = 2;
        }else if(level >= 300 && level <= 599){
            this.zivot = 450;
            this.posMag1 = 205;
            this.posMag2 = 245;
            this.uroven = 3;
        }else if(level >= 600 && level <= 999){
            this.zivot = 500;
            this.posMag1 = 235;
            this.posMag2 = 275;
            this.uroven = 4;
        }else if(level >= 1000 && level <= 9999){
            this.zivot = 550;
            this.posMag1 = 265;
            this.posMag2 = 305;
            this.uroven = 5;
        }
        System.out.println("Vytvoril sa kúzelník "+ this.meno+" úrovne "+this.uroven);
        System.out.println("Život kúzelníka je "+ this.zivot);
        System.out.println("Úder kúzelníka je od "+this.posMag1+" do "+this.posMag2);
    }

    public int getRandomNumber(int min, int max){
        return (int) ((Math.random() * (max - min)) + min);
    }

    public void bojSBojovnikom() throws IOException {

        Kuzelnik mag = new Kuzelnik("Jano");
        Bojovnik war = new Bojovnik("Ferko");

        while(mag.zivot > 0 && war.zivot > 0){

            mag.poskodenie = getRandomNumber(posMag1,posMag2);
            war.poskodenie = getRandomNumber(war.posWar1,war.posWar2);

            war.zivot = war.zivot - mag.poskodenie;

            if(war.zivot <= 0){
                System.out.println("Život kúzelníka: " +mag.zivot +" "+"Úder: "+mag.poskodenie+" "+"Život bojovníka: " + war.zivot);
                System.out.println("Vyhral si! Kúzelník vyhral!");
                if(suborCisel.exists()){
                    vstupnaHodnota = new Scanner(suborCisel);
                    int level = vstupnaHodnota.nextInt();
                    int novyLevel = level + 10;
                    suborCisel.delete();
                    Writer wr = new FileWriter("levelKuzelnik.txt");
                    wr.write(novyLevel +"");
                    wr.close();
                }
                break;
            }

            mag.zivot = mag.zivot - war.poskodenie;
            System.out.println("Život kúzelníka: " +mag.zivot +" "+"Úder: "+mag.poskodenie+" "+"Život bojovníka: " + war.zivot+" "+"Úder: "+war.poskodenie);
            if(mag.zivot <= 0){ System.out.println("Prehral si! Vyhral bojovník!"); }
        }
    }

    public void bojSLukostrelcom() throws IOException {

        Kuzelnik mag = new Kuzelnik("Jano");
        Lukostrelec luk = new Lukostrelec("Ferko");

        while(mag.zivot > 0 && luk.zivot > 0){

            mag.poskodenie = getRandomNumber(posMag1,posMag2);
            luk.poskodenie = getRandomNumber(luk.posLuk1,luk.posLuk2);

            luk.zivot = luk.zivot - mag.poskodenie;

            if(luk.zivot <= 0){
                System.out.println("Život kúzelníka: " +mag.zivot +" "+"Úder: "+mag.poskodenie+" "+"Život lukostrelca: " + luk.zivot);
                System.out.println("Vyhral si! Kúzelník vyhral!");
                if(suborCisel.exists()){
                    vstupnaHodnota = new Scanner(suborCisel);
                    int level = vstupnaHodnota.nextInt();
                    int novyLevel = level + 10;
                    suborCisel.delete();
                    Writer wr = new FileWriter("levelKuzelnik.txt");
                    wr.write(novyLevel +"");
                    wr.close();

                }
                break;
            }

            mag.zivot = mag.zivot - luk.poskodenie;
            System.out.println("Život kúzelníka: " +mag.zivot +" "+"Úder: "+mag.poskodenie+" "+"Život lukostrelca: " + luk.zivot+" "+"Úder: "+luk.poskodenie);
            if(mag.zivot <= 0){ System.out.println("Prehral si! Lukostrelec vyhral!"); }
        }
    }
}
