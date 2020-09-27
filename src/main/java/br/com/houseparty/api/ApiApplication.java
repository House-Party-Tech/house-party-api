package br.com.houseparty.api;

<<<<<<< HEAD
import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
=======
import java.util.stream.LongStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.houseparty.api.model.Cliente;
import br.com.houseparty.api.repositorios.ClienteRepositorio;
>>>>>>> 55f4850d7c19d1344f4e0bf6afaa43938622af6d

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
	
<<<<<<< HEAD
    @Bean
    public DataSource dataSource() {
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
    	dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    	dataSource.setUrl("jdbc:mysql://localhost:3306/House_Party");
    	dataSource.setUsername("root");
    	dataSource.setPassword("1234");
    	return dataSource;
    }
=======
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

>>>>>>> 55f4850d7c19d1344f4e0bf6afaa43938622af6d
}
