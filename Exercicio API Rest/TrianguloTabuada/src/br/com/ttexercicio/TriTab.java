package br.com.ttexercicio;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

//http://localhost:8080/TrianguloTabuada/rest/exercicio2/tabuada/4

@Path("exercicio2")
public class TriTab {

	@GET
	@Path("tabuada/{param1}")
	public String tabuada(@PathParam("param1") int tab){
		String out="tabuada do " + tab + "<br>";
		for( int x = 0; x <= 10; x++ ) {
		out += String.valueOf( tab*x + "<br>" );
		}
		
		return out;
	}
	
	
	@GET
	@Path("tabuada/{param1}/{param2}/{param3}")
	public String triangulo(@PathParam("param1") int a, @PathParam("param2") int b, @PathParam("param3") int c){
		int base = 0, area = 0;
		int co = 4, h = 4, ca = 4;
		
		if( ( (a + b) > c) && ((a + c) > b) && ((b + c) > a)){
			System.out.println("É um triangulo");
			area = (co*h)/2;
			base = co + ca + h;
			
		}else {
			System.out.println("Não é um triangulo");
		}
		String tri = String.valueOf("<br>-Area: " + area + "<br>-Perimetro: " + base);
		return tri;
	}	
	
}
