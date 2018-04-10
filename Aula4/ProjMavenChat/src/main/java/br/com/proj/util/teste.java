package br.com.proj.util;

import br.com.proj.controller.ChatDB;
import br.com.proj.model.Chat;

public class teste {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Chat msg = new Chat();
	//	msg.set(0);
		msg.setUser("aaaaaa");
		msg.setMessage("eeeeeee");
		
		new ChatDB().insert(msg);
	}


}
