package tech.ivery.BowtieStore.RepoTests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import tech.ivery.BowtieStore.exceptions.UserNotFoundException;
import tech.ivery.BowtieStore.models.User;
import tech.ivery.BowtieStore.repositories.UserRepo;
@DataJpaTest
class UserRepoTest {
	@Autowired
	private UserRepo uRepo;
	@Test
	void test() {
		//given
		//when
		User result = new User();
		System.out.println(result);
		try {
		 result =	uRepo.getUserById(1);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//then
		Assertions.assertThat(result.getId()).isEqualTo(1);
	}

}
