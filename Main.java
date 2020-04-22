public class Main{
  public static void main(String args[]){

    Tabuleiro tabuleiro = new Tabuleiro();

  CSVReader csv = new CSVReader();
	csv.setDataSource("../../../src/db/arq001.csv");
  String commands[] = csv.requestCommands();



    //Preencher a tabela
    for(int i = 0; i< 8; i++){ 
      for(int j= 0; j< 8; j++){

        if( (i<4) && ( (i % 2 != 0) && (j % 2 != 0) ) ){
          tabuleiro.createTable(new Comum(1),i,j);
        }
        else if ((i<4) && ((i % 2 == 0) && (j % 2 == 0))){
          tabuleiro.createTable(new Comum(1),i,j);
        }

        else if( (i<9 && i>6) && ( (i % 2 != 0) && (j % 2 != 0) ) ) {
          tabuleiro.createTable(new Comum(0),i,j);
        }
        else if ((i<9 && i>6) && ((i % 2 == 0) && (j % 2 == 0))){
          tabuleiro.createTable(new Comum(0),i,j);
        }

        else if(i>3 && i<6){
          tabuleiro.createTable(null,i,j);

        }
      
      }
    }

  int init_col, init_row, fin_col, fin_row;
  String command = "";

  while(something){
    command = commands[i];

    init_col = command[0] - 'a';
    init_row = command[1] - '1';

    fin_col = command [3] - 'a'
    fin_col = command[4] - '1';

    tabuleiro.vTabuleiro[init_row][init_col].analisaMovimento(init_row,init_col,fin_col,fin_row,tabuleiro);

  }







  }
}
