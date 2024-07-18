package employe.management.systeme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login extends JFrame implements ActionListener {

        JTextField tusername ;

        JPasswordField tpassword ;

        JButton login, back ;

    Login(){

        JLabel username = new JLabel("Username");
        username.setBounds(40,20,100,30);
        add(username);

        tusername = new JTextField();
        tusername.setBounds(150,20,150,30);
        add(tusername);

        JLabel password = new JLabel("Password");
        password.setBounds(40,70,100,30);
        add(password);

        tpassword = new JPasswordField();
        tpassword.setBounds(150,70,150,30);
        add(tpassword);

        login = new JButton("LOGIN");
        login.setBounds(150,140,150,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        back = new JButton("BACK");
        back.setBounds(150,180,150,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.gif"));
        Image i2 = i1.getImage().getScaledInstance(600,338,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,600,338);
        add(img);



        setSize(600,338);
        setLocation(450,200);
        setLayout(null);
        setVisible(true);


    }
    @Override
    public void actionPerformed(ActionEvent e){

    if (e.getSource() == login) {
        try{
            String username = tusername.getText();
            String password = new String(tpassword.getPassword());
            System.out.print(username);
            System.out.print(password);

            Conn connn = new Conn();

            String query = "select * from login where username ='"+ username +"' and pass = '"+password+"'";
            Statement stt = connn.getStatement();
            ResultSet res = stt.executeQuery(query);
            try {
                if (res.next()) {
                // Retrieve by column name
                int id  = res.getInt("id");
                String name = res.getString("username");
                String pass = res.getString("pass");



                setVisible(false);
                new Main_class();

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password");
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (HeadlessException ex) {
                throw new RuntimeException(ex);
            }
        }catch (Exception E){
            E.printStackTrace();
        }

      } else if (e.getSource() == back) {
          System.exit(90);
      }
    }


    public static void main(String[] args) {
        new Login();
    }
}
