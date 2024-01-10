package Package_GUI;

import java.awt.*;
import java.awt.event.*;
import Package_GUI.Opcje_Start.*;
import Package_Uczelnia.*;

import javax.swing.*;


public class Gui_Start implements ActionListener
{
    private final static int liczba = 6;
    private final static int liczbaP = 5;

    private static int[][] tabB = {{6}, {4}, {3}, {3, 6, 4, 5}, {2}, {3, 5, 4}};
            //new int[7][4];

    private int t1; //obsluga reakcji
    private int t2; //
    private int t3; //



    private Uczelnia uwu;

    private JButton[] buttons = new JButton[liczba];
    private JPanel[] panels = new JPanel[liczbaP];
    private JFrame frame = new JFrame();
    private JLabel header = new JLabel();

    /*buttons[0] = new JButton("Dodawanie"); //Dodawanie
    private JButton buttons2 = new JButton("Wyswietlanie list"); //Wyswietlanie list:
    private JButton buttons3 = new JButton("Wyszukiwanie"); //Wyszukiwanie
    private JButton buttons4 = new JButton("Zapisywanie/Wczytywanie"); //Zapisywanie/Wczytywanie
    private JButton buttons5 = new JButton("Usuwanie"); //Usuwanie
    private JButton buttons6 = new JButton("Sortowanie"); //Sortowanie*/
    private JButton buttonExit = new JButton("Wyjscie"); //Wyjscie
    private JPanel panelExit = new JPanel();

    public Gui_Start( Uczelnia uwu)
    {
        t1 = 0;
        t2 = 0;
        t3 = 0;
        this.uwu = uwu;

        createButtons();
        createPanels();

        setButtons(t1, t2, t3);

        wygladGui(t1, t2, t3, liczba);

        /*final int x = 800;
        final int y = 600;

        final int b = 150; //border

        panels[0].setBackground(Color.GRAY);
        panels[1].setBackground(Color.LIGHT_GRAY);
        panels[2].setBackground(Color.CYAN);
        panels[3].setBackground(Color.LIGHT_GRAY);
        panels[4].setBackground(Color.ORANGE);

        frame.setLayout( new BorderLayout());

        panels[0].setPreferredSize(new Dimension(x-2*b, 50));
        panels[1].setPreferredSize(new Dimension(b, y));
        panels[2].setPreferredSize(new Dimension(x-2*b, 450));
        panels[3].setPreferredSize(new Dimension(b, y));
        panels[4].setPreferredSize(new Dimension(x-2*b, 100));

        frame.add(panels[0],BorderLayout.NORTH);
        frame.add(panels[1],BorderLayout.WEST);
        frame.add(panels[2],BorderLayout.CENTER);
        frame.add(panels[3],BorderLayout.EAST);
        frame.add(panels[4],BorderLayout.SOUTH);

        panels[2].setLayout( new GridLayout(liczba,1));
        for( int i = 0; i < liczba; i++)
        {
            panels[2].add(buttons[i]);
            buttons[i].addActionListener(this);
        }

        buttonExit.setPreferredSize(new Dimension(150,40));
        panels[4].setLayout( new FlowLayout());
        //panels[4].setLayout(new BorderLayout());
        panels[4].add(buttonExit);
        buttonExit.addActionListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(x,y));
        frame.setVisible(true);
        frame.setResizable(true);*/

        /*panels[0].setBounds(b,0, x-2*b, 50);
        panels[1].setBounds(0, 0, b, y);
        panels[2].setBounds( b, 50, x-2*b, 450);
        panels[3].setBounds(x-b, 0, b, y);
        panels[4].setBounds(b, 500, x-2*b,100);

        panels[0].setBackground(Color.GRAY);
        panels[1].setBackground(Color.LIGHT_GRAY);
        panels[2].setBackground(Color.CYAN);
        panels[3].setBackground(Color.LIGHT_GRAY);
        panels[4].setBackground(Color.ORANGE);

        for( int i = 0; i < 5; i++)
            frame.add(panels[i]);*/
        /*
        frame.getContentPane().add(BorderLayout.WEST, panels[1]);
        frame.getContentPane().add(BorderLayout.CENTER, panels[2]);
        frame.getContentPane().add(BorderLayout.EAST, panels[3]);

        panels[2].setLayout(new BoxLayout(panels[2], BoxLayout.Y_AXIS));

        panels[2].add(buttons[0]);
        panels[2].add(buttons[1]);

        //buttons[0].setBounds(100, 160, 200, 40);
        buttons[0].addActionListener(this);

        //buttonExit.setBounds(400, 500, 200, 40);
        buttonExit.addActionListener(this);*/

        //frame.add(buttons[0]);
        //frame.add(buttonExit);

    }

    public Gui_Start( Uczelnia uwu, int t1_, int t2_, int t3_)
    {
        this.t1 = t1_;
        this.t2 = t2_;
        this.t3 = t3_;
        this.uwu = uwu;

        createButtons();
        createPanels();

        setButtons(t1, t2, t3);

        wygladGui(t1, t2, t3, liczba);
    }

    public void wygladGui(int t1, int t2, int t3, int nb ) //number of buttons
    {
        final int x = 800;
        final int y = 600;

        final int b = 150; //border

        //createButtons();
        //createPanels();

        panels[0].setBackground(Color.GRAY);
        panels[1].setBackground(Color.LIGHT_GRAY);
        panels[2].setBackground(Color.CYAN);
        panels[3].setBackground(Color.LIGHT_GRAY);
        panels[4].setBackground(Color.ORANGE);

        frame.setLayout( new BorderLayout());

        panels[0].setPreferredSize(new Dimension(x-2*b, 50));
        panels[1].setPreferredSize(new Dimension(b, y));
        panels[2].setPreferredSize(new Dimension(x-2*b, 450));
        panels[3].setPreferredSize(new Dimension(b, y));
        panels[4].setPreferredSize(new Dimension(x-2*b, 100));

        frame.add(panels[0],BorderLayout.NORTH);
        frame.add(panels[1],BorderLayout.WEST);
        frame.add(panels[2],BorderLayout.CENTER);
        frame.add(panels[3],BorderLayout.EAST);
        frame.add(panels[4],BorderLayout.SOUTH);

        panels[2].setLayout( new GridLayout(nb,1));
        for( int i = 0; i < nb; i++)
        {
            panels[2].add(buttons[i]);
            buttons[i].addActionListener(this);
        }

        buttonExit.setPreferredSize(new Dimension(150,40));
        panels[4].setLayout( new FlowLayout());
        //panels[4].setLayout(new BorderLayout());
        panels[4].add(buttonExit);
        buttonExit.addActionListener(this);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(x,y));
        frame.setVisible(true);
        frame.setResizable(true);
    }

    //osobna klasa dla kazdej funkcjonalnosci albo zmienianie widocznosci guzikow

    private boolean czyT1zero()
    {
        return( t1 == 0);
    }

    private boolean czyT2zero()
    {
        return (t2 == 0);
    }

    public void actionPerformed( ActionEvent eve) //glowne menu
    {

        if( eve.getSource() == buttons[0])
        {
            if(czyT1zero())
                t1 = 1;
            else
            {
                if(czyT2zero())
                    t2 = 1;
                else
                {
                    t3 = 1;
                }
            }
            /*frame.dispose();
            Gui_Dodawanie dod = new Gui_Dodawanie(uwu);*/
            frame.dispose();
            new Gui_Funkcje(uwu, t1, t2, t3);

        }else if( eve.getSource() == buttons[1])
        {
            if(czyT1zero())
                t1 = 2;
            else
            {
                if(czyT2zero())
                    t2 = 2;
                else
                {
                    t3 = 2;
                }
            }

            frame.dispose();
            new Gui_Funkcje(uwu, t1, t2, t3);
        }else if( eve.getSource() == buttons[2])
        {
            if(czyT1zero())
                t1 = 3;
            else
            {
                if( czyT2zero())
                    t2 = 3;
                else
                    t3 = 3;
            }

            frame.dispose();
            new Gui_Funkcje(uwu, t1, t2, t3);
        }else if( eve.getSource() == buttons[3])
        {
            if(czyT1zero())
                t1 = 4;
            else
            {
                if(czyT2zero())
                    t2 = 4;
                else
                    t3 = 4;
            }
            frame.dispose();
            new Gui_Funkcje(uwu, t1, t2, t3);
            //buttons[3].setVisible(false);
            //System.out.println("3");
        }else if( eve.getSource() == buttons[4])
        {
            if(czyT1zero())
                t1 = 5;
            else
            {
                if(czyT2zero())
                    t2 = 5;
                else
                    t3 = 5;
            }
            frame.dispose();
            new Gui_Funkcje(uwu, t1, t2, t3);

        }else if( eve.getSource() == buttons[5])
        {
            if(czyT1zero())
                t1 = 6;
            else
            {
                if(czyT2zero())
                    t2 = 6;
                else
                    t3 = 6;
            }

            frame.dispose();
            new Gui_Funkcje(uwu, t1, t2, t3);
        }else if( eve.getSource() == buttonExit)
        {
            frame.dispose();
        }


    }

    public void createButtons()
    {
        buttons[0] = new JButton("Dodawanie");
        buttons[1] = new JButton("Wyswietlanie list");
        buttons[2] = new JButton("Wyszukiwanie");
        buttons[3] = new JButton("Zapisywanie/Wczytywanie");
        buttons[4] = new JButton("Usuwanie");
        buttons[5] = new JButton("Sortowanie");
    }

    private void setButtons( int t1, int t2, int t3) // 0-0 - glowne menu
            //1-0 - menu dodawanie
            //2-0 - menu wyswietlanie
            //3-0 - menu wyszukiwanie
            //3-1 - pracownika, 3-2 - studenta, 3-3 - kursu
            //4-0 - menu serializacja
            //5-0 - menu usuwanie
            //5-1 - pracownika, 5-1 - studenta, 5-2 - kursu
            //6-0 - menu sortowanie
            //6-1 - osob, 6-2 - kursow

    {
        buttonReset();

        switch (t1)
        {
            case 0:
                addHeader("Menu glowne");
                buttons[0].setText("Dodawanie");
                buttons[1].setText("Wyswietlanie list");
                buttons[2].setText("Wyszukiwanie");
                buttons[3].setText("Zapisywanie/Wczytywanie");
                buttons[4].setText("Usuwanie");
                buttons[5].setText("Sortowanie");
                for( int i = 0; i < 6; i++)
                {
                    buttons[i].setVisible(true);
                }
                break;
            case 1:
                addHeader("Dodawanie elementow");
                buttons[0].setText("Dodaj studenta");
                buttons[1].setText("Dodaj pracownika");
                buttons[2].setText("Dodaj kurs");
                buttons[3].setText("Dodaj kurs dla studenta");

                for( int i = 0; i < 4; i++)
                {
                    buttons[i].setVisible(true);
                }
                break;
            case 2:
                addHeader("Wyswietlanie list");
                buttons[0].setText("Wyswietl wszystkich");
                buttons[1].setText("Wyswietl studentow z kursami");
                buttons[2].setText("Wyswietl pracownikow");
                for( int i = 0; i < 3; i++)
                {
                    buttons[i].setVisible(true);
                }
                break;
            case 3:
                switch (t2)
                {
                    case 0:
                        addHeader("Wyszukiwanie elementow");
                        buttons[0].setText("Wyszukaj pracownika");
                        buttons[1].setText("Wyszukaj studenta");
                        buttons[2].setText("Wyszukaj kurs");
                        for (int i = 0; i < 3; i++)
                        {
                            buttons[i].setVisible(true);
                        }
                        break;
                    case 1:
                        addHeader("Wyszukaj Pracownika poprzez:");

                        buttons[0].setText("Imie");
                        buttons[1].setText("Nazwisko");
                        buttons[2].setText("Staz");
                        buttons[3].setText("Liczbe nadgodzin");
                        buttons[4].setText("Stanowisko");
                        buttons[5].setText("Pensje");
                        for (int i = 0; i < 6; i++)
                        {
                            buttons[i].setVisible(true);
                        }
                        break;
                    case 2:
                        addHeader("Wyszukaj Studenta poprzez:");

                        buttons[0].setText("Imie");
                        buttons[1].setText("Nazwisko");
                        buttons[2].setText("Nr indeksu");
                        buttons[3].setText("Stopien studiow");
                        for (int i = 0; i < 4; i++)
                        {
                            buttons[i].setVisible(true);
                        }
                        break;
                    case 3:
                        addHeader("Wyszukaj Kurs poprzez:");

                        buttons[0].setText("Nazwe kursu");
                        buttons[1].setText("Nazwisko prowadzacego");
                        buttons[2].setText("Imie prowadzacego");
                        buttons[3].setText("Pesel prowadzacego");
                        buttons[4].setText("Punkty ECTS");
                        for (int i = 0; i < 5; i++)
                        {
                            buttons[i].setVisible(true);
                        }
                        break;
                }
                break;
            case 4:
                addHeader("Zapisywanie/Wczytywanie bazy");
                buttons[0].setText("Zapis bazy");
                buttons[1].setText("Wczytanie bazy");

                for( int i = 0; i < 2; i++)
                {
                    buttons[i].setVisible(true);
                }
                break;
            case 5:
                switch (t2)
                {
                    case 0:
                        addHeader("Usuwanie elementow");
                        buttons[0].setText("Usun pracownika");
                        buttons[1].setText("Usun studenta");
                        buttons[2].setText("Usun kurs");
                        for (int i = 0; i < 3; i++)
                        {
                            buttons[i].setVisible(true);
                        }
                        break;
                    case 1:
                        addHeader("Usun Pracownika poprzez:");

                        buttons[0].setText("Imie");
                        buttons[1].setText("Nazwisko");
                        buttons[2].setText("Staz");
                        buttons[3].setText("Liczbe nadgodzin");

                        for (int i = 0; i < 4; i++)
                        {
                            buttons[i].setVisible(true);
                        }
                        break;
                    case 2:
                        addHeader("Usun Studenta poprzez:");

                        buttons[0].setText("Imie");
                        buttons[1].setText("Nazwisko");
                        buttons[2].setText("Nr indeksu");
                        buttons[3].setText("Stopien studiow");
                        for (int i = 0; i < 4; i++)
                        {
                            buttons[i].setVisible(true);
                        }
                        break;
                    case 3:
                        addHeader("Usun Kurs poprzez:");

                        buttons[0].setText("Nazwe kursu");
                        buttons[1].setText("Nazwisko prowadzacego");
                        buttons[3].setText("Pesel prowadzacego");
                        buttons[4].setText("Punkty ECTS");
                        for (int i = 0; i < 4; i++)
                        {
                            buttons[i].setVisible(true);
                        }
                        break;
                }
                break;
            case 6:
                switch (t2)
                {
                    case 0:
                        addHeader("Posortuj liste");


                        buttons[0].setText("Lista Osob");
                        buttons[1].setText("Lista Kursow");

                        for (int i = 0; i < 2; i++) {
                            buttons[i].setVisible(true);
                        }
                    break;
                    case 1:
                        addHeader("Sortowanie listy osob poprzez:");

                        buttons[0].setText("Nazwisko");
                        buttons[1].setText("Nazwisko i imie");
                        buttons[2].setText("Nazwisko i wiek");

                        for (int i = 0; i < 3; i++) {
                            buttons[i].setVisible(true);
                        }
                        break;
                    case 2:
                        addHeader("Sortowanie listy kursow poprzez:");

                        buttons[0].setText("ECTS i Nazwisko prowadzecego");
                        buttons[0].setVisible(true);
                        break;
                }

        }

    }

    private void addHeader(String a)
    {
        panels[0].add(header);
        header.setText(a);
        header.setForeground(Color.WHITE);
        header.setFont(new Font( "Arial", Font.PLAIN, 25));
        //Na gornym panelu info w stylu (Wyszukaj studenta poprzez:)
    }

    private void buttonReset()
    {
        for( int i = 0; i < liczba; i++)
        {
            buttons[i].setVisible(false);
            for( ActionListener al : buttons[i].getActionListeners())
            {
                buttons[i].removeActionListener(al);
            }
        }
    }

    private void createPanels()
    {
        for( int i = 0; i < liczbaP; i++)
            panels[i] = new JPanel();
    }
}
