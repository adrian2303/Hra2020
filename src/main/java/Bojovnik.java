public class Bojovnik extends Hrac {

    public Bojovnik(String meno) {
        this.meno = meno;
        zivot = 1000;
        poskodenie = 50;
        System.out.println("Vytvoril sa bojovník s menom "+this.meno);
        System.out.println("Život bojovníka je: " + this.zivot);
    }

    public void bojSKuzelnikom(){

        Bojovnik war = new Bojovnik("Ferdo");
        Kuzelnik mag = new Kuzelnik("Jardo");

        while(war.zivot > 0 && mag.zivot > 0){

            mag.zivot = mag.zivot - war.poskodenie;

            if(mag.zivot <= 0){
                System.out.println("Život bojovnika: " +war.zivot +" "+"Život kúzelnika: " + mag.zivot);
                break;
            }

            war.zivot = war.zivot - mag.poskodenie;
            System.out.println("Život bojovnika: " +war.zivot +" "+"Život kúzelnika: " + mag.zivot);
        }
    }

    public void bojSLukostrelcom(){

        Bojovnik war = new Bojovnik("Ferdo");
        Lukostrelec luk = new Lukostrelec("Lukas");

        while(war.zivot > 0 && luk.zivot > 0) {

            luk.zivot = luk.zivot - war.poskodenie;

            if(luk.zivot <= 0){
                System.out.println("Život bojovnika: " + war.zivot + " " + "Život lukostrelca: " + luk.zivot);
                break;
            }

            war.zivot = war.zivot - luk.poskodenie;
            System.out.println("Život bojovnika: " + war.zivot + " " + "Život lukostrelca: " + luk.zivot);
        }
    }
}
