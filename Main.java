public class Main{
  public static void main(String args[]){

    Tabuleiro tabuleiro = new Tabuleiro();
    tabuleiro.setLance(1); // time branco se move primeiro

  CSVReader csv = new CSVReader();
	csv.setDataSource("entrada1.csv");
  String commands[] = csv.requestCommands();



    //Preencher a tabela
    for(int i = 0; i< 8; i++){ 
      for(int j= 0; j< 8; j++){


        if( (i<3) && ( (i % 2 == 0) && (j % 2 == 0) ) ){
           Comum comum = new Comum(1);
          tabuleiro.createTable(comum,i,j);
        }
        else if ((i<3) && ((i % 2 != 0) && (j % 2 != 0))){
          Comum comum = new Comum(1);
          tabuleiro.createTable(comum,i,j);
        }

        else if( (i<8 && i>=5) && ( (i % 2 != 0) && (j % 2 != 0) ) ) {
          Comum comum = new Comum(-1);
          tabuleiro.createTable(comum,i,j);
        }
        else if ((i<8 && i>=5) && ((i % 2 == 0) && (j % 2 == 0))){
          Comum comum = new Comum(-1);
          tabuleiro.createTable(comum,i,j);
        }

        else if(i>2 && i<5){
          tabuleiro.createTable(null,i,j);

        }
      
      }
    }
    System.out.println("Tabuleiro inicialmente: ");
    tabuleiro.mostrarTabuleiro();

  int init_col, init_row, fin_col, fin_row, i=0,j=0;
  String command = "";

  while(i < commands.length){
    command = commands[i];

    init_col = command.charAt(0) - 'a';
    init_row = command.charAt(1) - '1';

    fin_col = command.charAt(3) - 'a';
    fin_row = command.charAt(4) - '1';



    if(tabuleiro.ultimaPeca != null && tabuleiro.vTabuleiro[init_row][init_col] == tabuleiro.ultimaPeca){/// if same piece as last piece to move
      int x= fin_row - init_row,y = fin_col - init_col;///movement in x,y directions

      if(Math.abs(x) > 1 && Math.abs(y) > 1 && tabuleiro.vTabuleiro[init_row][init_col] instanceof Comum == true ){ ///same common peice trying to do a double capture
        tabuleiro.setLance(tabuleiro.vTabuleiro[fin_row][fin_col].time * -1); // revert turn to allow attempt at double capture
      }

      if(tabuleiro.vTabuleiro[init_row + (x) / Math.abs(x)][init_col + y/Math.abs(y)] != null && tabuleiro.vTabuleiro[init_row][init_col] instanceof Dama == true ){//dama attempting double capture
        tabuleiro.setLance(tabuleiro.vTabuleiro[fin_row][fin_col].time * -1); // revert turn to allow attempt at double capture
      }
    }

        
    if(tabuleiro.vTabuleiro[init_row][init_col].time != tabuleiro.getLance()){
      System.out.println("nao eh vez do jogador");
      i++;
      continue;
    }

    
    if(tabuleiro.vTabuleiro[init_row][init_col] instanceof Comum == true){
    ((Comum)tabuleiro.vTabuleiro[init_row][init_col]).analisaMovimento(init_row,init_col,fin_col,fin_row,tabuleiro);
    }

    else if(tabuleiro.vTabuleiro[init_row][init_col] instanceof Dama == true){
      ((Dama)tabuleiro.vTabuleiro[init_row][init_col]).analisaMovimento(init_row,init_col,fin_col,fin_row,tabuleiro);
    }
    
    i++;
    j++;

    }


  }

  }

