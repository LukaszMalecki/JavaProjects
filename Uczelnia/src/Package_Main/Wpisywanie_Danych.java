package Package_Main;

import Package_Osoba.*;
import Package_Kursy.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Wpisywanie_Danych {
    private final static String[] sP_Bad_Dyd =
            {"Asystent", "Adiunkt", "Profesor Nadzwyczajny", "Profesor Zwyczajny", "Wykladowca"};
    //mozliwosci Stanowiska Pracownika Badawczo-Dydaktycznego
    private final static String[] sP_Adm =
            {"Referent", "Specjalista", "Starszy Specjalista"};
    //mozliwosci Stanowiska Pracownika Administracyjnego
    private final static String lP_Os =
            "Imie, Nazwisko, Pesel, Wiek, Plec (M lub K)";
            //lista pol osoby
    private final static String[] lP_Stud =
                    {"Nr indeksu",
                            "Dla nastepnych trzech wpisywac True - gdy zdanie jest prawdziwe albo False - w przeciwnym wypadku"
                            , "Jest uczestnikiem programu ERASMUS", "Jest studentem na I stopniu studiow",
                    "Jest zapisany na studia stacjonarne"}; //inne niz False tez uzna za false

    private final static String lP_Prac = "Staz pracy (w latach), Pensja";

    private final static String lP_PracAdm = "Liczba nadgodzin";
    private final static String lP_PracBadDyd = "Punktacja ZDN";

    private final static String lP_Kurs = "Nazwa kursu, Pesel Prowadzacego, Punkty ETC";
    //"##ERROR##", -1, '#'  - informacja o zlych danych

    public Wpisywanie_Danych() {
    }

    //funkcje interfejsu

    public void menu() {
        System.out.printf("Wpisz jedna z podanych liczb aby wykonac podane dzialanie:%n" +
                "%2d - dodac Studenta%n%2d - dodac Pracownika Uczelni%n" +
                "%2d - dodac Kurs%n" +
                "%2d - zapisac baze danych%n" +
                "%2d - wczytac baze danych%n" +
                "%2d - wyswietl listy%n" +
                "%2d - wyswietl liste studentow z kursami%n" +
                "%2d - dodaj kursy Studentowi%n" +
                "%2d - posortuj listy%n" +
                "%2d - usun elementy z listy%n" +
                "%n%2d - wyjsc z programu%n", 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0);
    }

    //ETAP 3

    public void menuSort() {

        System.out.printf("Wpisz jedna z podanych liczb aby wykonac podane dzialanie:%n" +
                "%2d - sortuj liste osob wedlug Nazwiska%n" +
                "%2d - sortuj liste osob wedlug Nazwiska i Imienia%n" +
                "%2d - sortuj liste osob wedlug Nazwiska i Wieku%n" +
                "%2d - sortuj liste osob wedlug ECTS i Nazwiska Prowadzacego%n" +
                "%n%2d - powroc do menu glownego%n", 1, 2, 3, 4, 0);
    }

    //funkcje do dopisywania rzeczy

                    //PRZYPOMNIENIE//:
    //"##ERROR##", -1, '#'  - informacja o zlych danych


    public int sprawdzLiczbaNieUjemna( String a) //sprawdza, czy jest to liczba i czy nie jest ujemna
    {
        int n = -1;

        try
        {
            n = Integer.parseInt(a);
        }
        catch( Exception e)
        {
            return -1;
        }
        if( n < 0)
            return -1;
        return n;
    }

    //Dla Klasy Osoba:
    public String sprawdzPesel( String a) //sprawdza, czy sa to same liczby
    // (tutaj dla uproszczenia wpisywania danych nie wymaga konkretnej liczby znakow)
    {
        /*
        if( a.length() != 11)
            return "##ERROR##";
        */
        int min = '0';
        int max = '9';
        int v;
        for( int i = 0; i < a.length(); i++)
        {
            v = a.charAt(i);
            if( v > max || v < min)
                return "##ERROR##";
        }
        return a;
    }
    public int sprawdzWiek( String a) //sprawdza, czy jest to liczba i czy nie jest ujemna,
    // ewentualnie moglaby sprawdzac czy nie jest wiekszy od jakiejs liczby, jesli sie zmodyfiukuje
    {
        return sprawdzLiczbaNieUjemna(a);
    }
    public char sprawdzPlec( String a) //sprawdza, czy jest to pojedynczy znak M lub K
    // (mozna w przyszlosci ulepszyc by zatwierdzalo cale slowa i konwertowalo na M lub K
    {
        if( a.length() != 1)
            return '#';

        switch (a.charAt(0))
        {
            case 'm':
            case 'M':
                return 'M';
            case 'k':
            case 'K':
                return 'K';
            default:
                return '#';
        }
    }

    //Dla Klasy Student
    public int sprawdzNrIndeksu( String a) //sprawdza, czy spelnia wymagania bycia numerem indeksu
    {
        //poki co nie ma zadnego ustalonego wygladu numeru indeksu zatem uzywam wczesniejszej funkcji
        return sprawdzLiczbaNieUjemna(a);
    }
    public short sprawdzCzy( String a)
    {
        if( a.equals("Tak") || a.equals("tak"))
            a = "True";

        boolean l = false;

        try
        {
            l = Boolean.parseBoolean(a);
        }
        catch( Exception e)
        {
            return -1;
        }

        if( l == true)
            return 1;
        else
            return 0;

    }

    public Student wpisz_stud()
    {
        System.out.println("Prosze podac nastepujace dane potencjalnego Studenta " +
                "(rozdzielone spacja, bez polskich znakow, w jednej linijce):\n");
        System.out.println(lP_Os + ", " + lP_Stud[0] +"\n" + lP_Stud[1] + ":\n");
        for( int i = 2; i < lP_Stud.length; i++)
            System.out.println("-" + lP_Stud[i]);
        System.out.print("\n");

        Scanner wej = new Scanner(System.in);
        String s = wej.nextLine();

        return wpisz_stud_Funk( s );
    }

    public Student wpisz_stud_GUI( String s)
    {
        return wpisz_stud_Funk( s );
    }

    public Student wpisz_stud_Funk( String s)
    {
        /*System.out.println("Prosze podac nastepujace dane potencjalnego Studenta " +
                "(rozdzielone spacja, bez polskich znakow, w jednej linijce):\n");
        System.out.println(lP_Os + ", " + lP_Stud[0] +"\n" + lP_Stud[1] + ":\n");
        for( int i = 2; i < lP_Stud.length; i++)
            System.out.println("-" + lP_Stud[i]);
        System.out.print("\n");

        Scanner wej = new Scanner(System.in);

        String s = wej.nextLine();*/
        String[] tok = s.split(" ");

        if( tok.length != 9)
            return null;

        Student stud = new Student();

        stud.setImie(tok[0]);
        stud.setNazwisko((tok[1]));

        if(sprawdzPesel(tok[2]).equals("##ERROR##"))
            return null;
        stud.setPesel(tok[2]);

        int w = sprawdzWiek(tok[3]);
        if( w == -1)
            return null;
        stud.setWiek(w);

        char p = sprawdzPlec(tok[4]);
        if( p == '#')
            return null;
        stud.setPlec(p);

        w = sprawdzNrIndeksu(tok[5]);
        if( w == -1)
            return null;
        stud.setNrIndeksu(w);

        boolean[] log = new boolean[3];
        short t = 0;

        for( int i = 0; i < 3; i++)
        {
            t = sprawdzCzy(tok[6+i]);

            if( t == -1)
                return null;
            if( t == 0)
                log[i] = false;
            else
                log[i] = true;
        }

        stud.setStud_eras(log[0]);
        stud.setStud_Istopien(log[1]);
        stud.setStud_stac(log[2]);

        return stud;
    }

    //Dla Klasy Pracownik Uczelni
    public int sprawdzStazPracy( String a)
    {
        return sprawdzLiczbaNieUjemna(a);
    }
    public double sprawdzPensja( String a)
    {
        a = a.replaceFirst(",",".");
        if( a.contains(","))
            return -1;
        double f = -1;
        try
        {
            f = Double.parseDouble(a);
        }
        catch (Exception e)
        {
            return -1;
        }
        return f;
    }
    public int sprawdzLiczbaNadgodzin( String a)
    {
        return sprawdzLiczbaNieUjemna(a);
    }
    public int sprawdzPunktacjaZDN( String a)
    {
        return sprawdzLiczbaNieUjemna(a);
    }

    public String[] rodzaj_prac()
    {
        String[] p = new String[2]; //p[0] = A lub B, p[1] - stanowisko
        System.out.println("Prosze podac stanowisko pracownika (w jednej linijce)");

        Scanner wej = new Scanner(System.in);
        //wczytanie stanowiska
        while(!wej.hasNext())
        {
            wej.next();
        }

        String s = "";
        do
        {
            s = wej.nextLine();
        }while(s.length() == 0);

        p[1] = s;

        for( int i = 0; i < sP_Bad_Dyd.length; i++)
        {
            if( p[1].equals(sP_Bad_Dyd[i]))
            {
                p[0] = "B";
                return p;
            }
        }
        for( int i = 0; i < sP_Adm.length; i++)
        {
            if( p[1].equals(sP_Adm[i]))
            {
                p[0] = "A";
                return p;
            }
        }

        int t = 0;
        System.out.println("Prosze podac 1 - jesli jest to pracownik badawczo-dydaktyczny " +
                "albo 2 - jesli jest to pracownik administracyjny");
        try
        {
            t = wej.nextInt();
        }
        catch (Exception e)
        {
            p[0] = "#";
            return p;
        }

        if( t == 1)
        {
            p[0] = "B";
            return p;
        }
        if( t == 2)
        {
            p[0] = "A";
            return p;
        }
        p[0] = "#";
        return p;
    }

    public String[] rodzaj_prac_GUI(String s)
    {
        String[] p = new String[2]; //p[0] = A lub B, p[1] - stanowisko

        String[] r = s.split(" ");

        int l = 0;
        for( int i = 0; i < r.length; i++)
        {
            if( r[i].length() > 0)
                l++;
        }

        if( l < 2)
        {
            p[0] = "#";
            return p;
        }

        if( !(r[0].equals("A") || r[0].equals("B")))
        {
            p[0] = "#";
            return p;
        }
        p[0] = r[0];
        p[1] = r[1];

        for( int i = 2; i < r.length; i++)
        {
            p[1] += (" " + r[i]);
        }

        return p;
    }

    public Pracownik_Badawczo_Dydaktyczny wpisz_prac_baddyd_GUI( String q, String s)
    {
        Pracownik_Badawczo_Dydaktyczny prac = new Pracownik_Badawczo_Dydaktyczny();

        String[] tok = s.split(" ");

        if( tok.length != 8)
            return null;

        prac.setStanowisko(q);

        prac.setImie(tok[0]);
        prac.setNazwisko((tok[1]));

        if(sprawdzPesel(tok[2]).equals("##ERROR##"))
            return null;
        prac.setPesel(tok[2]);

        int w = sprawdzWiek(tok[3]);
        if( w == -1)
            return null;
        prac.setWiek(w);

        char p = sprawdzPlec(tok[4]);
        if( p == '#')
            return null;
        prac.setPlec(p);

        w = sprawdzStazPracy(tok[5]);
        if( w == -1)
            return null;
        prac.setStazPracy(w);

        double f = sprawdzPensja(tok[6]);
        if( f == -1)
            return null;
        prac.setPensja(f);

        w = sprawdzPunktacjaZDN(tok[7]);
        if( w == -1)
            return null;
        prac.setPunktacjaZDN(w);

        return prac;
    }

    public Pracownik_Administracyjny wpisz_prac_adm_GUI( String q, String s)
    {
        Pracownik_Administracyjny prac = new Pracownik_Administracyjny();
        String[] tok = s.split(" ");

        if( tok.length != 8)
            return null;

        prac.setStanowisko(q);

        prac.setImie(tok[0]);
        prac.setNazwisko((tok[1]));

        if(sprawdzPesel(tok[2]).equals("##ERROR##"))
            return null;
        prac.setPesel(tok[2]);

        int w = sprawdzWiek(tok[3]);
        if( w == -1)
            return null;
        prac.setWiek(w);

        char p = sprawdzPlec(tok[4]);
        if( p == '#')
            return null;
        prac.setPlec(p);

        w = sprawdzStazPracy(tok[5]);
        if( w == -1)
            return null;
        prac.setStazPracy(w);

        double f = sprawdzPensja(tok[6]);
        if( f == -1)
            return null;
        prac.setPensja(f);

        w = sprawdzLiczbaNadgodzin(tok[7]);
        if( w == -1)
            return null;
        prac.setLiczbaNadgodzin(w);

        return prac;
    }


    public Pracownik_Administracyjny wpisz_prac_adm( String q)
    {
        Pracownik_Administracyjny prac = new Pracownik_Administracyjny();

        System.out.println("Prosze podac nastepujace dane potencjalnego Pracownika Administracyjnego " +
                "(rozdzielone spacja, bez polskich znakow, w jednej linijce):\n");
        System.out.println(lP_Os + ", " + lP_Prac + ", " + lP_PracAdm + "\n");

        Scanner wej = new Scanner(System.in);

        String s = wej.nextLine();
        String[] tok = s.split(" ");

        if( tok.length != 8)
            return null;

        prac.setStanowisko(q);

        prac.setImie(tok[0]);
        prac.setNazwisko((tok[1]));

        if(sprawdzPesel(tok[2]).equals("##ERROR##"))
            return null;
        prac.setPesel(tok[2]);

        int w = sprawdzWiek(tok[3]);
        if( w == -1)
            return null;
        prac.setWiek(w);

        char p = sprawdzPlec(tok[4]);
        if( p == '#')
            return null;
        prac.setPlec(p);

        w = sprawdzStazPracy(tok[5]);
        if( w == -1)
            return null;
        prac.setStazPracy(w);

        double f = sprawdzPensja(tok[6]);
        if( f == -1)
            return null;
        prac.setPensja(f);

        w = sprawdzLiczbaNadgodzin(tok[7]);
        if( w == -1)
            return null;
        prac.setLiczbaNadgodzin(w);

        return prac;
    }

    public Pracownik_Badawczo_Dydaktyczny wpisz_prac_baddyd( String q)
    {
        Pracownik_Badawczo_Dydaktyczny prac = new Pracownik_Badawczo_Dydaktyczny();

        System.out.println("Prosze podac nastepujace dane potencjalnego Pracownika Badawczo-Dydaktycznego " +
                "(rozdzielone spacja, bez polskich znakow, w jednej linijce):\n");
        System.out.println(lP_Os + ", " + lP_Prac + ", " + lP_PracBadDyd + "\n");

        Scanner wej = new Scanner(System.in);

        String s = wej.nextLine();
        String[] tok = s.split(" ");

        if( tok.length != 8)
            return null;

        prac.setStanowisko(q);

        prac.setImie(tok[0]);
        prac.setNazwisko((tok[1]));

        if(sprawdzPesel(tok[2]).equals("##ERROR##"))
            return null;
        prac.setPesel(tok[2]);

        int w = sprawdzWiek(tok[3]);
        if( w == -1)
            return null;
        prac.setWiek(w);

        char p = sprawdzPlec(tok[4]);
        if( p == '#')
            return null;
        prac.setPlec(p);

        w = sprawdzStazPracy(tok[5]);
        if( w == -1)
            return null;
        prac.setStazPracy(w);

        double f = sprawdzPensja(tok[6]);
        if( f == -1)
            return null;
        prac.setPensja(f);

        w = sprawdzPunktacjaZDN(tok[7]);
        if( w == -1)
            return null;
        prac.setPunktacjaZDN(w);

        return prac;
    }

    //Dla Klasy Kursy
    public int sprawdzETC( String a)
    {
        return sprawdzLiczbaNieUjemna(a);
    }

    public Kursy wpisz_kurs()
    {
        System.out.println("Prosze podac nastepujace dane potencjalnego Kursu " +
                "(rozdzielone spacja, bez polskich znakow, w jednej linijce):\n");
        System.out.println(lP_Kurs + "\n");

        Scanner wej = new Scanner(System.in);

        String s = wej.nextLine();
        String[] tok = s.split(" ");

        if( tok.length != 3)
            return null;

        Kursy k = new Kursy();

        k.setNazwaKursu(tok[0]);

        if(sprawdzPesel(tok[1]).equals("##ERROR##"))
            return null;
        k.setPeselProwadzacego(tok[1]);

        int w = sprawdzETC((tok[2]));
        if( w == -1)
            return null;
        k.setPunktyETC(w);

        return k;
    }

    //Porzucona wersja

    /*public ArrayList wczytaj_Os()
    {
        ArrayList list = new ArrayList(5);
        try(Scanner wej = new Scanner(System.in))
        {
            for( int i = 0; i < 3; i++)
                list.set(i, (String)wej.next());
            int k = wej.nextInt();
            if( k < 0)
            {
                list.clear();
                list.set(0, "ERROR_ZLE_DANE");
                return list;
            }
            list.set(3, wej.nextInt());
            String t = wej.next();
            if( t.length() != 1)
            {
                list.clear();
                list.set(0, "ERROR_ZLE_DANE");
                return list;
            }
            char s = t.charAt(0);
            if( !(t.equals('M') || t.equals('K')) )
            {
                list.clear();
                list.set(0, "ERROR_ZLE_DANE");
                return list;
            }
            list.set(4, s);
        } catch( Exception e)
        {
            list.clear();
            list.set(0, "ERROR_ZLE_DANE");
            return list;
        }

    }*/
    /*public ArrayList wczytaj_Os( String[] os)
    {
        ArrayList list = new ArrayList(5);

        //list.set(0, "ERROR_ZLE_DANE");
        list.add("ERROR_ZLE_DANE");
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);

        for( int i = 0; i < 3; i++)
            list.set(i, os[i]);
        int t = 0;
        try
        {
            t = Integer.parseInt(os[3]);
            list.set(3, t);
        }catch( Exception e)
        {
            list.clear();
            list.add(0, "ERROR_ZLE_DANE");
            return list;
        }
        finally
        {
            if( t < 0)
            {
                list.clear();
                list.add(0, "ERROR_ZLE_DANE");
                return list;
            }
        }

        if( os[4].length() != 1)
        {
            list.clear();
            list.add(0, "ERROR_ZLE_DANE");
            return list;
        }

        char s = os[4].charAt(0);
        if( !(s == 'M' || s == 'K') )
        {
            list.clear();
            list.add(0, "ERROR_ZLE_DANE");
            return list;
        }
        list.add(4, s);

        return list;
    }

    public ArrayList wczytaj_Stud( String[] os)
    {
        ArrayList list = new ArrayList(4);

        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);


        list.set(0, -1);

        int t = 0;
        try
        {
            t = Integer.parseInt(os[0]);
            list.set(0, t);
        }catch( Exception e)
        {
            list.clear();
            list.add(0, -1);
            return list;
        }
        finally
        {
            if( t < 0)
            {
                list.clear();
                list.add(0, -1);
                return list;
            }
        }

        for( int i = 1; i < 4; i++)
        {
            try
            {
                boolean b = Boolean.parseBoolean(os[i]);
                list.set(i, b);
            }
            catch ( Exception e)
            {
                list.clear();
                list.add(0, -1);
                return list;
            }

        }

        return list;
    }

    public Student wpisz_stud()
    {
        System.out.println("Prosze podac nastepujace dane potencjalnego Studenta " +
                "(rozdzielone spacja, bez polskich znakow, w jednej linijce):\n");
        System.out.println(lP_Os + ", " + lP_Stud[0] +"\n" + lP_Stud[1] + ":\n");
        for( int i = 2; i < lP_Stud.length; i++)
            System.out.println("-" + lP_Stud[i]);
        System.out.print("\n");

        Scanner wej = new Scanner(System.in);

        String s = wej.nextLine();
        String[] tok = s.split(" ");

        if( tok.length != 9)
            return null;
        String[] osob = {tok[0], tok[1], tok[2], tok[3], tok[4]};
        ArrayList os = wczytaj_Os(osob);

        if( os.get(0).equals("ERROR_ZLE_DANE"))
            return null;

        String[] stud = { tok[5], tok[6], tok[7], tok[8]};

        ArrayList st = wczytaj_Stud(stud);

        if( (int)st.get(0) == -1)
            return null;

        try
        {
            Student student1 = new Student((String)(os.get(0)),(String)os.get(1), (String)os.get(2), (int)os.get(3), (char)os.get(4),
                    (int)st.get(0), (boolean)st.get(1), (boolean)st.get(2), (boolean)st.get(3));
            return student1;
        } catch( Exception e)
        {
            return null;
        }

    }*/
}
