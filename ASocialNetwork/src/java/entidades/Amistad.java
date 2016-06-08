/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marco
 */
@Entity
@Table(name = "Amistad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Amistad.findAll", query = "SELECT a FROM Amistad a"),
    @NamedQuery(name = "Amistad.findByIdAmistad", query = "SELECT a FROM Amistad a WHERE a.idAmistad = :idAmistad"),
    @NamedQuery(name = "Amistad.findByEstado", query = "SELECT a FROM Amistad a WHERE a.estado = :estado"),
    @NamedQuery(name = "Amistad.findByCreado", query = "SELECT a FROM Amistad a WHERE a.creado = :creado"),
    @NamedQuery(name = "Amistad.findByModificado", query = "SELECT a FROM Amistad a WHERE a.modificado = :modificado")})
public class Amistad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAmistad")
    private Integer idAmistad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @Column(name = "creado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "modificado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificado;
    @JoinColumn(name = "idUsuario1", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario1;
    @JoinColumn(name = "iidUsuario2", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario iidUsuario2;

    public Amistad() {
    }

    public Amistad(Integer idAmistad) {
        this.idAmistad = idAmistad;
    }

    public Amistad(Integer idAmistad, int estado, Date modificado) {
        this.idAmistad = idAmistad;
        this.estado = estado;
        this.modificado = modificado;
    }

    public Integer getIdAmistad() {
        return idAmistad;
    }

    public void setIdAmistad(Integer idAmistad) {
        this.idAmistad = idAmistad;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Date getCreado() {
        return creado;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
    }

    public Date getModificado() {
        return modificado;
    }

    public void setModificado(Date modificado) {
        this.modificado = modificado;
    }

    public Usuario getIdUsuario1() {
        return idUsuario1;
    }

    public void setIdUsuario1(Usuario idUsuario1) {
        this.idUsuario1 = idUsuario1;
    }

    public Usuario getIidUsuario2() {
        return iidUsuario2;
    }

    public void setIidUsuario2(Usuario iidUsuario2) {
        this.iidUsuario2 = iidUsuario2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAmistad != null ? idAmistad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Amistad)) {
            return false;
        }
        Amistad other = (Amistad) object;
        if ((this.idAmistad == null && other.idAmistad != null) || (this.idAmistad != null && !this.idAmistad.equals(other.idAmistad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Amistad[ idAmistad=" + idAmistad + " ]";
    }
    
}
