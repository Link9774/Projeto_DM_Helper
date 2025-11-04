import java.io.EOFException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import personagens.Monster;
import personagens.NPC;
import personagens.Personagem;
import personagens.Player;

public class Main {
    public static void main(String[] args) {
    Scanner s = new Scanner(System.in);        
    List<Personagem> personagens = new ArrayList<>();   
    
    while(true){
        System.out.println("\n ******GERENCIADOR DE RPG DE MESA******");
        System.out.println("1- Adicionar Player(Jogador)");
        System.out.println("2- Adicionar Monstro");
        System.out.println("3- Adicionar NPC");
        System.out.println("4- Listar personagens");
        System.out.println("5- Aplicar dano ou cura");
        System.out.println("6- Exibir Ordem de turnos");
        System.out.println("7- Sair");
        System.out.print("Escolha: ");
        
        String opcao = s.nextLine();
    
        try{
            switch (opcao) {
                case "1" ->{
                    System.out.println("Nome: ");
                    String nome = s.nextLine();
                    System.out.println("Classe: ");
                    String classe = s.nextLine();   
                    System.out.println("Nivel: ");
                    int nivel = Integer.parseInt(s.nextLine());
                    System.out.println("Vida: ");
                    int vida = Integer.parseInt(s.nextLine());
                    personagens.add(new Player(nome, nivel, vida, classe));
                    System.out.println("Player adicionado com sucesso!");
                   // System.out.println("Pressione qualquer tecla para sair.");
                    //s.nextLine();
                }
                case "2" ->{
                    System.out.println("Nome: ");
                    String nome = s.nextLine();
                    System.out.println("Tipo (ex: Dragão, morto vivo): ");
                    String tipo = s.nextLine();
                    System.out.println("Tipo de dano (ex: Cortante, fogo): ");
                    String tipoDano = s.nextLine();
                    System.out.println("Quantos dados de dano o monstro usa ?");
                    int dadoDano = Integer.parseInt(s.nextLine());
                    System.out.println("Dano do monstro: ");
                    int dano = Integer.parseInt(s.nextLine());
                    System.out.println("Nivel: ");
                    int nivel = Integer.parseInt(s.nextLine());
                    System.out.println("Vida: ");
                    int vida = Integer.parseInt(s.nextLine());
                    personagens.add(new Monster(nome, tipo, tipoDano, nivel, vida, dano, dadoDano));
                    System.out.println("Agora seus jogadores vão ter que se preocupar com " +nome);
                }
                case "3" ->{
                     System.out.println("Nome: ");
                    String nome = s.nextLine();
                    System.out.println("Papel (ex: Ferreiro, mercador, vilão): ");
                    String papel = s.nextLine();   
                    System.out.println("Nivel: ");
                    int nivel = Integer.parseInt(s.nextLine());
                    System.out.println("Vida: ");
                    int vida = Integer.parseInt(s.nextLine());
                    personagens.add(new NPC(nome, papel, vida, nivel));
                }
                case "4" ->{
                    System.out.println("\n***** Personagens na sessão *****");
                    for(Personagem p : personagens){
                        p.mostrarInfo();
                    }
                    System.out.println("Pressione qualquer tecla para sair.");
                    s.nextLine();
                }
                case "5" ->{
                    System.out.println("Digite o nome do personagem");
                    String nome = s.nextLine();
                    Personagem alvo = personagens.stream()
                    .filter(p -> p.getNome().equalsIgnoreCase(nome))
                    .findFirst()
                    .orElse(null);
                    
                    if(alvo == null) throw new Exception("Personagem não encontrado !!!");
                    
                    String tipo;
                    while (true) {
                        System.out.println("Aplicar Dano (D) ou Aplicar Cura (C)");
                        tipo = s.nextLine().trim();

                        if(tipo.equalsIgnoreCase("D") || tipo.equalsIgnoreCase("C")){
                            break;
                        }else{
                            System.out.println("Opção inválida, Digite apenas D ou C.");
                        }
                    }

                    System.out.println("Qauntidade: ");
                    int valor = Integer.parseInt(s.nextLine());
                    
                    if (tipo.equalsIgnoreCase("D")) alvo.receberDano(valor);
                    else alvo.curarVida(valor);
                
                    System.out.println("Vida do personagem atualizada com sucesso !!!");
                }
                case "6" ->{
                    System.out.println("\n***** Ordem de Turnos *****");
                    personagens.stream()
                    .sorted(Comparator.comparing(Personagem::getNivel).reversed())
                    .forEach(p -> System.out.println(p.getNome() + "(Nivel " +p.getNivel() + ")"));    
                    System.out.println("Pressione qualquer tecla caso queira voltar ao menu");
                    s.nextLine();
                }
                case "7" ->{
                    System.out.println("Fim da sessão, até a proxima sessão");
                    return;
                }
                case "8" ->{
                    System.out.println("""
                            ⠀⠀⠀⠀⠀⠀⠀⢹⡀⠀⠀⠀⠀⠀⠘⠀⣷⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡀⠀⠀⠀⠙⢦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⡼⠃⠀⠀⠀⠀⠀⣤⠀⢏⠀⠀⠀⠀⢠⣠⡆⠀⠀⣦⡀⠀⠳⡀⠀⠀⠀⠀⠑⢄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈
⠀⠀⠀⠀⠀⠀⠀⠀⠐⣇⡀⠀⠀⠀⠀⠀⠘⠂⢈⣦⠀⣀⡀⠈⣟⢷⣄⠀⠘⣷⣄⠀⠹⣆⠀⠀⠀⠀⠀⠙⢦⣀⠀⠀⠀⠀⠀⠀⠀⢤
⠀⠀⠀⠀⠐⣶⠦⠤⠴⠋⠁⠀⠀⠀⠀⡜⢷⣧⣸⣿⡀⡟⠹⡄⢹⠀⣹⣷⣤⡘⣄⠙⠲⢬⣿⣉⡉⠉⠉⠉⠉⢉⣥⣀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠈⠳⠤⢤⡀⠀⠀⠀⠀⠀⢹⡾⣿⠛⠉⣧⡇⠀⢱⣸⡔⢡⠏⠀⠉⢻⣦⣤⠀⠈⠹⣿⣂⡀⣠⠔⢉⡤⠾⡆⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⢀⡞⣧⠀⠀⢠⠈⣇⢀⣿⠃⠀⠀⠸⣿⣠⣼⣟⣠⣯⣴⡿⠷⣿⠟⠁⠀⠀⠀⠀⠀⣇⡇⠀⡿⠦⡀⣇⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⣾⡼⡇⠀⠀⠘⡇⣿⣿⣿⢦⣄⣧⠀⣯⣿⣼⣿⣿⠋⢿⣽⣶⡏⠀⠀⠀⠀⠀⠀⠀⢻⠇⢀⡇⣠⠇⢸⡄⠀⠀⠀⣠
⠀⠀⠀⠀⠀⠀⠀⠙⠓⠳⣤⣶⠀⣿⠛⣿⢻⣷⣮⣽⡆⠈⠿⠟⠻⠛⠉⠉⠋⠉⠀⠀⠀⠀⠀⠀⠀⠀⠙⠀⠘⢿⠃⠀⣼⠁⠀⠀⠀⡱
⠀⠀⠀⠀⠀⠀⠀⢀⣠⡴⣺⣿⢠⣍⡀⠘⡿⢿⡿⠿⣷⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⡈⢀⡾⠃⠀⠀⠀⠘⢄
⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠁⢸⡟⣾⡷⣄⢹⠀⠀⠀⣿⠁⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡏⡏⠉⠀⠀⠀⠀⠀⡐⠪
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠃⠈⠃⠀⠙⣇⠀⠀⠙⠦⠉⠉⠁⠀⠀⠀⠀⠀⢠⡆⠀⠀⠀⠀⠀⠀⠀⢸⠃⠹⡄⠀⠀⠀⠀⠀⠠⡀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣆⠀⠀⢠⣤⣤⡤⢒⣊⣩⣽⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⢸⡄⠀⠙⣿⠀⡄⠀⠀⠀⠙
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⢦⠀⠈⠹⣶⠛⣩⠔⠋⠉⠁⣸⠀⠀⠀⠀⠀⠀⠀⣠⢞⡁⠀⠀⡞⣸⠃⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠳⣄⠀⠈⣿⣇⣀⣀⣀⢴⡿⠀⠀⠀⠀⠀⣠⠞⠁⣸⠀⢀⡼⠟⠹⡀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠳⡄⠙⠲⠤⠥⢖⡋⠀⠀⠀⠀⡠⠊⠁⠀⢠⠇⠀⠀⠀⠀⠀⢹⣉⡉⢰⡎
⠀⣀⣤⠖⠒⢲⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣆⠀⠛⠋⠉⠀⠀⢀⡤⠊⠀⠀⠀⠀⠞⠀⠀⠀⠀⠀⠀⠀⢳⡼⠋⠀
⠋⡝⠁⠀⠀⠀⢱⡀⢀⡴⠊⠉⠉⠙⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⢘⣄⣀⣀⣀⡤⠖⠋⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⠤⠤⠖⠊⢁⡠⠖⠋
⠉⠉⠉⠉⠙⡆⠀⢷⠋⠀⠀⢀⡴⠚⠁⠀⠀⠀⠀⠀⠀⣠⠴⣚⠭⠜⠛⢯⠀⡇⠀⠀⣀⣀⠤⠄⠒⠒⠉⠉⠀⣀⣀⠤⠔⠊⠁⠀⠀⠀
⠳⠄⠀⠀⠀⡇⢀⡼⢦⡀⣰⠋⠀⠀⠀⠀⠀⠀⠀⠀⢸⣏⣛⠓⠤⠤⡀⠘⡆⢇⣠⠞⢁⣠⠤⠤⠖⠒⠒⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠈⠀⠀⠀⡟⠋⠀⠀⣹⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⡈⠉⠙⠢⡝⡄⠳⡼⠃⡴⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⢀⠀⢀⡴⠃⠀⠀⡸⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠇⠀⠀⠀⠙⢸⡞⢠⠞⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⣻⠒⠋⠀⠀⠀⡰⠃⠀⠀⠀⠀⠀⠀⠀⣀⣀⠠⠤⠤⠼⡀⠀⠀⠀⠀⡞⢠⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠘⠁⠀⠀⠀⠀⡰⠁⠀⠀⢀⣠⠄⠒⠊⠉⠀⠀⠀⠀⠀⠀⠈⢢⡀⠀⢰⢡⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⢀⣼⣁⠤⠖⠊⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣽⣴⡾⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⢀⣠⠞⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣼⡟⠋⠁⠀⠀
    VOCÊ PENSOU QUE ACHOU UMA FUNÇÃO ESCONDIDA MAS ERA EU... DIOOOO WRYHHH""");
                return;}
                
                
                default -> {System.out.println("Opção inválida, tenta uma das opções do menu.");
                    Thread.sleep(2000);
                } 
            }
        }catch(Exception e){
            System.out.println("!!!!!! ERRO: " + e.getMessage());
        }
        
    }
        
    }

}
