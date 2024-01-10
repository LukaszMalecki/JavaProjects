package Package_Osoba;

import java.io.Serializable;

public abstract class Osoba implements Serializable
{
    private String imie;
    private String nazwisko;
    private String pesel;
    private int wiek;
    private char plec; //K - kobieta, M - mezczyzna

    private static final long serialVersionUID = 1000001;

    public Osoba()
    {
        imie = "Jan";
        nazwisko = "Kowalski";
        pesel = "11111111111";
        wiek = 20;
        plec = 'M';
    }
    public Osoba( String imie_, String nazwisko_, String pesel_, int wiek_, char plec_)
    {
        imie = imie_;
        nazwisko = nazwisko_;
        pesel = pesel_;
        wiek = wiek_;
        plec = plec_;
    }

    public boolean equals( Object ob)
    {
        if( !(ob instanceof Osoba))
            return false;

        Osoba os = (Osoba)ob;

        if( !(pesel.equals(os.getPesel())))
            return false;

        //zakladam, ze pesel jest jednoznacznym identyfikatorem osoby

        return true;
    }

    public String toString()
    {
        return imie + " " + nazwisko + " " + pesel + " " + wiek + " " + plec;
    }

    public String getImie()
    {
        return imie;
    }
    public String getNazwisko()
    {
        return nazwisko;
    }
    public String getPesel()
    {
        return pesel;
    }
    public int getWiek()
    {
        return wiek;
    }
    public char getPlec()
    {
        return plec;
    }

    public void setImie( String imie_)
    {
        imie = imie_;
    }
    public void setNazwisko( String nazwisko_)
    {
        nazwisko = nazwisko_;
    }
    public void setPesel( String pesel_)
    {
        pesel = pesel_;
    }
    public void setWiek( int wiek_)
    {
        wiek = wiek_;
    }
    public void setPlec( char plec_)
    {
        plec = plec_;
    }

}
