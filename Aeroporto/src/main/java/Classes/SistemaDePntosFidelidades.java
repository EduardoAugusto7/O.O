
package Classes;

public class SistemaDePntosFidelidades {
private int pontosAcumulados;

    public SistemaDePntosFidelidades(){
    this.pontosAcumulados = 0;
}
    
    public SistemaDePntosFidelidades(int pontosAcumulados) {
        this.pontosAcumulados = pontosAcumulados;
    }

    public void adicionarPOntos(int pontos){
       this.pontosAcumulados += pontos;
    }
    
    public void removerPontos(int pontos){
        this.pontosAcumulados -= pontos;
    }
    
    public int retornaPontos(int pontos){
        return pontos;
    }
    
    public boolean resgatarPontos(int pontos){
        if(pontos > 0 && this.pontosAcumulados >= pontos){
            removerPontos(pontos);
            System.out.println("resgate com sucesso.");
            return true;
        }else{
            System.out.println("resgate nao foi feito com sucesso.");
            return false;
        }
    }
    

}
