import java.util.Random;


public class App {
    static int[] tamanhosTesteGrande = {500_000}    ;
    static int[] tamanhosTesteMedio =   {  200_000}    ;
    static int[] tamanhosTestePequeno = {       3};
    static Random aleatorio = new Random(48);

    //original
    //static int[] tamanhosTesteGrande =  { 125_000, 250_000, 500_000, 1_000_000, 2_000_000 };
    //static int[] tamanhosTesteMedio =   {  12_500,  25_000,  50_000,   100_000,   200_000 };
    //static int[] tamanhosTestePequeno = {       3,       6,      12,        24,        48 };
    //static Random aleatorio = new Random(42);

    /**
     * Código de teste 1. Este método...
     * @param vetor Vetor com dados para teste.
     * @return Uma resposta que significa....
     */

    static int operacoes;

    
    static int codigo1(int[] vetor) {
        operacoes = 0;
        int resposta = 0;
        for (int i = 0; i < vetor.length; i += 2) {
            resposta += vetor[i]%2;
            operacoes++;
        }
        return resposta;
    }

    /** length tamanho do vetoor */
    /** O método codigo1 percorre um vetor de 2 em 2 (índices pares) e 
    * conta quantos desses elementos são ímpares, usando o operador % para verificar a paridade. Ele retorna a quantidade de ímpares encontrados e conta o número de operações realizadas.*/


    /**
     * Código de teste 2. Este método...
     * @param vetor Vetor com dados para teste.
     * @return Uma resposta que significa....
     */

    static int codigo2(int[] vetor) {
        int contador = 0;
        operacoes = 0;
        for (int k = (vetor.length - 1); k > 0; k /= 2) {
            for (int i = 0; i <= k; i++) {
                contador++;
                operacoes++;
            }

        }
        return contador;
    }
    //pedir pedro explicação pq n entendi bulhufas
    //Loops aninhados com redução pela metade.


    /**
     * Código de teste 3. Este método...
     * @param vetor Vetor com dados para teste.
     */

    static void codigo3(int[] vetor) {
        operacoes = 0;
        for (int i = 0; i < vetor.length - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[j] < vetor[menor])
                    menor = j;
            }
            int temp = vetor[i];
            vetor[i] = vetor[menor];
            vetor[menor] = temp;
            operacoes++;
        }
    }
    //Algoritmo de ordenação Selection Sort

    /**
     * Código de teste 4 (recursivo). Este método...
     * @param n Ponto inicial do algoritmo
     * @return Um inteiro que significa...
     */
    static int codigo4(int n) {
        operacoes++;
        if (n <= 2)
            return 1;
        else
            return codigo4(n - 1) + codigo4(n - 2);
    }
    //Recursão para cálculo de Fibonacci.


    /**
     * Gerador de vetores aleatórios de tamanho pré-definido. 
     * @param tamanho Tamanho do vetor a ser criado.
     * @return Vetor com dados aleatórios, com valores entre 1 e (tamanho/2), desordenado.
     */
    static int[] gerarVetor(int tamanho){
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = aleatorio.nextInt(1, tamanho/2);
        }
        return vetor;
        
    }


    public static void main(String[] args) {
        for (int n : tamanhosTestePequeno) {
            // Reiniciar o contador de operações
            operacoes = 0;
    
            // Medir o tempo inicial
            long tempoInicial = System.currentTimeMillis();
    
            // Executar o código 4
            int resultado = codigo4(tamanhosTestePequeno[0]);
    
            // Medir o tempo final e calcular o tempo gasto
            long tempoFinal = System.currentTimeMillis();
            long tempoGasto = tempoFinal - tempoInicial;
    
            // Exibir resultados
            System.out.println("n: " + n);
            System.out.println("Resultado: " + resultado);
            System.out.println("Operações: " + operacoes);
            System.out.println("Tempo gasto: " + tempoGasto + " ms");
            System.out.println("--------------------------");
        }
    }
}
