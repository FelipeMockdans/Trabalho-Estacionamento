package Estacionamento;

import java.util.ArrayList;
import java.util.List;

public class SistemaEstacionamento {
    private List<Vaga> vagas = new ArrayList<>();
    private List<RegistroEstacionamento> registros = new ArrayList<>();

    public void adicionarVaga(int numero, String tamanho) {
        vagas.add(new Vaga(numero, tamanho));
    }

    public void registrarEntradaVeiculo(String placa, String modelo, String tamanho) {
        Veiculo veiculo = new Veiculo(placa, modelo, tamanho);
        Vaga vagaDisponivel = buscarVagaDisponivel(tamanho);

        if (vagaDisponivel != null) {
            RegistroEstacionamento registro = new RegistroEstacionamento(veiculo, vagaDisponivel);
            registros.add(registro);
            System.out.println("Veículo " + placa + " registrado na vaga " + vagaDisponivel.getNumero());
        } else {
            System.out.println("Não há vagas disponíveis para o tamanho " + tamanho);
        }
    }

    private Vaga buscarVagaDisponivel(String tamanhoVeiculo) {
        for (Vaga vaga : vagas) {
            if (vaga.isDisponivel() && vaga.getTamanho().equalsIgnoreCase(tamanhoVeiculo)) {
                return vaga;
            }
        }
        return null;
    }

    public void registrarSaidaVeiculo(String placa) {
        for (RegistroEstacionamento registro : registros) {
            if (registro.getVeiculo().getPlaca().equalsIgnoreCase(placa) && registro.getVeiculo().getHoraSaida() == null) {
                registro.registrarSaida();
                System.out.println("Veículo " + placa + " saiu da vaga " + registro.getVaga().getNumero());
                return;
            }
        }
        System.out.println("Veículo não encontrado ou já saiu.");
    }

    public void gerarRelatorioVagasOcupadas() {
        System.out.println("Vagas ocupadas no momento:");
        for (RegistroEstacionamento registro : registros) {
            if (registro.getVeiculo().getHoraSaida() == null) {
                Vaga vaga = registro.getVaga();
                System.out.println("Vaga: " + vaga.getNumero() + " | Tamanho: " + vaga.getTamanho() + " | Placa: " + registro.getVeiculo().getPlaca());
            }
        }
    }

    public void gerarHistoricoPermanencia() {
        System.out.println("Histórico de permanência dos veículos:");
        for (RegistroEstacionamento registro : registros) {
            if (registro.getVeiculo().getHoraSaida() != null) {
                registro.exibirDetalhes();
            }
        }
    }
}
