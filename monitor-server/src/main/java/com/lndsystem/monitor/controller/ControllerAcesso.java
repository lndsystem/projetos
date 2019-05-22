package com.lndsystem.monitor.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lndsystem.monitor.entities.DadosServidor;
import com.lndsystem.monitor.entities.EnderecoMonitor;
import com.lndsystem.monitor.entities.Perfil;
import com.lndsystem.monitor.entities.Servidor;
import com.lndsystem.monitor.repository.DadosServidorRepository;
import com.lndsystem.monitor.repository.EnderecoMonitorRepository;
import com.lndsystem.monitor.repository.PerfilRepository;
import com.lndsystem.monitor.repository.ServidorRepository;

@Controller
@RequestMapping({ "/app" })
public class ControllerAcesso {
	@Autowired
	private PerfilRepository perfilRep;
	@Autowired
	private EnderecoMonitorRepository enderecoMonitorRep;
	@Autowired
	private DadosServidorRepository dadosServidorRep;
	@Autowired
	private ServidorRepository servidorRepository;

	@RequestMapping({ "", "/selecaoperfil" })
	public ModelAndView selecaoperfil() {
		List<Perfil> listPerfis = this.perfilRep.findAll();

		ModelAndView mv = new ModelAndView("selecaoperfil");
		mv.addObject("listPerfil", listPerfis);
		return mv;
	}

	@RequestMapping({ "/selecaoperfil/{idperfil}" })
	@ResponseBody
	public ResponseEntity<List<EnderecoMonitor>> selecaoEnderecos(@PathVariable("idperfil") Integer idPerfil) {
		List<EnderecoMonitor> listEndereco = this.enderecoMonitorRep.findAllByPerfilId(idPerfil);

		return ResponseEntity.status(HttpStatus.OK).body(listEndereco);
	}

	@RequestMapping(value = { "/monitor" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public ModelAndView monitor(HttpServletRequest param) {
		String strPerdil = param.getParameter("idPerfil");
		List<EnderecoMonitor> listEndereco = new ArrayList<>();
		if (strPerdil != null) {
			Integer idPerfil = Integer.valueOf(Integer.parseInt(param.getParameter("idPerfil")));
			System.out.println("IDPERFIL -> " + idPerfil);
			listEndereco = this.enderecoMonitorRep.findAllByPerfilId(idPerfil);
		}

		ModelAndView mv = new ModelAndView("monitor");
		mv.addObject("listEndereco", listEndereco);
		return mv;
	}

	@RequestMapping(value = { "/monitorserver" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.GET })
	public ModelAndView monitorServidor(HttpServletRequest param) {
		Collection<Servidor> servidorCollection = new ArrayList<>();

		String strIdPerfil = param.getParameter("idPerfil");
		if (strIdPerfil != null) {
			Integer idPerfil = Integer.valueOf(Integer.parseInt(strIdPerfil));

			System.out.println("IDPERFIL -> " + idPerfil);

			Optional<Perfil> perfil = this.perfilRep.findById(idPerfil);

			servidorCollection =  perfil.get().getServidorCollection();
			
		}
		servidorCollection = servidorRepository.findAll();

		ModelAndView mv = new ModelAndView("monitorserver");
		mv.addObject("servidorCollection", servidorCollection);
		return mv;
	}

	@RequestMapping(value = { "/monitorserver/result" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.GET })
	@ResponseBody
	public String monitorServidorBusca(HttpServletRequest param) {
		Integer idServidor = Integer.valueOf(Integer.parseInt(param.getParameter("idServidor")));

		System.out.println("idServidor -> " + idServidor);

		List<DadosServidor> listDadosServidor = this.dadosServidorRep
				.findTop50ByIdServidorOrderByDataDesc(Long.valueOf(idServidor.longValue()));

		ObjectMapper objectMapper = new ObjectMapper();

		String arrayToJson = "{}";
		try {
			arrayToJson = objectMapper.writeValueAsString(listDadosServidor);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return arrayToJson;
	}
}
