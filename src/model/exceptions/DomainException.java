package model.exceptions;

public class DomainException extends RuntimeException {
	// Quando um tipo � serializable (que � o caso do Exception), ele precisa ter uma vers�o.
	// A linha abaixo estamos colocando o valor padr�o de vers�o.
	// Isso ser� explicado mais pra frente.
	private static final long serialVersionUID = 1L; // declarando a vers�o de uma classe serializable.
	
	// fizemos o construtor abaixo para permitir que eu possa INSTANCIAR a minha "Exce��o personalizada" (DomainException)
	// passando uma mensagem (msg) para ela. Ent�o, essa mensagem vai ficar armazenada dentro da minha exce��o personalizada.
	public DomainException(String msg) {
		super(msg); // repassando a mensagem (msg) para o construtor da Super Classe (Exception nesse caso)
	}

}
