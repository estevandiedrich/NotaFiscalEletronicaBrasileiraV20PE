package br.com.hs.nfe.pe.file;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import br.com.hs.nfe.pe.conf.Config;

public class FileReceiverImpl implements FileReceiver{
	
	public FileReceiverImpl() throws RemoteException 
	{
		super();
	}
	private static final Logger logger = Logger.getLogger("FileReceiverImpl");
	private static final long serialVersionUID = -4822959616721838640L;
	private final int BUFFER = 2048;
	
	public synchronized Character enviarZip(byte[] data,String checksum) throws RemoteException
	{

		File file = null;
		FileOutputStream fos = null;
		try {
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
			CheckedInputStream checksumNew = new CheckedInputStream(byteArrayInputStream, new Adler32());
			String checksumNewString = "";
			Long value = 0L;
			byte[] readBuffer = new byte[BUFFER];
			while (checksumNew.read(readBuffer) >= 0)
			{
				value = checksumNew.getChecksum().getValue();
			}
			checksumNewString = Long.toString(value);
			logger.info("Checksum enviado pelo servidor: "+checksum +" Checksum gerado no ponto emissor: "+checksumNewString);
			if(checksum.equalsIgnoreCase(checksumNewString))
			{
				file = new File(Config.getInstance().configVO.getXmlCompactado()+File.separatorChar+File.createTempFile(checksum, ".zip").getName());
				fos = new FileOutputStream(file);
				IOUtils.write(data, fos);
				IOUtils.closeQuietly(fos);
				
				logger.info("Checksum iguais");
				return '1';
			}
			else
			{
				logger.info("Checksum diferentes");
				return '0';
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			return '2';
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			return '2';
		} 
	}
	public synchronized Character enviarZipFSDA(byte[] data,String checksum) throws RemoteException
	{
		
		File file = null;
		FileOutputStream fos = null;
		try {
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
			CheckedInputStream checksumNew = new CheckedInputStream(byteArrayInputStream, new Adler32());
			String checksumNewString = "";
			Long value = 0L;
			byte[] readBuffer = new byte[BUFFER];
			while (checksumNew.read(readBuffer) >= 0)
			{
				value = checksumNew.getChecksum().getValue();
			}
			checksumNewString = Long.toString(value);
			logger.info("Checksum enviado pelo servidor: "+checksum +" Checksum gerado no ponto emissor: "+checksumNewString);
			if(checksum.equalsIgnoreCase(checksumNewString))
			{
				file = new File(Config.getInstance().configVO.getXmlCompactadoFSDA()+File.separatorChar+File.createTempFile(checksum, ".zip").getName());
				fos = new FileOutputStream(file);
				IOUtils.write(data, fos);
				IOUtils.closeQuietly(fos);
				
				logger.info("Checksum iguais");
				return '1';
			}
			else
			{
				logger.info("Checksum diferentes");
				return '0';
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			return '2';
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error(e);
			return '2';
		} 
	}
}
