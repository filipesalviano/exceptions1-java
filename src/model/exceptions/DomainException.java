package model.exceptions;

public class DomainException extends RuntimeException {
	// Quando um tipo é serializable (que é o caso do Exception), ele precisa ter uma versão.
	// A linha abaixo estamos colocando o valor padrão de versão.
	// Isso será explicado mais pra frente.
	private static final long serialVersionUID = 1L; // declarando a versão de uma classe serializable.
	
	// fizemos o construtor abaixo para permitir que eu possa INSTANCIAR a minha "Exceção personalizada" (DomainException)
	// passando uma mensagem (msg) para ela. Então, essa mensagem vai ficar armazenada dentro da minha exceção personalizada.
	public DomainException(String msg) {
		super(msg); // repassando a mensagem (msg) para o construtor da Super Classe (Exception nesse caso)
	}

}
