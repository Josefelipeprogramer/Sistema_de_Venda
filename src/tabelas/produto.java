/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelas;

import Conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Nadine Miranda
 */
public class produto {
    private int codProduto;
    private String Nome;
    private int Qtd;
    private int codTipo;

    public void atualizarEstoqueProduto(int COD, int QTD){
        try{
            java.sql.Connection conn = Conexao.abrir();
            QTD = QTD + this.getQtdDB(COD);
            String query = "UPDATE produto SET QTD = (?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt (1, QTD);
            preparedStmt.execute();
            System.out.println("Produto atualizado com sucesso!");
            
        } catch (Exception e){
            System.out.println("Erro! Não foi possível verificar a quantidade deste produto!");
            System.out.println(e.getMessage());
        }
    }
    
    public int getQtdDB(int Cod) {
        try{
            java.sql.Connection conn = Conexao.abrir();
            String query = "SELECT QTD FROM produto WHERE COD_PRODUTO = " + Cod;
            Statement stmt = conn.createStatement();
            ResultSet rsst = stmt.executeQuery(query);
            Qtd = rsst.getInt("QTD");
            
        } catch (Exception e){
            System.out.println("Erro! Não foi possível verificar a quantidade deste produto!");
            System.out.println(e.getMessage());
        }
        
        return Qtd;
    }
    
    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getQtd() {
        return Qtd;
    }

    public void setQtd(int Qtd) {
        this.Qtd = Qtd;
    }

    public int getCodTipo() {
        return codTipo;
    }

    public void setCodTipo(int codTipo) {
        this.codTipo = codTipo;
    }
    
    
    
}
