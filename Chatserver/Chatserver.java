import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Chatserver extends UnicastRemoteObject implements ServerInterface
{
     ArrayList<String> al1=new ArrayList<String>();
     ArrayList<ClientInterface> al2=new ArrayList<ClientInterface>();
    
    public Chatserver()throws Exception
    {
     super();  
    }
    
    
    public void registerClient(String n,ClientInterface ci)
    {
        al1.add(n);
        al2.add(ci);
        for(int i=0;i<al2.size();i++){
           try{ ClientInterface c=al2.get(i);
                c.refreshList(al1);
           }catch(Exception ex){
                System.out.println(ex); 
           }
        }
    }
    public void sendMessage(String m,String msg)
    {
        for(int i=0;i<al2.size();i++)
        {
            ClientInterface c=al2.get(i);
            try {
                c.displayMessage(m+":"+msg);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }
    public static void main(String[] args) 
    {
        try
        {
            Chatserver ser=new Chatserver();
            Naming.rebind("chatserver", ser);
            System.out.println("Server registered"); 
        }
        catch(Exception ex){System.out.println(ex);}
    }
}