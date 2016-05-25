/*
 * Copyright (C) 2016 Kamil
 */
package WirtualnySwiat.Inne;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Kamil
 */
public class DodawaczOrganizmow extends JFrame{
    public DodawaczOrganizmow(Gramy panel, int x, int y)
    {
        super("Jaki organizm chcesz tu dodać?");
        panel.setEnabled(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setSize(300,300);
        setResizable(false);
        setVisible(true);
        this.setLayout(new GridLayout(3,3));
        przyciski = new PrzyciskDodawanie[9];
        for(int i = 0; i < 9; i++)
        {
            przyciski[i] = new PrzyciskDodawanie(panel, this, i, panel.zwroc_swiat().nazwa(i), x, y);
            add(przyciski[i]);
        }       
    }
    private PrzyciskDodawanie przyciski[];
    public PoleGry pole;
}
