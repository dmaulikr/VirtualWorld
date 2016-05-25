/*
 * Copyright (C) 2016 Kamil
 */
package WirtualnySwiat;

/**
 *
 * @author Kamil
 */
public class Polozenie {
    public Polozenie(int x, int y){this.x=x; this.y=y;}
    public int znajdz_x(){return x;}
    public int znajdz_y(){return y;}
    public void ustaw_x(int x){this.x=x;}
    public void ustaw_y(int y){this.y=y;}
    public boolean porownaj(Polozenie b)
    {
        if(this.x == b.x && this.y == b.y)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    private int x;
    private int y;
}
