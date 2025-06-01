package ifsc.poo.atendimento;

public class Solicitacao {
    private Cliente cliente;
    private String descricao;

    public Solicitacao(Cliente cliente, String descricao) {
        this.cliente = cliente;
        this.descricao = descricao;
    }


    public Cliente getCliente() { return cliente; }
    public String getDescricao() { return descricao; }

    @Override
    public String toString() {
        return cliente.getNome() + ": " + descricao;
    }
}