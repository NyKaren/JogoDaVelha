public class JogoDaVelha {
    private int[][] grade;

    //espaços vazios = 0
    //jogador 1 (x) = 1
    //jogador 2 (o) = 2
    
    public JogoDaVelha(){
        //instancia um vetor 3x3
        grade = new int[3][3];

        //incicializa grade com zeros
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                grade[i][j] = 0;
            }
        }
    }

   //imprime grade substituindo os números por seus respectivos caracteres
    public void exibeGrade() {
    	System.out.println(" |0|1|2|");
        for (int i = 0; i < 3; i++){
        	System.out.print(i + "|");
            for (int j = 0; j < 3; j++){
                switch (grade[i][j]){
                    case 0:
                        System.out.print(" ");
                        break;
                    case 1:
                        System.out.print("x");
                        break;
                    case 2:
                        System.out.print("o");
                        break;
                }
                System.out.print("|");
            }
            System.out.print("\n");
        }
    }

    //executa uma jogada, substituindo o valor da coordenada passada, pelo número do jogador
    //TODO: garantir que a jogada só possa ser executada em um espaço vazio
    public void joga(int jogador, int linha, int coluna){
        grade[linha][coluna] = jogador;
    }

    //A cada jogada, verifica se alguém ganhou e quem foi
    //Se alguma das variáveis de verificação conter o valor 0, o jogador 1 ganhou. Caso seja 6, o jogador 2 ganhou.
    public int vencedor(){
        int verificaLinha = 3;
        int verificaColuna = 3;
        int verificaDiagonal = 3;
        
        int i = 0;
        int j = 0;
        
        /*if (
                (grade[0][0] == 1 && grade[0][1] == 1 && grade[0][2] == 1)
                ||
                (grade[1][0] == 1 && grade[1][1] == 1 && grade[1][2] == 1)
                ||
                (grade[2][0] == 1 && grade[2][1] == 1 && grade[2][2] == 1)
                )
            */
        
        for (i = 0; i < 3; i++){
            verificaDiagonal = grade[i][i] == 0 ? verificaDiagonal : grade[i][i] == 1 ? verificaDiagonal - 1 : verificaDiagonal + 1;
            j = 0;
            while (j < 3 && 
                    (verificaLinha > 0 || verificaLinha < 6) && 
                    (verificaColuna > 0 || verificaColuna < 6) ){
                verificaLinha = grade[i][j] == 0 ? verificaLinha : grade[i][i] == 1 ? verificaLinha - 1 : verificaLinha + 1;
                verificaColuna = grade[j][i] == 0 ? verificaColuna : grade[i][i] == 1 ? verificaColuna - 1 : verificaColuna + 1;
                j++;
            }
        }
        
        //Verifica a outra diagonal
        if (grade[0][2] == 1 && grade[1][1] == 1 && grade[2][0] == 1){
        	return 1;
        }
        else if (grade[0][2] == 2 && grade[1][1] == 2 && grade[2][0] == 2){
        	return 2;
        }

        //Verifica e retorna quem ganhou, caso isso não tenha sido definido na verificação anterior
        if (verificaLinha == 0 || verificaColuna == 0 || verificaDiagonal == 0){
            return 1;
        }
        else if (verificaLinha == 6 || verificaColuna == 6 || verificaDiagonal == 6){
            return 2;
        }
        else{
            return 0;
        }
    }
    
    public boolean velha(){
    	for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
            	if (grade[i][j] == 0){
            		return false;
            	}
            }
        }
    	return true;
    }
}