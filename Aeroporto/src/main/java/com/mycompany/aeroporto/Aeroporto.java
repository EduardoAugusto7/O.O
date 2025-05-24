package com.mycompany.aeroporto;

import Classes.Aeroport;
import Classes.Voo;
import Classes.Passageiro;
import java.util.List;

public class Aeroporto {
    public static void main(String[] args) {
        Aeroport aeroporto = new Aeroport("Aeroporto Internacional de Brasília", "Brasília");
        Voo voo1 = new Voo("BR123", "Nova York", 100, "Agendado");

        Passageiro passageiro1 = new Passageiro("João Silva", "12345678900");

        voo1.adicionarEscalas("Miami");
        voo1.adicionarEscalas("Orlando");

        aeroporto.adicionarVoo(voo1);
        voo1.adicionarPassageiros(passageiro1);

        passageiro1.getSistemaFidelidade().adicionarPontos(500);

        aeroporto.iniciarVoo("BR123");

        System.out.println("Voos com prejuízo:");
        List<Voo> voosPrejuizo = aeroporto.calcularVoosComPrejuizo();
        for (Voo v : voosPrejuizo) {
            System.out.println(v.getNumDoVoo());
        }
       System.out.println("Pontos do passageiro: " + passageiro1.getSistemaFidelidade().retornaPontos());
    }
    a
}
