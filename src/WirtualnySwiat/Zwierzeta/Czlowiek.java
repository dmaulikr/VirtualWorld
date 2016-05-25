/*
 * Copyright (C) 2016 Kamil
 */
package WirtualnySwiat.Zwierzeta;

import WirtualnySwiat.Organizm;
import WirtualnySwiat.Swiat;
import WirtualnySwiat.Polozenie;
/**
 *
 * @author Kamil
 */
public class Czlowiek extends Zwierze
{
    public Czlowiek(Swiat swiat)
    {
        this.sila = 5;
        this.inicjatywa = 4;
        this.swiat = swiat;
        this.znak = 9;
    }
    
    @Override
    public void akcja()
    {
        switch(swiat.znajdz_znak())
        {
            case 0:
                if(this.znajdz_polozenie().znajdz_x() != 0)
                {
                    ruch(-1, 0);
                }
                break;
            case 1:
                if(this.znajdz_polozenie().znajdz_y() != 0)
                {
                    ruch(0, -1);  
                }
                break;
            case 2:
                if(this.znajdz_polozenie().znajdz_x() != swiat.znajdz_x() -1)
                {
                    ruch(1, 0);     
                }
                break;
            case 3:
                if(this.znajdz_polozenie().znajdz_y() != swiat.znajdz_y() -1)
                {
                    ruch(0, 1);
                }
                break;
        }
    }
    
    @Override
    public boolean obrona(Organizm o)
    {
        if(swiat.czyAktywne() == true)
        {
            Polozenie czlowiek = this.znajdz_polozenie();
            if(ucieczka(o) != 0)
            {
                o.ustaw_polozenie(czlowiek);
            }
        }
        return swiat.czyAktywne();
    }
    
    private void supermoc(Organizm o)
    {
        int a = o.znajdz_znak();
        int b = this.znajdz_znak();
        if(this.znajdz_sila() >= o.znajdz_sila())
        {
            Polozenie punkt = o.znajdz_polozenie();
            if(!o.obrona(this))
            {
                if (a == 1 || a == 3 || a == 5 || a == 6)
		{
                    swiat.logi(b, a, 4);
		}
		else
		{
                    swiat.logi(b, a, 0);
		}
                swiat.zabij(o);
                ustaw_polozenie(punkt);
            }
            else
            {
                swiat.logi(a, b, 5);
            }
        }
        else if(this.znajdz_sila() < o.znajdz_sila())
        {
            swiat.logi(b, b, 5);
            //nie wchodzi na przeciwnika jak ma umiejetnosc
        }
    }
    
    @Override
    protected void kolizja(Organizm o)
    {
        if(swiat.czyAktywne() == true)
        {
            supermoc(o);
        }
        else
        {
            super.kolizja(o);
        }
    }
}
