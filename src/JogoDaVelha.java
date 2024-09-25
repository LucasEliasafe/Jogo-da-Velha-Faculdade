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

            switch (opcao) {
                case 1:
                    iniciar();
                    break;
                case 2:
                    continuar = false;
                    System.out.println("Saindo do jogo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
        scanner.close();
    }

    public void iniciar() {
        boolean jogoEmAndamento = true;
        Scanner scanner = new Scanner(System.in);

        while (jogoEmAndamento) {
            tabuleiro.exibir();
            System.out.println("Jogador " + jogadorAtual.getVelha() + ", escolha um número (1-9): ");
            int jogada = scanner.nextInt();

            if (tabuleiro.jogadaPermitida(jogada)) {
                tabuleiro.realizar(jogada, jogadorAtual.getVelha());
                if (tabuleiro.verificar()) {
                    tabuleiro.exibir();
                    System.out.println("Jogador " + jogadorAtual.getVelha() + " venceu!");
                    jogoEmAndamento = false;
                } else if (tabuleiro.tabuleirocompleto()) {
                    tabuleiro.exibir();
                    System.out.println("Empate!");
                    jogoEmAndamento = false;
                } else {
                    jogadorAtual = Jogador.alternarJogador(jogadorAtual);
                }
            } else {
                System.out.println("Jogada inválida, tente novamente.");
            }
        }
    }



}