package br.com.hs.nfe.pe.zip;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.log4j.Logger;

public class DescompactaNFe {
	private static final Logger logger = Logger.getLogger("DescompactaNFe");
	private final int BUFFER = 2048;
	public void descompactaNFe(File enviNFeZip,String destino) throws IOException
	{
		BufferedOutputStream dest = null;
        FileInputStream fis = new FileInputStream(enviNFeZip);
        CheckedInputStream checksum = new CheckedInputStream(fis, new Adler32());
        ZipInputStream zis = new ZipInputStream(new BufferedInputStream(checksum));
        ZipEntry entry = null;
        while((entry = zis.getNextEntry()) != null) {
           logger.info("Extracting: " +entry);
           int count;
           byte data[] = new byte[BUFFER];
           // write the files to the disk
           File f = new File(destino+File.separatorChar+entry.getName());
           FileOutputStream fos = new FileOutputStream(f);
           dest = new BufferedOutputStream(fos,BUFFER);
           while ((count = zis.read(data, 0, BUFFER)) != -1) {
              dest.write(data, 0, count);
           }
           dest.flush();
           dest.close();
        }
        zis.close();
        logger.info("Checksum: "+checksum.getChecksum().getValue());
	}
}
