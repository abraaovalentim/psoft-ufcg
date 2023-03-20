package pratica1;
public class ServiceProduto {
    private RepositoryProduto rp;

    ServiceProduto(){}

    void criaObjeto(String id, String nome, String fabricante){
        Produto produto = new Produto(id, nome, fabricante);
        rp.addProduto(id, produto);
    }
}
