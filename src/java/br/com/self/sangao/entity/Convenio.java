/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.self.sangao.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author prado
 */
@Entity
@Table(name = "convenio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Convenio.findAll", query = "SELECT c FROM Convenio c"),
    @NamedQuery(name = "Convenio.findByMatricula", query = "SELECT c FROM Convenio c WHERE c.matricula = :matricula"),
    @NamedQuery(name = "Convenio.findByNaturezaContratacao", query = "SELECT c FROM Convenio c WHERE c.naturezaContratacao = :naturezaContratacao"),
    @NamedQuery(name = "Convenio.findByAcomodacao", query = "SELECT c FROM Convenio c WHERE c.acomodacao = :acomodacao"),
    @NamedQuery(name = "Convenio.findByValidade", query = "SELECT c FROM Convenio c WHERE c.validade = :validade"),
    @NamedQuery(name = "Convenio.findByAbrangencia", query = "SELECT c FROM Convenio c WHERE c.abrangencia = :abrangencia"),
    @NamedQuery(name = "Convenio.findByPaciente", query = "SELECT c FROM Convenio c WHERE c.idPaciente = :idPaciente")})
public class Convenio implements Serializable, Entidade {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="seq", sequenceName="convenio_matricula_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq")
    @Column(name = "matricula")
    private Integer matricula;
    @Column(name = "natureza_contratacao")
    private String naturezaContratacao;
    @Column(name = "acomodacao")
    private String acomodacao;
    @Column(name = "validade")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validade;
    @Column(name = "abrangencia")
    private String abrangencia;
    @JoinColumn(name = "id_paciente", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Paciente idPaciente;

    public Convenio() {
    }

    public Convenio(Integer matricula) {
        this.matricula = matricula;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public String getNaturezaContratacao() {
        return naturezaContratacao;
    }

    public void setNaturezaContratacao(String naturezaContratacao) {
        this.naturezaContratacao = naturezaContratacao;
    }

    public String getAcomodacao() {
        return acomodacao;
    }

    public void setAcomodacao(String acomodacao) {
        this.acomodacao = acomodacao;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public String getAbrangencia() {
        return abrangencia;
    }

    public void setAbrangencia(String abrangencia) {
        this.abrangencia = abrangencia;
    }

    public Paciente getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Paciente idPaciente) {
        this.idPaciente = idPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matricula != null ? matricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Convenio)) {
            return false;
        }
        Convenio other = (Convenio) object;
        if ((this.matricula == null && other.matricula != null) || (this.matricula != null && !this.matricula.equals(other.matricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.self.sangao.entity.Convenio[ matricula=" + matricula + " ]";
    }

    @Override
    public Object getID() {
        return matricula;
    }

    @Override
    public String getIndex() {
        return "matricula";
    }
    
}
