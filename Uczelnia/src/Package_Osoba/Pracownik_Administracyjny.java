package Package_Osoba;

import java.io.Serializable;

public class Pracownik_Administracyjny extends Pracownik_Uczelni
{
    private static final long serialVersionUID = 1000003;

    private int liczbaNadgodzin;

    private final static String[] stanowiskoPracy =
            {"Referent", "Specjalista", "Starszy Specjalista"};
    //mozliwosci stanowiska

    public Pracownik_Administracyjny()
    {
        super();

        setStanowisko("Referent");
        liczbaNadgodzin = 10;
    }
    public Pracownik_Administracyjny(String imie_, String nazwisko_, String pesel_, int wiek_, char plec_,
                                     String stanowisko_, int stazPracy_, double pensja_,
                                     int liczbaNadgodzin_)
    {
        super( imie_, nazwisko_, pesel_, wiek_, plec_, stanowisko_, stazPracy_, pensja_);

        liczbaNadgodzin = liczbaNadgodzin_;
    }

    public Pracownik_Administracyjny( Pracownik_Administracyjny p)
    {
        super(p.getImie(), p.getNazwisko(), p.getPesel(), p.getWiek(),
                p.getPlec(), p.getStanowisko(), p.getStazPracy(), p.getPensja());
        liczbaNadgodzin = p.getLiczbaNadgodzin();

    }

    public boolean equals( Object ob)
    {
        if( !(super.equals(ob)))
            return false;
        if( !(ob instanceof Pracownik_Administracyjny))
            return false;
        return true;
    }

    public String toString()
    {
        return super.toString() + " " + liczbaNadgodzin;
    }

    public int getLiczbaNadgodzin()
    {
        return liczbaNadgodzin;
    }

    public void setLiczbaNadgodzin( int liczbaNadgodzin_)
    {
        liczbaNadgodzin = liczbaNadgodzin_;
    }
}
