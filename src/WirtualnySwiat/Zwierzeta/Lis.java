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
public class Lis extends Zwierze
{
    public Lis(Swiat swiat)
    {
        this.sila = 3;
        this.inicjatywa = 7;
        this.swiat = swiat;
        this.znak = 2;
    }
    
    public void akcja()
    {
        //lis może się poruszyć na 4 pola
	int akcja[] = new int[4];
        int a = 0;
	int ile = 0;
	//sprawdzamy funkcją dobryWech w każdym wypadku czy ktoś tam jest, a jeśli jest to czy nie jest silniejszy od lisa
	if (znajdz_polozenie().znajdz_y() != 0)
	{
            if (dobryWech(0, -1))
            {
		akcja[a] = 1;
		a++;
		ile++;
            }
	}
	if (znajdz_polozenie().znajdz_x() != swiat.znajdz_x() - 1)
	{
            if (dobryWech(1, 0))
            {
		akcja[a] = 2;
		a++;
		ile++;
            }
	}
	if (znajdz_polozenie().znajdz_y() != swiat.znajdz_y() - 1)
	{
            if (dobryWech(0, 1))
            {
		akcja[a] = 3;
		a++;
		ile++;
            }
	}
        if (znajdz_polozenie().znajdz_x() != 0)
        {
            if (dobryWech(-1, 0))
            {
		akcja[a] = 4;
		a++;
		ile++;
            }
	}
	//spośród pól, na kótre lis się może ruszyć, losujemy jedno
	if (ile != 0)
	{
            int losuj = generator.nextInt(ile);
            switch (akcja[losuj])
            {
                case 1:
                    ruch(0, -1);
                    break;
		case 2:
                    ruch(1, 0);
                    break;
		case 3:
                    ruch(0, 1);
                    break;
		case 4:
                    ruch(-1, 0);
                    break;
		default:
                    break;
            }
        }
    }
        
    
    
    //Lis nie może poruszyć się na pole zajmowane przez organizm silniejszy niż on
    private boolean dobryWech(int a, int b)
    {
        int wspolrzednaPierwsza = znajdz_polozenie().znajdz_x() + a;
	int wspolrzednaDruga = znajdz_polozenie().znajdz_y() + b;
	if (swiat.ktoryTamJest(wspolrzednaPierwsza, wspolrzednaDruga) == -1)
	{
            return true;
	}
	else
        {
            int i = swiat.ktoryTamJest(wspolrzednaPierwsza, wspolrzednaDruga);
            Organizm przeciwnik = swiat.znajdz_organizmy()[i];
            if (przeciwnik.znajdz_sila() <= znajdz_sila())
            {
                return true;
            }
            else
            {
		return false;
            }
	}
    }
}
