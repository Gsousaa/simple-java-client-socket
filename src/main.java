import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   String host="100.141.1.241";
		   int	  port=9090;
		try {
			
			Socket socket = new Socket(host,port);
			// Criando printwriter para facilitar o envio de dados para o servidor.
			PrintWriter out=new PrintWriter(socket.getOutputStream(), true); // Passa o OutputStream do socket para o PrintWriter.
			
			//out.println("Socket created "+host +":"+port);
			System.out.println("Socket created "+host +":"+port);
			
			// Criando bufferedreader para facilitar a leitura de dados a partir do servidor.
			BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(true)
			{
				String value= in.readLine();
				if(value == null)
				{ 
					socket.close();
					socket = new Socket(host,port);
				}else 
				{
					System.out.println( value);	
				}
					
			}			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}


}
