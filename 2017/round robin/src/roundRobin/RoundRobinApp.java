/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roundRobin;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 *
 * @author carlos.reis
 */
public class RoundRobinApp {

    /**
     * @param args
     * @throws java.io.IOException
     * @throws java.net.URISyntaxException
     */

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws IOException, URISyntaxException {
        // TODO code application logic here
        Fila filaRoundRobin = new Fila();
        Fila filaProcessos = new Fila();

        
        URL url = RoundRobinApp.class.getResource("processo.txt");

        String path = url.getPath();

        try {
            FileManager.readProcess(path, filaProcessos);
        } catch (IOException e) {
            System.out.println("Erro de leitura de arquivo : " + e);;
        } catch (IllegalArgumentException a) {
            
            System.out.println(a);
        }
        
            RoundRobin roundRobin = new RoundRobin(filaRoundRobin, filaProcessos);

           System.out.println(roundRobin.run());
        }
    }
