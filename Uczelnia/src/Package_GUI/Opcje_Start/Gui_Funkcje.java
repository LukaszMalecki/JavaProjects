package Package_GUI.Opcje_Start;

import Package_GUI.Gui_Start;
import Package_Kursy.Kursy;
import Package_Main.Usuwanie_Danych;
import Package_Main.Wpisywanie_Danych;
import Package_Osoba.Pracownik_Administracyjny;
import Package_Osoba.Pracownik_Badawczo_Dydaktyczny;
import Package_Osoba.Pracownik_Uczelni;
import Package_Osoba.Student;
import Package_Uczelnia.Uczelnia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Gui_Funkcje
{
    private int t1;
    private int t2;
    private int t3;

    private final int liczbaP = 3;

    private Uczelnia uwu;
    private Wpisywanie_Danych wp = new Wpisywanie_Danych();
    private Usuwanie_Danych up;

    private JFrame frame;

    private JButton buttonExit = new JButton("Powrot do menu"); //Wyjscie
    private JPanel[] panels = new JPanel[liczbaP];

    public Gui_Funkcje( Uczelnia uwu, int t1_, int t2_, int t3_)
    {
        this.uwu = uwu;
        up = new Usuwanie_Danych(uwu);
        t1 = t1_;
        t2 = t2_;
        t3 = t3_;

        boolean open = true;

        if( t1 == 0)
        {
            new Gui_Start(uwu, t1, t2, t3);
            open = false;
        }
        else if( t2 == 0)
        {
            new Gui_Start(uwu, t1, t2, t3);
            open = false;
        }
        else if( (t1 == 3 || t1 == 5 || t1 == 6) && t3 == 0)
        {
                new Gui_Start(uwu, t1, t2, t3);
                open = false;
        }
        else
        {
            utworzFrame();
        }
    }

    //Student s = wp.wpisz_stud_GUI("uwu");

    public void utworzFrame()
    {
        frame = new JFrame();
        final int x = 1080;
        final int y = 810;

        for( int i = 0; i < liczbaP; i++)
            panels[i] = new JPanel();

        frame.setLayout( new BorderLayout());

        panels[0].setPreferredSize(new Dimension(x, 50));
        panels[1].setPreferredSize(new Dimension(x*1, 660));
        panels[2].setPreferredSize(new Dimension(x*1, 100));

        frame.add(panels[0], BorderLayout.NORTH);
        frame.add(panels[1], BorderLayout.CENTER);
        frame.add(panels[2], BorderLayout.SOUTH);


        panels[2].setLayout(new FlowLayout());
        panels[2].add(buttonExit);
        buttonExit.addActionListener(new ActionExit());

        buttonExit.setPreferredSize(new Dimension(150,40));

        frame.setSize(new Dimension(x,y));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);

        funkcjonalnosc();

    }

    public void funkcjonalnosc()
    {
        switch (t1)
        {
            case 1:
                switch (t2)
                {
                    case 1:
                        funkcja_Dodaj_Student();
                        break;
                    case 2:
                        funkcja_Dodaj_Pracownik_Rodzaj();
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                }
                break;
            case 2:
                switch (t2)
                {
                    case 1:
                        funkcja_Wyswietl_Wszystkich();
                        break;
                    case 2:
                        funkcja_Wyswietl_Studentow_Kursy();
                        break;
                    case 3:
                        funkcja_Wyswietl_Pracownikow();
                        break;
                }
                break;
            case 3:
                switch (t2)
                {
                    case 1:
                        funkcja_Wyszukaj_Pracownika(t3);
                        break;
                        /*switch (t3)
                        {
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            case 6:
                                break;
                        }*/
                    case 2:
                        funkcja_Wyszukaj_Studenta(t3);
                        break;
                    case 3:
                        funkcja_Wyszukaj_Kurs(t3);
                        break;
                }
            break;
            case 4:
                switch (t2)
                {
                    case 1:
                        funkcja_Zapisywanie_Bazy();
                        break;
                    case 2:
                        funkcja_Wczytywanie_Bazy();
                        break;
                }
                break;
            case 5:
                switch (t2)
                {
                    case 1:
                        switch (t3)
                        {
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                        }
                        break;
                    case 2:
                        switch (t3)
                        {
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                        }
                        break;
                    case 3:
                        switch (t3)
                        {
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                        }
                        break;
                }
                break;
            case 6:
                switch (t2)
                {
                    case 1:
                        funkcja_SortujOsoby(t3);
                        break;
                    case 2:
                        funkcja_SortujKursy(t3);
                        break;
                }
                break;
        }
    }


    class ActionExit implements ActionListener
    {
        public void actionPerformed( ActionEvent eve)
        {
            frame.dispose();
            new Gui_Start(uwu, 0, 0, 0);
        }
    }

    public void funkcja_Zapisywanie_Bazy()
    {

        panels[1].setLayout( new GridLayout(1,1));
        //panels[1].setLayout( new BoxLayout(panels[1], BoxLayout.Y_AXIS));
        //panels[1].setLayout( new BorderLayout());

        int stan = uwu.serializuj_GUI();

        JLabel napis = new JLabel();

        if( stan == 0)
        {
            napis.setText("Nie udalo sie zapisac bazy danych");
        }
        else if( stan == 1)
        {
            napis.setText("Udalo sie tylko czesciowo zapisac bazy danych");
        }
        else
        {
            napis.setText("Pomyslnie udalo sie zapisac bazy danych");
        }
        //napis.setHorizontalTextPosition(JLabel.CENTER);
        napis.setHorizontalAlignment(JLabel.CENTER);

        napis.setFont( new Font("Courier", Font.PLAIN, 30) );
        panels[1].add(napis);
    }
    public void funkcja_Wczytywanie_Bazy()
    {

        panels[1].setLayout( new GridLayout(1,1));
        //panels[1].setLayout( new BoxLayout(panels[1], BoxLayout.Y_AXIS));
        //panels[1].setLayout( new BorderLayout());

        int stan = uwu.deserializuj_nadpisz_GUI();

        JLabel napis = new JLabel();

        if( stan == 0)
        {
            napis.setText("Nie udalo sie wczytac bazy danych");
        }
        else if( stan == 1)
        {
            napis.setText("Udalo sie tylko czesciowo wczytac bazy danych");
        }
        else
        {
            napis.setText("Pomyslnie udalo sie wczytac bazy danych");
        }
        //napis.setHorizontalTextPosition(JLabel.CENTER);
        napis.setHorizontalAlignment(JLabel.CENTER);

        napis.setFont( new Font("Courier", Font.PLAIN, 30) );
        panels[1].add(napis);
    }

    public void funkcja_SortujOsoby( int nr)
    {

        panels[1].setLayout( new GridLayout(1,1));

        JLabel napis = new JLabel();

        if( nr == 1)
        {
            uwu.sortujNaz();
            napis.setText("Pomyslnie udalo sie posortowac liste osob wg Nazwisk");
        }
        else if( nr == 2)
        {
            uwu.sortujNazIm();
            napis.setText("Pomyslnie udalo sie posortowac liste osob wg Nazwisk i Imion");
        }
        else if( nr == 3)
        {
            uwu.sortujNazWiek();
            napis.setText("Pomyslnie udalo sie posortowac liste osob wg Nazwisk i Wieku");
        }
        napis.setHorizontalAlignment(JLabel.CENTER);

        napis.setFont( new Font("Courier", Font.PLAIN, 30) );
        panels[1].add(napis);
    }

    public void funkcja_SortujKursy( int nr)
    {

        panels[1].setLayout( new GridLayout(1,1));

        JLabel napis = new JLabel();

        if( nr == 1)
        {
            uwu.sortujKurs();
            napis.setText("Pomyslnie udalo sie posortowac liste kursow wg ECTS i Nazwisk");
        }

        napis.setHorizontalAlignment(JLabel.CENTER);

        napis.setFont( new Font("Courier", Font.PLAIN, 30) );
        panels[1].add(napis);
    }

    public void funkcja_Wyswietl_Wszystkich()
    {
        ArrayList<Student> stud = uwu.list_stud();
        ArrayList<Pracownik_Uczelni> prac = uwu.list_prac();
        ArrayList<Kursy> kurs = uwu.list_kurs();

        panels[1].setLayout( new GridLayout(2,1));

        JLabel napis = new JLabel();
        napis.setHorizontalAlignment(JLabel.CENTER);

        napis.setFont( new Font("Courier", Font.PLAIN, 30) );

        napis.setText("Wszystkie listy:");
        panels[1].add(napis);

        String[] tab = new String[prac.size()+stud.size()+kurs.size()+16];

        if( tab.length == 16)
        {
            napis.setText("Wszystkie listy sa puste");
            return;
        }

        tab[0] = "--------------------------------------------------------------";
        tab[1] = "Pracownicy Badawczo-Dydaktyczni";
        tab[2] = "Imie-Nazwisko-Pesel-Wiek-Plec-Stanowisko-Staz Pracy-Pensja-ZDN";
        tab[3] = tab[0];
        int i = 4;
        for( Pracownik_Uczelni E : prac)
        {
            if( E instanceof Pracownik_Badawczo_Dydaktyczny)
            {
                tab[i] = E.toString();
                i++;
            }
        }
        tab[i] = "---------------------------------------------------------------------";
        tab[i+1] = "Pracownicy Administracyjni";
        tab[i+2] = "Imie-Nazwisko-Pesel-Wiek-Plec-Stanowisko-Staz Pracy-Pensja-Nadgodziny";
        tab[i+3] = tab[i];
        i += 4;
        for( Pracownik_Uczelni E : prac)
        {
            if( E instanceof Pracownik_Administracyjny)
            {
                tab[i] = E.toString();
                i++;
            }
        }

        tab[i] = "---------------------------------------------------------------------";
        tab[i+1] = "Studenci";
        tab[i+2] = "Imie-Nazwisko-Pesel-Wiek-Plec-Nr Indeksu-Erasmus-Istopien-Stacjonarne";
        tab[i+3] = tab[i];
        i += 4;
        for( Student E : stud)
        {
                tab[i] = E.toString();
                i++;
        }

        tab[i] = "-------------------------------------------------------------------";
        tab[i+1] = "Kursy";
        tab[i+2] = "Nazwa kursu-Imie prowadzacego-Nazwisko prow.-Pesel prow.-Punkty ETC";
        tab[i+3] = tab[i];
        i += 4;
        for( Kursy E : kurs)
        {
            tab[i] = E.toString();
            i++;
        }

        JList list = new JList(tab);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(1);
        list.setFont(new Font( "Consolas", Font.PLAIN, 18));


        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(250, 80));

        panels[1].add(listScroller);

    }

    public void funkcja_Wyswietl_Studentow_Kursy()
    {
        ArrayList<Student> stud = uwu.list_stud();

        panels[1].setLayout( new GridLayout(2,1));

        JLabel napis = new JLabel();
        napis.setHorizontalAlignment(JLabel.CENTER);

        napis.setFont( new Font("Courier", Font.PLAIN, 30) );

        napis.setText("Wszystkie listy:");
        panels[1].add(napis);

        String[] tab = new String[(stud.size())*2+4];

        if( tab.length == 4)
        {
            napis.setText("Lista Studentow jest pusta");
            return;
        }

        int i = 0;

        tab[i] = "---------------------------------------------------------------------";
        tab[i+1] = "Studenci i ich kursy (z peselami prowadzacych)";
        tab[i+2] = "Imie-Nazwisko-Pesel-Wiek-Plec-Nr Indeksu-Erasmus-Istopien-Stacjonarne";
        tab[i+3] = tab[i];
        i += 4;
        for( Student E : stud)
        {
            tab[i] = E.toString();
            i++;
            tab[i] = "";
            int j = 1;
            if( E.getListaKursow().size() == 0)
                tab[i] = "Brak kursow";
            else
                for( Kursy K: E.getListaKursow())
                {
                    tab[i] += j + ")" + K.info() + "; ";
                    j++;
                }
                i++;
        }

        JList list = new JList(tab);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(1);
        list.setFont(new Font( "Consolas", Font.PLAIN, 18));


        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(250, 80));

        panels[1].add(listScroller);
    }

    public void funkcja_Wyswietl_Pracownikow()
    {
        panels[1].setLayout( new GridLayout(2,1));

        JLabel napis = new JLabel();
        napis.setHorizontalAlignment(JLabel.CENTER);

        napis.setFont( new Font("Courier", Font.PLAIN, 30) );

        napis.setText("Lista Pracownikow:");
        panels[1].add(napis);

        ArrayList<Pracownik_Uczelni> prac = uwu.list_prac();



        String[] tab = new String[prac.size()+8];

        if( tab.length == 8)
        {
            napis.setText("Listy pracownikow sa puste");
            return;
        }

        tab[0] = "--------------------------------------------------------------";
        tab[1] = "Pracownicy Badawczo-Dydaktyczni";
        tab[2] = "Imie-Nazwisko-Pesel-Wiek-Plec-Stanowisko-Staz Pracy-Pensja-ZDN";
        tab[3] = tab[0];
        int i = 4;
        for( Pracownik_Uczelni E : prac)
        {
            if( E instanceof Pracownik_Badawczo_Dydaktyczny)
            {
                tab[i] = E.toString();
                i++;
            }
        }
        tab[i] = "---------------------------------------------------------------------";
        tab[i+1] = "Pracownicy Administracyjni";
        tab[i+2] = "Imie-Nazwisko-Pesel-Wiek-Plec-Stanowisko-Staz Pracy-Pensja-Nadgodziny";
        tab[i+3] = tab[i];
        i += 4;
        for( Pracownik_Uczelni E : prac)
        {
            if( E instanceof Pracownik_Administracyjny)
            {
                tab[i] = E.toString();
                i++;
            }
        }


        JList list = new JList(tab);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(1);
        list.setFont(new Font( "Consolas", Font.PLAIN, 18));


        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(250, 80));

        panels[1].add(listScroller);
    }


    public void funkcja_Wyszukaj_Studenta( int nr)
    {


        String s = "";

        if( nr == 1)
        {
            s = "imie";
        }
        else if( nr == 2)
        {
            s = "nazwisko";
        }
        else if( nr == 3)
        {
            s = "nr indeksu";
        }
        else if( nr == 4)
        {
            s = "stopien studiow (1 lub 2)";
        }

        panels[1].setLayout( new GridLayout(4,1));

        JLabel napis = new JLabel();
        napis.setHorizontalAlignment(JLabel.CENTER);

        napis.setFont( new Font("Courier", Font.PLAIN, 30) );

        napis.setText("Wpisz " + s + " studenta");
        panels[1].add(napis);


        JTextField wej = new JTextField();
        wej.setPreferredSize(new Dimension(400, 50));
        wej.setFont( new Font("Courier", Font.PLAIN, 30) );
        JButton szukaj = new JButton("Szukaj");


        panels[1].add(wej);
        panels[1].add(szukaj);

        JList list = new JList();
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(1);
        list.setFont(new Font( "Consolas", Font.PLAIN, 18));


        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(250, 80));

        panels[1].add(listScroller);


        class submit implements ActionListener
        {
            public void actionPerformed( ActionEvent eve)
            {
                ArrayList<Student> stud = new ArrayList<Student>();
                String[] tab = new String[0];
                boolean good = true;

                if( nr == 1)
                {
                    stud = uwu.szukajStudent_im(wej.getText());
                }
                else if( nr  == 2)
                {
                    stud = uwu.szukajStudent_naz(wej.getText());
                }
                else if( nr == 3)
                {
                    try
                    {
                        stud = uwu.szukajStudent_nr(Integer.parseInt(wej.getText()));
                    }
                    catch( Exception E)
                    {
                        wej.setText("Podano zle dane");
                        good = false;
                    }
                }
                else if( nr == 4)
                {
                    try
                    {
                        int stop = Integer.parseInt(wej.getText());
                        boolean p= false;
                        if( stop == 1)
                            p = true;
                        else if( stop == 2)
                            p = false;
                        else
                        {
                            wej.setText("Podano zle dane");
                            good = false;
                        }

                        if( good)
                            stud = uwu.szukajStudent_stopI(p);
                    }
                    catch( Exception E)
                    {
                        wej.setText("Podano zle dane");
                        good = false;
                    }
                }

                if( good)
                {
                    tab = new String[stud.size()];

                    int i = 0;
                    for (Student E : stud) {
                        tab[i] = E.toString();
                        i++;
                    }
                    list.setListData(tab);
                }

            }

        }

        szukaj.addActionListener(new submit());

    }

    public void funkcja_Wyszukaj_Pracownika( int nr)
    {


        String s = "";

        if( nr == 1)
        {
            s = "imie";
        }
        else if( nr == 2)
        {
            s = "nazwisko";
        }
        else if( nr == 3)
        {
            s = "staz";
        }
        else if( nr == 4)
        {
            s = "liczba godzin";
        }
        else if( nr == 5)
        {
            s = "stanowisko";
        }
        else if( nr == 6)
        {
            s = "pensja";
        }

        panels[1].setLayout( new GridLayout(4,1));

        JLabel napis = new JLabel();
        napis.setHorizontalAlignment(JLabel.CENTER);

        napis.setFont( new Font("Courier", Font.PLAIN, 30) );

        napis.setText("Wpisz " + s + " pracownika");
        panels[1].add(napis);


        JTextField wej = new JTextField();
        wej.setPreferredSize(new Dimension(400, 50));
        wej.setFont( new Font("Courier", Font.PLAIN, 30) );
        JButton szukaj = new JButton("Szukaj");


        panels[1].add(wej);
        panels[1].add(szukaj);

        JList list = new JList();
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(1);
        list.setFont(new Font( "Consolas", Font.PLAIN, 18));


        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(250, 80));

        panels[1].add(listScroller);


        class submit implements ActionListener
        {
            public void actionPerformed( ActionEvent eve)
            {
                ArrayList<Pracownik_Uczelni> stud = new ArrayList<Pracownik_Uczelni>();
                String[] tab = new String[0];
                boolean good = true;

                if( nr == 1)
                {
                    stud = uwu.szukajPracownik_im(wej.getText());
                }
                else if( nr  == 2)
                {
                    stud = uwu.szukajPracownik_naz(wej.getText());
                }
                else if( nr == 3)
                {
                    try
                    {
                        stud = uwu.szukajPracownik_staz(Integer.parseInt(wej.getText()));
                    }
                    catch( Exception E)
                    {
                        wej.setText("Podano zle dane");
                        good = false;
                    }
                }
                else if( nr == 4)
                {
                    try
                    {
                        int t = Integer.parseInt(wej.getText());
                        stud = uwu.szukajPracownik_nadgodziny(t);
                    }
                    catch( Exception E)
                    {
                        wej.setText("Podano zle dane");
                        good = false;
                    }
                }
                else if( nr == 5)
                {
                    try
                    {
                        stud = uwu.szukajPracownik_stanowisko((wej.getText()));
                    }
                    catch( Exception E)
                    {
                        wej.setText("Podano zle dane");
                        good = false;
                    }
                }
                else if( nr == 6)
                {
                    double money = wp.sprawdzPensja(wej.getText());
                    if( money == -1)
                    {
                        wej.setText("Podano zle dane");
                        good = false;
                    }
                    else
                    {
                        stud = uwu.szukajPracownik_pensja(money);
                    }
                }

                if( good)
                {
                    tab = new String[stud.size()];

                    int i = 0;
                    for (Pracownik_Uczelni E : stud) {
                        tab[i] = E.toString();
                        i++;
                    }
                    list.setListData(tab);
                }

            }

        }

        szukaj.addActionListener(new submit());

    }
    public void funkcja_Wyszukaj_Kurs( int nr)
    {


        String s = "";

        if( nr == 1)
        {
            s = "nazwe";
        }
        else if( nr == 2)
        {
            s = "nazwisko prowadzacego";
        }
        else if( nr == 3)
        {
            s = "imie prowadzacego";
        }
        else if( nr == 4)
        {
            s = "pesel prowadzacego";
        }
        else if( nr == 5)
        {
            s = "punkty ECTS";
        }

        panels[1].setLayout( new GridLayout(4,1));

        JLabel napis = new JLabel();
        napis.setHorizontalAlignment(JLabel.CENTER);

        napis.setFont( new Font("Courier", Font.PLAIN, 30) );

        napis.setText("Wpisz " + s + " kursu");
        panels[1].add(napis);


        JTextField wej = new JTextField();
        wej.setPreferredSize(new Dimension(400, 50));
        wej.setFont( new Font("Courier", Font.PLAIN, 30) );
        JButton szukaj = new JButton("Szukaj");


        panels[1].add(wej);
        panels[1].add(szukaj);

        JList list = new JList();
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(1);
        list.setFont(new Font( "Consolas", Font.PLAIN, 18));


        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(250, 80));

        panels[1].add(listScroller);


        class submit implements ActionListener
        {
            public void actionPerformed( ActionEvent eve)
            {
                ArrayList<Kursy> stud = new ArrayList<Kursy>();
                String[] tab = new String[0];
                boolean good = true;

                if( nr == 1)
                {
                    stud = uwu.szukajKurs_nazwa(wej.getText());
                }
                else if( nr  == 2)
                {
                    stud = uwu.szukajKurs_nazpro(wej.getText());
                }
                else if( nr == 3)
                {
                    try
                    {
                        stud = uwu.szukajKurs_impro(wej.getText());
                    }
                    catch( Exception E)
                    {
                        wej.setText("Podano zle dane");
                        good = false;
                    }
                }
                else if( nr == 4)
                {
                    try
                    {
                        stud = uwu.szukajKurs_pesel(wej.getText());
                    }
                    catch( Exception E)
                    {
                        wej.setText("Podano zle dane");
                        good = false;
                    }
                }
                else if( nr == 5)
                {
                    try
                    {
                        stud = uwu.szukajKurs_ects(Integer.parseInt(wej.getText()));
                    }
                    catch( Exception E)
                    {
                        wej.setText("Podano zle dane");
                        good = false;
                    }
                }

                if( good)
                {
                    tab = new String[stud.size()];

                    int i = 0;
                    for (Kursy E : stud) {
                        tab[i] = E.toString();
                        i++;
                    }
                    list.setListData(tab);
                }

            }

        }

        szukaj.addActionListener(new submit());

    }

    public void funkcja_Dodaj_Student()
    {


        String[] s = {"Podaj nastepujace dane studenta (rodzielone spacjami):"
                ,"Imie-Nazwisko-Pesel-Wiek-Plec(M lub K)-Nr Indeksu-",
                "Dla nastepnych trzech wpisywac True - gdy zdanie jest prawdziwe albo False - w przeciwnym wypadku",
                "-Jest uczestnikiem programu ERASMUS", "-Jest studentem na I stopniu studiow",
            "-Jest zapisany na studia stacjonarne"};


        panels[1].setLayout( new GridLayout(3,1));

        JList list = new JList(s);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(1);
        list.setFont(new Font( "Consolas", Font.PLAIN, 18));


        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(250, 80));

        panels[1].add(listScroller);


        JTextField wej = new JTextField();
        wej.setPreferredSize(new Dimension(400, 50));
        wej.setFont( new Font("Courier", Font.PLAIN, 30) );
        JButton szukaj = new JButton("Dodaj");


        panels[1].add(wej);
        panels[1].add(szukaj);


        class submit implements ActionListener
        {
            public void actionPerformed( ActionEvent eve)
            {
                boolean good = true;

                Student stud = wp.wpisz_stud_GUI(wej.getText());

                if( stud == null)
                {
                    good = false;
                    wej.setText("Wpisano bledne dane");
                }


                if( good)
                {
                    if(uwu.dodajStudentaBool(stud))
                        wej.setText("Pomyslnie dodano studenta");
                    else
                        wej.setText("Ten student juz jest tu zapisany");
                }

            }

        }

        szukaj.addActionListener(new submit());

    }

    public void funkcja_Dodaj_Pracownik_Rodzaj()
    {
        panels[1].removeAll();


        String[] s = {"Podaj nastepujace dane Pracownika (rodzielone spacjami):"
                ,"Rodzaj profesji: (A - jesli pracownik administracyjny",
        "(B - jesli pracownik badawczo dydaktyczny", "Stanowisko"};


        panels[1].setLayout( new GridLayout(3,1));


        JList list = new JList(s);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(1);
        list.setFont(new Font( "Consolas", Font.PLAIN, 18));


        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(250, 80));

        panels[1].add(listScroller);


        JTextField wej = new JTextField();
        wej.setPreferredSize(new Dimension(400, 50));
        wej.setFont( new Font("Courier", Font.PLAIN, 30) );
        JButton szukaj = new JButton("Dodaj");


        panels[1].add(wej);
        panels[1].add(szukaj);




        class submit implements ActionListener
        {
            public void actionPerformed( ActionEvent eve)
            {
                boolean good = true;

                    String[] stud = wp.rodzaj_prac_GUI(wej.getText());

                    if (stud[0].equals("#")) {
                        good = false;
                        wej.setText("Wpisano bledne dane");
                    }


                    if (good)
                    {
                        frame.dispose();
                        usun_frame();
                        new Gui_Funkcje(uwu, t1, t2, t3, stud[0], stud[1]);

                        /*if(uwu.dodajStudentaBool(stud))
                            wej.setText("Pomyslnie dodano studenta");
                        else
                            wej.setText("Ten student juz jest tu zapisany");*/
                    }
                }


        }

        szukaj.addActionListener(new submit());


    }

    public Gui_Funkcje( Uczelnia uwu, int t1_, int t2_, int t3_, String rodz, String stan)
    {
        this.uwu = uwu;
        up = new Usuwanie_Danych(uwu);
        t1 = t1_;
        t2 = t2_;
        t3 = t3_;

        utworzFrame();
        //new Gui_Start(uwu);
        funkcja_Dodaj_Pracownik(rodz, stan);
    }

    public void funkcja_Dodaj_Pracownik( String rodz, String stan)
    {

        String[] s = {"Podaj nastepujace dane Pracownika (rodzielone spacjami):"
                , "Imie, Nazwisko, Pesel, Wiek, Plec (M lub K)", "Staz pracy (w latach), Pensja", ""};

        if( rodz.equals("A"))
        {
            s[3] = "Liczba nadgodzin";
        }
        else if ( rodz.equals("B"))
        {
            s[3] = "Punktacja ZDN";
        }

        panels[1].setLayout( new GridLayout(3,1));

        int etap = 0;

        JList list = new JList(s);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);
        list.setVisibleRowCount(1);
        list.setFont(new Font( "Consolas", Font.PLAIN, 18));


        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(250, 80));

        panels[1].add(listScroller);


        JTextField wej = new JTextField();
        wej.setPreferredSize(new Dimension(400, 50));
        wej.setFont( new Font("Courier", Font.PLAIN, 30) );
        JButton szukaj = new JButton("Dodaj");


        panels[1].add(wej);
        panels[1].add(szukaj);




        class submit implements ActionListener
        {
            public void actionPerformed( ActionEvent eve)
            {
                boolean good = true;

                if( rodz.equals("A"))
                {
                    Pracownik_Administracyjny prac = new Pracownik_Administracyjny();
                    prac = wp.wpisz_prac_adm_GUI(stan, wej.getText());
                    if( prac == null)
                    {
                        good = false;
                        wej.setText("Wpisano bledne dane");
                    }

                    if( good)
                    {
                        if(uwu.dodajPracownikaBool(prac))
                            wej.setText("Pomyslnie dodano pracownika");
                        else
                            wej.setText("Ten pracownik juz jest tu zatrudniony");
                    }
                }
                else
                {
                    Pracownik_Badawczo_Dydaktyczny prac = new Pracownik_Badawczo_Dydaktyczny();
                    prac = wp.wpisz_prac_baddyd_GUI(stan, wej.getText());
                    if( prac == null)
                    {
                        good = false;
                        wej.setText("Wpisano bledne dane");
                    }

                    if( good)
                    {
                        if(uwu.dodajPracownikaBool(prac))
                            wej.setText("Pomyslnie dodano pracownika");
                        else
                            wej.setText("Ten pracownik juz jest tu zatrudniony");
                    }
                }
                if( good) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                    frame.dispose();
                    new Gui_Funkcje(uwu, t1, t2, t3);
                }

            }

        }

        szukaj.addActionListener(new submit());

    }

    public void usun_frame()
    {
        frame.dispose();
    }
}
