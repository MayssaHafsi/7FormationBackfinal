package com.projet.formationCertification.controller;


import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin
public class EmailController {
	public JavaMailSender jms  ;
	
	@Autowired
	public  EmailController(JavaMailSender jms) {

		this.jms = jms;
	} 
	
	@RequestMapping("/envoiMail" )
	@ExceptionHandler(Exception.class)
	public void envoyer(@RequestParam("to") String to , @RequestParam("text") String  text, @RequestParam("objet") String  ob) throws AddressException, MessagingException, IOException {
		SimpleMailMessage mail=new SimpleMailMessage();
		mail.setTo(to);
		mail.setFrom("bakoufarine@gmail.com");
		mail.setSubject(ob);
		mail.setText(text);
		jms.send(mail);
	}
		
	@RequestMapping("/envoie" )
	@ExceptionHandler(Exception.class)
	public void envoyerMail(@RequestParam("to") String to , @RequestParam("text") String  text, @RequestParam("objet") String  ob) throws AddressException, MessagingException, IOException {
		SimpleMailMessage mail=new SimpleMailMessage();
		mail.setTo(to);
		mail.setFrom("amirahajkacem123@gmail.com");
		mail.setSubject(ob);
		mail.setText(text);
		jms.send(mail);



	

	
		
		
}

}
