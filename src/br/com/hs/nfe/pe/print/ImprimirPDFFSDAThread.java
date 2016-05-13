package br.com.hs.nfe.pe.print;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import br.com.hs.nfe.base.ThreadBase;
import br.com.hs.nfe.file.FileManager;
import br.com.hs.nfe.pe.conf.Config;
import br.com.hs.nfe.print.ImprimirPDF;

public class ImprimirPDFFSDAThread extends ThreadBase{
	private static final Logger logger = Logger.getLogger("ImprimirPDFThread");
	public void run()
	{
		Thread.currentThread().setName( "ImprimirPDFFSDAThread" );
		logger.info("Iniciando thread ImprimirPDFFSDAThread");
		while ( super.isRunning() ) 
		{
			try
			{
				File[] enviNFePDFArray = FileManager.getInstance().getPdfFiles(Config.getInstance().configVO.getDanfeFSDA());
				for(File enviNFePDF:enviNFePDFArray)
				{
					logger.info("Imprimindo arquivo : "+enviNFePDF.getName());
					InputStream is = new FileInputStream(enviNFePDF);
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					IOUtils.copy(is, baos);
					byte msg[] = baos.toByteArray();
					IOUtils.closeQuietly(is);
					IOUtils.closeQuietly(baos);
					ImprimirPDF.getInstance().imprimir(msg,Config.getInstance().configVO.getImpressoraFSDA(),Integer.parseInt(Config.getInstance().configVO.getNroPaginasFSDA()),true);
					enviNFePDF.delete();
					logger.info("Terminou");
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
				logger.error("Problemas ao interromper a Thread ImprimirPDFFSDAThread", e);
			}
			finally
			{
				
			}
		}
	}
}