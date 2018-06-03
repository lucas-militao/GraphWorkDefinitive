package MatrizAdj.Elementos;

public class Vertice {

    private int id;
    private String nome;
    private Aresta aresta;

    public Vertice(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.aresta = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Aresta getAresta() {
        return aresta;
    }

    public void setAresta(Aresta aresta) {
        this.aresta = aresta;
    }
}
