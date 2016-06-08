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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author marco
 */
@Entity
@Table(name = "MeGusta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MeGusta.findAll", query = "SELECT m FROM MeGusta m"),
    @NamedQuery(name = "MeGusta.findByIdLike", query = "SELECT m FROM MeGusta m WHERE m.idLike = :idLike"),
    @NamedQuery(name = "MeGusta.findByCreado", query = "SELECT m FROM MeGusta m WHERE m.creado = :creado")})
public class MeGusta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idLike")
    private Integer idLike;
    @Column(name = "creado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creado;
    @JoinColumn(name = "idPost", referencedColumnName = "idPost")
    @ManyToOne(optional = false)
    private Post idPost;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public MeGusta() {
    }

    public MeGusta(Integer idLike) {
        this.idLike = idLike;
    }

    public Integer getIdLike() {
        return idLike;
    }

    public void setIdLike(Integer idLike) {
        this.idLike = idLike;
    }

    public Date getCreado() {
        return creado;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
    }

    public Post getIdPost() {
        return idPost;
    }

    public void setIdPost(Post idPost) {
        this.idPost = idPost;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLike != null ? idLike.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MeGusta)) {
            return false;
        }
        MeGusta other = (MeGusta) object;
        if ((this.idLike == null && other.idLike != null) || (this.idLike != null && !this.idLike.equals(other.idLike))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.MeGusta[ idLike=" + idLike + " ]";
    }
    
}
