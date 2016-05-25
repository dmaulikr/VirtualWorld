/*
 * Copyright (C) 2016 Kamil
 */
package WirtualnySwiat.Inne;

import java.awt.GridLayout;
import javax.swing.JLabel;
/**
 *
 * @author Kamil
 */
public class Manual extends javax.swing.JPanel{
    public Manual()
    {
        setSize(400,400);
        this.setLayout(new GridLayout(20, 1));
        setVisible(true);
        label[0] = new JLabel("Wirtualny Świat");
        label[1] = new JLabel("Sterowanie:");
        label[2] = new JLabel("Poruszanie się                    -     Strzałki");
        label[3] = new JLabel("Aktywacja umiejętności   -     s");
        label[4] = new JLabel("Zapis i wczytanie gry         -     Przyciski poniżej");
        for(int i = 0; i < 5; i++)
        {
            this.add(label[i]);
        }
    }
    
    private JLabel label[] = new JLabel[20];
    
}
