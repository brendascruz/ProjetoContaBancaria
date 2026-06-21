# Projeto Conta Bancária

O **Projeto Conta Bancária** é uma aplicação de console desenvolvida para praticar e consolidar conceitos fundamentais de **Programação Orientada a Objetos (POO)** em Java. O sistema simula operações bancárias essenciais, utilizando estruturas de controle, coleções dinâmicas e tratamento preciso de valores monetários.

## Resumo

O sistema gerencia um conjunto de contas bancárias em memória utilizando `ArrayList`. Ele garante a integridade das operações financeiras (como saques e transferências) por meio de validações de saldo e uso da classe `BigDecimal`, evitando os problemas de arredondamento comuns em tipos primitivos como `float` ou `double`.

---

## Funcionalidades Principais

* **Gerenciamento de Contas:**
    * Criar nova conta bancária com titular, número e saldo inicial.
    * Consultar dados e informações detalhadas de uma conta específica através do número.
* **Operações Financeiras:**
    * **Depósito:** Realiza aportes financeiros validando se o valor é positivo.
    * **Saque:** Deduz valores do saldo, impedindo a operação caso não haja fundos suficientes.
    * **Transferência:** Permite mover saldos entre duas contas distintas com segurança (valida remetente, destinatário e saldo antes de concluir).

---

## Estrutura do Projeto

O projeto mantém uma estrutura simples e direta na raiz do diretório `src/`:

* `ContaBancaria.java` — Classe de modelo que encapsula as regras de negócio, atributos da conta (titular, saldo, número) e os métodos de validação das operações financeiras.
* `Main.java` — Classe principal responsável pelo fluxo do menu de interação no console, captura de entradas do usuário via `Scanner` e gerenciamento da lista de contas.
* `Makefile` — Arquivo de automação para simplificar os processos de compilação, execução e limpeza do projeto via terminal.

---

## Como Compilar e Rodar

### Requisitos Básicos
* **Java Development Kit (JDK):** Versão 8 ou superior instalada e configurada nas variáveis de ambiente.
* **Make:** Utilitário de automação instalado (comum no Git Bash, MSYS2 ou adicionado nativamente ao prompt do Windows).

### Executando pelo Terminal (Windows)

Abra o prompt de comando (CMD, PowerShell ou Git Bash) na pasta raiz do projeto onde estão os arquivos fontes e o `Makefile`:

**1. Compilar e Executar o projeto de forma direta:**
```bash
make run
``` 
(Este comando irá compilar os arquivos .java automaticamente e logo em seguida iniciará a aplicação).

**2. Apenas compilar o projeto (gerar os arquivos `.class`):**
```bash
make compile
```

**3. Limpar os arquivos gerados pela compilação:**
Se quiser remover os arquivos .class gerados e limpar o diretório, execute:
```bash
make clean
```

