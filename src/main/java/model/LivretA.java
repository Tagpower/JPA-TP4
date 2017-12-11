package model;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class LivretA extends Compte {
	
	@Column(name="taux")
	private double taux;

	public LivretA(double solde, double taux) {
		super(solde);
		this.taux = taux;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}


}
