/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

/**
 *
 * @author LENOVO
 */

import javax.mail.Authenticator;

import javax.mail.internet.AddressException;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author LENOVO
 */
public class Mail {
    public static void send(String recepient,String code) throws MessagingException 
    {
        System.out.println("Preparing Send email");
        Properties props = new Properties();

        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");	
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        String myAccountEmail ="efoodappproject@gmail.com";
        String password ="EfoodAppPiDEV";
        Session session = Session.getDefaultInstance(props,new Authenticator() 
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() 
            {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
            Message message = prepareMessageCode(session,myAccountEmail,recepient,code);
            Transport.send(message);
            System.out.println("message sent");
    }

    private static Message prepareMessageCode(Session session,String myAccountEmail,String recepient,String code) throws AddressException, MessagingException {
       
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Discount");
            String htmlCode="<!DOCTYPE html>\n" +
"<html xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" lang=\"en\">\n" +
"\n" +
"<head>\n" +
"	<title></title>\n" +
"	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
"	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"	<!--[if mso]><xml><o:OfficeDocumentSettings><o:PixelsPerInch>96</o:PixelsPerInch><o:AllowPNG/></o:OfficeDocumentSettings></xml><![endif]-->\n" +
"	<!--[if !mso]><!-->\n" +
"	<link href=\"https://fonts.googleapis.com/css?family=Montserrat\" rel=\"stylesheet\" type=\"text/css\">\n" +
"	<!--<![endif]-->\n" +
"	<style>\n" +
"		* {\n" +
"			box-sizing: border-box;\n" +
"		}\n" +
"\n" +
"		body {\n" +
"			margin: 0;\n" +
"			padding: 0;\n" +
"		}\n" +
"\n" +
"		a[x-apple-data-detectors] {\n" +
"			color: inherit !important;\n" +
"			text-decoration: inherit !important;\n" +
"		}\n" +
"\n" +
"		#MessageViewBody a {\n" +
"			color: inherit;\n" +
"			text-decoration: none;\n" +
"		}\n" +
"\n" +
"		p {\n" +
"			line-height: inherit\n" +
"		}\n" +
"\n" +
"		@media (max-width:660px) {\n" +
"			.icons-inner {\n" +
"				text-align: center;\n" +
"			}\n" +
"\n" +
"			.icons-inner td {\n" +
"				margin: 0 auto;\n" +
"			}\n" +
"\n" +
"			.row-content {\n" +
"				width: 100% !important;\n" +
"			}\n" +
"\n" +
"			.column .border {\n" +
"				display: none;\n" +
"			}\n" +
"\n" +
"			.stack .column {\n" +
"				width: 100%;\n" +
"				display: block;\n" +
"			}\n" +
"		}\n" +
"	</style>\n" +
"</head>\n" +
"\n" +
"<body style=\"background-color: #ebebeb; margin: 0; padding: 0; -webkit-text-size-adjust: none; text-size-adjust: none;\">\n" +
"	<table class=\"nl-container\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ebebeb;\">\n" +
"		<tbody>\n" +
"			<tr>\n" +
"				<td>\n" +
"					<table class=\"row row-1\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"						<tbody>\n" +
"							<tr>\n" +
"								<td>\n" +
"									<table class=\"row-content stack\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 640px;\" width=\"640\">\n" +
"										<tbody>\n" +
"											<tr>\n" +
"												<td class=\"column column-1\" width=\"100%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 5px; padding-bottom: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"													<table class=\"text_block\" width=\"100%\" border=\"0\" cellpadding=\"10\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n" +
"														<tr>\n" +
"															<td>\n" +
"																<div style=\"font-family: sans-serif\">\n" +
"																	<div style=\"font-size: 12px; mso-line-height-alt: 14.399999999999999px; color: #393d47; line-height: 1.2; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;\">\n" +
"																		<p style=\"margin: 0; font-size: 14px;\">You don't want to miss this...</p>\n" +
"																	</div>\n" +
"																</div>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"												</td>\n" +
"											</tr>\n" +
"										</tbody>\n" +
"									</table>\n" +
"								</td>\n" +
"							</tr>\n" +
"						</tbody>\n" +
"					</table>\n" +
"					<table class=\"row row-2\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"						<tbody>\n" +
"							<tr>\n" +
"								<td>\n" +
"									<table class=\"row-content stack\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffffff; color: #000000; background-image: url('https://d1oco4z2z1fhwp.cloudfront.net/templates/default/3451/bg.jpg'); background-repeat: no-repeat; width: 640px;\" width=\"640\">\n" +
"										<tbody>\n" +
"											<tr>\n" +
"												<td class=\"column column-1\" width=\"100%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 5px; padding-bottom: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"													<table class=\"heading_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"														<tr>\n" +
"															<td style=\"padding-bottom:5px;padding-left:20px;padding-right:20px;padding-top:30px;text-align:center;width:100%;\">\n" +
"																<h1 style=\"margin: 0; color: #ffffff; direction: ltr; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; font-size: 31px; font-weight: normal; letter-spacing: normal; line-height: 150%; text-align: right; margin-top: 0; margin-bottom: 0;\"><span style=\"background-color: #008661;\"><strong></strong></span></h1>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"													<table class=\"heading_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"														<tr>\n" +
"															<td style=\"padding-left:20px;padding-right:20px;text-align:center;width:100%;\">\n" +
"																<h1 style=\"margin: 0; color: #156965; direction: ltr; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; font-size: 55px; font-weight: normal; letter-spacing: normal; line-height: 120%; text-align: right; margin-top: 0; margin-bottom: 0;\"><strong>FREE</strong></h1>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"													<table class=\"heading_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"														<tr>\n" +
"															<td style=\"padding-left:20px;padding-right:20px;text-align:center;width:100%;\">\n" +
"																<h1 style=\"margin: 0; color: #156965; direction: ltr; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; font-size: 55px; font-weight: normal; letter-spacing: normal; line-height: 120%; text-align: right; margin-top: 0; margin-bottom: 0;\"><strong>DELIVERY</strong></h1>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"													<table class=\"heading_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"														<tr>\n" +
"															<td style=\"padding-left:20px;padding-right:20px;text-align:center;width:100%;\">\n" +
"																<h1 style=\"margin: 0; color: #156965; direction: ltr; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; font-size: 55px; font-weight: normal; letter-spacing: normal; line-height: 120%; text-align: right; margin-top: 0; margin-bottom: 0;\"><strong>ON ALL</strong></h1>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"													<table class=\"heading_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"														<tr>\n" +
"															<td style=\"padding-left:20px;padding-right:20px;text-align:center;width:100%;\">\n" +
"																<h1 style=\"margin: 0; color: #156965; direction: ltr; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; font-size: 55px; font-weight: normal; letter-spacing: normal; line-height: 120%; text-align: right; margin-top: 0; margin-bottom: 0;\"><strong>ORDERS</strong></h1>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"													<table class=\"divider_block\" width=\"100%\" border=\"0\" cellpadding=\"10\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"														<tr>\n" +
"															<td>\n" +
"																<div align=\"center\">\n" +
"																	<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"100%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"																		<tr>\n" +
"																			<td class=\"divider_inner\" style=\"font-size: 1px; line-height: 1px; border-top: 1px solid #BBBBBB;\"><span>&#8202;</span></td>\n" +
"																		</tr>\n" +
"																	</table>\n" +
"																</div>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"													<table class=\"html_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"														<tr>\n" +
"															<td style=\"padding-bottom:205px;\">\n" +
"																<div style=\"font-family:Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;text-align:center;\" align=\"center\"><div class=\"our-class\"> Your coupon code \n" + 
                   
                 
" <p>"+ code +"</p>" +
"</div>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"												</td>\n" +
"											</tr>\n" +
"										</tbody>\n" +
"									</table>\n" +
"								</td>\n" +
"							</tr>\n" +
"						</tbody>\n" +
"					</table>\n" +
"					<table class=\"row row-3\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"						<tbody>\n" +
"							<tr>\n" +
"								<td>\n" +
"									<table class=\"row-content stack\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffffff; color: #000000; width: 640px;\" width=\"640\">\n" +
"										<tbody>\n" +
"											<tr>\n" +
"												<td class=\"column column-1\" width=\"100%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 30px; padding-bottom: 30px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"													<table class=\"heading_block\" width=\"100%\" border=\"0\" cellpadding=\"5\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"														<tr>\n" +
"															<td>\n" +
"																<h1 style=\"margin: 0; color: #008661; direction: ltr; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; font-size: 29px; font-weight: normal; letter-spacing: normal; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0;\"><strong>Delicious. Fresh. Organic.</strong></h1>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"													<table class=\"text_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n" +
"														<tr>\n" +
"															<td style=\"padding-bottom:10px;padding-left:30px;padding-right:30px;padding-top:10px;\">\n" +
"																<div style=\"font-family: sans-serif\">\n" +
"																	<div style=\"font-size: 12px; mso-line-height-alt: 18px; color: #555555; line-height: 1.5; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;\">\n" +
"																		<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 24px;\"><span style=\"font-size:16px;\">With food made fresh, from the highest quality, all organic ingredients, celebrating this holiday doesn't have to be a compromise. Food that tastes great and makes you feel great.</span></p>\n" +
"																	</div>\n" +
"																</div>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"													<table class=\"divider_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"														<tr>\n" +
"															<td style=\"padding-bottom:10px;padding-left:10px;padding-right:10px;padding-top:40px;\">\n" +
"																<div align=\"center\">\n" +
"																	<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" width=\"90%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"																		<tr>\n" +
"																			<td class=\"divider_inner\" style=\"font-size: 1px; line-height: 1px; border-top: 1px solid #B2D2C7;\"><span>&#8202;</span></td>\n" +
"																		</tr>\n" +
"																	</table>\n" +
"																</div>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"												</td>\n" +
"											</tr>\n" +
"										</tbody>\n" +
"									</table>\n" +
"								</td>\n" +
"							</tr>\n" +
"						</tbody>\n" +
"					</table>\n" +
"					<table class=\"row row-4\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"						<tbody>\n" +
"							<tr>\n" +
"								<td>\n" +
"									<table class=\"row-content stack\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #156965; color: #000000; width: 640px;\" width=\"640\">\n" +
"										<tbody>\n" +
"											<tr>\n" +
"												<td class=\"column column-1\" width=\"100%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 30px; padding-bottom: 30px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"													<table class=\"heading_block\" width=\"100%\" border=\"0\" cellpadding=\"5\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"														<tr>\n" +
"															<td>\n" +
"																<h1 style=\"margin: 0; color: #ffffff; direction: ltr; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; font-size: 29px; font-weight: normal; letter-spacing: normal; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0;\"><strong>Great Food Delivered.</strong><br></h1>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"													<table class=\"text_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n" +
"														<tr>\n" +
"															<td style=\"padding-bottom:10px;padding-left:30px;padding-right:30px;padding-top:10px;\">\n" +
"																<div style=\"font-family: sans-serif\">\n" +
"																	<div style=\"font-size: 12px; mso-line-height-alt: 18px; color: #ffffff; line-height: 1.5; font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif;\">\n" +
"																		<p style=\"margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 24px;\"><span style=\"font-size:16px;\">Our Restaurant is ready to serve you with fast, safe, contactless delivery.&nbsp;</span></p>\n" +
"																	</div>\n" +
"																</div>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"												</td>\n" +
"											</tr>\n" +
"										</tbody>\n" +
"									</table>\n" +
"								</td>\n" +
"							</tr>\n" +
"						</tbody>\n" +
"					</table>\n" +
"					<table class=\"row row-5\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"						<tbody>\n" +
"							<tr>\n" +
"								<td>\n" +
"									<table class=\"row-content\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #008661; color: #000000; width: 640px;\" width=\"640\">\n" +
"										<tbody>\n" +
"											<tr>\n" +
"												<td class=\"column column-1\" width=\"25%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-left: 5px; padding-right: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"													<table class=\"icons_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"														<tr>\n" +
"															<td style=\"vertical-align: middle; color: #ffffff; font-family: inherit; font-size: 13px; letter-spacing: 0px; text-align: center; padding-top: 25px; padding-bottom: 25px;\">\n" +
"																<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"																	<tr>\n" +
"																		<td style=\"vertical-align: middle; text-align: center;\">\n" +
"																			<!--[if vml]><table align=\"left\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"display:inline-block;padding-left:0px;padding-right:0px;mso-table-lspace: 0pt;mso-table-rspace: 0pt;\"><![endif]-->\n" +
"																			<!--[if !vml]><!-->\n" +
"																			<table class=\"icons-inner\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; display: inline-block; margin-right: -4px; padding-left: 0px; padding-right: 0px;\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\">\n" +
"																				<!--<![endif]-->\n" +
"																				<tr>\n" +
"																					<td style=\"vertical-align: middle; text-align: center; padding-top: 10px; padding-bottom: 10px; padding-left: 10px; padding-right: 10px;\"><a href=\"https://www.example.com\" target=\"_self\" style=\"text-decoration: none;\"><img class=\"icon\" alt=\"Truck Icon\" src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/3451/Frame_42.png\" height=\"32\" width=\"32\" align=\"center\" style=\"display: block; height: auto; margin: 0 auto; border: 0;\"></a></td>\n" +
"																				</tr>\n" +
"																				<tr>\n" +
"																					<td style=\"font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; font-size: 13px; color: #ffffff; vertical-align: middle; letter-spacing: normal; text-align: center;\"><a href=\"https://www.example.com\" target=\"_self\" style=\"color: #ffffff; text-decoration: none;\">Order</a></td>\n" +
"																				</tr>\n" +
"																			</table>\n" +
"																		</td>\n" +
"																	</tr>\n" +
"																</table>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"												</td>\n" +
"												<td class=\"column column-2\" width=\"25%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-left: 5px; padding-right: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"													<table class=\"icons_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"														<tr>\n" +
"															<td style=\"vertical-align: middle; color: #ffffff; font-family: inherit; font-size: 13px; letter-spacing: 0px; text-align: center; padding-top: 25px; padding-bottom: 25px;\">\n" +
"																<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"																	<tr>\n" +
"																		<td style=\"vertical-align: middle; text-align: center;\">\n" +
"																			<!--[if vml]><table align=\"left\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"display:inline-block;padding-left:0px;padding-right:0px;mso-table-lspace: 0pt;mso-table-rspace: 0pt;\"><![endif]-->\n" +
"																			<!--[if !vml]><!-->\n" +
"																			<table class=\"icons-inner\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; display: inline-block; margin-right: -4px; padding-left: 0px; padding-right: 0px;\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\">\n" +
"																				<!--<![endif]-->\n" +
"																				<tr>\n" +
"																					<td style=\"vertical-align: middle; text-align: center; padding-top: 10px; padding-bottom: 10px; padding-left: 10px; padding-right: 10px;\"><a href=\"https://www.example.com\" target=\"_self\" style=\"text-decoration: none;\"><img class=\"icon\" alt=\"Pizza Icon\" src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/3451/Frame_41.png\" height=\"32\" width=\"32\" align=\"center\" style=\"display: block; height: auto; margin: 0 auto; border: 0;\"></a></td>\n" +
"																				</tr>\n" +
"																				<tr>\n" +
"																					<td style=\"font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; font-size: 13px; color: #ffffff; vertical-align: middle; letter-spacing: normal; text-align: center;\"><a href=\"https://www.example.com\" target=\"_self\" style=\"color: #ffffff; text-decoration: none;\">Menu</a></td>\n" +
"																				</tr>\n" +
"																			</table>\n" +
"																		</td>\n" +
"																	</tr>\n" +
"																</table>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"												</td>\n" +
"												<td class=\"column column-3\" width=\"25%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-left: 5px; padding-right: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"													<table class=\"icons_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"														<tr>\n" +
"															<td style=\"vertical-align: middle; color: #ffffff; font-family: inherit; font-size: 13px; letter-spacing: 0px; text-align: center; padding-top: 25px; padding-bottom: 25px;\">\n" +
"																<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"																	<tr>\n" +
"																		<td style=\"vertical-align: middle; text-align: center;\">\n" +
"																			<!--[if vml]><table align=\"left\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"display:inline-block;padding-left:0px;padding-right:0px;mso-table-lspace: 0pt;mso-table-rspace: 0pt;\"><![endif]-->\n" +
"																			<!--[if !vml]><!-->\n" +
"																			<table class=\"icons-inner\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; display: inline-block; margin-right: -4px; padding-left: 0px; padding-right: 0px;\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\">\n" +
"																				<!--<![endif]-->\n" +
"																				<tr>\n" +
"																					<td style=\"vertical-align: middle; text-align: center; padding-top: 10px; padding-bottom: 10px; padding-left: 10px; padding-right: 10px;\"><a href=\"https://www.example.com\" target=\"_self\" style=\"text-decoration: none;\"><img class=\"icon\" alt=\"Map Pin\" src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/3451/Frame_40.png\" height=\"32\" width=\"32\" align=\"center\" style=\"display: block; height: auto; margin: 0 auto; border: 0;\"></a></td>\n" +
"																				</tr>\n" +
"																				<tr>\n" +
"																					<td style=\"font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; font-size: 13px; color: #ffffff; vertical-align: middle; letter-spacing: normal; text-align: center;\"><a href=\"https://www.example.com\" target=\"_self\" style=\"color: #ffffff; text-decoration: none;\">Map</a></td>\n" +
"																				</tr>\n" +
"																			</table>\n" +
"																		</td>\n" +
"																	</tr>\n" +
"																</table>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"												</td>\n" +
"												<td class=\"column column-4\" width=\"25%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-left: 5px; padding-right: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"													<table class=\"icons_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"														<tr>\n" +
"															<td style=\"vertical-align: middle; color: #ffffff; font-family: inherit; font-size: 13px; letter-spacing: 0px; text-align: center; padding-top: 25px; padding-bottom: 25px;\">\n" +
"																<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"																	<tr>\n" +
"																		<td style=\"vertical-align: middle; text-align: center;\">\n" +
"																			<!--[if vml]><table align=\"left\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"display:inline-block;padding-left:0px;padding-right:0px;mso-table-lspace: 0pt;mso-table-rspace: 0pt;\"><![endif]-->\n" +
"																			<!--[if !vml]><!-->\n" +
"																			<table class=\"icons-inner\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; display: inline-block; margin-right: -4px; padding-left: 0px; padding-right: 0px;\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\">\n" +
"																				<!--<![endif]-->\n" +
"																				<tr>\n" +
"																					<td style=\"vertical-align: middle; text-align: center; padding-top: 10px; padding-bottom: 10px; padding-left: 10px; padding-right: 10px;\"><a href=\"https://www.example.com\" target=\"_self\" style=\"text-decoration: none;\"><img class=\"icon\" alt=\"Default\" src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/3451/Frame_39.png\" height=\"32\" width=\"32\" align=\"center\" style=\"display: block; height: auto; margin: 0 auto; border: 0;\"></a></td>\n" +
"																				</tr>\n" +
"																				<tr>\n" +
"																					<td style=\"font-family: Montserrat, Trebuchet MS, Lucida Grande, Lucida Sans Unicode, Lucida Sans, Tahoma, sans-serif; font-size: 13px; color: #ffffff; vertical-align: middle; letter-spacing: normal; text-align: center;\"><a href=\"https://www.example.com\" target=\"_self\" style=\"color: #ffffff; text-decoration: none;\">Rewards</a></td>\n" +
"																				</tr>\n" +
"																			</table>\n" +
"																		</td>\n" +
"																	</tr>\n" +
"																</table>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"												</td>\n" +
"											</tr>\n" +
"										</tbody>\n" +
"									</table>\n" +
"								</td>\n" +
"							</tr>\n" +
"						</tbody>\n" +
"					</table>\n" +
"				</td>\n" +
"			</tr>\n" +
"		</tbody>\n" +
"	</table><!-- End -->\n" +
"</body>\n" +
"\n" +
"</html>";
            message.setContent(htmlCode,"text/html");
            return message;
    }
 
}
