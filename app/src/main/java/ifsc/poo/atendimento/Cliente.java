package ifsc.poo.atendimento;

public class Cliente {
    private String nome;
    private int idade;
    private String telefone;

    public Cliente(String nome, int idade, String telefone) {
        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;
    }


    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    public String getTelefone() { return telefone; }

    @Override
    public String toString() {
        return nome + " (" + idade + " anos) - Tel: " + telefone;
    }
}