/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.front.entity;

import br.com.self.sangao.entity.Coleta;
import br.com.self.sangao.entity.TipoExame;
import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author prado
 */
@Entity
@Table(name = "exame_tipo_exame")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExameTipoExame.findAll", query = "SELECT e FROM ExameTipoExame e"),
    @NamedQuery(name = "ExameTipoExame.findById", query = "SELECT e FROM ExameTipoExame e WHERE e.id = :id")})
public class ExameTipoExame implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_tipo_exame", referencedColumnName = "id")
    @ManyToOne
    private TipoExame idTipoExame;
    @JoinColumn(name = "id_exame", referencedColumnName = "id")
    @ManyToOne
    private Coleta idExame;

    public ExameTipoExame() {
    }

    public ExameTipoExame(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoExame getIdTipoExame() {
        return idTipoExame;
    }

    public void setIdTipoExame(TipoExame idTipoExame) {
        this.idTipoExame = idTipoExame;
    }

    public Coleta getIdExame() {
        return idExame;
    }

    public void setIdExame(Coleta idExame) {
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
        if (!(object instanceof ExameTipoExame)) {
            return false;
        }
        ExameTipoExame other = (ExameTipoExame) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.self.sangao.front.entity.ExameTipoExame[ id=" + id + " ]";
    }
    
}
