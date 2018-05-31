/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Mattn
 */
public class Concurrency {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ExecutorService fixedExecutor = Executors.newFixedThreadPool(4);
        
        System.out.println("\n*********Main Thread STARTING**********");
        
        for(int i = 1; i < 3; i++) {
            Foreground foreground = new Foreground("Foreground Thread " + i);
            Background background = new Background("Background Thread " + i);
            fixedExecutor.execute(foreground);
            fixedExecutor.execute(background);
        }
        System.out.println("\n***********Main Thread Going to Sleep************");
        try {
            Thread.sleep(10000);
            System.out.println("\n**********Main Thread Done Sleeping***********");
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
        fixedExecutor.shutdown();
        
        System.out.println("\n*********Main Thread FINISHED**********");
    }
    
}
