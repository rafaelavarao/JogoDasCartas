import java.util.Scanner;
public class app{
    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);

        //Perguntando ao usuario.
        //resposta do usuario com retirada de espaços e letras maiusculas.
        System.out.println("Por favor, digite três cartas."); 
        String cartaUm = teclado.nextLine().trim().toUpperCase(); 
        String cartaDois = teclado.nextLine().trim().toUpperCase();
        String cartaTres = teclado.nextLine().trim().toUpperCase();

        //descobrindo o tamanho da entrada do usuario.
        int tamanhoCartaUm = cartaUm.length(); 
        int tamanhoCartaDois = cartaDois.length();
        int tamanhoCartaTres = cartaTres.length();

        //pegando a posição do ultimo elemento
        int ultimoElementoCartaUm = tamanhoCartaUm - 1;
        int ultimoElementoCartaDois = tamanhoCartaDois -1;
        int ultimoElementoCartaTres = tamanhoCartaTres -1;

        //pegando o ultimo elemento(naipe)
        String naipeCartaUm = cartaUm.substring(ultimoElementoCartaUm);
        String naipeCartaDois = cartaDois.substring(ultimoElementoCartaDois);
        String naipeCartaTres = cartaTres.substring(ultimoElementoCartaTres);

        //pegando valor da carta(primeiro elemento)
        String valorCartaUm = cartaUm.substring(0,1);
        String valorCartaDois = cartaDois.substring(0,1);
        String valorCartaTres = cartaTres.substring(0,1);

        //pegando o 1 e as letras e atribuindo valor a eles
        if(valorCartaUm.equals("1") || valorCartaUm.equals("A") || valorCartaUm.equals("J") || valorCartaUm.equals("Q") || valorCartaUm.equals("K")){
            if(valorCartaUm.equals("1")){
                valorCartaUm = "10";
            } else if(valorCartaUm.equals("A")){
                valorCartaUm = "1";
            } else if(valorCartaUm.equals("J")){
                valorCartaUm = "11";
            } else if(valorCartaUm.equals("Q")){
                valorCartaUm = "12";
            } else if(valorCartaUm.equals("K")){
                valorCartaUm = "13";
            }
        }

        if(valorCartaDois.equals("1") || valorCartaDois.equals("A") || valorCartaDois.equals("J") || valorCartaDois.equals("Q") || valorCartaDois.equals("K")){
            if(valorCartaDois.equals("1")){
                valorCartaDois = "10";
            } else if(valorCartaDois.equals("A")){
                valorCartaDois = "1";
            } else if(valorCartaDois.equals("J")){
                valorCartaDois = "11";
            } else if(valorCartaDois.equals("Q")){
                valorCartaDois = "12";
            } else if(valorCartaDois.equals("K")){
                valorCartaDois = "13";
            }
        }

        if(valorCartaTres.equals("1") || valorCartaTres.equals("A") || valorCartaTres.equals("J") || valorCartaTres.equals("Q") || valorCartaTres.equals("K")){
            if(valorCartaTres.equals("1")){
                valorCartaTres = "10";
            } else if(valorCartaTres.equals("A")){
                valorCartaTres = "1";
            } else if(valorCartaTres.equals("J")){
                valorCartaTres = "11";
            } else if(valorCartaTres.equals("Q")){
                valorCartaTres = "12";
            } else if(valorCartaTres.equals("K")){
                valorCartaTres = "13";
            }
        }

        //transformando string para int
        int intValorCartaUm = Integer.parseInt(valorCartaUm); 
        int intValorCartaDois = Integer.parseInt(valorCartaDois); 
        int intValorCartaTres = Integer.parseInt(valorCartaTres); 
        
        //declarando para poder usar com o .max
        int maiorValorCartaUmECartaDois = 0;
        int maiorValorCartaDoisECartaTres = 0;

        //usando .max para saber o maior entre as combinações
        maiorValorCartaUmECartaDois = Math.max(intValorCartaUm,intValorCartaDois);
        maiorValorCartaDoisECartaTres = Math.max(intValorCartaDois,intValorCartaTres);

        //transformando em string o maior valor entre as duplas do .max
        String stringMaiorValorUmEDois = String.valueOf(maiorValorCartaUmECartaDois);
        String stringMaiorValorDoisETres = String.valueOf(maiorValorCartaDoisECartaTres);
        
        //declarando para poder usar nas sequencias
        int menorCarta = 0;
        int meioCarta = 0;
        int maiorCarta = 0;

        //possibilidades de ordem para as sequencias
        if(stringMaiorValorUmEDois.equals(valorCartaUm)){ // 1 > 2

            if (stringMaiorValorDoisETres.equals(valorCartaTres)){ // 3 > 2

                if(maiorValorCartaDoisECartaTres > maiorValorCartaUmECartaDois){ // 3 > 1?
                    // 3 1 2 
                    maiorCarta = intValorCartaTres;
                    meioCarta = intValorCartaUm;
                    menorCarta = intValorCartaDois;
                } else { //1  3  2
                    maiorCarta = intValorCartaUm;
                    meioCarta = intValorCartaTres;
                    menorCarta = intValorCartaDois;
                }
            }else{ //2 > 3  1 2 3
                maiorCarta = intValorCartaUm;
                meioCarta = intValorCartaDois;
                menorCarta = intValorCartaTres;
            }
        } else { //2 > 1
            if(stringMaiorValorDoisETres.equals(valorCartaTres)){
                maiorCarta = intValorCartaTres;
                meioCarta = intValorCartaDois;
                menorCarta = intValorCartaUm;
            }else{
                if (intValorCartaUm > intValorCartaTres){ // 1 > 3? = 2 1 3
                    maiorCarta = intValorCartaDois;
                    meioCarta = intValorCartaUm;
                    menorCarta = intValorCartaTres;
                } else {//3 > 1 = 2 3 1
                    maiorCarta = intValorCartaDois;
                    meioCarta = intValorCartaTres;
                    menorCarta = intValorCartaUm;
                }  
            }
        }
        
        
        //ERROS QUE O USUARIO PODE COMETER
        //1 - se o usuario inserir uma carta com menos que dois elementos ou mais que tres elementos 
        if((tamanhoCartaUm < 2) || (tamanhoCartaUm > 3) || (tamanhoCartaDois < 2) || (tamanhoCartaDois > 3) || (tamanhoCartaTres < 2) || (tamanhoCartaTres > 3)){
            System.out.println("Erro, menos de 2 elementos ou mais de 3 elementos."); 
        } else {
        
        //2 - se o usuario inserir qualquer outra letra que nao seja os naipes(P,O,E,C)
        if((!naipeCartaUm.equals("P") && !naipeCartaUm.equals("O") && !naipeCartaUm.equals("E") && !naipeCartaUm.equals("C"))){
                System.out.println("Naipe não existente; erro.");
            } else{
        if((!naipeCartaDois.equals("P") && !naipeCartaDois.equals("O") && !naipeCartaDois.equals("E") && !naipeCartaDois.equals("C"))){
                System.out.println("Naipe não existente; erro.");
            } else{
        if((!naipeCartaTres.equals("P") && !naipeCartaTres.equals("O") && !naipeCartaTres.equals("E") && !naipeCartaTres.equals("C"))){
                System.out.println("Naipe não existente; erro.");
            } else{
                
        //3 - se o usuario inserir numeros maiores que 10 
        if((tamanhoCartaUm == 3)){
            if((!valorCartaUm.equals("11P") || !valorCartaUm.equals("11O") || !valorCartaUm.equals("11E") || !valorCartaUm.equals("11C"))){
                System.out.println("Valor da carta não existente; erro.");
            } 
        } else{
        if((tamanhoCartaDois == 3)){
            if((!valorCartaDois.equals("11P") || !valorCartaDois.equals("11O") || !valorCartaDois.equals("11E") || !valorCartaDois.equals("11C"))){
                System.out.println("Valor da carta não existente; erro.");
            }  
        } else{
        if((tamanhoCartaTres == 3)){
            if((!valorCartaTres.equals("11P") || !valorCartaTres.equals("11O") || !valorCartaTres.equals("11E") || !valorCartaTres.equals("11C"))){
                System.out.println("Valor da carta não existente; erro.");
            }  
        } else{

        //imprimindo as cartas em sequencia para o usuario 
        System.out.println("1º carta: " + menorCarta + naipeCartaUm);
        System.out.println("2º carta: " + meioCarta + naipeCartaDois);
        System.out.println("3º carta: " + maiorCarta + naipeCartaTres); 
        
        //RESOLVENDO AS QUESTÕES DO TRABALHO
        //A) descobrindo se todos os naipes são iguais
        if((naipeCartaUm).equals(naipeCartaDois) && (naipeCartaDois).equals(naipeCartaTres)){
            System.out.println("As cartas são todas do mesmo naipe? Sim.");
        } else {
            System.out.println("As cartas são todas do mesmo naipe? Não.");
        }

        //B) descobrindo se todos os naipes são diferentes ou não
        if((!naipeCartaUm.equals(naipeCartaDois) && !naipeCartaDois.equals(naipeCartaTres))){
            System.out.println("As cartas são todas de naipes diferentes? Sim.");
        } else {
            System.out.println("As cartas são todas de naipes diferentes? Não.");
        }

        //C) descobrindo se as cartas formam uma trinca
        if((!naipeCartaUm.equals(naipeCartaDois) && !naipeCartaDois.equals(naipeCartaTres))){
            if((valorCartaUm).equals(valorCartaDois) && (valorCartaDois).equals(valorCartaTres)){
                System.out.println("As cartas formam uma trinca (valores iguais, porém naipes diferentes)? Sim.");
            }else {
                System.out.println("As cartas formam uma trinca (valores iguais, porém naipes diferentes)? Não.");
            } 
        } else { 
            System.out.println("As cartas formam uma trinca (valores iguais, porém naipes diferentes)? Os naipes não são diferentes.");
        }

        //D) descobrindo se as cartas formam uma sequencia simples
        if(menorCarta + 1 == meioCarta && meioCarta +1 == maiorCarta){
            System.out.println("As cartas formam uma sequencia simples (independente dos naipes)? Sim.");
        } else {
            System.out.println("As cartas formam uma sequencia simples (independente dos naipes)? Não.");
        }

        //E) descobrindo se as cartas formam uma sequencia premium
        if((naipeCartaUm).equals(naipeCartaDois) && (naipeCartaDois).equals(naipeCartaTres)){
            if(menorCarta + 1 == meioCarta && meioCarta +1 == maiorCarta){
                System.out.println("As cartas formam uma sequencia premium (mesmos naipes)? Sim.");
            } 
        } else {
            System.out.println("As cartas formam uma sequencia premium (mesmos naipes)? Não.");
        }

    }
}
}
}
}
}
}
}
}

