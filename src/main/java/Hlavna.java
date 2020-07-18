import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hlavna {
    public static void main(String[] args) {

        ImageIcon obrazok;
        JLabel pozadieHry;
        JFrame okno = new JFrame("RPG hra");
        okno.setPreferredSize(new Dimension(1000,750));
        obrazok = new ImageIcon(Hlavna.class.getResource("/pozadieObrazok.jpg"));
        pozadieHry = new JLabel(obrazok);
        pozadieHry.setSize(1000,750);
        okno.setDefaultCloseOperation(okno.EXIT_ON_CLOSE);
        okno.add(pozadieHry);
        okno.setResizable(false);
        okno.pack();
        okno.setVisible(true);

        JButton bojovnikTlac;
        JButton kuzelnikTlac;
        JButton lukostrelecTlac;

        pozadieHry.add(bojovnikTlac = new JButton("Bojovník"));
        bojovnikTlac.setBounds(450,320,100,50);

        pozadieHry.add(kuzelnikTlac = new JButton("Kúzelník"));
        kuzelnikTlac.setBounds(450,400,100,50);

        pozadieHry.add(lukostrelecTlac = new JButton("Lukostrelec"));
        lukostrelecTlac.setBounds(450,480,100,50);

        //pridanie akcií tlačidlu, ktorá sa má vykonať po stlačení tlačidla start (implmentované použitím anonymnej triedy)
        bojovnikTlac.addActionListener(new ActionListener() {
            //daná metóda sa zavolá po kliknutí na tačidlo "bojovnikTlac"
            @Override
            public void actionPerformed(ActionEvent e) {
                //Po stlačení tlačidla start sa vytvorí nové grafiké okno (JFrame) a na tomto okne sa vytvorí
                // nová inštanicia triedy HernyPanel čím sa zavolá aj jej konštruktor.
                // V tomto novovytvorenom okne sa nám zobrazí hra, ktorá je od tejto chvíle plne hrateľná
                if (e.getSource() == bojovnikTlac) {
                    Hrac war = new Bojovnik("Jano");
                }
            }});



        kuzelnikTlac.addActionListener(new ActionListener() {

            // daná metóda sa zavolá po kliknutí na tačidlo "kuzelnikTlac"
            public void actionPerformed(ActionEvent e) {

                //Po stlačení tlačidla start sa vytvorí nové grafiké okno (JFrame) a na tomto okne sa vytvorí
                // nová inštanicia triedy HernyPanel čím sa zavolá aj jej konštruktor.
                // V tomto novovytvorenom okne sa nám zobrazí hra, ktorá je od tejto chvíle plne hrateľná
                if (e.getSource() == kuzelnikTlac) {
                    Hrac mag = new Kuzelnik("Ďuro");
                }

            }});

//pridanie akcií tlačidlu, ktorá sa má vykonať po stlačení tlačidla start (implmentované použitím anonymnej triedy)
        lukostrelecTlac.addActionListener(new ActionListener() {

            //daná metóda sa zavolá po kliknutí na tačidlo "luskostrelecTlac"
            public void actionPerformed(ActionEvent e) {

                //Po stlačení tlačidla start sa vytvorí nové grafiké okno (JFrame) a na tomto okne sa vytvorí
                // nová inštanicia triedy HernyPanel čím sa zavolá aj jej konštruktor.
                // V tomto novovytvorenom okne sa nám zobrazí hra, ktorá je od tejto chvíle plne hrateľná
                if (e.getSource() == lukostrelecTlac) {
                    Hrac luk = new Lukostrelec("Fero");
                }

            }});

    }
}
