package employe.management.systeme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Mise_à_jour extends JFrame implements ActionListener {
    JLabel tid;
    JTextField tprénom, tadresse, ttéléphone, temail, tposte, tsalaire, teducation, tcontrat, tCIN;
    JButton add, back;
    String number;

    Mise_à_jour(String number) {
        this.number = number;

        getContentPane().setBackground(new Color(163, 255, 188));

        JLabel heading = new JLabel("Ajouter Les Coordonnées D'un Employé");
        heading.setBounds(235, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        add(heading);

        JLabel nom = new JLabel("Nom");
        nom.setBounds(100, 150, 150, 30);
        nom.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(nom);

        JLabel tnom = new JLabel();
        tnom.setBounds(270, 150, 150, 20);
        tnom.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
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

        JLabel tdn = new JLabel();
        tdn.setBounds(250, 200, 150, 30);
        tdn.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(tdn);

        JLabel salaire = new JLabel("Salaire");
        salaire.setBounds(500, 250, 150, 30);
        salaire.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(salaire);

        tsalaire = new JTextField();
        tsalaire.setBounds(650, 250, 150, 30);
        tsalaire.setBackground(new Color(177, 252, 197));
        add(tsalaire);

        JLabel poste = new JLabel("Poste");
        poste.setBounds(100, 250, 150, 30);
        poste.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(poste);

        tposte = new JTextField();
        tposte.setBounds(250, 250, 150, 30);
        tposte.setBackground(new Color(177, 252, 197));
        add(tposte);

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
        tCIN.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
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

        tcontrat = new JTextField();
        tcontrat.setBounds(650, 350, 150, 30);
        tcontrat.setBackground(new Color(177, 252, 197));
        add(tcontrat);

        JLabel education = new JLabel("Education");
        education.setBounds(500, 400, 150, 30);
        education.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(education);

        teducation = new JTextField();
        teducation.setBounds(650, 400, 150, 30);
        teducation.setBackground(new Color(177, 252, 197));
        add(teducation);

        JLabel id = new JLabel("ID EMPLOYÉ");
        id.setBounds(100, 400, 150, 30);
        id.setFont(new Font("SAN_SERIF", Font.BOLD, 20));
        add(id);

        tid = new JLabel();
        tid.setBounds(285, 400, 150, 30);
        tid.setFont(new Font("SAN_SERIF", Font.BOLD, 22));
        tid.setForeground(Color.RED);
        add(tid);

        try {
            Conn c = new Conn();
            String query = "select * from employee where ID = '" + number + "'";
            ResultSet resultSet = c.statement.executeQuery(query);
            while (resultSet.next()) {
                tnom.setText(resultSet.getString("nom"));
                tprénom.setText(resultSet.getString("prénom"));
                tdn.setText(resultSet.getString("dn"));
                tadresse.setText(resultSet.getString("adresse"));
                tsalaire.setText(resultSet.getString("salaire"));
                ttéléphone.setText(resultSet.getString("telephone"));
                temail.setText(resultSet.getString("email"));
                teducation.setText(resultSet.getString("education"));
                tCIN.setText(resultSet.getString("CIN"));
                tid.setText(resultSet.getString("ID"));
                tposte.setText(resultSet.getString("poste"));
                tcontrat.setText(resultSet.getString("contrat"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        add = new JButton("METTRE_À_JOUR");
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
            String prénom = tprénom.getText();
            String salaire = tsalaire.getText();
            String adresse = tadresse.getText();
            String telephone = ttéléphone.getText();
            String email = temail.getText();
            String education = teducation.getText();
            String poste = tposte.getText();
            String contrat = tcontrat.getText();

            try {
                if (!number.isEmpty()) {
                    Conn c = new Conn();
                    String query = "update employee set prénom = '" + prénom + "', salaire = '" + salaire + "', adresse = '" + adresse + "', telephone = '" + telephone + "', email = '" + email + "', education = '" + education + "', poste = '" + poste + "', contrat = '" + contrat + "' where ID = '" + number + "'";
                    c.statement.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Mise à jour effectuée avec succès");
                    setVisible(false);
                    new Main_class();
                } else {
                    JOptionPane.showMessageDialog(null, "ID Employé non trouvé.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            setVisible(false);
            new Main_class();
        }
    }

    public static void main(String[] args) {
        new Mise_à_jour("");
    }
}
