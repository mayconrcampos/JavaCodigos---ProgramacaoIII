package Veiculo;

public class Veiculo {
    private String nome;
    private String marca;
    private String combustivel;


    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }
  
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCombustivel() {
        return combustivel;
    }
    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public void acelerar() {
        System.out.println("Veículo Acelerando.");
    }
   
}
