/*
 * Copyright (C) 2016 Kamil
 */
package WirtualnySwiat.Inne;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
/**
 *
 * @author Kamil
 */
public class Wyjdz extends JButton implements ActionListener{
    public Wyjdz(Gramy panel)
    {
        super("Wyjdź z Gry");
        this.addActionListener(this);
        this.panel = panel;
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        System.exit(0);
    }
    
    private Gramy panel;
}
