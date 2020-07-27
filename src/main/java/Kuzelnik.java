public class Kuzelnik extends Hrac {

    public Kuzelnik(String meno) {
        this.meno = meno;
        zivot = 300;
        poskodenie = 165;
        System.out.println("Vytvoril sa kúzelník s menom "+ this.meno);
        System.out.println("Život kúzelníka je "+ this.zivot);
    }

    public void bojSBojovnikom(){

        Kuzelnik mag = new Kuzelnik("Jano");
        Bojovnik war = new Bojovnik("Ferko");

        while(mag.zivot > 0 && war.zivot > 0){

            war.zivot = war.zivot - mag.poskodenie;

            if(war.zivot <= 0){
                System.out.println("Život kúzelníka: " +mag.zivot +" "+"Život bojovníka: " + war.zivot);
                break;
            }

            mag.zivot = mag.zivot - war.poskodenie;
            System.out.println("Život kúzelníka: " +mag.zivot +" "+"Život bojovníka: " + war.zivot);
        }
    }

    public void bojSLukostrelcom(){

        Kuzelnik mag = new Kuzelnik("Jano");
        Lukostrelec luk = new Lukostrelec("Ferko");

        while(mag.zivot > 0 && luk.zivot > 0){

            luk.zivot = luk.zivot - mag.poskodenie;

            if(luk.zivot <= 0){
                System.out.println("Život kúzelníka: " +mag.zivot +" "+"Život lukostrelca: " + luk.zivot);
                break;
            }

            mag.zivot = mag.zivot - luk.poskodenie;
            System.out.println("Život kúzelníka: " +mag.zivot +" "+"Život lukostrelca: " + luk.zivot);
        }
    }
}
