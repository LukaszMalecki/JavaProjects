package Package_Main;

import java.util.ArrayList;
import Package_Osoba.*;
import Package_Kursy.*;
import Package_Uczelnia.*;
import Package_GUI.*;

public class Main
{
	//ETAP 1 I 2

	public static void testI()
	{
		Pracownik_Administracyjny p1 = new Pracownik_Administracyjny("John", "Bruh", "123456789", 40,
				'M', "Referent", 3, 2600.0, 10);
		System.out.println(p1);
		Pracownik_Administracyjny p2 = new Pracownik_Administracyjny("Jim", "Bruh", "123456780", 27,
				'M', "Referent", 2, 2500.0, 13);
		Pracownik_Administracyjny p3 = new Pracownik_Administracyjny("John", "Hough", "128456780", 57,
				'M', "Specjalista", 20, 2800.0, 0);
		Pracownik_Administracyjny p4 = new Pracownik_Administracyjny("Liam", "Ser", "123456789", 40,
				'M', "Referent", 7, 2600.0, 10);

		Uczelnia uwu = new Uczelnia();
		uwu.dodajPracownika(p1);
		uwu.dodajPracownika(p2);
		uwu.dodajPracownika(p3);
		uwu.dodajPracownika(p4); //ma ten sam pesel, czyli sprzeczne z zal

		uwu.wys_prac_naz("Bruh");
		uwu.wys_prac_im("John");

	}

	public static void testII()
	{
		Pracownik_Administracyjny p1 = new Pracownik_Administracyjny("John", "Bruh", "123456789", 40,
				'M', "Referent", 3, 2600.0, 10);
		System.out.println(p1);
		Pracownik_Administracyjny p2 = new Pracownik_Administracyjny("Jim", "Bruh", "123456780", 27,
				'M', "Referent", 2, 2500.0, 13);
		Pracownik_Administracyjny p3 = new Pracownik_Administracyjny("John", "Hough", "128456780", 57,
				'M', "Specjalista", 20, 2800.0, 0);
		Pracownik_Badawczo_Dydaktyczny p4 = new Pracownik_Badawczo_Dydaktyczny("Larry", "Hed", "223456789",
				40, 'M', "Wykladowca", 7, 2620.0, 7);

		Pracownik_Badawczo_Dydaktyczny p5 = new Pracownik_Badawczo_Dydaktyczny(p4);

		Uczelnia uwu = new Uczelnia();
		uwu.dodajPracownika(p1);
		uwu.dodajPracownika(p2);
		uwu.dodajPracownika(p3);
		uwu.dodajPracownika(p4);
		p5.setPesel("323456789");
		p5.setWiek(29);
		p5.setStanowisko("Asystent");
		p5.setStazPracy(2);
		uwu.dodajPracownika(p5);
		p5 = new Pracownik_Badawczo_Dydaktyczny(p5);
		p5.setPesel("423456789");
		p5.setStanowisko("Wykladowca");
		p5.setImie("Marcin");
		p5.setNazwisko("Bruh");
		p5.setWiek(35);
		p5.setStazPracy(5);
		uwu.dodajPracownika(p5);
		p4 = new Pracownik_Badawczo_Dydaktyczny(p4);
		p4.setPesel("523456789");
		p4.setImie("Larry");
		p4.setNazwisko("Hough");
		p4.setWiek(38);
		p4.setPensja(2601);
		p4.setStanowisko("Wykladowca");
		uwu.dodajPracownika(p4);





		Kursy k1 = new Kursy("PSIO", p4, 3);

		ArrayList kk = new ArrayList();
		kk.add(k1);
		kk.trimToSize();

		Student s1 = new Student("Jan", "Nowak", "623456789", 20, 'M',
				10, kk, false, true, true);

		uwu.dodajKurs(k1);

		uwu.dodajStudenta(s1);

		uwu.wys_prac_stanowisko("Wykladowca");

		ArrayList wyk = uwu.szukajPracownik_stanowisko("Wykladowca");

		wyk.trimToSize();
		int j = kk.size();

		kk = new ArrayList(kk);

		for( int i = 0; i < wyk.size(); i++)
		{
			kk.add( new Kursy("Analiza_Matematyczna", (Pracownik_Badawczo_Dydaktyczny)(wyk.get(i)), 6));
			uwu.dodajKurs(kk.get(j));
			j++;
		}
		s1 = new Student(s1);
		s1.setPesel("723456789");
		s1.setImie("Marek");
		s1.setNazwisko("Lincoln");
		s1.dodajKurs((Kursy)(kk.get(2)));
		s1.setNrIndeksu(11);
		uwu.dodajStudenta(s1);

		uwu.wyswietlListe(s1.getListaKursow());

		s1 = new Student(s1);
		s1.setPesel("823456789");
		s1.setImie("Marta");
		s1.setPlec('K');
		s1.setStud_Istopien(false);
		s1.setWiek(24);
		s1.setNrIndeksu(12);
		s1.dodajKurs((Kursy)kk.get(3));
		uwu.dodajStudenta(s1);

		uwu.wyswietlListe(s1.getListaKursow());



		System.out.println("Pracownicy o nazwisku Bruh:\n");
		uwu.wys_prac_naz("Bruh");

		System.out.println("Pracownicy o imieniu John:\n");
		uwu.wys_prac_im("John");

		uwu.wys_all();

		System.out.println("--------\n");

		uwu.wys_stud_naz("Lincoln");

		((Student)(uwu.szukajStudent_naz("Lincoln").get(0))).setImie("InneImie");

		uwu.wys_stud_naz("Lincoln");


	}

    public static void main(String[] args)
    {
    	/*testI();
    	System.out.println("----------\nKoniec Testu I\n----------\n");
    	testII();
		System.out.println("----------\nKoniec Testu II\n----------\n");*/

		//Uczelnia uwu = new Uczelnia();

		//uwu.start();

		//Graficzny_Interfejs gui = new Graficzny_Interfejs();
		//gui.start();

		Uczelnia uwu = new Uczelnia();

		Gui_Start start = new Gui_Start(uwu);



    }
}
