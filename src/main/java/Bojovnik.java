public class Bojovnik extends Hrac {

    public Bojovnik(String meno) {
        this.meno = meno;
        zivot = 1000;
        poskodenie = 50;
        System.out.println("Vytvoril sa bojovník s menom "+this.meno);
        System.out.println("Život bojovníka je: " + this.zivot);
    }
}
