import java.util.Scanner;

public class JogoDaVelha {
    private Tabuleiro tabuleiro;
    private Jogador jogadorAtual;

    public JogoDaVelha() {
        this.tabuleiro = new Tabuleiro();
        this.jogadorAtual = new Jogador('X');
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;


        while (continuar) {
            System.out.println("\nMENU do Jogo da Velha\n");
            System.out.println("1 - Iniciar novo Jogo\n");
            System.out.println("2 - Sair\n");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
        }
    }
}