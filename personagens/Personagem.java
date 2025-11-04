package personagens;

public abstract class Personagem {
    private String nome;
    private int nivel;
    private int vida;
    private int vidaMaxima;

    public Personagem (String nome, int nivel, int vidaMaxima){
        this.nome = nome;
        this.nivel = nivel;
        this.vidaMaxima = vidaMaxima;
        this.vida = vidaMaxima;   
    }
    public abstract void mostrarInfo();//{
    //System.out.println("Nome: " + nome + " | Nivel: " + nivel + " | Vida: " +vida+ "/" +vidaMaxima);
    //}
    
    public void receberDano(int dano){
    vida -= dano;
    if(vida < 0) vida = 0;
    }
    
    public void curarVida(int cura){
    vida += cura;
    if(vida > vidaMaxima) vida = vidaMaxima;
    }
    
    public String getNome(){
        return nome;
    }
    public int getNivel(){
        return nivel;
    }
    public int getVida(){
        return vida;
    }    
    public int getVidaMaxima(){
       return vidaMaxima;
    }
}
