import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<No> palavras = new ArrayList<>();
        LeitorArquivo leitor = new LeitorArquivo("M:\\Usuarios\\0079504\\IdeaProjects\\TP4-ArvoreBinaria\\src\\brasil.txt");
        ArvoreBinaria arvore = new ArvoreBinaria();
        while ((palavras = leitor.getPalavrasLinha())!= null){
            for (No palavra: palavras){
                arvore.inserir(palavra);
            }
        }
        arvore.imprimirOrdem();
    }
}