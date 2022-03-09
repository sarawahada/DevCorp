/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

/**
 *
 * @author sarawahada
 */

import java.util.Properties;

import javax.mail.Session;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;


public class SendingMail 
{
    

    public static void send(String recepient,int mot) throws MessagingException 
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
            Message message = prepareMessage(session,myAccountEmail,recepient,mot);
            Transport.send(message);
            System.out.println("message sent");
    }

    private static Message prepareMessage(Session session,String myAccountEmail,String recepient,int mot) throws AddressException, MessagingException {
       
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("password reset");
            String htmlCode="<!DOCTYPE html>\n" +
"<html>\n" +
" <head>\n" +
"  <title>\n" +
"  </title>\n" +
"  <meta content=\"summary_large_image\" name=\"twitter:card\">\n" +
"  <meta content=\"website\" property=\"og:type\">\n" +
"  <meta content=\"\" property=\"og:description\">\n" +
"  <meta content=\"https://82y9j95ifn.preview-posted-stuff.com/V2-naiS-FPnm-d6mX-kcQZ/\" property=\"og:url\">\n" +
"  <meta content=\"https://pro-bee-beepro-thumbnails.s3.amazonaws.com/messages/768578/752136/1496341/7283525_large.jpg\" property=\"og:image\">\n" +
"  <meta content=\"\" property=\"og:title\">\n" +
"  <meta content=\"\" name=\"description\">\n" +
"  <meta charset=\"utf-8\">\n" +
"  <meta content=\"width=device-width\" name=\"viewport\">\n" +
"  <link href=\"https://fonts.googleapis.com/css?family=Bitter\" rel=\"stylesheet\" type=\"text/css\">\n" +
"  <link href=\"https://fonts.googleapis.com/css?family=Cormorant+Garamond\" rel=\"stylesheet\" type=\"text/css\">\n" +
"  <link href=\"https://fonts.googleapis.com/css?family=Cabin\" rel=\"stylesheet\" type=\"text/css\">\n" +
"  <link href=\"https://fonts.googleapis.com/css?family=Droid+Serif\" rel=\"stylesheet\" type=\"text/css\">\n" +
"  <link href=\"https://fonts.googleapis.com/css?family=Montserrat\" rel=\"stylesheet\" type=\"text/css\">\n" +
"  <link href=\"https://fonts.googleapis.com/css?family=Roboto+Slab\" rel=\"stylesheet\" type=\"text/css\">\n" +
"  <style>\n" +
"   .bee-row,\n" +
"		.bee-row-content {\n" +
"			position: relative\n" +
"		}\n" +
"\n" +
"		.bee-row-1,\n" +
"		.bee-row-2,\n" +
"		.bee-row-3 {\n" +
"			background-repeat: no-repeat\n" +
"		}\n" +
"\n" +
"		body {\n" +
"			background-color: #85a4cd;\n" +
"			color: #000;\n" +
"			font-family: Roboto Slab, Arial, Helvetica Neue, Helvetica, sans-serif\n" +
"		}\n" +
"\n" +
"		a {\n" +
"			color: #0068a5\n" +
"		}\n" +
"\n" +
"		* {\n" +
"			box-sizing: border-box\n" +
"		}\n" +
"\n" +
"		body,\n" +
"		h1,\n" +
"		p {\n" +
"			margin: 0\n" +
"		}\n" +
"\n" +
"		.bee-row-content {\n" +
"			max-width: 650px;\n" +
"			margin: 0 auto;\n" +
"			display: flex\n" +
"		}\n" +
"\n" +
"		.bee-row-content .bee-col-w12 {\n" +
"			flex-basis: 100%\n" +
"		}\n" +
"\n" +
"		.bee-html-block {\n" +
"			text-align: center\n" +
"		}\n" +
"\n" +
"		.bee-divider,\n" +
"		.bee-image {\n" +
"			overflow: auto\n" +
"		}\n" +
"\n" +
"		.bee-divider .center,\n" +
"		.bee-image .bee-center {\n" +
"			margin: 0 auto\n" +
"		}\n" +
"\n" +
"		.bee-row-1 .bee-col-1 .bee-block-3 {\n" +
"			width: 100%\n" +
"		}\n" +
"\n" +
"		.bee-image img {\n" +
"			display: block;\n" +
"			width: 100%\n" +
"		}\n" +
"\n" +
"		.bee-social .icon img {\n" +
"			max-height: 32px\n" +
"		}\n" +
"\n" +
"		.bee-text {\n" +
"			overflow-wrap: anywhere\n" +
"		}\n" +
"\n" +
"		@media (max-width:670px) {\n" +
"			.bee-row-content:not(.no_stack) {\n" +
"				display: block\n" +
"			}\n" +
"		}\n" +
"\n" +
"		.bee-row-1 .bee-row-content,\n" +
"		.bee-row-2 .bee-row-content,\n" +
"		.bee-row-3 .bee-row-content {\n" +
"			background-repeat: no-repeat;\n" +
"			color: #000\n" +
"		}\n" +
"\n" +
"		.bee-row-1 .bee-col-1 {\n" +
"			padding-bottom: 5px;\n" +
"			padding-top: 5px\n" +
"		}\n" +
"\n" +
"		.bee-row-1 .bee-col-1 .bee-block-1 {\n" +
"			padding: 30px\n" +
"		}\n" +
"\n" +
"		.bee-row-1 .bee-col-1 .bee-block-2 {\n" +
"			padding-bottom: 10px;\n" +
"			text-align: center;\n" +
"			width: 100%\n" +
"		}\n" +
"\n" +
"		.bee-row-1 .bee-col-1 .bee-block-10,\n" +
"		.bee-row-1 .bee-col-1 .bee-block-4,\n" +
"		.bee-row-1 .bee-col-1 .bee-block-7,\n" +
"		.bee-row-1 .bee-col-1 .bee-block-9,\n" +
"		.bee-row-2 .bee-col-1 .bee-block-1,\n" +
"		.bee-row-3 .bee-col-1 .bee-block-3 {\n" +
"			padding: 10px\n" +
"		}\n" +
"\n" +
"		.bee-row-1 .bee-col-1 .bee-block-5,\n" +
"		.bee-row-1 .bee-col-1 .bee-block-6 {\n" +
"			padding: 5px 10px\n" +
"		}\n" +
"\n" +
"		.bee-row-1 .bee-col-1 .bee-block-11,\n" +
"		.bee-row-3 .bee-col-1 .bee-block-1 {\n" +
"			padding: 15px\n" +
"		}\n" +
"\n" +
"		.bee-row-2 {\n" +
"			background-color: #c4d6ec\n" +
"		}\n" +
"\n" +
"		.bee-row-2 .bee-col-1 {\n" +
"			padding-bottom: 20px;\n" +
"			padding-top: 20px\n" +
"		}\n" +
"\n" +
"		.bee-row-3 {\n" +
"			background-color: #f3f6fe\n" +
"		}\n" +
"\n" +
"		.bee-row-3 .bee-col-1 .bee-block-2 {\n" +
"			padding: 10px 20px;\n" +
"			text-align: center\n" +
"		}\n" +
"  </style>\n" +
" </head>\n" +
" <body>\n" +
"  <div class=\"bee-page-container\">\n" +
"   <div class=\"bee-row bee-row-1\">\n" +
"    <div class=\"bee-row-content\">\n" +
"     <div class=\"bee-col bee-col-1 bee-col-w12\">\n" +
"      <div class=\"bee-block bee-block-1 bee-divider\">\n" +
"       <div class=\"spacer\" style=\"height:0px;\">\n" +
"       </div>\n" +
"      </div>\n" +
"      <div class=\"bee-block bee-block-2 bee-heading\">\n" +
"       <h1 style=\"color:#ffffff;direction:ltr;font-family:'Roboto Slab', Arial, 'Helvetica Neue', Helvetica, sans-serif;font-size:30px;font-weight:normal;letter-spacing:2px;line-height:120%;text-align:center;margin-top:0;margin-bottom:0;\">\n" +
"        <strong>\n" +
"         FORGOT YOUR PASSWORD?\n" +
"        </strong>\n" +
"       </h1>\n" +
"      </div>\n" +
"      <div class=\"bee-block bee-block-3 bee-image\">\n" +
"       <img alt=\"Wrong Password Animation\" class=\"bee-center bee-autowidth\" src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/3856/GIF_password.gif\" style=\"max-width:500px;\">\n" +
"      </div>\n" +
"      <div class=\"bee-block bee-block-4 bee-divider\">\n" +
"       <div class=\"spacer\" style=\"height:0px;\">\n" +
"       </div>\n" +
"      </div>\n" +
"      <div class=\"bee-block bee-block-5 bee-text\">\n" +
"       <div class=\"bee-text-content\" style=\"font-size: 14px; line-height: 120%; color: #3f4d75; font-family: inherit;\">\n" +
"        <p style=\"font-size: 14px; line-height: 16px; text-align: center;\">\n" +
"         <span style=\"font-size: 20px; line-height: 24px;\">\n" +
"          Don't worry, be happy!\n" +
"         </span>\n" +
"        </p>\n" +
"       </div>\n" +
"      </div>\n" +
"      <div class=\"bee-block bee-block-6 bee-text\">\n" +
"       <div class=\"bee-text-content\" style=\"font-size: 14px; line-height: 120%; color: #3f4d75; font-family: inherit;\">\n" +
"        <p style=\"font-size: 14px; line-height: 16px; text-align: center;\">\n" +
"         <span style=\"font-size: 22px; line-height: 26px;\">\n" +
"          Let's get you a new password.\n" +
"         </span>\n" +
"        </p>\n" +
"       </div>\n" +
"      </div>\n" +
"      <div class=\"bee-block bee-block-7 bee-divider\">\n" +
"       <div class=\"spacer\" style=\"height:0px;\">\n" +
"       </div>\n" +
"      </div>\n" +
"      <div class=\"bee-block bee-block-8 bee-html-block\">\n" +
"       <div class=\"our-class\">\n" +
"        Your verification code :\n" +
"        <p>\n" +mot+
"        </p>\n" +
"       </div>\n" +
"      </div>\n" +
"      <div class=\"bee-block bee-block-9 bee-divider\">\n" +
"       <div class=\"spacer\" style=\"height:0px;\">\n" +
"       </div>\n" +
"      </div>\n" +
"      <div class=\"bee-block bee-block-10 bee-text\">\n" +
"       <div class=\"bee-text-content\" style=\"font-size: 14px; line-height: 120%; color: #3f4d75; font-family: inherit;\">\n" +
"        <p style=\"font-size: 14px; line-height: 16px; text-align: center;\">\n" +
"         <span style=\"font-size: 14px; line-height: 16px;\">\n" +
"          If you didn&rsquo;t request to change your password, simply ignore this email.\n" +
"         </span>\n" +
"        </p>\n" +
"       </div>\n" +
"      </div>\n" +
"      <div class=\"bee-block bee-block-11 bee-divider\">\n" +
"       <div class=\"spacer\" style=\"height:0px;\">\n" +
"       </div>\n" +
"      </div>\n" +
"     </div>\n" +
"    </div>\n" +
"   </div>\n" +
"   <div class=\"bee-row bee-row-2\">\n" +
"    <div class=\"bee-row-content\">\n" +
"     <div class=\"bee-col bee-col-1 bee-col-w12\">\n" +
"      <div class=\"bee-block bee-block-1 bee-text\">\n" +
"       <div class=\"bee-text-content\" style=\"font-size: 14px; line-height: 120%; color: #3f4d75; font-family: inherit;\">\n" +
"        <p style=\"font-size: 14px; line-height: 16px; text-align: center;\">\n" +
"         <span style=\"font-size: 12px; line-height: 14px;\">\n" +
"          This link will&nbsp;expire in 24 hours.&nbsp;If you continue to have problems\n" +
"         </span>\n" +
"         <br style=\"\">\n" +
"         <span style=\"font-size: 12px; line-height: 14px;\">\n" +
"          please feel free to contact us .\n" +
"          <a href=\"https://www.example.com\" rel=\"noopener\" style=\"text-decoration: underline; color: #ffffff;\" target=\"_blank\"></a>\n" +
"         </span>\n" +
"        </p>\n" +
"       </div>\n" +
"      </div>\n" +
"     </div>\n" +
"    </div>\n" +
"   </div>\n" +
"   <div class=\"bee-row bee-row-3\">\n" +
"    <div class=\"bee-row-content\">\n" +
"     <div class=\"bee-col bee-col-1 bee-col-w12\">\n" +
"      <div class=\"bee-block bee-block-1 bee-divider\">\n" +
"       <div class=\"spacer\" style=\"height:10px;\">\n" +
"       </div>\n" +
"      </div>\n" +
"      <div class=\"bee-block bee-block-2 bee-social\">\n" +
"       <div class=\"content\">\n" +
"        <span class=\"icon\" style=\"padding:0 10px 0 10px;\">\n" +
"         <a href=\"https://www.facebook.com/\">\n" +
"          <img alt=\"Facebook\" src=\"https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/circle-color/facebook@2x.png\" title=\"facebook\"></a>\n" +
"        </span>\n" +
"        <span class=\"icon\" style=\"padding:0 10px 0 10px;\">\n" +
"         <a href=\"https://www.twitter.com/\">\n" +
"          <img alt=\"Twitter\" src=\"https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/circle-color/twitter@2x.png\" title=\"twitter\"></a>\n" +
"        </span>\n" +
"        <span class=\"icon\" style=\"padding:0 10px 0 10px;\">\n" +
"         <a href=\"https://www.linkedin.com/\">\n" +
"          <img alt=\"Linkedin\" src=\"https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/circle-color/linkedin@2x.png\" title=\"linkedin\"></a>\n" +
"        </span>\n" +
"        <span class=\"icon\" style=\"padding:0 10px 0 10px;\">\n" +
"         <a href=\"https://www.instagram.com/\">\n" +
"          <img alt=\"Instagram\" src=\"https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/circle-color/instagram@2x.png\" title=\"instagram\"></a>\n" +
"        </span>\n" +
"       </div>\n" +
"      </div>\n" +
"      <div class=\"bee-block bee-block-3 bee-divider\">\n" +
"       <div class=\"spacer\" style=\"height:10px;\">\n" +
"       </div>\n" +
"      </div>\n" +
"     </div>\n" +
"    </div>\n" +
"   </div>\n" +
"  </div>\n" +
" </body>\n" +
"</html>";
            message.setContent(htmlCode,"text/html");
         
            return message;
    }
        public static void sendSignUp(String recepient) throws MessagingException 
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
            Message message = prepareMessageSignUp(session,myAccountEmail,recepient);
            Transport.send(message);
            System.out.println("message sent");
    }

    private static Message prepareMessageSignUp(Session session,String myAccountEmail,String recepient) throws AddressException, MessagingException {
       
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Account created");
            String htmlCode="""
                            <!DOCTYPE html>
                            <html xmlns:v="urn:schemas-microsoft-com:vml" xmlns:o="urn:schemas-microsoft-com:office:office" lang="en">
                            
                            <head>
                            \t<title></title>
                            \t<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
                            \t<meta name="viewport" content="width=device-width, initial-scale=1.0">
                            \t<!--[if mso]><xml><o:OfficeDocumentSettings><o:PixelsPerInch>96</o:PixelsPerInch><o:AllowPNG/></o:OfficeDocumentSettings></xml><![endif]-->
                            \t<!--[if !mso]><!-->
                            \t<link href="https://fonts.googleapis.com/css?family=Chivo" rel="stylesheet" type="text/css">
                            \t<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
                            \t<!--<![endif]-->
                            \t<style>
                            \t\t* {
                            \t\t\tbox-sizing: border-box;
                            \t\t}
                            
                            \t\tbody {
                            \t\t\tmargin: 0;
                            \t\t\tpadding: 0;
                            \t\t}
                            
                            \t\ta[x-apple-data-detectors] {
                            \t\t\tcolor: inherit !important;
                            \t\t\ttext-decoration: inherit !important;
                            \t\t}
                            
                            \t\t#MessageViewBody a {
                            \t\t\tcolor: inherit;
                            \t\t\ttext-decoration: none;
                            \t\t}
                            
                            \t\tp {
                            \t\t\tline-height: inherit
                            \t\t}
                            
                            \t\t@media (max-width:720px) {
                            \t\t\t.row-content {
                            \t\t\t\twidth: 100% !important;
                            \t\t\t}
                            
                            \t\t\t.column .border {
                            \t\t\t\tdisplay: none;
                            \t\t\t}
                            
                            \t\t\t.stack .column {
                            \t\t\t\twidth: 100%;
                            \t\t\t\tdisplay: block;
                            \t\t\t}
                            \t\t}
                            \t</style>
                            </head>
                            
                            <body style="background-color: #FFFFFF; margin: 0; padding: 0; -webkit-text-size-adjust: none; text-size-adjust: none;">
                            \t<table class="nl-container" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #FFFFFF;">
                            \t\t<tbody>
                            \t\t\t<tr>
                            \t\t\t\t<td>
                            \t\t\t\t\t<table class="row row-1" align="center" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-image: url('https://d1oco4z2z1fhwp.cloudfront.net/templates/default/96/bg_hero_illo.jpg'); background-repeat: repeat;">
                            \t\t\t\t\t\t<tbody>
                            \t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t<td>
                            \t\t\t\t\t\t\t\t\t<table class="row-content" align="center" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 700px;" width="700">
                            \t\t\t\t\t\t\t\t\t\t<tbody>
                            \t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t<td class="column column-1" width="100%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 60px; padding-bottom: 0px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t<table class="image_block" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="width:100%;padding-right:0px;padding-left:0px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div align="center" style="line-height:10px"><img src="https://d1oco4z2z1fhwp.cloudfront.net/templates/default/96/logo.png" style="display: block; height: auto; border: 0; width: 140px; max-width: 100%;" width="140" alt="Image" title="Image"></div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t<table class="text_block" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="padding-bottom:35px;padding-left:10px;padding-right:10px;padding-top:10px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-family: Arial, sans-serif">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-family: 'Chivo', Arial, Helvetica, sans-serif; font-size: 12px; mso-line-height-alt: 14.399999999999999px; color: #5beda6; line-height: 1.2;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p style="margin: 0; text-align: center; font-size: 12px;"><span style="color:#ffcc00;"><span style="font-size:38px;"><em>Congrats on joining EFood!</em></span></span></p>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t<table class="image_block" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="width:100%;padding-right:0px;padding-left:0px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div align="center" style="line-height:10px"><img src="https://d1oco4z2z1fhwp.cloudfront.net/templates/default/96/illo_hero_transparent.png" style="display: block; height: auto; border: 0; width: 587px; max-width: 100%;" width="587" alt="Image" title="Image"></div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t</tbody>
                            \t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t</tbody>
                            \t\t\t\t\t</table>
                            \t\t\t\t\t<table class="row row-2" align="center" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            \t\t\t\t\t\t<tbody>
                            \t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t<td>
                            \t\t\t\t\t\t\t\t\t<table class="row-content stack" align="center" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 700px;" width="700">
                            \t\t\t\t\t\t\t\t\t\t<tbody>
                            \t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t<td class="column column-1" width="100%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-left: 25px; padding-right: 25px; padding-top: 25px; padding-bottom: 25px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t<table class="text_block" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="padding-bottom:10px;padding-left:40px;padding-right:40px;padding-top:10px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-family: Tahoma, Verdana, sans-serif">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-size: 12px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 18px; color: #555555; line-height: 1.5;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p style="margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 27px;"><span style="font-size:18px;">Hi there!</span></p>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p style="margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 27px;"><span style="font-size:18px;">Thanks for joining us !</span></p>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p style="margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 27px;"><span style="font-size:18px;">Let's introduce you to some of our best features.</span></p>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t</tbody>
                            \t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t</tbody>
                            \t\t\t\t\t</table>
                            \t\t\t\t\t<table class="row row-3" align="center" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #F4F4F4; background-image: url('https://d1oco4z2z1fhwp.cloudfront.net/templates/default/96/sayagata-400px.png'); background-repeat: repeat;">
                            \t\t\t\t\t\t<tbody>
                            \t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t<td>
                            \t\t\t\t\t\t\t\t\t<table class="row-content" align="center" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #333; width: 700px;" width="700">
                            \t\t\t\t\t\t\t\t\t\t<tbody>
                            \t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t<td class="column column-1" width="33.333333333333336%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t<table class="image_block" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="padding-bottom:70px;padding-left:40px;padding-right:40px;padding-top:70px;width:100%;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div align="center" style="line-height:10px"><img src="https://d1oco4z2z1fhwp.cloudfront.net/templates/default/96/iphone_v1_1png.png" style="display: block; height: auto; border: 0; width: 117px; max-width: 100%;" width="117" alt="Image" title="Image"></div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t<td class="column column-2" width="66.66666666666667%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t<table class="text_block" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="padding-left:10px;padding-right:40px;padding-top:65px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-family: Arial, sans-serif">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-size: 12px; font-family: 'Chivo', Arial, Helvetica, sans-serif; mso-line-height-alt: 14.399999999999999px; color: #5beda6; line-height: 1.2;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p style="margin: 0; font-size: 14px;"><span style="font-size:22px;"><strong>Feature 1<br></strong></span></p>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t<table class="text_block" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="padding-bottom:5px;padding-left:10px;padding-right:40px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-family: Arial, sans-serif">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-size: 12px; font-family: 'Chivo', Arial, Helvetica, sans-serif; mso-line-height-alt: 14.399999999999999px; color: #5beda6; line-height: 1.2;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p style="margin: 0; font-size: 14px;"><span style="font-size:16px;color:#ffcc00;"><strong>Rapidity</strong></span></p>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t<table class="text_block" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="padding-left:10px;padding-right:40px;padding-bottom:30px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-family: Tahoma, Verdana, sans-serif">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-size: 12px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 18px; color: #555555; line-height: 1.5;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p style="margin: 0; font-size: 14px; text-align: left; mso-line-height-alt: 24px;"><span style="font-size:16px;">Unlike many other food delivering apps we guarantee rapidity and quality!</span></p>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t</tbody>
                            \t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t</tbody>
                            \t\t\t\t\t</table>
                            \t\t\t\t\t<table class="row row-4" align="center" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            \t\t\t\t\t\t<tbody>
                            \t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t<td>
                            \t\t\t\t\t\t\t\t\t<table class="row-content" align="center" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #333; width: 700px;" width="700">
                            \t\t\t\t\t\t\t\t\t\t<tbody>
                            \t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t<td class="column column-1" width="66.66666666666667%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t<table class="text_block" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="padding-left:40px;padding-top:65px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-family: Arial, sans-serif">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-size: 12px; font-family: 'Chivo', Arial, Helvetica, sans-serif; mso-line-height-alt: 18px; color: #5beda6; line-height: 1.5;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p style="margin: 0; font-size: 14px; text-align: right; mso-line-height-alt: 33px;"><span style="font-size:22px;"><strong>Feature 2<br></strong></span></p>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t<table class="text_block" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="padding-bottom:5px;padding-left:40px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-family: Arial, sans-serif">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-size: 12px; font-family: 'Chivo', Arial, Helvetica, sans-serif; mso-line-height-alt: 14.399999999999999px; color: #5beda6; line-height: 1.2;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p style="margin: 0; font-size: 14px; text-align: right;"><span style="font-size:16px;color:#ffcc00;"><strong>Green</strong></span></p>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t<table class="text_block" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="padding-left:40px;padding-bottom:30px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-family: Tahoma, Verdana, sans-serif">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-size: 12px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 18px; color: #555555; line-height: 1.5;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p style="margin: 0; font-size: 14px; text-align: right; mso-line-height-alt: 24px;"><span style="font-size:16px;">Our vast food choices include vegan and vegetarian options for our Green clients.</span></p>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t<td class="column column-2" width="33.333333333333336%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t<table class="image_block" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="padding-bottom:70px;padding-left:40px;padding-right:40px;padding-top:70px;width:100%;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div align="center" style="line-height:10px"><img src="https://d1oco4z2z1fhwp.cloudfront.net/templates/default/96/iphone_v1_2.png" style="display: block; height: auto; border: 0; width: 117px; max-width: 100%;" width="117" alt="Image" title="Image"></div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t</tbody>
                            \t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t</tbody>
                            \t\t\t\t\t</table>
                            \t\t\t\t\t<table class="row row-5" align="center" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #F4F4F4; background-image: url('https://d1oco4z2z1fhwp.cloudfront.net/templates/default/96/sayagata-400px.png'); background-repeat: repeat;">
                            \t\t\t\t\t\t<tbody>
                            \t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t<td>
                            \t\t\t\t\t\t\t\t\t<table class="row-content" align="center" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #333; width: 700px;" width="700">
                            \t\t\t\t\t\t\t\t\t\t<tbody>
                            \t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t<td class="column column-1" width="33.333333333333336%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t<table class="image_block" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="padding-bottom:70px;padding-left:40px;padding-right:40px;padding-top:70px;width:100%;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div align="center" style="line-height:10px"><img src="https://d1oco4z2z1fhwp.cloudfront.net/templates/default/96/iphone_v1_3.png" style="display: block; height: auto; border: 0; width: 117px; max-width: 100%;" width="117" alt="Image" title="Image"></div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t<td class="column column-2" width="66.66666666666667%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t<table class="text_block" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="padding-left:10px;padding-right:40px;padding-top:65px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-family: Arial, sans-serif">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-size: 12px; font-family: 'Chivo', Arial, Helvetica, sans-serif; mso-line-height-alt: 14.399999999999999px; color: #5beda6; line-height: 1.2;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p style="margin: 0; font-size: 14px;"><span style="font-size:22px;"><strong>Feature 3<br></strong></span></p>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t<table class="text_block" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="padding-bottom:5px;padding-left:10px;padding-right:40px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-family: Arial, sans-serif">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-size: 12px; font-family: 'Chivo', Arial, Helvetica, sans-serif; mso-line-height-alt: 14.399999999999999px; color: #5beda6; line-height: 1.2;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p style="margin: 0; font-size: 14px;"><span style="font-size:16px;color:#ffcc00;"><strong>Sales</strong></span></p>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t<table class="text_block" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="padding-left:10px;padding-right:40px;padding-bottom:30px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-family: Tahoma, Verdana, sans-serif">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-size: 12px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 18px; color: #555555; line-height: 1.5;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p style="margin: 0; font-size: 14px; text-align: left; mso-line-height-alt: 24px;"><span style="font-size:16px;">We offer regular sales and discount codes for our loyal clients.</span></p>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t</tbody>
                            \t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t</tbody>
                            \t\t\t\t\t</table>
                            \t\t\t\t\t<table class="row row-6" align="center" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #9ef2c3;">
                            \t\t\t\t\t\t<tbody>
                            \t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t<td>
                            \t\t\t\t\t\t\t\t\t<table class="row-content" align="center" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #333; width: 700px;" width="700">
                            \t\t\t\t\t\t\t\t\t\t<tbody>
                            \t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t<td class="column column-1" width="50%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t<table class="image_block" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="padding-right:20px;width:100%;padding-left:0px;padding-top:5px;padding-bottom:45px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div align="right" style="line-height:10px"><img src="https://d1oco4z2z1fhwp.cloudfront.net/templates/default/96/gplay.gif" style="display: block; height: auto; border: 0; width: 122px; max-width: 100%;" width="122" alt="Image" title="Image"></div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t<td class="column column-2" width="50%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t<table class="image_block" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="padding-left:20px;width:100%;padding-right:0px;padding-top:5px;padding-bottom:5px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="line-height:10px"><img src="https://d1oco4z2z1fhwp.cloudfront.net/templates/default/96/appstore.png" style="display: block; height: auto; border: 0; width: 122px; max-width: 100%;" width="122" alt="Image" title="Image"></div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t</tbody>
                            \t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t</tbody>
                            \t\t\t\t\t</table>
                            \t\t\t\t\t<table class="row row-7" align="center" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #FFFFFF;">
                            \t\t\t\t\t\t<tbody>
                            \t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t<td>
                            \t\t\t\t\t\t\t\t\t<table class="row-content stack" align="center" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 700px;" width="700">
                            \t\t\t\t\t\t\t\t\t\t<tbody>
                            \t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t<td class="column column-1" width="100%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 40px; padding-bottom: 40px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t<table class="image_block" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="padding-bottom:15px;width:100%;padding-right:0px;padding-left:0px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div align="center" style="line-height:10px"><img src="https://d1oco4z2z1fhwp.cloudfront.net/templates/default/96/logo.png" style="display: block; height: auto; border: 0; width: 148px; max-width: 100%;" width="148" alt="Image" title="Image"></div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t<table class="text_block" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-family: sans-serif">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-size: 12px; mso-line-height-alt: 14.399999999999999px; color: #5beda6; line-height: 1.2; font-family: Lato, Tahoma, Verdana, Segoe, sans-serif;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p style="margin: 0; font-size: 14px; text-align: center;"><span style="font-size:16px;"><strong>EFood Delivery</strong></span></p>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p style="margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 14.399999999999999px;">&nbsp;</p>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t<table class="social_block" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table class="social-table" width="148px" border="0" cellpadding="0" cellspacing="0" role="presentation" align="center" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="padding:0 5px 0 0px;"><a href="https://twitter.com/" target="_blank"><img src="https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/circle-gray/twitter@2x.png" width="32" height="32" alt="Twitter" title="Twitter" style="display: block; height: auto; border: 0;"></a></td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="padding:0 5px 0 0px;"><a href="https://plus.google.com/" target="_blank"><img src="https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/circle-gray/googleplus@2x.png" width="32" height="32" alt="Google+" title="Google+" style="display: block; height: auto; border: 0;"></a></td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="padding:0 5px 0 0px;"><a href="https://www.youtube.com/" target="_blank"><img src="https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/circle-gray/youtube@2x.png" width="32" height="32" alt="YouTube" title="YouTube" style="display: block; height: auto; border: 0;"></a></td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="padding:0 5px 0 0px;"><a href="https://www.facebook.com/" target="_blank"><img src="https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/circle-gray/facebook@2x.png" width="32" height="32" alt="Facebook" title="Facebook" style="display: block; height: auto; border: 0;"></a></td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t</tbody>
                            \t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t</tbody>
                            \t\t\t\t\t</table>
                            \t\t\t\t\t<table class="row row-8" align="center" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #F4F4F4;">
                            \t\t\t\t\t\t<tbody>
                            \t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t<td>
                            \t\t\t\t\t\t\t\t\t<table class="row-content stack" align="center" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 700px;" width="700">
                            \t\t\t\t\t\t\t\t\t\t<tbody>
                            \t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t<td class="column column-1" width="100%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 25px; padding-bottom: 25px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t<table class="text_block" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-family: sans-serif">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-size: 12px; mso-line-height-alt: 14.399999999999999px; color: #555555; line-height: 1.2; font-family: Lato, Tahoma, Verdana, Segoe, sans-serif;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p style="margin: 0; font-size: 12px; text-align: center;">All rights reserved \u00a9 2018 /&nbsp; Efood</p>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t</tbody>
                            \t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t</tbody>
                            \t\t\t\t\t</table>
                            \t\t\t\t</td>
                            \t\t\t</tr>
                            \t\t</tbody>
                            \t</table><!-- End -->
                            </body>
                            
                            </html>""";
            message.setContent(htmlCode ,"text/html");
            return message;
    }
         public static void sendPasswordReset(String recepient) throws MessagingException 
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
            Message message = prepareMessagePasswordReset(session,myAccountEmail,recepient);
            Transport.send(message);
            System.out.println("message sent");
    }

    private static Message prepareMessagePasswordReset(Session session,String myAccountEmail,String recepient) throws AddressException, MessagingException {
       
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Password reset");
            String htmlCode="""
                            <!DOCTYPE html>
                            <html xmlns:v="urn:schemas-microsoft-com:vml" xmlns:o="urn:schemas-microsoft-com:office:office" lang="en">
                            
                            <head>
                            \t<title></title>
                            \t<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
                            \t<meta name="viewport" content="width=device-width, initial-scale=1.0">
                            \t<!--[if mso]><xml><o:OfficeDocumentSettings><o:PixelsPerInch>96</o:PixelsPerInch><o:AllowPNG/></o:OfficeDocumentSettings></xml><![endif]-->
                            \t<!--[if !mso]><!-->
                            \t<link href="https://fonts.googleapis.com/css?family=Bitter" rel="stylesheet" type="text/css">
                            \t<link href="https://fonts.googleapis.com/css?family=Cormorant+Garamond" rel="stylesheet" type="text/css">
                            \t<link href="https://fonts.googleapis.com/css?family=Cabin" rel="stylesheet" type="text/css">
                            \t<link href="https://fonts.googleapis.com/css?family=Droid+Serif" rel="stylesheet" type="text/css">
                            \t<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
                            \t<link href="https://fonts.googleapis.com/css?family=Roboto+Slab" rel="stylesheet" type="text/css">
                            \t<!--<![endif]-->
                            \t<style>
                            \t\t* {
                            \t\t\tbox-sizing: border-box;
                            \t\t}
                            
                            \t\tbody {
                            \t\t\tmargin: 0;
                            \t\t\tpadding: 0;
                            \t\t}
                            
                            \t\ta[x-apple-data-detectors] {
                            \t\t\tcolor: inherit !important;
                            \t\t\ttext-decoration: inherit !important;
                            \t\t}
                            
                            \t\t#MessageViewBody a {
                            \t\t\tcolor: inherit;
                            \t\t\ttext-decoration: none;
                            \t\t}
                            
                            \t\tp {
                            \t\t\tline-height: inherit
                            \t\t}
                            
                            \t\t@media (max-width:670px) {
                            \t\t\t.row-content {
                            \t\t\t\twidth: 100% !important;
                            \t\t\t}
                            
                            \t\t\t.column .border {
                            \t\t\t\tdisplay: none;
                            \t\t\t}
                            
                            \t\t\t.stack .column {
                            \t\t\t\twidth: 100%;
                            \t\t\t\tdisplay: block;
                            \t\t\t}
                            \t\t}
                            \t</style>
                            </head>
                            
                            <body style="background-color: #85a4cd; margin: 0; padding: 0; -webkit-text-size-adjust: none; text-size-adjust: none;">
                            \t<table class="nl-container" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #85a4cd;">
                            \t\t<tbody>
                            \t\t\t<tr>
                            \t\t\t\t<td>
                            \t\t\t\t\t<table class="row row-1" align="center" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            \t\t\t\t\t\t<tbody>
                            \t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t<td>
                            \t\t\t\t\t\t\t\t\t<table class="row-content stack" align="center" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 650px;" width="650">
                            \t\t\t\t\t\t\t\t\t\t<tbody>
                            \t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t<td class="column column-1" width="100%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 5px; padding-bottom: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t<table class="heading_block" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="padding-bottom:10px;text-align:center;width:100%;padding-top:60px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<h1 style="margin: 0; color: #ffffff; direction: ltr; font-family: 'Roboto Slab', Arial, 'Helvetica Neue', Helvetica, sans-serif; font-size: 30px; font-weight: 400; letter-spacing: 2px; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0;"><strong>Your password has been reset!</strong></h1>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t<table class="image_block" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="width:100%;padding-right:0px;padding-left:0px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div align="center" style="line-height:10px"><img src="https://d1oco4z2z1fhwp.cloudfront.net/templates/default/3856/GIF_password.gif" style="display: block; height: auto; border: 0; width: 500px; max-width: 100%;" width="500" alt="Wrong Password Animation" title="Wrong Password Animation"></div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t<table class="text_block" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="padding-bottom:5px;padding-left:10px;padding-right:10px;padding-top:25px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-family: sans-serif">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-size: 14px; mso-line-height-alt: 16.8px; color: #3f4d75; line-height: 1.2; font-family: Roboto Slab, Arial, Helvetica Neue, Helvetica, sans-serif;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p style="margin: 0; font-size: 14px; text-align: center;"><span style="font-size:20px;">Don't worry! Your account has been restored!</span></p>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t<table class="text_block" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="padding-bottom:5px;padding-left:10px;padding-right:10px;padding-top:5px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-family: sans-serif">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-size: 14px; mso-line-height-alt: 16.8px; color: #3f4d75; line-height: 1.2; font-family: Roboto Slab, Arial, Helvetica Neue, Helvetica, sans-serif;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p style="margin: 0; font-size: 14px; text-align: center;"><span style="font-size:22px;">Use your new password to login.</span></p>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t<table class="text_block" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="padding-bottom:40px;padding-left:10px;padding-right:10px;padding-top:50px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-family: sans-serif">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-size: 14px; mso-line-height-alt: 16.8px; color: #3f4d75; line-height: 1.2; font-family: Roboto Slab, Arial, Helvetica Neue, Helvetica, sans-serif;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p style="margin: 0; font-size: 14px; text-align: center;"><span style="font-size:14px;">If you didn\u2019t request to change your password, Let us know.</span></p>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t</tbody>
                            \t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t</tbody>
                            \t\t\t\t\t</table>
                            \t\t\t\t\t<table class="row row-2" align="center" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #c4d6ec;">
                            \t\t\t\t\t\t<tbody>
                            \t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t<td>
                            \t\t\t\t\t\t\t\t\t<table class="row-content stack" align="center" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 650px;" width="650">
                            \t\t\t\t\t\t\t\t\t\t<tbody>
                            \t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t<td class="column column-1" width="100%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 20px; padding-bottom: 20px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t<table class="text_block" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-family: sans-serif">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-size: 14px; mso-line-height-alt: 16.8px; color: #3f4d75; line-height: 1.2; font-family: Roboto Slab, Arial, Helvetica Neue, Helvetica, sans-serif;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p style="margin: 0; font-size: 14px; text-align: center;"><span style="font-size:12px;">If you continue to have problems</span><br><span style="font-size:12px;">please feel free to contact us .<a href="https://www.example.com" target="_blank" style="text-decoration: underline; color: #ffffff;" rel="noopener"></a></span></p>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t</tbody>
                            \t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t</tbody>
                            \t\t\t\t\t</table>
                            \t\t\t\t\t<table class="row row-3" align="center" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #f3f6fe;">
                            \t\t\t\t\t\t<tbody>
                            \t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t<td>
                            \t\t\t\t\t\t\t\t\t<table class="row-content stack" align="center" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 650px;" width="650">
                            \t\t\t\t\t\t\t\t\t\t<tbody>
                            \t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t<td class="column column-1" width="100%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 0px; padding-bottom: 0px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t<table class="social_block" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="padding-bottom:40px;padding-left:20px;padding-right:20px;padding-top:50px;text-align:center;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table class="social-table" width="208px" border="0" cellpadding="0" cellspacing="0" role="presentation" align="center" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="padding:0 10px 0 10px;"><a href="https://www.facebook.com/" target="_blank"><img src="https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/circle-color/facebook@2x.png" width="32" height="32" alt="Facebook" title="facebook" style="display: block; height: auto; border: 0;"></a></td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="padding:0 10px 0 10px;"><a href="https://www.twitter.com/" target="_blank"><img src="https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/circle-color/twitter@2x.png" width="32" height="32" alt="Twitter" title="twitter" style="display: block; height: auto; border: 0;"></a></td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="padding:0 10px 0 10px;"><a href="https://www.linkedin.com/" target="_blank"><img src="https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/circle-color/linkedin@2x.png" width="32" height="32" alt="Linkedin" title="linkedin" style="display: block; height: auto; border: 0;"></a></td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="padding:0 10px 0 10px;"><a href="https://www.instagram.com/" target="_blank"><img src="https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/circle-color/instagram@2x.png" width="32" height="32" alt="Instagram" title="instagram" style="display: block; height: auto; border: 0;"></a></td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t</tbody>
                            \t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t</tbody>
                            \t\t\t\t\t</table>
                            \t\t\t\t</td>
                            \t\t\t</tr>
                            \t\t</tbody>
                            \t</table><!-- End -->
                            </body>
                            
                            </html>""";
            message.setContent(htmlCode ,"text/html");
            return message;
    }
            public static void sendAccountModified(String recepient) throws MessagingException 
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
            Message message = prepareMessageAccountModified(session,myAccountEmail,recepient);
            Transport.send(message);
            System.out.println("message sent");
    }

    private static Message prepareMessageAccountModified(Session session,String myAccountEmail,String recepient) throws AddressException, MessagingException {
       
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Account modified ");
            String htmlCode="""
                            <!DOCTYPE html>
                            <html xmlns:v="urn:schemas-microsoft-com:vml" xmlns:o="urn:schemas-microsoft-com:office:office" lang="en">
                            
                            <head>
                            \t<title></title>
                            \t<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
                            \t<meta name="viewport" content="width=device-width, initial-scale=1.0">
                            \t<!--[if mso]><xml><o:OfficeDocumentSettings><o:PixelsPerInch>96</o:PixelsPerInch><o:AllowPNG/></o:OfficeDocumentSettings></xml><![endif]-->
                            \t<!--[if !mso]><!-->
                            \t<link href="https://fonts.googleapis.com/css?family=Chivo" rel="stylesheet" type="text/css">
                            \t<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
                            \t<!--<![endif]-->
                            \t<style>
                            \t\t* {
                            \t\t\tbox-sizing: border-box;
                            \t\t}
                            
                            \t\tbody {
                            \t\t\tmargin: 0;
                            \t\t\tpadding: 0;
                            \t\t}
                            
                            \t\ta[x-apple-data-detectors] {
                            \t\t\tcolor: inherit !important;
                            \t\t\ttext-decoration: inherit !important;
                            \t\t}
                            
                            \t\t#MessageViewBody a {
                            \t\t\tcolor: inherit;
                            \t\t\ttext-decoration: none;
                            \t\t}
                            
                            \t\tp {
                            \t\t\tline-height: inherit
                            \t\t}
                            
                            \t\t@media (max-width:720px) {
                            \t\t\t.row-content {
                            \t\t\t\twidth: 100% !important;
                            \t\t\t}
                            
                            \t\t\t.column .border {
                            \t\t\t\tdisplay: none;
                            \t\t\t}
                            
                            \t\t\t.stack .column {
                            \t\t\t\twidth: 100%;
                            \t\t\t\tdisplay: block;
                            \t\t\t}
                            \t\t}
                            \t</style>
                            </head>
                            
                            <body style="background-color: #FFFFFF; margin: 0; padding: 0; -webkit-text-size-adjust: none; text-size-adjust: none;">
                            \t<table class="nl-container" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #FFFFFF;">
                            \t\t<tbody>
                            \t\t\t<tr>
                            \t\t\t\t<td>
                            \t\t\t\t\t<table class="row row-1" align="center" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-image: url('https://d1oco4z2z1fhwp.cloudfront.net/templates/default/96/bg_hero_illo.jpg'); background-repeat: repeat;">
                            \t\t\t\t\t\t<tbody>
                            \t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t<td>
                            \t\t\t\t\t\t\t\t\t<table class="row-content" align="center" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 700px;" width="700">
                            \t\t\t\t\t\t\t\t\t\t<tbody>
                            \t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t<td class="column column-1" width="100%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 60px; padding-bottom: 0px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t<table class="image_block" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="width:100%;padding-right:0px;padding-left:0px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div align="center" style="line-height:10px"><img src="https://d1oco4z2z1fhwp.cloudfront.net/templates/default/96/logo.png" style="display: block; height: auto; border: 0; width: 140px; max-width: 100%;" width="140" alt="Image" title="Image"></div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t<table class="text_block" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="padding-bottom:35px;padding-left:10px;padding-right:10px;padding-top:10px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-family: Arial, sans-serif">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-family: 'Chivo', Arial, Helvetica, sans-serif; font-size: 12px; mso-line-height-alt: 14.399999999999999px; color: #5beda6; line-height: 1.2;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p style="margin: 0; text-align: center; font-size: 12px;"><span style="color:#ffcc00;"><span style="font-size:38px;"><em>Your profile was updated successfully!</em></span></span></p>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t<table class="image_block" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="width:100%;padding-right:0px;padding-left:0px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div align="center" style="line-height:10px"><img src="https://d1oco4z2z1fhwp.cloudfront.net/templates/default/96/illo_hero_transparent.png" style="display: block; height: auto; border: 0; width: 587px; max-width: 100%;" width="587" alt="Image" title="Image"></div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t</tbody>
                            \t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t</tbody>
                            \t\t\t\t\t</table>
                            \t\t\t\t\t<table class="row row-2" align="center" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            \t\t\t\t\t\t<tbody>
                            \t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t<td>
                            \t\t\t\t\t\t\t\t\t<table class="row-content stack" align="center" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 700px;" width="700">
                            \t\t\t\t\t\t\t\t\t\t<tbody>
                            \t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t<td class="column column-1" width="100%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-left: 25px; padding-right: 25px; padding-top: 25px; padding-bottom: 25px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t<table class="text_block" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="padding-bottom:10px;padding-left:40px;padding-right:40px;padding-top:10px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-family: Tahoma, Verdana, sans-serif">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-size: 12px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 18px; color: #555555; line-height: 1.5;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p style="margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 27px;"><span style="font-size:18px;">Hi there!</span></p>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p style="margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 27px;"><span style="font-size:18px;">We want to let you know that your profile has been updated successfully.</span></p>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t<table class="divider_block" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div align="center">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table border="0" cellpadding="0" cellspacing="0" role="presentation" width="100%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class="divider_inner" style="font-size: 1px; line-height: 1px; border-top: 1px solid #BBBBBB;"><span>&#8202;</span></td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t<table class="text_block" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-family: sans-serif">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-size: 14px; mso-line-height-alt: 21px; color: #393d47; line-height: 1.5; font-family: Lato, Tahoma, Verdana, Segoe, sans-serif;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p style="margin: 0; font-size: 14px; text-align: center;"><strong><span style="font-size:16px;">If it wasn't you who updated the profile, Let us know.</span></strong></p>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t</tbody>
                            \t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t</tbody>
                            \t\t\t\t\t</table>
                            \t\t\t\t\t<table class="row row-3" align="center" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #9ef2c3;">
                            \t\t\t\t\t\t<tbody>
                            \t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t<td>
                            \t\t\t\t\t\t\t\t\t<table class="row-content" align="center" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #333; width: 700px;" width="700">
                            \t\t\t\t\t\t\t\t\t\t<tbody>
                            \t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t<td class="column column-1" width="50%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t<table class="image_block" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="padding-right:20px;width:100%;padding-left:0px;padding-top:5px;padding-bottom:45px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div align="right" style="line-height:10px"><img src="https://d1oco4z2z1fhwp.cloudfront.net/templates/default/96/gplay.gif" style="display: block; height: auto; border: 0; width: 122px; max-width: 100%;" width="122" alt="Image" title="Image"></div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t<td class="column column-2" width="50%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t<table class="image_block" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="padding-left:20px;width:100%;padding-right:0px;padding-top:5px;padding-bottom:5px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="line-height:10px"><img src="https://d1oco4z2z1fhwp.cloudfront.net/templates/default/96/appstore.png" style="display: block; height: auto; border: 0; width: 122px; max-width: 100%;" width="122" alt="Image" title="Image"></div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t</tbody>
                            \t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t</tbody>
                            \t\t\t\t\t</table>
                            \t\t\t\t\t<table class="row row-4" align="center" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #FFFFFF;">
                            \t\t\t\t\t\t<tbody>
                            \t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t<td>
                            \t\t\t\t\t\t\t\t\t<table class="row-content stack" align="center" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 700px;" width="700">
                            \t\t\t\t\t\t\t\t\t\t<tbody>
                            \t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t<td class="column column-1" width="100%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 40px; padding-bottom: 40px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t<table class="image_block" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="padding-bottom:15px;width:100%;padding-right:0px;padding-left:0px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div align="center" style="line-height:10px"><img src="https://d1oco4z2z1fhwp.cloudfront.net/templates/default/96/logo.png" style="display: block; height: auto; border: 0; width: 148px; max-width: 100%;" width="148" alt="Image" title="Image"></div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t<table class="text_block" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-family: sans-serif">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-size: 12px; mso-line-height-alt: 14.399999999999999px; color: #5beda6; line-height: 1.2; font-family: Lato, Tahoma, Verdana, Segoe, sans-serif;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p style="margin: 0; font-size: 14px; text-align: center;"><span style="font-size:16px;"><strong>EFood Delivery</strong></span></p>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p style="margin: 0; font-size: 14px; text-align: center; mso-line-height-alt: 14.399999999999999px;">&nbsp;</p>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t<table class="social_block" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table class="social-table" width="148px" border="0" cellpadding="0" cellspacing="0" role="presentation" align="center" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="padding:0 5px 0 0px;"><a href="https://twitter.com/" target="_blank"><img src="https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/circle-gray/twitter@2x.png" width="32" height="32" alt="Twitter" title="Twitter" style="display: block; height: auto; border: 0;"></a></td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="padding:0 5px 0 0px;"><a href="https://plus.google.com/" target="_blank"><img src="https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/circle-gray/googleplus@2x.png" width="32" height="32" alt="Google+" title="Google+" style="display: block; height: auto; border: 0;"></a></td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="padding:0 5px 0 0px;"><a href="https://www.youtube.com/" target="_blank"><img src="https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/circle-gray/youtube@2x.png" width="32" height="32" alt="YouTube" title="YouTube" style="display: block; height: auto; border: 0;"></a></td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td style="padding:0 5px 0 0px;"><a href="https://www.facebook.com/" target="_blank"><img src="https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/circle-gray/facebook@2x.png" width="32" height="32" alt="Facebook" title="Facebook" style="display: block; height: auto; border: 0;"></a></td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t</tbody>
                            \t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t</tbody>
                            \t\t\t\t\t</table>
                            \t\t\t\t\t<table class="row row-5" align="center" width="100%" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #F4F4F4;">
                            \t\t\t\t\t\t<tbody>
                            \t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t<td>
                            \t\t\t\t\t\t\t\t\t<table class="row-content stack" align="center" border="0" cellpadding="0" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 700px;" width="700">
                            \t\t\t\t\t\t\t\t\t\t<tbody>
                            \t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t<td class="column column-1" width="100%" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 25px; padding-bottom: 25px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t<table class="text_block" width="100%" border="0" cellpadding="10" cellspacing="0" role="presentation" style="mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-family: sans-serif">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div style="font-size: 12px; mso-line-height-alt: 14.399999999999999px; color: #555555; line-height: 1.2; font-family: Lato, Tahoma, Verdana, Segoe, sans-serif;">
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<p style="margin: 0; font-size: 12px; text-align: center;">All rights reserved \u00a9 2022 /&nbsp; Efood</p>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t\t\t\t\t</tbody>
                            \t\t\t\t\t\t\t\t\t</table>
                            \t\t\t\t\t\t\t\t</td>
                            \t\t\t\t\t\t\t</tr>
                            \t\t\t\t\t\t</tbody>
                            \t\t\t\t\t</table>
                            \t\t\t\t</td>
                            \t\t\t</tr>
                            \t\t</tbody>
                            \t</table><!-- End -->
                            </body>
                            </html>""";
            message.setContent(htmlCode ,"text/html");
            return message;
    }
     public static void sendBanned(String recepient) throws MessagingException 
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
            Message message = prepareMessageBanned(session,myAccountEmail,recepient);
            Transport.send(message);
            System.out.println("message sent");
    }

    private static Message prepareMessageBanned(Session session,String myAccountEmail,String recepient) throws AddressException, MessagingException {
       
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Banned");
            String htmlCode="<!DOCTYPE html>\n" +
"<html xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" lang=\"en\">\n" +
"\n" +
"<head>\n" +
"	<title></title>\n" +
"	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
"	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"	<!--[if mso]><xml><o:OfficeDocumentSettings><o:PixelsPerInch>96</o:PixelsPerInch><o:AllowPNG/></o:OfficeDocumentSettings></xml><![endif]-->\n" +
"	<!--[if !mso]><!-->\n" +
"	<link href=\"https://fonts.googleapis.com/css?family=Lato\" rel=\"stylesheet\" type=\"text/css\">\n" +
"	<link href=\"https://fonts.googleapis.com/css2?family=Alex+Brush&amp;display=swap\" rel=\"stylesheet\" type=\"text/css\">\n" +
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
"		@media (max-width:700px) {\n" +
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
"<body style=\"background-color: #f2f2f2; margin: 0; padding: 0; -webkit-text-size-adjust: none; text-size-adjust: none;\">\n" +
"	<table class=\"nl-container\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #f2f2f2;\">\n" +
"		<tbody>\n" +
"			<tr>\n" +
"				<td>\n" +
"					<table class=\"row row-1\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"						<tbody>\n" +
"							<tr>\n" +
"								<td>\n" +
"									<table class=\"row-content stack\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 680px;\" width=\"680\">\n" +
"										<tbody>\n" +
"											<tr>\n" +
"												<td class=\"column column-1\" width=\"100%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 5px; padding-bottom: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"													<div class=\"spacer_block\" style=\"height:40px;line-height:40px;font-size:1px;\">&#8202;</div>\n" +
"												</td>\n" +
"											</tr>\n" +
"										</tbody>\n" +
"									</table>\n" +
"								</td>\n" +
"							</tr>\n" +
"						</tbody>\n" +
"					</table>\n" +
"					<table class=\"row row-2\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-image: url('https://d1oco4z2z1fhwp.cloudfront.net/templates/default/3951/header_bg.png'); background-position: top center; background-repeat: no-repeat;\">\n" +
"						<tbody>\n" +
"							<tr>\n" +
"								<td>\n" +
"									<table class=\"row-content stack\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; color: #000000; width: 680px;\" width=\"680\">\n" +
"										<tbody>\n" +
"											<tr>\n" +
"												<td class=\"column column-1\" width=\"50%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"													<table class=\"text_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n" +
"														<tr>\n" +
"															<td style=\"padding-bottom:15px;padding-left:20px;padding-right:20px;padding-top:125px;\">\n" +
"																<div style=\"font-family: Tahoma, Verdana, sans-serif\">\n" +
"																	<div style=\"font-size: 14px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 16.8px; color: #000000; line-height: 1.2;\">\n" +
"																		<p style=\"margin: 0; font-size: 30px;\"><strong>Unfortunately, </strong></p>\n" +
"																		<p style=\"margin: 0; font-size: 30px;\"><strong>You have been banned from using the app.</strong></p>\n" +
"																	</div>\n" +
"																</div>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"												</td>\n" +
"												<td class=\"column column-2\" width=\"50%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"													<table class=\"heading_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"														<tr>\n" +
"															<td style=\"text-align:center;width:100%;padding-top:45px;\">\n" +
"																<h1 style=\"margin: 0; color: #000000; direction: ltr; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; font-size: 16px; font-weight: 400; letter-spacing: normal; line-height: 120%; text-align: center; margin-top: 0; margin-bottom: 0;\"><span style=\"color: #000000;\"><a href=\"http://www.example.com\" target=\"_blank\" style=\"text-decoration: none; color: #000000;\" rel=\"noopener\"><strong>Contact us&gt;&gt;</strong></a></span></h1>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"													<table class=\"image_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"														<tr>\n" +
"															<td style=\"width:100%;padding-right:0px;padding-left:0px;padding-top:45px;padding-bottom:25px;\">\n" +
"																<div align=\"center\" style=\"line-height:10px\"><img src=\"https://d1oco4z2z1fhwp.cloudfront.net/templates/default/3951/buyer_1.png\" style=\"display: block; height: auto; border: 0; width: 301px; max-width: 100%;\" width=\"301\" alt=\"buyer\" title=\"buyer\"></div>\n" +
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
"									<table class=\"row-content stack\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #7ecd34; color: #000000; width: 680px;\" width=\"680\">\n" +
"										<tbody>\n" +
"											<tr>\n" +
"												<td class=\"column column-1\" width=\"100%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 5px; padding-bottom: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"													<table class=\"text_block\" width=\"100%\" border=\"0\" cellpadding=\"20\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n" +
"														<tr>\n" +
"															<td>\n" +
"																<div style=\"font-family: Tahoma, Verdana, sans-serif\">\n" +
"																	<div style=\"font-size: 14px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 16.8px; color: #000000; line-height: 1.2;\">\n" +
"																		<p style=\"margin: 0; font-size: 14px; text-align: center;\"><span style=\"font-size:16px;\"><strong>If you think we made a mistake, reach out to us!</strong></span></p>\n" +
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
"					<table class=\"row row-4\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"						<tbody>\n" +
"							<tr>\n" +
"								<td>\n" +
"									<table class=\"row-content stack\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffffff; color: #000000; width: 680px;\" width=\"680\">\n" +
"										<tbody>\n" +
"											<tr>\n" +
"												<td class=\"column column-1\" width=\"100%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 5px; padding-bottom: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"													<table class=\"text_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n" +
"														<tr>\n" +
"															<td style=\"padding-bottom:10px;padding-left:20px;padding-right:20px;padding-top:30px;\">\n" +
"																<div style=\"font-family: Tahoma, Verdana, sans-serif\">\n" +
"																	<div style=\"font-size: 14px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 16.8px; color: #000000; line-height: 1.2;\">\n" +
"																		<p style=\"margin: 0; font-size: 14px; text-align: center;\"><span style=\"font-size:30px;\"><strong><span style>Trouble reaching your account ? We're here to help!</span></strong></span></p>\n" +
"																	</div>\n" +
"																</div>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"													<table class=\"button_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"														<tr>\n" +
"															<td style=\"padding-bottom:10px;padding-left:10px;padding-right:10px;padding-top:30px;text-align:center;\">\n" +
"																<div align=\"center\">\n" +
"																	<!--[if mso]><v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" href=\"www.example.com\" style=\"height:44px;width:147px;v-text-anchor:middle;\" arcsize=\"46%\" strokeweight=\"0.75pt\" strokecolor=\"#60BB44\" fillcolor=\"#60bb44\"><w:anchorlock/><v:textbox inset=\"0px,0px,0px,0px\"><center style=\"color:#ffffff; font-family:Tahoma, Verdana, sans-serif; font-size:16px\"><![endif]--><a href=\"www.example.com\" target=\"_blank\" style=\"text-decoration:none;display:inline-block;color:#ffffff;background-color:#60bb44;border-radius:20px;width:auto;border-top:1px solid #60BB44;border-right:1px solid #60BB44;border-bottom:1px solid #60BB44;border-left:1px solid #60BB44;padding-top:5px;padding-bottom:5px;font-family:'Lato', Tahoma, Verdana, Segoe, sans-serif;text-align:center;mso-border-alt:none;word-break:keep-all;\"><span style=\"padding-left:20px;padding-right:20px;font-size:16px;display:inline-block;letter-spacing:normal;\"><span style=\"font-size: 16px; line-height: 2; word-break: break-word; mso-line-height-alt: 32px;\"><span style=\"font-size: 16px; line-height: 32px;\" data-mce-style=\"font-size: 16px; line-height: 32px;\"><strong><span style=\"line-height: 32px;\" data-mce-style=\"line-height: 32px;\">CONTACT US</span></strong></span></span></span></a>\n" +
"																	<!--[if mso]></center></v:textbox></v:roundrect><![endif]-->\n" +
"																</div>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"													<table class=\"text_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n" +
"														<tr>\n" +
"															<td style=\"padding-bottom:10px;padding-left:20px;padding-right:20px;padding-top:30px;\">\n" +
"																<div style=\"font-family: Tahoma, Verdana, sans-serif\">\n" +
"																	<div style=\"font-size: 14px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 16.8px; color: #000000; line-height: 1.2;\">\n" +
"																		<p style=\"margin: 0; font-size: 14px; text-align: center;\"><span style=\"font-size:16px;\"><strong>For any questions, email us or call us Monday to Friday 8:30 AM - 5:30 PM</strong></span></p>\n" +
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
"					<table class=\"row row-5\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-position: top center;\">\n" +
"						<tbody>\n" +
"							<tr>\n" +
"								<td>\n" +
"									<table class=\"row-content stack\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #ffffff; color: #000000; width: 680px;\" width=\"680\">\n" +
"										<tbody>\n" +
"											<tr>\n" +
"												<td class=\"column column-1\" width=\"100%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 0px; padding-bottom: 0px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"													<table class=\"html_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"														<tr>\n" +
"															<td style=\"padding-top:10px;\">\n" +
"																<div style=\"font-family:Arial, Helvetica Neue, Helvetica, sans-serif;text-align:center;\" align=\"center\"></div>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"													<table class=\"text_block\" width=\"100%\" border=\"0\" cellpadding=\"10\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\">\n" +
"														<tr>\n" +
"															<td>\n" +
"																<div style=\"font-family: Tahoma, Verdana, sans-serif\">\n" +
"																	<div style=\"font-size: 12px; mso-line-height-alt: 21.6px; color: #000000; line-height: 1.8; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif;\">\n" +
"																		<p style=\"margin: 0; text-align: center; font-size: 14px; mso-line-height-alt: 25.2px;\"><span style=\"font-size:14px;\">Copyright © 2022, EFood.</span></p>\n" +
"																		<p style=\"margin: 0; text-align: center; font-size: 14px; mso-line-height-alt: 25.2px;\"><span style=\"font-size:14px;\">Changed your mind? You can<a href=\"http://www.example.com\" target=\"_blank\" style=\"text-decoration: underline; color: #000000;\" rel=\"noopener\"> unsubscribe</a>&nbsp;at any time.</span></p>\n" +
"																	</div>\n" +
"																</div>\n" +
"															</td>\n" +
"														</tr>\n" +
"													</table>\n" +
"													<table class=\"social_block\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"														<tr>\n" +
"															<td style=\"padding-bottom:30px;padding-left:10px;padding-right:10px;padding-top:10px;text-align:center;\">\n" +
"																<table class=\"social-table\" width=\"144px\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" align=\"center\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"																	<tr>\n" +
"																		<td style=\"padding:0 2px 0 2px;\"><a href=\"https://www.facebook.com/\" target=\"_blank\"><img src=\"https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/t-outline-circle-dark-gray/facebook@2x.png\" width=\"32\" height=\"32\" alt=\"Facebook\" title=\"facebook\" style=\"display: block; height: auto; border: 0;\"></a></td>\n" +
"																		<td style=\"padding:0 2px 0 2px;\"><a href=\"https://www.twitter.com/\" target=\"_blank\"><img src=\"https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/t-outline-circle-dark-gray/twitter@2x.png\" width=\"32\" height=\"32\" alt=\"Twitter\" title=\"twitter\" style=\"display: block; height: auto; border: 0;\"></a></td>\n" +
"																		<td style=\"padding:0 2px 0 2px;\"><a href=\"https://www.linkedin.com/\" target=\"_blank\"><img src=\"https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/t-outline-circle-dark-gray/linkedin@2x.png\" width=\"32\" height=\"32\" alt=\"Linkedin\" title=\"linkedin\" style=\"display: block; height: auto; border: 0;\"></a></td>\n" +
"																		<td style=\"padding:0 2px 0 2px;\"><a href=\"https://www.instagram.com/\" target=\"_blank\"><img src=\"https://app-rsrc.getbee.io/public/resources/social-networks-icon-sets/t-outline-circle-dark-gray/instagram@2x.png\" width=\"32\" height=\"32\" alt=\"Instagram\" title=\"instagram\" style=\"display: block; height: auto; border: 0;\"></a></td>\n" +
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
"					<table class=\"row row-6\" align=\"center\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\">\n" +
"						<tbody>\n" +
"							<tr>\n" +
"								<td>\n" +
"									<table class=\"row-content stack\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #60bb44; color: #000000; width: 680px;\" width=\"680\">\n" +
"										<tbody>\n" +
"											<tr>\n" +
"												<td class=\"column column-1\" width=\"100%\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-top: 5px; padding-bottom: 5px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\">\n" +
"													<div class=\"spacer_block\" style=\"height:40px;line-height:40px;font-size:1px;\">&#8202;</div>\n" +
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
            message.setContent(htmlCode ,"text/html");
            return message;
    }
    
}