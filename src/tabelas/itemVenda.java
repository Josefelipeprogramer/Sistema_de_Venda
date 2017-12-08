
package tabelas;

import Conexao.Conexao;
import java.sql.PreparedStatement;
import java.util.Date;

/**
 *
 *@author Rainan Miranda de Jesus
 * @author José Felipe Xavier
 * Data: 13/11/2017
 */
public class itemVenda {
    private int codItem;
    private int cpfVendedor;
    private int cpfCliente;
    private int codProduto;
    private int qtd;
    private Date dataVenda;

    public itemVenda(int cpfVendedor, int codProduto, int qtd, Date dataVenda) {
        this.cpfVendedor = cpfVendedor;
        this.codProduto = codProduto;
        this.qtd = qtd;
        this.dataVenda = dataVenda;
    }
    
    public void putInDB (){
        try{
            java.sql.Connection conn = Conexao.abrir();
                String query = "INSERT INTO item_venda(CPF_VENDEDOR, COD_PRODUTO, QTD, DATA_VENDA)"
                    + " VALUES (?, ?, ?, "+ this.dataVenda +")";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt (1, this.cpfVendedor);
                preparedStmt.setInt (2, this.codProduto);
                preparedStmt.setInt (3, this.qtd);
                preparedStmt.execute();
                System.out.println("Item registrado com sucesso!");
            conn.close();
        } catch (Exception e){
            System.out.println("Erro! Não foi possível adicionar o item.");
            System.out.println(e.getMessage());
        }
    }
    

    public int getCodItem() {
        return codItem;
    }

    private void setCodItem(int codItem) {
        this.codItem = codItem;
    }

    public int getCpfVendedor() {
        return cpfVendedor;
    }

    private void setCpfVendedor(int cpfVendedor) {
        this.cpfVendedor = cpfVendedor;
    }

    public int getCpfCliente() {
        return cpfCliente;
    }

    private void setCpfCliente(int cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public int getCodProduto() {
        return codProduto;
    }

    private void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public int getQtd() {
        return qtd;
    }

    private void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    private void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }
    
    
}
