/*
 * Copyright (C) 2016 Kamil
 */
package WirtualnySwiat.Zwierzeta;

import WirtualnySwiat.Organizm;
import WirtualnySwiat.Polozenie;
import WirtualnySwiat.Swiat;
/**
 *
 * @author Kamil
 */
public class Antylopa extends Zwierze
{
    public Antylopa(Swiat swiat)
    {
        this.sila = 4;
        this.inicjatywa = 4;
        this.swiat = swiat;
        this.znak = 0;
    }
    
    @Override
    public void akcja()
    {
        switch (generator.nextInt(12))
	{
            case 0:
                if (znajdz_polozenie().znajdz_y() != 0)
		{
                    ruch(0, -1);
		}
		break;
            case 1:
		if (znajdz_polozenie().znajdz_x() != swiat.znajdz_x() - 1)
		{
                    ruch(1, 0);
		}
		break;
            case 2:
		if (znajdz_polozenie().znajdz_y() != swiat.znajdz_y() - 1)
		{
                    ruch(0, 1);
		}
		break;
            case 3:
		if (znajdz_polozenie().znajdz_x() != 0)
		{
                    ruch(-1, 0);
		}
		break;
            case 4:
		if (znajdz_polozenie().znajdz_y() > 1)
		{
                    ruch(0, -2);
		}
		else if (znajdz_polozenie().znajdz_y() != 0)
		{
                    ruch(0, -1);
		}
		break;
            case 5:
                if (znajdz_polozenie().znajdz_x() < swiat.znajdz_x() - 2)
		{
                    ruch(2, 0);
		}
		else if (znajdz_polozenie().znajdz_x() != swiat.znajdz_x() - 1)
		{
                    ruch(1, 0);
		}
		break;
            case 6:
		if (znajdz_polozenie().znajdz_y() < swiat.znajdz_y() - 2)
		{
                    ruch(0, 2);
		}
		else if (znajdz_polozenie().znajdz_y() != swiat.znajdz_y() - 1)
		{
                    ruch(0, 1);
		}
		break;
            case 7:
		if (znajdz_polozenie().znajdz_x() > 1)
		{
                    ruch(-2, 0);
		}
		else if (znajdz_polozenie().znajdz_x() != 0)
		{
                    ruch(-1, 0);
		}
		break;
            case 8:
		if (znajdz_polozenie().znajdz_y() != 0 && znajdz_polozenie().znajdz_x() != 0)
		{
                    ruch(-1, -1);
		}
		break;
            case 9:
		if (znajdz_polozenie().znajdz_y() != swiat.znajdz_y() - 1 && znajdz_polozenie().znajdz_x() != 0)
		{
                    ruch(-1, 1);
		}
		break;
            case 10:
		if (znajdz_polozenie().znajdz_y() != swiat.znajdz_y() - 1 && znajdz_polozenie().znajdz_x() != swiat.znajdz_x() - 1)
		{
                    ruch(1, 1);
		}
		break;
            case 11:
		if (znajdz_polozenie().znajdz_y() != 0 && znajdz_polozenie().znajdz_x() != swiat.znajdz_x() - 1)
		{
                    ruch(1, -1);
		}
		break;
            default:
		break;
			}
    }
    
    @Override
    public boolean obrona(Organizm o)
    {
        if(generator.nextInt(2) == 1)
        {
          Polozenie antylopa = this.znajdz_polozenie();
          int x = antylopa.znajdz_x();
          int y = antylopa.znajdz_y();
          if(ucieczka(o) != 0)
          {
              o.ustaw_polozenie(x, y);
              return true;
          }
          else
          {
              return false;
          }
        }
        else
        {
            return false;
        }
    }
    
    @Override
    protected void kolizja(Organizm o)
    {
        if(this.getClass() == o.getClass())
        {
            rozmnazanie(o);
        }
        else
        {
            int a = o.znajdz_znak();
            int rand = generator.nextInt(2);
            if(rand == 1 && !(a == 1 || a == 3 || a == 5 || a ==6) && ucieczka(o) != 0)
            {
                swiat.logi(this.znajdz_znak(), a, 5);
            }
            else
            {
                walka(o);
            }
        }
    }
}

