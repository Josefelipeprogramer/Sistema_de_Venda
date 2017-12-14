/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemavendav1;

import javax.swing.JOptionPane;
import tabelas.*;

/**
 *
 * @author Nadine Miranda
 */
public class SistemaVendaV1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        int opt = 0;
        
        while (opt != 4){
            opt = Integer.parseInt(JOptionPane.showInputDialog("Digite uma opção: 1 - iniciar uma venda, "
                + "2 - atualizar estoque, 3 - adicionar vendedor, 4 - sair"));
            
            switch (opt) {
                case 1:
                venda V1 = new venda();
                V1.vender(Integer.parseInt(JOptionPane.showInputDialog("Digite o seu cpf")));
                    break;
                case 2:
                compra C1 = new compra();
                C1.comprar();
                    break;
                case 3:
                vendedor Vnd = new vendedor();
                Vnd.setVendedor(Integer.parseInt(JOptionPane.showInputDialog("Digite o cpf do vendedor")), Integer.parseInt(JOptionPane.showInputDialog("Digite o telefone do vendedor")), JOptionPane.showInputDialog("Digite o nome do vendedor"), JOptionPane.showInputDialog("Digite o endereço do vendedor"));
                Vnd.adicionarVendedor();
                    break;
            }
        }
        
        
    }
    
}
