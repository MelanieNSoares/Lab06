public class Comum extends Peca {
  
  public Comum (int time){
    super(time);
  }
      
  public int verificaMovimento(int init_row, int init_col, int fin_col, int fin_row,Tabuleiro tabuleiro){
    verificaMovimento.super(int init_row, int init_col, int fin_col, int fin_row,Tabuleiro tabuleiro)
  }

  public void analisaMovimento(int init_row, int init_col, int fin_col, int fin_row,Tabuleiro tabuleiro){

    if(tabuleiro.vTabuleiro[init_row][init_col] != null){
      
      int foward = fin_row - init_row;
      int diagonal = fin_col - fin_row;

      if( (time == 1 && foward == -1) || (time == 0 && foward == 1) )/// verifica se o time e o movimento esta orientado corretamente{
        return 1; // movement fail;
        tabuleiro.setLance()
      }
            
      if( (foward == 1 || foward == -1) && ( diagonal == -1 || diagonal == 1 ) ){ /// verifica se ha movimento retrogado
        verificaMovimento();        
      }

        
    }
  }

}
