import ListaAdj.ListaAdj;
import MatrizAdj.Elementos.Aresta;
import MatrizAdj.Elementos.Vertice;
import MatrizAdj.MatrizAdj;

public class main {

    public static void main(String args[]) {
        ListaAdj lista = new ListaAdj();
        MatrizAdj matriz = new MatrizAdj();

        matriz.addVertice(new Vertice(1, "A"));
        matriz.addVertice(new Vertice(2, "B"));
        matriz.addVertice(new Vertice(3, "C"));

        matriz.addAresta(new Aresta(1, "Oliveria paiva"), "A", "B");
        matriz.addAresta(new Aresta(2, "Desembargador Gonzaga"), "A", "C");

        matriz.removerAresta("A", "B");

        matriz.imprimirMatriz();
    }

}
