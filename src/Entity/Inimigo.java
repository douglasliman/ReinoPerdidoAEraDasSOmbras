package Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Inimigo extends Personagem{
    private int forca;
    private Tipo tipo;
    private int RecompensaXp;
    private int RecompensaGold;
    private List<Item> ITENS_DISPONIVEIS;

    public Inimigo(String nome, int pontosVida, int pontosMana, int pontosAtaque, int pontosDefesa, int nivel, int experiencia, int gold, List<Habilidade> habilidades, TipoEfeito efeito, int turnosEfeito, int forca, Tipo tipo, int recompensaXp, int recompensaGold, List<Item> ITENS_DISPONIVEIS) {
        super(nome, pontosVida, pontosMana, pontosAtaque, pontosDefesa, nivel, experiencia, gold, habilidades, efeito, turnosEfeito);
        this.forca = forca;
        this.tipo = tipo;
        RecompensaXp = recompensaXp;
        RecompensaGold = recompensaGold;
        this.ITENS_DISPONIVEIS = new ArrayList<>();
    }



    public Inimigo(){

    }

    public void dropItens() {
        Random random = new Random();
        for (Item item : ITENS_DISPONIVEIS) {
            if (random.nextInt(100) < item.getChanceDeDrop()) {
                System.out.println(getNome() + " dropou: " + item.getNome());
            }
        }
    }
    public int calcularDano(Personagem heroi) {
        return Math.max(0, getPontosAtaque() + getForca() - heroi.getPontosDefesa());
    }

    @Override
    public void atacar(Personagem heroi) {
        System.out.println("========================");
        System.out.println("Turno do " + getNome() + "!");
        int dano = calcularDano(heroi);

        if (Math.random() * 100 > 90) {
            ataqueCritico(heroi);
        } else {
            heroi.setPontosVida(heroi.getPontosVida() - dano);
            System.out.println("Ataque do " + getNome() + " tirou: " + dano + " de vida do: " + heroi.getNome());
            System.out.println("Vida atual do " + heroi.getNome() + " é: " + heroi.getPontosVida());
            System.out.println("========================");
        }
    }

    public void ataqueCritico(Personagem heroi) {
        int dano = (int) (calcularDano(heroi) * 1.5);
        heroi.setPontosVida(heroi.getPontosVida() - dano);
        System.out.println("Ataque crítico!");
        System.out.println("Ataque do " + getNome() + " tirou: " + dano + " de vida do: " + heroi.getNome());
        System.out.println("Vida atual do " + heroi.getNome() + " é: " + heroi.getPontosVida());
    }

    public void morrer(Personagem heroi){

        heroi.setExperiencia(getExperiencia() + RecompensaXp);
        heroi.setGold(heroi.getGold() + RecompensaGold);
        dropItens();
        ganharExperiencia(RecompensaXp);
    }


    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public int getRecompensaXp() {
        return RecompensaXp;
    }

    public void setRecompensaXp(int recompensaXp) {
        RecompensaXp = recompensaXp;
    }

    public int getRecompensaGold() {
        return RecompensaGold;
    }

    public void setRecompensaGold(int recompensaGold) {
        RecompensaGold = recompensaGold;
    }

    public List<Item> getITENS_DISPONIVEIS() {
        return ITENS_DISPONIVEIS;
    }

    public void setITENS_DISPONIVEIS(List<Item> ITENS_DISPONIVEIS) {
        this.ITENS_DISPONIVEIS = ITENS_DISPONIVEIS;
    }
}
