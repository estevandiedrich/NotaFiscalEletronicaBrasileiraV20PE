package br.com.hs.nfe.pe.vo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("configVO")
public class ConfigVO {
	
	private String orientacaoDanfe = "";
	private String danfe = "";
	private String danfeFSDA = "";
	private String nroPaginas = "";
	private String nroPaginasFSDA = "";
	private String impressora = "";
	private String impressoraFSDA = "";
	private String logoDanfe = "";
	private String xmlCompactado = "";
	private String xmlCompactadoFSDA = "";
	private String enviNFeXMLProcessados = "";
	private String enviNFeXMLProcessadosFSDA = "";
	private String portaRMI = "";
	private String razaoSocial = "";
	
	public String getOrientacaoDanfe() {
		return orientacaoDanfe;
	}
	public void setOrientacaoDanfe(String orientacaoDanfe) {
		this.orientacaoDanfe = orientacaoDanfe;
	}
	public String getDanfe() {
		return danfe;
	}
	public void setDanfe(String danfe) {
		this.danfe = danfe;
	}
	
	public String getNroPaginas() {
		return nroPaginas;
	}
	public void setNroPaginas(String nroPaginas) {
		this.nroPaginas = nroPaginas;
	}
	public String getImpressora() {
		return impressora;
	}
	public void setImpressora(String impressora) {
		this.impressora = impressora;
	}
	public String getLogoDanfe() {
		return logoDanfe;
	}
	public void setLogoDanfe(String logoDanfe) {
		this.logoDanfe = logoDanfe;
	}
	public String getXmlCompactado() {
		return xmlCompactado;
	}
	public void setXmlCompactado(String xmlCompactado) {
		this.xmlCompactado = xmlCompactado;
	}
	public String getEnviNFeXMLProcessados() {
		return enviNFeXMLProcessados;
	}
	public void setEnviNFeXMLProcessados(String enviNFeXMLProcessados) {
		this.enviNFeXMLProcessados = enviNFeXMLProcessados;
	}
	public String getPortaRMI() {
		return portaRMI;
	}
	public void setPortaRMI(String portaRMI) {
		this.portaRMI = portaRMI;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getDanfeFSDA() {
		return danfeFSDA;
	}
	public void setDanfeFSDA(String danfeFSDA) {
		this.danfeFSDA = danfeFSDA;
	}
	public String getNroPaginasFSDA() {
		return nroPaginasFSDA;
	}
	public void setNroPaginasFSDA(String nroPaginasFSDA) {
		this.nroPaginasFSDA = nroPaginasFSDA;
	}
	public String getImpressoraFSDA() {
		return impressoraFSDA;
	}
	public void setImpressoraFSDA(String impressoraFSDA) {
		this.impressoraFSDA = impressoraFSDA;
	}
	public String getXmlCompactadoFSDA() {
		return xmlCompactadoFSDA;
	}
	public void setXmlCompactadoFSDA(String xmlCompactadoFSDA) {
		this.xmlCompactadoFSDA = xmlCompactadoFSDA;
	}
	public String getEnviNFeXMLProcessadosFSDA() {
		return enviNFeXMLProcessadosFSDA;
	}
	public void setEnviNFeXMLProcessadosFSDA(String enviNFeXMLProcessadosFSDA) {
		this.enviNFeXMLProcessadosFSDA = enviNFeXMLProcessadosFSDA;
	}
}
