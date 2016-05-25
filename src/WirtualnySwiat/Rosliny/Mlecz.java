/*
 * Copyright (C) 2016 Kamil
 */
package WirtualnySwiat.Rosliny;

import WirtualnySwiat.Swiat;
/**
 *
 * @author Kamil
 */
public class Mlecz extends Roslina 
{
    public Mlecz(Swiat swiat)
    {
        this.sila = 0;
        this.inicjatywa = 0;
        this.swiat = swiat;
        this.znak = 3;
    }
    
    @Override
    public void akcja()
    {
       for(int i = 0; i < 3; i++)
       {
           int a = generator.nextInt(100);
           if(a < this.zwroc_prawdo())
           {
               rozmnazanie(this);
           }
       }
    }
}
