

/**
 *
 * @author Alfredo
 */
public class ExercicioDoisB {
    
  
    
    public static void main(String[] args){
        System.out.println("Resultado: "+sum(2));
        
    
    }
    
    static double soma = 0;
    public static double sum(double n){
        if(n > 0){
            soma = soma + (1/n);
             
            sum(n-1);
            
        }
        
        return soma;
        
    }
   
    
    
}
