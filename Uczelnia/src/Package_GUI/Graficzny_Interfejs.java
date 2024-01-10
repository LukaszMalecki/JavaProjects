package Package_GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import Package_Uczelnia.*;

import javax.swing.*;



public class Graficzny_Interfejs
{
    private JFrame frame;

    private int bruhNumber = 0;

    private JButton button1;

    private Uczelnia uwu;

    public Graficzny_Interfejs( Uczelnia uwu)
    {
        this.uwu = uwu;
    }

    class ButtonReact1 implements ActionListener
    {
        public void actionPerformed( ActionEvent e)
        {
            System.out.println("kotlet\n");
        }
    }

    class ButtonReact2 implements ActionListener
    {
        public void actionPerformed( ActionEvent e)
        {
            System.out.println("ser\n");
        }
    }

    class ButtonReact3 implements ActionListener
    {
        public void actionPerformed( ActionEvent e)
        {
            bruhNumber++;
        }
    }
    class ButtonReact4 implements ActionListener
    {
        public void actionPerformed( ActionEvent e)
        {
            System.out.println("Times clicked: " + bruhNumber + "\n");
        }
    }

    public void start()
    {
        frame = new JFrame();

        JButton b1 = new JButton("wypisze kotlet");
        JButton b2 = new JButton("wypisze ser");
        JButton b3 = new JButton("click");
        JButton b4 = new JButton("times clicked");
        JButton b5 = new JButton("aaaaadsaa");

        b1.addActionListener(new ButtonReact1());
        b2.addActionListener(new ButtonReact2());
        b3.addActionListener(new ButtonReact3());
        b4.addActionListener(new ButtonReact4());

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(BorderLayout.NORTH, p1);
        frame.getContentPane().add(BorderLayout.WEST, p2);
        frame.getContentPane().add(BorderLayout.CENTER, p3);
        frame.getContentPane().add(BorderLayout.EAST, p4);
        frame.getContentPane().add(BorderLayout.SOUTH, p5);

        //frame.getContentPane().add(BorderLayout.CENTER, p2);

        JTextField tF = new JTextField(20);

        p3.setLayout( new BoxLayout(p3, BoxLayout.Y_AXIS));

        p3.add( new JLabel("Bruh moment"));

        p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));

        p2.add( b3);
        p2.add( b2);

        p3.add(tF);
        tF.setText("Czemu to tu jest?");

        p1.add(b1);
        p4.add(b4);
        p5.add(b5);


        Dimension dim = new Dimension(500, 200);


        frame.setTitle("Uczelnia");
        frame.setPreferredSize(dim);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

}
