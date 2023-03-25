package pratica1;
public class ServiceProduto {
    private RepositoryProduto rp;

    ServiceProduto(){
        this.rp = new RepositoryProduto();
    }

    public void addProduto(String id, String nome, String fabricante, int quant){
        Produto produto = new Produto(id, nome, fabricante);
        rp.addProduto(id, produto, quant);
    }

    public int removeProduto(String id, int quant){
        return rp.removeProduto(id, quant);
    }

    public boolean mudaId(String id, String newId){
        boolean mi = false;
        Produto objeto = rp.getProduto(id);
        if (objeto != null){
            objeto.setId(newId);
            mi = true;
        }
        return mi;
    }

    public boolean mudaNome(String id, String newNome){
        boolean mn = false;
        Produto objeto = rp.getProduto(id);
        if (objeto != null){
            objeto.setNome(newNome);
            mn = true;
        }
        return mn;
    }

    public boolean mudaFabricante(String id, String newFabricante){
        boolean mn = false;
        Produto objeto = rp.getProduto(id);
        if (objeto != null){
            objeto.setFabricante(newFabricante);
            mn = true;
        }
        return mn;
    }

    public String listaProdutos(){
        return this.rp.listaProdutos();
    }
}
