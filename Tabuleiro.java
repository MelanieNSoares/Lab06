public class Tabuleiro{
  Peca vTabuleiro[8][8];

  public void createTable(Peca peca, int linha, int coluna){
    vTabuleiro[linha][coluna] = peca;
  }
  
}
