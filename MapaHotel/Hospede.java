package MapaHotel;

public class Hospede {
    private Integer codigo;
    private String nome;
    private String endereco;
    private Integer idade;

    public Hospede(Integer codigo, String nome, String endereco, Integer idade) {
        this.setCodigo(codigo);
        this.setNome(nome);
        this.setEndereco(endereco);
        this.setIdade(idade);
    }
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

}
