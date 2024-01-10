package Package_Osoba;

import java.io.Serializable;

public abstract class Pracownik_Uczelni extends Osoba
{
    private static final long serialVersionUID = 1000002;

    private String stanowisko;
    private int stazPracy; //w latach
    private double pensja;

    public Pracownik_Uczelni()
    {
        super();

        stazPracy = 3;
        pensja = 2500;
    }
    public Pracownik_Uczelni( String imie_, String nazwisko_, String pesel_, int wiek_, char plec_,
                              String stanowisko_, int stazPracy_, double pensja_ )
    {
        super( imie_, nazwisko_, pesel_, wiek_, plec_);

        stanowisko = stanowisko_;
        stazPracy = stazPracy_;
        pensja = pensja_;
    }

    public boolean equals( Object ob)
    {
        if( !(super.equals(ob)))
            return false;
        if( !(ob instanceof Pracownik_Uczelni))
            return false;
        return true;
    }


    public String toString()
    {
        return super.toString() + " " + stanowisko + " " + stazPracy + " " + pensja;
    }

    public String getStanowisko()
    {
        return stanowisko;
    }
    public int getStazPracy()
    {
        return stazPracy;
    }
    public double getPensja()
    {
        return pensja;
    }

    public void setStanowisko( String stanowisko_)
    {
        stanowisko = stanowisko_;
    }
    public void setStazPracy( int stazPracy_)
    {
        stazPracy = stazPracy_;
    }
    public void setPensja( double pensja_)
    {
        pensja = pensja_;
    }
}
