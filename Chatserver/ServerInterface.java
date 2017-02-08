
import java.rmi.Remote;

public interface ServerInterface extends Remote {
    void registerClient(String name1,ClientInterface ci);
    void sendMessage(String name2,String message);
}
