import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

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
                    JButton pralesBojovnik;
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

                    pozadieMenu.add(pralesBojovnik = new JButton("Záhadný prales"));
                    pralesBojovnik.setBounds(470,490,200,50);

//pridanie akcií tlačidlu, ktorá sa má vykonať po stlačení tlačidla bojovnikVsMagTlac (implmentované použitím anonymnej triedy)
                    bojovnikVsMagTlac.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e)  {
                            if (e.getSource() == bojovnikVsMagTlac){
                                Bojovnik war = null;
                                try {
                                    war = new Bojovnik("Jano");
                                } catch (FileNotFoundException ex) {
                                    ex.printStackTrace();
                                }
                                try {
                                    war.bojSKuzelnikom();
                                } catch (FileNotFoundException ex) {
                                    ex.printStackTrace();
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                            }

                        }
                    });

                    //pridanie akcií tlačidlu, ktorá sa má vykonať po stlačení tlačidla bojovnikVsMagTlac (implmentované použitím anonymnej triedy)
                    bojovnikVsLukTlac.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(e.getSource() == bojovnikVsLukTlac){
                                Bojovnik war = null;
                                try {
                                    war = new Bojovnik("Jano");
                                } catch (FileNotFoundException ex) {
                                    ex.printStackTrace();
                                }
                                try {
                                    war.bojSLukostrelcom();
                                } catch (FileNotFoundException ex) {
                                    ex.printStackTrace();
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        }
                    });

//pridanie akcií tlačidlu, ktorá sa má vykonať po stlačení tlačidla bojovnikVsMagTlac (implmentované použitím anonymnej triedy)
                  pralesBojovnik.addActionListener(new ActionListener() {
                      @Override
                      public void actionPerformed(ActionEvent e) {
                          if(e.getSource() == pralesBojovnik) {
                              ImageIcon BojovnikObrPrales;
                              JLabel pozadiePrales;
                              JButton BojovnikVsNepriatel;
                              JFrame pralesBojovnikOkno = new JFrame("Bojovníkov Záhadný prales");
                              pralesBojovnikOkno.setPreferredSize(new Dimension(1135, 745));
                              BojovnikObrPrales = new ImageIcon(Hlavna.class.getResource("/PozadieZahadnyPrales.jpg"));
                              pozadiePrales = new JLabel(BojovnikObrPrales);
                              pozadiePrales.setSize(1135,745);
                              pralesBojovnikOkno.setDefaultCloseOperation(okno.EXIT_ON_CLOSE);
                              pralesBojovnikOkno.add(pozadiePrales);
                              pralesBojovnikOkno.setResizable(false);
                              pralesBojovnikOkno.pack();
                              pralesBojovnikOkno.setVisible(true);

//                            pridanie tlačidla na útok na nepriateľa do okna a nastavenie jeho umiestnenia
                              pozadiePrales.add(BojovnikVsNepriatel = new JButton("Útok na nepriateľa"));
                              BojovnikVsNepriatel.setBounds(470,350,200,50);

                              //pridanie akcií tlačidlu, ktorá sa má vykonať po stlačení tlačidla BojovníkVsNepriatel (implmentované použitím anonymnej triedy)
                              BojovnikVsNepriatel.addActionListener(new ActionListener() {
                                  @Override
                                  public void actionPerformed(ActionEvent e) {
                                      if(e.getSource() == BojovnikVsNepriatel){
                                          Nepriatel nepriatel = null;
                                          try {
                                              nepriatel = new Nepriatel("Ferdo",2);
                                          } catch (FileNotFoundException ex) {
                                              ex.printStackTrace();
                                          }
                                          try {
                                              nepriatel.bojSBojovnikom();
                                          } catch (IOException ex) {
                                              ex.printStackTrace();
                                          }
                                      }
                                  }
                              });
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
                    JButton pralesKuzelnik;
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
                    pozadieMenu.add(pralesKuzelnik = new JButton("Záhadný prales"));
                    pralesKuzelnik.setBounds(470,490, 200,50);

                    //pridanie akcií tlačidlu, ktorá sa má vykonať po stlačení tlačidla bojovnikVsMagTlac (implmentované použitím anonymnej triedy)
                    MagVsBojovnikTlac.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(e.getSource() == MagVsBojovnikTlac) {
                                Kuzelnik mag = null;
                                try {
                                    mag = new Kuzelnik("Ďuro");
                                } catch (FileNotFoundException ex) {
                                    ex.printStackTrace();
                                }
                                try {
                                    mag.bojSBojovnikom();
                                } catch (FileNotFoundException ex) {
                                    ex.printStackTrace();
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        }
                    });

                    MagVsLukTlac.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(e.getSource() == MagVsLukTlac) {
                                Kuzelnik mag = null;
                                try {
                                    mag = new Kuzelnik("Ďuro");
                                } catch (FileNotFoundException ex) {
                                    ex.printStackTrace();
                                }
                                try {
                                    mag.bojSLukostrelcom();
                                } catch (FileNotFoundException ex) {
                                    ex.printStackTrace();
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        }
                    });
                    //pridanie akcií tlačidlu, ktorá sa má vykonať po stlačení tlačidla lukostrelecTlac (implmentované použitím anonymnej triedy)
                    pralesKuzelnik.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                              if(e.getSource() == pralesKuzelnik){

                                  ImageIcon KuzelnikObrPrales;
                                  JLabel pozadiePrales;
                                  JButton KuzelnikVsNepriatel;
                                  JFrame pralesBojovnikOkno = new JFrame("Kúzelnikov Záhadný prales");
                                  pralesBojovnikOkno.setPreferredSize(new Dimension(1135, 745));
                                  KuzelnikObrPrales = new ImageIcon(Hlavna.class.getResource("/PozadieZahadnyPrales.jpg"));
                                  pozadiePrales = new JLabel(KuzelnikObrPrales);
                                  pozadiePrales.setSize(1135,745);
                                  pralesBojovnikOkno.setDefaultCloseOperation(okno.EXIT_ON_CLOSE);
                                  pralesBojovnikOkno.add(pozadiePrales);
                                  pralesBojovnikOkno.setResizable(false);
                                  pralesBojovnikOkno.pack();
                                  pralesBojovnikOkno.setVisible(true);

                                  // pridanie tlačidla na útok na nepriateľa do okna a nastavenie jeho umiestnenia
                                  pozadiePrales.add(KuzelnikVsNepriatel = new JButton("Útok na nepriateľa"));
                                  KuzelnikVsNepriatel.setBounds(470,350,200,50);

                                  //pridanie akcií tlačidlu, ktorá sa má vykonať po stlačení tlačidla KuzelnikVsNepriatel (implmentované použitím anonymnej triedy)
                                  KuzelnikVsNepriatel.addActionListener(new ActionListener() {
                                      @Override
                                      public void actionPerformed(ActionEvent e) {
                                          if ((e.getSource() == KuzelnikVsNepriatel)){
                                              Nepriatel nepriatel = null;
                                              try {
                                                  nepriatel = new Nepriatel("Ferdo",1);
                                              } catch (FileNotFoundException ex) {
                                                  ex.printStackTrace();
                                              }
                                              try {
                                                  nepriatel.bojSKuzelnikom();
                                              } catch (IOException ex) {
                                                  ex.printStackTrace();
                                              }
                                          }
                                      }
                                  });
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
                    JButton pralesLukostrelec;
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
                    pozadieMenu.add(pralesLukostrelec = new JButton("Záhadný prales"));
                    pralesLukostrelec.setBounds(470,490,200,50);

                    //pridanie akcií tlačidlu, ktorá sa má vykonať po stlačení tlačidla LukVsMagTlac (implmentované použitím anonymnej triedy)
                    LukVsMagTlac.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(e.getSource() == LukVsMagTlac){
                                Lukostrelec luk = null;
                                try {
                                    luk = new Lukostrelec("Miso");
                                } catch (FileNotFoundException ex) {
                                    ex.printStackTrace();
                                }
                                try {
                                    luk.bojSKuzelnikom();
                                } catch (FileNotFoundException ex) {
                                    ex.printStackTrace();
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                            }

                        }
                    });

                    LukVsBojovnikTlac.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(e.getSource() == LukVsBojovnikTlac){
                                Lukostrelec luk = null;
                                try {
                                    luk = new Lukostrelec("Peťo");
                                } catch (FileNotFoundException ex) {
                                    ex.printStackTrace();
                                }
                                try {
                                    luk.bojSBojovnikom();
                                } catch (FileNotFoundException ex) {
                                    ex.printStackTrace();
                                } catch (IOException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        }
                    });
                    //pridanie akcií tlačidlu, ktorá sa má vykonať po stlačení tlačidla pralesLukostrelec (implmentované použitím anonymnej triedy)
                    pralesLukostrelec.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(e.getSource() == pralesLukostrelec){
                                ImageIcon LukostrelecObrPrales;
                                JLabel pozadiePrales;
                                JButton LukostrelecVsNepriatel;
                                JFrame pralesBojovnikOkno = new JFrame("Lukostrelcov Záhadný prales");
                                pralesBojovnikOkno.setPreferredSize(new Dimension(1135, 745));
                                LukostrelecObrPrales = new ImageIcon(Hlavna.class.getResource("/PozadieZahadnyPrales.jpg"));
                                pozadiePrales = new JLabel(LukostrelecObrPrales);
                                pozadiePrales.setSize(1135,745);
                                pralesBojovnikOkno.setDefaultCloseOperation(okno.EXIT_ON_CLOSE);
                                pralesBojovnikOkno.add(pozadiePrales);
                                pralesBojovnikOkno.setResizable(false);
                                pralesBojovnikOkno.pack();
                                pralesBojovnikOkno.setVisible(true);

                                // pridanie tlačidla na útok na nepriateľa do okna a nastavenie jeho umiestnenia
                                pozadiePrales.add(LukostrelecVsNepriatel = new JButton("Útok na nepriateľa"));
                                LukostrelecVsNepriatel.setBounds(470,350,200,50);

                                //pridanie akcií tlačidlu, ktorá sa má vykonať po stlačení tlačidla LukostrelecVsNepriatel (implmentované použitím anonymnej triedy)
                                LukostrelecVsNepriatel.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        if(e.getSource() == LukostrelecVsNepriatel){
                                            Nepriatel nepriatel = null;
                                            try {
                                                nepriatel = new Nepriatel("Ferdo",3);
                                            } catch (FileNotFoundException ex) {
                                                ex.printStackTrace();
                                            }
                                            try {
                                                nepriatel.bojSLukostrelcom();
                                            } catch (IOException ex) {
                                                ex.printStackTrace();
                                            }
                                        }
                                    }
                                });
                            }
                        }
                    });
                }

            }});

    }
}
