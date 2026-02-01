package vue;

import java.awt.*;
import javax.swing.*;
import model.*;
import controleur.*;

public class afficherReservation extends JPanel{
	Hotel hotel;
	
	public afficherReservation(Hotel h) {
		hotel = h;
        setLayout(new BorderLayout()); // pour classer nord, centre, ext...
        setBackground(Color.LIGHT_GRAY);
        
        JLabel titre = new JLabel("Enregistrer une réservation", JLabel.CENTER);
        titre.setFont(new Font("Arial", Font.BOLD, 30));
        add(titre, BorderLayout.NORTH);
        setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        titre.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0)); // bas: 30px d’espace

        GridLayout grille = new GridLayout(6,2);
        JPanel champsPanel = new JPanel(grille); // Ajuster l'espacement des cellules
        champsPanel.setBackground(Color.LIGHT_GRAY);
        
        // ID de reservation (centrer le label et la barre)
        JPanel pIdRes = new JPanel(new FlowLayout(FlowLayout.CENTER)); // FlowLayout pour centrer
        pIdRes.setBackground(Color.LIGHT_GRAY);
        JLabel lblIdRes = new JLabel("Numéro de réservation :");
        lblIdRes.setFont(new Font("Arial", Font.BOLD, 18));
        JTextField txtIdRes = new JTextField(10); // longueur horizontale de la zone blanche
        pIdRes.add(lblIdRes);
        pIdRes.add(txtIdRes);
        champsPanel.add(pIdRes);
        
        // Nom et prénom du client (centrer le label et la barre)
        JPanel pClient = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pClient.setBackground(Color.LIGHT_GRAY);
        JLabel lblCl = new JLabel("Client :");
        lblCl.setFont(new Font("Arial", Font.BOLD, 18));
        JComboBox<Client> clientBox = new JComboBox<>();
        for (Client ci : hotel.ListClient) {
            clientBox.addItem(ci);
        }
        pClient.add(lblCl);
        pClient.add(clientBox);
        champsPanel.add(pClient);
        
        // Numéro de chambre (centrer le label et la barre)
        JPanel pChambre = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pChambre.setBackground(Color.LIGHT_GRAY);
        JLabel lblChambre = new JLabel("Chambre :");
        lblChambre.setFont(new Font("Arial", Font.BOLD, 18));
        JComboBox<Chambre> chambreBox = new JComboBox<>();
        for (Chambre ca : hotel.ListChambre) {
            chambreBox.addItem(ca); // Affiche avec toString()
        }
        pChambre.add(lblChambre);
        pChambre.add(chambreBox);
        champsPanel.add(pChambre);
               
        // Liste déroulante pour le jour
        String[] jours = new String[31];       
        for (int i = 1; i <= 31; i++) {
            jours[i - 1] = Integer.toString(i);
        }

        // Liste déroulante pour le mois
        String[] mois = new String[12];
        for (int i = 1; i <= 12; i++) {
        	mois[i - 1] = Integer.toString(i);
        }

        // Liste déroulante pour l'année
        String[] annees = new String[2];
        annees[0] = Integer.toString(2025);
        annees[1] = Integer.toString(2026);
        
        // date de début
        JPanel pDateDeb = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pDateDeb.setBackground(Color.LIGHT_GRAY);
        JLabel lblDateDeb = new JLabel("Date de debut de réservation : ");
        lblDateDeb.setFont(new Font("Arial", Font.BOLD, 18));
        
        JComboBox<String> jourDebBox = new JComboBox<>(jours);
        JComboBox<String> moisDebBox = new JComboBox<>(mois);
        JComboBox<String> anneeDebBox = new JComboBox<>(annees);

        pDateDeb.add(lblDateDeb);
        pDateDeb.add(jourDebBox);
        pDateDeb.add(moisDebBox);
        pDateDeb.add(anneeDebBox);
        champsPanel.add(pDateDeb);
        
        // date de fin
        JPanel pDateFin = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pDateFin.setBackground(Color.LIGHT_GRAY);
        JLabel lblDateFin = new JLabel("Date de fin de réservation : ");
        lblDateFin.setFont(new Font("Arial", Font.BOLD, 18));
        
        JComboBox<String> jourFinBox = new JComboBox<>(jours);
        JComboBox<String> moisFinBox = new JComboBox<>(mois);
        JComboBox<String> anneeFinBox = new JComboBox<>(annees);

        pDateFin.add(lblDateFin);
        pDateFin.add(jourFinBox);
        pDateFin.add(moisFinBox);
        pDateFin.add(anneeFinBox);
        champsPanel.add(pDateFin);
        
        // statut de la réservation (centrer le label et la barre)
        JPanel pStatutRes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pStatutRes.setBackground(Color.LIGHT_GRAY);
        JLabel lblStatutRes = new JLabel("Statut :");
        lblStatutRes.setFont(new Font("Arial", Font.BOLD, 18));
        JRadioButton attente = new JRadioButton("en attente");
        attente.setFont(new Font("Arial", Font.BOLD, 18));
        attente.setBackground(Color.LIGHT_GRAY);
        JRadioButton validee = new JRadioButton("validée");
        validee.setFont(new Font("Arial", Font.BOLD, 18));
        validee.setBackground(Color.LIGHT_GRAY);
        JRadioButton terminee = new JRadioButton("terminée");
        terminee.setFont(new Font("Arial", Font.BOLD, 18));
        terminee.setBackground(Color.LIGHT_GRAY);
        
        // Regrouper les boutons pour une sélection unique
        ButtonGroup groupeStatut = new ButtonGroup();
        groupeStatut.add(attente);
        groupeStatut.add(validee);
        groupeStatut.add(terminee);
        
        // afficher les boutons
        pStatutRes.add(lblStatutRes);
        pStatutRes.add(attente);
        pStatutRes.add(validee);
        pStatutRes.add(terminee);
        champsPanel.add(pStatutRes);
        
        add(champsPanel, BorderLayout.CENTER); // centrer le tout
        
        // bouton "ajouter"
        JPanel boutonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        boutonPanel.setBackground(Color.LIGHT_GRAY);
        JButton btnAjouter = new JButton("Enregistrer");
        btnAjouter.setBackground(Color.GRAY);
        boutonPanel.add(btnAjouter);
        add(boutonPanel, BorderLayout.SOUTH);
        
    boutonAjouterReservation res = new boutonAjouterReservation(txtIdRes, jourDebBox, moisDebBox, 
    	anneeDebBox, jourFinBox, moisFinBox, anneeFinBox, groupeStatut, clientBox, chambreBox, hotel);
    btnAjouter.addActionListener(res);;
	}

}