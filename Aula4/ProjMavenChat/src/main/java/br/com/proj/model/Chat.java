package br.com.proj.model;

import java.text.MessageFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Chat {
	
	public static final String QUERY_ALL = "Chat.All";
	
	//private date datamessage;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigo;
	private String user;
	private String message;
	
	
	public Chat(int codigo, String user, String message) {
		this.codigo = codigo;
		this.user = user;
		this.message = message;
	}

	public Chat() {
	}

	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	
	
	@Override
	public String toString() {
		return MessageFormat.format("{0} - {1}", user, message);
	}
}
