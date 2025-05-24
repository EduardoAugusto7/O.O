package Classes;

public class SistemaDePontosFidelidade {

    private int pontosAcumulados;

    public SistemaDePontosFidelidade() {
        this.pontosAcumulados = 0;
    }

    public SistemaDePontosFidelidade(int pontosAcumulados) {
        this.pontosAcumulados = pontosAcumulados;
    }

    public void adicionarPontos(int pontos) {
        this.pontosAcumulados += pontos;
    }

    public void removerPontos(int pontos) {
        this.pontosAcumulados -= pontos;
    }

    public int retornaPontos() {
        return this.pontosAcumulados;
    }

    public boolean resgatarPontos(int pontos) {
        if (pontos > 0 && this.pontosAcumulados >= pontos) {
            removerPontos(pontos);
            System.out.println("resgate com sucesso.");
            return true;
        } else {
            System.out.println("resgate nao foi feito com sucesso.");
            return false;
        }
    }

}
