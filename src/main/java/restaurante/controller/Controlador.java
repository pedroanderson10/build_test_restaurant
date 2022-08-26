package restaurante.controller;

import restaurante.dao.ProdutoDAO;
import restaurante.repository.BDProduto;
import restaurante.view.ViewAcesso;
import restaurante.view.ViewMenu;

import java.util.Scanner;

public class Controlador {

    protected ViewMenu viewMenu;
    //protected ControladorPedido controladorPedido;
    protected ControladorProduto controladorProduto;
    protected ViewAcesso viewAcesso;
    protected Scanner scan;
    protected int escolhaUsuario;
    protected boolean end;
    private ProdutoDAO ProdutoDAO = new ProdutoDAO();

    private BDProduto bdProduto = new BDProduto();

    public void instanciarAtributos(){
        this.scan = new Scanner(System.in);
        this.viewMenu = new ViewMenu();
        //this.controladorPedido = new ControladorPedido();
        this.controladorProduto = new ControladorProduto(ProdutoDAO, bdProduto);
        this.viewAcesso = new ViewAcesso();
        this.end = false;
    }

}
