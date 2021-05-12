package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // colocamos STATIC para que n�o seja instanciado 
																			  // um NOVO SimpleDateFormat pra cada objeto 
																			  // Reservation que minha aplica��o tiver.
																			  // Vamos precisar de apenas um.
	
	/*
	public Reservation() {
	}
	*/

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		
		// tratando (j� no construtor) o caso onde o usu�rio digita a data de checkOut menor que a data de checkIn
		if(!checkOut.after(checkIn)) {
			 throw new DomainException("Check-out date must be after check-in date");
		}
		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	// m�todo para calcular a dura��o da hospedagem (diferen�a de dias):
	public long duration() { // vai retornar um dado do tipo long que � o INTEIRO mais longo.
		long diff = checkOut.getTime() - checkIn.getTime(); // pegando a diferen�a entre duas datas em MILISEGUNDOS...
		long dias = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);// convertendo o valor "diff" (que estava em milisegundos) para DIAS.
		return dias;
	}
	
	public void updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) { // Agora, se acontecer um erro, vamos lan�ar uma exce��o em vez de retornar alguma coisa
			 throw new DomainException("Reservation dates for update must be future dates"); // temos que instanciar uma exce��o. Vamos usar uma que j� existe no java. Essa "IllegalArgumentException", usamos quando os argumentos que passamos no m�todo, s�o inv�lidos.
		}
		if(!checkOut.after(checkIn)) {
			 throw new DomainException("Check-out date must be after check-in date");
		}
		this.checkIn = checkIn; // o checkIn do meu objeto recebe o checkIn que veio como argumento.
		this.checkOut = checkOut; // o checkOut do meu objeto recebe o checkOut que veio como argumento.
	}
	
	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ " check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duration()
				+ " nights";
	}
}
