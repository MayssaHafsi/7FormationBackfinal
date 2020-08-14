package com.projet.formationCertification.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;


@Entity
public class Fichier {
	  @Id
	  @GeneratedValue
	    @Column(name = "id")

	    private Long id;
	  
	    @Column(name = "name")

	  private String name;
	    
	    @Column(name = "mimetype")
	  private String mimetype;
	  
	    @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "id_formateur")
	    private Formateur formateurfichier ;
	  @Lob
	    @Column(name="pic")
	    private byte[] pic;


	public Formateur getFormateurfichier() {
		return formateurfichier;
	}

	public void setFormateurfichier(Formateur formateurfichier) {
		this.formateurfichier = formateurfichier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMimetype() {
		return mimetype;
	}

	public void setMimetype(String mimetype) {
		this.mimetype = mimetype;
	}

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Fichier(String name, String mimetype, byte[] pic) {
		super();
		this.name = name;
		this.mimetype = mimetype;
		this.pic = pic;

	}

	/*public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
*/
	public Fichier() {
		super();
		// TODO Auto-generated constructor stub
	}
	  
}
