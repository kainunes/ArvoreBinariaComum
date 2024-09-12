public class No {

    String palavra;
    No direita;
    No esquerda;
    ListaSE linhas;
    int linha;
    public No (String palavra, int linha) {
        this.palavra = palavra;
        linhas=new ListaSE();
        this.linha=linha;
        linhas.inserirNoFim(new Celula(linha));
    }

    public void inserirLinha(int linha){
        linhas.inserirNoFim(new Celula(linha));
    }

}
