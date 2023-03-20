package pratica1;
public class ServiceProduto {
    private RepositoryProduto rp;

    ServiceProduto(){}

    void addProduto(String id, String nome, String fabricante){
        Produto produto = new Produto(id, nome, fabricante);
        rp.addProduto(id, produto, 1);
    }

    void addProduto(String id, String nome, String fabricante, int quant){
        Produto produto = new Produto(id, nome, fabricante);
        rp.addProduto(id, produto, quant);
    }

    void removeProduto(String id){
        rp.removeProduto(id, 1);
    }

    void removeProduto(String id, int quant){
        rp.removeProduto(id, quant);
    }

    boolean mudaId(String id, String newId){
        boolean mi = false;
        Produto objeto = rp.getProduto(id);
        if (objeto != null){
            objeto.setId(newId);
            mi = true;
        }
        return mi;
    }

    boolean mudaNome(String id, String newNome){
        boolean mn = false;
        Produto objeto = rp.getProduto(id);
        if (objeto != null){
            objeto.setNome(newNome);
            mn = true;
        }
        return mn;
    }

    boolean mudaFabricante(String id, String newFabricante){
        boolean mn = false;
        Produto objeto = rp.getProduto(id);
        if (objeto != null){
            objeto.setFabricante(newFabricante);
            mn = true;
        }
        return mn;
    }
}
