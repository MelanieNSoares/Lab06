public class Comum extends Peca {
  
  public Comum (int time){
    super(time);
  }
      

  public void analisaMovimento(int init_row, int init_col, int fin_col, int fin_row,Tabuleiro tabuleiro){

    

    int foward = fin_row - init_row;
    int diagonal = fin_col - init_col;

    if(tabuleiro.vTabuleiro[init_row][init_col].time == 1 && foward < 0){ /// peca comum querendo voltar pra tras

      System.out.println("querendo voltar para tras1");
      tabuleiro.setLance(tabuleiro.vTabuleiro[init_col][init_col].time * -1);
      return;///movement fail
    }
    else if(tabuleiro.vTabuleiro[init_row][init_col].time == -1 && foward > 0){ /// peca comum querendo voltar pra tras 
      System.out.println("querendo voltar pra tras2");
      tabuleiro.setLance(tabuleiro.vTabuleiro[init_row][init_col].time * -1);//movement fail
      return;
    }

    //tentando se mover
    if((foward == 1 || foward == -1) && (diagonal == 1 || diagonal == -1)){
      if(tabuleiro.vTabuleiro[init_row + foward][init_col + diagonal] == null){
        tabuleiro.move(foward,diagonal,init_row,init_col);
        tabuleiro.setLance(tabuleiro.vTabuleiro[fin_row][fin_col].time * -1);//movement sucess
        return;
      }
    }

    //tentando capturar
    if((foward == 2 || foward == -2) && (diagonal == 2 || diagonal == -2)){

      if(tabuleiro.vTabuleiro[init_row +(foward/2)][init_col + (diagonal/2)] != null && tabuleiro.vTabuleiro[fin_row][fin_col] == null){

        if(tabuleiro.vTabuleiro[init_row +(foward/2)][init_col + (diagonal/2)].time != time){

          tabuleiro.capture(foward,diagonal,init_row,init_col);

          tabuleiro.setLance(tabuleiro.vTabuleiro[fin_row][fin_col].time * -1);///movement sucess
          return;
        }
      }
    }

  tabuleiro.setLance(tabuleiro.vTabuleiro[init_row][init_col].time * -1);///movement fail
  }


        
}

