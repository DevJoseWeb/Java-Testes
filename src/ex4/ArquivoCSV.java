package ex4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
/**
 * @author Jose R F Junior
 * web2ajax@gmail.com
 */
public class ArquivoCSV {
   public static void main(String[] args) throws IOException {
      Path arquivo = Paths.get("telefones-clientes.csv");
      
      List<TelefoneCliente> telefones = Files.lines(arquivo)
         .map(linha -> linha.split(";"))
         .filter(arr -> arr[1].equals("19"))
              .limit(168)
         .map(arr -> new TelefoneCliente(arr[0], arr[1], arr[2]))
         .collect(Collectors.toList());

      telefones.parallelStream()
              .forEach(System.out::println);
   }
}
