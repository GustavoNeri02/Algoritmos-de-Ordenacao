import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    static long movimentos = 0;

    public static void main(String[] args){
        StringBuilder texto = new StringBuilder("[");

        //---Coloque aqui seu documento .txt (Ex: 2, 42, -23, 31) para ordená-lo---
        int[] vetor = leitura("C:\\Users\\Gustavo\\Desktop\\dadosb.txt");

        //---Inicio da contagem---
        long tempoInicial = System.currentTimeMillis();

        insertionSort(vetor);
        //selectionSort(vetor);
        //bubbleSort(vetor);
        //combSort(vetor);

        //---fim da contagem---
        long tempoFinal = System.currentTimeMillis();

        System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms");

        for (int i = 0; i < vetor.length; i++) {
            texto.append(vetor[i]);
            if (i == vetor.length - 1) {
                texto.append("]");
            } else {
                texto.append(", ");
            }
        }
        System.out.println(texto);
        System.out.println("Total de " + movimentos + " movimentos.");
    }

    public static int[] leitura(String arquivo) {

        Path pasta = Paths.get(arquivo);

        try{
            byte[] text = Files.readAllBytes(pasta);

            String[] ler = new String(text).split(", ");
            int[] vetor = new int[ler.length];

            for(int i = 0; i < ler.length; i++) {
                vetor[i] = Integer.parseInt(ler[i]);
            }

            return vetor;
        }

        catch(Exception erro){
            return null;
        }
    }


    public static void insertionSort(int[] vetor) {
        int j;
        int chave;
        int i;

        for (j = 1; j < vetor.length; j++) {
            chave = vetor[j];
            for (i = j - 1; (i >= 0) && (vetor[i] > chave); i--) {
                vetor[i + 1] = vetor[i];
                movimentos++;
            }
            vetor[i + 1] = chave;
        }
    }

    public static void selectionSort(int[] vetor) {
        for (int fixo = 0; fixo < vetor.length - 1; fixo++) {
            int menor = fixo;

            for (int i = menor + 1; i < vetor.length; i++) {
                if (vetor[i] < vetor[menor]) {
                    menor = i;
                    movimentos++;
                }
            }
            if (menor != fixo) {
                int t = vetor[fixo];
                vetor[fixo] = vetor[menor];
                vetor[menor] = t;
            }
        }
    }

    private static void bubbleSort(int[] vetor) {
        boolean troca = true;
        int aux;
        while (troca) {
            troca = false;
            for (int i = 0; i < vetor.length - 1; i++) {
                if (vetor[i] > vetor[i + 1]) {
                    aux = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = aux;
                    troca = true;
                    movimentos++;
                }
            }
        }
    }

    public static void combSort(int[] vetor) {
        int intervalo = (int) (vetor.length / 1.3);
        int indice = 0;

        while (intervalo > 0 && indice != vetor.length - 1) {
            indice = 0;
            while ((indice + intervalo) < vetor.length) {
                if (vetor[indice] > vetor[indice + intervalo]) {
                    int aux = vetor[indice];
                    vetor[indice] = vetor[indice + intervalo];
                    vetor[indice + intervalo] = aux;
                    movimentos++;
                }
                indice++;
            }
            intervalo = (int) (intervalo / 1.3);
        }
    }


}
