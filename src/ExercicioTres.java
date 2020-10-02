
import javax.swing.JOptionPane;



/**
 *
 * @author Alfredo
 */
public class ExercicioTres {
    
  
    
    public static void main(String[] args){
     verificar(Integer.parseInt(JOptionPane.showInputDialog("Introduza um  numero: ")));
        
    
    }
    
 
    public static void verificar(int n){
        
        if(n < 0){
            JOptionPane.showMessageDialog(null, "Numero introduzido invalido!!");
        }else{
            impares(n-1);
            
        }
   
    }
    
    public static void impares(int n){
            if(n > 0)
               impares(n-1);
              
            if(n%2 != 0) {    
                System.out.println(n+" ; ");
              
            }
                 
    }    
}
