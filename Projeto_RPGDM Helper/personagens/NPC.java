package personagens;

public class NPC extends Personagem{
    private String papel;

    public NPC (String nome, String papel, int vidaMaxima, int nivel){
        super(nome,nivel,vidaMaxima);
        this.papel = papel;
    }
    @Override
    public void mostrarInfo(){
         System.out.println("NPC " + nome + " | Papel do NPC: " + papel + " | Nivel:" + nivel+ " | Vida " +vida+ "/" +vidaMaxima);
    }
}
