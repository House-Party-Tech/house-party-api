package br.com.houseparty.api;

import java.util.stream.LongStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.houseparty.api.model.produto.Categoria;
import br.com.houseparty.api.repositorios.CategoriaRepositorio;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
	
	/*@Bean
	CommandLineRunner init(CategoriaRepositorio repositorio) {
		return args -> {
			repositorio.deleteAll();
			LongStream.range(1, 11)
				.mapToObj(i -> {
					Categoria cat = new Categoria("categoria " + i);
					return cat;
				})
				.map(v -> repositorio.save(v))
				.forEach(System.out::println);
		};
	}*/

}
