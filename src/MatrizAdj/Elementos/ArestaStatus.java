package MatrizAdj.Elementos;

public class ArestaStatus {

    private Aresta aresta;
    private Boolean status;

    public ArestaStatus () {
        this.aresta = null;
        status = false;
    }

    public Aresta getAresta() {
        return aresta;
    }

    public void setAresta(Aresta aresta) {
        this.aresta = aresta;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
