import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LeitorArquivo {
    private String diretorioArquivo;
    BufferedReader entradaDeDados;
    private StringTokenizer strK;
    private int linhaAtual;

    public LeitorArquivo(String diretorioArquivo) throws FileNotFoundException {

        this.diretorioArquivo = diretorioArquivo;
        this.entradaDeDados = new BufferedReader(new FileReader(diretorioArquivo));
        this.linhaAtual=0;

    }

    public String[] proximaLinha() {
        String[] linhaFatiada = null;
        try {
            String linha = entradaDeDados.readLine();
            if (linha != null) {
                linha = linha.toLowerCase();//deixar a linha inteira minusculo
                strK = new StringTokenizer(linha, " ,.?!:_-\"'");  //fatia a linha e remove caracteres
                int count = 0;
                linhaFatiada = new String[strK.countTokens()];
                while (strK.hasMoreTokens()) {
                    linhaFatiada[count] = strK.nextToken();
                    count++;
                }
            } else {
                entradaDeDados.close();
                strK = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        linhaAtual++;
        return linhaFatiada;
    }
    public ArrayList<No> getPalavrasLinha(){
        String[] palavras = proximaLinha();
        ArrayList<No> arrayNo = new ArrayList<>();
        if (palavras!=null) {
            for (String palavra : palavras) {
                if (palavra.length() >= 3 && palavra.length() <= 20) {
                    No no = new No(palavra, linhaAtual);
                    arrayNo.add(no);
                }
            }
        }else{
            arrayNo = null;
        }
        return arrayNo;
    }
}
