import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class MyClient {
    public static void main(String[] args) {

    try
    {
        Adder stub = (Adder) Naming.lookup("rmi://localhost:5000/shubha");
        System.out.println("Sum ="+stub.add(5,6));
    } catch (RemoteException e) {
        System.out.println(e.getMessage());
    } catch (NotBoundException e) {
        System.out.println( e.getMessage());
    } catch (MalformedURLException e) {
        System.out.println( e.getMessage());
    }
    }}
