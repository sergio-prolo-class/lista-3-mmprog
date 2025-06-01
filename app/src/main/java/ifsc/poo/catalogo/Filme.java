package ifsc.poo.catalogo;

public class Filme {
    private String titulo;
    private int ano;
    private String genero;

    public Filme(String titulo, int ano, String genero) {
        this.titulo = titulo;
        this.ano = ano;
        this.genero = genero;
    }

    public String getTitulo() { return titulo; }
    public int getAno() { return ano; }
    public String getGenero() { return genero; }

    @Override
    public String toString() {
        return titulo + " (" + ano + ") - " + genero;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Filme filme = (Filme) obj;
        return ano == filme.ano && titulo.equals(filme.titulo);
    }

    @Override
    public int hashCode() {
        return titulo.hashCode() + ano;
    }
}