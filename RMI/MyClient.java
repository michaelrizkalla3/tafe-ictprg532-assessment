import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyClient {
    public static void main(String[] args) {

    try
    {
//        Adder stub = (Adder) Naming.lookup("rmi://localhost:5000/shubha");
        Registry registry = LocateRegistry.getRegistry(5000);
        Adder adderStub = (Adder)registry.lookup("Adder");
        System.out.println("Sum ="+adderStub.add(5,6));
    } catch (RemoteException e) {
        System.out.println("ERROR");
        System.out.println(e.getMessage());
        e.printStackTrace();
    } catch (NotBoundException e) {
        System.out.println("ERROR");
        System.out.println( e.getMessage());
        e.printStackTrace();
    } /*catch (MalformedURLException e) {
        System.out.println( e.getMessage());
    }*/
    }}
