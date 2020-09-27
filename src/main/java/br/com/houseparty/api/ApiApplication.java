package br.com.houseparty.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
	
	/*@Bean
	CommandLineRunner init(UsuarioRepositorio repository) {
		return args -> {
			repository.deleteAll();
			LongStream.range(1, 2)
					.mapToObj(i -> {
						Cliente c = new Cliente();
						c.setCpf("111111111");
						c.setEmail("teste@teste.com");
						c.setNome("teste");
						c.setNome_usuario("teste Usuario");
						c.setSenha("123");
						c.setTelefone("40028922");
						return c;
					})
					.map(v -> repository.save(v))
					.forEach(System.out::println);
		};
	}*/

}
