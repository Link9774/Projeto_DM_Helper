package personagens;

public class NPC extends Personagem{
    private String papel;

    public NPC (String nome, String papel, int nivel, int vidaMaxima){
        super(nome,nivel,vidaMaxima);
        this.papel = papel;
    }
    @Override
    public void mostrarInfo(){
         System.out.println("NPC " + getNome() + " | Papel do NPC: " + papel + " | Nivel:" + getNivel()+ " | Vida " +getVida()+ "/" +getVidaMaxima());
    }
}
