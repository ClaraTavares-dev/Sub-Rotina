import java.util.Locale;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("=== DIGITE SEU SÁLARIO BRUTO ===");
        double salarioBruto = sc.nextDouble();
        System.out.println("======================================");

        double desconto = calcularValorDoDesconto(salarioBruto);
        System.out.printf("VALOR DO DESCONTO: %.1f%n",desconto);

        double salarioLiquido = valorDoSalarioLiquido(salarioBruto, desconto);
        System.out.printf("VALOR DO SALÁRIO LÍQUIDO: %.1f%n",salarioLiquido);

        String tipoDoDesconto = tipoDeDesconto(salarioBruto);
        System.out.println("TIPO DO DESCONTO:"+ tipoDoDesconto);


        sc.close();
    }
    public static double calcularValorDoDesconto(double salarioBruto){
        double percentualDoDesconto;
        if(salarioBruto <= 2000){
            percentualDoDesconto = 0;
        }else if(salarioBruto <= 4000){
            percentualDoDesconto = 2;
        }else{
            percentualDoDesconto = 4;
        }
        double valorDoDesconto = salarioBruto * percentualDoDesconto / 100;
        if(valorDoDesconto > 400){
            valorDoDesconto = 400;
        }
        return valorDoDesconto;
    }
    public static double valorDoSalarioLiquido(double salarioBruto, double valorDoDesconto){
        double salarioLiquido = salarioBruto - valorDoDesconto;
        return salarioLiquido;
    }

    public static String tipoDeDesconto(double salarioBruto){
        String tipoDesconto;
        if (salarioBruto <= 2000) {
            tipoDesconto = "Isento";
        }
        else if (salarioBruto <= 4000) {
            tipoDesconto = "Mínimo";
        }
        else {
            double valorDesconto = salarioBruto * 4 / 100;
            if (valorDesconto > 400) {
                tipoDesconto = "Máximo";
            }
            else {
                tipoDesconto = "Médio";
            }
            return tipoDesconto;
        }
        return tipoDesconto;
    }
}

