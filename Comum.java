public class Comum extends Peca {
  
  public Comum (int time){
    super(time);
  }
      
  public int verificaMovimento(int init_row, int init_col, int fin_col, int fin_row,Tabuleiro tabuleiro){

    if(tabuleiro.vTabuleiro[init_row][init_col] != null){
      int foward = fin_row - init_row;
      int diagonal = fin_col - fin_row;

      if( (time == 1 && foward == -1) || (time == 0 && foward == 1) ){
        return 1; // movement fail
      }
            
      if( (foward == 1 || foward == -1) && ( (diagonal == -1) || (diagonal == 1) ) ){
                
        if(tabuleiro.vTabuleiro[init_row + foward][init_col + diagonal] != null){
            
          if( (tabuleiro.vTabuleiro[init_row + foward][init_col + diagonal].time != time) && (tabuleiro.vTabuleiro[init_row + foward+foward][init_col + diagonal+diagonal] == null) ){

            tabuleiro.capture(foward,diagonal,init_row,init_col,2);
            return 0; /// movement success
          }

        }

        else{
          tabuleiro.move(foward,diagonal,init_row,init_col,1);
          return 0;/// movement successs
        }
                
      }

        
    }
    
  }
  
  return 1; //movement fail
}