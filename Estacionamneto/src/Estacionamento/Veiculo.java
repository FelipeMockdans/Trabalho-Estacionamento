package Estacionamento;

import java.time.LocalDateTime;

public class Veiculo {
    private String placa;
    private String modelo;
    private String tamanho;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSaida;

    public Veiculo(String placa, String modelo, String tamanho) {
        this.placa = placa;
        this.modelo = modelo;
        this.tamanho = tamanho;
    }

    public String getPlaca() { return placa; }
    public String getModelo() { return modelo; }
    public String getTamanho() { return tamanho; }
    public LocalDateTime getHoraEntrada() { return horaEntrada; }
    public LocalDateTime getHoraSaida() { return horaSaida; }

    public void registrarEntrada() { this.horaEntrada = LocalDateTime.now(); }
    public void registrarSaida() { this.horaSaida = LocalDateTime.now(); }
}
