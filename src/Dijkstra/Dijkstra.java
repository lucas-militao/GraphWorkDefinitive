package Dijkstra;

import Elementos.Vertice;
import ListaAdj.ListaAdj;

import java.util.ArrayList;
import java.util.List;

public class Dijkstra {

    private List<ArrayList<Vertice>> grafo;

    public Dijkstra(List<ArrayList<Vertice>> grafo) {
        this.grafo = grafo;
    }

    public int MenorCaminho (String v, int dist) { //função que retorna o menor caminho
        for (int i = 0; i < grafo.size(); i++) {
            if (grafo.get(i).get(0).getAresta() == null && grafo.get(i).get(0).getNome() == v) {
                if(grafo.get(i).size() > 1) {
                    int menor = dist;
                    for (int j = 1; j < grafo.get(i).size(); j++) {
                        if(dist == 0){
                            dist += grafo.get(i).get(j).getAresta().getCongestionamento();
                            continue;
                        } else {
                            if (dist > grafo.get(i).get(j).getAresta().getCongestionamento() + menor) {
                                dist = grafo.get(i).get(j).getAresta().getCongestionamento() + menor;
                            }
                        }
                    }
                    return dist;
                }
            }
        }
        return dist;
    }

    public void CaminhoMinimo () { //função que deve retorna o caminho mínimo

    }
}
