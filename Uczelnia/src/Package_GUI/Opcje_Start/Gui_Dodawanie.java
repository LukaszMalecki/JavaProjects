package Package_GUI.Opcje_Start;

import java.awt.*;
import java.awt.event.*;

import Package_Uczelnia.*;

import javax.swing.*;


public class Gui_Dodawanie implements ActionListener
{
    private Uczelnia uwu;
    private final static int liczba = 4;
    private final static int liczbaP = 5;

    private JFrame frame = new JFrame();
    private JButton[] buttons = new JButton[liczba];
    private JPanel[] panels = new JPanel[liczbaP];

    private JButton buttonExit = new JButton("Wyjscie"); //Wyjscie
    private JPanel panelExit = new JPanel();

    public Gui_Dodawanie( Uczelnia uwu)
    {
        this.uwu = uwu;

        wygladGui();

    }

    public void wygladGui()
    {
        final int x = 800;
        final int y = 600;

        final int b = 150; //border

        createButtons();
        createPanels();

        panels[0].setBackground(Color.GRAY);
        panels[1].setBackground(Color.LIGHT_GRAY);
        panels[2].setBackground(Color.CYAN);
        panels[3].setBackground(Color.LIGHT_GRAY);
        panels[4].setBackground(Color.ORANGE);

        frame.setLayout( new BorderLayout());

        panels[0].setPreferredSize(new Dimension(x-2*b, 50));
        panels[1].setPreferredSize(new Dimension(b, y));
        panels[2].setPreferredSize(new Dimension(x-2*b, 450));
        panels[3].setPreferredSize(new Dimension(b, y));
        panels[4].setPreferredSize(new Dimension(x-2*b, 100));

        frame.add(panels[0],BorderLayout.NORTH);
        frame.add(panels[1],BorderLayout.WEST);
        frame.add(panels[2],BorderLayout.CENTER);
        frame.add(panels[3],BorderLayout.EAST);
        frame.add(panels[4],BorderLayout.SOUTH);

        panels[2].setLayout( new GridLayout(liczba,1));
        for( int i = 0; i < liczba; i++)
        {
            panels[2].add(buttons[i]);
            buttons[i].addActionListener(this);
        }

        buttonExit.setPreferredSize(new Dimension(150,40));
        panels[4].setLayout( new FlowLayout());
        //panels[4].setLayout(new BorderLayout());
        panels[4].add(buttonExit);
        buttonExit.addActionListener(this);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(x,y));
        frame.setVisible(true);
        frame.setResizable(true);
    }

    public void actionPerformed( ActionEvent eve)
    {
        if( eve.getSource() == buttons[0])
        {
            frame.dispose();
            Gui_Dodawanie dod = new Gui_Dodawanie(uwu);

        }else if( eve.getSource() == buttons[1])
        {
            System.out.println("1");
        }else if( eve.getSource() == buttons[2])
        {

            System.out.println("2");
        }else if( eve.getSource() == buttons[3])
        {

            System.out.println("3");
        }else if( eve.getSource() == buttonExit)
        {
            frame.dispose();
        }


    }

    private void createButtons()
    {
        buttons[0] = new JButton("Dodaj Studenta");
        buttons[1] = new JButton("Dodaj Pracownika");
        buttons[2] = new JButton("Dodaj Kurs");
        buttons[3] = new JButton("Dodaj Kursy dla Studenta");
       // buttons[4] = new JButton("Usuwanie");
       // buttons[5] = new JButton("Sortowanie");
    }
    private void createPanels()
    {
        for( int i = 0; i < liczbaP; i++)
            panels[i] = new JPanel();
    }
}
