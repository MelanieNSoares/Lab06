public class Dama extends Peca {
  
  public Dama (int time){
    super(time);
  }

  public void analisaMovimento(int init_row, int init_col, int fin_col, int fin_row,Tabuleiro tabuleiro){
    
    System.out.println("yes entered");


    int straight = fin_row - init_row;
    int diagonal = fin_col - init_col;

  System.out.println(straight + " " + diagonal);

    int i, j, k = 1;

    if(straight < 0){
      i = -1;
    }else{i = 1;}

    if(diagonal < 0){j = -1;}
    else{j = 1;}
    
    if(tabuleiro.vTabuleiro[fin_row][fin_col] == null){
      System.out.println("yes entered1");
      boolean possible = true;
      while(possible && Math.abs(i) < Math.abs(straight) ){
        System.out.println("yes entered2");
        if(tabuleiro.vTabuleiro[init_row + i][init_col+j] != null && tabuleiro.vTabuleiro[init_row + i][init_col+j].time != time){
          possible = false;

        }
        k++;
        i = i * k;
        i = j * k;
      }

      System.out.println("yes entered3");
      if(straight < 0){
      i = -1;
      }else{i = 1;}

      if(diagonal < 0){j = -1;}
      else{j = 1;}
       k = 1;

      while(Math.abs(i) < Math.abs(straight)){
        tabuleiro.vTabuleiro[init_row + i][init_col+j] = null;
        System.out.println("yes entered4");
        k++;
        i = i * k;
        i = j * k;

      }

      tabuleiro.vTabuleiro[fin_row][fin_col] = tabuleiro.vTabuleiro[init_row][init_col];

      tabuleiro.vTabuleiro[init_row][init_col] = null;
      tabuleiro.pecaMovendo = tabuleiro.vTabuleiro[fin_row][fin_col];
    }
  tabuleiro.setLance(tabuleiro.vTabuleiro[fin_row][fin_col].time * -1);

  tabuleiro.mostrarTabuleiro();
  }
   
  }
