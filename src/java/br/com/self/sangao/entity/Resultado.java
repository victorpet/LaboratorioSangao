/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author prado
 */
@Entity
@Table(name = "resultado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resultado.findAll", query = "SELECT r FROM Resultado r"),
    @NamedQuery(name = "Resultado.findById", query = "SELECT r FROM Resultado r WHERE r.id = :id"),
    @NamedQuery(name = "Resultado.findByDescricao", query = "SELECT r FROM Resultado r WHERE r.descricao = :descricao")})
public class Resultado implements Serializable, Entidade {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="seq", sequenceName="SEQUENCE")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="seq")
    @Column(name = "id")
    private Integer id;
    @Column(name = "descricao")
    private String descricao;
    @JoinColumn(name = "id_exame", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Exame idExame;

    public Resultado() {
    }

    public Resultado(Integer id) {
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

    public Exame getIdExame() {
        return idExame;
    }

    public void setIdExame(Exame idExame) {
        this.idExame = idExame;
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
        if (!(object instanceof Resultado)) {
            return false;
        }
        Resultado other = (Resultado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.self.sangao.entity.Resultado[ id=" + id + " ]";
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
