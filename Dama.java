public class Dama extends Peca {
  
  public Dama (int time){
    super(time);
  }

  public void analisaMovimento(int init_row, int init_col, int fin_col, int fin_row,Tabuleiro tabuleiro){

    int straight = fin_row - init_row;
    int diagonal = fin_col - init_col;

    if(Math.abs(straight) != Math.abs(diagonal)){
       tabuleiro.setLance(tabuleiro.vTabuleiro[init_row][init_col].time * -1);
      return; /// movement fail can only move diagonally
    }

    int i= straight / Math.abs(straight), 
    j = diagonal / Math.abs(diagonal);
    boolean possible = false;

    if(tabuleiro.vTabuleiro[fin_row][fin_col] == null){


      possible = true;

      while(possible && Math.abs(i) < Math.abs(straight) ){
  

        if(tabuleiro.vTabuleiro[init_row + i][init_col+j] != null && tabuleiro.vTabuleiro[init_row + i][init_col+j].time == time){
          possible = false;


        }
        i = (Math.abs(i) + 1 )*(i/Math.abs(i));
        j = (Math.abs(j) + 1 )*(j/Math.abs(j));
      }

    if(possible){
      tabuleiro.moveDama(straight,diagonal,init_row,init_col,fin_row,fin_col);
      return;///movement success
    }
    
    }
  tabuleiro.setLance(tabuleiro.vTabuleiro[init_row][init_col].time * -1);///movement fail
  }
   
  }
