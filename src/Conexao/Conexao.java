/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author José Felipe Xavier
 * @author Rainan Miranda de Jesus
 */
public class Conexao {

    private static final String USUARIO = "root";
    private static final String SENHA = "";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/sistema_venda";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    // Conectar ao banco
    public static Connection abrir() throws Exception {
        System.out.println("Conectando com o banco...");
        // Registrar o driver
        Class.forName(DRIVER);
        // Capturar a conexão
        Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
        // Retorna a conexao aberta
        System.out.println("Conectado");
        return conn;

    }

}
