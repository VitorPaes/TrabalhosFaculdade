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
public class RoundRobin {

    Fila filaRoundRobin;
    Fila processos;
    static int quantum;

    public RoundRobin(Fila roundRobin, Fila processos) {
        this.filaRoundRobin = roundRobin;
        this.processos = processos;
    }

    public String run() {
        String saida = "";

        saida += "*********************************\n";
        saida += "**** Escalonador Round-Robin ****\n";
        saida += "*********************************\n\n";

        
        int cont = 1;
        int tamanhoTotal = tamanhoTotal();

        for (int i = 0; i <= tamanhoTotal; i++) {
            boolean breakOuterFor = false;
            String description = "";
            boolean isLastCPU = (i == tamanhoTotal);

            for (Processo processo : processos.asVector()) {
                if (processo.submission == i) {
                    filaRoundRobin.enqueue(processo);
                    description += " chegada de processo " + processo.name;
                }
            }

            Processo processo = filaRoundRobin.peek();

            if (processo != null) {
                boolean passouQuantum = cont >= quantum;
                boolean ultimo = processo.burst == 0;
                int[] vetorIO = processo.converteIO(processo.opIO);
                boolean temIO = vetorIO.length != 0;

                if (temIO) {
                    for (int j : vetorIO) {
                        boolean isIO = processo.reverseBurst == j;

                        if (isIO) {
                            description += " operação de I/O " + processo.name;
                            processo = changePeek(filaRoundRobin, processo);
                            cont = 1;

                            if (!ultimo) {
                                if (!passouQuantum) {
                                    saida += execProcessNotQuantum(description, i, processo, filaRoundRobin);
                                    breakOuterFor = true;
                                    break;
                                } else if (passouQuantum) {
                                    saida += execProcessOnQuantum(description, i, processo, filaRoundRobin);
                                    cont = 1;

                                    breakOuterFor = true;
                                    break;
                                }
                            } else if (ultimo) {
                                saida += execProcessEnd(description, i, processo, filaRoundRobin, breakOuterFor);
                                cont = 1;
                                break;
                            }
                        }
                    }
                }

                if (breakOuterFor) {
                    continue;
                }

                if (!ultimo) {
                    if (!passouQuantum) {
                        saida += execProcessNotQuantum(description, i, processo, filaRoundRobin);
                        cont++;
                    } else if (passouQuantum) {
                        saida += execProcessOnQuantum(description, i, processo, filaRoundRobin);
                        cont = 1;
                    }

                } else if (ultimo) {
                    saida += execProcessEnd(description, i, processo, filaRoundRobin, breakOuterFor);
                    cont = 1;
                }
            }

            if (isLastCPU) {
                saida += "Tempo: " + i + " fim de processo " + processo.name + "\n";
                saida += "Fila: " + filaRoundRobin.allList() + "\n\n";
            }
        }

        saida += "*************************************\n";
        saida += "* Fim do simulador de escalonamento *\n";
        saida += "*************************************\n\n";

        return saida;
    }

    private String execProcessNotQuantum(String description, int i, Processo processo, Fila filaRoundRobin) {
        String saida = "";
        saida += "Tempo: " + i + description + "\n";
        saida += "Fila: " + filaRoundRobin.allList() + "\n";
        saida += "CPU: " + processo.name + "(" + processo.burst + ")\n\n";
        processo.burst--;
        processo.reverseBurst++;

        return saida;
    }

    private String execProcessOnQuantum(String description, int i, Processo processo, Fila filaRoundRobin) {
        String saida = "";

        description = " fim de quantum " + processo.name;
        processo = changePeek(filaRoundRobin, processo);
        saida += "Tempo: " + i + description + "\n";
        saida += "Fila: " + filaRoundRobin.allList() + "\n";
        saida += "CPU: " + processo.name + "(" + processo.burst + ")\n\n";
        processo.burst--;
        processo.reverseBurst++;

        return saida;
    }

    private String execProcessEnd(String description, int i, Processo processo, Fila filaRoundRobin, boolean breakOuterFor) {
        String saida = "";
        description = " fim de processo " + processo.name;
        filaRoundRobin.dequeue();
        processo = filaRoundRobin.peek();
        if (processo != null) {
            saida += "Tempo: " + i + description + "\n";
            saida += "Fila: " + filaRoundRobin.allList() + "\n";
            saida += "CPU: " + processo.name + "(" + processo.burst + ")\n\n";
            processo.burst--;
            processo.reverseBurst++;
            breakOuterFor = true;
        }

        return saida;
    }
    
    private Processo changePeek(Fila filaRoundRobin, Processo processo) {
        filaRoundRobin.dequeue();
        filaRoundRobin.enqueue(processo);
        processo = filaRoundRobin.peek();
        return processo;
    }
    
    private int tamanhoTotal() {
        int tamanhoTotal = 0;

        for (Processo processo : processos.asVector()) {
            tamanhoTotal += processo.burst;
        }

        return tamanhoTotal;
    }
}
