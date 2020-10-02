

/**
 *
 * @author Alfredo
 */
public class ExercicioDoisA {
    
    public static void main(String[] args){
        
        System.out.println("Resultado: "+multiplicacao(6,4));
        
    }
    
    static int mult = 0;
    public static int multiplicacao(int n,int m){
        if(n > 0){
            mult = mult + m;
            multiplicacao(n-1, m);
        }
        return mult; 
    }
}
