package br.com.fiap.g1.eventos.comunicacao.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.g1.eventos.comunicacao.domain.Email;
import br.com.fiap.g1.eventos.comunicacao.service.MailService;

@RestController
@RequestMapping(value = "/email")
public class SendMailController {

	Properties props = new Properties();

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:ss");

	@Autowired
	private MailService mailService;

	@RequestMapping(method = RequestMethod.POST)
	public String sendMail(@RequestBody Email email)

	{
		StringBuilder sb = new StringBuilder();

		sb.append("Prezado cliente " + email.getNomeCliente());
		sb.append("\n\nO seu cadastro foi efetuado com sucesso. \n\n\n");
		sb.append("São Paulo, " + sdf.format(new Date(System.currentTimeMillis())));

		String msg = sb.toString();

		mailService.sendMail(props.getProperty("spring.mail.username"), email.getEmail(), "Confirmação de cadastro",
				msg);

		return "Email enviado";
	}
}
