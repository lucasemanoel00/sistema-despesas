import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        GerenciadorDespesas gerenciadorDespesas = new GerenciadorDespesas();
        Scanner sc = new Scanner (System.in);

        int escolha;

        do {

            System.out.println("[1] Cadastrar despesa \n[2] Buscar despesa por id \n[3] Listar todas as despesas \n[4] Remover despesas por ID \n[5] Mostrar total gasto \n[6] Mostrar gastos por categoria \n[7] Alterar categoria da despesa \n[8] para sair");
            escolha = sc.nextInt();
            sc.nextLine();

            switch(escolha) {

                case 1-> {

                    try{
                    System.out.println("Vamos cadastrar aqui sua despesa!");
                    System.out.println("Digite aqui o destinatario");
                    String destinatario = sc.nextLine();
                    System.out.println("Digite aqui a descrição da despesa");
                    String descricao = sc.nextLine();
                    System.out.println("Digite APENAS o dia que a despesa foi feita");
                    int dia = sc.nextInt();
                    System.out.println("Digite APENAS o mês que a despesa foi feita");
                    int mes = sc.nextInt();
                    System.out.println("Digite aqui APENAS o ano em que a despesa foi feita");
                    int ano = sc.nextInt();
                    System.out.println("Digite o valor da despesa:");
                    double despesa = sc.nextDouble();

                    gerenciadorDespesas.cadastrarDespesa(new Despesa(destinatario, despesa, descricao, dia, mes, ano));
                    }
                    catch (IllegalArgumentException e) {

                        System.out.println(e.getMessage());

                    }

                }

                case 2-> {

                    try {
                        System.out.println("Digite aqui o número identificador que deseja ");
                        int idProcurar = sc.nextInt();
                        System.out.println(gerenciadorDespesas.buscarPorID(idProcurar));
                    }
                    catch (IllegalArgumentException e) {

                        System.out.println(e.getMessage());

                    }

                }
                case 3-> {

                    gerenciadorDespesas.mostrarDespesas();

                }
                case 4 -> {

                    System.out.println("Digite o número do identificador da despesa que deseja remover");
                    int idProcurar = sc.nextInt();
                    System.out.println(gerenciadorDespesas.removerDespesaId(idProcurar));

                }
                case 5 -> {

                    System.out.println(gerenciadorDespesas.calcularTotalGasto());

                }
                case 6-> {

                    System.out.println(gerenciadorDespesas.calcularDespesaCategoria());

                }
                case 7 -> {

                    try {
                     System.out.println("Digite o número identificador da depesa que deseja alterar");
                        int idProcurar = sc.nextInt();

                        System.out.println("[1] para ALIMENTAÇÃO \n [2] para TRANSPORTE \n[3] para LAZER \n[4]para EDUCAÇÃO \n[5] para SAÚDE \n[6] para OUTROS");
                        int escolhaCategoria = sc.nextInt();
                        gerenciadorDespesas.buscarPorID(idProcurar).setCategoriaDespesa(escolhaCategoria);
                    }
                    catch (IllegalArgumentException e) {

                        System.out.println(e.getMessage());

                    }

                }
                case 8-> {

                    System.out.println("Encerrando programa...");

                }





            }




        } while (escolha != 8);
        


    }

}