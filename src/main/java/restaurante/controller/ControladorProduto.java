package restaurante.controller;

import restaurante.dao.ProdutoDAO;
import restaurante.model.produto.*;
import restaurante.repository.BDProduto;

public class ControladorProduto extends Controlador implements OpcoesControladorProduto {

    private ProdutoDAO produtoDAO;
    private BDProduto BDProduto;

    public ControladorProduto(ProdutoDAO produtoDAO, BDProduto BDProduto){
        this.produtoDAO = produtoDAO;
        this.BDProduto = BDProduto;
    }

    public boolean adicionarProduto(Produto produto) throws Exception {
//        return produtoDAO.addProdutos(produto);
        BDProduto.adicionarProduto(produto);

        return true;
    }

    public boolean alterarDadosProduto(int codigo, double valor) throws Exception {

        instanciarAtributos();

//        return produtoDAO.alteraValorDoProduto(codigo, valor);

        //DAOProduto.alterarDadosProduto(cod, valor);

        BDProduto.alterarDadosProduto(codigo, valor);
        return true;
    }

//    public ArrayList<Produto> listarProdutos() throws Exception {
    public String listarProdutos() throws Exception {

        instanciarAtributos();

//        return produtoDAO.listProdutosDisponiveis();

//        return bdProduto.listarProdutosDisponiveis();
        return BDProduto.listarProdutosDisponiveis();
    }

    public boolean deletarProduto(int codigo) throws Exception {

        instanciarAtributos();

//        return produtoDAO.deletProduto(codigo);

        //DAOProduto.deletarProduto(cod);
        BDProduto.deletarProduto(codigo);

        return true;
    }


    public boolean buscarProdutoPorCodigo(int codigo) throws Exception {

        instanciarAtributos();

//        return produtoDAO.buscarProdutoPorCodigo(codigo);
        BDProduto.procurarProduto(codigo);

        return true;
    }
}
