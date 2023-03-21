package pratica1;

import java.util.HashMap;

public class RepositoryProduto {
    private HashMap<String,Produto> produtos;

    RepositoryProduto(){
        this.produtos = new HashMap<>();
    }

    public void addProduto(String id, Produto produto, int quant){
        if(produtos.containsKey(id)){
            getProduto(id).soma(quant);
        } else {
            produtos.put(id, produto);
        }
    }

    public int removeProduto(String id, int quant){
        int removidos = 0;
        if(produtos.containsKey(id)){
            if(getProduto(id).getQuantidade() > quant){
                getProduto(id).vende(quant);
                removidos = quant;
            } else {
                removidos = quant;
                produtos.remove(id);
            }
        }
        return removidos;
    }

    public Produto getProduto(String id){
        if(produtos.containsKey(id)){
            return produtos.get(id);
        }
        return null;
    }

    public String listaProdutos(){
        String lista = "Lista de Produtos Atuais: /n ----- /n";
      for (String id : produtos.keySet()) {
        lista += getProduto(id).toString() + "/n";
      }  
      return lista;
    }
}
