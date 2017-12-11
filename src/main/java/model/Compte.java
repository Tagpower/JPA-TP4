package model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="compte")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Compte {

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int numero;
	@Column(name="solde", nullable=false, precision=2)
	private double solde;
	@ManyToMany(mappedBy="comptes", cascade=CascadeType.ALL )
	private Set<Client> titulaires;
	@OneToMany(mappedBy="compte", cascade=CascadeType.ALL )
	private Set<Operation> operations;
	
	public Compte() {
		
	}
	
	public Compte(double solde) {
		this.solde = solde;
		this.titulaires = new HashSet<Client>(0);
		this.operations = new HashSet<Operation>(0);
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public double getSolde() {
		return solde;
	}


	public void setSolde(double solde) {
		this.solde = solde;
	}


	public Set<Client> getTitulaires() {
		return titulaires;
	}


	public void setTitulaires(Set<Client> titulaires) {
		this.titulaires = titulaires;
	}


	public Set<Operation> getOperations() {
		return operations;
	}


	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}
	
	
	
}
