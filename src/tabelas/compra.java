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
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *@author Rainan Miranda de Jesus
 * @author José Felipe Xavier
 * Data: 08/12/2017
 */
public class compra {
    private int codCompra;
    private double valorCompra;
    private Date dataCompra;
    
    public void comprar(){
        try{
            java.sql.Connection conn = Conexao.abrir();
            Date data = new Date();
            this.setDataCompra(data);
            this.setValorCompra(0);
            boolean keepAdding = true;
            while(!keepAdding){
                int Cod = Integer.parseInt(JOptionPane.showInputDialog("Codigo do produto comprado: "));
                int qtd= Integer.parseInt(JOptionPane.showInputDialog("Quantidade adicionada deste produto: "));
                produto P = new produto();
                P.atualizarEstoqueProduto(Cod, qtd);
                produtoPreço PP = new produtoPreço();
                double precoUnit = PP.getMedPriceCompra(Cod, this.dataCompra);
                this.setValorCompra(this.getValorCompra() + (qtd*precoUnit));
            }
            
            this.gravarDB();
            
            conn.close();
            System.out.println("Atualização finalizada!");
            System.out.println("Valor da compra: "+ this.getValorCompra());
        }
        catch (Exception e){
            System.out.println("Atualização não pode ser realizada!");
            System.out.println(e.getMessage());
        }
    }
    
    private void gravarDB(){
        try{
            java.sql.Connection conn = Conexao.abrir();
                String query = "INSERT INTO compra(DATA_VENDA)"
                    + " VALUES ("+ this.getDataCompra() +", "+ this.getValorCompra() +")";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.execute();
                System.out.println("Venda registrada com sucesso!");
            conn.close();
        } catch (Exception e){
            System.err.println("Erro:");
            System.err.println(e.getMessage());
        }
    }

    public int getCodCompra() {
        return codCompra;
    }

    private void setCodCompra(int codCompra) {
        this.codCompra = codCompra;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    private void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    private void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }
    
}
