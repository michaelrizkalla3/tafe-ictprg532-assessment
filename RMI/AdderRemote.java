import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AdderRemote extends UnicastRemoteObject implements Adder

{
public AdderRemote() throws RemoteException{
    super();
}

    public int add(int x, int y) throws RemoteException {
        return x + y;
    }


}
