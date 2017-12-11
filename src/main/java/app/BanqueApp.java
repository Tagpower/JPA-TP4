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
		//NB : pas besoin de persister les Adresses, elles sont intégrées dans Client.
		
		Client cl1 = new Client("Bauchet", "Clément", LocalDate.of(1994, 7, 14), ad3, b1);
		Client cl2 = new Client("Bauchet", "Victoire", LocalDate.of(2002, 1, 19), ad3, b1);
		
		Compte co1 = new Compte(100.0);
		LivretA co2 = new LivretA(150, 1.5);
		Compte compteJoint = new Compte(1000);
		AssuranceVie av1 = new AssuranceVie(50000, 0.5, LocalDate.of(2050, 12, 31));
		
		Virement v1 = new Virement(LocalDate.now(), 25, "Essence", "Station", co1);
		Virement v2 = new Virement(LocalDate.now(), 50, "Epargne", "", co2);
		
		co1.getOperations().add(v1);
		co2.getOperations().add(v2);
		cl1.getComptes().add(co1);
		cl1.getComptes().add(av1);
		cl2.getComptes().add(co2);
		
		//Compte joint
		cl1.getComptes().add(compteJoint);
		cl2.getComptes().add(compteJoint);
		
		b1.getClients().add(cl1);
		b1.getClients().add(cl2);
		
		//Ajout des entités
		em.persist(b1);
		em.persist(b2);
		
		em.persist(cl1);
		em.persist(cl2);
		em.persist(co1);
		em.persist(co2);
		em.persist(v1);
		em.persist(v2);
		
		et.commit();
		
		em.close();
		emfact.close();
	}

}
