package java.com.sd.Clients;

import java.text.ParseException;
import java.util.Scanner;

import org.springframework.web.reactive.function.client.WebClient;
import com.sd.Models.CartItem;
import com.sd.Models.Order;
import com.sd.Models.Product;

public class ClientGeral {

    public static void menu(){
        System.out.println("------ Loja Produtos Cliente ---");
        System.out.println();
        System.out.println("1 - Registar Cliente");
        System.out.println("2 - Listar Produtos");
        System.out.println("3 - Adicionar Produto ao Carrinho");
        System.out.println("4 - Remover Produto do Carrinho");
        System.out.println("5 - Ver Carrinho");
        System.out.println("6 - Finalizar Compra (checkout)");
        System.out.println("7 - Listar Encomendas");
        System.out.println("0 - Sair");
        System.out.println();
        System.out.print("Escolha uma opção: ");
    }

    public static void main(String[] args) throws ParseException {
        menu();
    }
}