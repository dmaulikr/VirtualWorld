/*
 * Copyright (C) 2016 Kamil
 */
package WirtualnySwiat.Zwierzeta;

import WirtualnySwiat.Organizm;
import WirtualnySwiat.Swiat;
/**
 *
 * @author Kamil
 */
public class Zolw extends Zwierze
{
    public Zolw(Swiat swiat)
    {
        this.sila = 2;
        this.inicjatywa = 1;
        this.swiat = swiat;
        this.znak = 8;
    }
    
    @Override
    public void akcja()
    {
        if(generator.nextInt(100) < 25)
        {
            super.akcja();
        }
    }
    
    @Override
    public boolean obrona(Organizm o)
    {
        if(o.znajdz_sila() < 5)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
}
