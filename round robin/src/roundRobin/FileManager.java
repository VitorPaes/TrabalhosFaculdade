/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roundRobin;

/**
 *
 * @author carlos.reis
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileManager {

    @SuppressWarnings("empty-statement")
    public static void readProcess(String path, Fila processos) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader(path));


        RoundRobin.quantum = Integer.parseInt(bf.readLine());
        String line = bf.readLine();

        int emptyLine = 0;
        while (emptyLine < 2) {

            Processo process = new Processo();
            Node current = new Node(process);
            if (line != null) {

                line = bf.readLine();
                current.getDado().setName(line);

                line = bf.readLine();
                current.getDado().setBurst(Integer.parseInt(line));

                line = bf.readLine();
                current.getDado().setSubmission(Integer.parseInt(line));

                line = bf.readLine();
                current.getDado().setIO(line);

                if (line.equalsIgnoreCase("SIM")) {

                    line = bf.readLine();
                    CharSequence a = Integer.toString(current.getDado().burst);
                    if (line.contains(a) || line.contains("1")) {
                        System.out.println("Última operação do processo deve ser na CPU, não em I/O, favor mudar o processo " + current.getDado().name);
                        throw new IllegalArgumentException();
                    }
                    current.getDado().setopIO(line.trim());

                }
                processos.enqueue(process);
            } else {
                emptyLine++;
                break;
            }

            line = bf.readLine();

        }

        bf.close();

    }
}
