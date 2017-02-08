import java.rmi.*;
interface MiddleApp extends Remote
{
	void registerClient(String name,ClientInterface ci)throws RemoteException;
        void sendMessage(String name,String message)throws RemoteException;
}