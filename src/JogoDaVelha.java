import java.util.Scanner;

public class JogoDaVelha {
    private Tabuleiro tabuleiro;
    private Jogador jogadorAtual;
    private boolean jogoEmAndamento;

    public JogoDaVelha() {
        this.tabuleiro = new Tabuleiro();
        this.jogadorAtual = new Jogador('X');
        this.jogoEmAndamento = false;
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;


        while (continuar) {
            System.out.println("\nMENU do Jogo da Velha\n");
            System.out.println("1 - Iniciar novo Jogo\n");
            if (jogoEmAndamento) {
                System.out.println("2 - Continuar Jogo Atual");
            }
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    iniciar();
                    break;
                case 2:
                    if (jogoEmAndamento) {
                        continuarJogo();
                    } else {
                        System.out.println("Nenhum jogo em andamento. Escolha 'Iniciar novo Jogo'.");
                    }
                    break;
                case 3:
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
        tabuleiro.reiniciar();
        jogadorAtual = new Jogador('X');
        jogoEmAndamento = true;
        continuarJogo();
    }


    public void continuarJogo() {
        Scanner scanner = new Scanner(System.in);

        while (jogoEmAndamento) {
            tabuleiro.exibir();
            System.out.println("\nJogador " + jogadorAtual.getVelha() + ", escolha uma opção: \n");
            System.out.println("Digite 1-9 para fazer uma jogada");
            System.out.println("Digite 99 para voltar a última jogada");
            System.out.println("Digite 98 para sair ao menu");
            System.out.print("Escolha uma opção: ");

            int jogada = scanner.nextInt();

            if (jogada == 98) {
                System.out.println("Voltando ao menu...");
                return;
            } else if (jogada == 99) {
                if (tabuleiro.desfazerUltimaJogada()) {
                    System.out.println("Última jogada desfeita.");
                    jogadorAtual = Jogador.alternarJogador(jogadorAtual);
                } else {
                    System.out.println("Não há jogadas para desfazer.");
                }
            } else if (tabuleiro.jogadaPermitida(jogada)) {
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



    public static void main(String[] args) {
        JogoDaVelha jogo = new JogoDaVelha();
        jogo.mostrarMenu();
    }
}