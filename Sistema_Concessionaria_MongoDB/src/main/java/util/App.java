package util;

import dao.AutoSys;
import dao.MongoConnection;
import model.Clientes;
import model.Veiculo;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try(Scanner input = new Scanner(System.in)){

        MongoConnection mc = new MongoConnection();
        AutoSys operations = new AutoSys(mc);

        boolean running = true;
        while (running) {


            System.out.println("\n--- MENU DE OPERAÇÕES ---");
            System.out.println("1. Inserir Veículo");
            System.out.println("2. Cadastrar Cliente");
            System.out.println("3. Sair");
            System.out.print("Qual operação deseja realizar? ");


            String option = input.next();
            input.nextLine().trim();// Usa nextLine() e trim() para remover espaços extras
            switch (option) {

                case "1":
                    System.out.println("\n--- CADASTRO DE VEÍCULOS ---");
                    System.out.println("1. Inserir Veículo");
                    System.out.println("2. Remover Veículo");
                    System.out.println("3. Sair");
                    System.out.print("Qual operação deseja realizar? ");

                    switch (input.nextLine().trim()) {
                        case "1":
                            System.out.print("Digite o modelo do Veículo: ");
                            String model = input.nextLine().trim();
                            System.out.print("Digite a marca do Veículo: ");
                            String marca = input.nextLine().trim();
                            System.out.print("Digite a placa do Veículo: ");
                            String placa = input.nextLine().trim();

                            if (model.isEmpty() || marca.isEmpty() || placa.isEmpty()) {
                                System.out.println("Erro: Modelo, marca e placa não podem ser vazios.");
                                break; // Volta ao menu principal
                            }

                            System.out.print("Digite o ano do Veículo: ");
                            int ano = input.nextInt();
                            input.nextLine();


                            Veiculo v = new Veiculo(model, marca, placa, ano);
                            try {
                                operations.creatCar(v);
                                System.out.println("Veículo cadastrado com sucesso!");
                            } catch (Exception e) {
                                System.err.println("Erro ao cadastrar veículo: " + e.getMessage());

                            }
                            break;

                        case "2":

                        System.out.println("Digite a placa do veículo para remover: ");
                        String deleteByPlaca = input.nextLine().trim();
                        operations.deleteAuto(deleteByPlaca);
                        System.out.println("\nVeiculo removido com sucesso!");
                        break;

                        case "3":
                            System.out.println("\nPrograma finalizado com sucesso!");
                            break;
                    }
                    break;

                case "2":

                    System.out.println("\n--- CADASTRO DE CLIENTES ---");
                    System.out.println("1. Cadastrar cliente");
                    System.out.println("2. Remover cliente");
                    System.out.println("3. Sair");
                    System.out.print("Qual operação deseja realizar? ");

                    switch (input.nextLine().trim()) {
                        case "1":
                            System.out.println("Insira o nome do cliente: ");
                            String nome = input.nextLine().trim();
                            System.out.println("Insira o cpf do cliente: ");
                            String cpf = input.nextLine().trim();
                            System.out.println("Insira o telefone do cliente: ");
                            String telefone = input.nextLine().trim();

                            Clientes c = new Clientes(nome, cpf, telefone);
                            operations.creatCliente(c);
                            break;

                        case "2":
                            String delCPF = input.nextLine().trim();
                            operations.deleteCliente(delCPF);
                            break;

                        case "3":
                            System.out.println("\nPrograma finalizado com sucesso!");
                            break;
                    }
                    break;

                case "3":
                    running = false;
                    System.out.println("\nPrograma finalizado com sucesso!");
                    break;

                default:
                    System.out.println("\nEntrada inválida!");
                    System.out.println("Digite apenas opções que estão no menu de operações");
                    break;
            }

        }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }
}
