package br.com.houseparty.api.model;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente extends Usuario{

	public Cliente() {}
}
