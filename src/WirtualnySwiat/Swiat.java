/*
 * Copyright (C) 2016 Kamil
 */
package WirtualnySwiat;

import java.util.Random;
import WirtualnySwiat.Zwierzeta.*;
import WirtualnySwiat.Rosliny.*;
import WirtualnySwiat.Inne.Wyjatek;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 *
 * @author Kamil
 */
public class Swiat 
{
    //konstruktor
    public Swiat(int x, int y, int ileOrganizmow)
    {
        this.ileOrganizmow = ileOrganizmow;
        //ograniczenie konstruktora do świata wymiarów 20x20
        if(x > 20)
        {
            x = 20;
        }
        if(y>20)
        {
            y = 20;
        }
        //tylko jeden organizm na pole
        if(ileOrganizmow > x * y)
        {
            ileOrganizmow = x * y;
        }
        this.x = x;
        this.y = y;
        tura = 0;
        luki = 0;
        kiedyAktywacja = 0;
        aktywacja = false;
        iloscOrganizmow = 0;
        organizmy = new Organizm[x*y];
        for(int i = 0; i < x*y; i++)
        {
            organizmy[i]=null;
        }
        Random generator = new Random();
        int a = generator.nextInt(x);
        int b = generator.nextInt(y);
        Polozenie czlowiek = new Polozenie(a, b);
        dodajOrganizm(9, czlowiek);
        if(ileOrganizmow < 19)//jak ich malo to dodajemy losowe
        {
            for(int i = 0; i < ileOrganizmow - 1; i++)
            {
                int rand = generator.nextInt(9);
                dodajOrganizm(rand, wolnyPunkt());
            }
        }
        else
        {//jak ich wiecej to dodajemy po 2 z kazdego gatunku, a reszte losowo
            for(int i = 0; i < 9; i++)
            {
                dodajOrganizm(i, wolnyPunkt());
                dodajOrganizm(i, wolnyPunkt());   
            }
            for(int i = 0; i < ileOrganizmow - 19; i++)
            {
                int rand = generator.nextInt(9);
                dodajOrganizm(rand, wolnyPunkt());
            }
        }
    }
    
    
    public void dodajOrganizm(int znak, Polozenie gdzie)
    {
        int i = 0;
        while(organizmy[i] != null)
        {
            i++;
        }
        organizmy[i] = narodziny(znak);
        organizmy[i].ustaw_polozenie(gdzie);
        if(luki == 0)
        {
            iloscOrganizmow++;
        }
        else
        {
            luki--;
        }
    }
    
    public void gramy(int znak)
    {
        if (aktywacja == true && tura - kiedyAktywacja > 4)
	{
            logi(9, 9, 7);
            aktywacja = false;
	}
        if(znak < 4)
        {
            this.znak = znak;
            this.wykonajTure();
        }
        else if(znak == 4)
        {
            if(aktywacja == false)
            {
                if (kiedyAktywacja != 0 && tura - kiedyAktywacja < 10)
		{
                    logi(9, 9, 8);
		}
		else if (tura != 0)
		{
                    kiedyAktywacja = tura;
                    aktywacja = true;
                    logi(9, 9, 6);
		}
            }
        }
        else if(znak == 5)
        {
            try
            {
                zapiszDoPliku();
            }
            catch(FileNotFoundException ex)
            {
                System.out.println("Błąd zapisu do pliku");
            }
            catch(Wyjatek w)
            {
                System.out.println("Zły typ danych");
            }
        }
        else if(znak == 6)
        {
            try
            {
                wczytajZPliku();
            }
            catch (FileNotFoundException ex)
            {
                System.out.println("Błąd odczytu z pliku");
            }
            catch(Wyjatek w)
            {
                System.out.println("Zły typ danych");
            }
        }
        else if(znak == 7)
        {
            nowaGra();
        }
        //8 zarezerowwane dla HELP!
    }
    
    public void zabij(Organizm o)
    {
        Polozenie kogo = o.znajdz_polozenie();
        organizmy[ktoryTamJest(kogo.znajdz_x(), kogo.znajdz_y())] = null;
        luki++;
    }
    
    public void logi(int a, int b, int akcja)
    {
        if(tablicaLogow[0] == " ")
        {
            iteratorLogow = 0;
        }
        if(iteratorLogow == 20)
        {
            for(int i = 0; i < 20 - 1; i++)
            {
                tablicaLogow[i] = tablicaLogow[i + 1];
            }
            iteratorLogow = 19;
        }
        if(akcja == 0)
        {
            tablicaLogow[iteratorLogow] = "Tura " + tura + ": " + nazwa(a) + " zabił " + nazwa(b); 
        }
        else if(akcja == 1)
        {
            tablicaLogow[iteratorLogow] = "Tura " + tura + ": " + nazwa(a) + " rozsiał sie "; 
        }
        else if(akcja == 2)
        {
            tablicaLogow[iteratorLogow] = "Tura " + tura + ": " + nazwa(a) + " rozmnożył się "; 
        }
        else if(akcja == 3)
        {
            tablicaLogow[iteratorLogow] = "Tura " + tura + ": " + " +3 siły dla  " + nazwa(a); 
        }
        else if(akcja == 4)
        {
            tablicaLogow[iteratorLogow] = "Tura " + tura + ": " + nazwa(a) + " zjadł " + nazwa(b); 
        }
        else if(akcja == 5)
        {
            if(a == 8)
            {
                tablicaLogow[iteratorLogow] = "Tura " + tura + ": " + nazwa(a) + " odpiera atak od " + nazwa(b); 
            }
            else if(a == 0)
            {
                tablicaLogow[iteratorLogow] = "Tura " + tura + ": " + nazwa(a) + " ucieka przed " + nazwa(b); 
            }
            else if(a == 9)
            {
                tablicaLogow[iteratorLogow] = "Tura " + tura + ": " + nazwa(a) + " jest nieśmiertelny! "; 
            }
        }
        else if(akcja == 6)
        {
            tablicaLogow[iteratorLogow] = "Tura " + tura + ": " + " Aktywacja umiejętności "; 
        }
        else if(akcja == 7)
        {
            tablicaLogow[iteratorLogow] = "Tura " + tura + ": " + " Dezaktywacja umiejętności ";  
        }
        else if(akcja == 8)
        {
            tablicaLogow[iteratorLogow] = "Tura " + tura + ": " + " Umiejętność się odnawia "; 
        }
        else if(akcja == 9)
        {
            tablicaLogow[iteratorLogow] = "Tura " + tura + ": " + nazwa(a) + " zatruł " + nazwa(b); 
        }
        else if(akcja == 10)
        {
            tablicaLogow[iteratorLogow] = "Tura " + tura + ": " + nazwa(a) + " umiera "; 
        }
        iteratorLogow++;
    }
    
    public String nazwa (int znak)
    {
        switch (znak)
	{
            case 0: return "Antylopa";
            case 1: return "Guarana";
            case 2: return "Lis";
            case 3: return "Mlecz";
            case 4: return "Owca";
            case 5: return "Trawa";
            case 6: return "WilczeJagody";
            case 7: return "Wilk";
            case 8: return "Zolw";
            case 9: return "Czlowiek";
            default: return "Nieznany organizm";
	}
    }
    
    public int znajdz_x(){return x;}
    public int znajdz_y(){return y;}
    public int znajdz_znak(){return znak;}
    public int znajdz_iloscOrganizmow(){return iloscOrganizmow;}
    public String[] zwroc_logi(){return tablicaLogow;}
    public Organizm[] znajdz_organizmy(){return organizmy;}
    
    //zwraca indeks organizmu na polu o wspolrzednych x,y. Jesli nic tam nie ma, to zwraca -1
    public int ktoryTamJest(int x, int y)
    {
        if (x == -1 || y == -1 || x == (this.x) || y == (this.y))
	{
            return -2;
	}
	for (int i = 0; i < iloscOrganizmow; i++)
	{
            if (organizmy[i] != null)
            {
                if (organizmy[i].znajdz_polozenie().porownaj(new Polozenie(x,y)))
		{
                    return i;
		}
            }
        }
	return -1;
    }
    public boolean czyAktywne()
    {
        return aktywacja;
    }
    
    
    //rozmiary świata
    private int x;
    private int y;
    
    private Organizm[] organizmy; 
    private int iloscOrganizmow;//alokujemy x*y miejsca dla organizmow, ale przeszukujemy tablice tylko
    //tak daleko, ile rzeczywiście mamy tam organizmów. 
    
    private int znak; //odzwierciedla wciśnięty przycisk/klawisz. W zależności od tego wykonujemy akcję
    
    private int tura;
    
    //Jeśli usunę(zabiję) organizm, to wtedy w tablicy powstaje luka. Postanowiłem zapisywać ilość luk i 
    //alokować nowe organizmy w lukach tak, aby było ekeonomiczniej
    private int luki;
    private int ileOrganizmow;//potrzebne do robienia nowej gry, tzn zapisuje wartość ile podano w konstruktorze
    
    //do superumiejętności człowieka
    private int kiedyAktywacja;
    private boolean aktywacja;
    
    //logi gry
    private String tablicaLogow[] = new String[20];
    private static int iteratorLogow = 0;
   
    private void wykonajTure()
    {
        for(int a = 7; a >= 0; a--)//po inicjatywie
        {
            for(int b = tura; b > 0; b--)//po wieku
            {
                for(int i = 0; i < iloscOrganizmow; i++)
                {
                    if(organizmy[i] != null)
                    {
                        if(organizmy[i].znajdz_inicjatywa() == a && organizmy[i].znajdz_wiek() == b)
                        {
                            organizmy[i].akcja();
                        }
                    }
                }
            }
        }
        for (int j = 0; j < iloscOrganizmow; j++)
	{
            if (organizmy[j] != null)
            {
		organizmy[j].dodaj_wiek();
            }
	}
	tura++;
    }
    
    //Zwraca polozenie losowego niezajętego pola
    private Polozenie wolnyPunkt()
    {
        Random generator = new Random();
        int a = generator.nextInt(x);
        int b = generator.nextInt(y);
        Polozenie losowe = new Polozenie(a, b);
        for(int i = 0; i < iloscOrganizmow; i++)
        {
            boolean poleZajete = (losowe.porownaj(organizmy[i].znajdz_polozenie()));
            if (poleZajete)
            {
                return wolnyPunkt();
            }
        }
        return losowe;
    }
    
    private Organizm narodziny(int znak)
    {
        Organizm organizm = null;
        switch(znak)
        {
            case 0:
                organizm = new Antylopa(this);
                break;
            case 1:
                organizm = new Guarana(this);
                break;
            case 2:
                organizm = new Lis(this);
                break;
            case 3:
                organizm = new Mlecz(this);
                break;
            case 4:
                organizm = new Owca(this);
                break;
            case 5:
                organizm = new Trawa(this);
                break;
            case 6:
                organizm = new WilczeJagody(this);
                break;
            case 7:
                organizm = new Wilk(this);
                break;
            case 8:
                organizm = new Zolw(this);
                break;
            case 9:
                organizm = new Czlowiek(this);
                break;
            default:
                break;
        }
        return organizm;
    }
    
    private void zapiszDoPliku() throws FileNotFoundException, Wyjatek
    {
        PrintWriter zapis = new PrintWriter("save.txt");
        zapis.println(x);
        zapis.println(y);
        zapis.println(iloscOrganizmow);
        zapis.println(luki);
        zapis.println(tura);
        zapis.println(kiedyAktywacja);
        zapis.println(aktywacja);
        for(int i = 0; i < iloscOrganizmow; i++)
        {
            if(organizmy[i] != null)
            {
                Polozenie temp = organizmy[i].znajdz_polozenie();
                zapis.println(organizmy[i].znajdz_znak());
                zapis.println(temp.znajdz_x());
                zapis.println(temp.znajdz_y());
                zapis.println(organizmy[i].znajdz_sila());
                zapis.println(organizmy[i].znajdz_inicjatywa());
                zapis.println(organizmy[i].znajdz_wiek());      
            }
        }
        zapis.close();
    }
    
    private void wczytajZPliku() throws FileNotFoundException, Wyjatek
    {
        File plik = new File("save.txt");
        Scanner in = new Scanner(plik);
        for (int i = 0; i < 20; i++)
        {
            tablicaLogow[i] = " ";
	}
        x = in.nextInt();
        y = in.nextInt();
        iloscOrganizmow = in.nextInt();
        luki = in.nextInt();
        tura = in.nextInt();
        kiedyAktywacja = in.nextInt();
        String śmieć = in.nextLine();
        String temp = in.nextLine();
        if(temp == "true")
        {
            aktywacja = true;
        }
        else
        {
            aktywacja = false;
        }
        organizmy = new Organizm [x*y];
        for(int i = 0; i < x*y; i++)
        {
            organizmy[i] = null;
        }
        for(int i = 0; i < iloscOrganizmow - luki; i++)
        {
            int znak = in.nextInt();
            organizmy[i] = narodziny(znak);
            int temp1, temp2, sila, inicjatywa, wiek;
            temp1 = in.nextInt();
            temp2 = in.nextInt();
            sila = in.nextInt();
            inicjatywa = in.nextInt();
            wiek = in.nextInt();
            organizmy[i].ustaw_polozenie(new Polozenie(temp1, temp2));
            organizmy[i].ustaw_sila(sila);
            organizmy[i].ustaw_inicjatywe(inicjatywa);
            organizmy[i].ustaw_wiek(wiek);
        }
    }
    
    private void nowaGra()     
    {
        for(int i = 0; i < x*y; i++)
        {
            organizmy[i] = null;
        }
        tura = 0;
        luki = 0;
        kiedyAktywacja = 0;
        aktywacja = false;
        iloscOrganizmow = 0;
        Random generator = new Random();
        int a = generator.nextInt(x);
        int b = generator.nextInt(y);
        Polozenie czlowiek = new Polozenie(a, b);
        dodajOrganizm(9, czlowiek);
        if(ileOrganizmow < 19)
        {
            for(int i = 0; i < ileOrganizmow - 1; i++)
            {
                int rand = generator.nextInt(9);
                dodajOrganizm(rand, wolnyPunkt());
            }
        }
        else
        {
            for(int i = 0; i < 9; i++)
            {
                dodajOrganizm(i, wolnyPunkt());
                dodajOrganizm(i, wolnyPunkt());   
            }
            for(int i = 0; i < ileOrganizmow - 19; i++)
            {
                int rand = generator.nextInt(9);
                dodajOrganizm(rand, wolnyPunkt());
            }
        }
    }
}
