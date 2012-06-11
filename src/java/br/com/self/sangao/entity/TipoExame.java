/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author prado
 */
@Entity
@Table(name = "tipo_exame")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoExame.findAll", query = "SELECT t FROM TipoExame t"),
    @NamedQuery(name = "TipoExame.findById", query = "SELECT t FROM TipoExame t WHERE t.id = :id"),
    @NamedQuery(name = "TipoExame.findByDescricao", query = "SELECT t FROM TipoExame t WHERE t.descricao = :descricao")})
public class TipoExame implements Serializable, Entidade {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="seq", sequenceName="SEQUENCE")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="seq")
    @Column(name = "id")
    private Integer id;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoExame")
    private Collection<Exame> exameCollection;

    public TipoExame() {
    }

    public TipoExame(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public Collection<Exame> getExameCollection() {
        return exameCollection;
    }

    public void setExameCollection(Collection<Exame> exameCollection) {
        this.exameCollection = exameCollection;
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
        if (!(object instanceof TipoExame)) {
            return false;
        }
        TipoExame other = (TipoExame) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.self.sangao.entity.TipoExame[ id=" + id + " ]";
    }

    @Override
    public Object getID() {
        return id;
    }

    @Override
    public String getIndex() {
        return "id";
    }
    
}
