package restaurante.view;

//import restaurante.controller.ControladorPedido;
import restaurante.controller.ControladorProduto;
import restaurante.dao.ProdutoDAO;
import restaurante.repository.BDProduto;

import java.util.Scanner;

public class View {

    protected ViewMenu viewMenu;
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
        this.controladorProduto = new ControladorProduto(ProdutoDAO, bdProduto);
        this.viewAcesso = new ViewAcesso();
        this.end = false;
    }

}
