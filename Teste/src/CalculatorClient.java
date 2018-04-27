
import java.rmi.Naming;

import javax.swing.JOptionPane;

public class CalculatorClient {

	public static void main(String[] args) {
		try {
			Calculator c = (Calculator) Naming.lookup("//localhost:1020/calculatorservice");
			
			int n1 = Integer.parseInt(
			JOptionPane.showInputDialog(null, "Entre com o primeiro valor", "Input", JOptionPane.INFORMATION_MESSAGE));
			
			
			String opcao[] = {"+","-","*","/"};
			int operacao = JOptionPane.showOptionDialog(null, "Escolha uma das operacoes", "Tipo de operacao", 0,
															JOptionPane.INFORMATION_MESSAGE, null, opcao, opcao[0]);
				
			int n2 = Integer.parseInt(
			JOptionPane.showInputDialog(null, "Entre com o primeiro valor", "Input", JOptionPane.INFORMATION_MESSAGE));
			
			//´´´´´´
			switch(operacao) {
			case 0:
				JOptionPane.showMessageDialog(null, "ADD: " +c.add(n1, n2));
				break;
			case 1:
				JOptionPane.showMessageDialog(null, "SUB: " +c.sub(n1, n2));
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "MUL: " +c.mul(n1, n2));
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "DIV: " +c.div(n1, n2));
				break;
			}
			
		} catch (Exception e) {
			System.out.println(e);
			}

	}
}
