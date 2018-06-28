package excepciones;

public class FechaInvalidaException extends RuntimeException{
	
	private int mes;
	private int dia;
	
	
	public FechaInvalidaException(String info) {
		super(info);
	}
	public FechaInvalidaException(String info, int diaParam, int mesParam) {
		super(info);
		dia = diaParam;
		mes = mesParam;
	}

	public void informacionMensaje() {
		
		if(mes < 1 || mes > 12) {
			System.out.println("Mes ingresado incorrecto. Ingrese un mes entre 1 y 12.");
		}
		else {
			if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
				
				if(dia > 31 || dia < 1) {
					System.out.println("El dia ingresado no es valido. El mes ingresado tiene 31 dias.");
				}
				
			}
			else if(mes == 4 || mes == 6 || mes == 9 || mes == 11) {
				if(dia > 30 || dia < 1) {
					System.out.println("El dia ingresado no es valido. El mes ingresado tiene 30 dias");
				}
				
			}
			else {
				if(dia > 28 || dia < 1) {
					System.out.println("El dia ingresado no es valido. El mes ingresado tiene 28 dias");
				}
			}
		}
	}
}	
	
