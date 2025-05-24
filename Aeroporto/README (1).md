# Sistema de Gerenciamento de Aeroporto ✈️

Projeto desenvolvido como parte da disciplina de **Programação Orientada a Objetos (OO)**.

## 📌 Descrição

Este sistema simula o gerenciamento de um aeroporto, permitindo:

- Cadastro de voos com destino, escalas e número máximo de passageiros;
- Cadastro de passageiros com CPF e sistema de pontos de fidelidade;
- Atribuição de passageiros aos voos;
- Controle de estado dos voos (agendado, em andamento, concluído);
- Cálculo de voos com prejuízo (poucos passageiros);
- Fidelização de passageiros com base na conclusão de voos.

## 🧰 Tecnologias Utilizadas

- **Java SE**
- **Orientação a Objetos (OO)**: encapsulamento, composição, agregação, etc.
- **Coleções**: uso de `ArrayList`
- **IDE**: NetBeans (recomendado)

## 🏗️ Estrutura de Classes

- `Aeroport`: representa um aeroporto com lista de voos.
- `Voo`: representa um voo com destino, escalas, passageiros e estado.
- `Passageiro`: contém informações pessoais e sistema de fidelidade.
- `SistemaFidelidade`: classe auxiliar que controla pontos dos passageiros.

## ▶️ Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   ```
2. Importe o projeto em sua IDE Java (ex: NetBeans).
3. Execute a classe `aeroporto/Aeroporto.java`, que contém o método `main`.

## 📊 Funcionalidades em Destaque

- `adicionarVoo()`: adiciona voo ao aeroporto.
- `adicionarPassageiros()`: associa passageiros a voos.
- `iniciarVoo(String numDoVoo)`: altera o estado do voo para "em andamento".
- `calcularVoosComPrejuizo()`: retorna voos com ocupação baixa.
- Fidelização automática: passageiros recebem pontos ao final de um voo.

## 📚 Conceitos Envolvidos

- **Encapsulamento**
- **Agregação**
- **Composição**
- **Reutilização de código**
- **Boas práticas de modelagem**

## 👨‍🏫 Professor(a)

Disciplina orientada pelo(a) professor(a): *[Nome do professor]*

## 📅 Semestre

Projeto desenvolvido no semestre: **[1º / 2º semestre de 2025]**

## 👥 Autores

- [@joaopxulo](https://github.com/joaopxulo)
- [@EduardoAugusto7](https://github.com/EduardoAugusto7)

---

> Projeto acadêmico. Proibida a cópia para fins comerciais.
