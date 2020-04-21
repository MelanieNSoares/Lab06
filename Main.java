public class Main{
  public static void main(String args[]){

    Tabuleiro tabuleiro = new Tabuleiro();

    //Preencher a tabela
    for(int i = 0; i<= 8; i++){ 
      for(int j= 0; j<= 8; j++){

        if( (i<4) && ( (i % 2 != 0) && (j % 2 != 0) ) ){
          Tabuleiro.createTable(new Comum(1),i,j);
        }
        else if ((i<4) && ((i % 2 == 0) && (j % 2 == 0))){
          Tabuleiro.createTable(new Comum(1),i,j);
        }

        else if( (i<9 && i>6) && ( (i % 2 != 0) && (j % 2 != 0) ) ) {
          Tabuleiro.createTable(new Comum(0),i,j);
        }
        else if ((i<9 && i>6) && ((i % 2 == 0) && (j % 2 == 0))){
          Tabuleiro.createTable(new Comum(0),i,j);
        }

        else if(i>3 && i<6){
          Tabuleiro.createTable(null,i,j);

        }
      
      }
    }






  }
}
