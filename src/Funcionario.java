import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Locale;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;
    
    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }
    
    public BigDecimal getSalario() {
        return salario;
    }
    
    public String getFuncao() {
        return funcao;
    }
    
    public void aumentarSalario(BigDecimal percentual) {
        BigDecimal aumento = salario.multiply(percentual.divide(BigDecimal.valueOf(100)));
        this.salario = salario.add(aumento);
    }
    
    public String formatarSalario() {
        return String.format(Locale.getDefault(), "%,.2f", salario);
    }
}
