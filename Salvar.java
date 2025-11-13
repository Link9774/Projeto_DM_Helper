import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import personagens.Monster;
import personagens.NPC;
import personagens.Personagem;
import personagens.Player;

public class Salvar {
    private static final String PATH = "personagensSalvos.txt";

    public static void salvar(List<Personagem> personagens) throws IOException{
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(PATH))){
            for (Personagem p : personagens){
                bw.write(p.toString());
                bw.newLine();
            }
        }
    }

    public static List<Personagem> carregar() throws IOException{
        List<Personagem> personagens = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(PATH))){
            String linha;
            while ((linha = br.readLine()) != null){
                String[] dados = linha.split(";");
            
                String tipoD = dados[0];
            
                switch (tipoD) {
                    case "Player" -> {
                        String nome = dados[1];
                        String classe = dados[5];
                        int nivel = Integer.parseInt(dados[2]);
                        int vida = Integer.parseInt(dados[3]);
                        int vidaMaxima = Integer.parseInt(dados[4]);
                        Player p = new Player(nome, nivel, vidaMaxima, classe);
                        while (p.getVida() > vida) p.receberDano(1);
                        personagens.add(p);
                    }
                     case "Monster" -> {
                        String nome = dados[1];
                        String tipo = dados[5];
                        String tipoDano = dados[6];
                        int nivel = Integer.parseInt(dados[2]);
                        int vida = Integer.parseInt(dados[3]);
                        int vidaMaxima = Integer.parseInt(dados[4]);
                        int dano = Integer.parseInt(dados[7]);
                        int dadoDano = Integer.parseInt(dados[8]);

                        Monster m = new Monster(nome, tipo, tipoDano, nivel, vidaMaxima, dano, dadoDano);
                        while (m.getVida() > vida) m.receberDano(1);
                        personagens.add(m);
                     }
                     case "NPC" -> {
                        String nome = dados [1];
                        String papel = dados [2];
                        int nivel = Integer.parseInt(dados[3]);
                        int vida = Integer.parseInt(dados[4]);
                        int vidaMaxima = Integer.parseInt(dados[5]);
                        NPC npc = new NPC(papel, nome, nivel, vidaMaxima);
                        while (npc.getVida() > vida) npc.receberDano(1);
                        personagens.add(npc);
                    }
                } 
            }
        } catch (FileNotFoundException e){
            System.out.println("Nenhum arquivo existente. Um novo será cirado.");
        }
        
        return personagens;
    }
}
