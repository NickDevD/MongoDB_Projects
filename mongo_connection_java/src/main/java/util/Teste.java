package util;
import dao.mongoConnection;
import dao.autoSys;
import model.Veiculo;

import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

        mongoConnection connection = new mongoConnection();

        autoSys sys = new autoSys(connection);

        boolean conectado = true;
        while (conectado){

            try{
                System.out.println("Escolha a opção:");

                String op = in.next();
                switch (op){
                    case "1":
                    boolean input = false;
                    while (!input){
                        try{

                            Veiculo veiculo = new Veiculo("Opala", "CDA8565", 2001);
                            sys.creatAuto(veiculo);
                            input = true;

                        }catch (Exception e){
                            if (e.getMessage() != null){
                                System.out.println("Erro: digite novamente");
                            }
                        }
                    }
                    break;
                    case "2":
                    conectado = false;
                    break;

                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }


    }
}
