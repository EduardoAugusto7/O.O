package Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aeroport {

    private String nome;
    private String localizacao;
    private List<Voo> lista_voos = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public Aeroport() {
        this.nome = "";
        this.localizacao = "";
    }

    public Aeroport(String nome, String localizacao) {
        this.nome = nome;
        this.localizacao = localizacao;
    }

    public void preencher() {
        System.out.println("Informe o nome do aeroporto:");
        this.nome = input.nextLine();
        System.out.println("Informe a localização:");
        this.localizacao = input.nextLine();
    }

    public void imprimir() {
        System.out.println(this);
    }

    public void copiar(Aeroport outro) {
        this.nome = outro.getNome();
        this.localizacao = outro.getLocalizacao();
    }

    public void adicionarVoo(Voo voo) {
        lista_voos.add(voo);
        System.out.println("Voo adicionado com sucesso!");
    }

    public void removerVoo(String numero) {
        Voo encontrado = null;
        for (Voo v : lista_voos) {
            if (v.getNumDoVoo().equals(numero)) {
                encontrado = v;
                break;
            }
        }
        if (encontrado != null) {
            lista_voos.remove(encontrado);
            System.out.println("Voo removido com sucesso.");
        } else {
            System.out.println("Voo não encontrado.");
        }
    }

    public void listarVoos() {
        if (lista_voos.isEmpty()) {
            System.out.println("Nenhum voo cadastrado.");
        } else {
            for (Voo v : lista_voos) {
                System.out.println(v);
            }
        }
    }

    public List<Voo> calcularVoosComPrejuizo() {
        List<Voo> comPrejuizo = new ArrayList<>();
        for (Voo v : lista_voos) {
            if (v.temPrejuizo()) {
                comPrejuizo.add(v);
            }
        }
        return comPrejuizo;
    }

    public void iniciarVoo(String numero) {
        for (Voo v : lista_voos) {
            if (v.getNumDoVoo().equals(numero)) {
                v.alterarEstadoDeVoo("Em andamento");
                System.out.println("Voo iniciado com sucesso.");
                return;
            }
        }
        System.out.println("Voo não encontrado.");
    }

    @Override
    public String toString() {
        return "Aeroport{" + "nome=" + nome + ", localizacao=" + localizacao + ", lista_voos=" + lista_voos + '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public List<Voo> getLista_voos() {
        return lista_voos;
    }

    public void setLista_voos(List<Voo> lista_voos) {
        this.lista_voos = lista_voos;
    }
}
