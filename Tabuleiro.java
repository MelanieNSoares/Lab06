public class Tabuleiro{
  public Peca vTabuleiro[][] = new Peca[8][8];

  private int lance;
  Peca ultimaPeca; // ultima peca a se mover
  
  public void setLance(int lance){
    this.lance = lance; // 1 lance do time branco; -1 lance do time preto
  }

  public int getLance(){
    return lance;
  }


  public void createTable(Peca peca, int linha, int coluna){
    vTabuleiro[linha][coluna] = peca;
  }

  public void capture(int foward, int diagonal, int i, int j){
    vTabuleiro[i + (foward/2)][j+(diagonal/2)] = null;
    move(foward,diagonal,i,j);
   
  }

  public void seDama(Peca pecaMovendo,int i, int j, int foward,int diagonal){

    if(pecaMovendo.time == 1){
      if((foward + i) == 7){/// eles se torna um dama
        Dama dama = new Dama(1);
        vTabuleiro[7][j+diagonal] = dama;

      }
    }
    else{
      if(foward + i == 0){/// eles se torna um dama
        Dama dama = new Dama(-1);
        vTabuleiro[0][j+diagonal] = dama;

      }
    }

  }
  
  public void moveDama(int straight,int diagonal,int init_row, int init_col, int fin_row, int fin_col){


    int i= straight / Math.abs(straight);
    int j = diagonal / Math.abs(diagonal);

      
      while(Math.abs(i) < Math.abs(straight)){
        vTabuleiro[init_row + i][init_col+j] = null;
        
        i = (Math.abs(i) + 1 )*(i/Math.abs(i));
        j = (Math.abs(j) + 1 )*(j/Math.abs(j));

      }

      vTabuleiro[fin_row][fin_col] = vTabuleiro[init_row][init_col];

      vTabuleiro[init_row][init_col] = null;
      ultimaPeca = vTabuleiro[fin_row][fin_col];
      setLance(vTabuleiro[fin_row][fin_col].time * -1);
      
      System.out.println((char) (init_col + 97) +""+(char)(init_row + 49) + " para " + (char)(fin_col + 97)+""+(char)(fin_row + 49));
      mostrarTabuleiro();
  }

  public void move(int foward, int diagonal, int i, int j){
    Peca pecaMovendo = vTabuleiro[i][j];
    vTabuleiro[i][j] = null;
    vTabuleiro[i + foward][j+  diagonal] = pecaMovendo;


    seDama(pecaMovendo,i,j,foward,diagonal);

    ultimaPeca = pecaMovendo;
    System.out.println((char) (j + 97) +""+(char)(i + 49) + " para " + (char)(j + diagonal + 97)+""+(char)(foward + i + 49));
    mostrarTabuleiro();  
  }

  public char getPeca(int i, int j){
    if(vTabuleiro[i][j] == null){
      return '-';
    }
    else if(vTabuleiro[i][j].time == 1){
      if(vTabuleiro[i][j] instanceof Dama == true){return 'b';}
      else{return 'B';}
    }
    else{
      if(vTabuleiro[i][j] instanceof Dama == true){return 'p';}
      else{return 'P';}
  }
  }

  public void mostrarTabuleiro(){
    for(int i=7; i>=0; i--){
      int linha = i + 1;
      System.out.print(linha + "\t");
      
      for(int j=0; j<8; j++){

        System.out.print(getPeca(i,j) + "\t");

      }

      System.out.print("\n");
    }
    System.out.println("\t" + "a\t"+"b\t"+"c\t"+ "d\t"+ "e\t"+ "f\t"+ "g\t" + "h"  + "\n");
    System.out.print("\n");
  }


  
}
