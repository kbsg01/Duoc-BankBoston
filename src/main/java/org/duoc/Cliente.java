package org.duoc;

public class Cliente {
    // Atributos
    private String rut;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String domicilio;
    private String comuna;
    private String telefono;
    private Cuenta cuentaCorriente;

    // Constructor
    public Cliente(String rut, String nombre, String apellidoPaterno, String apellidoMaterno, String domicilio,
            String comuna, String telefono) {
        if (rut.length() < 11 || rut.length() > 12) {
            throw new IllegalArgumentException("Escriba un rut válido");
        }
        this.rut = rut;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.domicilio = domicilio;
        this.comuna = comuna;
        this.telefono = telefono;
        this.cuentaCorriente = new Cuenta(); // Ahora se genera automáticamente
    }

    public String getRut() {
        return rut;
    }

    public Cuenta getCuenta() {
        return cuentaCorriente;
    }

    public void mostrarDatos() {
        System.out.println("Rut: " + rut);
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido Paterno: " + apellidoPaterno);
        System.out.println("Apellido Materno: " + apellidoMaterno);
        System.out.println("Domicilio: " + domicilio);
        System.out.println("Comuna: " + comuna);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Número de Cuenta: " + cuentaCorriente.getNumeroCuenta());
        System.out.println("Saldo: $" + cuentaCorriente.getSaldo());
    }

    public void mostrarSaldo() {
        System.out.println("El saldo de la cuenta es: $" + cuentaCorriente.getSaldo());
    }
}
