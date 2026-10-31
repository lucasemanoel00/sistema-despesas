import java.time.LocalDate;

public class Despesa {

    private double valorDespesa;
    private String destinatario; //
    private static int geradorId = 0;
    private final int idDespesa = ++geradorId;
    private CategoriaDespesa categoriaDespesa;
    private String descricaoDespesa; //
    private LocalDate dataPagamento; //

    public enum CategoriaDespesa {

        NAO_INFORMADA, //
        ALIMENTAÇÃO, //
        TRANSPORTE, //
        LAZER, //
        EDUCAÇÃO, //
        SAÚDE, //
        OUTROS

    }

    public Despesa(String destinatario,double valorDespesa,String descricao, int dia,int mes, int ano) {

        if (destinatario == null || destinatario.isBlank() ){

            this.destinatario = "Não informado";

        }
        else {

             this.destinatario = destinatario;

        }
        if (valorDespesa<= 0) {

            throw new IllegalArgumentException("O valor deve ser superior a R$ 0,00");

        }
        else {

            this.valorDespesa = valorDespesa;

        }
        if (descricao == null || descricao.isBlank()) {

            this.descricaoDespesa = "Descrição não informada";

        }
        else {

            this.descricaoDespesa = descricao;

        }
        this.dataPagamento = LocalDate.of(ano,mes,dia);
        this.categoriaDespesa = CategoriaDespesa.NAO_INFORMADA; 
    }

    public void setValorDespesa(double valorDespesa) {

        if (valorDespesa<=0) {

            throw new IllegalArgumentException("ERRO,O valor da despesa deve ser maior que R$ 0,00");

        }

        this.valorDespesa = valorDespesa;

    }
    public void setDestinatario(String destinatario) {

        
        
        if (destinatario == null || destinatario.isBlank()) {

            this.destinatario = "Não informado";

        } 
        else {
            
            this.destinatario = destinatario;

        }
    }
    public void setCategoriaDespesa(int escolha) {

        switch (escolha) {
            case 1-> {
                this.categoriaDespesa = CategoriaDespesa.ALIMENTAÇÃO;
            }
            
            case 2-> {
            
                this.categoriaDespesa = CategoriaDespesa.TRANSPORTE;
            
            }

            case 3-> {

                this.categoriaDespesa = CategoriaDespesa.LAZER;

            }
            case 4-> {

                this.categoriaDespesa = CategoriaDespesa.EDUCAÇÃO;

            }
            case 5-> {

                this.categoriaDespesa = CategoriaDespesa.SAÚDE;

            }
            case 6-> {

                this.categoriaDespesa = CategoriaDespesa.OUTROS;

            }
            default-> {

                throw new IllegalArgumentException("O número escolhido não corresponde a uma categória");

            }
                
        }

    }
    public void setDescricaoDespesa(String descricao) {
        
        if (descricao == null || descricao.isBlank()) {

            this.descricaoDespesa = "Não informada";

        }
        else {
        
            this.descricaoDespesa = descricao;

        }

    }
    public void setDataPagamento(int ano,int mes,int dia) {

        this.dataPagamento = LocalDate.of(ano,mes,dia);

    }
    public double getValorDespesa() {

        return this.valorDespesa;

    }
    public String getDestinatarioDespesa() {

        if (this.destinatario == null) {

            return "Destinatário não informado";

        }
        
        return this.destinatario;

    }
    public int getIdDespesa() {

        return this.idDespesa;

    }
    public CategoriaDespesa getCategoriaDespesa() {

        return this.categoriaDespesa;

    }
    public String getDescricaoDespesa() {

        return this.descricaoDespesa;

    }
    public LocalDate getDataPagamentoDespesa() {

        return this.dataPagamento;

    }
    @Override 
    public String toString() {

        return "Número identificador da despesa: %d \nNome do destinatário: %s \nValor da despesa: %.2f \nCategoria da despesa: %s \nDescrição da despesa: %s \nData do pagamento %s".formatted(getIdDespesa(),getDestinatarioDespesa(),getValorDespesa(),getCategoriaDespesa(),getDescricaoDespesa(),getDataPagamentoDespesa());

    }
    
}