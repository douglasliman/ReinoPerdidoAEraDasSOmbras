    package Entity;

    import java.util.List;

    public class Arqueiro extends Personagem{
        private int destreza;

        public Arqueiro(String nome, int pontosVida, int pontosMana, int pontosAtaque, int pontosDefesa, int nivel, int experiencia, int gold, List<Habilidade> habilidades, TipoEfeito efeito, int turnosEfeito, int destreza) {
            super(nome, pontosVida, pontosMana, pontosAtaque, pontosDefesa, nivel, experiencia, gold, habilidades, efeito, turnosEfeito);
            this.destreza = destreza;
        }

        public Arqueiro(){

        }


        public Arqueiro(int destreza) {
            this.destreza = destreza;
        }

        public int getDestreza() {
            return destreza;
        }

        public void setDestreza(int destreza) {
            this.destreza = destreza;
        }
    }

