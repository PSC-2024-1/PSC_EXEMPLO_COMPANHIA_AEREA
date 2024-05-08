/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ex01.psc_exemplo_companhia_aerea;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author rafaelamoreira
 */
public class PSC_EXEMPLO_COMPANHIA_AEREA {

    public static void main(String[] args) {
        
        ArrayList<Voo> voos = new ArrayList();
        Scanner input = new Scanner(System.in);
        CompanhiaAerea ca = new CompanhiaAerea();
        int n = 2, opcao, opcao2;

        // cadastrar voos
        for (int i = 0; i < n; i++) {
            ca.cadastrarVoo();
        }

        do {
            System.out.println("\n::::::::::::::OPÇÕES::::::::::::::\n");
            System.out.println("""
                                [1] Consultar
                                [2] Efetuar reserva
                                [3] Sair
                                """);
            System.out.println("Escolha uma opção: ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1 -> {
                    System.out.println("\n::::::::::::::OPÇÕES::::::::::::::\n");

                    System.out.println("""
                                            [1] Consultar por voo
                                            [2] Consultar por origem
                                            [3] Consultar por destino
                                        """);
                    System.out.println("Escolha uma opção: ");
                    opcao2 = input.nextInt();
                    input.nextLine();  // Limpa o buffer
                    switch (opcao2) {

                        case 1 -> {
                            System.out.println("Informe o numero do voo: ");
                            int numero = input.nextInt();
                            Voo voo = ca.buscarVooPorNumero(numero);
                            if (voo != null) {
                                System.out.println(voo);
                            } else {
                                System.out.println("Voo não encontrado!");
                            }

                        }
                        case 2 -> {
                            System.out.println("Informe a origem: ");
                            String origem = input.nextLine();
                            ArrayList<Voo> vooOrigem = ca.buscarVooPorOrigem(origem);
                            if (!vooOrigem.isEmpty()) {
                                for (Voo voo : vooOrigem) {
                                    System.out.println(voo);
                                }
                            } else {
                                System.out.println("Voo não encontrado!");
                            }

                        }
                        case 3 -> {
                            System.out.println("Informe o destino: ");
                            String destino = input.nextLine();
                            ArrayList<Voo> vooDestino = ca.buscarVooPorDestino(destino);
                            if (!vooDestino.isEmpty()) {
                                for (Voo voo : vooDestino) {
                                    System.out.println(voo);
                                }
                            } else {
                                System.out.println("Voo não encontrado!");
                            }

                        }
                        default ->
                            System.out.println("Opção Inválida!");

                    }
                }

                case 2 -> {

                    System.out.println("Informeo numero do voo para reservar: ");
                    int numero = input.nextInt();
                    String reserva = ca.reservarLugarNoVoo(numero);
                    System.out.println(reserva);

                }
                case 3 ->
                    System.out.println("Volte sempre!");
                default ->
                    System.out.println("Opção Inválida!");

            }
        } while (opcao != 3);

    }
}

