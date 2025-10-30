package personagens;

public class Player extends Personagem{
    private String classe; 

    public Player(String nome, int nivel, int vidaMaxima, String classe){
        super(nome, nivel, vidaMaxima);
        this.classe = classe;
    }
    @Override
    public void mostrarInfo(){
        System.out.println("[Player] " + nome + " | Classe: " + classe + " | Nivel:" + nivel+ " | Vida " +vida+ "/" +vidaMaxima);
    }


}
