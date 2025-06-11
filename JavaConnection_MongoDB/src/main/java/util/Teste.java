package util;

import dao.ConexaoMongo;
import dao.autoSys;
import model.Automovel;

import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ConexaoMongo conexao = new ConexaoMongo();

        autoSys operation = new autoSys(conexao);

        boolean operacao = true;
        while (operacao){

            System.out.println("Escolha as opções");
            System.out.println("1. Inserir automovel");
            System.out.println("2. Listar automovels");
            System.out.println("3. Sair");

            String opcao = input.nextLine();
            switch (opcao){
                case "1":
                    Automovel automovel = new Automovel("Uno","Fiat", "ABC123", 1999);
                    operation.creatAuto(automovel);
                    System.out.println("Inserido automovel com sucesso");
                    break;
                case "2":
                    System.out.println("Automóveis cadastrados: ");
                    operation.listarAuto();
                    break;
                case "3":
                    operacao = false;
                    System.out.println("Processo finalizado com sucesso");
                    break;
            }

        }


    }
}
