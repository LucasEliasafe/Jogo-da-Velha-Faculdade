public class Tabuleiro {
    private char [][] tabuleiro = {
            {'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'}
    };

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
    public boolean jogadaValida(int jogada) {
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
                return tabuleiro[1][3] == '7';
            case 8:
                return tabuleiro[2][0] == '8';
            case 9:
                return tabuleiro[2][1] == '9';
            default: return false;

        }
    }

    public void realizarJogada(int jogada, char simbolo) {
        switch (jogada) {

        }
    }



}
