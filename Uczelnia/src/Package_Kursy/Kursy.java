package Package_Kursy;

import Package_Osoba.Pracownik_Badawczo_Dydaktyczny;

import java.io.Serializable;

public class Kursy implements Serializable
{
    private static final long serialVersionUID = 1000006;

    private String nazwaKursu;
    private String imieProwadzacego;
    private String nazwiskoProwadzacego;
    private String peselProwadzacego;
    private int punktyETC;

    public Kursy()
    {
        nazwaKursu = "kurs";
        imieProwadzacego = "Jan";
        nazwiskoProwadzacego = "Kowalski";
        peselProwadzacego = "11111111111";
        punktyETC = 0;
    }
    public Kursy( String nazwaKursu_, String imieProwadzacego_, String nazwiskoProwadzacego_, String peselProwadzacego_,int punktyETC_)
    {
        nazwaKursu = nazwaKursu_;
        imieProwadzacego = imieProwadzacego_;
        nazwiskoProwadzacego = nazwiskoProwadzacego_;
        peselProwadzacego = peselProwadzacego_;
        punktyETC = punktyETC_;
    }
    public Kursy(String nazwaKursu_, Pracownik_Badawczo_Dydaktyczny prac, int punktyETC_)
    {
        nazwaKursu = nazwaKursu_;
        imieProwadzacego = prac.getImie();
        nazwiskoProwadzacego = prac.getNazwisko();
        peselProwadzacego = prac.getPesel();
        punktyETC = punktyETC_;
    }

    public boolean equals( Object ob)
    {
        if( !(ob instanceof Kursy))
        {
            return false;
        }
        Kursy kurs = (Kursy)ob;

        if( !(nazwaKursu.equals(kurs.getNazwaKursu())))
            return false;
        if( !(peselProwadzacego.equals(kurs.getPeselProwadzacego())))
            return false;
        if( !(imieProwadzacego.equals(kurs.getImieProwadzacego())))
            return false;
        if( !(nazwiskoProwadzacego.equals(kurs.getNazwiskoProwadzacego())))
            return false;
        if( !(punktyETC == kurs.getPunktyETC()))
            return false;

        return true;
    }

    public String toString()
    {
        return nazwaKursu + " " + imieProwadzacego + " " + nazwiskoProwadzacego + " " + peselProwadzacego + " " + punktyETC;
    }

    public String info()
    {
        return nazwaKursu + " " + peselProwadzacego;
    }

    public String getNazwaKursu()
    {
        return nazwaKursu;
    }
    public String getImieProwadzacego()
    {
        return imieProwadzacego;
    }
    public String getNazwiskoProwadzacego()
    {
        return nazwiskoProwadzacego;
    }
    public int getPunktyETC()
    {
        return punktyETC;
    }

    public String getPeselProwadzacego() {
        return peselProwadzacego;
    }

    public void setNazwaKursu(String nazwaKursu)
    {
        this.nazwaKursu = nazwaKursu;
    }
    public void setImieProwadzacego(String imieProwadzacego)
    {
        this.imieProwadzacego = imieProwadzacego;
    }
    public void setNazwiskoProwadzacego(String nazwiskoProwadzacego)
    {
        this.nazwiskoProwadzacego = nazwiskoProwadzacego;
    }
    public void setPunktyETC(int punktyETC)
    {
        this.punktyETC = punktyETC;
    }

    public void setPeselProwadzacego(String peselProwadzacego) {
        this.peselProwadzacego = peselProwadzacego;
    }
}
