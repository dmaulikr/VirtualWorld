/*
 * Copyright (C) 2016 Kamil
 */
package WirtualnySwiat.Inne;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 *
 * @author Kamil
 */
public class PoleGry extends JButton implements ActionListener
{
    
    private final ImageIcon wilk = new ImageIcon(this.getClass().getResource("grafika/wilk.jpg"));
    private final ImageIcon owca = new ImageIcon(this.getClass().getResource("grafika/owca.jpg"));
    private final ImageIcon lis = new ImageIcon(this.getClass().getResource("grafika/lis.jpg"));
    private final ImageIcon zolw = new ImageIcon(this.getClass().getResource("grafika/zolw.jpg"));
    private final ImageIcon antylopa = new ImageIcon(this.getClass().getResource("grafika/antylopa.jpg"));
    private final ImageIcon czlowiek = new ImageIcon(this.getClass().getResource("grafika/czlowiek.jpg"));
    private final ImageIcon guarana = new ImageIcon(this.getClass().getResource("grafika/guarana.jpg"));
    private final ImageIcon mlecz = new ImageIcon(this.getClass().getResource("grafika/mlecz.jpg"));
    private final ImageIcon trawa = new ImageIcon(this.getClass().getResource("grafika/trawa.jpg"));
    private final ImageIcon wilczejagody = new ImageIcon(this.getClass().getResource("grafika/wilczejagody.jpg"));
    private final Gramy panel;
    private final int x;
    private final int y;
  
     
    public PoleGry(Gramy panel, int x, int y)
    {
        this.x = x;
        this.y = y;
        this.panel = panel;
        this.addActionListener(this);
        setIcon(null);
    }
    
    public void ustawIkone(int znak)
    {
        switch(znak)
        {
            case 0:
                setIcon(antylopa);
                break;
            case 1:
                setIcon(guarana);
                break;
            case 2:
                setIcon(lis);
                break;
            case 3:
                setIcon(mlecz);
                break;
            case 4:
                setIcon(owca);
                break;
            case 5:
                setIcon(trawa);
                break;
            case 6:
                setIcon(wilczejagody);
                break;
            case 7:
                setIcon(wilk);
                break;
            case 8:
                setIcon(zolw);
                break;
            case 9:
                setIcon(czlowiek);
                break;
            default:
                setIcon(null);
                break;           
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        //Jak klikniemy na wolne pole to mozemy dodac dowolny organizm
        if(panel.zwroc_swiat().ktoryTamJest(x, y) == -1)
        {
            DodawaczOrganizmow dodaj = new DodawaczOrganizmow(panel, x, y);
        }
        panel.odswież();
        panel.requestFocus();
    }
    
}
