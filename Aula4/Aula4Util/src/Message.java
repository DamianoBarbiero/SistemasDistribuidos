import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.proj.controller.ChatDB;
import br.com.proj.model.Chat;

public class Message implements Serializable {
	
	
	
	private String user;
	private String message;
	
	private static List<Message> LstMessage = new ArrayList<Message>();

	public Message(String user, String message) {
		this.user = user;
		this.message = message;
	}

	public String getUser() {
		return user;
	}
	
	private static final long serialVersionUID = 1L;
	

	public void setUser(String user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public static List<Message> getLstMessage(){
		return LstMessage;
	}
	
	public static void setLstMessage(Message msg) {
		LstMessage.add(msg);
		
		Chat msgchat = new Chat();
			msgchat.setUser(msg.getUser());
			msgchat.setMessage(msg.getMessage());
			
			new ChatDB().insert(msgchat);
			
			if(msgchat.getMessage().equals("!CriarTexto")) {
				CriarTxt();
			}
			
	}
	
	public static void CriarTxt() {
		FileWriter arq;
		try {
			String path = "C:\\Text\\";
			(new File(path)).mkdir();
			
			arq = new FileWriter(path+"TextoL.txt");
			PrintWriter gravar = new PrintWriter (arq);
			List<Chat> lstChat = new ChatDB().selectAll();
			
			for(Chat chat: lstChat) {
				gravar.println(chat.toString());
			}
			arq.close();
		}catch (IOException e) {
			e.getMessage();
		}
	}
}
