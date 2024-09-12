public class ArvoreBinaria {
    No raiz;
    public ArvoreBinaria(){ raiz = null; }
    private No inserirNovo(No novo, No atual) {
        No aux;
        if (atual == null) {
            return novo;
        }
        if (atual.palavra.compareTo(novo.palavra)>0) {
            atual.esquerda = inserirNovo(novo, atual.esquerda);
        } else if (atual.palavra.compareTo(novo.palavra)<0) {
            atual.direita = inserirNovo(novo, atual.direita);
        } else{
            atual.inserirLinha(novo.linha);
        }
        return atual;
    }
    public void inserir(No novo) {
        raiz = inserirNovo(novo, raiz);
    }

//    private No pesquisarNo (No atual, int valor) {
//        No aux = null;
//        if(atual == null) {
//            aux = null;
//        }
//        assert atual != null;
//        if(atual.valor == valor) {
//            aux = atual;
//        }
//        if(atual.valor < valor) {
//            pesquisarNo(atual.direita, valor);
//        }
//        if(atual.valor > valor) {
//            pesquisarNo(atual.esquerda, valor);
//        }
//        return aux;
//    }

//    public No pesquisar(int valor) {
//        return pesquisarNo(this.raiz, valor);
//    }
//    private void preordem(No elemento) {
//        if (elemento != null) {
//            System.out.println(elemento.valor);
//            preordem(elemento.esquerda);
//            preordem(elemento.direita);
//        }
//    }

//    public void imprimirPreordem() {
//        preordem(raiz);
//    }
    private void ordem(No elemento) {
        if (elemento != null) {
            ordem(elemento.esquerda);
            System.out.println(elemento.palavra);
            ordem(elemento.direita);
        }
    }

    public void imprimirOrdem() {
        ordem(raiz);
    }
//    private void posordem(No elemento) {
//        if (elemento != null) {
//            posordem(elemento.esquerda);
//            posordem(elemento.direita);
//            System.out.println(elemento.valor);
//        }
//    }
//
//    public void imprimirPosordem() {
//        posordem(raiz);
//    }

}
