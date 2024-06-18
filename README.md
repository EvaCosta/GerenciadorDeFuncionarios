# GerenciadorDeFuncionarios

GerenciadorDeFuncionarios é um sistema de gerenciamento de funcionários desenvolvido em Java. Este projeto foi criado para gerenciar informações de funcionários, incluindo seus salários, funções, aniversários e mais. Ele demonstra boas práticas de programação, incluindo princípios SOLID, design patterns e clean code.

## Funcionalidades

- Inserir todos os funcionários com suas informações.
- Remover um funcionário específico da lista.
- Imprimir todos os funcionários com todas as suas informações formatadas.
- Aplicar um aumento de 10% nos salários dos funcionários.
- Agrupar os funcionários por função.
- Imprimir os funcionários agrupados por função.
- Imprimir os funcionários que fazem aniversário nos meses de outubro e dezembro.
- Encontrar e imprimir o funcionário com a maior idade.
- Ordenar e imprimir a lista de funcionários por ordem alfabética.
- Calcular e imprimir o total dos salários dos funcionários.
- Calcular e imprimir quantos salários mínimos cada funcionário recebe.


## Requisitos

- Java 8 ou superior

## Configuração e Execução

1. Clone o repositório:

   ```sh
   git clone https://github.com/seuusuario/GerenciadorDeFuncionarios.git
   ```

2. Navegue até o diretório do projeto:

   ```sh
   cd GerenciadorDeFuncionarios
   ```

3. Compile o projeto:

   ```sh
   javac -d bin src/main/java/com/suaempresa/projetonome/*.java
   ```

4. Execute a aplicação:

   ```sh
   java -cp bin com.suaempresa.projetonome.Principal
   ```

## Exemplos de Uso

### Inicialização dos Funcionários

A lista de funcionários é inicializada com as seguintes informações:

| Nome    | Data de Nascimento | Salário   | Função       |
|---------|--------------------|-----------|--------------|
| Maria   | 18/10/2000         | 2009.44   | Operador     |
| João    | 12/05/1990         | 2284.38   | Operador     |
| Caio    | 02/05/1961         | 9836.14   | Coordenador  |
| Miguel  | 14/10/1988         | 19119.88  | Diretor      |
| Alice   | 05/01/1995         | 2234.68   | Recepcionista|
| Heitor  | 19/11/1999         | 1582.72   | Operador     |
| Arthur  | 31/03/1993         | 4071.84   | Contador     |
| Laura   | 08/07/1994         | 3017.45   | Gerente      |
| Heloísa | 24/05/2003         | 1606.85   | Eletricista  |
| Helena  | 02/09/1996         | 2799.93   | Gerente      |

### Saída Exemplo

```plaintext
Funcionários:
Nome: Maria, Data de Nascimento: 18/10/2000, Salário: R$ 2.009,44, Função: Operador
Nome: Caio, Data de Nascimento: 02/05/1961, Salário: R$ 9.836,14, Função: Coordenador
Nome: Miguel, Data de Nascimento: 14/10/1988, Salário: R$ 19.119,88, Função: Diretor
Nome: Alice, Data de Nascimento: 05/01/1995, Salário: R$ 2.234,68, Função: Recepcionista
Nome: Heitor, Data de Nascimento: 19/11/1999, Salário: R$ 1.582,72, Função: Operador
Nome: Arthur, Data de Nascimento: 31/03/1993, Salário: R$ 4.071,84, Função: Contador
Nome: Laura, Data de Nascimento: 08/07/1994, Salário: R$ 3.017,45, Função: Gerente
Nome: Heloísa, Data de Nascimento: 24/05/2003, Salário: R$ 1.606,85, Função: Eletricista
Nome: Helena, Data de Nascimento: 02/09/1996, Salário: R$ 2.799,93, Função: Gerente

Funcionários agrupados por função:
Operador:
- Maria
- Heitor
Contador:
- Arthur
Coordenador:
- Caio
Diretor:
- Miguel
Recepcionista:
- Alice
Gerente:
- Laura
- Helena
Eletricista:
- Heloísa

Funcionários que fazem aniversário nos meses [10, 12]:
- Maria
- Miguel
- João

Funcionário mais velho: Caio, Idade: 62 anos

Funcionários em ordem alfabética:
- Alice
- Arthur
- Caio
- Helena
- Heloísa
- Heitor
- João
- Laura
- Maria
- Miguel

Total dos salários dos funcionários: R$ 47.558,32

Salários mínimos que cada funcionário ganha:
- Maria: 1.65 salários mínimos
- Caio: 8.11 salários mínimos
- Miguel: 15.77 salários mínimos
- Alice: 1.84 salários mínimos
- Heitor: 1.30 salários mínimos
- Arthur: 3.36 salários mínimos
- Laura: 2.49 salários mínimos
- Heloísa: 1.32 salários mínimos
- Helena: 2.31 salários mínimos
```