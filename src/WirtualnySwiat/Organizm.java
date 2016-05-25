/*
 * Copyright (C) 2016 Kamil
 */
package WirtualnySwiat;
import java.util.Random;
/**
 *
 * @author Kamil
 */
abstract public class Organizm 
{
    public Organizm()
    {
        wiek = 0;
        zatruty = false;
    }
    public int znajdz_wiek(){return wiek;}
    public int znajdz_inicjatywa(){return inicjatywa;}
    public int znajdz_sila(){return sila;}
    public int znajdz_znak(){return znak;}
    public Polozenie znajdz_polozenie(){return polozenie;}
    public void ustaw_wiek(int wiek){this.wiek=wiek;}
    public void ustaw_inicjatywe(int inicjatywa){this.inicjatywa=inicjatywa;}
    public void ustaw_sila(int sila){this.sila=sila;}
    public void ustaw_polozenie(Polozenie polozenie){this.polozenie=polozenie;}
    public void ustaw_polozenie(int x, int y){this.polozenie.ustaw_x(x);this.polozenie.ustaw_y(y);}
    public void dodaj_wiek(){wiek++;}
    public void buffSila(int ile){sila+=ile;}
    public void zatrutoMnie(){zatruty=true;}
    
    //funkcja szuka wolnych pol wokol organizmu, zwraca liczbe reprezentujaca ilosc ile ich jest
    public int szukajWokolRodzica(Organizm o, int tabI[], int tabJ[], int przesun)
    {
        int a = 0;
        int x = o.znajdz_polozenie().znajdz_x();
        int y = o.znajdz_polozenie().znajdz_y();
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                if(i!=1 || j!=1)
                {
                    if(swiat.ktoryTamJest(x - 1 + i, y - 1 + j) == -1)
                    {
                        tabI[a] = i;
                        tabJ[a] = j;
                        a++;
                        przesun++;
                    }
                }
            }
        }
        a -= przesun;
        return przesun;
    }
    
    public void akcja(){}
    
    public boolean obrona(Organizm o){return false;}
    
    
    
    protected int wiek;
    protected int sila;
    protected int inicjatywa;
    protected int znak;
    protected boolean zatruty;
    protected Polozenie polozenie;
    protected Swiat swiat;
    protected void kolizja(Organizm o){}
    
    //implementowane z myślą o antylopie i człowieku
    protected int ucieczka(Organizm o)
    {
        int x = this.znajdz_polozenie().znajdz_x();
        int y = this.znajdz_polozenie().znajdz_y();
        int tab[] = new int[4];
        int ile = 0;
        int a = 0;
        if(swiat.ktoryTamJest(x, y - 1) == -1)
        {
            tab[a] = 1;
            a++;
            ile++;
        }
        if(swiat.ktoryTamJest(x + 1, y) == -1)
        {
            tab[a] = 2;
            a++;
            ile++;
        }
        if(swiat.ktoryTamJest(x, y + 1) == -1)
        {
            tab[a] = 3;
            a++;
            ile++;
        }
        if(swiat.ktoryTamJest(x - 1, y) == -1)
        {
            tab[a] = 4;
            a++;
            ile++;
        }
        if (ile != 0)
        {
            int r = generator.nextInt(ile);
            switch(tab[r])
            {
            case 1:
                ustaw_polozenie(x, y - 1);
                break;
            case 2:
                ustaw_polozenie(x + 1, y);
                break;
            case 3:
                ustaw_polozenie(x, y + 1);
                break;
            case 4:
                ustaw_polozenie(x - 1, y);
                break;
            default:
                break;
            }
        }
        return ile;
    }
    protected static Random generator = new Random();
}
