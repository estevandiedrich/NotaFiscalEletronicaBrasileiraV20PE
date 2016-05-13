package br.com.hs.nfe.pe.conf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import br.com.hs.nfe.pe.vo.ConfigVO;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("config")
public class Config {
	@XStreamOmitField
	private static Config me = null;
	@XStreamOmitField
	private static XStream xStream = null;
	@XStreamOmitField
	private static final Logger logger = Logger.getLogger("Config");
	@XStreamOmitField
	private static File configFile = null;
	@XStreamOmitField
	private static FileInputStream fileInputStream = null;
	@XStreamOmitField
	private static FileOutputStream fileOutputStream = null;
	
	static
	{
		xStream = new XStream();
		xStream.processAnnotations(Config.class);
		String configFilePath = System.getProperty("nfe.config.xml", "../conf/config.xml");
		configFile = new File(configFilePath);
		try
		{
			if(!configFile.exists())
			{
				configFile.createNewFile();
			}
		}
		catch (IOException e) 
		{
			logger.error(e);
		}
	}
	public String getConfigFilePath()
	{
		return configFile.getAbsolutePath();
	}
	
	public Boolean save()
	{
		String xml = xStream.toXML(me);
		try
		{
			logger.info("Salvando configuração");
			fileOutputStream = new FileOutputStream(configFile);
			fileOutputStream.write(xml.getBytes());
			IOUtils.closeQuietly(fileOutputStream);
		}
		catch(FileNotFoundException fileNotFoundException)
		{
			logger.error(fileNotFoundException);
			return Boolean.FALSE;
		}
		catch (IOException e) 
		{
			logger.error(e);
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}
	public static void load(String configFilePath)
	{
		byte[] b = null;
		configFile = new File(configFilePath);
		try
		{
			if(!configFile.exists())
			{
				configFile.createNewFile();
			}
			logger.info("Carregando configuração");
			fileInputStream = new FileInputStream(configFile);
			b = IOUtils.toByteArray(fileInputStream);
			IOUtils.closeQuietly(fileInputStream);
			me = (Config)xStream.fromXML(new String(b));
		}
		catch(FileNotFoundException exception)
		{
			logger.error(exception);
		}
		catch (IOException e) 
		{
			logger.error(e);
		}
	}
	private static Config load()
	{
		byte[] b = null;
		try
		{
			logger.info("Carregando configuração");
			fileInputStream = new FileInputStream(configFile);
			b = IOUtils.toByteArray(fileInputStream);
			IOUtils.closeQuietly(fileInputStream);
		}
		catch(FileNotFoundException exception)
		{
			logger.error(exception);
		}
		catch (IOException e) 
		{
			logger.error(e);
		}
		return (Config)xStream.fromXML(new String(b));
	}
	public synchronized static Config getInstance()
	{
		if(me == null)
		{
			me = load();
			//me = new Config();
		}
		return me;
	}
	public String enviNFeThreadSleep = "";
	public synchronized String getEnviNFeThreadSleep() {
		return enviNFeThreadSleep;
	}
	public synchronized void setEnviNFeThreadSleep(String enviNFeThreadSleep) {
		this.enviNFeThreadSleep = enviNFeThreadSleep;
	}
	public ConfigVO configVO = new ConfigVO();
}
