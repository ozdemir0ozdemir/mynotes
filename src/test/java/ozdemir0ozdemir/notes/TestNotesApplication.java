package ozdemir0ozdemir.notes;

import org.springframework.boot.SpringApplication;

public class TestNotesApplication {

	public static void main(String[] args) {
		SpringApplication.from(NotesApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
