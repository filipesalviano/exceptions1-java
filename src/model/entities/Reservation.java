package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // colocamos STATIC para que não seja instanciado 
																			  // um NOVO SimpleDateFormat pra cada objeto 
																			  // Reservation que minha aplicação tiver.
																			  // Vamos precisar de apenas um.
	
	/*
	public Reservation() {
	}
	*/

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
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

	// método para calcular a duração da hospedagem (diferença de dias):
	public long duration() { // vai retornar um dado do tipo long que é o INTEIRO mais longo.
		long diff = checkOut.getTime() - checkIn.getTime(); // pegando a diferença entre duas datas em MILISEGUNDOS...
		long dias = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);// convertendo o valor "diff" (que estava em milisegundos) para DIAS.
		return dias;
	}
	
	public void updateDates(Date checkIn, Date checkOut) {
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
