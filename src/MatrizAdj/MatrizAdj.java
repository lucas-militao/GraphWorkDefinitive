package MatrizAdj;

import MatrizAdj.Elementos.Aresta;
import MatrizAdj.Elementos.ArestaStatus;
import MatrizAdj.Elementos.Vertice;

import java.util.ArrayList;
import java.util.List;

public class MatrizAdj {

    ArrayList<Vertice> vertList;
    ArestaStatus[][] matriz;

    public MatrizAdj () {
        vertList = new ArrayList<Vertice>();
        matriz = null;
    }



    public void addVertice (Vertice vertice) {
        if(!vertList.isEmpty()) {

            ArestaStatus[][] matrizIndice = new ArestaStatus[vertList.size() + 1][vertList.size() + 1];

            for (int i = 0; i < vertList.size() + 1; i++) {
                for (int j = 0; j < vertList.size() + 1; j++) {
                    if(i < vertList.size() && j < vertList.size()) {
                        matrizIndice[i][j] = matriz[i][j];
                    } else {
                        matrizIndice[i][j] = new ArestaStatus();
                    }
                }
            }

            vertList.add(vertice);
            matriz = matrizIndice;

        } else {
            vertList.add(vertice);
            matriz = new ArestaStatus[vertList.size()][vertList.size()];
            matriz[0][0] = new ArestaStatus();
        }
    }

    public void removerVertice(String remover) {
        if(!vertList.isEmpty()) {

            Vertice removido = null;

            for (int i = 0; i < vertList.size(); i++) {
                if(vertList.get(i).getNome().equalsIgnoreCase(remover)) {
                    removido = vertList.get(i);
                    if(i < vertList.size() - 1) {
                        for (int j = i; j < vertList.size() - 1; j++) {
                            for (int k = i; k < vertList.size() - 1; k++) {
                                matriz[j][k] = matriz[j + 1][k + 1];
                            }
                        }
                        vertList.remove(i);
                    } else {
                        for (int j = 0; j < vertList.size() - 1; j++) {
                            for (int k = 0; k <vertList.size() - 1; k++) {
                                matriz[j][k] = matriz[j + 1][k + 1];
                            }
                        }
                        vertList.remove(i);
                    }
                    break;
                }
            }

            if(remover != null) {
                ArestaStatus[][] matrizIndice = new ArestaStatus[vertList.size()][vertList.size()];
                for (int i = 0; i < vertList.size(); i++) {
                    for (int j = 0; j < vertList.size(); j++) {
                        matrizIndice[i][j] = matriz[i][j];
                    }
                }

                matriz = matrizIndice;
                System.out.println("Vertice: " + remover + " removido.");
            } else {
                System.out.println("Não encontrado.");
            }

        } else {
            System.out.println("Matriz vazia!");
        }
    }

    public void addAresta (Aresta aresta, String origem, String destino) {
        if(!vertList.isEmpty()) {
            for (int i = 0; i < vertList.size(); i++) {
                if(vertList.get(i).getNome().equalsIgnoreCase(origem)) {
                    for (int j = 0; j < vertList.size(); j++) {
                        if(vertList.get(j).getNome().equalsIgnoreCase(destino)) {
                            vertList.get(i).setAresta(aresta);
                            matriz[i][j].setAresta(aresta);
                            matriz[i][j].setStatus(true);
                            break;
                        }
                    }
                    break;
                }
            }
        } else {
            System.out.println("Matriz vazia!");
        }

    }

    public void removerAresta(String origem, String destino) {
        if(!vertList.isEmpty()) {
            for (int i = 0; i < vertList.size(); i++) {
                if(vertList.get(i).getNome().equalsIgnoreCase(origem)) {
                    for (int j = 0; j < vertList.size(); j++) {
                        if (vertList.get(j).getNome().equalsIgnoreCase(destino)) {
                            vertList.get(i).setAresta(null);
                            matriz[i][j].setAresta(null);
                            matriz[i][j].setStatus(false);
                            break;
                        }
                    }
                    break;
                }
            }
        } else {
            System.out.println("Matriz vazia!");
        }
    }

    public void imprimirMatriz() {
        if(!vertList.isEmpty()) {

            for (int i = 0; i < vertList.size(); i++) {
                System.out.print("\t" + vertList.get(i).getNome());
            }

            System.out.println("");

            for (int i = 0; i < vertList.size(); i++) {
                System.out.print(vertList.get(i).getNome() + "\t");
                for (int j = 0; j < vertList.size(); j++) {
                    if (i != j) {
                        if(matriz[i][j].getStatus()) {
                            System.out.print("1\t");
                        } else {
                            System.out.print("0\t");
                        }
                    } else {
                        System.out.print("0\t");
                    }
                }
                System.out.println("");
            }
        } else {
            System.out.println("Matriz vazia!");
        }
    }
}
