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

    tabuleiro.mostrarTabuleiro();

  int init_col, init_row, fin_col, fin_row, i=0,j=0;
  String command = "";

  while(i < commands.length){
    command = commands[i];

    init_col = command.charAt(0) - 'a';
    init_row = command.charAt(1) - '1';

    fin_col = command.charAt(3) - 'a';
    fin_row = command.charAt(4) - '1';

    
    if(tabuleiro.vTabuleiro[init_row][init_col].time != tabuleiro.getLance()){
      System.out.println("nao eh vez do jogador");
      i++;
      continue;
    }

    /*if(tabuleiro.pecaMovendo != null && tabuleiro.vTabuleiro[init_row][init_col] == tabuleiro.pecaMovendo){/// if same piece as last piece to move
      if(Math.abs(fin_row - init_row) > 1 && Math.abs(fin_col - init_col) > 1){ ///same common peice trying to do a double capture
        tabuleiro.setLance(tabuleiro.vTabuleiro[fin_row][fin_col].time * -1);
      }
    }*/

    
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

