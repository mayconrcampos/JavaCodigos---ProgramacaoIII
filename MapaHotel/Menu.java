

package MapaHotel;


public class Menu {
    
    public static void Principal(){
        Integer opcao;
        Reserva reserva = new Reserva();
  

        do {
            System.out.println("-=-=-=-=-= Sistema de Reservas -=-=-=-=-=");
            System.out.println("-=-=-=-= Hotel Califórnia LTDA -=-=-=-=-=");
            System.out.println("1. Cadastrar Suíte");
            System.out.println("2. Cadastrar Hóspede");
            System.out.println("3. Cadastrar Reserva");
            System.out.println("4. Listar Reservas");
            System.out.println("0. Sair");
            System.out.println("Opção: ");

            opcao = Read.readInt();

           Menu.limpaTela();
        

            while(opcao == -1){
                System.out.println("Opção Inválida. Digite Novamente.\n\n\n");
                opcao = Read.readInt();
            }

            switch (opcao) {
                case 1:
                    Menu.opcaoUM(reserva);
                    break;
                
                case 2:
                    Menu.opcaoDOIS(reserva);
                    break;
                
                case 3:
                    Menu.opcaoTRES(reserva);
                    break;
                
                case 4:
                    Menu.OpcaoQUATRO(reserva);
                    break;

                case 0:
                    System.out.println("Você saiu do Sistema de Reservas.");
                    break;
            
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }

            
            
        } while (opcao != 0);
    }


    public static void imprimeDadosSuiteCadastrada(Reserva reserva){
        System.out.println("-=-=-=-=- Dados da Suite Cadastrada -=-=-=-=-=");
        System.out.println("Número      : "+reserva.getSuite().getNumero());
        System.out.println("Tipo        : "+reserva.getSuite().getTipo());
        System.out.println("Capacidade  : "+reserva.getSuite().getCapacidade());
        System.out.println("R$/Diária   : "+reserva.getSuite().getValorDiaria());
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
    }

    public static void opcaoUM(Reserva reserva){
        System.out.println("Opção 1. Cadastrar Suite");
        System.out.println("-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-");
        System.out.println("Cadastro de Suíte\n\n\n");

        // Verifica se Atributo suite já foi instanciado dentro de reserva
        if(reserva.getSuite() == null){
            System.out.println("Número da Suíte:    ");
            Integer numero = Read.readInt();

            System.out.println("Tipo:   ");
            String tipo = Read.readString();

            System.out.println("Capacidade MAX de pessoas:  ");
            Integer capacidade = Read.readInt();

            System.out.println("R$/Diária:  ");
            Double valorDiaria = Read.readDouble();


            reserva.setSuite(new Suite(numero, tipo, capacidade, valorDiaria));

            
            Menu.imprimeDadosSuiteCadastrada(reserva);
        }else{
            System.out.println("ERRO! Já existe suíte cadastrada.\n\n\n");

            Menu.imprimeDadosSuiteCadastrada(reserva);
        }
    }

    public static void opcaoDOIS(Reserva reserva){
            System.out.println("Deseja cadastrar um Hóspede? S ou N: ");
            String confirma = Read.readString();

            switch (confirma) {
                case "s":
                case "S":
                case "sim":
                case "Sim":
                case "yes":
                case "Yes":
                    System.out.println("Opção 2. Cadastrar Hóspede");
                    System.out.println("-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-");
                    System.out.println("Cadastro de Hóspedes.\n\n\n");

                    System.out.println("Digite a idade do Hóspede: ");
                    Integer idade = Read.readInt();

                    if(idade == -1){
                        System.out.println("Idade Inválida! Favor digitar novamente.");
                        idade = Read.readInt();
                    }

                    if(idade > 2){
                        reserva.setQuantidadePessoas(reserva.getQuantidadePessoas() + 1);
                        
                        System.out.println("Digite o Código do hóspede: ");
                        Integer codigo = Read.readInt();

                        System.out.println("Digite o nome do hóspede:   ");
                        String nome = Read.readString();

                        System.out.println("Digite o endereço:  ");
                        String endereco = Read.readString();

                        if(reserva.verificarCapacidade(reserva.getSuite().getCapacidade(), reserva.getQuantidadePessoas()) == true){

                            System.out.println("idade "+idade+" codigo "+codigo+" endereco "+endereco+" nome "+nome);
                            reserva.setHospedesAppend(new Hospede(codigo, nome, endereco, idade));
                            Menu.listarHospedes(reserva); 
                
                        }else{
                            System.err.println("ERRO! Capacidade MAX de pessoas excedida.");
                            
                        }
                        
                    }else{
                        System.out.println("Digite o Código do hóspede (Bebê): ");
                        Integer codigo = Read.readInt();

                        if(codigo == -1){
                            System.out.println("Idade Inválida! Favor digitar novamente.");
                            codigo = Read.readInt();
                        }

                        System.out.println("Digite o nome do hóspede:   ");
                        String nome = Read.readString();

                        System.out.println("Digite o endereço:  ");
                        String endereco = Read.readString();

                        reserva.setHospedesAppend(new Hospede(codigo, nome, endereco, idade));
                        Menu.listarHospedes(reserva); 

                        System.out.println("idade "+idade+" codigo "+codigo+" endereco "+endereco+" nome "+nome);
 
                    }
                    break;

                case "n":
                case "N":
                case "Não":
                case "não":
                case "nao":
                case "naum":
                case "naim":
                case "nem a pau":
                    System.out.println("Voltando ao Menu Principal.\n\n\n");
                    break;

                default:
                    System.out.println("Opção Inválida.");
                    break;
            }
                    
    }

    public static void listarHospedes(Reserva reserva){
        for(Integer i = 0; i < reserva.getHospedes().size(); i++){
            System.out.println("Código      :   "+  reserva.getHospedes().get(i).getCodigo());
            System.out.println("Nome        :   "+  reserva.getHospedes().get(i).getNome());
            System.out.println("Endereço    :   "+  reserva.getHospedes().get(i).getEndereco());
            System.out.println("Idade       :   "+  reserva.getHospedes().get(i).getIdade());
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
        }
    }

    public static void opcaoTRES(Reserva reserva){
        

        System.out.println("Deseja Cadastrar reserva? S ou N: ");
        String confirma = Read.readString();

        switch (confirma) {
            case "s":
            case "S":
            case "sim":
            case "Sim":
                System.out.println("Opção 3. Cadastrar Reserva");
                System.out.println("-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-");
                System.out.println("Favor digite a quantidade de dias: ");
                Integer quantidadeDias = Read.readInt();

                if(quantidadeDias == -1){
                    System.out.println("ERRO! Quantidade de dias inválido. Favor digite novamente: ");
                    quantidadeDias = Read.readInt();
                }
                
                // Setar qtde de dias
                
                reserva.setQuantidadeDias(quantidadeDias);
                
                System.out.println("Quantidade de Dias Hospedagem   : "+quantidadeDias);
                System.out.println("Valor (R$)/Diária               :"+reserva.getSuite().getValorDiaria());
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                System.out.println("Acima de 7 dias (Desconto de 10%)");
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                System.err.println("Cálculo");

                // Calcular valor da hospedagem baseado na quantidade de dias vezes o valor da diária

                reserva.calculaDiaria(reserva.getSuite().getValorDiaria(), reserva.getQuantidadeDias());
                              
                break;
            
            case "n":
            case "N":
            case "Não":
            case "não":

                break;
            default:
                break;
        }
    }

    public static void OpcaoQUATRO(Reserva reserva){
        System.out.println("Opção 4. Listar Reservas");
        System.out.println("-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-");

        Menu.imprimeDadosSuiteCadastrada(reserva);
        System.out.println("-=-=-=-=-=-=-=- Hóspedes =-=-=-=-=-=-=-=-=-=");
        Menu.listarHospedes(reserva);

    }

    public static void limpaTela(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
    
}
