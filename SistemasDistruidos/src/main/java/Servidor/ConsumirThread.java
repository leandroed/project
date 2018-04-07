package Servidor;

import java.util.List;
import java.util.concurrent.ExecutorService;

public class ConsumirThread implements Runnable {
    private List<String> comandos;
    private ExecutorService executor;
    
    public ConsumirThread(List<String> comandos, ExecutorService executor){
        if(comandos != null && !comandos.isEmpty()){
            this.comandos.addAll(comandos);
            this.executor = executor;
        }
    }
    
    @Override
    public void run() {
        if(comandos != null && !comandos.isEmpty()){
            LogThread logTrd = new LogThread(this.comandos);
            ProcessaThread procTrd = new ProcessaThread(this.comandos);

            this.executor.execute(procTrd);
            this.executor.execute(logTrd);
        }
    }
    
}
