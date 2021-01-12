import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;

import java.io.IOException;

public class main {
    static int movimentos = 0;

    public static void main(String[] args) throws IOException {
        String texto = "[";

        int[] vetor;
        vetor = new int[]{ };
        long tempoInicial = System.currentTimeMillis();

        insertionSort(vetor);
        //selectionSort(vetor);
        //bubbleSort(vetor);
        //combSort(vetor);

        long tempoFinal = System.currentTimeMillis();

        System.out.println("Executado em = " + (tempoFinal - tempoInicial) + " ms");

        for (int i = 0; i < vetor.length; i++) {
            texto += vetor[i];
            if (i == vetor.length - 1) {
                texto += "]";
            } else {
                texto += ", ";
            }
        }
        System.out.println(texto);
        System.out.println("Total de " + movimentos + " movimentos.");
    }

    public static void insertionSort(int[] vetor) {
        int j;
        int key;
        int i;

        for (j = 1; j < vetor.length; j++) {
            key = vetor[j];
            for (i = j - 1; (i >= 0) && (vetor[i] > key); i--) {
                vetor[i + 1] = vetor[i];
                movimentos++;
            }
            vetor[i + 1] = key;
        }
    }

    public static void selectionSort(int[] array) {
        for (int fixo = 0; fixo < array.length - 1; fixo++) {
            int menor = fixo;

            for (int i = menor + 1; i < array.length; i++) {
                if (array[i] < array[menor]) {
                    menor = i;
                    movimentos++;
                }
            }
            if (menor != fixo) {
                int t = array[fixo];
                array[fixo] = array[menor];
                array[menor] = t;
            }
        }
    }

    private static void bubbleSort(int vetor[]) {
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
