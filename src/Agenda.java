import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class Agenda {

    private final Map<String, Contato> agenda = new HashMap<>();

    public Contato addContato(Contato contato) {
        String telefone = contato.getTelefone();
        agenda.put(telefone, contato);
        return contato;
    }

    public boolean removeContatoByTelefone(String telefone) {
        Contato contato = agenda.get(telefone);
        if (contato != null) {
            agenda.remove(telefone);
            return true;
        }
        return false;
    }

    public boolean removeContatoByNome(String nome) {
        for (Contato contato : agenda.values()) {
            if (contato.getNome().equals(nome)) {
                String telefone = contato.getTelefone();
                agenda.remove(telefone);
                return true;
            }
        }
        return false;
    }

    public Contato getContatoByTelefone(String telefone) {
        Contato contato = agenda.get(telefone);
        return contato;
    }

    public Contato getContatoByNome(String nome) {
        for (Contato contato : agenda.values()) {
            if (contato.getNome().equals(nome)) {
                return contato;
            }
        }
        return null;
    }

    public ArrayList<Contato> getAllContatos() {
        ArrayList<Contato> contatos = new ArrayList<>();
        contatos.addAll(agenda.values());
        return contatos;
    }

    public String call(String telefone) {
        Contato contato = getContatoByTelefone(telefone);
        if (contato != null) {
            return "Ligando para " + contato.getNome() + ", telefone: " + telefone;
        }

        return "Contato não encontrado";
    }

    public boolean clearAgenda() {
        agenda.clear();
        return true;
    }

    public ArrayList<Contato> importContatos(String filePath) {
        ArrayList<Contato> contatos = new ArrayList<>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] fields =  line.split("&");

                if(fields.length != 3) {
                    System.out.println("Linha inválida: " + line);
                    continue;
                }

                String nome = fields[0].trim();
                String telefone = fields[1].trim();
                String endereco = fields[2].trim();

                if (nome.length() > 30 || telefone.length() != 11 || endereco.length() > 100) {
                    System.out.println("Campos com tamanho inválidos: " + line);
                    continue;
                }

                Contato contato = new Contato(nome, telefone, endereco);
                contatos.add(contato);
            }
        } catch(IOException error) {
            error.printStackTrace();
        }

        return contatos;
    }

    public String exportContatos(String filePath) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Contato contato : agenda.values()) {
                writer.write(contato.getNome() + "&" + contato.getTelefone() + "&" + contato.getEndereco());
                writer.newLine();
            }

            System.out.println("Contatos exportados para: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return filePath;
    }
}
