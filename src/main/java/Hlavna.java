import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hlavna {
    public static void main(String[] args) {

        ImageIcon obrazok;
        JLabel pozadieHry;
        JFrame okno = new JFrame("RPG hra");
        okno.setPreferredSize(new Dimension(1135,745));
        obrazok = new ImageIcon(Hlavna.class.getResource("/pozadieObrazok.jpg"));
        pozadieHry = new JLabel(obrazok);
        pozadieHry.setSize(1135,745);
        okno.setDefaultCloseOperation(okno.EXIT_ON_CLOSE);
        okno.add(pozadieHry);
        okno.setResizable(false);
        okno.pack();
        okno.setVisible(true);

        JButton bojovnikTlac;
        JButton kuzelnikTlac;
        JButton lukostrelecTlac;

        pozadieHry.add(bojovnikTlac = new JButton("Bojovník"));
        bojovnikTlac.setBounds(470,250,100,50);

        pozadieHry.add(kuzelnikTlac = new JButton("Kúzelník"));
        kuzelnikTlac.setBounds(470,330,100,50);

        pozadieHry.add(lukostrelecTlac = new JButton("Lukostrelec"));
        lukostrelecTlac.setBounds(470,410,100,50);

        //pridanie akcií tlačidlu, ktorá sa má vykonať po stlačení tlačidla start (implmentované použitím anonymnej triedy)
        bojovnikTlac.addActionListener(new ActionListener() {
            //daná metóda sa zavolá po kliknutí na tačidlo "bojovnikTlac"
            @Override
            public void actionPerformed(ActionEvent e) {
                //Po stlačení tlačidla start sa vytvorí nové grafiké okno (JFrame) a na tomto okne sa vytvorí
                // nová inštanicia triedy HernyPanel čím sa zavolá aj jej konštruktor.
                // V tomto novovytvorenom okne sa nám zobrazí hra, ktorá je od tejto chvíle plne hrateľná
                if (e.getSource() == bojovnikTlac) {

                    ImageIcon MenuBojovnikaObr;
                    JLabel pozadieMenu;
                    JButton bojovnikVsMagTlac;
                    JButton bojovnikVsLukTlac;
                    JFrame menuOkno = new JFrame("Hlavné menu postavy Bojovník");
                    menuOkno.setPreferredSize(new Dimension(1135,745));
                    MenuBojovnikaObr = new ImageIcon(Hlavna.class.getResource("/MenuBojovnikaPozadie.jpg"));
                    pozadieMenu = new JLabel(MenuBojovnikaObr);
                    pozadieMenu.setSize(1135,745);
                    menuOkno.setDefaultCloseOperation(okno.EXIT_ON_CLOSE);
                    menuOkno.add(pozadieMenu);
                    menuOkno.setResizable(false);
                    menuOkno.pack();
                    menuOkno.setVisible(true);

                    pozadieMenu.add(bojovnikVsMagTlac = new JButton("Útok na kúzelníka"));
                    bojovnikVsMagTlac.setBounds(470,330,200,50);

                    pozadieMenu.add(bojovnikVsLukTlac = new JButton("Útok na lukostrelca"));
                    bojovnikVsLukTlac.setBounds(470,410,200,50);

//pridanie akcií tlačidlu, ktorá sa má vykonať po stlačení tlačidla bojovnikVsMagTlac (implmentované použitím anonymnej triedy)
                    bojovnikVsMagTlac.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (e.getSource() == bojovnikVsMagTlac){
                                  Bojovnik warior = new Bojovnik("Jano");
                                  warior.bojSKuzelnikom();
                            }

                        }
                    });

                    //pridanie akcií tlačidlu, ktorá sa má vykonať po stlačení tlačidla bojovnikVsMagTlac (implmentované použitím anonymnej triedy)
                    bojovnikVsLukTlac.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(e.getSource() == bojovnikVsLukTlac){
                                Bojovnik warior = new Bojovnik("Jano");
                                warior.bojSLukostrelcom();
                            }
                        }
                    });

                }
            }});

//pridanie akcií tlačidlu, ktorá sa má vykonať po stlačení tlačidla kuzelnikTlac (implmentované použitím anonymnej triedy)
        kuzelnikTlac.addActionListener(new ActionListener() {

            // daná metóda sa zavolá po kliknutí na tačidlo "kuzelnikTlac"
            public void actionPerformed(ActionEvent e) {

                //Po stlačení tlačidla start sa vytvorí nové grafiké okno (JFrame) a na tomto okne sa vytvorí
                // nová inštanicia triedy HernyPanel čím sa zavolá aj jej konštruktor.
                // V tomto novovytvorenom okne sa nám zobrazí hra, ktorá je od tejto chvíle plne hrateľná
                if (e.getSource() == kuzelnikTlac) {

                    ImageIcon MenuKuzelnikaObr;
                    JLabel pozadieMenu;
                    JButton MagVsBojovnikTlac;
                    JButton MagVsLukTlac;
                    JFrame menuOkno = new JFrame("Hlavné menu postavy Kúzelník");
                    menuOkno.setPreferredSize(new Dimension(1135,745));
                    MenuKuzelnikaObr = new ImageIcon(Hlavna.class.getResource("/MenuBojovnikaPozadie.jpg"));
                    pozadieMenu = new JLabel(MenuKuzelnikaObr);
                    pozadieMenu.setSize(1135,745);
                    menuOkno.setDefaultCloseOperation(okno.EXIT_ON_CLOSE);
                    menuOkno.add(pozadieMenu);
                    menuOkno.setResizable(false);
                    menuOkno.pack();
                    menuOkno.setVisible(true);

                    pozadieMenu.add(MagVsBojovnikTlac = new JButton("Útok na bojovníka"));
                    MagVsBojovnikTlac.setBounds(470,330,200,50);
                    pozadieMenu.add(MagVsLukTlac = new JButton("Útok na lukostrelca"));
                    MagVsLukTlac.setBounds(470,410,200,50);

                    //pridanie akcií tlačidlu, ktorá sa má vykonať po stlačení tlačidla bojovnikVsMagTlac (implmentované použitím anonymnej triedy)
                    MagVsBojovnikTlac.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(e.getSource() == MagVsBojovnikTlac) {
                                Kuzelnik mag = new Kuzelnik("Ďuro");
                                mag.bojSBojovnikom();
                            }
                        }
                    });

                    MagVsLukTlac.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(e.getSource() == MagVsLukTlac) {
                                Kuzelnik mag = new Kuzelnik("Ďuro");
                                mag.bojSLukostrelcom();
                            }
                        }
                    });
                }

            }});


//pridanie akcií tlačidlu, ktorá sa má vykonať po stlačení tlačidla lukostrelecTlac (implmentované použitím anonymnej triedy)
        lukostrelecTlac.addActionListener(new ActionListener() {

            //daná metóda sa zavolá po kliknutí na tačidlo "luskostrelecTlac"
            public void actionPerformed(ActionEvent e) {

                //Po stlačení tlačidla start sa vytvorí nové grafiké okno (JFrame) a na tomto okne sa vytvorí
                // nová inštanicia triedy HernyPanel čím sa zavolá aj jej konštruktor.
                // V tomto novovytvorenom okne sa nám zobrazí hra, ktorá je od tejto chvíle plne hrateľná
                if (e.getSource() == lukostrelecTlac) {

                    ImageIcon MenuLukostrelcaObr;
                    JLabel pozadieMenu;
                    JButton LukVsMagTlac;
                    JButton LukVsBojovnikTlac;
                    JFrame menuOkno = new JFrame("Hlavné menu postavy Lukostrelec");
                    menuOkno.setPreferredSize(new Dimension(1135,745));
                    MenuLukostrelcaObr = new ImageIcon(Hlavna.class.getResource("/MenuBojovnikaPozadie.jpg"));
                    pozadieMenu = new JLabel(MenuLukostrelcaObr);
                    pozadieMenu.setSize(1135,745);
                    menuOkno.setDefaultCloseOperation(okno.EXIT_ON_CLOSE);
                    menuOkno.add(pozadieMenu);
                    menuOkno.setResizable(false);
                    menuOkno.pack();
                    menuOkno.setVisible(true);

                    pozadieMenu.add(LukVsMagTlac = new JButton("Útok na kúzelníka"));
                    LukVsMagTlac.setBounds(470,330,200,50);
                    pozadieMenu.add(LukVsBojovnikTlac = new JButton("Útok na bojovníka"));
                    LukVsBojovnikTlac.setBounds(470,410,200,50);

                    //pridanie akcií tlačidlu, ktorá sa má vykonať po stlačení tlačidla LukVsMagTlac (implmentované použitím anonymnej triedy)
                    LukVsMagTlac.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(e.getSource() == LukVsMagTlac){
                                Lukostrelec luk = new Lukostrelec("Miso");
                                luk.bojSKuzelnikom();
                            }

                        }
                    });

                    LukVsBojovnikTlac.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(e.getSource() == LukVsBojovnikTlac){
                                Lukostrelec luk = new Lukostrelec("Peťo");
                                luk.bojSBojovnikom();
                            }
                        }
                    });
                }

            }});

    }
}
