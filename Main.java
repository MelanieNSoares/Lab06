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
      continue;
    }

    ((Comum)tabuleiro.vTabuleiro[init_row][init_col]).analisaMovimento(init_row,init_col,fin_col,fin_row,tabuleiro);

    i++;
    j++;

  }




tabuleiro.mostrarTabuleiro();


  }
}
