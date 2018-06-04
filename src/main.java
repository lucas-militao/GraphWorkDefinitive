import Dijkstra.Dijkstra;
import Dijkstra.Elementos.Grafo;
import Elementos.Aresta;
import Elementos.Vertice;
import ListaAdj.ListaAdj;


import java.util.ArrayList;
import java.util.GregorianCalendar;

public class main {

    public static void main(String args[]) {
        ListaAdj lista = new ListaAdj();
        Grafo grafo = new Grafo();
        Dijkstra algoritmo = new Dijkstra("A", grafo);

        lista.addVertice(new Vertice(1, "A"));
        lista.addVertice(new Vertice(2, "B"));
        lista.addVertice(new Vertice(3, "C"));

        lista.addAresta(new Aresta(1, "Oliveira Paiva"),"A", "B");
        lista.addAresta(new Aresta(2, "Desembargador"),"A", "C");

        lista.getLista().get(0).get(1).getAresta().setCongestionamento(2);
        lista.getLista().get(0).get(2).getAresta().setCongestionamento(4);

        grafo.updateGrafo(lista);

        lista.printLista();

        System.out.println("");

        grafo.imprimirGrafo();

        System.out.println(algoritmo.menorCaminho("A"));
    }

}
