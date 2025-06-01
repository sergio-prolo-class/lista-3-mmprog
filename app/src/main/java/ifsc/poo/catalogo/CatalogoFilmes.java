package ifsc.poo.catalogo;

import java.util.*;
import java.util.stream.Collectors;

public class CatalogoFilmes {
    private Set<Filme> filmes = new HashSet<>();

    public boolean adicionarFilme(Filme filme) {
        return filmes.add(filme);
    }

    public boolean removerFilme(Filme filme) {
        return filmes.remove(filme);
    }

    public List<Filme> listarPorTitulo() {
        return filmes.stream()
                .sorted(Comparator.comparing(Filme::getTitulo))
                .collect(Collectors.toList());
    }

    public List<Filme> listarPorGenero() {
        return filmes.stream()
                .sorted(Comparator.comparing(Filme::getGenero))
                .collect(Collectors.toList());
    }

    public List<Filme> listarPorAno() {
        return filmes.stream()
                .sorted(Comparator.comparingInt(Filme::getAno))
                .collect(Collectors.toList());
    }

    public List<Filme> buscarPorAno(int ano) {
        return filmes.stream()
                .filter(f -> f.getAno() == ano)
                .sorted(Comparator.comparing(Filme::getTitulo))
                .collect(Collectors.toList());
    }
}