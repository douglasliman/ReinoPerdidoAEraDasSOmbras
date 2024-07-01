package Entity;

public class Item {
    private String nome;
    private int forca;
    private int defesa;
    private int destreza;
    private int inteligencia;
    private int vida;
    private int mana;
    private int chanceDeDrop;
    private String raridade;

    public Item(String nome, int forca, int defesa, int destreza, int inteligencia, int vida, int mana, int chanceDeDrop, String raridade) {
        this.nome = nome;
        this.forca = forca;
        this.defesa = defesa;
        this.destreza = destreza;
        this.inteligencia = inteligencia;
        this.vida = vida;
        this.mana = mana;
        this.chanceDeDrop = chanceDeDrop;
        this.raridade = raridade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getChanceDeDrop() {
        return chanceDeDrop;
    }

    public void setChanceDeDrop(int chanceDeDrop) {
        this.chanceDeDrop = chanceDeDrop;
    }

    public String getRaridade() {
        return raridade;
    }

    public void setRaridade(String raridade) {
        this.raridade = raridade;
    }
}
