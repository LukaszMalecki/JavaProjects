package Package_Main;

import Package_Uczelnia.*;
import Package_Osoba.*;
import Package_Kursy.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuwanie_Danych
{
    //PRZYPOMNIENIE//:
    //"##ERROR##", -1, '#'  - informacja o zlych danych

    private Uczelnia ucz;

    private Scanner wej = new Scanner(System.in);

    public Usuwanie_Danych( Uczelnia ucz)
    {
        this.ucz = ucz;
    }

    public void start()
    {
        int st;
        do
        {
            menu(0);

            while(!wej.hasNextInt())
            {
                wej.next();
            }
            st = wej.nextInt();

            wybor(st);

            if (st < 0)
                System.out.println("Wyglada na to, ze zostaly wpisane bledne dane," +
                        " prosze postepowac zgodnie z instrukcjami.\n");
            try {
                Thread.sleep(750);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }while( st != 0);
    }

    public void menu(int st)
    {
        switch (st)
        {
            case 0:
                System.out.printf("Wpisz jedna z podanych liczb aby wykonac podane dzialanie:%n" +
                    "%2d - usunac Studentow%n" +
                    "%2d - usunac Pracownikow Uczelni%n" +
                    "%2d - usunac Kursy%n" +
                    "%n%2d - powrot do menu%n", 1, 2, 3, 0);
                break;
            case 1:
                System.out.printf("Wpisz jedna z podanych liczb aby wybrac kryterium usuwania Studentow:%n" +
                        "%2d - Nazwisko%n" +
                        "%2d - Imie%n" +
                        "%2d - Nr Indeksu%n" +
                        "%2d - Stopien Studiow%n" +
                        "%n%2d - anuluj%n", 1, 2, 3, 4, 0);
                break;
            case 2:
                System.out.printf("Wpisz jedna z podanych liczb aby wybrac kryterium usuwania Pracownikow:%n" +
                        "%2d - Nazwisko%n" +
                        "%2d - Imie%n" +
                        "%2d - Staz Pracy%n" +
                        "%2d - Stanowisko%n" +
                        "%n%2d - anuluj%n", 1, 2, 3, 4, 0);
                break;
            case 3:
                System.out.printf("Wpisz jedna z podanych liczb aby wybrac kryterium usuwania Kursow:%n" +
                        "%2d - Nazwa Kursu%n" +
                        "%2d - Nazwisko Prowadzacego%n" +
                        "%2d - Pesel Prowadzacego%n" +
                        "%2d - Punkty ECTS%n" +
                        "%n%2d - anuluj%n", 1, 2, 3, 4, 0);
                break;
            default:
                System.out.println("Bledne dane.\n");
                break;
        }
    }

    public void wybor( int st)
    {
        if( st <= 0)
            return;
        int st2 = 0;

        menu(st);

        st2 = wczytywanie_Int();

        if( st2 <= 0)
            return;

        switch (st)
        {
            case 1:
                usunStud(st2);
                break;
            case 2:
                usunPrac(st2);
                break;
            case 3:
                usunKurs(st2);
                break;
            default:
                return;
        }
    }

    public void usunStud( int st)
    {
        String s;
        int n;
        boolean b;

        switch (st)
        {
            case 1:
                System.out.println("Wpisz Nazwisko:\n");
                s = wczytywanie_String();
                ucz.getListaOsob().removeIf( E -> (E.getNazwisko().equals(s) && E instanceof Student));
                break;
            case 2:
                System.out.println("Wpisz Imie:\n");
                s = wczytywanie_String();
                ucz.getListaOsob().removeIf( E -> (E.getImie().equals(s) && E instanceof Student));
                break;
            case 3:
                System.out.println("Wpisz Nr Indeksu:\n");
                n = wczytywanie_Int();
                ucz.getListaOsob().removeIf( E -> ( (E instanceof Student) && (((Student) E).getNrIndeksu()) == n));
                break;
            case 4:
                System.out.println("Wpisz stopien studiow (1 lub 2):\n");
                n = wczytywanie_Int();
                if( n != 1 && n != 2)
                {
                    System.out.println("Zle podane dane.\n");
                    return;
                }
                b = true;

                if( n == 1)
                    b = true;
                if( n == 2)
                    b = false;

                final boolean b2 = b; //kazalo dac final

                ucz.getListaOsob().removeIf( E -> ( (E instanceof Student) && (((Student) E).isStud_Istopien()) == b2));
                break;
            default:
                System.out.println("Wpisano zle dane.\n");
                break;
        }
    }

    public void usunPrac( int st)
    {
        String s;
        int n;
        boolean b;

        switch (st)
        {
            case 1:
                System.out.println("Wpisz Nazwisko:\n");
                s = wczytywanie_String();
                ucz.getListaOsob().removeIf( E -> (E.getNazwisko().equals(s) && E instanceof Pracownik_Uczelni));
                break;
            case 2:
                System.out.println("Wpisz Imie:\n");
                s = wczytywanie_String();
                ucz.getListaOsob().removeIf( E -> (E.getImie().equals(s) && E instanceof Pracownik_Uczelni));
                break;
            case 3:
                System.out.println("Wpisz Staz w latach:\n");
                n = wczytywanie_Int();
                ucz.getListaOsob().removeIf( E -> ( (E instanceof Pracownik_Uczelni) && (((Pracownik_Uczelni) E).getStazPracy()) == n));
                break;
            case 4:
                System.out.println("Wpisz Stanowisko Pracy w jednej linijce:");
                s = wczytywanie_String();
                ucz.getListaOsob().removeIf( E -> (E instanceof Pracownik_Uczelni && (((Pracownik_Uczelni) E).getStanowisko()).equals(s)));
                break;
            default:
                System.out.println("Wpisano zle dane.\n");
                break;
        }
    }

    public void usunKurs( int st)
    {
        String s;
        int n;
        boolean b;

        switch (st)
        {
            case 1:
                System.out.println("Wpisz Nazwe Kursu w jednej linijce:\n");
                s = wczytywanie_String();
                ucz.getListaKursow().removeIf( E -> (E.getNazwaKursu().equals(s)));
                break;
            case 2:
                System.out.println("Wpisz Nazwisko Prowadzacego:\n");
                s = wczytywanie_String();
                ucz.getListaKursow().removeIf( E -> (E.getNazwiskoProwadzacego().equals(s)));
                break;
            case 3:
                System.out.println("Wpisz Pesel Prowadzacego:\n");
                s = wczytywanie_String();
                ucz.getListaKursow().removeIf( E -> (E.getPeselProwadzacego().equals(s)));
                break;
            case 4:
                System.out.println("Wpisz Liczbe ECTS:\n");
                n = wczytywanie_Int();
                ucz.getListaKursow().removeIf( E -> (E.getPunktyETC() == n));
                break;
        }
    }

    public String wczytywanie_String()
    {
        while(!wej.hasNext())
        {
            wej.next();
        }

        String s = "";
        do
        {
            s = wej.nextLine();
        }while(s.length() == 0);

        return s;
    }

    public int wczytywanie_Int()
    {
        while( !wej.hasNextInt())
        {
            wej.nextLine();
            System.out.println("Wpisano zle dane, sprobuj podobnie");
        }

        int n = wej.nextInt();

        return n;
    }



    /*public void usuwanie()
    {

        //ucz.getListaOsob().removeIf( E -> (E.getNazwisko().equals("Wegiel")));
    }*/

}
