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
public class Guarana extends Roslina 
{
    public Guarana(Swiat swiat)
    {
        this.sila = 0;
        this.inicjatywa = 0;
        this.swiat = swiat;
        this.znak = 1;
    }
    
    @Override
    public boolean obrona(Organizm o)
    {
        o.buffSila(3);
        int a = o.znajdz_znak();
        swiat.logi(a, a, 3);
        return false;
    }
}
