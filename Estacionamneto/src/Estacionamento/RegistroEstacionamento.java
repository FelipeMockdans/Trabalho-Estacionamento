package Estacionamento;

import java.time.Duration;

public class RegistroEstacionamento {
    private Veiculo veiculo;
    private Vaga vaga;
    private Duration tempoPermanencia;
    private double valorPago;

    public RegistroEstacionamento(Veiculo veiculo, Vaga vaga) {
        this.veiculo = veiculo;
        this.vaga = vaga;
        veiculo.registrarEntrada();
        vaga.ocupar();
    }

    public void registrarSaida() {
        veiculo.registrarSaida();
        tempoPermanencia = Duration.between(veiculo.getHoraEntrada(), veiculo.getHoraSaida());
        valorPago = calcularValor();
        vaga.liberar();
    }

    private double calcularValor() {
        long horas = tempoPermanencia.toHours();
        if (horas <= 1) return 5.0;
        else if (horas <= 3) return 10.0;
        else return 15.0;
    }

    public Veiculo getVeiculo() { return veiculo; }
    public Vaga getVaga() { return vaga; }
    public Duration getTempoPermanencia() { return tempoPermanencia; }
    public double getValorPago() { return valorPago; }

    public void exibirDetalhes() {
        System.out.println("Placa: " + veiculo.getPlaca());
        System.out.println("Tempo de permanência: " + tempoPermanencia.toHours() + " horas");
        System.out.println("Valor pago: R$ " + valorPago);
    }
}
