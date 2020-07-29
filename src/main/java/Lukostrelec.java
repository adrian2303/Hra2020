public class Lukostrelec extends Hrac {

    public Lukostrelec(String meno) {
        this.meno = meno;
        zivot = 600;
        System.out.println("Vytvoril sa lukostrelec s menom "+this.meno);
        System.out.println("Život lukostrelca je: " + this.zivot);
    }

    public int getRandomNumber(int min, int max){
        return (int) ((Math.random() * (max - min)) + min);
    }

    public void bojSKuzelnikom(){

        Lukostrelec luk = new Lukostrelec("Miso");
        Kuzelnik mag = new Kuzelnik("Jardo");

        while(luk.zivot > 0 && mag.zivot > 0){

            luk.poskodenie = getRandomNumber(65,105);
            mag.poskodenie = getRandomNumber(145,185);

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

    public void bojSBojovnikom(){

        Lukostrelec luk = new Lukostrelec("Miso");
        Bojovnik war = new Bojovnik("Ferko");

        while(luk.zivot > 0 && war.zivot > 0){

            luk.poskodenie = getRandomNumber(65,105);
            war.poskodenie = getRandomNumber(30,70);

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
