package controleur;

import javax.swing.*;
import java.awt.event.*;
import model.*;

public class boutonSupModSejour implements ActionListener {
	Hotel hotel;
	JComboBox<Sejour> listeSejMod;
	
	public boutonSupModSejour(Hotel h, JComboBox<Sejour> mod) {
		hotel = h;
		listeSejMod = mod;
	}
	
	public void actionPerformed(ActionEvent e) {
		Sejour selected = (Sejour) listeSejMod.getSelectedItem();
		if (selected != null) {
			try {
			// modifier l'ID
			int oldId = selected.id_sejour;
			String newId = JOptionPane.showInputDialog("Nouvel ID :", selected.id_sejour);
			if (newId != null) selected.id_sejour = Integer.parseInt(newId);
			if (selected.id_sejour != oldId) {
				for (Client c : hotel.ListClient) {
					for (Reservation r : c.ListReservation) {
						// si l'id existe déjà, sans compter lui même
						if (r.sejour.id_sejour == selected.id_sejour && r.sejour != selected) {
			        		selected.id_sejour = oldId; // il reprend son ancienne valeur
							JOptionPane.showMessageDialog(null, "ID séjour déjà existant");
			        		return;
						}
					}
				}
			}
			} catch (NumberFormatException a) {
                JOptionPane.showMessageDialog(null, "Valeurs numériques invalides.");
        	}
			int choix = JOptionPane.showConfirmDialog(
				    null,
				    "Séjour payé ?",
				    "Statut de paiement",
				    JOptionPane.YES_NO_OPTION
			);
			selected.est_payee = (choix == JOptionPane.YES_OPTION);
				
			listeSejMod.repaint(); // met à jour la barre déroulante
			JOptionPane.showMessageDialog(null,  "Séjour modifiée");
		}
	}
}
