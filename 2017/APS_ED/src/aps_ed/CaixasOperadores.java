package aps_ed;

/**
 *
 * @author lab804
 */
public class CaixasOperadores {
   private String nome;
   private int id;
   private boolean preferencial;
   private ThreadFila fila;
   private int tmpDemo;

    public CaixasOperadores() {
    }

    public String getNome() {
       
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPreferencial() {
        return preferencial;
    }

    public void setPreferencial(boolean preferencial) {
        this.preferencial = preferencial;
    }

    public ThreadFila getThreadFila() {
        return fila;
    }

    public void setThreadFila(ThreadFila fila) {
        this.fila = fila;
    }

    public int getTmpDemo() {
        return tmpDemo;
    }

    public void setTmpDemo(int tmpDemo) {
        this.tmpDemo = tmpDemo;
    }

    public CaixasOperadores(String nome, int id, boolean preferencial, ThreadFila fila, int tempDemo) {
        this.nome = nome;
        this.id = id;
        this.preferencial = preferencial;
        this.fila = fila;
        this.tmpDemo = tmpDemo;
    }

    

    
    public String display()
    {
        return "Nome Funcionaria(o) "+nome+"\nIdentificador Funcional "+id+
                "\n É preferencial? "+preferencial;
    }
    
    
    
}
