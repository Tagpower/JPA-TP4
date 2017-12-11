package app;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import model.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BanqueApp {

	private static final Logger LOG = LoggerFactory.getLogger(BanqueApp.class);

	public static void main(String[] args) {
		EntityManagerFactory emfact = Persistence.createEntityManagerFactory("banque");
		EntityManager em = emfact.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		//Création des entités
		Banque b1 = new Banque("Crédit Mutuel");
		Banque b2 = new Banque("BNP Paribas");
		
		Adresse ad1 = new Adresse(41, "rue Calypso", 44470, "Carquefou");
		Adresse ad2 = new Adresse(8, "rue du Tage", 44470, "Carquefou");
		Adresse ad3 = new Adresse(18, "rue du rocher", 44470, "Carquefou");
		
		Client cl1 = new Client("Bauchet", "Clément", LocalDate.of(1994, 7, 14), ad3, b1);
		
		Compte co1 = new Compte(100.0);
		
		Virement v1 = new Virement(LocalDate.now(), 25, "Essence", "Station", co1);
		
		co1.getOperations().add(v1);
		cl1.getComptes().add(co1);
		b1.getClients().add(cl1);
		
		et.commit();
		
		em.close();
		emfact.close();
	}

}
