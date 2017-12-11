package model;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Virement extends Operation {

	@Column(name="beneficiaire")
	private String beneficiaire;
	
	public Virement(LocalDate date, double montant, String motif, String beneficiaire, Compte compte) {
		super(date, montant, motif, compte);
		this.beneficiaire = beneficiaire;
	}

}
