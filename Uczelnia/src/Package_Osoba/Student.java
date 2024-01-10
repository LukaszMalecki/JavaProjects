package Package_Osoba;


import java.util.ArrayList;
import Package_Kursy.*;

import java.io.Serializable;

public class Student extends Osoba
{
    private static final long serialVersionUID = 1000005;

    private int nrIndeksu;
    private ArrayList<Kursy> listaKursow;

    private boolean stud_eras; //czy student jest uczestnikiem programu ERASMUS
    private boolean stud_Istopien; //czy student jest na I stopniu studiow w przeciwnym wypadku II stopien
    // 0 - II stopien, 1 - I stopien
    private boolean stud_stac; //czy student jest na studiach stacjonarych w przeciwnym wypadku niestacjonarne
    // 0 - niestacjonarne, 1 - stacjonarne

    public Student()
    {
        super();
        nrIndeksu = 100;
        listaKursow = new ArrayList<Kursy>();
        stud_eras = false;
        stud_Istopien = true;
        stud_stac = true;
    }
    public Student(String imie_, String nazwisko_, String pesel_, int wiek_, char plec_,
                   int nrIndeksu_, ArrayList<Kursy> listaKursow_, boolean stud_eras_, boolean stud_Istopien_, boolean stud_stac_)
    {
        super( imie_, nazwisko_, pesel_, wiek_, plec_);

        nrIndeksu = nrIndeksu_;
        listaKursow = listaKursow_;
        stud_eras = stud_eras_;
        stud_Istopien = stud_Istopien_;
        stud_stac = stud_stac_;
    }
    public Student(String imie_, String nazwisko_, String pesel_, int wiek_, char plec_,
                   int nrIndeksu_, boolean stud_eras_, boolean stud_Istopien_, boolean stud_stac_)
    {
        super( imie_, nazwisko_, pesel_, wiek_, plec_);

        nrIndeksu = nrIndeksu_;
        listaKursow = new ArrayList<Kursy>();
        stud_eras = stud_eras_;
        stud_Istopien = stud_Istopien_;
        stud_stac = stud_stac_;
    }

    public Student( Student p)
    {
        super(p.getImie(), p.getNazwisko(), p.getPesel(), p.getWiek(),
                p.getPlec());
        nrIndeksu = p.getNrIndeksu();
        listaKursow = p.getListaKursow();
        stud_eras = p.isStud_eras();
        stud_Istopien = p.isStud_Istopien();
        stud_stac = p.isStud_stac();

    }

    public boolean equals( Object ob)
    {
        if( !(super.equals(ob)))
            return false;
        if( !(ob instanceof Student))
            return false;
        return true;
    }

    public String toString()
    {
        return super.toString() + " " + nrIndeksu + " " + stud_eras + " " + stud_Istopien + " " + stud_stac;
    }

    public void dodajKurs( Kursy k1)
    {
        listaKursow.trimToSize();

        if( listaKursow.contains(k1))
        {
            System.out.println("Ten student zapisal sie juz na ten kurs\n");
            return;
        }
        listaKursow.add(k1);
        System.out.println("Pomyslnie dopisano kurs do listy\n");
    }

    public void pokazKursy()
    {
        if( listaKursow.isEmpty())
        {
            System.out.println("Brak Kursow\n");
            return;
        }
        for( int i = 0; i < listaKursow.size(); i++)
        {
            System.out.println(listaKursow.get(i));
        }
        System.out.print("\n");
    }

    public int getNrIndeksu()
    {
        return nrIndeksu;
    }
    public ArrayList<Kursy> getListaKursow()
    {
        return listaKursow;
    }
    public boolean isStud_eras()
    {
        return stud_eras;
    }
    public boolean isStud_Istopien()
    {
        return stud_Istopien;
    }
    public boolean isStud_stac()
    {
        return stud_stac;
    }

    public void setNrIndeksu(int nrIndeksu)
    {
        this.nrIndeksu = nrIndeksu;
    }
    public void setListaKursow(ArrayList<Kursy> listaKursow)
    {
        this.listaKursow = listaKursow;
    }
    public void setStud_eras(boolean stud_eras)
    {
        this.stud_eras = stud_eras;
    }
    public void setStud_Istopien(boolean stud_Istopien)
    {
        this.stud_Istopien = stud_Istopien;
    }
    public void setStud_stac(boolean stud_stac)
    {
        this.stud_stac = stud_stac;
    }
}
