package employe.management.systeme;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Ajoute_employé extends JFrame implements ActionListener {

    Random ran = new Random();
    int number = ran.nextInt(999999);

    JLabel tid;
    JTextField tnom, tprénom, tadresse, ttéléphone, tCIN, temail, tposte, tsalaire;
    JDateChooser tdn;
    JButton add, back;
    JComboBox<String> Boxeducation, Boxcontrat;

    Ajoute_employé() {

        JLabel heading = new JLabel("Ajouter les coordonnées d'un employé");
        heading.setBounds(195, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);

        JLabel nom = new JLabel("Nom");
        nom.setBounds(100, 150, 150, 30);
        nom.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(nom);

        tnom = new JTextField();
        tnom.setBounds(250, 150, 150, 30);
        tnom.setBackground(new Color(177, 252, 197));
        add(tnom);

        JLabel prénom = new JLabel("Prénom");
        prénom.setBounds(500, 150, 150, 30);
        prénom.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(prénom);

        tprénom = new JTextField();
        tprénom.setBounds(650, 150, 150, 30);
        tprénom.setBackground(new Color(177, 252, 197));
        add(tprénom);

        JLabel dn = new JLabel("Date De Naissance");
        dn.setBounds(50, 200, 150, 30);
        dn.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(dn);

        tdn = new JDateChooser();
        tdn.setBounds(250, 200, 150, 30);
        tdn.setBackground(new Color(177, 252, 197));
        add(tdn);

        JLabel poste = new JLabel("Poste");
        poste.setBounds(100, 250, 150, 30);
        poste.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(poste);

        tposte = new JTextField();
        tposte.setBounds(250, 250, 150, 30);
        tposte.setBackground(new Color(177, 252, 197));
        add(tposte);

        JLabel salaire = new JLabel("Salaire");
        salaire.setBounds(500, 250, 150, 30);
        salaire.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(salaire);

        tsalaire = new JTextField();
        tsalaire.setBounds(650, 250, 150, 30);
        tsalaire.setBackground(new Color(177, 252, 197));
        add(tsalaire);

        JLabel telephone = new JLabel("Téléphone");
        telephone.setBounds(500, 200, 150, 30);
        telephone.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(telephone);

        ttéléphone = new JTextField();
        ttéléphone.setBounds(650, 200, 150, 30);
        ttéléphone.setBackground(new Color(177, 252, 197));
        add(ttéléphone);

        JLabel cin = new JLabel("CIN");
        cin.setBounds(100, 300, 150, 30);
        cin.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(cin);

        tCIN = new JTextField();
        tCIN.setBounds(250, 300, 150, 30);
        tCIN.setBackground(new Color(177, 252, 197));
        add(tCIN);

        JLabel email = new JLabel("Email");
        email.setBounds(500, 300, 150, 30);
        email.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(email);

        temail = new JTextField();
        temail.setBounds(650, 300, 150, 30);
        temail.setBackground(new Color(177, 252, 197));
        add(temail);

        JLabel adresse = new JLabel("Adresse");
        adresse.setBounds(100, 350, 150, 30);
        adresse.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(adresse);

        tadresse = new JTextField();
        tadresse.setBounds(250, 350, 150, 30);
        tadresse.setBackground(new Color(177, 252, 197));
        add(tadresse);

        JLabel contrat = new JLabel("Contrat");
        contrat.setBounds(500, 350, 150, 30);
        contrat.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(contrat);

        String items[] = {"SIVP", "CDI", "CDD", "STAGIAIRE"};
        Boxcontrat = new JComboBox<>(items);
        Boxcontrat.setBackground(new Color(177, 252, 197));
        Boxcontrat.setBounds(650, 350, 150, 30);
        add(Boxcontrat);

        JLabel education = new JLabel("Education");
        education.setBounds(500, 400, 150, 30);
        education.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(education);

        String item[] = {"BACCALAURÉAT", "LICENCE", "MASTER", "INGÉNIEURIE", "NON DIPLOMÉ", "LYCÉE", "COLLÉGE", "PRIMAIRE", "FORMATION", "BTS"};
        Boxeducation = new JComboBox<>(item);
        Boxeducation.setBackground(new Color(177, 252, 197));
        Boxeducation.setBounds(650, 400, 150, 30);
        add(Boxeducation);

        JLabel id = new JLabel("ID EMPLOYÉ");
        id.setBounds(100, 400, 150, 30);
        id.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(id);

        tid = new JLabel("" + number);
        tid.setBounds(285, 400, 150, 30);
        tid.setFont(new Font("SAN_SERIF", Font.BOLD, 22));
        tid.setForeground(Color.RED);
        add(tid);

        add = new JButton("AJOUTÉ");
        add.setBounds(250, 550, 150, 40);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("RETOUR");
        back.setBounds(450, 550, 150, 40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        setSize(900, 700);
        setLayout(null);
        setLocation(300, 50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            String nom = tnom.getText();
            String prénom = tprénom.getText();
            String dn = ((JTextField) tdn.getDateEditor().getUiComponent()).getText();
            String salaire = tsalaire.getText();
            String adresse = tadresse.getText();
            String cin = tCIN.getText();
            String telephone = ttéléphone.getText();
            String email = temail.getText();
            String education = (String) Boxeducation.getSelectedItem();
            String poste = tposte.getText();
            String ID = tid.getText();
            String contrat = (String) Boxcontrat.getSelectedItem();

            try {
                Conn c = new Conn();
                String query = "INSERT INTO employee VALUES('" + nom + "', '" + prénom + "', '" + dn + "', '" + salaire + "','" + adresse + "', '" + telephone + "', '" + email + "', '" + education + "', '" + poste + "','" + cin + "', '" + ID + "','" + contrat + "')";
                c.getStatement().executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Ajouté avec succès");
                setVisible(false);
                new Main_class();

            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
            new Main_class();
        }
    }

    public static void main(String[] args) {
        new Ajoute_employé();
    }
}