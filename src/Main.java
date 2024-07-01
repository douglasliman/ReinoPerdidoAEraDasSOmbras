import Entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arqueiro heroi = new Arqueiro();
        heroi.setNome("Guerreiro");
        heroi.setPontosVida(100);
        heroi.setPontosMana(50);
        heroi.setPontosAtaque(20);
        heroi.setPontosDefesa(15);
        heroi.setNivel(1);
        heroi.setExperiencia(0);
        heroi.setGold(0);

        List<Item> itensDisponiveis = new ArrayList<>();
        itensDisponiveis.add(new Item("Espada", 5, 0, 0, 0, 0, 0, 50, "Comum"));
        //FACA INIMIGO
        Inimigo inimigo = new Inimigo();
        inimigo.setNome("Goblin");
        inimigo.setPontosVida(50);
        inimigo.setPontosMana(0);
        inimigo.setPontosAtaque(10);
        inimigo.setPontosDefesa(5);
        inimigo.setNivel(1);
        inimigo.setExperiencia(20);
        inimigo.setRecompensaGold(40);
        inimigo.setExperiencia(50);
        inimigo.setGold(10);
        inimigo.setITENS_DISPONIVEIS(itensDisponiveis);



        boolean jogando = true;

        while (jogando) {
            System.out.println("Bem-vindo ao RPG de Turno!");
            System.out.println("1. Iniciar batalha");
            System.out.println("2. Ver status do herói");
            System.out.println("3. Sair do jogo");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    iniciarBatalha(heroi, inimigo, scanner);
                    break;
                case 2:
                    verStatusHeroi(heroi);
                    break;
                case 3:
                    jogando = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }

        System.out.println("Obrigado por jogar!");
    }

    public static void iniciarBatalha(Personagem heroi, Inimigo inimigo, Scanner scanner) {
        System.out.println("Você encontrou um " + inimigo.getNome() + "!");
        boolean batalha = true;

        while (batalha) {
            System.out.println("1. Atacar");
            System.out.println("2. Defender");
            System.out.println("3. Fugir");
            System.out.print("Escolha uma ação: ");
            int acao = scanner.nextInt();

            switch (acao) {
                case 1:
                    heroi.atacar(inimigo);
                    if (inimigo.getPontosVida() <= 0) {
                        System.out.println("Você derrotou o " + inimigo.getNome() + "!");
                        inimigo.morrer(heroi);
                        heroi.ganharExperiencia(inimigo.getRecompensaXp());
                        heroi.setGold(heroi.getGold() + inimigo.getRecompensaGold());
                        inimigo.dropItens();
                        batalha = false;
                    } else {
                        inimigo.atacar(heroi);
                    }
                    if (heroi.getPontosVida() <= 0) {
                        System.out.println("Você foi derrotado! Fim de jogo.");
                        System.exit(0);
                    }
                    break;
                case 2:
                    System.out.println("Você se defendeu.");
                    heroi.defender(inimigo.getPontosAtaque());
                    break;
                case 3:
                    System.out.println("Você fugiu da batalha.");
                    batalha = false;
                    break;
                default:
                    System.out.println("Ação inválida! Tente novamente.");
            }
        }
    }

    public static void verStatusHeroi(Personagem heroi) {
        System.out.println("Status do Herói:");
        System.out.println("Nome: " + heroi.getNome());
        System.out.println("Vida: " + heroi.getPontosVida());
        System.out.println("Mana: " + heroi.getPontosMana());
        System.out.println("Ataque: " + heroi.getPontosAtaque());
        System.out.println("Defesa: " + heroi.getPontosDefesa());
        System.out.println("Nível: " + heroi.getNivel());
        System.out.println("Experiência: " + heroi.getExperiencia());
        System.out.println("Gold: " + heroi.getGold());
    }
}
