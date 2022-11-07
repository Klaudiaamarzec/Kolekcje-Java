package tb.soft;

import java.io.*;
import java.util.ArrayList;

class FilmyException extends Exception{
    private static final long serialVersionUID = 1L;

    public FilmyException(String message) {
        super(message);
    }
}

public class Filmy implements Comparable<Filmy>
{
    public String tytul;
    public String gatunek;
    public int rok;
    public String krajProdukcji;

    public Filmy(String tytul, String gatunek, String kraj, int rok)
    {
        this.tytul = tytul;
        this.gatunek = gatunek;
        this.krajProdukcji = kraj;
        this.rok = rok;
    }

    public Filmy(String tytul, String gatunek, String kraj)
    {
        this.tytul = tytul;
        this.gatunek = gatunek;
        this.krajProdukcji = kraj;
    }

    public String toString()
    {
        String s = (tytul + " " + gatunek + " " + rok + " " + krajProdukcji);
        return s;
    }

    public void setRok(int rok_wydania) throws FilmyException {
        if (rok_wydania!=0 && (rok_wydania>2022 && rok_wydania < 0))
            throw new FilmyException("Rok produkcji musi być w przedziale (0,2022]");
        this.rok = rok_wydania;
    }

    public int getRok()
    {
        return rok;
    }

    public void setRok(String rok) throws FilmyException {
        if (rok == null || rok.equals("")){  // pusty łańcuch znaków oznacza rok niezdefiniowany
            setRok(0);
            return;
        }
        try {
            setRok(Integer.parseInt(rok));
        } catch (NumberFormatException e) {
            throw new FilmyException("Rok wydania musi być liczbą całkowitą.");
        }
    }

    public static Filmy readFromFile(BufferedReader reader) throws FilmyException{
        try {
            String line = reader.readLine();
            String[] txt = line.split("  ");
            Filmy film = new Filmy(txt[0], txt[1], txt[2]);
            film.setRok(txt[2]);
            return film;
        } catch(IOException e){
            throw new FilmyException("Wystąpił błąd podczas odczytu danych z pliku.");
        }
    }


    public static Filmy readFromFile(String file_name) throws FilmyException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(file_name)))) {
            return Filmy.readFromFile(reader);
        } catch (FileNotFoundException e){
            throw new FilmyException("Nie odnaleziono pliku " + file_name);
        } catch(IOException e){
            throw new FilmyException("Wystąpił błąd podczas odczytu danych z pliku.");
        }
    }

    public static void printToFile(PrintWriter writer, Filmy film)
    {
        writer.println(film.tytul + "  " + film.gatunek+ "  " +
                film.krajProdukcji + "  " + film.rok );
    }

    public static void printToFile(PrintWriter writer, ArrayList<Filmy> film)
    {
        writer.println(film.indexOf(0) + "  " + film.indexOf(1)+ "  " +
                film.indexOf(2) + "  " + film.indexOf(3) );
    }

    public static void printToFile(String file_name, Filmy film) throws FilmyException {
        try (PrintWriter writer = new PrintWriter(file_name)) {
            printToFile(writer, film);
        } catch (FileNotFoundException e){
            throw new FilmyException("Nie odnaleziono pliku " + file_name);
        }

    }

    public static void printToFile(String s, ArrayList<Filmy> film) throws FilmyException
    {
        try (PrintWriter writer = new PrintWriter(s)) {
            printToFile(writer, film);
        } catch (FileNotFoundException e){
            throw new FilmyException("Nie odnaleziono pliku " + s);
        }
    }

    @Override
    public int compareTo(Filmy o)
    {

        if(this.getRok() > o.getRok())
            return 1;
        else
            return -1;

    }
}
