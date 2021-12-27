import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MyServer {
    public static void main(String[] args) {
        try
        {
//            System.setProperty("java.rmi.server.hostname","localhost");
                Registry registry = LocateRegistry.createRegistry(5000);
            registry.rebind("Adder", new AdderRemote());
//            Naming.rebind("rmi://127.0.0.1:5001/shubha",stub);
        } catch (RemoteException e) {
            System.out.println("ERROR");
            System.out.println(e.getMessage());
            e.printStackTrace();
        } /*catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }*/
    }
}
