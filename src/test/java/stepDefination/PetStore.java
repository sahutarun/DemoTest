package stepDefination;

import static org.hamcrest.Matchers.is;

import endpoints.PetEndpoint;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.ValidatableResponse;
import models.PetEntity;
import net.thucydides.core.annotations.Steps;

public class PetStore {

	@Steps
	protected PetEndpoint petEndpoint;

	@Given("user add a new pet in pet store and check if a pet is added")
	public void user_add_a_new_pet_in_pet_store() {
		int petId = 5;
		PetEntity petEntity = new PetEntity(petId, "MyNewPet", "available");
		ValidatableResponse response = petEndpoint
				.createPet(petEntity)
				.then().statusCode(200)
				.and().body("id", is(petId)).and().body("name", is("MyNewPet"));
	}

	@Given("user update the status of the pet as {string}")
	public void user_update_the_status_of_the_pet_as(String status) {
		int petId = 5;
		PetEntity petEntity = new PetEntity(petId, "MyNewPet", status);
		ValidatableResponse response = petEndpoint
				.updatePet(petEntity)
				.then().statusCode(200)
				.and().body("id", is(petId))
				.and().body("name", is("MyNewPet"))
				.and().body("status", is(status));
	}

	@When("user delete the pet from the store")
	public void user_delete_the_pet_from_the_store() {
		int petId = 5;
		ValidatableResponse response = petEndpoint
				.deletePet(petId)
				.then().statusCode(200);
	}

	@Then("pet should be deleted")
	public void pet_should_be_deleted() {
		 petEndpoint
         .getPetById(5)
         .then().statusCode(404);
	}


}
