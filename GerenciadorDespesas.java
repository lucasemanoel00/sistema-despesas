import java.util.HashMap;

public class GerenciadorDespesas {

    private final HashMap <Integer,Despesa> listaDespesa = new HashMap<>();

    public String cadastrarDespesa(Despesa despesa) {

        listaDespesa.put(despesa.getIdDespesa(),despesa);
        return "Cadastro feito com sucesso";

    }
    public Despesa buscarPorID(int idDespesa) {
        
        if (listaDespesa.get(idDespesa) == null) {

            throw new IllegalArgumentException("Despesa não encontrada");

        }

        return listaDespesa.get(idDespesa);
        
    }
    public String removerDespesaId(int idDespesa) {

        if (listaDespesa.containsKey(idDespesa)) {
            
            listaDespesa.remove(idDespesa);
            return "Depesa de número identificador %d foi removida com sucesso!".formatted(idDespesa);
        
        }

        return "Despesa de número identificador %d não encontrada".formatted(idDespesa);

    }
    public void mostrarDespesas() {

        if (listaDespesa.isEmpty()) {

            System.out.println("A lista de despesas está vazia!");
            return;

        }
        for (Despesa despesa : listaDespesa.values()) {

            System.out.println(despesa);

        }
    }
    public double calcularTotalGasto() {

        if (listaDespesa.isEmpty()) {

            return 0;

        }
        double somaGastos = 0;

        for (Despesa despesa : listaDespesa.values()) {

            somaGastos += despesa.getValorDespesa();

        }
        return somaGastos;
    }
    public String calcularDespesaCategoria() {

        double valor_Nãoinformado = 0;
        double valor_ALIMENTAÇÃO = 0;
        double valor_TRANSPORTE =0;
        double valor_LAZER = 0;
        double valor_EDUCAÇÃO = 0;
        double valor_SAÚDE= 0;
        double valor_OUTROS= 0;

        for (Despesa despesa : listaDespesa.values()) {

            if (despesa.getCategoriaDespesa() == Despesa.CategoriaDespesa.NAO_INFORMADA) {

                valor_Nãoinformado += despesa.getValorDespesa();

            }
            else if (despesa.getCategoriaDespesa() == Despesa.CategoriaDespesa.ALIMENTAÇÃO) {

                valor_ALIMENTAÇÃO +=despesa.getValorDespesa();

            }
            else if (despesa.getCategoriaDespesa() == Despesa.CategoriaDespesa.EDUCAÇÃO) {

                valor_EDUCAÇÃO += despesa.getValorDespesa();

            }
            else if (despesa.getCategoriaDespesa() == Despesa.CategoriaDespesa.LAZER) {

                valor_LAZER += despesa.getValorDespesa();

            }
            else if (despesa.getCategoriaDespesa() == Despesa.CategoriaDespesa.SAÚDE) {

                valor_SAÚDE += despesa.getValorDespesa();

            }
            else if (despesa.getCategoriaDespesa() == Despesa.CategoriaDespesa.TRANSPORTE) {

                valor_TRANSPORTE += despesa.getValorDespesa();

            }
            else if (despesa.getCategoriaDespesa() == Despesa.CategoriaDespesa.OUTROS) {

                valor_OUTROS += despesa.getValorDespesa();

            }

        }

        return "NÃO INFORMADO: %.2f \nALIMENTAÇÃO: %.2f \nEDUCAÇÃO: %.2f \nLAZER: %.2f \nSAÚDE: %.2f \nTRANSPORTE: %.2f \nOUTROS: %.2f".formatted(valor_Nãoinformado,valor_ALIMENTAÇÃO,valor_EDUCAÇÃO,valor_LAZER,valor_SAÚDE,valor_TRANSPORTE,valor_OUTROS);


    }




}