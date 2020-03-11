import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class KontoImpl extends UnicastRemoteObject implements KontoI
{
	private int saldo = 100; // man starter med 100 kroner
	private ArrayList<String> bevægelser = new ArrayList<>();

	public KontoImpl() throws java.rmi.RemoteException
	{
	}

	public void overførsel(int kroner)
	{
		int nySaldo = saldo + kroner; // her beregnes ny saldo
		String s = Thread.currentThread() + " Overførsel på "+kroner+" kr. Ny saldo er "+nySaldo+" kr.";
		bevægelser.add(s);
		System.out.println(s);
		//try { Thread.sleep(500); } catch (InterruptedException ex) { } // transaktionen gemmes
		saldo = nySaldo; // her er transaktionen gemt
	}

	public int saldo()
	{
		System.out.println("Der spørges om saldoen. Den er "+saldo+" kr.");
		return saldo;
	}

	public ArrayList<String> bevægelser()
	{
		System.out.println("Der spørges på alle bevægelser.");
		return bevægelser;
	}
}