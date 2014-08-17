
import java.io.IOException;
import utfpr.ct.dainf.if62c.exemplo.CapturaSaida;

/**
 * IF62C Fundamentos de Programação 2
 * Exemplo de programação em Java.
 * @author Wilson Horstmeyer Bogado <wilson@utfpr.edu.br>
 */
public class ExemploExecCmdThread {

    public static void main(String args[]) throws Exception {
        // executamos o comando compatível com o sistema opearacional
        String cmd;
        String os = System.getProperty("os.name");
        if (os.toLowerCase().contains("windows")) {
            cmd = "cmd /c c: & cd \\windows & dir";
        } else {
            cmd = "sh -c \"cd /tmp;ls -al\"";
        }

        Runtime rt = Runtime.getRuntime();
        System.out.println("Executando " + cmd);
        Process proc = rt.exec(cmd);
        CapturaSaida err = new CapturaSaida(proc.getErrorStream());
        CapturaSaida out = new CapturaSaida(proc.getInputStream());

        err.start();
        out.start();

        int status = proc.waitFor();
        System.out.println("Processo terminado com status " + status);
    }
}
