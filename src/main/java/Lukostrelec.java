public class Lukostrelec extends Hrac {

    public Lukostrelec(String meno) {
        this.meno = meno;
        zivot = 600;
        poskodenie = 85;
        System.out.println("Vytvoril sa lukostrelec s menom "+this.meno);
        System.out.println("Život lukostrelca je: " + this.zivot);
    }
}
