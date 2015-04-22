/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.jorisdek.dinnerspinner.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gebruiker
 */
@Entity
@Table(name = "dishes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dishes.findAll", query = "SELECT d FROM Dishes d"),
    @NamedQuery(name = "Dishes.findById", query = "SELECT d FROM Dishes d WHERE d.id = :id"),
    @NamedQuery(name = "Dishes.findByNaam", query = "SELECT d FROM Dishes d WHERE d.naam = :naam"),
    @NamedQuery(name = "Dishes.findByWinkel", query = "SELECT d FROM Dishes d WHERE d.winkel = :winkel"),
    @NamedQuery(name = "Dishes.findByKosten", query = "SELECT d FROM Dishes d WHERE d.kosten = :kosten"),
    @NamedQuery(name = "Dishes.findByGezond", query = "SELECT d FROM Dishes d WHERE d.gezond = :gezond"),
    @NamedQuery(name = "Dishes.findByGoedkoop", query = "SELECT d FROM Dishes d WHERE d.goedkoop = :goedkoop"),
    @NamedQuery(name = "Dishes.findBySimpel", query = "SELECT d FROM Dishes d WHERE d.simpel = :simpel"),
    @NamedQuery(name = "Dishes.findBySnel", query = "SELECT d FROM Dishes d WHERE d.snel = :snel")})
public class Dishes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "naam")
    private String naam;
    @Size(max = 100)
    @Column(name = "winkel")
    private String winkel;
    @Lob
    @Size(max = 65535)
    @Column(name = "ingredienten")
    private String ingredienten;
    @Lob
    @Size(max = 65535)
    @Column(name = "extra")
    private String extra;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "kosten")
    private Double kosten;
    @Lob
    @Size(max = 65535)
    @Column(name = "bereiding")
    private String bereiding;
    @Column(name = "gezond")
    private Boolean gezond;
    @Column(name = "goedkoop")
    private Boolean goedkoop;
    @Column(name = "simpel")
    private Boolean simpel;
    @Column(name = "snel")
    private Boolean snel;

    public Dishes() {
    }

    public Dishes(Integer id) {
        this.id = id;
    }

    public Dishes(Integer id, String naam) {
        this.id = id;
        this.naam = naam;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getWinkel() {
        return winkel;
    }

    public void setWinkel(String winkel) {
        this.winkel = winkel;
    }

    public String getIngredienten() {
        return ingredienten;
    }

    public void setIngredienten(String ingredienten) {
        this.ingredienten = ingredienten;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public Double getKosten() {
        return kosten;
    }

    public void setKosten(Double kosten) {
        this.kosten = kosten;
    }

    public String getBereiding() {
        return bereiding;
    }

    public void setBereiding(String bereiding) {
        this.bereiding = bereiding;
    }

    public Boolean getGezond() {
        return gezond;
    }

    public void setGezond(Boolean gezond) {
        this.gezond = gezond;
    }

    public Boolean getGoedkoop() {
        return goedkoop;
    }

    public void setGoedkoop(Boolean goedkoop) {
        this.goedkoop = goedkoop;
    }

    public Boolean getSimpel() {
        return simpel;
    }

    public void setSimpel(Boolean simpel) {
        this.simpel = simpel;
    }

    public Boolean getSnel() {
        return snel;
    }

    public void setSnel(Boolean snel) {
        this.snel = snel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dishes)) {
            return false;
        }
        Dishes other = (Dishes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nl.jorisdek.dinnerspinner.entity.Dishes[ id=" + id + " ]";
    }
    
}
