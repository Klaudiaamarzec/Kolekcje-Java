package tb.soft;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.*;

public class Filmykolekcje
{
    static Scanner scan = new Scanner(System.in);

    static String tytul;
    static String gatunek;
    static int rok;
    static String kraj;

    //Zbiory
    static HashSet<Filmy> lista1 = new HashSet<Filmy>();

    static TreeSet<Filmy> lista2 = new TreeSet<Filmy>();
    //Listy
    static ArrayList<Filmy> lista3 = new ArrayList<Filmy>();
    static LinkedList<Filmy> lista4 = new LinkedList<Filmy>();

    static HashMap<Filmy, FilmyDziedziczenie> lista5 = new HashMap<Filmy, FilmyDziedziczenie>();
    //static TreeMap<Filmy> lista6 = new TreeMap<Filmy>();

    static HashSet<FilmyDziedziczenie> lista7 = new HashSet<FilmyDziedziczenie>();
    static TreeSet<FilmyDziedziczenie> lista8 = new TreeSet<FilmyDziedziczenie>();
    static ArrayList<FilmyDziedziczenie> lista9 = new ArrayList<FilmyDziedziczenie>();
    static LinkedList<FilmyDziedziczenie> lista10 = new LinkedList<FilmyDziedziczenie>();

    static void dane()
    {
        //Funkcja pobierająca dane
        System.out.println("Podaj tytuł filmu:");
        tytul = scan.next();
        System.out.println("Podaj gatunek filmu:");
        gatunek = scan.next();
        System.out.println("Podaj rok produkcji filmu:");
        rok = scan.nextInt();
        System.out.println("Podaj kraj produkcji filmu:");
        kraj = scan.next();
    }

    static Filmy daneF()
    {
        Filmy film = new Filmy(tytul, gatunek, kraj,rok);
        return film;
    }

    static FilmyDziedziczenie daneFD()
    {
        FilmyDziedziczenie film = new FilmyDziedziczenie(tytul, gatunek, kraj,rok);
        return film;
    }

    static void menu()
    {
        System.out.println("MENU GŁÓWNE");
        System.out.println("1- Dodaj dane filmu");
        System.out.println("2- Wyświetl dane wszystkich filmów w bazie");
        System.out.println("3- Usuń dane filmu");
        System.out.println("4- Wczytaj dane z pliku");
        System.out.println("5- Zapisz dane do pliku");
        System.out.println("0 - Zakończ program");
    }

    static void menuKolekcje()
    {
        System.out.println("1- HashSet");
        System.out.println("2- TreeSet");
        System.out.println("3- ArrayList");
        System.out.println("4- LinkedList");
        System.out.println("5- HashMap");
        //System.out.println("6- TreeMap");
        System.out.println("0- Koniec");
    }

    static void wyswietlH1(HashSet<Filmy> lista)
    {
        for(Filmy cos : lista)
        {
            System.out.println(cos);
        }
    }

    static void wyswietlH2(HashSet<FilmyDziedziczenie> lista)
    {
        for(Filmy cos : lista)
        {
            System.out.println(cos);
        }
    }

    static void wyswietlT1(TreeSet<Filmy> lista)
    {
        for(Filmy cos : lista)
        {
            System.out.println(cos);
        }
    }

    static void wyswietlT2(TreeSet<FilmyDziedziczenie> lista)
    {
        for(Filmy cos : lista)
        {
            System.out.println(cos);
        }
    }

    static void wyswietlA1(ArrayList<Filmy> lista)
    {
        for(Filmy cos : lista)
        {
            System.out.println(cos);
        }
    }

    static void wyswietlA2(ArrayList<FilmyDziedziczenie> lista)
    {
        for(Filmy cos : lista)
        {
            System.out.println(cos);
        }
    }

    static void wyswietlL1(LinkedList<Filmy> lista)
    {
        for(Filmy cos : lista)
        {
            System.out.println(cos);
        }
    }

    static void wyswietlL2(LinkedList<FilmyDziedziczenie> lista)
    {
        for(Filmy cos : lista)
        {
            System.out.println(cos);
        }
    }

    public static void main(String[] args) throws FileNotFoundException, FilmyException
    {
        menu();
        int numer = scan.nextInt();

        while(numer!=0)
        {

            switch(numer)
            {
                case 1:
                {
                    //Dodanie nowego filmu do bazy
                    dane();
                    Filmy film1 = daneF();
                    FilmyDziedziczenie film2 = daneFD();

                    //HashSet - elementy nie mogą się powtarzac!
                    //Klasa Filmy- dodawanie wszystkiego co zostanie podane, niezależnie od powtarzalności
                    lista1.add(film1);
                    //Klasa FilmyDziedziczenie- dodawanie do zbioru tylko nowych elementów, które nie zostały jeszcze dodane
                    lista7.add(film2);

                    //TreeSet - dodawanie wszystkiego, co zostanie podane, niezależnie od powtarzalności
                    lista2.add(film1);
                    lista8.add(film2);

                    //Do ArrayListy mozna wielokrotnie dodawac te same elementy, zostają one umieszczone
                    //na liście tyle razy, ile razy ich dane zostały wprowadzone- w obu przypadkach działa tak samo

                    lista3.add(film1);
                    lista9.add(film2);

                    //LinkedList- dodawanie wielokrotnie tych samych elementów- w obu przypadkach to samo
                    lista4.add(film1);
                    lista10.add(film2);

                    lista5.put(film1, film2);

                    break;
                }

                case 2:
                {
                    //Wyswietlenie danych wszystkich filmów w bazie

                    System.out.println("Wybierz, który rodzaj kolekcji chcesz użyć do wyświetlenia danych filmów:");
                    menuKolekcje();
                    int kolekcje = scan.nextInt();

                    switch(kolekcje)
                    {
                        case 1:
                        {
                            //HashSet

                            //Bez nadpiasnych funkcji hashCode() oraz equals() zbiór wypisuje wszystkie elementy, które zostały w nim
                            //umieszczone, bez zwracania uwagi na to, czy się powtarzają oraz w takiej kolejności, w jakiej zostały podane
                            System.out.println("Filmy:");
                            wyswietlH1(lista1);
                            System.out.println();

                            //Z nadpisaniem funkcji hashCode() oraz equals() zbiór HashSet zachowuje się prawidłowo, czyli
                            //dodaje do zbioru tylko elementy, które się nie powtarzają, nie zwraca natomiast uwagi na kolejność wpisywania
                            System.out.println("FilmyDziedziczenie:");
                            wyswietlH2(lista7);
                            System.out.println();

                            break;
                        }
                        case 2:
                        {
                            //TreeSet - wyświetla wszystkie elemnty zbioru bez zwracania uwagi na kolejność
                            //W obu przypadkach działa tak samo

                            System.out.println("Filmy:");
                            wyswietlT1(lista2);
                            System.out.println();
                            System.out.println("FilmyDziedziczenie");
                            wyswietlT2(lista8);

                            break;
                        }
                        case 3:
                        {
                            //ArrayList

                            //W obu przypadkach zachowuje sie tak samo- jest to uporządkowana lista i wszystkie dane są wyświetlane
                            //w takiej kolejności, w jakiej zostały podane, niezależnie od tego czy się powtarzają czy nie

                            System.out.println("Filmy:");
                            wyswietlA1(lista3);
                            System.out.println();
                            System.out.println("FilmyDziedziczenie:");
                            wyswietlA2(lista9);
                            System.out.println();

                            break;
                        }
                        case 4:
                        {
                            //LinkedList - wyświetlanie danych w odpowiedniej kolejności, w jakiej zostały podane, w obu przypadkach

                            System.out.println("Filmy:");
                            wyswietlL1(lista4);
                            System.out.println();
                            System.out.println("FilmyDziedziczenie:");
                            wyswietlL2(lista10);
                            System.out.println();

                            break;
                        }
                        case 5:
                        {
                            //HashMap -
                            System.out.println(lista5);
                        }
                    }

                    break;

                }

                case 3:
                {
                    //Usunięcie danych filmu z bazy

                    System.out.println("Podaj numer filmu, który chcesz usunąć z listy");
                    int liczba = scan.nextInt();

                    System.out.println("Wybierz, który rodzaj chcesz użyć do sprawdzenia, jak zostają usunięte dane z kolekcji:");
                    menuKolekcje();
                    int kolekcje = scan.nextInt();

                    switch(kolekcje)
                    {
                        case 1:
                        {
                            //HashSet
                            //Usuwanie elementów ze zbioru nie jest możliwe w obu przypadkach

                            lista1.remove(liczba-1);
                            lista7.remove(liczba-1);

                            System.out.println("Filmy:");
                            wyswietlH1(lista1);
                            System.out.println();
                            System.out.println("FilmyDziedziczenie:");
                            wyswietlH2(lista7);
                            System.out.println();

                            break;
                        }
                        case 2:
                        {
                            //TreeSet

                            lista2.remove(liczba-1);
                            lista8.remove(liczba-1);

                            System.out.println("Filmy:");
                            wyswietlT1(lista2);
                            System.out.println();
                            System.out.println("FilmyDziedziczenie:");
                            wyswietlT2(lista8);
                            System.out.println();

                            break;
                        }
                        case 3:
                        {
                            //ArrayList
                            //W obu przypadkach dane są usuwane poprawnie

                            lista3.remove(liczba-1);
                            lista9.remove(liczba-1);

                            System.out.println("Filmy:");
                            wyswietlA1(lista3);
                            System.out.println();
                            System.out.println("FilmyDziedziczenie:");
                            wyswietlA2(lista9);
                            System.out.println();

                            break;
                        }
                        case 4:
                        {
                            //LinkedList

                            lista3.remove(liczba-1);
                            lista10.remove(liczba-1);

                            //Klasa Filmy- lista nie usuwa danych
                            System.out.println("Filmy:");
                            wyswietlL1(lista4);
                            System.out.println();

                            //Klasa FilmyDziedziczenie- lista poprawnie usuwa wymagane dane
                            System.out.println("FilmyDziedziczenie:");
                            wyswietlL2(lista10);
                            System.out.println();

                            break;
                        }
                        case 5:
                        {
                            //HashMap
                            lista5.remove(liczba-1);
                            System.out.println(lista5);
                        }
                    }

                    break;
                }

                case 4:
                {
                    //Nie działa

                    //Wczytaj dane z pliku - filmy.txt

                    //Obiekt przechowujacy dane pliku:
                    Filmy film = Filmy.readFromFile("filmy.txt");
                    //File plik = new File(nazwa);
                    //Scanner odczyt = new Scanner(new File(nazwa));
                    //Filmy linijka = Filmy.readFromFile(odczyt.nextLine());
                    //lista.add(linijka);
                    lista3.add(film);
                }

                case 5:
                {
                    //Nie działa

                    //Zapis danych do pliku - plik zapis.txt

                    //Filmy film = null;
                    Filmy.printToFile("zapis.txt", lista3);
                }

            }

            menu();
            numer = scan.nextInt();
        }

        System.out.println("Program zakończył działanie!");

    }
}
