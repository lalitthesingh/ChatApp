import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
public interface ClientInterface extends Remote
{
    void refreshList(ArrayList<String> al)throws RemoteException;
    void displayMessage(String message)throws RemoteException;
}
