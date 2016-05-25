/*
 * Copyright (C) 2016 Kamil
 */
package WirtualnySwiat.Rosliny;

import WirtualnySwiat.Polozenie;
import WirtualnySwiat.Organizm;
/**
 *
 * @author Kamil
 */
abstract public class Roslina extends Organizm
{
    public void rozmnoz(Organizm o, int a, int b)
    {
        int x = o.znajdz_polozenie().znajdz_x();
        int y = o.znajdz_polozenie().znajdz_y();
        swiat.logi(o.znajdz_znak(), o.znajdz_znak(), 2);
        Polozenie gdzie = new Polozenie(x + a, y + b);
        swiat.dodajOrganizm(o.znajdz_znak(), gdzie);
    }
    
    public void rozmnazanie(Organizm o)
    {
        int tabI[] = new int[9];
        int tabJ[] = new int[9];
        int przesun = 0;
        przesun = this.szukajWokolRodzica(this, tabI, tabJ, przesun);
        if(przesun != 0)
        {
            int a = generator.nextInt(przesun);
            rozmnoz(this, -1 + tabI[a], -1 + tabJ[a]);
            return;
        }
    }
    
    @Override
    public void akcja()
    {
        int a = generator.nextInt(100);
        if (a < prawdopodobienstwo)
        {
           rozmnazanie(this);
        }
    }
    
    public void kolizja()
    {
        //Można zaimplementować jeśli chcemy mieć rośline, które się poruszają i mogą nachodzić na inne organizmy
    }
    
    public boolean obrona()
    {
        return false;
    }
    
    public int zwroc_prawdo(){return prawdopodobienstwo;}
    private static final int prawdopodobienstwo = 5;
}
