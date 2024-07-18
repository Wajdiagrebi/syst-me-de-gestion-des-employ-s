package employe.management.systeme;


import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class voir_employé extends JFrame implements ActionListener {

     Choice choiceEMP;
     JTable table;
     JButton cherche, print, update, back;

    voir_employé(){

        getContentPane().setBackground(new Color(255,131,122));
        JLabel search = new JLabel("Recherche par ID ");
        search.setBounds(20,20,140,20);
        add(search);

        choiceEMP = new Choice();
        choiceEMP.setBounds(180,20,150,20);
        add(choiceEMP);

           try{
               Conn c = new Conn();
               ResultSet resultSet = c.statement.executeQuery("select * from employee");
               while (resultSet.next()){
                   choiceEMP.add(resultSet.getString("ID"));
               }


           }catch (Exception e){
               e.printStackTrace();
           }

           table = new JTable();
        try{
            Conn c= new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }
        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(0,100,1200,900);
        add(jp);

        cherche= new JButton("Recherche");
        cherche.setBounds(20,70,120,20);
        cherche.addActionListener(this);
        add (cherche);

        print = new JButton("Imprimer");
        print.setBounds(190,70,120,20);
        print.addActionListener(this);
        add (print);

        update = new JButton("Mise à jour");
        update.setBounds(360,70,120,20);
        update.addActionListener(this);
        add (update);

        back = new JButton("Retour");
        back.setBounds(540,70,120,20);
        back.addActionListener(this);
        add (back);



           setSize(1200,900);
           setLayout(null);
           setLocation(300,100);
           setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cherche) {
            String query = "select * from employee where ID = '" + choiceEMP.getSelectedItem() + "'";
            try {
                Conn c = new Conn();
                ResultSet resultSet = c.statement.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));


            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == print) {
            try {
                table.print();
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == update) {
            setVisible(false);
            new Mise_à_jour(choiceEMP.getSelectedItem());

        }else {
            setVisible(false);
            new Main_class();
        }

    }

    public static void main(String[] args) {

        new voir_employé();
    }
}
