package Package_Osoba;

import java.io.Serializable;

public class Pracownik_Badawczo_Dydaktyczny extends Pracownik_Uczelni
{
    private static final long serialVersionUID = 1000004;

    private int punktacjaZDN; //punktacja z dorobku naukowego

    private final static String[] stanowiskoPracy =
            { "Asystent", "Adiunkt", "Profesor Nadzwyczajny", "Profesor Zwyczajny", "Wykladowca"};
    //mozliwosci stanowiska

    public Pracownik_Badawczo_Dydaktyczny()
    {
        super();
        setStanowisko("Asystent");
        punktacjaZDN = 2;
    }
    public Pracownik_Badawczo_Dydaktyczny(String imie_, String nazwisko_, String pesel_, int wiek_, char plec_,
                                          String stanowisko_, int stazPracy_, double pensja_,
                                          int punktacjaZDN_)
    {
        super( imie_, nazwisko_, pesel_, wiek_, plec_, stanowisko_, stazPracy_, pensja_);

        punktacjaZDN = punktacjaZDN_;
    }

    public Pracownik_Badawczo_Dydaktyczny( Pracownik_Badawczo_Dydaktyczny p)
    {
        super(p.getImie(), p.getNazwisko(), p.getPesel(), p.getWiek(),
                p.getPlec(), p.getStanowisko(), p.getStazPracy(), p.getPensja());
        punktacjaZDN = p.getPunktacjaZDN();

    }

    public boolean equals( Object ob)
    {
        if( !(super.equals(ob)))
            return false;
        if( !(ob instanceof Pracownik_Badawczo_Dydaktyczny))
            return false;
        return true;
    }

    public String toString()
    {
        return super.toString() + " " + punktacjaZDN;
    }

    public int getPunktacjaZDN()
    {
        return punktacjaZDN;
    }
    public void setPunktacjaZDN( int punktacjaZDN_)
    {
        punktacjaZDN = punktacjaZDN_;
    }
}
