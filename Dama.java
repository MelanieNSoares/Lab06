public class Dama extends Peca {
  
  public Dama (int time){
    super(time);
  }

  public void analisaMovimento(int init_row, int init_col, int fin_col, int fin_row,Tabuleiro tabuleiro){

    
    int straight = fin_row - init_row;
    int diagonal = fin_col - fin_row;

    int i, j, k = 1;
    if(straight < 0){i = - 1;}
    else{i = 1;}

    if(diagonal < 0){j = -1;}
    else{j = 1;}

    ///para se mover
    while(Math.abs(i) < Math.abs(straight)){

      if(tabuleiro.vTabuleiro[init_row + i][init_col + j] == null){
        tabuleiro.move(straight,diagonal,init_row,init_col);
        k++;
        i = i * k;
        j = j * k;
      }

    }
    

  tabuleiro.setLance(tabuleiro.getLance() * - 1);
  }

}