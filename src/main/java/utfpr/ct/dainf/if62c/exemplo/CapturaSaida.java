package utfpr.ct.dainf.if62c.exemplo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * UTFPR - Universidade Tecnológica Federal do Paraná DAINF - Departamento
 * Acadêmico de Informática IF62C - Fundamentos de Programação 2
 *
 * Exemplo de Programação em Java.
 * Esta classe implementa um thread que tenta ler a saída de um
 * processo enquanto o processo estiver ativo.
 * @author Wilson Horstmeyer Bogado <wilson@utfpr.edu.br>
 */
public class CapturaSaida extends Thread {

    private final InputStream is;

    public CapturaSaida(InputStream is) {
        this.is = is;
    }

    @Override
    public void run() {
        try {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String linha;
            while ((linha = br.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }
}
