import java.util.Scanner;

public class Menu {
    Concessionaria concessionaria = new Concessionaria("Casa dos carros");
    private Scanner entrada = new Scanner(System.in);

    public void menu() {
        System.out.println(
                "Digite a opção desejada:\n" +
                        "1) Cadastrar Carro\n" +
                        "2) Procurar carro pela marca\n" +
                        "3) Procurar carro pelo ano\n" +
                        "4) Remover carro\n" +
                        "5) Lista de Carros cadastrados\n" + 
                        "6) Sair"
                        );
    }

    public void tratarMenu(int opcao) {
        switch (opcao) {
            case 1:
                cadastrarCarro();
                break;
            case 2:
                procurarCarroPorMarca();
                break;
            case 3:
                procurarCarroPorAno();
                break;
            case 4:
                removerCarro();
                break;
            case 5:
                imprimiLista();
                break;
            case 6:
                System.out.println("Saindo do programa...");
                entrada.close();
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    public void cadastrarCarro() {
        System.out.println("Digite a marca do carro:");
        String marca = entrada.nextLine();

        System.out.println("Digite o ano do carro:");
        int ano = Integer.parseInt(entrada.nextLine());

        Carro carro = new Carro(marca, ano);

        if (concessionaria.cadastraCarro(carro)) {
            System.out.println("Carro cadastrado com sucesso.");
        } else {
            System.out.println("Falha ao cadastrar o carro. Verifique se já não está cadastrado.");
        }
    }

    public void procurarCarroPorMarca() {
        System.out.println("Digite a marca do carro:");
        String marca = entrada.nextLine();

        if (concessionaria.buscarCarroMarca(marca)) {
            System.out.println("Carro encontrado.");
        } else {
            System.out.println("Carro não encontrado.");
        }
    }

    public void procurarCarroPorAno() {
        System.out.println("Digite o ano do carro:");
        int ano = Integer.parseInt(entrada.nextLine());

        if (concessionaria.buscarCarroAno(ano)) {
            System.out.println("Carro encontrado.");
        } else {
            System.out.println("Carro não encontrado.");
        }
    }

    public void removerCarro() {
        System.out.println("Digite a marca do carro:");
        String marca = entrada.nextLine();

        if (concessionaria.removeCarro(marca)) {
            System.out.println("Carro removido com sucesso.");
        } else {
            System.out.println("Falha ao remover o carro. Verifique se o carro está cadastrado.");
        }
    }

    public void imprimiLista(){
        concessionaria.imprimirCarrosCadastrados();
    }

    public void executar(){
        int i = 1;

        while(i!= 6){
            menu();
            int menu = Integer.parseInt(entrada.nextLine());
            tratarMenu(menu);
        }
    }
}