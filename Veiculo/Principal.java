package Veiculo;

public class Principal {
    

    public static void main(String[] args) {
        
        Veiculo carro = new Carro();
        carro.acelerar();

        Veiculo bike = new Bicicleta();
        bike.acelerar();
    }
}
