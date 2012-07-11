/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.entity;

import br.com.self.sangao.front.entity.ExameTipoExame;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author prado
 */
@Entity
@Table(name = "exame")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coleta.findAll", query = "SELECT e FROM Coleta e"),
    @NamedQuery(name = "Coleta.findById", query = "SELECT e FROM Coleta e WHERE e.id = :id"),
    @NamedQuery(name = "Coleta.findByDtColeta", query = "SELECT e FROM Coleta e WHERE e.dtColeta = :dtColeta"),
    @NamedQuery(name = "Coleta.findByDtEntrega", query = "SELECT e FROM Coleta e WHERE e.dtEntrega = :dtEntrega")})
public class Coleta implements Serializable, Entidade {
    @Column(name = "dt_coleta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtColeta;
    @Column(name = "dt_entrega")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtEntrega;
    @OneToMany(mappedBy = "idExame")
    private Collection<ExameTipoExame> exameTipoExameCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="seq", sequenceName="EXAME_ID_SEQ")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="seq")
    @Column(name = "id")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idExame")
    private Collection<Resultado> resultadoCollection;
    @JoinColumn(name = "tipo_exame", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoExame tipoExame;
    @JoinColumn(name = "id_paciente", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Paciente idPaciente;
    @JoinColumn(name = "id_medico", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Medico idMedico;

    public Coleta() {
    }

    public Coleta(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDtColeta() {
        return dtColeta;
    }

    public void setDtColeta(Date dtColeta) {
        this.dtColeta = dtColeta;
    }

    public Date getDtEntrega() {
        return dtEntrega;
    }

    public void setDtEntrega(Date dtEntrega) {
        this.dtEntrega = dtEntrega;
    }

    @XmlTransient
    public Collection<Resultado> getResultadoCollection() {
        return resultadoCollection;
    }

    public void setResultadoCollection(Collection<Resultado> resultadoCollection) {
        this.resultadoCollection = resultadoCollection;
    }

    public TipoExame getTipoExame() {
        return tipoExame;
    }

    public void setTipoExame(TipoExame tipoExame) {
        this.tipoExame = tipoExame;
    }

    public Paciente getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Paciente idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Medico getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Medico idMedico) {
        this.idMedico = idMedico;
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
        if (!(object instanceof Coleta)) {
            return false;
        }
        Coleta other = (Coleta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.self.sangao.entity.Exame[ id=" + id + " ]";
    }

    @Override
    public Object getID() {
        return id;
    }

    @Override
    public String getIndex() {
        return "id";
    }

    @XmlTransient
    public Collection<ExameTipoExame> getExameTipoExameCollection() {
        return exameTipoExameCollection;
    }

    public void setExameTipoExameCollection(Collection<ExameTipoExame> exameTipoExameCollection) {
        this.exameTipoExameCollection = exameTipoExameCollection;
    }
    
}
