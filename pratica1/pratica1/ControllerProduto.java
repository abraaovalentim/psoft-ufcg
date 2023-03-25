package pratica1;

import java.security.Provider.Service;

public class ControllerProduto{
    private ServiceProduto sp;

    ControllerProduto(){
        this.sp = new ServiceProduto();
    }

    public void addProduto(String id, String nome, String fabricante){
        sp.addProduto(id, nome, fabricante, 1);
    }

    public void addProduto(String id, String nome, String fabricante, int quant){
        sp.addProduto(id, nome, fabricante, quant);
    }

    public int removeProduto(String id){
        return sp.removeProduto(id, 1);
    }

    public int removeProduto(String id, int quant){
        return sp.removeProduto(id, quant);
    }

    public boolean mudaId(String id, String newId){
        return sp.mudaId(id, newId);
    }

    public boolean mudaNome(String id, String newNome){
        return sp.mudaNome(id, newNome);
    }

    public boolean mudaFabricante(String id, String newFabricante){
        return sp.mudaFabricante(id, newFabricante);
    }

    public String listaProdutos(){
        return this.sp.listaProdutos();
    }

    

}