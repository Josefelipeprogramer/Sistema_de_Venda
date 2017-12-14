/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelas;

import Conexao.Conexao;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Jonai
 */
public class Financeiro {
    
    public double lucroDia(Date data) throws Exception {
    java.sql.Connection conn = Conexao.abrir();
    String query = "SELECT SUM(venda.VALOR_VENDA) as somaVenda, SUM(compra.VALOR_COMPRA) as somaCompra"
            + " FROM venda, compra WHERE compra.DATA_COMPRA = " + data + " AND venda.DATA_VENDA = " + data; 
            Statement stmt = conn.createStatement();
            ResultSet rsst = stmt.executeQuery(query);
            double lucroD = rsst.getDouble("somaVenda") - rsst.getDouble("somaCompra");
    
    return lucroD;
    
}
    
    public double lucroMes(int Mes, int Ano) throws Exception {
    Date dataIni = new Date(Ano, Mes, 1);    
    Date dataEnd= new Date(Ano, Mes, 30);
    
    double lucroM = this.lucroPeriodo(dataIni, dataEnd);
    
    return lucroM;
}
    
    public double lucroPeriodo(Date dataINI, Date dataEND) throws Exception {
    java.sql.Connection conn = Conexao.abrir();
    String query = "SELECT SUM(venda.VALOR_VENDA) as somaVenda, SUM(compra.VALOR_COMPRA) as somaCompra"
            + " FROM venda, compra WHERE compra.DATA_COMPRA > "+dataINI + " AND compra.DATA_COMPRA < "
            + dataEND + " AND venda.DATA_VENDA > "+dataINI + " AND venda.DATA_VENDA < "+dataEND; 
            Statement stmt = conn.createStatement();
            ResultSet rsst = stmt.executeQuery(query);
            double lucroP = rsst.getDouble("somaVenda") - rsst.getDouble("somaCompra");
    
    return lucroP;
}
   

    
}
