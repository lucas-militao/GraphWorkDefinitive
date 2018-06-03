package ListaAdj;

import ListaAdj.Elementos.Aresta;
import ListaAdj.Elementos.Vertice;

import java.util.ArrayList;
import java.util.List;

public class ListaAdj {

    private List<ArrayList<Vertice>> lista;

    public ListaAdj () {
        this.lista = new ArrayList<ArrayList<Vertice>>();
    }

    public List<ArrayList<Vertice>> getLista() {
        return lista;
    }

    public void setLista(List<ArrayList<Vertice>> lista) {
        this.lista = lista;
    }

    public void addVertice (Vertice vertice) {
        ArrayList<Vertice> newV = new ArrayList<Vertice>();
        newV.add(vertice);
        lista.add(newV);
    }

    public void removerVertice (String nome) {
        if(!lista.isEmpty()) {

            Vertice removido = null;

            for (int i = 0; i < lista.size(); i++) {
                if(lista.get(i).get(0).getNome().equalsIgnoreCase(nome)) {
                    removido = lista.get(i).get(0);
                    lista.remove(lista.get(i));

                    for (int j = 0; j < lista.size(); j++) {
                        for (int k = 0; k < lista.get(j).size(); k++) {
                          if(lista.get(j).get(k).getNome().equalsIgnoreCase(nome)) {
                              lista.get(j).remove(lista.get(j).get(k));
                          }
                        }
                    }
                    break;
                }
            }

            if(removido != null) {
                System.out.println("Vertice " + nome + " removido.");
            } else {
                System.out.println("Não encontrado!");
            }
        } else {
            System.out.println("Lista vazia!");
        }
    }

    public void addAresta (Aresta aresta, String origem, String destino) {
        if(!lista.isEmpty()) {
            for (int i = 0; i < lista.size(); i++) {
                if(lista.get(i).get(0).getNome().equalsIgnoreCase(origem)) {
                    for (int j = 0; j < lista.size(); j++) {
                        if(lista.get(j).get(0).getNome().equalsIgnoreCase(destino)) {
                            lista.get(i).add(lista.get(j).get(0));
                            lista.get(i).get(0).setAresta(aresta);
                        }
                    }
                }
            }
        } else {
            System.out.println("Lista vazia!");
        }
    }

    public void removerAresta (String origem, String destino) {
        if(!lista.isEmpty()) {

            Aresta removido = null;

            for (int i = 0; i < lista.size(); i++) {
                if(lista.get(i).get(0).getNome().equalsIgnoreCase(origem)) {
                    for (int j = 0; j < lista.get(i).size(); j++) {
                        if (lista.get(i).get(j).getNome().equalsIgnoreCase(destino)) {
                            removido = lista.get(i).get(0).getAresta();
                            lista.get(i).remove(lista.get(i).get(j));
                            lista.get(i).get(0).setAresta(null);
                        }
                    }
                }
            }

            if(removido != null) {
                System.out.println("Rua " + removido.getId() + " removida.");
            } else {
                System.out.println("Não encontrado!");
            }
        } else {
            System.out.println("Lista vazia!");
        }
    }

    public void procurarVertById (int id) {
        if (!lista.isEmpty()) {
            for (int i = 0; i < lista.size(); i++) {
                if(lista.get(i).get(0).getId() == id) {
                    System.out.println(lista.get(i).get(0).getId() + ": " + lista.get(i).get(0).getNome() + ". Rua: " + lista.get(i).get(0).getAresta().getRua());
                }
            }
        } else {
            System.out.println("Lista Vazia!");
        }
    }

    public void procurarAresById (int id) {
        if(!lista.isEmpty()) {
            for (int i = 0; i < lista.size(); i++) {
                Aresta a = null;
                for (int j = 0; j < lista.get(i).size(); j++) {
                    if(lista.get(i).get(j).getAresta().getId() == id) {
                        a = lista.get(i).get(j).getAresta();
                        System.out.println(a.getId() + ": " + a.getRua() + ". Congestionamento: " + a.getCongestionamento());
                        break;
                    }
                }
                if(a != null) {
                    break;
                }
            }
        } else {
            System.out.println("Lista vazia!");
        }
    }

    public void printLista () {
        if(!lista.isEmpty()) {
            for (int i = 0; i < lista.size(); i++) {
                for (int j = 0; j < lista.get(i).size(); j++) {
                    if(j < lista.get(i).size() - 1) {
                        System.out.print(lista.get(i).get(j).getNome() + " -> ");
                    } else {
                        System.out.println(lista.get(i).get(j).getNome());
                    }
                }
            }
        } else {
            System.out.println("Lista vazia!");
        }
    }
}
