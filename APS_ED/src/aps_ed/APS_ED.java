package aps_ed;

import java.util.Scanner;

public class APS_ED {

    public static int temp = 1000;

    public static void main(String[] args) {

        int op;
        int x;
        int z;
        int rev;
        Scanner leitura = new Scanner(System.in);

        CaixasOperadores cx1 = new CaixasOperadores("Roberto", 12, false, new ThreadFila(), temp = 6000);
        CaixasOperadores cx2 = new CaixasOperadores("Marcia", 12, false, new ThreadFila(), temp = 5000);
        CaixasOperadores cx3 = new CaixasOperadores("Francisco", 12, false, new ThreadFila(), temp = 1000);
        Estoque produto = new Estoque("Arroz", 1, 5, new Pilha());
        Estoque produto1 = new Estoque("Feijão", 2, 5, new Pilha());
        Estoque produto2 = new Estoque("Farinha", 3, 5, new Pilha());
        Estoque produto3 = new Estoque("Açucar", 4, 5, new Pilha());

//        System.out.println(cx1.display());
//        cx1.getThreadFila().isEmpty();
        //COMEÇO CASO FILA
        cx1.getThreadFila().enqueue(2);
        cx1.getThreadFila().enqueue(3);
        cx1.getThreadFila().enqueue(4);
        cx2.getThreadFila().enqueue(994);
        cx2.getThreadFila().enqueue(12);
        cx2.getThreadFila().enqueue(85);
        cx3.getThreadFila().enqueue(54);
        cx3.getThreadFila().enqueue(47);
        cx3.getThreadFila().enqueue(66);
        //FIM CASO FILA

        //COMEÇO CASO PILHA
        for (int i = 1; i < 10; i++) {
            produto.getPilha().push(i);
        }
        for (int i = 1; i < 12; i++) {
            produto1.getPilha().push(i);
        }
        for (int i = 1; i < 15; i++) {
            produto2.getPilha().push(i);
        }
        for (int i = 1; i < 20; i++) {
            produto3.getPilha().push(i);
        }
//        produto.getPilha().display();
//        System.out.println("Há "+produto.getPilha().getQtd()+" na pilha "+produto.getNome_prd()+" ");
        //FIM CASO PILHA

//        System.out.println("A fila do funcionario "+cx1.getNome());
//        cx1.getThreadFila().display();
//        cx1.getThreadFila().dequeue();
//        cx1.getThreadFila().display();
//        System.out.println("Quantidade de pessoas na Fila(): "+cx1.getThreadFila().getTotalDeElementos());
        do {
            System.out.println("\tBem vindo ao SUPER MERCADO INFINITO");
            System.out.println("\n\tESCOLHA UMA OPÇÃO ABAIXO: ");
            System.out.println("\n01 - Gerenciar filas");
            System.out.println("02 - Gerenciar estoque");
            System.out.println("00 - Sair");
            op = leitura.nextInt();

            switch (op) {
                case 0:
                    System.out.println("Encerrando....");
                    break;
                case 1:
                    do {
                        System.out.println("Escolha um caixa para verificar a fila");
                        System.out.println("01- Roberto");
                        System.out.println("02 - Marcia");
                        System.out.println("03 - Francisco");
                        System.out.println("00 - Sair");
                        x = leitura.nextInt();
                        switch (x) {
                            case 0:
                                System.out.println("Voltando ao menu....");
                                break;
                            case 1:
                                temp = 6000;
                                System.out.println("Fila de " + cx1.getNome() + ":");
                                cx1.getThreadFila().display();
                                System.out.println("Fila em tempo real: ");
                                System.out.println("Aguarde");
                                for (int i = 0; i <= cx1.getThreadFila().getTotalDeElementos(); i++) {
                                    cx1.getThreadFila().dequeue();
                                    cx1.getThreadFila().display();

                                    System.out.println("Aguarde...");
                                }
                                System.out.println("Fila acabou a media de tempo de atendimento é de:" + (temp / 1000) + "seg");
                                break;
                            case 2:
                                temp = 4000;
                                System.out.println("Fila de " + cx2.getNome() + ":");
                                cx2.getThreadFila().display();
                                System.out.println("Fila em tempo real: ");
                                for (int i = 0; i <= cx2.getThreadFila().getTotalDeElementos(); i++) {
                                    cx2.getThreadFila().dequeue();
                                    cx2.getThreadFila().display();
                                    System.out.println("Aguarde...");
                                }

                                System.out.println("Fila acabou a media de tempo de atendimento é de:" + (temp / 1000) + "seg");
                                break;
                            case 3:
                                temp = 1000;
                                System.out.println("Fila de " + cx3.getNome() + ":");
                                cx3.getThreadFila().display();
                                System.out.println("Fila em tempo real: ");
                                for (int i = 0; i <= cx3.getThreadFila().getTotalDeElementos(); i++) {
                                    cx3.getThreadFila().dequeue();
                                    cx3.getThreadFila().display();
                                    System.out.println("Aguarde...");
                                }
                                System.out.println("Fila acabou a media de tempo de atendimento é de:" + (temp / 1000) + "seg");
                                break;
                            default:
                                System.out.println("Opção invalida:");
                                break;
                        }
                    } while (x != 0);
                    break;
                case 2:
                    do {
                        System.out.println("Produtos  no estoque e quantidades");
                        System.out.println("ID: " + produto.getId() + " " + produto.getNome_prd() + " Quantidade:" + produto.getPilha().getQtd());
                        System.out.println("ID: " + produto1.getId() + " " + produto1.getNome_prd() + " Quantidade:" + produto1.getPilha().getQtd());
                        System.out.println("ID: " + produto2.getId() + " " + produto2.getNome_prd() + " Quantidade:" + produto2.getPilha().getQtd());
                        System.out.println("ID: " + produto3.getId() + " " + produto3.getNome_prd() + " Quantidade:" + produto3.getPilha().getQtd());

                        System.out.println("Deseja remover(1) ou não (0)");
                        z = leitura.nextInt();
                        if (z == 1) {

                            System.out.println("\tREMOVER");
                            System.out.println("Escolha o produto: ");
                            rev = leitura.nextInt();
                            switch (rev) {
                                case 1:
                                    produto.getPilha().pop();
                                    break;
                                case 2:
                                    produto1.getPilha().pop();
                                    break;
                                case 3:
                                    produto2.getPilha().pop();
                                case 4:
                                    produto3.getPilha().pop();
                                    break;
                                default:
                                    System.out.println("Opção invalida!");
                            }

                        } else {
                            break;
                        }
                    } while (z != 0);
                    break;
                default:
                    System.out.println("Opção invalida!");
                    break;
            }
        } while (op != 0);

    }

}
