package br.com.hs.nfe.pe.pdf;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.io.IOUtils;

import br.com.hs.nfe.pdf.DanfeBuilder;
import br.com.hs.nfe.pe.conf.Config;

public class DanfeBuilderTester {
	public static void main(String[] args) throws Exception {
		// InputStream isLayout =
		// Thread.currentThread().getContextClassLoader().getResourceAsStream("danferetrato.jrxml");
		// JasperCompileManager.compileReportToStream(isLayout, new
		// FileOutputStream("C:/work/NF-e/nfe-danfe/nfe-danfe-PL005a/src/main/resources/danferetrato.jasper"));
		
		//		
		
		FileInputStream fis = new FileInputStream("C:\\filas\\enviNFe\\xmlProcessados\\NFe42110605537225000103550010000087441200612242-nfeProc.xml");
		// FileInputStream fis = new
		// FileInputStream("C:/work/NF-e/nfe-core/src/test/resources/NFe_PL005a_Template11.xml");
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		IOUtils.copy(fis, baos);
		byte[] ba = DanfeBuilder.montaDanfe(baos.toByteArray(), Thread.currentThread().getContextClassLoader().getResourceAsStream("laboratoriocat.gif"),DanfeBuilder.DANFE_055_RETRATO,Config.getInstance().configVO.getRazaoSocial());
		FileOutputStream fos = new FileOutputStream("c:/temp/t.pdf");
		fos.write(ba);
		fos.close();
		// System.out.println("");
		// String x = "a";
		// x = "000".substring(x.length()) + x;
		// System.out.println(x);
		// if (true)
		// return;
		// org.apache.xerces.dom.DeferredElementImpl a = null;
		// // a.getLength();
		// // a.getFirstChild()';'
		// org.w3c.dom.Node b = null;
		// // b.getNodeName()
		// String tag = "";
		//		
		// org.w3c.dom.NodeList nl = b.getChildNodes();
		// org.w3c.dom.Node ok = null;
		// for (int i = 0; i < nl.getLength(); i++) {
		// org.w3c.dom.Node node = nl.item(i);
		// if (tag.equals(node.getNodeName())) {
		// ok = node;
		// break;
		// }
		// }
		// Double.valueOf(null);
	}
}
