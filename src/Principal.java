import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    private static final BigDecimal SALARIO_MINIMO = new BigDecimal("1212.00");
    private static final BigDecimal PERCENTUAL_AUMENTO = BigDecimal.TEN;

    public static void main(String[] args) {
        List<Funcionario> funcionarios = inicializarFuncionarios();
        removerFuncionarioPorNome(funcionarios, "João");
        imprimirFuncionarios(funcionarios);
        aumentarSalarios(funcionarios, PERCENTUAL_AUMENTO);
        Map<String, List<Funcionario>> funcionariosPorFuncao = agruparPorFuncao(funcionarios);
        imprimirFuncionariosAgrupados(funcionariosPorFuncao);
        imprimirAniversariantes(funcionarios, Arrays.asList(10, 12));
        imprimirFuncionarioMaisVelho(funcionarios);
        ordenarFuncionariosPorNome(funcionarios);
        calcularTotalSalarios(funcionarios);
        calcularSalariosMinimos(funcionarios);
    }

    private static List<Funcionario> inicializarFuncionarios() {
        return new ArrayList<>(Arrays.asList(
                new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"),
                new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"),
                new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"),
                new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"),
                new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"),
                new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"),
                new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"),
                new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"),
                new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"),
                new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente")
        ));
    }

    private static void removerFuncionarioPorNome(List<Funcionario> funcionarios, String nome) {
        funcionarios.removeIf(funcionario -> funcionario.getNome().equals(nome));
    }

    private static void imprimirFuncionarios(List<Funcionario> funcionarios) {
        System.out.println("Funcionários:");
        funcionarios.forEach(Principal::imprimirFuncionario);
    }

    private static void imprimirFuncionario(Funcionario funcionario) {
        System.out.printf("Nome: %s, Data de Nascimento: %s, Salário: %s, Função: %s\n",
                funcionario.getNome(),
                funcionario.formatarDataNascimento(),
                funcionario.formatarSalario(),
                funcionario.getFuncao());
    }

    private static void aumentarSalarios(List<Funcionario> funcionarios, BigDecimal percentual) {
        funcionarios.forEach(funcionario -> funcionario.aumentarSalario(percentual));
    }

    private static Map<String, List<Funcionario>> agruparPorFuncao(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));
    }

    private static void imprimirFuncionariosAgrupados(Map<String, List<Funcionario>> funcionariosPorFuncao) {
        System.out.println("\nFuncionários agrupados por função:");
        funcionariosPorFuncao.forEach((funcao, lista) -> {
            System.out.println(funcao + ":");
            lista.forEach(funcionario -> System.out.printf("- %s\n", funcionario.getNome()));
        });
    }

    private static void imprimirAniversariantes(List<Funcionario> funcionarios, List<Integer> meses) {
        System.out.println("\nFuncionários que fazem aniversário nos meses " + meses.toString() + ":");
        funcionarios.stream()
                .filter(funcionario -> meses.contains(funcionario.getDataNascimento().getMonthValue()))
                .forEach(funcionario -> System.out.printf("- %s\n", funcionario.getNome()));
    }

    private static void imprimirFuncionarioMaisVelho(List<Funcionario> funcionarios) {
        Funcionario maisVelho = funcionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                .orElse(null);

        if (maisVelho != null) {
            long idade = calcularIdade(maisVelho.getDataNascimento());
            System.out.printf("\nFuncionário mais velho: %s, Idade: %d anos\n",
                    maisVelho.getNome(), idade);
        }
    }

    private static long calcularIdade(LocalDate dataNascimento) {
        return LocalDate.now().getYear() - dataNascimento.getYear();
    }

    private static void ordenarFuncionariosPorNome(List<Funcionario> funcionarios) {
        List<Funcionario> funcionariosOrdenados = funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .collect(Collectors.toList());

        System.out.println("\nFuncionários em ordem alfabética:");
        funcionariosOrdenados.forEach(funcionario -> System.out.printf("- %s\n", funcionario.getNome()));
    }

    private static void calcularTotalSalarios(List<Funcionario> funcionarios) {
        BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.printf("\nTotal dos salários dos funcionários: %,.2f\n", totalSalarios);
    }

    private static void calcularSalariosMinimos(List<Funcionario> funcionarios) {
        System.out.println("\nSalários mínimos que cada funcionário ganha:");
        funcionarios.forEach(funcionario -> {
            BigDecimal salariosMinimos = calcularSalariosMinimos(funcionario.getSalario());
            System.out.printf("- %s: %.2f salários mínimos\n", funcionario.getNome(), salariosMinimos);
        });
    }

    private static BigDecimal calcularSalariosMinimos(BigDecimal salario) {
        return salario.divide(SALARIO_MINIMO, 2, RoundingMode.DOWN);
    }
}
