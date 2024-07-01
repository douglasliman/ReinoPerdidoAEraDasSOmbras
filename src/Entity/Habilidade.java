package Entity;

public class Habilidade {
    private String nome;
    private Tipo tipo;
    private int poder;
    private int danoBase;
    private int custoMana;

    public Habilidade(String nome, Tipo tipo, int poder, int danoBase, int custoMana) {
        this.nome = nome;
        this.tipo = tipo;
        this.poder = poder;
        this.danoBase = danoBase;
        this.custoMana = custoMana;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    public int getDanoBase() {
        return danoBase;
    }

    public void setDanoBase(int danoBase) {
        this.danoBase = danoBase;
    }

    public int getCustoMana() {
        return custoMana;
    }

    public void setCustoMana(int custoMana) {
        this.custoMana = custoMana;
    }
}
