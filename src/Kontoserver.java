import java.rmi.Naming;

public class Kontoserver
{
	private static int PORT = 1099;
	public static void main(String[] arg) throws Exception
	{
		// Enten: Kør programmet 'rmiregistry' fra mappen med .class-filerne, eller:
		java.rmi.registry.LocateRegistry.createRegistry(PORT); // start i server-JVM
		KontoImpl k = new KontoImpl();

		//Naming.rebind("rmi://localhost:"+PORT+"/kontotjeneste", k);

		System.setProperty("java.rmi.server.hostname", "dist.saluton.dk");
		Naming.rebind("rmi://dist.saluton.dk:"+PORT+"/kontotjeneste", k);

		System.out.println("Kontotjeneste registreret magn.");
		//k.overførsel(117);
		//k.overførsel(1023);


	}
}
/*
Hvis klienter skulle forbinde til server "javabog.dk" på port 20099 skulle der rettes til
		java.rmi.registry.LocateRegistry.createRegistry(20099); // lyt på port 20099
		KontoI k = new KontoImpl();
		System.setProperty("java.rmi.server.hostname", "javabog.dk");
		Naming.rebind("rmi://javabog.dk:20099/kontotjeneste", k);

Overfør JAR-fil til server, f.eks.:
scp /home/j/prog1/oop-projekt/dist/oop-projekt.jar javabog.dk:

Log ind på server, f.eks.:
ssh javabog.dk

Start med f.eks.:
java -cp oop-projekt.jar kapitel_19.Kontoserver

I stedet for System.setProperty("java.rmi.server.hostname", "javabog.dk");
kunne du også starte serverprogrammet med:
java -Djava.rmi.server.hostname=javabog.dk -cp oop-projekt.jar kapitel_19.Kontoserver


*/
