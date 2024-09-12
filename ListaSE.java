public class ListaSE {

    private Celula primeiro;
    private int comprimento;

    public ListaSE(){
        primeiro = null;
        comprimento = 0;
    }

    public boolean estaVazia() {
        return (primeiro == null);
    }

    public void imprimir() {
        Celula aux = primeiro;
        while (aux != null) {
            System.out.println("Valor = " + aux.linha);
            aux = aux.proximo;
        }
    }

    public int getComprimento(){
        return comprimento;
    }

    public void inserirNoInicio(Celula celula) {
        celula.proximo = primeiro;
        primeiro = celula;
        comprimento++;
    }

    public void inserirNoFim(Celula celula) {
        if (estaVazia()) {
            primeiro = celula;
        } else {
            Celula aux = primeiro;
            while (aux.proximo != null) {
                aux = aux.proximo;
            }
            aux.proximo = celula;
        }
        comprimento++;
    }

    public Celula pesquisar(int valor) {
        Celula aux;
        if (estaVazia()) {
            aux = null;
        } else {
            aux = primeiro;
            while (aux != null && aux.linha != valor) {
                aux = aux.proximo;
            }
        }
        return aux;
    }

    // metodo para inserir elementos ordenadamente

    // metodos removerInicio e removerFinal (usando aux.prox.prox)

    public void removerInicio() {
        Celula aux = primeiro;
        if (!estaVazia()) {
            if (aux.proximo == null) {
                primeiro = null;
            } else {
                primeiro = aux.proximo;
            }
        }
        comprimento--;
    }

    public void removerFinal() {
        Celula aux = primeiro;
        if (!estaVazia()) {
            if (aux.proximo == null) {
                primeiro = null;
            } else {
                while (aux.proximo.proximo != null) {
                    aux = aux.proximo;
                }
                aux.proximo = null;
            }
        }
        comprimento--;
    }

    public void inserirOrdenado(Celula celula) {
        Celula proximaCelula = primeiro;
        if (!estaVazia()) {
            if (celula.linha < proximaCelula.linha) {
                celula.proximo = proximaCelula;
                primeiro = celula;
            } else {
                Celula tweetAnterior = primeiro;
                proximaCelula = proximaCelula.proximo;
                while (proximaCelula != null) {
                    if (celula.linha > proximaCelula.linha) {
                        tweetAnterior = proximaCelula;
                        proximaCelula = proximaCelula.proximo;
                    } else {
                        break;
                    }
                }
                tweetAnterior.proximo = celula;
                celula.proximo = proximaCelula;
            }
        } else {
            primeiro = celula;
        }
        comprimento++;
    }

}
