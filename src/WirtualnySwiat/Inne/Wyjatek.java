/*
 * Copyright (C) 2016 Kamil
 */
package WirtualnySwiat.Inne;

/**
 *
 * @author Kamil
 */
public class Wyjatek extends Exception
{   
    public Wyjatek(String tekst)
    {
        this.tekst = tekst;
    }
    private String tekst;
}
