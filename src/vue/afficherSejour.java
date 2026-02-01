package vue;

import javax.swing.*;
import java.awt.*;
import model.*;
import controleur.*;

public class afficherSejour extends JPanel {
    Hotel hotel;

    public afficherSejour(Hotel h) {
        hotel = h;
        setLayout(new BorderLayout()); // pour classer nord, centre, ext...
        setBackground(Color.LIGHT_GRAY);
        setOpaque(true);

        JLabel titre = new JLabel("Créer un séjour", JLabel.CENTER);
        titre.setFont(new Font("Arial", Font.BOLD, 30));
        add(titre, BorderLayout.NORTH);
        setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        titre.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0)); // bas: 30px d’espace

        GridLayout grille = new GridLayout(4, 2);
        JPanel champsPanel = new JPanel(grille);
        champsPanel.setBackground(Color.LIGHT_GRAY);
        
        // ID du séjour (centrer le label et la barre)
        JPanel pIdSej = new JPanel(new FlowLayout(FlowLayout.CENTER)); // FlowLayout pour centrer
        pIdSej.setBackground(Color.LIGHT_GRAY);
        JLabel lblIdSej = new JLabel("ID du séjour :");
        lblIdSej.setFont(new Font("Arial", Font.BOLD, 18));
        JTextField txtIdSej = new JTextField(10); // longueur horizontale de la zone blanche
        pIdSej.add(lblIdSej);
        pIdSej.add(txtIdSej);
        champsPanel.add(pIdSej);
        
        // numéro de réservation (centrer le label et la barre)
        JPanel pReservation = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pReservation.setBackground(Color.LIGHT_GRAY);
        JLabel lblReservation = new JLabel("Reservation :");
        lblReservation.setFont(new Font("Arial", Font.BOLD, 18));
        JComboBox<Reservation> reservationBox = new JComboBox<>();
        for (Chambre c : hotel.ListChambre) {
            for (Reservation r : c.ListReservation) {
                reservationBox.addItem(r);
            }
        }
        pReservation.add(lblReservation);
        pReservation.add(reservationBox);
        champsPanel.add(pReservation);
        
        // sejour payé ? (centrer le label et la barre)
        JPanel pPayee = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pPayee.setBackground(Color.LIGHT_GRAY);
        JCheckBox boxPayee = new JCheckBox("   Facture payée");
        boxPayee.setBackground(Color.LIGHT_GRAY);
        boxPayee.setFont(new Font("Arial", Font.BOLD, 18));
        pPayee.add(boxPayee);
        champsPanel.add(pPayee);
    
        add(champsPanel, BorderLayout.CENTER); // centrer le tout
        
        // bouton "valider"
        JPanel boutonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        boutonPanel.setBackground(Color.LIGHT_GRAY);
        JButton btnValider = new JButton("Valider");
        btnValider.setBackground(Color.GRAY);
        boutonPanel.add(btnValider);
        add(boutonPanel, BorderLayout.SOUTH);
        
        boutonAjouterSejour btnAjouterSej = new boutonAjouterSejour(txtIdSej, reservationBox, boxPayee, hotel);
        btnValider.addActionListener(btnAjouterSej);
    }
}