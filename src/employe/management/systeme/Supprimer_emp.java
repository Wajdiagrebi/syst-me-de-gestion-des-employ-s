package employe.management.systeme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class Supprimer_emp extends JFrame implements ActionListener {

   Choice choiceEMPID;

   JButton effacer,retour;

    Supprimer_emp(){

        JLabel label = new JLabel("ID");
        label.setBounds(50,50,100,30);
        label.setFont(new Font("Tahoma",Font.BOLD,15));
        add(label);

        choiceEMPID = new Choice();
        choiceEMPID.setBounds(200,50,150,30);
        add(choiceEMPID);

        try{
            Conn c =new Conn() ;
            ResultSet resultSet =c.statement.executeQuery("select * from employee");
            while (resultSet.next()){
                choiceEMPID.add(resultSet.getString("ID"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel labelNom = new JLabel("Nom");
        labelNom.setBounds(50,100,100,30);
        labelNom.setFont(new Font("Tahoma",Font.BOLD,15));
        add(labelNom);

        JLabel textNom = new JLabel();
        textNom.setBounds(200,100,100,30);
        add(textNom);

        JLabel labelTelephone = new JLabel("Téléphone");
        labelTelephone.setBounds(50,150,100,30);
        labelTelephone.setFont(new Font("Tahoma",Font.BOLD,15));
        add(labelTelephone);

        JLabel textTelephone = new JLabel();
        textTelephone.setBounds(200,150,100,30);
        add(textTelephone);

        JLabel labelEmail = new JLabel("Email");
        labelEmail.setBounds(50,200,100,30);
        labelEmail.setFont(new Font("Tahoma",Font.BOLD,15));
        add(labelEmail);

        JLabel textEmail = new JLabel();
        textEmail.setBounds(200,200,100,30);
        add(textEmail);

  try{
      Conn c =new Conn();
      ResultSet resultSet =c.statement.executeQuery("select * from employee where ID ='"+choiceEMPID.getSelectedItem()+"'");
      while (resultSet.next()){
          textNom.setText(resultSet.getString("nom"));
          textTelephone.setText(resultSet.getString("telephone"));
          textEmail.setText(resultSet.getString("email"));
      }
  }catch(Exception e){
      e.printStackTrace();
  }

    choiceEMPID.addItemListener(new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            try{
                Conn c =new Conn();
                ResultSet resultSet =c.statement.executeQuery("select * from employee where ID ='"+choiceEMPID.getSelectedItem()+"'");
                while (resultSet.next()) {
                    textNom.setText(resultSet.getString("nom"));
                    textTelephone.setText(resultSet.getString("telephone"));
                    textEmail.setText(resultSet.getString("email"));
                }
            }catch (Exception E){
                E.printStackTrace();
            }

        }
    });
  effacer= new JButton("Effacer");
  effacer.setBounds(80,300,100,30);
  effacer.setBackground(Color.black);
  effacer.setForeground(Color.WHITE);
  effacer.addActionListener(this);
  add(effacer);

  ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
  Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
  ImageIcon i3 = new ImageIcon(i2);
  JLabel img = new JLabel(i3);
  img.setBounds(700,80,200,200);
  add(img);

  ImageIcon i11 =new ImageIcon(ClassLoader.getSystemResource("icons/rback.png"));
  Image i22 = i11.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
  ImageIcon i33 = new ImageIcon(i22);
  JLabel image = new JLabel(i33);
  image.setBounds(0,0,1120,630);
  add(image);

  retour= new JButton("Retour");
  retour.setBounds(220,300,100,30);
  retour.setBackground(Color.black);
  retour.setForeground(Color.WHITE);
  retour.addActionListener(this);
  add(retour);




        setSize(1000,400);
        setLocation(300,150);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==effacer){
            try{
                Conn c = new Conn();
                String query ="delete from employee where ID ='"+choiceEMPID.getSelectedItem()+"'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employé effacer avec succée");
                setVisible(false);
                new Main_class();

            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new Supprimer_emp();
    }
}