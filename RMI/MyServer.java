import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class MyServer {
    public static void main(String[] args) {
        try
        {
            Adder stub = new AdderRemote();
            Naming.rebind("rmi://localhost:5000/shubha",stub);
        } catch (RemoteException e) {
            System.out.println(e.getMessage());
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }
}
