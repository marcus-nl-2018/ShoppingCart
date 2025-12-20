package com.shopping.utility;

import com.shopping.exception.MailSendException;
import jakarta.mail.MessagingException;

public class MailMessage {

	/* -------------------- Public APIs -------------------- */

	public static void registrationSuccess(String emailId, String name) {
		String subject = "Registration Successful";
		String message = buildRegistrationMessage(name);
		send(emailId, subject, message);
	}

	public static void transactionSuccess(String email, String name, String transId, double amount) {
		String subject = "Order Placed at Ellison Electronics";
		String message = buildTransactionMessage(name, transId, amount, "placed");
		send(email, subject, message);
	}

	public static void orderShipped(String email, String name, String transId, double amount) {
		String subject = "Hurray!! Your Order has been Shipped";
		String message = buildTransactionMessage(name, transId, amount, "shipped");
		send(email, subject, message);
	}

	public static void productAvailableNow(String email, String name, String prodName, String prodId) {
		String subject = "Product " + prodName + " is Now Available";
		String message = buildProductAvailableMessage(name, prodName, prodId);
		send(email, subject, message);
	}

	public static String sendMessage(String email, String subject, String htmlTextMessage) {
		try {
			send(email, subject, htmlTextMessage);
			return "SUCCESS";
		} catch (MailSendException ex) {
			return "FAILURE";
		}
	}

	/* -------------------- Core Mail Sender -------------------- */

	private static void send(String recipient, String subject, String htmlMessage) {
		try {
			JavaMailUtil.sendMail(recipient, subject, htmlMessage);
		} catch (MessagingException e) {
			throw new MailSendException(
					"Failed to send email to " + recipient + " with subject: " + subject,
					e
			);
		}
	}

	/* -------------------- HTML Builders -------------------- */

	private static String buildRegistrationMessage(String name) {
		return String.format(
				"<html>" +
						"<body>" +
						"<h2 style='color:green;'>Welcome to Ellison Electronics</h2>" +
						"Hi %s,<br/><br/>" +
						"Thanks for signing up with Ellison Electronics.<br/>" +
						"Enjoy up to <b>60%% OFF</b> on top gadgets.<br/><br/>" +
						"<b>PROMO CODE:</b> ELLISON500<br/><br/>" +
						"Have a great day!<br/>" +
						"</body>" +
						"</html>",
				name
		);
	}
	private static String buildTransactionMessage(String name, String transId, double amount, String status) {
		return String.format(
				"<html>" +
						"<body>" +
						"Hey %s,<br/><br/>" +
						"Your order has been %s successfully.<br/><br/>" +
						"<b>Order Id:</b> %s<br/>" +
						"<b>Amount Paid:</b> %.2f<br/><br/>" +
						"Thank you for shopping with us!<br/>" +
						"<b>Ellison Electronics</b>" +
						"</body>" +
						"</html>",
				name, status, transId, amount
		);
	}
	private static String buildProductAvailableMessage(String name, String prodName, String prodId) {
		return String.format(
				"<html>" +
						"<body>" +
						"Hey %s,<br/><br/>" +
						"Good news! The product <b>%s</b> (ID: %s) is now available.<br/><br/>" +
						"Come shop again!<br/>" +
						"<b>Ellison Electronics</b>" +
						"</body>" +
						"</html>",
				name, prodName, prodId
		);
	}
}
