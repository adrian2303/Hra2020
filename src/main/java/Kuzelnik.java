public class Kuzelnik extends Hrac {

    public Kuzelnik(String meno) {
        this.meno = meno;
        zivot = 300;
        poskodenie = 165;
        System.out.println("Vytvoril sa kúzelník s menom "+ this.meno);
        System.out.println("Život kúzelníka je "+ this.zivot);
    }
}
