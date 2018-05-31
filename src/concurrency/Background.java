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
public class Background implements Runnable {
    
    String runnableName;
    int count;

    public Background(String runnableName) {
        this.runnableName = runnableName;
    }

    public String getRunnableName() {
        return runnableName;
    }

    public void setRunnableName(String runnableName) {
        this.runnableName = runnableName;
    }
    
    
    @Override
    public void run() {
        System.out.println("\n*********" + runnableName + " STARTING*********");
        
        for (int i = 0; i < 1001; i++) {
            count = i;
            try {
                Thread.currentThread().sleep(10);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("\n*********" + runnableName + " FINISHED*********"
                + "\nCount = " + count);
    }
}
