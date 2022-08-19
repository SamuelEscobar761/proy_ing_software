import java.util.Scanner;

public class Main {
    private static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        //Creacion de productos
	    Producto A = new Producto(270);
        Producto B = new Producto(340);
        Producto C = new Producto(390);

        while(true){
            //Variables
            int montoIngresado = 0;
            int vuelto;
            Producto productoEscogido = null;

            //Ejecucion del programa
            while(productoEscogido == null){
                System.out.println("Elija producto: A, B, C");
                String tipo = teclado.nextLine();
                switch (tipo){

                    case "A":
                        productoEscogido = A;
                        break;
                    case "B":
                        productoEscogido = B;
                        break;
                    case "C":
                        productoEscogido = C;
                        break;
                }
            }
            montoIngresado = pedirDinero(productoEscogido);
            vuelto = montoIngresado - productoEscogido.getPrecio();
            darVuelto(vuelto);
        }
    }

    private static int pedirDinero(Producto p){
        int montoIngresado = 0;
        System.out.println("Ingrese monedas: 10, 50, 100");
            while(montoIngresado < p.getPrecio()){
                int moneda = teclado.nextInt();
                teclado.nextLine();
                if(!(moneda == 10 || moneda == 50 || moneda == 100)){
                    System.out.println("Error, la maquina no acepta esta moneda");
                }else{
                    montoIngresado += moneda;
                }
            }
        return montoIngresado;
    }

    private static void darVuelto(int vuelto){
        int deuda = vuelto;
        System.out.println("Su vuelto:");
        while(deuda > 0){
            if(deuda >= 100){
                System.out.println("100");
                deuda -= 100;
            }else if(deuda >= 50){
                System.out.println("50");
                deuda -= 50;
            }else if(deuda >= 10){
                System.out.println("10");
                deuda -= 10;
            }
        }
    }
}
