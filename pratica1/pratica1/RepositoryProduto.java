package pratica1;

import java.util.HashMap;

public class RepositoryProduto {
    private HashMap<String,Produto> produtos;

    RepositoryProduto(){ }

    void addProduto(String id, Produto produto){
        produtos.put(id, produto);
    }

    Produto getProduto(String id){
        return produtos.get(id);
    }
}
