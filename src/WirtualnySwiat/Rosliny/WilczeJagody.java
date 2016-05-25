/*
 * Copyright (C) 2016 Kamil
 */
package WirtualnySwiat.Rosliny;

import WirtualnySwiat.Organizm;
import WirtualnySwiat.Swiat;
/**
 *
 * @author Kamil
 */
public class WilczeJagody extends Roslina 
{
    public WilczeJagody(Swiat swiat)
    {
        //sila 99 tzn, ze zawsze zabija jak się na nią wejdzie
        this.sila = 0;
        this.inicjatywa = 0;
        this.swiat = swiat;
        this.znak = 6;
    }
    
    public void zatruj(Organizm o)
    {
        if(!swiat.czyAktywne())
        {
            o.zatrutoMnie();
        }
    }
    
    @Override
    public boolean obrona(Organizm o)
    {
        zatruj(o);
        swiat.logi(this.znajdz_znak(), o.znajdz_znak(), 9);
        return false;
    }
}
