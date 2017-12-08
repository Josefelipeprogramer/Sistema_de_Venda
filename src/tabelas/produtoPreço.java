/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelas;

import Conexao.Conexao;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author Nadine Miranda
 */
public class produtoPreço {
    private int codProduto;
    private double precoAtual;
    
    public double getAtualPrice(int Cod, Date dataAtual){
        double Price=0;
        try{
            java.sql.Connection conn = Conexao.abrir();
            String query = "SELECT PREÇO_VENDA FROM produto_preço WHERE ("+dataAtual+">DATA_INICIO) AND ("+dataAtual+"<DATA_FIM)";
            Statement stmt = conn.createStatement();
            ResultSet rsst = stmt.executeQuery(query);
            Price = rsst.getDouble("PREÇO_VENDA");
            
        } catch (Exception e){
            System.out.println("Erro! Não foi possível pegar o valor do preço!");
            System.out.println(e.getMessage());
        }
        return Price;
    }
    
    public double getMedPriceCompra(int Cod, Date dataAtual){
        double Price=0;
        try{
            java.sql.Connection conn = Conexao.abrir();
            String query = "SELECT MEDIA_PREÇO_COMPRA FROM produto_preço WHERE ("+dataAtual+">DATA_INICIO) AND ("+dataAtual+"<DATA_FIM)";
            Statement stmt = conn.createStatement();
            ResultSet rsst = stmt.executeQuery(query);
            Price = rsst.getDouble("MEDIA_PREÇO_COMPRA");
            
        } catch (Exception e){
            System.out.println("Erro! Não foi possível pegar o valor do preço!");
            System.out.println(e.getMessage());
        }
        return Price;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public double getPrecoAtual() {
        return precoAtual;
    }

    public void setPrecoAtual(double precoAtual) {
        this.precoAtual = precoAtual;
    }
    
    
    
}
