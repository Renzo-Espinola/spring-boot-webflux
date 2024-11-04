package com.bolsadeideas.springboot.webflux.app.controller;

import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.spring6.context.webflux.ReactiveDataDriverContextVariable;
import com.bolsadeideas.springboot.webflux.app.models.documents.Producto;
import com.bolsadeideas.springboot.webflux.app.service.ProductoService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class ProductoController {
	@Autowired
	private ProductoService service;
	
	private static Logger log = LoggerFactory.getLogger(ProductoController.class);
	
	@GetMapping({"/listar","/"})
	public Mono<String> listar (Model model) {
		Flux<Producto> productos = service.findAllConNombreUpperCase();
		productos.subscribe(prod -> log.info(prod.getNombre()));
		model.addAttribute("productos", productos);
		model.addAttribute("titulo", "Listado de productos");
		return Mono.just("listar");
	}
	
	@GetMapping("/form")
	public Mono<String> crear(Model model){
		model.addAttribute("producto", new Producto());
		model.addAttribute("titulo", "Formulario de producto");
		return Mono.just("form");
	}
	
	@PostMapping("/form")
	public Mono<String> guardar(Producto producto){
		return service.save(producto).doOnNext(prod -> {
			log.info("Producto guardado: "+ prod.getNombre() + " Id: "+ prod.getId());	
		}).thenReturn("redirect:/listar");
	}
	
	@GetMapping("/listar-datadriver")
	public String listarDataDriver (Model model) {
		//Manera para trabajar con la contraprsion
		// le damos el tamaño del buffer a procesar por cantidad de elementos
		Flux<Producto> productos = service.findAllConNombreUpperCase().delayElements(Duration.ofSeconds(1));
		productos.subscribe(prod -> log.info(prod.getNombre()));
		model.addAttribute("productos", new ReactiveDataDriverContextVariable(productos,2));
		model.addAttribute("titulo", "Listado de productos");
		return "listar";
	}
	
	@GetMapping("/listar-full")
	public String listarFull (Model model) {
		//Manera para trabajar con la contraprsion
		// le damos el tamaño del buffer a procesar por cantidad de elementos
		Flux<Producto> productos = service.findAllConNombreUpperCaseRepeat();
		model.addAttribute("productos", productos);
		model.addAttribute("titulo", "Listado de productos");
		return "listar";
	}
	
	@GetMapping("/listar-chunked")
	public String listarChunked (Model model) {
		//Manera para trabajar con la contraprsion
		// le damos el tamaño del buffer a procesar por cantidad de elementos
		Flux<Producto> productos = service.findAllConNombreUpperCaseRepeat();
		model.addAttribute("productos", productos);
		model.addAttribute("titulo", "Listado de productos");
		return "listar-chunked";
	}
}
