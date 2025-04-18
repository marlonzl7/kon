package com.marlonzl7.kon.commands;

import com.marlonzl7.kon.utils.Version;

import java.util.Map;

public class HelpCommand implements Command {

    @Override
    public void execute(Map<String, String> arguments) {
        String version = "1.0.0";
        System.out.printf("Kon - Conversor de Unidades (v%s)%n", Version.getVersion());
        System.out.println();

        System.out.println("Uso:");
        System.out.println("kon --converter <grandeza> --from <unidade> --to <unidade> --value <valor>");
        System.out.println("kon --list <grandeza>");
        System.out.println("kon --help");
        System.out.println();

        System.out.println("Opções:");
        System.out.println("-c, --converter <grandeza>   Define o tipo de grandeza (ex: massa, comprimento, temperatura)");
        System.out.println("-f, --from <unidade>         Unidade de origem (ex: kg, m, C)");
        System.out.println("-t, --to <unidade>           Unidade de destino (ex: g, cm, F)");
        System.out.println("-v, --value <valor>          Valor numérico a ser convertido");
        System.out.println("-l, --list <grandeza>        Lista as unidades disponíveis para grandeza informada");
        System.out.println("-h, --help                   Exibe esta mensagem de ajuda");
        System.out.println();

        System.out.println("Exemplos:");
        System.out.println("kon --converter speed --from ms --to kmh --value 25");
        System.out.println("    Converte 25m/s para km/h.");
        System.out.println();
        System.out.println("kon -c temperature -f celsius -t fahrenheit -v 32");
        System.out.println("    Converte 32 graus Celsius para Fahrenheit.");
        System.out.println();
        System.out.println("kon --list length");
        System.out.println("    Lista todas as unidades disponíveis para a grandeza 'length'.");
        System.out.println();

        System.out.println("Suporte a português:");
        System.out.println(" - É possível usar as flags, unidades e grandezas em português.");
        System.out.println(" - Exemplo:");
        System.out.println("   kon --converter comprimento --de metro --para quilometro --valor 1000");
        System.out.println("     (Funciona igual usar 'length', 'meter', 'kilometer')");
        System.out.println();

        System.out.println("Notas:");
        System.out.println(" - Os nomes das grandezas devem ser escritos em minúsculas (ex: mass, temperature)");
        System.out.println(" - Utilize 'kon --list' para descobrir quais unidades estão disponíveis para conversão");
    }
}
