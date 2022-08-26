package restaurante.controller;

import restaurante.model.produto.Produto;

public interface OpcoesControladorProduto {

    public boolean adicionarProduto(Produto produto) throws Exception;
    public boolean alterarDadosProduto(int codigo, double valor) throws Exception;
    public String listarProdutos() throws Exception;
    public boolean deletarProduto(int codigo) throws Exception;
    public boolean buscarProdutoPorCodigo(int codigo) throws Exception;

}
