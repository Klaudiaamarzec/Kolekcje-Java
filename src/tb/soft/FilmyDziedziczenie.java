package tb.soft;

public class FilmyDziedziczenie extends Filmy
{

    public FilmyDziedziczenie(String tytul, String gatunek, String kraj, int rok)
    {
        super(tytul, gatunek, kraj, rok);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Filmy filmy = (Filmy) o;

        if (rok != filmy.rok) return false;
        if (!tytul.equals(filmy.tytul)) return false;
        return gatunek.equals(filmy.gatunek);
    }

    @Override
    public int hashCode()
    {
        int result = tytul.hashCode();
        result = 31 * result + gatunek.hashCode();
        result = 31 * result + rok;
        return result;
    }
}
