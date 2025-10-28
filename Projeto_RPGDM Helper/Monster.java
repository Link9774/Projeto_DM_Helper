public class Monster extends Personagem{
    private String tipo;
    private int dano;
    private String tipoDano;

    public Monster(String nome,String tipo, String tipoDano ,int nivel, int vidaMaxima, int dano){
        super(nome, nivel, vidaMaxima);
        this.tipo = tipo;
        this.dano = dano;
        this.tipoDano = tipoDano;
    }
    @Override
    public void mostrarInfo(){
         System.out.println("Nome: " + nome + " | Tipo do monstro: " +tipo+ " | Dano: " + dano + " | Tipo de Dano: " + tipoDano + " | Nivel: " + nivel+ " | Vida " +vida+ "/" +vidaMaxima);
    }
}
