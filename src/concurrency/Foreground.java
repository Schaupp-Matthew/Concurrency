/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrency;

/**
 *
 * @author Mattn
 */
public class Foreground extends Thread {
    
    String threadName;

    public Foreground(String threadName) {
        this.threadName = threadName;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }
    
    @Override
    public void run() {
        System.out.println("\n*********" + threadName + " STARTING*********");
        
        for (int i = 0; i < 101; i++) {
            System.out.println(threadName + ": " + i);
            try {
                Thread.currentThread().sleep(500);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("\n*********" + threadName + " FINISHED*********");
    }
}
