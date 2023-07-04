import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Arquivo {
    public void salvarPassageiros(List<Passageiro> passageiros) {
        try {
            FileWriter fileWriter = new FileWriter("C:/Users/maria/Documents/passageiros.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(passageiros.toString());

            bufferedWriter.close();
            System.out.println("Dados armazenados com sucesso no arquivo.");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao armazenar os dados no arquivo: " + e.getMessage());
        }
    }
}