/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.self.sangao.etiqueta.entity;

import java.util.Date;

/**
 *
 * @author treinamento
 */
public class Etiqueta {

    private String nomePaciente;
    private String tipoExame;
    private String medico;
    private Date dataColeta;
    private Date dataEntrega;

    /**
     * @return the nomePaciente
     */
    public String getNomePaciente() {
        return nomePaciente;
    }

    /**
     * @param nomePaciente the nomePaciente to set
     */
    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    /**
     * @return the tipoExame
     */
    public String getTipoExame() {
        return tipoExame;
    }

    /**
     * @param tipoExame the tipoExame to set
     */
    public void setTipoExame(String tipoExame) {
        this.tipoExame = tipoExame;
    }

    /**
     * @return the medico
     */
    public String getMedico() {
        return medico;
    }

    /**
     * @param medico the medico to set
     */
    public void setMedico(String medico) {
        this.medico = medico;
    }

    /**
     * @return the dataColeta
     */
    public Date getDataColeta() {
        return dataColeta;
    }

    /**
     * @param dataColeta the dataColeta to set
     */
    public void setDataColeta(Date dataColeta) {
        this.dataColeta = dataColeta;
    }

    /**
     * @return the dataEntrega
     */
    public Date getDataEntrega() {
        return dataEntrega;
    }

    /**
     * @param dataEntrega the dataEntrega to set
     */
    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

}
