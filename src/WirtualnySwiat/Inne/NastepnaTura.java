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
public class NastepnaTura extends JButton implements ActionListener{
    public NastepnaTura(Gramy panel)
    {
        super("Następna Tura");
        this.addActionListener(this);
        this.panel = panel;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        panel.zwroc_swiat().gramy(-1);
        panel.odswież();
        panel.requestFocus();
    }
    
    private Gramy panel;
}
