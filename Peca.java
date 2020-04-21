public class Peca{

  int time; // 1 eh time branco, 0 eh time vermelho


  //f4:d4
  public void verificaMovimento(int init_row, int init_col){
    
    
     
     
  }

  public class Dama extends Peca{
    super(time);
  }
    
  public class Comum extends Peca{
    super(time);
      
      public void verificaMovimento(int init_row, int init_col, int fin_col, int fin_row){
        if(Tabuleiro.vTabuleiro[init_row][init_col] != null){
            
            int foward = fin_row - init_row;
            int diagonal = fin_col - fin_row;
            
            if((foward == 1) && ((diagonal == -1) || (diagonal == 1))){
                
                if(Tabuleiro.vTabuleiro[init_row + foward][init_col + diagonal] != null){
                    if((Tabuleiro.vTabuleiro[init_row + foward][init_col + diagonal].time != time) && (Tabuleiro.vTabuleiro[init_row + foward+foward][init_col + diagonal+diagonal] == null){
                        capture()
                    }
                else{
                    move();
                }
             }
                
        }
      }
  }

} 
