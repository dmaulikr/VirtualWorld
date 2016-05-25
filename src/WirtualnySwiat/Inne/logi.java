/*
 * Copyright (C) 2016 Kamil
 */
package WirtualnySwiat.Inne;

import WirtualnySwiat.Swiat;
import java.awt.GridLayout;
import javax.swing.JLabel;
/**
 *
 * @author Kamil
 */
public class logi extends javax.swing.JPanel{
    public logi(Swiat swiat)
    {
        this.swiat = swiat;
        logi = swiat.zwroc_logi();
        setSize(400,400);
        this.setLayout(new GridLayout(20, 1));
        setVisible(true);
        for(int i = 0; i < 20; i++)
        {
            label[i] = new JLabel(logi[i]);
            this.add(label[i]);
        }
    }
    
    public void odswiez()
    {
        for(int i = 0; i < 20; i++)
        {
            label[i].setText(logi[i]);
        }
    }
    
    private JLabel label[] = new JLabel[20];
    private Swiat swiat;
    private String logi[];
}
