package br.com.hs.nfe.pe;

import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import br.com.hs.nfe.pe.conf.Config;
import br.com.hs.nfe.pe.file.FileReceiver;
import br.com.hs.nfe.pe.file.FileReceiverImpl;
import br.com.hs.nfe.pe.pdf.DanfeFSDAThread;
import br.com.hs.nfe.pe.pdf.DanfeThread;
import br.com.hs.nfe.pe.print.ImprimirPDFFSDAThread;
import br.com.hs.nfe.pe.print.ImprimirPDFThread;
import br.com.hs.nfe.pe.zip.DescompactaNFeFSDAThread;
import br.com.hs.nfe.pe.zip.DescompactaNFeThread;

public class Main {

	/**
	 * @param args
	 */
	private static final Logger logger = Logger.getLogger("Main");
	private static FileReceiver fileReceiverImpl;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String log4jConfigurationFile = System.getProperty("log4j.configuration", "conf/log4j.properties");
		PropertyConfigurator.configure(log4jConfigurationFile);
		logger.info("Aplicação iniciada");
		if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }
		
		try
		{
			fileReceiverImpl = new FileReceiverImpl();
			Registry r = LocateRegistry.createRegistry(Integer.parseInt(Config.getInstance().configVO.getPortaRMI()));
			Remote obj = UnicastRemoteObject.exportObject(fileReceiverImpl, Integer.parseInt(Config.getInstance().configVO.getPortaRMI()));
	        r.rebind("FileReceiver", obj);
		}
		catch(RemoteException re)
        {
            logger.error(re);
        }
		
		DescompactaNFeThread descompactaNFeThread = new DescompactaNFeThread();
		descompactaNFeThread.start();
		DescompactaNFeFSDAThread descompactaNFeFSDAThread = new DescompactaNFeFSDAThread();
		descompactaNFeFSDAThread.start();
		DanfeThread danfeThread = new DanfeThread();
		danfeThread.start();
		DanfeFSDAThread danfeFSDAThread = new DanfeFSDAThread();
		danfeFSDAThread.start();
		ImprimirPDFThread imprimirPDFThread = new ImprimirPDFThread();
		imprimirPDFThread.start();
		ImprimirPDFFSDAThread imprimirPDFFSDAThread = new ImprimirPDFFSDAThread();
		imprimirPDFFSDAThread.start();
	}

}
