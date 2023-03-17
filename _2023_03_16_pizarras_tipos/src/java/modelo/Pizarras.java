/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luisgm
 */
@Entity
@Table(name = "pizarras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pizarras.findAll", query = "SELECT p FROM Pizarras p"),
    @NamedQuery(name = "Pizarras.findById", query = "SELECT p FROM Pizarras p WHERE p.id = :id"),
    @NamedQuery(name = "Pizarras.findByDescripcion", query = "SELECT p FROM Pizarras p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Pizarras.findByDimensiones", query = "SELECT p FROM Pizarras p WHERE p.dimensiones = :dimensiones"),
    @NamedQuery(name = "Pizarras.findByMaterial", query = "SELECT p FROM Pizarras p WHERE p.material = :material")})
public class Pizarras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "dimensiones")
    private String dimensiones;
    @Column(name = "material")
    private String material;
    @JoinColumn(name = "tipos_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tipos tiposId;
    
    

    public Pizarras() {
    }

    public Pizarras(Integer id) {
        this.id = id;
    }

    public Pizarras(Integer id, String descripcion, String dimensiones, String material, Tipos tiposId) {
        this.id = id;
        this.descripcion = descripcion;
        this.dimensiones = dimensiones;
        this.material = material;
        this.tiposId = tiposId;
    }
    
    
    
    
    
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Tipos getTiposId() {
        return tiposId;
    }

    public void setTiposId(Tipos tiposId) {
        this.tiposId = tiposId;
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
        if (!(object instanceof Pizarras)) {
            return false;
        }
        Pizarras other = (Pizarras) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Pizarras[ id=" + id + " ]";
    }
    
}
