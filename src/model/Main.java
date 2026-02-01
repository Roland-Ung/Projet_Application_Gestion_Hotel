package model;

import java.util.Date;

public class Main {
	public static void main (String[] args){
		Hotel monhotel = new Hotel ("Love", "5 avenue du love");
		
		Chambre chambre1 = new Chambre (1, 2, "luxe", 400, monhotel); // chambre associé à l'hotel
		Chambre chambre2 = new Chambre (3, 13, "grand", 300, monhotel);
		monhotel.ajoutChambre(chambre1);
		monhotel.ajoutChambre(chambre2);
		
		Client c1 = new Client (001,"cdg", "Blue", "roro@gmail.com", "07XXXXXXXXX", monhotel);
		monhotel.ajoutClient(c1);
		
		Reservation res = new Reservation (001,new Date(03/04/2025), new Date(03/04/2025), "libre", c1, chambre1);
		c1.ajoutReservation(res);
		chambre1.ajoutReservation(res);
		
		Sejour s = new Sejour (001, true, res);
		res.setSejour(s); 
		
		Produit_mini_bar oasis = new Produit_mini_bar (001, "oasis", 2, monhotel);
		monhotel.ajoutProduit_mini_bar(oasis);
		
		Consommation con1 = new Consommation(1, 3, 6, s, oasis);
		s.ajoutConsommation(con1);
		oasis.ajoutConsommation(con1);
		
		
	}
}