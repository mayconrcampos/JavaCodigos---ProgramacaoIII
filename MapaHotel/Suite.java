package MapaHotel;

public class Suite {
    private Integer numero;
    private String tipo;
    private Integer capacidade;
    private Double valorDiaria;

    public Suite(Integer numero, String tipo, Integer capacidade, Double valorDiaria){
        this.setNumero(numero);
        this.setTipo(tipo);
        this.setCapacidade(capacidade);
        this.setValorDiaria(valorDiaria);
    }
    
    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public Double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(Double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public Boolean getDadosSuite(){
        if(this.numero == null){
            return false;
        }else{
            System.out.println("Número      :   "+this.getNumero());
            System.out.println("Tipo        :   "+this.getTipo());
            System.out.println("Capacidade  :   "+this.getCapacidade());
            System.out.println("R$/Diária   :   "+this.getValorDiaria());

            return true;
        }
        
    }
}
