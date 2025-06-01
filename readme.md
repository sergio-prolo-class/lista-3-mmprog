 /* PROGRAMAÇÃO ORIENTADA A OBJETOS
PROFESSOR: SERGIO MAURÍCIO PROLO SANTOS JUNIOR
ALUNOS: MARIA EDUARDA TELEMBERG, MARCUS JHUAN EPIFANIO LIMA

Laboratorio 3
# Lista 3: Programação Orientada a Objetos - Diagramas de Classe

## Sistema de Catálogo de Filmes 

O prorama possui 3 pacotes
Atendimento = Referente a fila de Atendimento 



Catalogo = Referente aos catalogos do filme 



App = o aplicativo que une ambos */

```mermaid
classDiagram
    class Atendimento {
        -clientes : Map~String, Cliente~
        -fila : Queue~Solicitacao~
        -atendidos : Set~Cliente~
        +registrarCliente(Cliente, String) void
        +adicionarSolicitacao(String, String) void
        +listarTelefonesClientes() List~String~
        +proximoCliente() String
        +atenderProxima() Solicitacao
        +listarIdadesAtendidos() List~Integer~
        +listarTelefonesEspera() List~String~
    }

    class Cliente {
        -nome : String
        -idade : int
        -telefone : String
        +Cliente(String, int, String)
        +getNome() String
        +getIdade() int
        +getTelefone() String
    }

    class Solicitacao {
        -cliente : Cliente
        -descricao : String
        +Solicitacao(Cliente, String)
        +getCliente() Cliente
        +getDescricao() String
    }
    
    Atendimento "1" *-- "0..*" Cliente : gerencia
    Atendimento "1" *-- "0..*" Solicitacao : gerencia
    Solicitacao "1" *-- "1" Cliente : associado
  

  
    class CatalogoFilmes {
        -filmes: Set~Filme~
        +adicionarFilme(Filme filme) boolean
        +removerFilme(Filme filme) boolean
        +listarPorTitulo() List~Filme~
        +listarPorGenero() List~Filme~
        +listarPorAno() List~Filme~
        +buscarPorAno(int ano) List~Filme~
    }

    class Filme {
        -titulo: String
        -ano: int
        -genero: String
        +Filme(String titulo, int ano, String genero)
        +getTitulo() String
        +getAno() int
        +getGenero() String
        +equals(Object obj) boolean
        +hashCode() int
        +toString() String
    }

    CatalogoFilmes "1" *-- "*" Filme : contém
