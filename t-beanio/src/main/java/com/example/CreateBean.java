package com.example;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.text.DecimalFormat;

import org.apache.commons.io.FileUtils;
import org.beanio.BeanWriter;
import org.beanio.StreamFactory;

import com.example.beanio.EmailInvoiceAttachmentModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CreateBean {
	
	public void writeFileBean() {
		// Get beanIO format
		// Read mapping file
		StreamFactory factory = StreamFactory.newInstance();

		try {
			factory.load(getClass().getClassLoader().getResourceAsStream("emailInvoiceAttachment.xml"));
		} catch (Exception e) {
			log.error(e.toString());
		}

		Writer writer = new StringWriter();
		BeanWriter beanIOWriteFile = factory.createWriter("InvoiceAttachment", writer);
		beanIOWriteFile.write("headers", null);

		EmailInvoiceAttachmentModel emailInvoiceAttachmentModel = new EmailInvoiceAttachmentModel();
		emailInvoiceAttachmentModel.setBuyerCode("2000058557");
		emailInvoiceAttachmentModel.setVendorCode("1150");
		emailInvoiceAttachmentModel.setFiDocNo("");
		emailInvoiceAttachmentModel.setBlockchainPaymentRef("");
		emailInvoiceAttachmentModel.setInvoiceAmount(null);
		emailInvoiceAttachmentModel.setVatAmount(null);
		DecimalFormat df = new DecimalFormat("#,##0.00");
		String whtAmount = df.format(new BigDecimal(0.00));
		
		emailInvoiceAttachmentModel.setWhtAmount(whtAmount);
		emailInvoiceAttachmentModel.setWhtFlag("N");
		emailInvoiceAttachmentModel.setBusinessPlace("0585");
		emailInvoiceAttachmentModel.setPaymentDate("");
		emailInvoiceAttachmentModel.setNetPaymentAmount(null);
		emailInvoiceAttachmentModel.setReason("Duplicate error");
		beanIOWriteFile.write(emailInvoiceAttachmentModel);
		
		beanIOWriteFile.flush();
		beanIOWriteFile.close();

		try {
			writer.close();
			FileUtils.writeStringToFile(new File("output/test.txt"), writer.toString(), Charset.forName("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}
}
