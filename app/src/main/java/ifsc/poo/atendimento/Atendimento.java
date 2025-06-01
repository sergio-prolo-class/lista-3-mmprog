package ifsc.poo.atendimento;

import java.util.*;
import java.util.stream.Collectors;

public class Atendimento {
    private Map<String, Cliente> clientes = new HashMap<>();
    private Queue<Solicitacao> fila = new LinkedList<>();
    private Set<Cliente> atendidos = new HashSet<>();

    public void registrarCliente(Cliente cliente, String descricao) {
        clientes.putIfAbsent(cliente.getTelefone(), cliente);
        fila.add(new Solicitacao(cliente, descricao));
    }

    public void adicionarSolicitacao(String telefone, String descricao) {
        Cliente cliente = clientes.get(telefone);
        if (cliente != null) {
            fila.add(new Solicitacao(cliente, descricao));
        }
    }

    public List<String> listarTelefonesClientes() {
        return new ArrayList<>(clientes.keySet());
    }

    public String proximoCliente() {
        return fila.isEmpty() ? "Nenhum cliente na fila" : fila.peek().getCliente().getNome();
    }

    public Solicitacao atenderProxima() {
        if (fila.isEmpty()) return null;

        Solicitacao solicitacao = fila.poll();
        atendidos.add(solicitacao.getCliente());
        return solicitacao;
    }

    public List<Integer> listarIdadesAtendidos() {
        return atendidos.stream()
                .map(Cliente::getIdade)
                .collect(Collectors.toList());
    }

    public List<String> listarTelefonesEspera() {
        return fila.stream()
                .map(s -> s.getCliente().getTelefone())
                .distinct()
                .collect(Collectors.toList());
    }
}