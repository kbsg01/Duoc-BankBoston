package org.duoc;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Scanner;

public class BankBostonApp {
    private ArrayList<Cliente> clientes;

    public BankBostonApp() {
        clientes = new ArrayList<>();
    }

    public void registrarCliente(Scanner sc){
        System.out.println("Ingrese su RUT");
        String rut = sc.nextLine();

        if(buscarCliente(rut) != null){
            System.out.println("El cliente ya existe");
            return;
        }

        System.out.println("Ingrese su nombre");
        String nombre = sc.nextLine();
        System.out.println("Ingrese su apellido paterno");
        String apellidoPaterno = sc.nextLine();
        System.out.println("Ingrese su apellido materno");
        String apellidoMaterno = sc.nextLine();
        System.out.println("Ingrese su domicilio");
        String domicilio = sc.nextLine();
        System.out.println("Ingrese su comuna");
        String comuna = sc.nextLine();
        System.out.println("Ingrese su teléfono");
        String telefono = sc.nextLine();
        System.out.println("Ingrese su número de cuenta");
        int numeroCuenta = sc.nextInt();
        sc.nextLine();

        try {
            Cliente newCliente = new Cliente(rut, nombre, apellidoPaterno, apellidoMaterno, domicilio, comuna, telefono, numeroCuenta);
            clientes.add(newCliente);
            System.out.println("Cliente registrado con éxito.");
        } catch(IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void verDatosCliente(Scanner sc){
        Cliente cliente = solicitarCliente(sc);
        if (cliente != null) cliente.mostrarDatos();
    }

    public void realizarDeposito(Scanner sc) {
        Cliente cliente = solicitarCliente(sc);
        if (cliente != null) {
            System.out.print("Ingrese monto a depositar: ");
            int monto = sc.nextInt();
            sc.nextLine();
            cliente.getCuenta().depositar(monto);
            System.out.println("Deposito realizado con éxito.");
            System.out.println("Su saldo actual es de: $" + cliente.getCuenta().getSaldo());
        }
    }

    public void realizarGiro(Scanner sc) {
        Cliente cliente = solicitarCliente(sc);
        if (cliente != null) {
            System.out.print("Ingrese monto a girar: ");
            int monto = sc.nextInt();
            sc.nextLine();
            cliente.getCuenta().girar(monto);
            System.out.println("Giro realizado con éxito.");
            System.out.println("Su saldo actual es de: $" + cliente.getCuenta().getSaldo());
        }
    }

    public void consultarSaldo(Scanner sc) {
        Cliente cliente = solicitarCliente(sc);
        if (cliente != null) {
            System.out.println("Saldo actual: $" + cliente.getCuenta().getSaldo());
        }
    }

    private Cliente solicitarCliente(Scanner sc) {
        System.out.print("Ingrese RUT del cliente: ");
        System.out.print("Con puntos y con guíon (ej: 12.345.678-9): ");
        String rut = sc.nextLine();
        Cliente cliente = buscarCliente(rut);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
        }
        return cliente;
    }

    private @Nullable Cliente buscarCliente(String rut) {
        for (Cliente c : clientes) {
            if (c.getRut().equalsIgnoreCase(rut)) {
                return c;
            }
        }
        return null;
    }

}
