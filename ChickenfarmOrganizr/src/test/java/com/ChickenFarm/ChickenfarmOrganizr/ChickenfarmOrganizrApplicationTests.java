package com.ChickenFarm.ChickenfarmOrganizr;

import com.ChickenFarm.ChickenfarmOrganizr.controller.CreateChickenController;
import com.ChickenFarm.ChickenfarmOrganizr.data.CreateChickenDTO;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
class ChickenfarmOrganizrApplicationTests {

	@Autowired
	CreateChickenController createChickenController;

		@Test
		void InsertTest() throws JSONException {


			int id = 0 ;
			String chickenName = "Ali Chicken";
			LocalDate chickenDateOfBirth = LocalDate.of( 2023, 6, 5);
			String chickenGender = "Alex Gender";
			String chickenRace = "alexrace";
			LocalDate chickenDateOfDeath = null;
            int groupId = 43;

			CreateChickenDTO createChickenDTO = new CreateChickenDTO(
					id,
					chickenName,
					chickenDateOfBirth,
					chickenGender,
					chickenRace, chickenDateOfDeath,
					groupId
			);

			createChickenController.add(createChickenDTO);

			List<CreateChickenDTO> createChickenDTOGetList = createChickenController.get();


	}

	@Test
	void t() {
		Object[][] args = new Object[][] {
				{21, "str"},
				{22, "str"},
				{23, "str"},
				{24, "str"}
		};
		for (int i = 0; i < args.length; i++) {
			// 10 times entered
			run(args[i]);
		}
	}
	int i = 21;
	void run(Object[] args) {
		int id = (int) args[0];

		String somethingElse = (String) args[1];

		assert id ==  i;
		assert somethingElse.equals("str");
		i++;
	}



	private static Stream<Arguments> paramT() {
		return Stream.of(
				Arguments.of(1, "str"),
				Arguments.of(21, "str"),
				Arguments.of(42, "str"),
				Arguments.of("21", "str2")
		);
	}
	@ParameterizedTest
	@MethodSource
	void paramT(int id, String somethingElse) {
		// given
		// passed arguments (preparedChicken = create chicken)

		// when
		// no execution (save(chicken)

		// then
		// load chicken.equals(preparedChicken)
		assert id == 21;
		assert somethingElse.equals("str");
	}
}
