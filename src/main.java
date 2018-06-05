import Dijkstra.Dijkstra;
import Elementos.Aresta;
import Elementos.Vertice;
import ListaAdj.ListaAdj;


import java.util.ArrayList;
import java.util.GregorianCalendar;

public class main {

    public static void main(String args[]) {
        ListaAdj lista = new ListaAdj();
        Dijkstra alg = new Dijkstra(lista.getLista());

        lista.addVertice(new Vertice(1, "A"));
        lista.addVertice(new Vertice(2, "B"));
        lista.addVertice(new Vertice(3, "C"));
        lista.addVertice(new Vertice(4, "D"));

        lista.addAresta(new Aresta(1, "Oliveira Paiva"),"A", "B");
        lista.addAresta(new Aresta(2, "Desembargador"),"A", "C");
        lista.addAresta(new Aresta(3, "Manuel"),"A", "D");

        lista.getLista().get(0).get(1).getAresta().setCongestionamento(2);
        lista.getLista().get(0).get(2).getAresta().setCongestionamento(4);
        lista.getLista().get(0).get(3).getAresta().setCongestionamento(1);

        System.out.println(alg.MenorCaminho("A",0));
    }

}
