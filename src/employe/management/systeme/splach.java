package employe.management.systeme;

import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class splach extends JFrame  {
    splach(){
        //chargement image d'acceuil
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.gif"));
        Image i2 = i1.getImage().getScaledInstance(800,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);image.setBounds(0,0,800,600);
        add(image);

        setSize(820 , 620 );
        setLocation(100,100);
        setLayout(null);
        setVisible(true);

        try {
            Thread.sleep(5000);
            setVisible(false);
        new Login();
        }catch ( Exception e) {
            e.printStackTrace();
        }

    }


public static void main(String[] args) {
        new splach();
}

}
