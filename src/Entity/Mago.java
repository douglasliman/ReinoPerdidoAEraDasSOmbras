package Entity;

import java.util.List;

public class Mago extends Personagem{
    private int inteligencia;

    public Mago(String nome, int pontosVida, int pontosMana, int pontosAtaque, int pontosDefesa, int nivel, int experiencia, int gold, List<Habilidade> habilidades, TipoEfeito efeito, int turnosEfeito, int inteligencia) {
        super(nome, pontosVida, pontosMana, pontosAtaque, pontosDefesa, nivel, experiencia, gold, habilidades, efeito, turnosEfeito);
        this.inteligencia = inteligencia;
    }

    public Mago(){

    }
    public Mago(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    @Override
    public int calcularDano(Personagem inimigo) {
        return Math.max(getInteligencia()  + getPontosAtaque() - inimigo.getPontosDefesa(), 0);
    }

    @Override
    public void atacar(Personagem inimigo){
        int dano = calcularDano(inimigo);
        inimigo.setPontosVida(inimigo.getPontosVida() - dano);

        System.out.println("Ataque tirou " + dano + " de vida do: " + inimigo.getNome());
        System.out.println("Vida atual do " + inimigo.getNome() + ": " + inimigo.getPontosVida());

    }


    @Override
    public void subirNivel() {
        super.subirNivel();
        System.out.println("Inteligência: " + " (+7)");
    }
    public void ganharExperiencia(int xp) {
        if(getExperiencia() >= 100){
            subirNivel();
        }
        setExperiencia(getExperiencia() + xp);
        System.out.println("Você ganhou " + xp + " de experiência!");
        if (getNivel() >= 5){
            System.out.println("Ao chegar no nivel 10 você pode evoluir para mago superior");
        }
    }
    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }
}
