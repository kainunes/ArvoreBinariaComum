/**
 * Classe que representa uma árvore binária de busca.
 */
public class ArvoreBinaria {
    No raiz;

    /**
     * Construtor para inicializar uma árvore binária vazia.
     */
    public ArvoreBinaria() {
        raiz = null;
    }

    /**
     * Método privado para inserir um novo nó na árvore binária.
     *
     * @param novo   O novo nó a ser inserido.
     * @param atual  O nó atual onde a comparação é feita.
     * @return O nó atualizado após a inserção.
     */
    private No inserirNovo(No novo, No atual) {
        No aux;
        if (atual == null) {
            return novo;
        }
        if (atual.palavra.compareTo(novo.palavra) > 0) {
            atual.esquerda = inserirNovo(novo, atual.esquerda);
        } else if (atual.palavra.compareTo(novo.palavra) < 0) {
            atual.direita = inserirNovo(novo, atual.direita);
        } else {
            atual.inserirLinha(novo.linha);
        }
        return atual;
    }

    /**
     * Insere um novo nó na árvore binária.
     *
     * @param novo O nó a ser inserido.
     */
    public void inserir(No novo) {
        raiz = inserirNovo(novo, raiz);
    }

    /**
     * Método recursivo privado para imprimir as palavras em ordem.
     *
     * @param elemento O nó atual.
     */
    private void ordem(No elemento) {
        if (elemento != null) {
            ordem(elemento.esquerda);
            System.out.printf(elemento.palavra);
            elemento.linhas.imprimir();
            ordem(elemento.direita);
        }
    }

    /**
     * Imprime as palavras armazenadas na árvore em ordem.
     */
    public void imprimirOrdem() {
        ordem(raiz);
    }
}