/*
 * Copyright (C) 2016 Kamil
 */
package WirtualnySwiat.Inne;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import WirtualnySwiat.Swiat;

/**
 *
 * @author Kamil
 */
public class Przycisk extends JButton implements ActionListener{
     private Swiat swiat;
     private int znak;
     
     public Przycisk(Swiat swiat, Gramy panel, int znak, String nazwa)
     {
         super(nazwa);
         this.panel = panel;
         this.swiat = swiat;
         this.znak = znak;
         this.addActionListener(this);
         setIcon(null);
     }
     
    public void actionPerformed(ActionEvent e)
    {
        if(znak == 8)
        {
            Pomoc pomoc = new Pomoc();
        }
        swiat.gramy(znak);
        panel.odswież();
        panel.requestFocus();
        return;
    }
     private Gramy panel;
}
