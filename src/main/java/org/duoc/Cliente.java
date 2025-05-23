package org.duoc;

public class Cliente {
    //Atributos
    private String rut;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String domicilio;
    private String comuna;
    private String telefono;
    private Cuenta cuentaCorriente;

    //Constructor
    public Cliente(String rut, String nombre, String apellidoPaterno, String apellidoMaterno, String domicilio,
                   String comuna, String telefono, int numeroCuenta){
        if(rut.length() < 11 || rut.length() > 12){
            System.out.println("El rut debe tener entre 11 y 12 caracteres");
            return;
        }
        this.rut = rut;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.domicilio = domicilio;
        this.comuna = comuna;
        this.telefono = telefono;
        this.cuentaCorriente = new Cuenta(numeroCuenta);
    }

    public String getRut(){
        return rut;
    }

    public Cuenta getCuenta(){
        return  cuentaCorriente;
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

    public void mostrarSaldo(){
        System.out.println("El saldo de la cuenta es: $"+ cuentaCorriente.getSaldo());
    }
}
