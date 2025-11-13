package personagens;

public class Monster extends Personagem{
    private String tipo;
    private int dano;
    private String tipoDano;
    private int dadoDano;

    public Monster(String nome,String tipo, String tipoDano ,int nivel, int vidaMaxima, int dano, int dadoDano){
        super(nome, nivel, vidaMaxima);
        this.tipo = tipo;
        this.dano = dano;
        this.tipoDano = tipoDano;
        this.dadoDano = dadoDano;
    }
    @Override
    public void mostrarInfo(){
         System.out.println("Nome: " + getNome() + " | Tipo do monstro: " +tipo+ " | Dano: " + dadoDano+ "D" + dano + " | Tipo de Dano: " + tipoDano + " | Nivel: " + getNivel()+ " | Vida " +getVida()+ "/" +getVidaMaxima());
    }
    
    @Override
    public String toString(){
        return "Monster;" + super.toString() + ";" + tipo + ";" + tipoDano + ";" + dano + ";" + dadoDano;
    }



}
