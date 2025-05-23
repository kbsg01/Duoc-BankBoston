package org.duoc;

public class Cuenta {
    //Atributos
    private int numeroCuenta;
    private int saldo = 0;

    //Constructor
    public Cuenta( int numeroCuenta){
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    //Getters y Setters

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    //Métodos
    public void depositar(int monto){
        if(monto > 0){
            saldo += monto;
        } else {
            System.out.println("El monto debe ser mayor que 0");
        }
    }

    public void girar(int monto){
        if(monto > 0 && monto <= saldo){
            saldo -= monto;
            System.out.println("Giro existoso. Saldo actual: $ "+ saldo);
        } else if( monto > saldo ) {
            System.out.println("El monto no puede ser superior al saldo disponible en la cuenta. Saldo actual $ "+ saldo);
        } else {
            System.out.println("El monto debe ser mayor que cero.");
        }
    }
}
