package Hilos;

import javax.swing.*;
import java.awt.*;

public class Hilos {

	private static JTextArea textArea = new JTextArea("prueba");

	public static void main(String[] args) {
		Runnable r = new Runnable() { //para poder ejecutar lo que hay dentro del metodo run en un hilo

			@Override
			public void run() { //Lo que queremos que se ejecute
				apareceTexto("texto");
				cambiarColorTexto("texto");
			}
		};
		Thread t = new Thread(r); //Establecemos un nuevo hilo con la interfaz runnable
		t.start(); //iniciamos el hilo
	}
	private static void cambiarColorTexto(String texto) {
		textArea.setText("");
		int r=122,g=160,b=100;
		for(int i=0;i<texto.length();i++) {
			textArea.setText(textArea.getText()+String.valueOf(texto.charAt(i)));
			textArea.setForeground(new Color(r,g,b));
			r++;
			if(r>255)
				r=0;
			g++;
			if(g>255)
				g=0;
			b++;
			if(b>255)
				b=0;
			try {
				Thread.sleep(100); //Para durante 100 milisegundos
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static void apareceTexto(String texto) {
		textArea.setForeground(Color.WHITE);
		textArea.setText(texto);

		while(true) {
			for(int i=255;i>=0;i--) {
				textArea.setForeground(new Color(i, i, i));
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			for(int i=0;i<256;i++) {
				textArea.setForeground(new Color(255, i, i));
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
