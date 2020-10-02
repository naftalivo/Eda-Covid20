
package exercicioQuatro;

import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Metodos {
    
    private Socio socio;
    private Socio[] socios =  new Socio[10];
    private int quantidade = 0;
    
    
    public void criarMenu(){
        do{
            
            int op = Integer.parseInt(JOptionPane.showInputDialog("Selecione uma opcao: \n"
                + "1 - Adicionar Socio \n"
                + "2 - Pesquisar Socio (SEQUENCIAL) \n"
                + "3 - Pesquisar Socio (SEQUENCIAL COM SENTINELA) \n"
                + "4 - Ver numero total de Socios registados \n"
                + "5 - Remover Socio \n"
                + "0 - sair")
            );
            
            switch(op){
                case 1: regOpcao(); break;
                case 2: pesquisaSequencial(); break;
                case 3: pesquisaSequencialSent(); break;
                case 4: verTotal(); break;
                case 5: remove(); break;
                case 0: System.exit(0); break;
                    default: JOptionPane.showMessageDialog(null, "Opcao invalida!! tente novamente");
            }
            
        }while(true);
     
        
    }
    
    public void regOpcao(){
        do{
            
            int op = Integer.parseInt(JOptionPane.showInputDialog("Registar Socio: \n"
                + "1 - No fim da lista \n"
                + "2 - Numa posicao dada \n"
                + "0 - cancelar")
            );
            
            switch(op){
                case 1: registar(getQuantidade()); break;
                case 2: pedirPos(); break;
                case 0: criarMenu(); break;
                    default: JOptionPane.showMessageDialog(null, "Opcao invalida!! tente novamente");
            }
            
        }while(true);
    }
    
    public void pedirPos(){
        int pos = Integer.parseInt(JOptionPane.showInputDialog("Introduza a posicao:"));
        if (verificaTamanho(pos) ==  false){
            JOptionPane.showMessageDialog(null, "Posicao introduzida nao existe! tente novamente");
            criarMenu();
        }
        
        registar(pos);
          
        
    }
    
    public void pesquisar(){
        int pos = Integer.parseInt(JOptionPane.showInputDialog("Introduza a posicao para pesquisa:"));
        
        if (verificaTamanho(pos) ==  false){
            JOptionPane.showMessageDialog(null, "Posicao introduzida nao existe! tente novamente");
            pesquisar();
        }
        if (verificaNull(pos) == false){
            JOptionPane.showMessageDialog(null, "Nenhum registo na posicao introduzida");
            criarMenu();
        }
        socio = socios[pos];
        JOptionPane.showMessageDialog(null, socio);
        
        
    }
    
    public void registar(int pos){
        String sex, nome;
        int numero =  getQuantidade();
        double val;
        
        nome  = JOptionPane.showInputDialog("Introduza o nome do socio: ");
        String sexAux  = JOptionPane.showInputDialog("Introduza o sexo do socio: \n"
                + " 'M' -  Masculino \n"
                + " 'F' -  Feminino");
                if(sexAux.equalsIgnoreCase(""))
                    sex = "MASCULINO";
                else
                    sex = "FEMININO";
        val = Double.parseDouble(JOptionPane.showInputDialog("Introduza o valor a contribuir: "));
        
        socio = new Socio(nome, sex, val, numero);
        add(socio,pos);
      
    }
    public void pesq(){
        
    }
    
    public void pesquisaSequencial(){
     //   Vector vet = new Vector(2,2);
        int cont = 0;
        String nome = JOptionPane.showInputDialog("Introduza o nome para pesquisa: ");
        socioAux = socios[cont];
        
        while(socioAux != null || cont == socios.length){
           
            if(nome.equalsIgnoreCase(socioAux.getNome())){
                JOptionPane.showMessageDialog(null, "Resultado nr: "+cont+": \n"+socioAux);
                criarMenu();
                
            }
            cont++;
            socioAux = socios[cont];
            
        }
        JOptionPane.showMessageDialog(null, "Nome Nao Consta na Lista");
       
           
    }
    
    
    public void pesquisaSequencialSent(){
        int cont = 0;
        String nome = JOptionPane.showInputDialog("Introduza o nome para pesquisa: ");
     
        socio = new Socio(nome, "MASCULINO", 000, quantidade);
        socios[quantidade] = socio;
        socioAux =  socios[cont] ;
        
        while(socioAux != null){
           
            if(nome.equalsIgnoreCase(socioAux.getNome()) && cont != quantidade){
                JOptionPane.showMessageDialog(null, "Resultado nr: "+cont+": \n"+socioAux);
                socios[quantidade] = null;
                criarMenu();
                
            }
            cont++;
           
            socioAux = socios[cont];
            
        }
        JOptionPane.showMessageDialog(null, "Nome Nao Consta na Lista");
        
        socios[quantidade] = null;
        
        
        
        
    }
    
    public void add(Socio socio, int pos){
        
        if (verificaTamanho(getQuantidade())){
            duplicaArray();
            
        }
        
        if (verificaNull(pos) == true)
            organizaArray(pos, quantidade);
            
        socios[pos] = socio;  
        
        JOptionPane.showMessageDialog(null, "Registado com sucesso");
        quantidade++;
        criarMenu();
        
            
        
    }
    
     public void remove(){
        int pos = Integer.parseInt(JOptionPane.showInputDialog("Introduza a posicao para remover:"));
         
        if (verificaTamanho(pos) ==  false){
            JOptionPane.showMessageDialog(null, "Posicao introduzida nao existe! tente novamente");
            pesquisar();
        }
        if (verificaNull(pos) == false){
            JOptionPane.showMessageDialog(null, "Nenhum registo na posicao introduzida");
            criarMenu();
        }
        
        socios[pos] = null;
        organizaArrayDois(pos, quantidade);
        quantidade--;
        
        
    }
     
      public void organizaArrayDois(int pos, int quant){
      
       if(pos != quant){
            socioAux = socios[pos+1];
            socios[pos] = socioAux;
            organizaArray(pos+1,quant);
           
       }
     
        
    }
    
    public void verTotal(){
        JOptionPane.showMessageDialog(null, "Foram registados "+getQuantidade()+" socios");
        
    }
    
    public boolean verificaTamanho(int pos){
        if(pos <= socios.length)
        return true;
        else
        return false;
    }
    
    public void duplicaArray(){
        Socio [] socioAux = new Socio[socios.length];
        System.arraycopy(socios, 0, socioAux, 0, socios.length);
        socios = new Socio[2*socioAux.length];
        System.arraycopy(socioAux, 0, socios, 0, socioAux.length);
        
    }
    
    public boolean verificaNull(int pos){
        if(socios[pos] != null)
            return true;
        else
            return false;
        
    }
    private Socio socioAux;
    public void organizaArray(int pos, int quant){
      
       if(pos != quant){
            socioAux = socios[quant-1];
            socios[quant] = socioAux;
            organizaArray(pos,quant-1);
           
       }
     
        
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
    
    
}
