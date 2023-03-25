package pratica1;

public class Produto {
    private String id;
    private String nome;
    private String fabricante;
    private int quantidade;

    Produto(String id, String nome, String fabricante){
        this.id = id;
        this.nome = nome;
        this.fabricante = fabricante;
    }

    public String toString(){
        return id + " - " + this.nome + " " + this.fabricante + " - " + this.quantidade;
    }

    public String getId(){
        return this.id;
    }

    public String getNome(){
        return this.nome;
    }

    public String getFabricante(){
        return this.fabricante;
    }

    public int getQuantidade(){
        return this.quantidade;
    }

    public void setId(String newId){
     this.id = newId;
    }

    public void setNome(String newNome){
        this.nome = newNome;
    }

    public void setFabricante(String newFabricante){
        this.id = newFabricante;
    }

    public void soma(int quant){
        this.quantidade += quant;
    }

    public void vende(int quant){
        this.quantidade -= quant;
    }
}

