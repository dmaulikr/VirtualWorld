/*
 * Copyright (C) 2016 Kamil
 */
package WirtualnySwiat.Zwierzeta;

import WirtualnySwiat.Organizm;
import WirtualnySwiat.Polozenie;
/**
 *
 * @author Kamil
 */
abstract public class Zwierze extends Organizm
{
    @Override
    public void akcja()
    {
        int i = generator.nextInt(4);
        switch(i)
        {
            case 0:
                if(znajdz_polozenie().znajdz_y() != 0)
                {
                    ruch(0, -1);
                }
                break;
            case 1:
                if(znajdz_polozenie().znajdz_x() != swiat.znajdz_x() - 1)
                {
                    ruch(1, 0);
                }
                break;
            case 2:
                if(znajdz_polozenie().znajdz_y() != swiat.znajdz_y() - 1)
                {
                    ruch(0, 1);
                }
                break;
            case 3:
                if(znajdz_polozenie().znajdz_x() != 0)
                {
                    ruch(-1, 0);
                }
                break;
            default:
                break;
        }
    }
    
    protected void walka(Organizm o)
    {
        int a = o.znajdz_znak();
        int b = this.znajdz_znak();
        if(this.znajdz_sila() >= o.znajdz_sila())
        {
            Polozenie punkt = o.znajdz_polozenie();
            if(!(o.obrona(this)))
            {
                if(a == 1 || a == 3 || a == 5 || a == 6)
                {
                    swiat.logi(b, a, 4);
                }
                else
                {
                    swiat.logi(b, a, 0);
                }
                swiat.zabij(o);
                this.ustaw_polozenie(punkt);
                if(this.zatruty)
                {
                    swiat.logi(b, b, 10);
                    swiat.zabij(this);
                }
            }
            else
            {
                swiat.logi(a, b, 5);
            }
        }
        else if(this.znajdz_sila() < o.znajdz_sila())
        {
            swiat.logi(a, b, 0);
            swiat.zabij(this);
        }
    }
    
    @Override
    protected void kolizja(Organizm o)
    {
        if(this.getClass()==o.getClass())
        {
            rozmnazanie(o);
        }
        else
        {
            walka(o);
        }
    }
    
    protected void ruch(int a, int b)
    {
        int pierwszaWspolrzedna = znajdz_polozenie().znajdz_x() + a;
	int drugaWspolrzedna = znajdz_polozenie().znajdz_y() + b;
	if (swiat.ktoryTamJest(pierwszaWspolrzedna, drugaWspolrzedna) == -1)
        {
            ustaw_polozenie(pierwszaWspolrzedna, drugaWspolrzedna);
	}
	else
	{
            kolizja(swiat.znajdz_organizmy()[swiat.ktoryTamJest(pierwszaWspolrzedna, drugaWspolrzedna)]);
	}
    }
    
    protected void rozmnazanie(Organizm o)
    {
        int tabI[] = new int[9];
        int tabJ[] = new int[9];
        int tabI2[] = new int[9];
        int tabJ2[] = new int[9];
        int przesun = 0, przesun2 = 0;
        przesun = szukajWokolRodzica(this, tabI, tabJ, przesun);
        przesun2 = szukajWokolRodzica(o, tabI2, tabJ2, przesun2);
        if(przesun!=0 || przesun2!=0)
        {
            int i = generator.nextInt(2);
            if(i == 1)
            {
                if(przesun != 0)
                {
                    int a = generator.nextInt(przesun);
                    rozmnoz(this, -1 + tabI[a], -1 + tabJ[a]);
                }
                else
                {
                    int a = generator.nextInt(przesun2);
                    rozmnoz(o, -1 + tabI2[a], -1 + tabJ2[a]);
                }
            }
            else
            {
                if(przesun2 != 0)
                {
                    int a = generator.nextInt(przesun2);
                    rozmnoz(o, -1 + tabI2[a], -1 + tabJ2[a]);
                }
                else
                {
                    int a = generator.nextInt(przesun);
                    rozmnoz(this, -1 + tabI[a], -1 + tabJ[a]);
                }
            }
        }
    }
    
    protected void rozmnoz(Organizm o, int a, int b)
    {
        int x = o.znajdz_polozenie().znajdz_x();
	int y = o.znajdz_polozenie().znajdz_y();
        swiat.logi(o.znajdz_znak(), o.znajdz_znak(), 2);
	Polozenie gdzie = new Polozenie(x + a, y + b);
	swiat.dodajOrganizm(o.znajdz_znak(), gdzie);
    }
    
}
