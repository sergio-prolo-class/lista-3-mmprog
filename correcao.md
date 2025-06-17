# Correção

| Questão     | Legibilidade | P1 | P2 | Total |
|-------------|--------------|----|----|-------|
| Nota máxima | 15           | 35 | 50 | 100   |
| Nota        | 10           | 33 | 43 | 86    |

## Diagramas

- P1:
  - se o Catalogo recebe objetos do tipo Filme na hora de adicionar ou remover...
  - então ele não controla o ciclo de vida desses objetos! alguém cria e passa pra ele.
  - logo, composição provavelmente não é o tipo de associação correta
- P2:
  - se o Atendimento recebe objetos do tipo Cliente na hora de registrar...
  - então ele não controla o ciclo de vida desses objetos! alguém cria e passa pra ele.
  - logo, composição provavelmente não é o tipo de associação correta

## P1

- tudo ok

### Requisitos Funcionais
- [x] Adicionar filmes
- [x] Remover filmes
- [x] Listar filmes por ordem alfabética de título
- [x] Listar filmes por ordem alfabética de gênero
- [x] Listar filmes por ordem de lançamento
- [x] Buscar filmes de um ano

## P2

- informação duplicada:
  - objetos Cliente com atributo telefone armazenados em Mapa de telefone -> Cliente
  - o que acontece quando esses dois telefones discordam?
- como existe um Set de objetos Cliente, como o método Set.add() sabe que um Cliente já está presente na coleção?

### Requisitos Funcionais
- [x] Registrar dados de um cliente quando é sua primeira solicitação
- [x] Registrar novas solicitações vinculadas a um cliente
- [x] Listar os telefones dos clientes registrados
- [x] Imprimir o nome do próximo cliente
- [x] Atender o próximo cliente
- [x] Listar as idades dos clientes já atendidos
- [x] Listar os telefones dos clientes em espera