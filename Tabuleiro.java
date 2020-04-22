public class Tabuleiro{
  public Peca vTabuleiro[][] = new Peca[8][8];

  private int lance;

  public void setLance(int lance){
    this.lance = lance; // 1 lance do time branco; 0 lance do time preto
  }

  public int getLance(){
    return lance;
  }

  public void createTable(Peca peca, int linha, int coluna){
    vTabuleiro[linha][coluna] = peca;
  }

  public void capture(int foward, int diagonal, int i, int j, int fator){
    vTabuleiro[i + foward][j+diagonal] = null;
    move(foward,diagonal,i,j,fator);
   
  }

  public void move(int foward, int diagonal, int i, int j,int fator){
    Peca pecaMovendo = vTabuleiro[i][j];
    vTabuleiro[i][j] = null;
    vTabuleiro[i + (fator * foward)][j+ (fator * diagonal)] = pecaMovendo;
    
  }
  
}
