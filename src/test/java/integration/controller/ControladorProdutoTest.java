//package integration.controller;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import restaurante.controller.ControladorProduto;
//import restaurante.dao.ProdutoDAO;
//import restaurante.model.produto.Baiao;
//import restaurante.model.produto.Cerveja;
//import restaurante.model.produto.Produto;
//import restaurante.model.produto.Sorvete;
//import restaurante.repository.BDProduto;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class ControladorProdutoTest {
//
//    @Mock
//    ProdutoDAO produtoDAOMock;
//    BDProduto bdProduto;
//
//    private ControladorProduto controladorProduto;
//
//    @BeforeEach
//    public void beforeEach(){
//        MockitoAnnotations.initMocks(this); //Ler anotações do mockito
//        this.controladorProduto = new ControladorProduto(produtoDAOMock); //Setando o mock do ProdutoDao no controlador
//    }
//
//    @Test
//    @DisplayName("Deveria adicionar um produto no banco (Sendo chamado pelo controlador)")
//    void adicionarProdutosBanco() throws Exception {
//
//        Produto produto = new Cerveja(1, 10, "Skol");
//
//        Mockito.when(produtoDAOMock.addProdutos(produto)).thenReturn(false);
//
//        boolean resultadoAddProduto = controladorProduto.adicionarProduto(produto);
//
//        //Verificar se o método addProdutos do mock foi executado pelo controlador
//        Mockito.verify(produtoDAOMock).addProdutos(produto);
//
//        assertFalse(resultadoAddProduto);
//    }
//
//    @Test
//    @DisplayName("Não deveria adicionar um produto no banco, retornando SQLexception (Sendo chamado pelo controlador)")
//    void naoAdicionarProdutosBanco() throws Exception {
//
//        Produto produto = new Cerveja(1, 10, "Skol");
//
//        //Manipular para receber uma SQLexception
//        Mockito.when(produtoDAOMock.addProdutos(Mockito.any())).thenThrow(SQLException.class);
//
//        try {
//            boolean resultadoAddProduto = controladorProduto.adicionarProduto(produto);
//        }catch (SQLException e){}
//
//    }
//
//
//    @Test
//    @DisplayName("Deveria deletar um produto do banco (Sendo chamado pelo controlador)")
//    void deletarProdutoDoBanco() throws Exception {
//
//        Mockito.when(produtoDAOMock.deletProduto(1)).thenReturn(false);
//
//        boolean resultadoDelProduto = controladorProduto.deletarProduto(1);
//
//        //Verificar se o método deletProduto do mock foi executado pelo controlador
//        Mockito.verify(produtoDAOMock).deletProduto(1);
//
//        assertFalse(resultadoDelProduto);
//    }
//
//    @Test
//    @DisplayName("Não deveria deletar um produto do banco, retornando SQLexception (Sendo chamado pelo controlador))")
//    void naoDeletarProdutoDoBanco() throws Exception {
//
//        //Manipular para receber uma SQLexception
//        Mockito.when(produtoDAOMock.deletProduto(1)).thenThrow(SQLException.class);
//
//        try {
//            boolean resultadoDelProduto = controladorProduto.deletarProduto(1);
//        }catch (SQLException e){}
//
//    }
//
//    @Test
//    @DisplayName("Deveria buscar um produto por código (Sendo chamado pelo controlador)")
//    void buscarProdutoPorCodigo() throws Exception {
//
//        Produto produto = new Cerveja(1, 10, "Skol");
//
//        Mockito.when(produtoDAOMock.buscarProdutoPorCodigo(Mockito.any())).thenReturn(produto);
//
//        Produto produtoBuscado = controladorProduto.buscarProdutoPorCodigo(1);
//
//        //Verificar se o método buscarProdutoPorCodigo do mock foi executado pelo controlador
//        Mockito.verify(produtoDAOMock).buscarProdutoPorCodigo(1);
//
//        assertEquals(1, produtoBuscado.getCodigoProduto());
//        assertEquals("Skol", produtoBuscado.getNomeProduto());
//        assertEquals(10, produtoBuscado.getValorUnitario());
//    }
//
//    @Test
//    @DisplayName("Não deveria retornar um produto por código, retornando SQLexception (Sendo chamado pelo controlador)")
//    void naoBuscarProdutoPorCodigo() throws Exception {
//
//        Produto produto = new Cerveja(1, 10, "Skol");
//
//        //Manipular para receber uma SQLexception
//        Mockito.when(produtoDAOMock.buscarProdutoPorCodigo(1)).thenThrow(SQLException.class);
//
//        try {
//            Produto produtoBuscado = controladorProduto.buscarProdutoPorCodigo(1);
//        }catch (SQLException e){}
//
//    }
//
//    @Test
//    @DisplayName("Deveria alterar um produto do banco (Sendo chamado pelo controlador)")
//    void alterarProdutoDoBanco() throws Exception {
//
//        Mockito.when(produtoDAOMock.alteraValorDoProduto(1, 20)).thenReturn(false);
//
//        boolean resultadoAlterarProduto = controladorProduto.alterarDadosProduto(1, 20);
//
//        //Verificar se o método alterarValorDoProduto do mock foi executado pelo controlador
//        Mockito.verify(produtoDAOMock).alteraValorDoProduto(1, 20);
//
//        assertFalse(resultadoAlterarProduto);
//    }
//
//    @Test
//    @DisplayName("Não deveria alterar um produto do banco, retornando SQLexception (Sendo chamado pelo controlador)")
//    void naoAlterarProdutoDoBanco() throws Exception {
//
//        //Manipular para receber uma SQLexception
//        Mockito.when(produtoDAOMock.alteraValorDoProduto(1, 45)).thenThrow(SQLException.class);
//
//        try {
//            boolean resultadoAlterarProduto = controladorProduto.alterarDadosProduto(1, 20);
//        }catch (SQLException e){}
//
//    }
//
//    @Test
//    @DisplayName("Deveria buscar lista de produtos no banco (Sendo chamado pelo controlador)")
//    void buscarProdutosBanco() throws Exception {
//
//        Mockito.when(produtoDAOMock.listProdutosDisponiveis()).thenReturn(criarListaProdutos());
//
//        ArrayList<Produto> arrayProdutos = controladorProduto.listarProdutos();
//
//        //Verificar se o método listProdutosDisponiveis do mock foi executado pelo controlador
//        Mockito.verify(produtoDAOMock).listProdutosDisponiveis();
//
//        assertFalse(arrayProdutos.isEmpty());
//        assertEquals("Kibom", arrayProdutos.get(0).getNomeProduto());
//        assertEquals("De dois", arrayProdutos.get(1).getNomeProduto());
//    }
//
//    @Test
//    @DisplayName("Não deveria retornar lista de produtos do banco, retornando SQLexception (Sendo chamado pelo controlador)")
//    void naoBuscarProdutosBanco() throws Exception {
//
//        //Manipular para receber uma SQLexception
//        Mockito.when(produtoDAOMock.listProdutosDisponiveis()).thenThrow(SQLException.class);
//
//        try {
//            ArrayList<Produto> arrayProdutos = controladorProduto.listarProdutos();
//        }catch (SQLException e){}
//
//    }
//
//    private ArrayList<Produto> criarListaProdutos(){
//        ArrayList<Produto> arrayProdutos = new ArrayList<>();
//
//        arrayProdutos.add(new Sorvete(1, 5, "Kibom"));
//        arrayProdutos.add(new Baiao(2, 20, "De dois"));
//        arrayProdutos.add(new Cerveja(3, 10, "Skol"));
//
//        return arrayProdutos;
//    }
//
//}
