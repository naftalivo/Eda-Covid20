

/**
 *
 * @author Alfredo
 */
public class ExercicioDoisC {
    
  
    
    public static void main(String[] args){
        System.out.println("Resultado: "+serie(2));
        
    
    }
    
    static int soma = 0;
    public static int serie(double n){
        
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        
        else
            return 2*serie(n-1)+3*serie(n-2);
       
        
    }
   
    
    
}
