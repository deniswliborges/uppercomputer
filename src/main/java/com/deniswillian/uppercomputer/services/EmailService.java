package com.deniswillian.uppercomputer.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.deniswillian.uppercomputer.domain.Equipe;
import com.deniswillian.uppercomputer.domain.Funcionario;



public interface EmailService {
void sendOrderConfirmationEmail(Equipe obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendOrderConfirmationHtmlEmail(Equipe obj);
	
	void sendHtmlEmail(MimeMessage msg);
	
	void sendNewPasswordEmail(Funcionario funcionario, String newPass);
}

