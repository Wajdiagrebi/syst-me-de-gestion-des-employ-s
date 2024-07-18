package employe.management.systeme;

import com.mysql.cj.xdevapi.RemoveStatement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_class extends JFrame {

    Main_class(){
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
    Image i2 = i1.getImage().getScaledInstance(1120,630, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel img = new JLabel(i3);
    img.setBounds(0,0,1120,630);
    add(img);

    JLabel heading = new JLabel("Système de gestion des employés");
    heading.setBounds(340,155,400,40);
    heading.setFont((new Font("Raleway",Font.BOLD,23)));
    img.add(heading);

    JButton add = new JButton("Ajouter un employé");
    add.setBounds(320,270,180,40);
    add.setForeground(Color.WHITE);
    add.setBackground(Color.BLACK);
    add.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Ajoute_employé();
            setVisible(false);

        }
    });
    img.add(add);

    JButton rem= new JButton("Supprimer un employé");
    rem.setBounds(425,370,180,40);
    rem.setForeground(Color.WHITE);
    rem.setBackground(Color.BLACK);
    rem.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new Supprimer_emp();


        }
    });
    img.add(rem);

    JButton voir = new JButton("Voir la liste des employés");
    voir.setBounds(550,270,180,40);
    voir.setForeground(Color.WHITE);
    voir.setBackground(Color.BLACK);
    voir.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new voir_employé();
            setVisible(false);

        }
    });
    img.add(voir);


        setSize(1120,630);
        setLocation(250,100);
        setLayout(null);
        setVisible(true);

    }

    public static void main(String[] args) {

        new Main_class();
    }
}
