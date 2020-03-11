import java.rmi.Naming;
import java.util.ArrayList;

public class Kontoklient
{
	public static void main(String[] arg) throws Exception
	{
		Thread.sleep(500);
		KontoI k =(KontoI) Naming.lookup("rmi://localhost:1099/kontotjeneste");
    k.overførsel(100);
    k.overførsel(50);
		System.out.println( "Saldo er: "+ k.saldo() );
		k.overførsel(-150);
		System.out.println( "Saldo ved slut er: "+ k.saldo() );
		ArrayList<String> bevægelser = k.bevægelser();

		System.out.println( "Bevægelser er: "+ bevægelser );

		Thread.sleep(10000);
		System.out.println( "Saldo HELT ved slut er: "+ k.saldo() );
	}
}
/*
	long tid = System.currentTimeMillis();
	for (int i=0; i<100; i++) {
		k.overførsel(1);
		k.overførsel(-1);
	}
	long dt = System.currentTimeMillis() - tid;
	System.out.println( "Kørselstiden for RMI var: "+ dt );
*/
