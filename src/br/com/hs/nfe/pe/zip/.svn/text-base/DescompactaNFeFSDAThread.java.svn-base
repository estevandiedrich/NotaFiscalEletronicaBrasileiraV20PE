package br.com.hs.nfe.pe.zip;

import java.io.File;

import org.apache.log4j.Logger;

import br.com.hs.nfe.base.ThreadBase;
import br.com.hs.nfe.file.FileManager;
import br.com.hs.nfe.pe.conf.Config;

public class DescompactaNFeFSDAThread extends ThreadBase {
	private static final Logger logger = Logger.getLogger("DescompactaNFeFSDAThread");
	private DescompactaNFe descompactaNFe = new DescompactaNFe();
	public void run()
	{
		Thread.currentThread().setName( "DescompactaNFeFSDAThread" );
		logger.info("Iniciando thread DescompactaNFeFSDAThread");
		while ( super.isRunning() ) 
		{
			try
			{
				File[] enviNFeZIPArray = FileManager.getInstance().getZipFiles(Config.getInstance().configVO.getXmlCompactadoFSDA());
				for(File enviNFeZip:enviNFeZIPArray)
				{
					descompactaNFe.descompactaNFe(enviNFeZip,Config.getInstance().configVO.getEnviNFeXMLProcessadosFSDA());
			        enviNFeZip.delete();
				}
			}
			catch(Throwable t)
			{
				logger.error("Erro não capturado", t);
			}
			try 
			{
				Thread.sleep( Integer.parseInt(Config.getInstance().getEnviNFeThreadSleep()) );
			}
			catch ( InterruptedException e ) 
			{
				logger.error("Problemas ao interromper a Thread DescompactaNFeFSDAThread", e);
			}
			finally
			{
				
			}
		}
	}
}