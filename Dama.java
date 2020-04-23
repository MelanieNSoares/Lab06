public class Dama extends Peca {
  
  public Dama (int time){
    super(time);
  }

  public void analisaMovimento(int init_row, int init_col, int fin_col, int fin_row,Tabuleiro tabuleiro){
    
    System.out.println("yes entered");


    int straight = fin_row - init_row;
    int diagonal = fin_col - init_col;

    if(Math.abs(straight) != Math.abs(diagonal)){
       tabuleiro.setLance(tabuleiro.vTabuleiro[init_row][init_col].time * -1);
      return; /// movement fail can only move diagonally
    }

  System.out.println(straight + " " + diagonal);

    int i= straight / Math.abs(straight), 
        j = diagonal / Math.abs(diagonal);
    boolean possible = false;

    if(tabuleiro.vTabuleiro[fin_row][fin_col] == null){
      System.out.println("yes entered1");

      possible = true;

      while(possible && Math.abs(i) < Math.abs(straight) ){
        System.out.println("yes entered2");

        if(tabuleiro.vTabuleiro[init_row + i][init_col+j] != null && tabuleiro.vTabuleiro[init_row + i][init_col+j].time == time){
          possible = false;
          System.out.println("how");

        }
        i = (Math.abs(i) + 1 )*(i/Math.abs(i));
        j = (Math.abs(j) + 1 )*(j/Math.abs(j));
      }


    System.out.println(possible);

    if(possible){
    System.out.println("yes entered3");

    i= straight / Math.abs(straight);
    j = diagonal / Math.abs(diagonal);

      
      while(Math.abs(i) < Math.abs(straight)){
        tabuleiro.vTabuleiro[init_row + i][init_col+j] = null;
        System.out.println("yes entered4");
        
        i = (Math.abs(i) + 1 )*(i/Math.abs(i));
        j = (Math.abs(j) + 1 )*(j/Math.abs(j));

      }

      tabuleiro.vTabuleiro[fin_row][fin_col] = tabuleiro.vTabuleiro[init_row][init_col];

      tabuleiro.vTabuleiro[init_row][init_col] = null;
      tabuleiro.ultimaPeca = tabuleiro.vTabuleiro[fin_row][fin_col];
      tabuleiro.setLance(tabuleiro.vTabuleiro[fin_row][fin_col].time * -1);
      tabuleiro.mostrarTabuleiro();
      return;///movement success
    }
    
    }
  tabuleiro.setLance(tabuleiro.vTabuleiro[init_row][init_col].time * -1);///movement fail
  }
   
  }
