package personagens;

public abstract class Personagem {
    protected String nome;
    protected int nivel;
    protected int vida;
    protected int vidaMaxima;

    public Personagem (String nome, int nivel, int vidaMaxima){
        this.nome = nome;
        this.nivel = nivel;
        this.vidaMaxima = vidaMaxima;
        this.vida = vidaMaxima;   
    }
    public void mostrarInfo(){
    System.out.println("Nome: " + nome + " | Nivel: " + nivel + " | Vida: " +vida+ "/" +vidaMaxima);
    }
    
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

}
