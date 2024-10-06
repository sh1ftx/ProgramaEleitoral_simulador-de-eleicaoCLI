# Sistema-de-elei-o-CLI-com-Java

## Documentação do Projeto: programaEleitoral

## Índice

1. [Visão Geral](#visão-geral)
2. [Objetivos do Sistema](#objetivos-do-sistema)
3. [Estrutura do Projeto](#estrutura-do-projeto)
4. [Classes e Componentes](#classes-e-componentes)
   - [Eleição](#eleição)
   - [Candidato](#candidato)
   - [Eleitor](#eleitor)
   - [ContagemVotos](#contagemvotos)
   - [ResultadoMajoritario](#resultadomaioritario)
   - [ResultadoProporcional](#resultadoproporcional)
   - [Lista](#lista)
   - [Verificador](#verificador)
   - [ExibirResultados](#exibirresultados)
   - [Main](#main)
5. [Fluxo de Execução do Sistema](#fluxo-de-execução-do-sistema)
6. [Requisitos](#requisitos)
7. [Como Executar](#como-executar)
8. [Possíveis Melhorias Futuras](#possíveis-melhorias-futuras)
9. [Diagramas UML Sugeridos](#diagramas-uml-sugeridos)

---

## Visão Geral

O **programaEleitoral** é um sistema de gerenciamento de eleições que permite o registro de eleitores, candidatos e a contagem de votos. O sistema é projetado para ser modular e escalável, oferecendo suporte a eleições majoritárias e proporcionais. A aplicação pode ser utilizada para diferentes cargos, como presidente, vereador e deputado, dependendo das necessidades do usuário.

## Objetivos do Sistema

- **Registrar Eleitores**: Permitir o cadastro e consulta de eleitores.
- **Registrar Candidatos**: Facilitar o cadastro de candidatos com seus respectivos dados.
- **Votação**: Proporcionar um mecanismo para que os eleitores possam votar em candidatos.
- **Contagem de Votos**: Contar e classificar os votos, apresentando resultados de forma clara.
- **Exibir Resultados**: Mostrar os vencedores de eleições majoritárias e a distribuição de vagas em eleições proporcionais.

## Estrutura do Projeto

O projeto é organizado em pacotes, cada um com responsabilidades específicas:

```
programaEleitoral/
│
├── adminEleicoes/
│   └── Eleicao.java
│
├── features/
│   └── Cadastro.java
│
├── interfac/
│   └── Login.java
│
├── resultado/
│   ├── ContagemVotos.java
│   ├── ResultadoMajoritario.java
│   ├── ResultadoProporcional.java
│   └── ExibirResultados.java
│
├── usuarios/
│   ├── Candidato.java
│   └── Eleitor.java
│
├── utilitarios/
│   └── Lista.java
│
└── verificacoes/
    └── Verificador.java
│
└── Main.java
```

## Classes e Componentes

### Eleição

```java
package adminEleicoes;

public class Eleicao {
    private boolean ativa;
    private int limiteVotos;

    public Eleicao(int limiteVotos) {
        this.limiteVotos = limiteVotos;
        this.ativa = true; // A eleição começa ativa
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void finalizarEleicao() {
        this.ativa = false;
    }

    public int getLimiteVotos() {
        return limiteVotos;
    }
}
```

**Descrição**: A classe `Eleicao` gerencia o estado da eleição (ativa ou não) e o limite de votos permitidos. Fornece métodos para finalizar a eleição e verificar se a eleição ainda está ativa.

**Métodos**:
- `isAtiva()`: Verifica se a eleição está ativa.
- `finalizarEleicao()`: Define a eleição como inativa.
- `getLimiteVotos()`: Retorna o número máximo de votos permitidos na eleição.

### Candidato

```java
package usuarios;

public class Candidato {
    private String cargo;
    private String nome;
    private String partido;
    private int numero;
    private int votos;

    public Candidato(String cargo, String nome, String partido, int numero) {
        this.cargo = cargo;
        this.nome = nome;
        this.partido = partido;
        this.numero = numero;
        this.votos = 0;
    }

    // Métodos de acesso (getters) e para adicionar votos
}
```

**Descrição**: A classe `Candidato` representa um candidato em uma eleição. Armazena informações sobre o cargo, nome, partido, número e votos recebidos. Inclui métodos para acessar essas informações e incrementar o número de votos.

**Métodos**:
- `getCargo()`, `getNome()`, `getPartido()`, `getNumero()`, `getVotos()`: Métodos de acesso para obter informações do candidato.
- `addVoto()`: Incrementa o contador de votos do candidato.

### Eleitor

```java
package usuarios;

public class Eleitor {
    private String nome;
    private int idade;
    private Integer cpf; 
    private boolean jaVotou = false;

    public Eleitor(String nome, int idade, Integer cpf) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf; 
    }

    // Métodos de acesso (getters) e para registrar se o eleitor já votou
}
```

**Descrição**: A classe `Eleitor` representa um eleitor no sistema, armazenando nome, idade, CPF e se já votou. Inclui métodos para acessar essas informações e modificar o estado de votação.

**Métodos**:
- `getNome()`, `getIdade()`, `getCpf()`, `getJaVotou()`: Métodos de acesso para obter informações do eleitor.
- `setJaVotou()`: Define que o eleitor já votou.

### ContagemVotos

```java
package resultado;

public class ContagemVotos {
    private int votoBranco;
    private int votoNulo;
    private int votosValidos;
    private int votosTotais;
    private int limiteVotos;

    public ContagemVotos(int limiteVotos) {  
        this.votoBranco = 0;
        this.votoNulo = 0;
        this.votosValidos = 0;
        this.votosTotais = 0;
        this.limiteVotos = limiteVotos;
    }
    
    // Métodos para adicionar votos e verificar limites
}
```

**Descrição**: A classe `ContagemVotos` gerencia a contagem de votos, incluindo votos válidos, nulos e brancos, além do total de votos. Possui métodos para adicionar votos e verificar se o limite de votos foi atingido.

**Métodos**:
- `adicionarVotoValido()`, `adicionarVotoNulo()`, `adicionarVotoBranco()`: Métodos para incrementar os contadores de votos.
- `verificarLimite()`: Verifica se o limite de votos foi atingido.

### ResultadoMajoritario

```java
package resultado;

import usuarios.Candidato;
import utilitarios.Lista;

public class ResultadoMajoritario {
    private Lista listaCandidatos; 

    public ResultadoMajoritario(Lista listaCandidatos) {
        this.listaCandidatos = listaCandidatos;
    }

    // Métodos para calcular e exibir o vencedor majoritário
}
```

**Descrição**: A classe `ResultadoMajoritario` é responsável por calcular e exibir o vencedor em uma eleição majoritária, utilizando a lista de candidatos.

**Métodos**:
- `calcularVencedor()`: Determina o candidato com mais votos e o retorna.
- `exibirResultado()`: Exibe o resultado da eleição majoritária.

### ResultadoProporcional

```java
package resultado;

import java.util.List;
import java.util.Map;
import usuarios.Candidato;
import utilitarios.Lista;

public class ResultadoProporcional {
    private Lista listaCandidatos;

    public ResultadoProporcional(Lista listaCandidatos) {
        this.listaCandidatos = listaCandidatos;
    }

    // Métodos para calcular e exibir os vencedores proporcionais
}
```

**Descrição**: A classe `ResultadoProporcional` calcula as vagas proporcionais que cada partido tem direito com base nos votos recebidos e exibe os candidatos eleitos.

**Métodos**:
- `calcularVagasProporcionais()`: Calcula as vagas que cada partido tem direito com base na quantidade de votos recebidos.
- `candidatosEleitos()`: Determina os candidatos eleitos por partido.
- `exibirVencedores()`: Exibe os candidatos eleitos para o cargo especificado.

### Lista

```java
package utilitarios;

import java.util.HashMap;
import java.util.Map;
import usuarios.Candidato;
import usuarios.Eleitor;

public class Lista {
    private Map<Integer, Eleitor> listaEleitor = new HashMap<>();
    private Map<Integer, Candidato> listaCandidato = new HashMap<>();

    // Métodos para exibir candidatos e gerenciar

 eleitores
}
```

**Descrição**: A classe `Lista` é uma estrutura de dados que armazena eleitores e candidatos. Fornece métodos para exibir candidatos por cargo ou partido e manipular as listas de eleitores e candidatos.

### Verificador

```java
package verificacoes;

import adminEleicoes.Eleicao;
import usuarios.Eleitor;

public class Verificador {
    public static boolean podeVotar(Eleitor eleitor) {
        return !eleitor.getJaVotou();
    }

    public static boolean eleicaoAtiva(Eleicao eleicao) {
        return eleicao.isAtiva();
    }
}
```

**Descrição**: A classe `Verificador` fornece métodos para verificar se um eleitor pode votar e se a eleição está ativa.

### ExibirResultados

```java
package resultado;

import java.util.List;
import usuarios.Candidato;

public class ExibirResultados {
    // Métodos para exibir os resultados das eleições
}
```

**Descrição**: A classe `ExibirResultados` é responsável por formatar e exibir os resultados das eleições de forma legível.

### Main

```java
import java.util.Scanner;
import utilitarios.Lista;
import interfac.Login;
import features.Cadastro;
import adminEleicoes.Eleicao;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Lista lista = new Lista();

        Cadastro.adicionarEleitorPraTeste(lista);
        Cadastro.adicionarCandidatosPraTeste(lista);

        Eleicao eleicao = new Eleicao(10);

        Login login = new Login(lista, eleicao);
        login.login(scan);
        
        scan.close();
    }
}
```

**Descrição**: A classe `Main` inicia a aplicação. Realiza a configuração inicial, como a adição de eleitores e candidatos para teste, e chama o método de login para interagir com o usuário.

## Fluxo de Execução do Sistema

1. **Inicialização**: Ao executar a classe `Main`, são adicionados dados de teste para eleitores e candidatos.
2. **Login**: O usuário é solicitado a realizar login. Isso pode incluir autenticação de um administrador ou eleitor.
3. **Gerenciamento de Eleição**: Após o login, o sistema permite que o usuário gerencie a eleição, incluindo a possibilidade de iniciar uma votação, registrar votos e finalizar a eleição.
4. **Votação**: Os eleitores podem votar em candidatos. O sistema valida se o eleitor já votou e se a eleição está ativa.
5. **Contagem de Votos**: Após a votação, o sistema conta os votos e determina o resultado com base na lógica definida para eleições majoritárias ou proporcionais.
6. **Exibição de Resultados**: Os resultados são exibidos para o usuário, mostrando candidatos eleitos e a distribuição de vagas.

## Requisitos

- Java Development Kit (JDK) 22 ou superior.
- IDE Eclipse ou qualquer outra IDE que suporte Java.
- Configuração adequada de classpath e arquivos de projeto.

## Como Executar

1. **Clone o repositório**: Se o projeto estiver em um repositório Git, clone o repositório em seu ambiente local.
   
   ```bash
   git clone <URL do repositório>
   cd programaEleitoral
   ```

2. **Abra no Eclipse**: Abra o Eclipse e importe o projeto como um projeto existente.

3. **Compile e Execute**: Compile o projeto e execute a classe `Main`. Siga as instruções exibidas no console para interagir com o sistema.

4. **Testes**: Utilize o método `Cadastro.adicionarEleitorPraTeste` e `Cadastro.adicionarCandidatosPraTeste` para criar dados de teste e explorar o funcionamento do sistema.

## Possíveis Melhorias Futuras

- **Persistência de Dados**: Implementar um sistema de banco de dados para armazenar permanentemente eleitores e candidatos.
- **Interface Gráfica do Usuário (GUI)**: Desenvolver uma interface gráfica para facilitar a interação do usuário com o sistema.
- **Validação de CPF**: Adicionar validações para garantir que os CPFs sejam únicos e formatados corretamente.
- **Sistema de Relatórios**: Criar relatórios que resumam os resultados das eleições em diferentes formatos (PDF, Excel).
- **Aprimoramento de Segurança**: Implementar autenticação e autorização mais robustas para acesso ao sistema.
- **Testes Automatizados**: Adicionar testes unitários e de integração para garantir a qualidade do código e o funcionamento adequado do sistema.
