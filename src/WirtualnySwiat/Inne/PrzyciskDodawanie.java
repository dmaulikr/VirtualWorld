/*
 * Copyright (C) 2016 Kamil
 */
package WirtualnySwiat.Inne;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import WirtualnySwiat.Swiat;
import WirtualnySwiat.Polozenie;

/**
 *
 * @author Kamil
 */
public class PrzyciskDodawanie extends JButton implements ActionListener{
     private Swiat swiat;
     private int znak;
     private int x;
     private int y;
     
     public PrzyciskDodawanie(Gramy glowne, DodawaczOrganizmow panel, int znak, String nazwa, int x, int y)
     {
         super(nazwa);
         this.x = x;
         this.y = y;
         this.glowne = glowne;
         this.panel = panel;
         this.swiat = glowne.zwroc_swiat();
         this.znak = znak;
         this.addActionListener(this);
         setIcon(null);
     }
     
    public void actionPerformed(ActionEvent e)
    {
        swiat.dodajOrganizm(znak, new Polozenie(x,y));
        glowne.odswież();
        glowne.setEnabled(true);
        panel.dispose();
    }
    private Gramy glowne;
    private DodawaczOrganizmow panel;
}
