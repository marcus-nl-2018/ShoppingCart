package com.shopping.utility;

import jakarta.mail.MessagingException;

public class TestMail {

	private static final String RECIPIENT = "ellison.alumni@gmail.com";
	private static final String SUBJECT = "Mail Configuration Successful";

	public static void main(String[] args) {
		try {
			String message = buildTestMailMessage();
			JavaMailUtil.sendMail(RECIPIENT, SUBJECT, message);
			System.out.println("Mail sent successfully!");

		} catch (MessagingException ex) {
			System.err.println("Failed to send mail: " + ex.getMessage());
			// In real applications, log this using a logger instead
		}
	}

	private static String buildTestMailMessage() {
		return "<html>" +
				"<head>" +
				"<title>Java Mail Configuration Test</title>" +
				"<style>" +
				".greenText { color: green; font-weight: bold; }" +
				"p { font-size: 14px; }" +
				"</style>" +
				"</head>" +
				"<body>" +
				"<h2 style='color:red;'>Welcome to Ellison Electronics</h2>" +
				"<p>" +
				"Hey,<br/><br/>" +
				"Thanks for signing up with Ellison Electronics.<br/>" +
				"We are glad that you chose us. Check out our latest electronics appliances.<br/><br/>" +
				"Enjoy up to <b>60% OFF</b> on most electronic gadgets.<br/><br/>" +
				"As a welcome gift, get an additional <b>10% OFF up to ₹500</b> on your first purchase.<br/><br/>" +
				"Use promo code: <span class='greenText'>ELLISON500</span><br/><br/>" +
				"Have a great day!<br/>" +
				"</p>" +
				"</body>" +
				"</html>";
	}
}
