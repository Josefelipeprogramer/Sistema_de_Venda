/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabelas;

import Conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 *
 * @author Nadine Miranda
 */
public class vendedor {
    //Atributos
    int cpf;
    int telefone;
    String nome;
    String endereco;
    //métodos

    public void adicionarVendedor() throws Exception{
        try{
            java.sql.Connection conn = Conexao.abrir();
            String query1 = ("SELECT * FROM vendedor WHERE CPF_VENDEDOR = " + this.cpf);
            
            Statement stmt = conn.createStatement();
            ResultSet rsst = stmt.executeQuery(query1);
            ResultSetMetaData rsmd = rsst.getMetaData();  
            int numColumns = rsmd.getColumnCount();
            if(numColumns > 0){
                String query = "INSERT INTO vendedor(CPF_VENDEDOR, NOME, ENDERECO, TELEFONE)"
                    + " VALUES (?, UPPER(?), ?, ?)";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setInt (1, this.cpf);
                preparedStmt.setString (2, this.nome);
                preparedStmt.setString (3, this.endereco);
                preparedStmt.setInt(4, this.telefone);
                preparedStmt.execute();
                System.out.println("Vendedor adicionado com sucesso!");
            } else {
                System.out.println("Esse vendedor já está registrado!");
            }
            conn.close();
        } catch (Exception e){
            System.err.println("Erro:");
            System.err.println(e.getMessage());
        }
        
    }
    //Setters e Getters

    public void setVendedor(int cpf, int telefone, String nome, String endereco) {
        this.cpf = cpf;
        this.telefone = telefone;
        this.nome = nome;
        this.endereco = endereco;
    }
    
    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    
    
}
