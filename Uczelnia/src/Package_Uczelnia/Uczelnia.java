package Package_Uczelnia;

import java.util.ArrayList;

import Package_Main.Usuwanie_Danych;
import Package_Main.Wpisywanie_Danych;
import Package_Osoba.*;
import Package_Kursy.*;
import Package_Main.Wpisywanie_Danych.*;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

import java.io.ObjectOutputStream;
import java.io.FileOutputStream;

import java.io.ObjectInputStream;
import java.io.FileInputStream;

import java.io.Serializable;


public class Uczelnia implements Serializable {
    private static final long serialVersionUID = 1000000;

    private ArrayList<Osoba> listaOsob;
    private ArrayList<Kursy> listaKursow;

    public Uczelnia() {
        listaOsob = new ArrayList<Osoba>();
        listaKursow = new ArrayList<Kursy>();
    }

    public Uczelnia(ArrayList<Osoba> listaOsob_, ArrayList<Kursy> listaKursow_) {
        listaOsob = listaOsob_;
        listaKursow = listaKursow_;
    }
    ///////////////////
    //Funkcje dla GUI//

    public int serializuj_GUI() {
        listaOsob.trimToSize();
        listaKursow.trimToSize();

        int success = 2;

        try (ObjectOutputStream wyj = new ObjectOutputStream(new FileOutputStream("ListaOsob.ser"))) {
            wyj.writeObject(listaOsob);
        } catch (Exception e) {
            e.printStackTrace();
            success--;
        }

        try (ObjectOutputStream wyj = new ObjectOutputStream(new FileOutputStream("ListaKursow.ser"))) {
            wyj.writeObject(listaKursow);
        } catch (Exception e) {
            e.printStackTrace();
            success--;
        }

        return success;

    }

    public int deserializuj_nadpisz_GUI() {
        //na wypadek bledu nie utracimy obecnej bazy
        ArrayList<Osoba> kopia = new ArrayList<Osoba>(listaOsob);
        ArrayList<Kursy> kopia2 = new ArrayList<Kursy>(listaKursow);

        int success = 2;


        try (ObjectInputStream wej = new ObjectInputStream(new FileInputStream("ListaOsob.ser"))) {
            listaOsob = (ArrayList<Osoba>) wej.readObject();

        } catch (Exception e) {
            e.printStackTrace();
            listaOsob = kopia;

            success--;
        }

        try (ObjectInputStream wej = new ObjectInputStream(new FileInputStream("ListaKursow.ser"))) {
            listaKursow = (ArrayList<Kursy>) wej.readObject();

        } catch (Exception e) {
            e.printStackTrace();
            listaKursow = kopia2;

            success--;
        }

        return success;
    }

    public void sortujNaz()
    {
        Collections.sort(listaOsob, Comparator_Naz);
    }
    public void sortujNazIm()
    {
        Collections.sort(listaOsob, Comparator_NazIm);
    }
    public void sortujNazWiek()
    {
        Collections.sort(listaOsob, Comparator_NazW);
    }
    public void sortujKurs()
    {
        Collections.sort(listaKursow, Comparator_EctsNazP);
    }



    ////////////////////
    ////Serializacja////

    public void serializuj() {
        listaOsob.trimToSize();
        listaKursow.trimToSize();

        boolean success = true;

        try (ObjectOutputStream wyj = new ObjectOutputStream(new FileOutputStream("ListaOsob.ser"))) {
            wyj.writeObject(listaOsob);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Serializacja listy osob nie powiodla sie");
            success = false;
        }

        try (ObjectOutputStream wyj = new ObjectOutputStream(new FileOutputStream("ListaKursow.ser"))) {
            wyj.writeObject(listaKursow);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Serializacja listy kursow nie powiodla sie");

            success = false;
        }

        if (success)
            System.out.println("Pomyslnie dokonano zapisu bazy\n");

    }

    public void deserializuj_nadpisz() {
        //na wypadek bledu nie utracimy obecnej bazy
        ArrayList<Osoba> kopia = new ArrayList<Osoba>(listaOsob);
        ArrayList<Kursy> kopia2 = new ArrayList<Kursy>(listaKursow);

        boolean success = true;


        try (ObjectInputStream wej = new ObjectInputStream(new FileInputStream("ListaOsob.ser"))) {
            listaOsob = (ArrayList<Osoba>) wej.readObject();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Deserializacja listy osob nie powiodla sie");
            listaOsob = kopia;

            success = false;
        }

        try (ObjectInputStream wej = new ObjectInputStream(new FileInputStream("ListaKursow.ser"))) {
            listaKursow = (ArrayList<Kursy>) wej.readObject();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Deserializacja listy kursow nie powiodla sie");
            listaKursow = kopia2;

            success = false;
        }

        if (success)
            System.out.println("Pomyslnie wczytano baze\n");
    }

    ////////////////
    /////ETAP 3/////

    private CompNazwisko Comparator_Naz = new CompNazwisko();
    private CompNazwiskoImie Comparator_NazIm = new CompNazwiskoImie();
    private CompNazwiskoWiek Comparator_NazW = new CompNazwiskoWiek(); //wiek malejaco
    private CompECTSNazwiskoProw Comparator_EctsNazP = new CompECTSNazwiskoProw(); //ECTS malejaco

    class CompNazwisko implements Comparator<Osoba>
    {
        public int compare( Osoba os1, Osoba os2)
        {
            return os1.getNazwisko().compareTo(os2.getNazwisko());
        }
    }

    class CompNazwiskoImie implements Comparator<Osoba>
    {
        public int compare( Osoba os1, Osoba os2)
        {
            if (os1.getNazwisko().compareTo(os2.getNazwisko()) != 0)
                return os1.getNazwisko().compareTo(os2.getNazwisko());
            return os1.getImie().compareTo(os2.getImie());
        }
    }

    class CompNazwiskoWiek implements Comparator<Osoba> //wiek malejaco
    {
        public int compare( Osoba os1, Osoba os2)
        {
            if (os1.getNazwisko().compareTo(os2.getNazwisko()) != 0)
                return os1.getNazwisko().compareTo(os2.getNazwisko());

            if( os1.getWiek() > os2.getWiek())
                return -1;
            if( os1.getWiek() < os2.getWiek())
                return 1;
            return 0;
        }
    }

    class CompECTSNazwiskoProw implements Comparator<Kursy>
    {
        public int compare( Kursy k1, Kursy k2)
        {
            if( k1.getPunktyETC() > k2.getPunktyETC())
                return -1;
            if( k1.getPunktyETC() < k2.getPunktyETC())
                return 1;

            return k1.getNazwiskoProwadzacego().compareTo(k2.getNazwiskoProwadzacego());
        }
    }


    private void opcja_sortowanie()
    {
        Wpisywanie_Danych op = new Wpisywanie_Danych();
        Scanner wej = new Scanner(System.in);

        int st = 0;

        do {
            op.menuSort();

            while (!wej.hasNextInt())
            {
                wej.next();
                st++;
                if (st == 10) {
                    op.menuSort();
                    st = 0;
                }
            }
            st = wej.nextInt();

            switch (st)
            {
                case 1:
                    Collections.sort(listaOsob, Comparator_Naz);
                    break;
                case 2:
                    Collections.sort(listaOsob, Comparator_NazIm);
                    break;
                case 3:
                    Collections.sort(listaOsob, Comparator_NazW);
                    break;
                case 4:
                    Collections.sort(listaKursow, Comparator_EctsNazP);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Wybrano zla liczbe\n");
            }

            if( st > 0 && st <= 4)
                System.out.println("Pomyslnie posortowano liste\n");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }while( st != 0);

        System.out.println("Powrot do menu...\n");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    ////////////////////////////////
    ////Wczytywanie z klawiatury////

    public void start() {
        Scanner wej = new Scanner(System.in);
        //tutaj rzeczy jakas tabelka etc
        Wpisywanie_Danych op = new Wpisywanie_Danych();

        int st = 0;

        do {
            op.menu();

            if (wej.hasNextInt()) {
                st = wej.nextInt();
            } else {
                wej.next();
                st = -1;
            }
            wybor(st);

            if (st < 0)
                System.out.println("Wyglada na to, ze zostaly wpisane bledne dane," +
                        " prosze postepowac zgodnie z instrukcjami.\n");
            try {
                Thread.sleep(750);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (st != 0);

        System.out.println("Do widzenia!\n");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void wybor(int st) {
        Wpisywanie_Danych op = new Wpisywanie_Danych();
        switch (st) {
            case 1:    //dodac studenta
                Student s1 = op.wpisz_stud();
                if (s1 != null) {
                    if (dodajStudentaBool(s1))
                        wpisywanie_kursy(s1);
                } else {
                    System.out.println("Wpisano bledne dane");
                    break;
                }
                break;
            case 2:    //dodac pracownika uczelni
                String p[] = op.rodzaj_prac();
                wpisywanie_pracownik(p);
                break;
            case 3:    //dodac kurs
                Kursy k1 = op.wpisz_kurs();
                if (k1 != null) {
                    String pes = k1.getPeselProwadzacego();
                    Pracownik_Badawczo_Dydaktyczny prac = szukajPracBadDyd_pesel(pes);
                    if (prac != null) {
                        k1.setImieProwadzacego(prac.getImie());
                        k1.setNazwiskoProwadzacego(prac.getNazwisko());

                        dodajKurs(k1);
                        break;
                    }
                    System.out.println("Nie ma Pracownika Badawczo-Dydaktycznego o takim peselu");
                    break;
                }
                System.out.println("Wpisano bledne dane");
                break;
            case 4:
                serializuj();
                break;
            case 5:
                deserializuj_nadpisz();
                break;
            case 6:
                opcja_wyswietlanie();
                break;
            case 7:
                opcja_wyswietl_stud_kurs();
                break;
            case 8:
                opcja_dod_stud_kurs();
                break;
            case 9:
                opcja_sortowanie();
                break;
            case 10:
                Usuwanie_Danych usuw = new Usuwanie_Danych(this);
                usuw.start();
                break;
            default:
                break;

        }
    }

    public void opcja_dod_stud_kurs()
    {
        Scanner wej = new Scanner(System.in);

        int st = 0;

        System.out.println("Prosze wpisac pesel studenta");
        while( !wej.hasNext())
        {
            st++;
            if( st == 10)
            {
                System.out.println("Prosze wpisac pesel studenta");
                st = 0;
            }
        }
        String p = wej.next();

        Student stud = szukajStudent_pesel(p);

        if( stud != null)
        {
            wpisywanie_kursy(stud);
            return;
        }
        else
        {
            System.out.println( "Nie znaleziono studenta o takim peselu");
            return;
        }
    }

    public void opcja_wyswietl_stud_kurs()
    {
        wys_stud_kurs();
        System.out.println( "Wpisz dowolny znak, aby wrocic do menu");

        Scanner wej = new Scanner(System.in);
        wej.nextLine();
        return;
    }

    public void opcja_wyswietlanie()
    {
        wys_all();

        System.out.println( "Wpisz dowolny znak, aby wrocic do menu");

        Scanner wej = new Scanner(System.in);
        wej.nextLine();
        return;
    }

    private void wpisywanie_pracownik( String[] p)
    {
        if( p.length != 2)
        {
            System.out.println("NIEPRZEWIDZIANY BLAD");
            return;
        }

        Wpisywanie_Danych op = new Wpisywanie_Danych();

        if( p[0].equals("A"))
        {
            Pracownik_Administracyjny adm = op.wpisz_prac_adm(p[1]);
            if( adm != null)
                dodajPracownika(adm);
            else
                System.out.println("Wpisano bledne dane");

        }
        else
        {
            if( p[0].equals("B"))
            {
                Pracownik_Badawczo_Dydaktyczny bad = op.wpisz_prac_baddyd(p[1]);
                if( bad != null)
                    dodajPracownika(bad);
                else
                    System.out.println("Wpisano bledne dane");

            }
            else
            {
                System.out.println("Blad, nie dodano pracownika");
                return;
            }
        }

    }

    private void wpisywanie_kursy( Student s)
    {
        listaKursow.trimToSize();
        if( listaKursow.size() == 0)
        {
            System.out.println("Brak dostepnych kursow\n");
            return;
        }
        Wpisywanie_Danych op = new Wpisywanie_Danych();
        Scanner wej = new Scanner(System.in);
        int st = 0;
        do {
            System.out.println("Mozesz zapisac studenta na kursy, wybierajac odpowiedni numer (po jednym numerze na raz)\n\n" +
                    "0) - zakoncz wybieranie");
            wys_kurs_all_nr();
            if(wej.hasNextInt())
            {
                st = wej.nextInt();
            }
            else
            {
                wej.next();
                st = -1;
            }
            if( st < 0 || st > listaKursow.size())
            {
                System.out.println("Wpisano bledne dane");
            }
            else
            {
                if( st != 0)
                {
                    s.dodajKurs(listaKursow.get(st-1));
                }
            }
            try
            {
                Thread.sleep(500);
            } catch( InterruptedException e)
            {
                e.printStackTrace();
            }

        }while( st != 0);

        System.out.println("Zakonczono wybieranie kursow\n");
    }

    /////////////
    ////Osoba////

    private boolean osobaIstnieje( Object a)
    {
        if( !(a instanceof Osoba))
            return false;

        if( (szukajOsoba_pesel( ((Osoba) a).getPesel() )) != null)
            return true;
        return false;
    }

    ///////////////
    ////Student////

    private boolean studentIstnieje( Student stud)
    {
        return osobaIstnieje(stud);
        //return listaOsob.contains(stud); //do sprawdzenia czy dziala
    }

    public void dodajStudenta( Object stud1)
    {
        if( !(stud1 instanceof Student))
        {
            System.out.println("Osoba nie spelnila wymagan by zostac studentem\n");
            return;
        }

        Student stud = (Student)stud1;

        if( !(studentIstnieje(stud)))
        {
            listaOsob.add(stud);
            System.out.println("Dodano studenta o nazwisku " + stud.getNazwisko() + "\n");
        }
        else
        {
            System.out.println("Student o nazwisku " + stud.getNazwisko() + " jest juz na liscie studentow\n");
        }
    }

    public Boolean dodajStudentaBool( Object stud1)
    {
        if( !(stud1 instanceof Student))
        {
            System.out.println("Osoba nie spelnila wymagan by zostac studentem\n");
            return false;
        }

        Student stud = (Student)stud1;

        if( !(studentIstnieje(stud)))
        {
            listaOsob.add(stud);
            System.out.println("Dodano studenta o nazwisku " + stud.getNazwisko() + "\n");
            return true;
        }
        else
        {
            System.out.println("Student o nazwisku " + stud.getNazwisko() + " jest juz na liscie studentow\n");
            return false;
        }
    }

    public void usunStudenta( Student stud)
    {
        if( (studentIstnieje(stud)))
        {
            listaOsob.remove( stud);
            System.out.println("Usunieto studenta o nazwisku " + stud.getNazwisko() + " z listy studentow\n");
        }
        else
        {
            System.out.println("Studenta o nazwisku " + stud.getNazwisko() + " nie bylo na liscie studentow\n");
        }
    }

    /////////////////
    ////Pracownik////


    public boolean pracownikIstnieje( Object prac)
    {
        if( !(prac instanceof Pracownik_Uczelni))
            return false;
        Pracownik_Uczelni prac1 = (Pracownik_Uczelni)prac;
        return osobaIstnieje(prac);
        //return listaOsob.contains(prac1);
    }

    public boolean dodajPracownikaBool( Object prac)
    {
        if( pracownikIstnieje(prac))
        {
            System.out.println("Osoba o nazwisku " + ((Pracownik_Uczelni)prac).getNazwisko() + " jest juz na tej uczelni\n");
            return false;
        }
        if( prac instanceof Pracownik_Badawczo_Dydaktyczny)
        {
            Pracownik_Badawczo_Dydaktyczny prac1 = (Pracownik_Badawczo_Dydaktyczny)prac;
            listaOsob.add(prac1);
            System.out.println("Pracownik Badawczo-Dydaktyczny o nazwisku " + prac1.getNazwisko() + " zostal zatrudniony\n");
            return true;
        }
        else
        {
            if( prac instanceof Pracownik_Administracyjny)
            {
                Pracownik_Administracyjny prac1 = (Pracownik_Administracyjny)prac;
                listaOsob.add(prac1);
                System.out.println("Pracownik Administracyjny o nazwisku " + prac1.getNazwisko() + " zostal zatrudniony\n");
                return true;
            }
            else
            {
                System.out.println("Osoba nie zostala zatrudniona przez brak kwalifikacji\n");
                return false;
            }
        }
    }

    public void dodajPracownika( Object prac)
    {
        if( pracownikIstnieje(prac))
        {
            System.out.println("Osoba o nazwisku " + ((Pracownik_Uczelni)prac).getNazwisko() + " jest juz na tej uczelni\n");
            return;
        }
        if( prac instanceof Pracownik_Badawczo_Dydaktyczny)
        {
            Pracownik_Badawczo_Dydaktyczny prac1 = (Pracownik_Badawczo_Dydaktyczny)prac;
            listaOsob.add(prac1);
            System.out.println("Pracownik Badawczo-Dydaktyczny o nazwisku " + prac1.getNazwisko() + " zostal zatrudniony\n");
            return;
        }
        else
        {
            if( prac instanceof Pracownik_Administracyjny)
            {
                Pracownik_Administracyjny prac1 = (Pracownik_Administracyjny)prac;
                listaOsob.add(prac1);
                System.out.println("Pracownik Administracyjny o nazwisku " + prac1.getNazwisko() + " zostal zatrudniony\n");
                return;
            }
            else
            {
                System.out.println("Osoba nie zostala zatrudniona przez brak kwalifikacji\n");
                return;
            }
        }
    }

    /////////
    //Kursy//

    public boolean kursIstnieje( Kursy kurs)
    {
        return listaKursow.contains(kurs);
    }

    public void dodajKurs( Object kurs1)
    {
        if( !(kurs1 instanceof Kursy))
        {
            System.out.println("Zle wypelniony formularz utworzenia kursu\n");
            return;
        }

        Kursy kurs = (Kursy)kurs1;

        if( kursIstnieje(kurs))
        {
            System.out.println("Pracownik o nazwisku " + kurs.getNazwiskoProwadzacego() +
                    " prowadzi juz kurs " + kurs.getNazwaKursu() + "\n");
            return;
        }
        else
        {
            String p = kurs.getPeselProwadzacego();
            for( int i = 0; i < listaOsob.size(); i++)
            {
                if( listaOsob.get(i).getPesel().equals(p))
                {
                    if( listaOsob.get(i) instanceof Pracownik_Badawczo_Dydaktyczny)
                    {
                        listaKursow.add(kurs);
                        System.out.println("Od teraz Pracownik o nazwisku " + kurs.getNazwiskoProwadzacego() +
                                " zacznie prowadzic kurs " + kurs.getNazwaKursu() + "\n");
                        return;
                    }
                    else
                    {
                        System.out.println("Podana osoba nie ma kwalifikacji do prowadzenia kursu\n");
                    }
                }
            }

            System.out.println("Podany prowadzacy nie jest pracownikiem tej uczelni, zatem kursu nie utworzono\n");
            return;
        }
    }

    public Osoba szukajOsoba_pesel( String p)
    {
        listaOsob.trimToSize();

        for( int i = 0; i < listaOsob.size(); i++)
        {
            if( listaOsob.get(i).getPesel().equals(p))
            {
                return listaOsob.get(i);
            }
        }
        return null;
    }

    public Student szukajStudent_pesel( String p)
    {
        listaOsob.trimToSize();

        for( int i = 0; i < listaOsob.size(); i++)
        {
            if( listaOsob.get(i).getPesel().equals(p))
            {
                if( listaOsob.get(i) instanceof Student)
                    return (Student) listaOsob.get(i);
            }
        }
        return null;
    }

    public Pracownik_Administracyjny szukajPracAdm_pesel( String p)
    {
        listaOsob.trimToSize();

        for( int i = 0; i < listaOsob.size(); i++)
        {
            if( listaOsob.get(i).getPesel().equals(p))
            {
                if( listaOsob.get(i) instanceof Pracownik_Administracyjny)
                    return (Pracownik_Administracyjny) listaOsob.get(i);
            }
        }
        return null;
    }

    public Pracownik_Badawczo_Dydaktyczny szukajPracBadDyd_pesel( String p)
    {
        listaOsob.trimToSize();

        for( int i = 0; i < listaOsob.size(); i++)
        {
            if( listaOsob.get(i).getPesel().equals(p))
            {
                if( listaOsob.get(i) instanceof Pracownik_Badawczo_Dydaktyczny)
                    return (Pracownik_Badawczo_Dydaktyczny)listaOsob.get(i);
            }
        }
        return null;
    }

    public ArrayList<Student> szukajStudent_naz( String nazwisko1)
    {
        listaOsob.trimToSize();
        ArrayList<Student> stud = new ArrayList<Student>();

        for( int i = 0; i < listaOsob.size(); i++)
        {
            if(listaOsob.get(i) instanceof Student)
            {
                Student k = (Student)listaOsob.get(i);
                if( (k.getNazwisko()).equals(nazwisko1))
                {
                    stud.add(k);
                }
            }
        }
        stud.trimToSize();
        return stud;
    }
    public ArrayList<Student> szukajStudent_im( String imie1)
    {
        listaOsob.trimToSize();
        ArrayList<Student> stud = new ArrayList<Student>();

        for( int i = 0; i < listaOsob.size(); i++)
        {
            if(listaOsob.get(i) instanceof Student)
            {
                Student k = (Student)listaOsob.get(i);
                if( (k.getImie()).equals(imie1))
                {
                    stud.add(k);
                }
            }
        }
        stud.trimToSize();
        return stud;
    }
    public ArrayList<Student> szukajStudent_nr( int nr1)
    {
        listaOsob.trimToSize();
        ArrayList<Student> stud = new ArrayList<Student>();

        for( int i = 0; i < listaOsob.size(); i++)
        {
            if(listaOsob.get(i) instanceof Student)
            {
                Student k = (Student)listaOsob.get(i);
                if( (k.getNrIndeksu()) == nr1)
                {
                    stud.add(k);
                }
            }
        }
        stud.trimToSize();
        return stud;
    }
    public ArrayList<Student> szukajStudent_stopI (boolean s)
    {
        listaOsob.trimToSize();
        ArrayList<Student> stud = new ArrayList<Student>();

        for( int i = 0; i < listaOsob.size(); i++)
        {
            if(listaOsob.get(i) instanceof Student)
            {
                Student k = (Student)listaOsob.get(i);
                if( (k.isStud_Istopien()) == s)
                {
                    stud.add(k);
                }
            }
        }
        stud.trimToSize();
        return stud;
    }

    public ArrayList<Pracownik_Uczelni> szukajPracownik_naz( String s)
    {
        listaOsob.trimToSize();
        ArrayList<Pracownik_Uczelni> list = new ArrayList<Pracownik_Uczelni>();

        for( int i = 0; i < listaOsob.size(); i++)
        {
            if(listaOsob.get(i) instanceof Pracownik_Uczelni)
            {
                Pracownik_Uczelni k = (Pracownik_Uczelni)listaOsob.get(i);
                if( (k.getNazwisko()).equals(s))
                {
                    list.add(k);
                }
            }
        }
        list.trimToSize();
        return list;
    }
    public ArrayList<Pracownik_Uczelni> szukajPracownik_im( String s)
    {
        listaOsob.trimToSize();
        ArrayList<Pracownik_Uczelni> list = new ArrayList<Pracownik_Uczelni>();

        for( int i = 0; i < listaOsob.size(); i++)
        {
            if(listaOsob.get(i) instanceof Pracownik_Uczelni)
            {
                Pracownik_Uczelni k = (Pracownik_Uczelni)listaOsob.get(i);
                if( (k.getImie()).equals(s))
                {
                    list.add(k);
                }
            }
        }
        list.trimToSize();
        return list;
    }
    public ArrayList<Pracownik_Uczelni> szukajPracownik_staz( int s)
    {
        listaOsob.trimToSize();
        ArrayList<Pracownik_Uczelni> list = new ArrayList<Pracownik_Uczelni>();

        for( int i = 0; i < listaOsob.size(); i++)
        {
            if(listaOsob.get(i) instanceof Pracownik_Uczelni)
            {
                Pracownik_Uczelni k = (Pracownik_Uczelni)listaOsob.get(i);
                if( (k.getStazPracy()) == s)
                {
                    list.add(k);
                }
            }
        }
        list.trimToSize();
        return list;
    }

    public ArrayList<Pracownik_Uczelni> szukajPracownik_pensja( double s)
    {
        listaOsob.trimToSize();
        ArrayList<Pracownik_Uczelni> list = new ArrayList<Pracownik_Uczelni>();

        for( int i = 0; i < listaOsob.size(); i++)
        {
            if(listaOsob.get(i) instanceof Pracownik_Uczelni)
            {
                Pracownik_Uczelni k = (Pracownik_Uczelni)listaOsob.get(i);
                if( (k.getPensja()) == s)
                {
                    list.add(k);
                }
            }
        }
        list.trimToSize();
        return list;
    }

    public ArrayList<Pracownik_Uczelni> szukajPracownik_nadgodziny( int s)
    {
        listaOsob.trimToSize();
        ArrayList<Pracownik_Uczelni> list = new ArrayList<Pracownik_Uczelni>();

        for( int i = 0; i < listaOsob.size(); i++)
        {
            if(listaOsob.get(i) instanceof Pracownik_Administracyjny)
            {
                Pracownik_Administracyjny k = (Pracownik_Administracyjny)listaOsob.get(i);
                if( (k.getLiczbaNadgodzin()) == s)
                {
                    list.add(k);
                }
            }
        }
        list.trimToSize();
        return list;
    }

    public ArrayList<Pracownik_Uczelni> szukajPracownik_stanowisko( String s)
    {
        listaOsob.trimToSize();
        ArrayList<Pracownik_Uczelni> list = new ArrayList<Pracownik_Uczelni>();

        for( int i = 0; i < listaOsob.size(); i++)
        {
            if(listaOsob.get(i) instanceof Pracownik_Uczelni)
            {
                Pracownik_Uczelni k = (Pracownik_Uczelni) listaOsob.get(i);
                if( (k.getStanowisko()).equals(s))
                {
                    list.add(k);
                }
            }
        }
        list.trimToSize();
        return list;
    }

    public ArrayList<Kursy> szukajKurs_nazwa( String s)
    {
        listaKursow.trimToSize();
        ArrayList<Kursy> list = new ArrayList<Kursy>();

        for( int i = 0; i < listaKursow.size(); i++)
        {
            if(listaKursow.get(i) instanceof Kursy)
            {
                Kursy k = (Kursy) listaKursow.get(i);
                if( (k.getNazwaKursu()).equals(s))
                {
                    list.add(k);
                }
            }
        }
        list.trimToSize();
        return list;
    }
    public ArrayList<Kursy> szukajKurs_nazpro( String s)
    {
        listaKursow.trimToSize();
        ArrayList<Kursy> list = new ArrayList<Kursy>();

        for( int i = 0; i < listaKursow.size(); i++)
        {
            if(listaKursow.get(i) instanceof Kursy)
            {
                Kursy k = (Kursy) listaKursow.get(i);
                if( (k.getNazwiskoProwadzacego()).equals(s))
                {
                    list.add(k);
                }
            }
        }
        list.trimToSize();
        return list;
    }
    public ArrayList<Kursy> szukajKurs_impro( String s)
    {
        listaKursow.trimToSize();
        ArrayList<Kursy> list = new ArrayList<Kursy>();

        for( int i = 0; i < listaKursow.size(); i++)
        {
            if(listaKursow.get(i) instanceof Kursy)
            {
                Kursy k = (Kursy) listaKursow.get(i);
                if( (k.getImieProwadzacego()).equals(s))
                {
                    list.add(k);
                }
            }
        }
        list.trimToSize();
        return list;
    }
    public ArrayList<Kursy> szukajKurs_pesel( String s)
    {
        listaKursow.trimToSize();
        ArrayList<Kursy> list = new ArrayList<Kursy>();

        for( int i = 0; i < listaKursow.size(); i++)
        {
            if(listaKursow.get(i) instanceof Kursy)
            {
                Kursy k = (Kursy) listaKursow.get(i);
                if( (k.getPeselProwadzacego()).equals(s))
                {
                    list.add(k);
                }
            }
        }
        list.trimToSize();
        return list;
    }

    public ArrayList<Kursy> szukajKurs_ects( int s)
    {
        listaKursow.trimToSize();
        ArrayList<Kursy> list = new ArrayList<Kursy>();

        for( int i = 0; i < listaKursow.size(); i++)
        {
            if(listaKursow.get(i) instanceof Kursy)
            {
                Kursy k = (Kursy) listaKursow.get(i);
                if( (k.getPunktyETC()) == s)
                {
                    list.add(k);
                }
            }
        }
        list.trimToSize();
        return list;
    }

    public void wyswietlListe( ArrayList list)
    {
        if( list.isEmpty())
        {
            System.out.println("Podana lista jest pusta.\n");
            return;
        }
        list.trimToSize();

        for( int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }
        System.out.print("\n");
    }

    public void wys_stud_naz( String s)
    {
        ArrayList<Student> list = szukajStudent_naz(s);
        /*ArrayList<Osoba> list = new ArrayList<>(0);
        list.addAll(szukajStudent_naz(s));*/
        wyswietlListe(list);
    }
    public void wys_stud_im( String s)
    {
        ArrayList<Student> list = szukajStudent_im(s);
        wyswietlListe(list);
    }
    public void wys_stud_nr( int s)
    {
        ArrayList<Student> list = szukajStudent_nr(s);
        wyswietlListe(list);
    }
    public void wys_stud_stopI( boolean s)
    {
        ArrayList<Student> list = szukajStudent_stopI(s);
        wyswietlListe(list);
    }

    public void wys_prac_im( String s)
    {
        ArrayList<Pracownik_Uczelni> list = szukajPracownik_im(s);
        wyswietlListe(list);
    }
    public void wys_prac_naz( String s)
    {
        ArrayList<Pracownik_Uczelni> list = szukajPracownik_naz(s);
        wyswietlListe(list);
    }
    public void wys_prac_stanowisko( String s)
    {
        ArrayList<Pracownik_Uczelni> list = szukajPracownik_stanowisko(s);
        wyswietlListe(list);
    }
    public void wys_prac_staz( int s)
    {
        ArrayList<Pracownik_Uczelni> list = szukajPracownik_staz(s);
        wyswietlListe(list);
    }

    public void wys_kurs_nazwa( String s)
    {
        ArrayList<Kursy> list = szukajKurs_nazwa(s);
        wyswietlListe(list);
    }
    public void wys_kurs_nazpro( String s)
    {
        ArrayList<Kursy> list = szukajKurs_nazpro(s);
        wyswietlListe(list);
    }
    public void wys_kurs_impro( String s)
    {
        ArrayList<Kursy> list = szukajKurs_impro(s);
        wyswietlListe(list);
    }
    public void wys_kurs_pesel( String s)
    {
        ArrayList<Kursy> list = szukajKurs_pesel(s);
        wyswietlListe(list);
    }

    public ArrayList<Student> list_stud()
    {
        listaOsob.trimToSize();
        ArrayList<Student> stud = new ArrayList<Student>();

        for( int i = 0; i < listaOsob.size(); i++)
        {
            if(listaOsob.get(i) instanceof Student)
            {
                stud.add((Student)listaOsob.get(i));
            }
        }
        stud.trimToSize();
        return stud;
    }

    public void wys_stud_all()
    {
        System.out.println("Lista Studentow:\n");
        wyswietlListe(list_stud());
    }

    public ArrayList<Pracownik_Uczelni> list_prac()
    {
        listaOsob.trimToSize();
        ArrayList<Pracownik_Uczelni> stud = new ArrayList<Pracownik_Uczelni>();

        for( int i = 0; i < listaOsob.size(); i++)
        {
            if(listaOsob.get(i) instanceof Pracownik_Uczelni)
            {
                stud.add((Pracownik_Uczelni)listaOsob.get(i));
            }
        }
        stud.trimToSize();
        return stud;
    }

    public void wys_prac_all()
    {
        System.out.println("Lista Pracownikow:\n");
        wyswietlListe(list_prac());
    }

    public ArrayList<Kursy> list_kurs()
    {
        listaKursow.trimToSize();
        ArrayList<Kursy> stud = new ArrayList<Kursy>();

        for( int i = 0; i < listaKursow.size(); i++)
        {
            if(listaKursow.get(i) instanceof Kursy)
            {
                stud.add(listaKursow.get(i));
            }
        }
        stud.trimToSize();
        return stud;
    }

    public void wys_kurs_all_nr()
    {
        wys_kurs_nr(listaKursow);
    }

    public void wys_kurs_nr( ArrayList<Kursy> listaKursow)
    {
        listaKursow.trimToSize();

        if( listaKursow.size() == 0)
        {
            System.out.println("Lista jest pusta");
            return;
        }

        for( int i = 0; i < listaKursow.size(); i++)
        {
            System.out.println((i+1) + ") " + listaKursow.get(i).getNazwaKursu());
        }
        System.out.print("\n");
    }

    public void wys_kurs_nr_info( ArrayList<Kursy> listaKursow)
    {
        listaKursow.trimToSize();

        if( listaKursow.size() == 0)
        {
            System.out.println("Lista jest pusta");
            return;
        }

        for( int i = 0; i < listaKursow.size(); i++)
        {
            System.out.println((i+1) + ") " + listaKursow.get(i).getNazwaKursu() + " "
                    + listaKursow.get(i).getImieProwadzacego() + " " + listaKursow.get(i).getNazwiskoProwadzacego()
            + " " + listaKursow.get(i).getPunktyETC());
        }
    }


    public void wys_kurs_all()
    {
        System.out.println("Lista Kursow:\n");
        wyswietlListe(list_kurs());
    }

    public void wys_all()
    {
        wys_stud_all();
        wys_prac_all();
        wys_kurs_all();
    }

    public void wys_stud_kurs()
    {
        ArrayList<Student> stud = list_stud();

        if( stud.size() == 0)
        {
            System.out.println("Lista studentow jest pusta");
            return;
        }

        for( int i = 0; i < stud.size(); i++)
        {
            System.out.printf( "%4d) %s %s nr - %s pesel - %s:%n", (i+1), stud.get(i).getImie(), stud.get(i).getNazwisko(), stud.get(i).getNrIndeksu(), stud.get(i).getPesel());
            wys_kurs_nr_info(stud.get(i).getListaKursow());
        }
    }


    public ArrayList<Osoba> getListaOsob()
    {
        return listaOsob;
    }
    public ArrayList<Kursy> getListaKursow()
    {
        return listaKursow;
    }
    

}
