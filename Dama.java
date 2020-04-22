/*public class Dama extends Peca {
  
  public Dama (int time){
    super(time);
  }

  public int verificaMovimento(int init_row, int init_col, int fin_col, int fin_row,Tabuleiro tabuleiro){
    verificaMovimento.super(int init_row, int init_col, int fin_col, int fin_row,Tabuleiro tabuleiro)
  }

  public void analisaMovimento(int init_row, int init_col, int fin_col, int fin_row,Tabuleiro tabuleiro){

    if(tabuleiro.vTabuleiro[init_row][init_col] != null){
      
      int straight = fin_row - init_row;
      int diagonal = fin_col - fin_row;

      int i,j;
      if(straight < 0){
        i = -1;
        j= -1;

      }else {
        i = 1;
        j = 1;
      }

      
      while(Math.abs(i) <= Math.abs(straight) && Math.abs(j)<=abs(diagonal)){
        verificaMovimento(int init_row, int init_col,Tabuleiro tabuleiro,i,j)
        if(i>0){
          i = i + 1;
          j = j + 1;
        }
        else{
          i = i - 1;
          j = j - 1;

        }   
      }
        
    }
    
  return 1; //movement fail
  tabuleiro.setLance()
  }

} */