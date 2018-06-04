package Dijkstra;

import Dijkstra.Elementos.Grafo;
import Dijkstra.Elementos.VerticeStatus;
import Elementos.Vertice;
import ListaAdj.ListaAdj;

import java.util.ArrayList;

public class Dijkstra {

    private Grafo grafo;
    private String inicio;

    public Dijkstra (String inicio, Grafo grafo) {
        this.grafo = grafo;
        this.inicio = inicio;
    }

    public Grafo getGrafo() {
        return grafo;
    }

    public void setGrafo(Grafo grafo) {
        this.grafo = grafo;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public int menorCaminho (String v) {
        if (!grafo.getGrafo().isEmpty()) {

            for (int i = 0; i < grafo.getGrafo().size(); i++) {
                Vertice indice = grafo.getGrafo().get(i).get(0).getVertice();
                if(indice.getNome().equalsIgnoreCase(v)) {
                    if(v == inicio) {
                        grafo.getGrafo().get(i).get(0).setPeso(0);
                        grafo.getGrafo().get(i).get(0).setVisitado(true);
                        int menor = 0;
                        for (int j = 1; j < grafo.getGrafo().get(i).size(); j++) {
                            if(menor > grafo.getGrafo().get(i).get(j).getVertice().getAresta().getCongestionamento()) {
                                menor = grafo.getGrafo().get(i).get(j).getVertice().getAresta().getCongestionamento();
                                grafo.getGrafo().get(i).get(j).setVisitado(true);
                                grafo.getGrafo().get(i).get(j).setPeso(menor);
                            }
                        }
                        return menor;
                    }
                }
            }
        }


        return 0;
    }
}
