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

    String getId(){
        return this.id;
    }

    String getNome(){
        return this.nome;
    }

    String getFabricante(){
        return this.fabricante;
    }

    int getQuantidade(){
        return this.quantidade;
    }

    void setId(String newId){
     this.id = newId;
    }

    void setNome(String newNome){
        this.nome = newNome;
    }

    void setFabricante(String newFabricante){
        this.id = newFabricante;
    }

    void soma(int quant){
        this.quantidade += quant;
    }

    void vende(int quant){
        this.quantidade -= quant;
    }
}

