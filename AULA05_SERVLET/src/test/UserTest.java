package test;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import model.User;
import service.UserService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserTest {
	User user, copia;
	UserService userService;
	static int id = 0;

	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco nenhuma
	 * linha com o id igual ao do escolhido para o to instanciado abaixo. Se
	 * houver, delete. 
	 * Certifique-se também que sobrecarregou o equals na classe
	 * Cliente. 
	 * Certifique-se que a fixture cliente1 foi criada no banco.
	 * Além disso, a ordem de execução dos testes é importante; por
	 * isso a anotação FixMethodOrder logo acima do nome desta classe
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		user = new User();
		user.setId(id);
		user.setPlate("201502920");
		user.setName("Monica Gomes");
		user.setCpf("41251478965");
		user.setRg("21452367");
		user.setAddress("Rua Teste");
		user.setPhone("(11) 91234-4321");
		user.setEmail("monica.gomes@usjt.com.br");
		user.setFunction("Atendente");
		user.setGroup("1");
		copia = new User();
		copia.setId(id);
		copia.setPlate("201502920");
		copia.setName("Monica Gomes");
		copia.setCpf("41251478965");
		copia.setRg("21452367");
		copia.setAddress("Rua Teste");
		copia.setPhone("(11) 91234-4321");
		copia.setEmail("monica.gomes@usjt.com.br");
		copia.setFunction("Atendente");
		copia.setGroup("1");
		userService = new UserService();
		System.out.println(user);
		System.out.println(copia);
		System.out.println(id);
	}
	
	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		User fixture = new User();
		fixture.setId(1);
		//copia.setId(id);
		fixture.setPlate("201502920");
		fixture.setName("Monica Gomes");
		fixture.setCpf("41251478965");
		fixture.setRg("21452367");
		fixture.setAddress("Rua Teste");
		fixture.setPhone("(11) 91234-4321");
		fixture.setEmail("monica.gomes@usjt.com.br");
		fixture.setFunction("Atendente");
		fixture.setGroup("1");
		UserService novoService = new UserService();
		User novo = novoService.carregar(1);
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Criar() {
		System.out.println("criar");
		id = userService.criar(user);
		System.out.println(id);
		copia.setId(id);
		assertEquals("testa criacao", user, copia);
	}

	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		user.setPhone("11111111");
		copia.setPhone("11111111");		
		userService.atualizar(user);
		user = userService.carregar(user.getId());
		assertEquals("testa atualizacao", user, copia);
	}

	@Test
	public void test03Excluir() {
		System.out.println("excluir");
		copia.setId(1);
		copia.setPlate(null);
		copia.setName(null);
		copia.setCpf(null);
		copia.setRg(null);
		copia.setAddress(null);
		copia.setPhone(null);
		copia.setEmail(null);
		copia.setFunction(null);
		copia.setGroup(null);
		userService.excluir(id);
		user = userService.carregar(id);
		assertEquals("testa exclusao", user, copia);
	}
}