package pratica1;

import java.util.HashMap;

public class RepositoryProduto {
    private HashMap<String,Produto> produtos;

    RepositoryProduto(){ }

    void addProduto(String id, Produto produto, int quant){
        if(produtos.containsKey(id)){
            getProduto(id).soma(quant);
        } else {
            produtos.put(id, produto);
        }
    }

    void removeProduto(String id, int quant){
        if(produtos.containsKey(id)){
            if(getProduto(id).getQuantidade() > quant){
                getProduto(id).vende(quant);
            } else {
                produtos.remove(id);
            }
        }
    }

    Produto getProduto(String id){
        if(produtos.containsKey(id)){
            return produtos.get(id);
        }
        return null;
    }
}
