public class Tabuleiro {
    private char [][] tabuleiro = {
            {'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'}
    };

    private Stack<Integer> historicoJogadas = new Stack<>();

    public void exibir() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean jogadaPermitida(int jogada) {
        switch (jogada) {

            case 1:
                return tabuleiro[0][0] == '1';
            case 2:
                return tabuleiro[0][1] == '2';
            case 3:
                return tabuleiro[0][2] == '3';
            case 4:
                return tabuleiro[1][0] == '4';
            case 5:
                return tabuleiro[1][1] == '5';
            case 6:
                return tabuleiro[1][2] == '6';
            case 7:
                return tabuleiro[2][0] == '7';
            case 8:
                return tabuleiro[2][1] == '8';
            case 9:
                return tabuleiro[2][2] == '9';
            default:
                return false;

        }
    }

    public void realizar(int jogada, char velha) {
        switch (jogada) {
            case 1:
                tabuleiro[0][0] = velha;
                break;
            case 2:
                tabuleiro[0][1] = velha;
                break;
            case 3:
                tabuleiro[0][2] = velha;
                break;
            case 4:
                tabuleiro[1][0] = velha;
                break;
            case 5:
                tabuleiro[1][1] = velha;
                break;
            case 6:
                tabuleiro[1][2] = velha;
                break;
            case 7:
                tabuleiro[2][0] = velha;
                break;
            case 8:
                tabuleiro[2][1] = velha;
                break;
            case 9:
                tabuleiro[2][2] = velha;
                break;

            }
        historicoJogadas.push(jogada);
        }

    public boolean verificar() {
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][1] == tabuleiro[i][2]) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[1][i] == tabuleiro[2][i]) {
                return true;
            }
        }

        if (tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2]) {
            return true;
        }
        if (tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0]) {
            return true;
        }
        return false;
    }

    public boolean tabuleirocompleto(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] != 'X' && tabuleiro[i][j] != 'O') {
                    return false;
                }
            }
        }
        return true;
    }

    public void reiniciar() {
        tabuleiro = new char[][] {
                {'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8', '9'}
        };
    }
}
