/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelas;

import Conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *@author Rainan Miranda de Jesus
 * @author José Felipe Xavier
 * Data: 13/11/2017
 */
public class venda {
    private int codVenda;
    private int cpfVendedor;
    private double valorVenda;
    private Date dataVenda;
    
    public void vender(String NomeVendedor){
        try{
            java.sql.Connection conn = Conexao.abrir();
            String queryV = "SELECT vendedor.CPF_VENDEDOR FROM vendedor WHERE NOME = UPPER("+ NomeVendedor +")";
            Statement stmt = conn.createStatement();
            ResultSet rsst = stmt.executeQuery(queryV);
            this.cpfVendedor = rsst.getInt("CPF_VENDEDOR");
            Date data = new Date();
            this.setDataVenda(data);
            this.valorVenda=0;
            ArrayList<itemVenda> itens = new ArrayList();
            boolean keepAdding = true;
            while(!keepAdding){
                int Cod = Integer.parseInt(JOptionPane.showInputDialog("Codigo do produto a ser adicionado à venda: "));
                int qtd=0;
                boolean wrongValueqnt = true;
                produto P = new produto();
                produtoPreço PP = new produtoPreço();
                while(wrongValueqnt){
                    qtd = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade a ser vendida desse produto:"));
                    if(P.getQtdDB(Cod) >= qtd){
                        double precoUnit = PP.getAtualPrice(Cod, this.dataVenda);
                        this.valorVenda = this.valorVenda + (qtd*precoUnit);
                        wrongValueqnt = false;
                    } else{
                        System.out.println("Quantidade digitada inválida, existem " + P.getQtdDB(Cod) + " itens deste"
                                + " produto no estoque, digite uma quantidade menor ou igual a esta.");
                    }
                }
                
                itens.add(new itemVenda(this.cpfVendedor, Cod, qtd, this.dataVenda));
            }
            
            for (int i = 0; i < itens.size(); i++) {
                itens.get(i).putInDB();
            }
            
            this.gravarDB();
            
            conn.close();
            System.out.println("Venda finalizada!");
            System.out.println("Valor da venda: "+ this.valorVenda);
        }
        catch (Exception e){
            System.out.println("Venda não pode ser realizada!");
            System.out.println(e.getMessage());
        }
    }
    
    private void gravarDB(){
        try{
            java.sql.Connection conn = Conexao.abrir();
                String query = "INSERT INTO venda(CPF_VENDEDOR, DATA_VENDA, VALOR_VENDA)"
                    + " VALUES (?, "+ this.dataVenda +", ?)";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt (1, this.getCpfVendedor());
                preparedStmt.setDouble (2, this.valorVenda);
                preparedStmt.execute();
                System.out.println("Venda registrada com sucesso!");
            conn.close();
        } catch (Exception e){
            System.err.println("Erro:");
            System.err.println(e.getMessage());
        }
    }

    public int getCodVenda() {
        return codVenda;
    }

    private void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    public int getCpfVendedor() {
        return cpfVendedor;
    }

    private void setCpfVendedor(int cpfVendedor) {
        this.cpfVendedor = cpfVendedor;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    private void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }
    
    
    
}
