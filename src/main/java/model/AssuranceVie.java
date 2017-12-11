package model;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class AssuranceVie extends Compte {

	@Column(name="date_fin", nullable=false)
	private LocalDate dateFin;
	@Column(name="taux", nullable=false)
	private double taux;
	
	public AssuranceVie(double solde, double taux, LocalDate dateFin) {
		super(solde);
		this.dateFin = dateFin;
		this.taux = taux;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	
	
	
}
