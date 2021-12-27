/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guichatapplication;

/**
 *
 * @author User
 */
public class GUIChatApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        new Thread(new Runnable() {
            @Override
            public void run() {
                new Chat_Server().setVisible(true);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Chat_Server.start();
                    }
                }).start();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                new Chat_Client().setVisible(true);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Chat_Client.start();
                    }
                }).start();
            }
        }).start();
    }
    
}
