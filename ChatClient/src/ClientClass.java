
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JTextArea;
public class ClientClass extends UnicastRemoteObject implements ClientInterface
{
    JList list;
    JTextArea area;
    ClientClass(JList l,JTextArea area)throws RemoteException
    {
        super();
        this.list=l;
        this.area=area;
    }

    @Override
    public void refreshList(ArrayList<String> al) throws RemoteException {
        list.setListData(al.toArray());
    }

    @Override
    public void displayMessage(String message) throws RemoteException {
        area.append(message+"\n");
    }
    
    
}
