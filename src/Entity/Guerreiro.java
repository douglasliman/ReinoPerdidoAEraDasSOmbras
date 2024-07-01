package Entity;

import java.util.ArrayList;
import java.util.List;

public class Guerreiro extends Personagem{
    private int forca;
    private int carisma;

    public Guerreiro(String nome, int pontosVida, int pontosMana, int pontosAtaque, int pontosDefesa, int nivel, int experiencia, int gold, List<Habilidade> habilidades, TipoEfeito efeito, int turnosEfeito, int forca, int carisma) {
        super(nome, pontosVida, pontosMana, pontosAtaque, pontosDefesa, nivel, experiencia, gold, habilidades, efeito, turnosEfeito);
        this.forca = forca;
        this.carisma = carisma;
    }

    public Guerreiro(int forca, int carisma) {
        this.forca = forca;
        this.carisma = carisma;
    }

    public Guerreiro() {

    }



    @Override
    public int calcularDano(Personagem inimigo) {
        return Math.max(0, getPontosAtaque() + getForca() - inimigo.getPontosDefesa());

    }
    @Override
    public void atacar(Personagem inimigo) {
        System.out.println("========================");
        System.out.println("Turno do " + getNome() + "!");
        int dano = calcularDano(inimigo);

        if (Math.random() * 100 > 90) {
            ataqueCritico(inimigo);
        } else {
            inimigo.setPontosVida(inimigo.getPontosVida() - dano);
            System.out.println("Ataque do " + getNome() + " tirou: " + dano + " de vida do: " + inimigo.getNome());
            System.out.println("Vida atual do " + inimigo.getNome() + " é: " + inimigo.getPontosVida());
            System.out.println("========================");
        }
    }

    public void ataqueCritico(Personagem inimigo) {
        int dano = (int) (calcularDano(inimigo) * 1.5);
        inimigo.setPontosVida(inimigo.getPontosVida() - dano);
        System.out.println("Ataque crítico!");
        System.out.println("Ataque do " + getNome() + " tirou: " + dano + " de vida do: " + inimigo.getNome());
        System.out.println("Vida atual do " + inimigo.getNome() + " é: " + inimigo.getPontosVida());
    }





    @Override
    public void subirNivel() {

        System.out.println("O personagem " + getNome() + " subiu de nível!");


        setNivel(getNivel() + 1);
        setPontosVida(getPontosVida() + 10);
        setPontosMana(getPontosMana() + 5);
        setPontosAtaque(getPontosAtaque() + 5);
        setPontosDefesa(getPontosDefesa() + 5);
        setForca(getForca() + 5);
        setExperiencia(0);

        System.out.println("Vida: " + getPontosVida());
        System.out.println("Mana: " + getPontosMana());
        System.out.println("Ataque: " + getPontosAtaque());
        System.out.println("Defesa: " + getPontosDefesa() );
        System.out.println("Força: " + getForca());
        System.out.println("Nível: " + getNivel());

    }
    @Override
    public void ganharExperiencia(int xp) {
        setExperiencia(getExperiencia()+ xp);
        if(getExperiencia() >= 100){
            subirNivel();

        }

        System.out.println("Você ganhou " + xp + " de experiência!");

    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getCarisma() {
        return carisma;
    }

    public void setCarisma(int carisma) {
        this.carisma = carisma;
    }
}

