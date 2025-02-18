import java.util.Scanner;

public class Esercizio {
    private static Random random = new Random();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int n, i, j, n1;
        boolean trovato;

        do {
            n = input.nextInt();
        } while (n <= 0);
        n1 = 0;
        int[] v = new int[n * 25];

        i = 0;
        do {
            trovato = false;
            n1 = inserisci(v, n1, n1, random.nextInt(8) + 3 * 10);
            j = 0;
            while (j < n1) {
                if (v[n1 - 1] > v[j]) {
                    n1 = elimina(v, j, n1);
                    trovato = true;
                }
                j = j + 1;
            }
            i = i + 1;
            System.out.println("Stanno bevenedo: " + n1 + " animali");
        } while (i < n);
        n1 = rimuoviDuplicati(v, n1);
        visualizza(v, n1);
    }
    
    public static int elimina(int[] v, int ie, int n) {
        int i, n2;

        n2 = n - 1;
        i = ie;
        while (i <= n - 2) {
            v[i] = v[i + 1];
            i = i + 1;
        }
        
        return n2;
    }
    
    public static int inserisci(int[] v, int n, int ie, int e) {
        int i, n2;

        n2 = n + 1;
        i = n2 - 1;
        while (i >= ie + 1) {
            v[i] = v[i - 1];
            i = i - 1;
        }
        v[ie] = e;
        
        return n2;
    }
    
    public static int rimuoviDuplicati(int[] v, int n) {
        int i, j;

        i = 0;
        while (i <= n - 2) {
            j = i + 1;
            while (j <= n - 1) {
                if (v[i] == v[j]) {
                    System.out.println("Elimino " + v[j] + " da cella " + j);
                    n = eliminaVettore(v, j, n);
                } else {
                    j = j + 1;
                }
            }
            i = i + 1;
        }
        
        return n;
    }
    
    public static void visualizza(int[] v, int n) {
        int i;

        i = 0;
        while (i < n) {
            System.out.println(Integer.toString(i) + ": " + v[i]);
            i = i + 1;
        }
    }
}