package br.com.hs.nfe.pe.pdf;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import br.com.hs.nfe.base.ThreadBase;
import br.com.hs.nfe.file.FileManager;
import br.com.hs.nfe.pdf.DanfeBuilder;
import br.com.hs.nfe.pe.conf.Config;
import br.com.hs.nfe.util.GeradorChaveAcesso;
import br.com.hs.nfe.xpath.XPathUtil;

public class DanfeFSDAThread extends ThreadBase{
	private static final Logger logger = Logger.getLogger("DanfeFSDAThread");
	private GeradorChaveAcesso geradorChaveAcesso = new GeradorChaveAcesso();
	public void run()
	{
		Thread.currentThread().setName( "DanfeFSDAThread" );
		logger.info("Iniciando thread DanfeFSDAThread");
		while ( super.isRunning() ) 
		{
			try
			{
				File[] enviNFeXMLArray = FileManager.getInstance().getXMLFiles(Config.getInstance().configVO.getEnviNFeXMLProcessadosFSDA());
				for(File enviNFeXML:enviNFeXMLArray)
				{
					FileInputStream fis = new FileInputStream(enviNFeXML);
					byte[] nfeProcByteArray = IOUtils.toByteArray(fis);
					String chaveAcesso = XPathUtil.solveXPath(new ByteArrayInputStream(nfeProcByteArray), "//:nfeProc/:NFe/:infNFe/@Id");
					if(chaveAcesso != null && !chaveAcesso.equalsIgnoreCase(""))
					{
						String formatoDanfe = Config.getInstance().configVO.getOrientacaoDanfe().equalsIgnoreCase("R")?DanfeBuilder.DANFE_055_RETRATO_FSDA:DanfeBuilder.DANFE_055_PAISAGEM;
						logger.info("Razão social: "+Config.getInstance().configVO.getRazaoSocial());
						String chaveDados = geradorChaveAcesso.construirChaveDados(new String(nfeProcByteArray));
						byte[] danfe = DanfeBuilder.montaDanfe(nfeProcByteArray, new FileInputStream(Config.getInstance().configVO.getLogoDanfe()),formatoDanfe,Config.getInstance().configVO.getRazaoSocial(),chaveDados);
						FileOutputStream fos = new FileOutputStream(Config.getInstance().configVO.getDanfeFSDA()+File.separatorChar+chaveAcesso+".pdf");
						fos.write(danfe);
						IOUtils.closeQuietly(fos);
						logger.info("Salvando arquivo : "+Config.getInstance().configVO.getDanfeFSDA()+File.separatorChar+chaveAcesso+".pdf");
					}
					else
					{
						logger.info("Falha ao gerar PDF Arquivo XML corrompido");
					}
					IOUtils.closeQuietly(fis);
					enviNFeXML.delete();
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
				logger.error("Problemas ao interromper a Thread DanfeFSDAThread", e);
			}
			finally
			{
				
			}
		}
	}
}
