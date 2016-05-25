/*
 * Copyright (C) 2016 Kamil
 */
package WirtualnySwiat.Inne;
import WirtualnySwiat.Swiat;
import WirtualnySwiat.Organizm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
/**
 *
 * @author Kamil
 */
public class Gramy extends javax.swing.JFrame implements KeyListener{
    
    public JPanel panel = new JPanel();
    public JPanel panel2 = new JPanel();
    public JPanel panel2sub1 = new JPanel();
    public JPanel panel2sub2 = new JPanel();
    
    @Override
    public void keyReleased(KeyEvent e)
    {
       this.requestFocusInWindow();
    }
    
    @Override
    public void keyPressed(KeyEvent e)
    {
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_UP:
                swiat.gramy(0);
                break;
            case KeyEvent.VK_LEFT:
                swiat.gramy(1);
                break;
            case KeyEvent.VK_DOWN:
                swiat.gramy(2);
                break;
            case KeyEvent.VK_RIGHT:
                swiat.gramy(3);
                break;
            case KeyEvent.VK_S:
                swiat.gramy(4);
                break;
            case KeyEvent.VK_Z:
                swiat.gramy(5);
                break;
            case KeyEvent.VK_W:
                swiat.gramy(6);
                break;       
        }
        this.odswież();
        logiGry.odswiez();
    }
    
    @Override
    public void keyTyped(KeyEvent e)
    {
        
    }
    
    public Gramy(int szerokość, int wysokość, int ilośćOrganizmów){
        super("Kamil Łepek 150495");
        this.addKeyListener(this);
        this.requestFocusInWindow();
        setSize(1366,768);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(1,2));
        panel.setLayout(new GridLayout(szerokość, wysokość));
        panel2.setLayout(new GridLayout(2,1));
        panel2sub1.setLayout(new GridLayout(1,2));
        panel2sub2.setLayout(new GridLayout(2,3));
        setVisible(true);
        pola = new PoleGry[szerokość][wysokość];
        swiat = new Swiat(szerokość, wysokość, ilośćOrganizmów);
        for(int i = 0; i < szerokość; i++)
        {
            for(int j = 0; j < wysokość; j++)
            {
                pola[i][j] = new PoleGry(this, i, j);
                panel.add(pola[i][j]);
            }
        }
        wczytaj = new Przycisk(swiat, this, 6, "Wczytaj Grę");
        zapisz = new Przycisk(swiat, this, 5, "Zapisz Grę");
        logiGry = new logi(swiat);
        manual = new Manual();
        panel2sub1.add(logiGry);
        panel2sub1.add(manual);
        logiGry.odswiez();
        panel2sub2.add(new Przycisk(swiat, this, 7, "Nowa Gra"));
        panel2sub2.add(new Przycisk(swiat, this, 8, "Pomoc"));
        panel2sub2.add(new NastepnaTura(this));
        panel2sub2.add(zapisz);
        panel2sub2.add(wczytaj);
        panel2sub2.add(new Wyjdz(this));
        panel2.add(panel2sub1);
        panel2.add(panel2sub2);
        add(panel);
        add(panel2);
        this.odswież();
    } 
    
    public static void main(String args[]) {
       Gramy gramy = new Gramy(14,13,20);
       Swiat swiat = gramy.zwroc_swiat();
       gramy.odswież();
       gramy.requestFocus();
    }
    
    public Swiat zwroc_swiat(){return swiat;}
    
    //odświeżamy pola reprezentujące organizmy po każdej turze
    public void odswież()
    {
        Organizm[] organizm = swiat.znajdz_organizmy();
        for(int i = 0; i < pola.length; i++)
        {
            for(int j = 0; j < pola[0].length; j++)
            {
                int temp = swiat.ktoryTamJest(i, j);
                if(temp >=0)
                {
                    pola[i][j].ustawIkone(organizm[temp].znajdz_znak());
                }
                else if (temp == -1)
                {
                    pola[i][j].setIcon(null);
                }
            }
        }
    }
    
    private final PoleGry pola[][];//przyciski reprezentujące organizmy
    private final Swiat swiat;
    private static logi logiGry;
    private static Manual manual;
    private final Przycisk wczytaj;
    private final Przycisk zapisz;
    
}
