package br.org.serratec.biblioteca.exception;

import java.time.LocalDateTime;
import java.util.List;

public class ErroResposta {

    private Integer status;
    private String causa;
    private LocalDateTime dataErro;
    private List<String> erros;

    public ErroResposta(Integer status, String causa, LocalDateTime dataErro, List<String> Erros) {
        this.status = status;
        this.causa = causa;
        this.dataErro = dataErro;
        this.erros = Erros;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public LocalDateTime getDataErro() {
        return dataErro;
    }

    public void setDataErro(LocalDateTime dataErro) {
        this.dataErro = dataErro;
    }

    public List<String> getErros() {
        return erros;
    }

    public void setErros(List<String> Erros) {
        this.erros = Erros;
    }
}

