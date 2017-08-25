
package avaliadorexpressao;

import java.util.Scanner; 

public class AvaliadorExpressao {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Digite sua expressao infixa: ");
        String infixa= sc.nextLine();
        
        String posfixa= "";
        
        entraInfixa(infixa, posfixa);
        
    }
    
    //Funcao que recebe e le minha expressao infixa
    public static void entraInfixa(String infixa, String posfixa){
        //Gerando uma nova pilha do tamanho da minha string
         Pilha p; 
            p = new Pilha(infixa.length());
            
            char topo = 0;
        
        //iniciando meu laco de checagem da string infixa
            for(int i=0; i<infixa.length(); i++){
                char a = infixa.charAt(i);
                
                if(!p.isEmpty()){
                    topo = p.pegaTopo();
                }
                
            
            //Verifica se a posicao do meu string for um digito e manda direto para a posfixa
                if(Character.isDigit(a)){
                    posfixa = posfixa + a;
                }
         
            //Verifica se a posicao for um operador e manda para a pilha 
            
                else if (a == '^'){
                    p.push(a);
                }
                
                else if( a == '*'){
                        if(topo == '^'){
                        posfixa = posfixa + p.pop();
                        p.push(a);
                    }
                    else{
                        p.push(a);
                    }
                }
                
                else if( a == '/'){
                    if(topo == '^'){
                        posfixa = posfixa + p.pop();
                        p.push(a);
                    }
                    else{
                        p.push(a);
                    }
                }
                
                else if( a == '%'){
                        if(topo == '^'){
                        posfixa = posfixa + p.pop();
                        p.push(a);
                    }
                    else{
                        p.push(a);
                    }
                }
            
                else if( a == '+'){
                    if(topo == '*' || topo == '/' || topo == '%' || topo == '^'){
                        posfixa = posfixa + p.pop();
                        p.push(a);
                    }
                    else{
                        p.push(a);
                    }
                }
            
                else if( a == '-'){
                    if(topo == '*' || topo == '/' || topo == '%' || topo == '^'){
                        posfixa = posfixa + p.pop();
                        p.push(a);
                    }
                    else{
                        p.push(a);
                    }
                }
            }
            
        
            while(!p.isEmpty()){
                
                posfixa = posfixa + p.pop();
                
                
            }
            
            
           System.out.println("A sua expressao infixa eh: " +posfixa);
           calculaPosfixa(posfixa); 
    }    
    
      //Funcao le minha posfixa e calcula seu valor
      public static void calculaPosfixa(String posfixa){
          
          //Criando minha segunda pilha do tamanho da minha string posfixa
          PilhaFloat pp;
          pp = new PilhaFloat(posfixa.length());
   
          
          for(int i=0; i<posfixa.length(); i++){
              
              char ch = posfixa.charAt(i);
              
              if(Character.isDigit(ch)){
                  int n = posfixa.charAt(i)-'0';
                  pp.push(n);
                  
              }
              else{
                  
                  float aux1 = pp.pop();
                  float aux2 = pp.pop();
                  float res = 0;
                  
                  if  (ch == '^')
                      res = (float)Math.pow(aux2, aux1);
                          
                  else if (ch == '*')
                      res = aux1 * aux2;
                          
                  else if (ch == '/')
                      res = aux1 / aux2;
                          
                  else if (ch == '%')
                      res = aux1 % aux2;
                  
                  else if (ch == '+')
                      res = aux1 + aux2;
                  
                  else if (ch == '-')
                      res = aux1 - aux2;
                  
                  
                  
                  pp.push(res);

                  
              }
                
              
          }
          
          float resfinal = pp.pegaTopo();
          
          System.out.println("O resultado da sua expressao infixa eh: " +resfinal);
                  
        
    }
      
    
    
    
}
