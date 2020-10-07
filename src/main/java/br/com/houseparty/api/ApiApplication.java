package br.com.houseparty.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
	
	/*@Bean
	CommandLineRunner init(ProdutoRepositorio repository) {
		return args -> {
			repository.deleteAll();
			LongStream.range(1, 10)
					.mapToObj(i -> {
						Produto c = new Produto("000000000", "produto");
						return c;
					})
					.map(v -> repository.save(v))
					.forEach(System.out::println);
		};
	}*/

}
