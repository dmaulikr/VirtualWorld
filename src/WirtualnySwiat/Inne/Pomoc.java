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
public class Pomoc extends JFrame{
    public Pomoc()
    {
        super("Pomoc");
        setSize(1000, 700);
        JPanel opis = new JPanel();
        JScrollPane panel = new JScrollPane(opis);
        panel.getVerticalScrollBar().setUnitIncrement(10);
        opis.setLayout(new GridLayout(12, 1));
        setResizable(false);
        label[0] = new JLabel("<html>Zasady gry:<br>Wirtualny Świat to gra turowa, w której wcielamy się w człowieka w świecie pełnym organizmów."
                + " Poruszanie odbywa się za pomocą strzałek lub przycisku <br>następna tura (wtedy człowiek się nie porusza)."
                + " Organizmy mogą być zwierzętami lub roślnami. Każdy organizm ma statystyki: siłę oraz inicjatywę. <br>Zwierzęta poruszają się losowo, a rośliny nie poruszają się w ogóle. Rośliny mają w każdej turze pewną procentową szansę na rozprzestrzenie"
                + " się na sąsiadujące <br>puste pole. Jeżeli dwa zwierzęta tego samego gatunku wejdą na to samo pole to rozmnażają się i"
                + " na sąsiadującym wolnym polu pojawia się zwierzę tego samego gatunku.<br>Oczywiście rozmnażanie, rozprzestrzenianie nie"
                + " zachodzi, gdy wszystkie sąsiednie pola są zajęte. Jeżeli jeden organizm wejdzie na zajęte pole, to dochodzi do walki."
                + "<br>Walkę wygrywa organizm o większej sile. W przypadku równych sił wygrywa atakujący. Organizm, który przegrał ginie. W każdej turze organizmy"
                + " wykonują akcję w<br>ściśle zdefiniowanej kolejności. Poruszają się w kolejności począwszy od tych z największą inicjatywą do tych z najmniejszą."
                + " W przypadku takiej samej inicjatywy,<br>najpierw porusza się starszy organizm.</html>");
        label[2] = new JLabel("<html>Antylopa:<br>"
                + "<img src=\""
                + Pomoc.class.getResource("grafika/antylopa.jpg")
                + "\"><br>"
                + "Siła : 4<br>"
                + "Inicjatywa : 4<br>"
                + "Zasięg ruchu antylopy wynosi 2 pola. Posiada również 50% szansę na ucieczkę z walki.</html>");
        label[1] = new JLabel("<html>Człowiek:<br>"
                + "<img src=\""
                + Pomoc.class.getResource("grafika/czlowiek.jpg")
                + "\"><br>"
                + "Siła : 5<br>"
                + "Inicjatywa : 4<br>"
                + "Posiada umiejętność specjalną  aktywowaną przyciskiem \"s\". Jest to nieśmiertelność na okres 5 tur.</html>");
        label[3] = new JLabel("<html>Żółw:<br>"
                + "<img src=\""
                + Pomoc.class.getResource("grafika/zolw.jpg")
                + "\"><br>"
                + "Siła : 2<br>"
                + "Inicjatywa : 1<br>"
                + "Ma tylko 25% szans na wykonanie ruchu. Odpiera ataki organizmów o sile mniejszej niż 5.</html>");
        label[4] = new JLabel("<html>Lis:<br>"
                + "<img src=\""
                + Pomoc.class.getResource("grafika/lis.jpg")
                + "\"><br>"
                + "Siła : 3<br>"
                + "Inicjatywa : 7<br>"
                + "Lis jest inteligentny i nigdy sam nie zaatakuje organizmu silniejszego od siebie.</html>");
        label[5] = new JLabel("<html>Owca:<br>"
                + "<img src=\""
                + Pomoc.class.getResource("grafika/owca.jpg")
                + "\"><br>"
                + "Siła : 4<br>"
                + "Inicjatywa : 4<br></html>");
        label[6] = new JLabel("<html>Wilk:<br>"
                + "<img src=\""
                + Pomoc.class.getResource("grafika/wilk.jpg")
                + "\"><br>"
                + "Siła : 9<br>"
                + "Inicjatywa : 5</html>");
        label[7] = new JLabel("<html>Trawa: <br>"
                + "<img src=\""
                + Pomoc.class.getResource("grafika/trawa.jpg")
                + "\"><br>"
                + "Siła : 0 <br>"
                + "Inicjatywa : 0</html>");
        label[8] = new JLabel("<html>Mlecz: <br>"
                + "<img src=\""
                + Pomoc.class.getResource("grafika/mlecz.jpg")
                + "\"><br>"
                + "Siła : 0 <br>"
                + "Inicjatywa : 0<br>"
                + "W każdej turze wykonuje trzy próby rozprzestrzenienia się.</html>");
        label[9] = new JLabel("<html>Guarana: <br>"
                + "<img src=\""
                + Pomoc.class.getResource("grafika/guarana.jpg")
                + "\"><br>"
                + "Siła : 0 <br>"
                + "Inicjatywa : 0<br>"
                + "Organizm, który zje guarane dostaje bonus +3 do siły.</html>");
        label[10] = new JLabel("<html>Wilcze Jagody: <br>"
                + "<img src=\""
                + Pomoc.class.getResource("grafika/wilczejagody.jpg")
                + "\"><br>"
                + "Siła : 0 <br>"
                + "Inicjatywa : 0<br>"
                + "Organizm, który je zje zostaje otruty i umiera.</html>");
        label[11] = new JLabel("<html>Dodatkowe informacje: <br>"
                + "Klikająca na wolne pole możemy dodać wybrany organizm w dowolnym momencie gry!<br>"
                + "W domyśle gra nigdy się nie kończy, albowiem nawet w przypadku zawładnięcia światem"
                + " przez jeden gatunek, dalej wykonywana jest akcja.</html>");
        for(int i = 0; i < 12; i++)
        {
            opis.add(label[i]);
        }
        this.add(panel);
        setVisible(true);
    }
    
    private JLabel label[] = new JLabel[12];
}
