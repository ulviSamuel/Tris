package Bean;

public class Bot { //gestisce la selezione casuale di un posto dove inserire un simbolo nella tabella

	public Bot() {
		
	}
	
	public short lvMedAdd() {
		
		GestorePartita gp = new GestorePartita();
		
		boolean continua = false;
		short val = 0;
		
		do {
			continua = false;
			
			val = (short) (Math.random()*9);
			
			switch(val) {
				case 0: if(!gp.getPuntoOccupato(0, 0)) continua = true;
				break;
				
				case 1: if(!gp.getPuntoOccupato(0, 1)) continua = true;
				break;
					
				case 2: if(!gp.getPuntoOccupato(0, 2)) continua = true;
				break;
				
				case 3: if(!gp.getPuntoOccupato(1, 0)) continua = true;
				break;
				
				case 4: if(!gp.getPuntoOccupato(1, 1)) continua = true;
				break;
				
				case 5: if(!gp.getPuntoOccupato(1, 2)) continua = true;
				break;
				
				case 6: if(!gp.getPuntoOccupato(2, 0)) continua = true;
				break;
				
				case 7: if(!gp.getPuntoOccupato(2, 1)) continua = true;
				break;
				
				case 8: if(!gp.getPuntoOccupato(2, 2)) continua = true;
				break;
			}
			
		}while(continua);
		
		
		return val;
	}
}
