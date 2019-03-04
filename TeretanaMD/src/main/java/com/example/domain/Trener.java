package com.example.domain;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;
import com.fasterxml.jackson.annotation.JsonManagedReference;


//@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
@Entity
public class Trener   {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        
    private Long id;
    
    private String ime;
    // moze se automatizovati cena pri kreiranju
    
     private Double cena;
     
     private String prezime;
     @JsonManagedReference
    @OneToMany(mappedBy = "trener")
    private Set<KnjigaTreninga> knjigatreningaSet= new HashSet<>();;

    private Long nivo;
    
    
    public Trener() {
    } 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @XmlTransient
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public Set<KnjigaTreninga> getKnjigatreningaSet() {
		return knjigatreningaSet;
	}

	public void setKnjigatreningaSet(Set<KnjigaTreninga> knjigatreningaSet) {
		this.knjigatreningaSet = knjigatreningaSet;
	}

	@Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trener)) {
            return false;
        }
        Trener other = (Trener) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

	
    public Long getNivo() {
		return nivo;
	}

	public void setNivo(Long nivo) {
		this.nivo = nivo;
	}

	@Override
    public String toString() {
        return "Trener[ id=" + id + " ]";
    }
    
}
