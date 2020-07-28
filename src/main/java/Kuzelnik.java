public class Kuzelnik extends Hrac {

    public Kuzelnik(String meno) {
        this.meno = meno;
        zivot = 300;
        System.out.println("Vytvoril sa kúzelník s menom "+ this.meno);
        System.out.println("Život kúzelníka je "+ this.zivot);
    }

    public int getRandomNumber(int min, int max){
        return (int) ((Math.random() * (max - min)) + min);
    }

    public void bojSBojovnikom(){

        Kuzelnik mag = new Kuzelnik("Jano");
        Bojovnik war = new Bojovnik("Ferko");

        while(mag.zivot > 0 && war.zivot > 0){

            mag.poskodenie = getRandomNumber(145,185);
            war.poskodenie = getRandomNumber(30,70);

            war.zivot = war.zivot - mag.poskodenie;

            if(war.zivot <= 0){
                System.out.println("Život kúzelníka: " +mag.zivot +" "+"Úder: "+mag.poskodenie+" "+"Život bojovníka: " + war.zivot);
                break;
            }

            mag.zivot = mag.zivot - war.poskodenie;
            System.out.println("Život kúzelníka: " +mag.zivot +" "+"Úder: "+mag.poskodenie+" "+"Život bojovníka: " + war.zivot+" "+"Úder: "+war.poskodenie);
        }
    }

    public void bojSLukostrelcom(){

        Kuzelnik mag = new Kuzelnik("Jano");
        Lukostrelec luk = new Lukostrelec("Ferko");

        while(mag.zivot > 0 && luk.zivot > 0){

            mag.poskodenie = getRandomNumber(145,185);
            luk.poskodenie = getRandomNumber(65,105);

            luk.zivot = luk.zivot - mag.poskodenie;

            if(luk.zivot <= 0){
                System.out.println("Život kúzelníka: " +mag.zivot +" "+"Úder: "+mag.poskodenie+" "+"Život lukostrelca: " + luk.zivot);
                break;
            }

            mag.zivot = mag.zivot - luk.poskodenie;
            System.out.println("Život kúzelníka: " +mag.zivot +" "+"Úder: "+mag.poskodenie+" "+"Život lukostrelca: " + luk.zivot+" "+"Úder: "+luk.poskodenie);
        }
    }
}
