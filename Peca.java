public class Peca{

  protected int time; // 1 eh time branco, 0 eh time preto

  public Peca(int time){
    this.time = time;
  } 

  public int verificaMovimento(int init_row, int init_col,Tabuleiro tabuleiro, int foward, int diagonal){
    
    if(tabuleiro.vTabuleiro[init_row + foward][init_col + diagonal] != null){
            
      if( (tabuleiro.vTabuleiro[init_row + foward][init_col + diagonal].time != time) && (tabuleiro.vTabuleiro[init_row + foward+foward][init_col + diagonal+diagonal] == null) ){ // se a peca vizinha eh do time oposto e se ha espacao vazio atras

        tabuleiro.capture(foward,diagonal,init_row,init_col,2);
          return 0; /// movement success
        }

    }

    else{
      tabuleiro.move(foward,diagonal,init_row,init_col,1);/// espaco vazio portando pode se mover
      tabuleiro.setLance()
      return 0;/// movement successs
    }
    
  }

  
return 1;
} 
