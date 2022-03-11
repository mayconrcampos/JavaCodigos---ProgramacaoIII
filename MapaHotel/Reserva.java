package MapaHotel;

import java.util.ArrayList;

public class Reserva {
    private static ArrayList<Hospede> hospedes = new ArrayList<>();
    private Suite suite;
    private Integer quantidadePessoas = 0;
    private Integer quantidadeDias;


    public ArrayList<Hospede> getHospedes() {
        return hospedes;
    }

    public void setHospedesAppend(Hospede hospede) {
        hospedes.add(hospede);
    }

    public Suite getSuite() {
        return this.suite; 
    }

    public void setSuite(Suite suite) {
        this.suite = suite;
    }

    public Integer getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public void setQuantidadePessoas(Integer quantidadePessoas) {
        this.quantidadePessoas = quantidadePessoas;
    }

    public Integer getQuantidadeDias() {
        return quantidadeDias;
    }

    public void setQuantidadeDias(Integer quantidadeDias) {
        this.quantidadeDias = quantidadeDias;
    }

    public Boolean verificarCapacidade(Integer capacidade, Integer qtdePessoas){

        Boolean confirma = (capacidade >= qtdePessoas) ? true : false;

        return confirma;
    }

    public Double calculaDiaria(Double valorDiaria, Integer quantidadeDias){
        Double novoValor = 0.0;
        Double subtotal = 0.0;
        if(quantidadeDias > 7){
            Integer desconto = 10;
            subtotal = valorDiaria * quantidadeDias;
            novoValor = subtotal - ((subtotal / 100) * desconto);

            System.out.println("Total Com Desconto de 10%: R$: "+novoValor);
        }else{
            novoValor = valorDiaria * quantidadeDias;
            System.out.println("Valor sem Desconto: R$"+(novoValor));
        }
        
        
  
        return novoValor;
    }
   
}
