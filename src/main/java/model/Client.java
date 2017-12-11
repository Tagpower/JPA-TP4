package model;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int id;
	@Column(name="nom", nullable=false)
	private String nom;
	@Column(name="prenom", nullable=false)
	private String prenom;
	@Column(name="dateNaissance", nullable=false)
	private LocalDate date_n;
	@Embedded
	private Adresse adresse;
	@ManyToOne
	@JoinColumn(name="id_banque")
	private Banque banque;
	@ManyToMany
	@JoinTable(name="appartenance",
		joinColumns = @JoinColumn(name="id_client", referencedColumnName="id"),
		inverseJoinColumns = @JoinColumn(name="id_compte", referencedColumnName="id")		
	)
	private Set<Compte> comptes;
	
	
	
	public Client(String nom, String prenom, LocalDate date_n, Adresse adresse, Banque banque) {
		this.nom = nom;
		this.prenom = prenom;
		this.date_n = date_n;
		this.adresse = adresse;
		this.banque = banque;
		this.comptes = new HashSet<Compte>();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public LocalDate getDate_n() {
		return date_n;
	}
	public void setDate_n(LocalDate date_n) {
		this.date_n = date_n;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	public Set<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

	
	
	

}
