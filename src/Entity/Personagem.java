package Entity;

import java.util.ArrayList;
import java.util.List;

public abstract  class Personagem {
   private String nome;
    private int pontosVida;
    private int pontosMana;
    private int pontosAtaque;
    private int pontosDefesa;
    private int nivel;
    private int experiencia;
    private int gold;
    private List<Habilidade> habilidades;
    private TipoEfeito efeito;
    private int turnosEfeito;

    public Personagem(String nome, int pontosVida, int pontosMana, int pontosAtaque, int pontosDefesa, int nivel, int experiencia, int gold, List<Habilidade> habilidades, TipoEfeito efeito, int turnosEfeito) {
        this.nome = nome;
        this.pontosVida = pontosVida;
        this.pontosMana = pontosMana;
        this.pontosAtaque = pontosAtaque;
        this.pontosDefesa = pontosDefesa;
        this.nivel = nivel;
        this.experiencia = experiencia;
        this.gold = gold;
        this.habilidades = new ArrayList<>();;
        this.efeito = null ;
        this.turnosEfeito = turnosEfeito;
    }

    public Personagem(){

    }

    public void aplicarEfeito(TipoEfeito efeito) {
        if (efeito != null) {
            switch (efeito) {
                case ENVENENADO:
                    if (turnosEfeito % 2 == 0) { // Aplica a cada dois turnos
                        this.pontosVida -= 6;
                        System.out.println(nome + " está envenenado e perde 6 pontos de vida!");
                    }
                    break;
                case ATORDOADO:
                    if (turnosEfeito == 0) {
                        System.out.println(nome + " está atordoado e não pode atacar neste turno!");
                    }
                    break;
                case QUEIMADO:
                    if (turnosEfeito % 2 == 0) { // Aplica a cada dois turnos
                        this.pontosVida -= 12;
                        System.out.println(nome + " está queimando e perde 12 pontos de vida!");
                    }
                    break;
                case DORMINDO:
                    if (turnosEfeito == 0) {
                        System.out.println(nome + " está dormindo e não pode atacar neste turno!");
                    }
                    break;
            }
            turnosEfeito++;
            if (turnosEfeito == 2 && efeito == TipoEfeito.DORMINDO) { // Magos conseguem acordar o inimigo.
                System.out.println(nome + " está acordado.");
            }
        }
    }
    public int calcularDano(Personagem inimigo) {
        return Math.max(0, this.pontosAtaque - inimigo.pontosDefesa);
    }

    public void atacar(Personagem inimigo) {
        int dano = calcularDano(inimigo);
        aplicarEfeitoAleatorio(inimigo);
        if (Math.random() * 100 > 70) {
            ataqueCritico(inimigo);

        } else {
            inimigo.setPontosVida(inimigo.getPontosVida() + inimigo.getPontosDefesa() - dano);
            System.out.println(getNome() + " atacou " + inimigo.getNome() + " e causou " + dano + " de dano.");
            System.out.println("Vida atual do " + inimigo.getNome() + ": " + inimigo.getPontosVida());
        }
    }
    private void aplicarEfeitoAleatorio(Personagem inimigo) {
        int chance = (int) (Math.random()*100);
        if (this instanceof Guerreiro && chance < 40) {
            inimigo.aplicarEfeito(TipoEfeito.ATORDOADO);
            System.out.println(inimigo.getNome() + " foi atordoado!");
        } else if (this instanceof Arqueiro || this instanceof Mago) {
            if (chance < 10) {
                inimigo.aplicarEfeito(TipoEfeito.ENVENENADO);
                System.out.println(inimigo.getNome() + " foi envenenado!");
            } else if (chance < 20) {
                inimigo.aplicarEfeito(TipoEfeito.QUEIMADO);
                System.out.println(inimigo.getNome() + " foi queimado!");
            } else if (this instanceof Mago && chance < 20) {
                inimigo.aplicarEfeito(TipoEfeito.DORMINDO);
                System.out.println(inimigo.getNome() + " foi colocado para dormir!");
            }
        }
    }

    public void ataqueCritico(Personagem inimigo) {
        int dano = (int) (calcularDano(inimigo) * 1.5);
        inimigo.setPontosVida(inimigo.getPontosVida() + inimigo.getPontosDefesa() - dano);
        System.out.println("Ataque crítico!");
        System.out.println(getNome() + " atacou " + inimigo.getNome() + " e causou " + dano + " de dano.");
        System.out.println("Vida atual do " + inimigo.getNome() + ": " + inimigo.getPontosVida());
    }

    public void subirNivel() {
        System.out.println("Parabéns, você subiu de nível!");
        System.out.println("Seus atributos aumentaram!");

        nivel++;
        experiencia = 0;
        pontosVida += 10;
        pontosMana += 10;
        pontosAtaque += 10;
        pontosDefesa += 10;

        System.out.println("Vida: " + getPontosVida());
        System.out.println("Mana: " + getPontosMana());
        System.out.println("Ataque: " + getPontosAtaque());
        System.out.println("Defesa: " + getPontosDefesa());
        System.out.println("Nível: " + getNivel());
        setExperiencia(0);

    }

    public void ganharExperiencia(int xp) {
        if (getExperiencia() >= 100) {
            subirNivel();
        }
        setExperiencia(xp);
        System.out.println("Você ganhou " + xp + " de experiência!");

    }

    public void faltaExperiencia(int xp) {
        if (getExperiencia() < 100) {
            System.out.println("Você precisa de mais " + (100 - getExperiencia()) + " de experiência para subir de nível!");
        }
    }



    public void defender(int quantidadeDano) {
        int defesa = getPontosDefesa() + getPontosVida() - quantidadeDano;
        if (defesa < quantidadeDano) {
            setPontosVida(defesa - quantidadeDano);
            System.out.println("Dano recebido: " + quantidadeDano);
            System.out.println("Vida atual: " + getPontosVida());
        } else {
            System.out.println("Sua defesa segurou o dano recebido");
            System.out.println("Vida atual: " + getPontosVida());
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontosVida() {
        return pontosVida;
    }

    public void setPontosVida(int pontosVida) {
        this.pontosVida = pontosVida;
    }

    public int getPontosMana() {
        return pontosMana;
    }

    public void setPontosMana(int pontosMana) {
        this.pontosMana = pontosMana;
    }

    public int getPontosAtaque() {
        return pontosAtaque;
    }

    public void setPontosAtaque(int pontosAtaque) {
        this.pontosAtaque = pontosAtaque;
    }

    public int getPontosDefesa() {
        return pontosDefesa;
    }

    public void setPontosDefesa(int pontosDefesa) {
        this.pontosDefesa = pontosDefesa;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public List<Habilidade> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Habilidade> habilidades) {
        this.habilidades = habilidades;
    }
}
