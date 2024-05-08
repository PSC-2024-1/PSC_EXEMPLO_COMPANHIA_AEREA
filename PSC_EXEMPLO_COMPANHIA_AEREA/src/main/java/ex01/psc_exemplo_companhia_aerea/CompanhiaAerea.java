/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex01.psc_exemplo_companhia_aerea;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author rafaelamoreira
 */
public class CompanhiaAerea {

    Scanner input = new Scanner(System.in);
    ArrayList<Voo> voos = new ArrayList();

    public void adicionarVoo(int numero, String origem, String destino, int lugaresDisponiveis) {
        voos.add(new Voo(numero, origem, destino, lugaresDisponiveis));
    }

    public void cadastrarVoo() {

        System.out.println("Informe o numero do voo, origem, destino e número de lugares do voo ");
        int numero = input.nextInt();
        input.nextLine(); // limpar buffer
        String origem = input.nextLine();
        String destino = input.nextLine();
        int lugaresDisponiveis = input.nextInt();

        adicionarVoo(numero, origem, destino, lugaresDisponiveis);
        System.out.println("Voo cadastrado com sucesso!");

    }

    public void listarVoos() {
        for (Voo voo : voos) {
            System.out.println(voo);
        }

    }

    public Voo buscarVooPorNumero(int numero) {
        for (Voo voo : voos) {
            if (voo.getNumero() == numero) {
                return voo;
            }
        }
        return null;
    }

    public ArrayList<Voo> buscarVooPorOrigem(String origem) {
        ArrayList<Voo> resultado = new ArrayList();
        for (Voo voo : voos) {
            if (voo.getOrigem().equalsIgnoreCase(origem)) {
                resultado.add(voo);
            }
        }
        return resultado;
    }

    public ArrayList<Voo> buscarVooPorDestino(String destino) {
        ArrayList<Voo> resultado = new ArrayList();
        for (Voo voo : voos) {
            if (voo.getDestino().equalsIgnoreCase(destino)) {
                resultado.add(voo);
            }
        }
        return resultado;
    }

    public String reservarLugarNoVoo(int numero) {
        Voo voo = buscarVooPorNumero(numero);

        if (voo == null) {
            return "Voo inexistente!";
        } else if (voo.reservarLugar()) {
            return "Reserva confirmada!";
        } else {
            return "Voo lotado!";
        }

    }

}
