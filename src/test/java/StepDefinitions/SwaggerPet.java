package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import restAssuredPet.Files.payload;

import static io.restassured.RestAssured.given;

public class SwaggerPet {
    public static Response response;
    public ValidatableResponse json;
    public RequestSpecification request;
    public String ENDPOINT = "https://petstore.swagger.io/v2";

    @Then("I check pet id extracted from the newly added pet")
    public static String iCheckPetIdExtractedFromTheNewlyAddedPet() {
        String getPetResponse = response.asString();
        JsonPath js2 = new JsonPath(getPetResponse);
        String getName = js2.getString("id");

        return getName;

    }

    @Then("I check order id extracted from the placed order")
    public static String iCheckOrderIdExtractedFromThePlacedOrder() {
        String getPetResponse = response.asString();
        JsonPath js2 = new JsonPath(getPetResponse);
        String getId = js2.getString("id");
        System.out.println("ddddd" + getId);

        return getId;
    }

    @Given("Add new pet payload {string}")
    public void addNewPetPayload(String petName) {
        RestAssured.baseURI = ENDPOINT;
        request = given().header("Content-Type", "application/json").body(payload.AddNewPet(petName));
    }

    @Then("Api call is success with status code {int}")
    public void apiCallIsSuccessWithStatusCode(int statusCode) {

        Assert.assertEquals(statusCode, response.getStatusCode());
    }

    @When("user calls add new pet api by post http request")
    public void userCallsAddNewPetApiByPostHttpRequest() {
        response = request.when().post("pet");
    }

    @And("Status in response body is {string}")
    public void statusInResponseBodyIs(String status) {
        String getPetResponse = response.asString();
        JsonPath js2 = new JsonPath(getPetResponse);
        String getStatus = js2.getString("status");
        Assert.assertEquals(status, getStatus);
    }

    @And("name in response body is {string}")
    public void nameInResponseBodyIs(String name) {
        String getPetResponse = response.asString();
        JsonPath js2 = new JsonPath(getPetResponse);
        String getName = js2.getString("name");
        Assert.assertEquals(name, getName);
    }

    @Given("I put updated payload {string}")
    public void iPutUpdatedPayload(String petName) {
        RestAssured.baseURI = ENDPOINT;
        request = given().header("Content-Type", "application/json").body(payload.UpdatePet(petName));

    }

    @When("user calls update api by put http request")
    public void userCallsUpdateApiByPutHttpRequest() {
        response = request.when().put("pet");
    }

    @Given("add requirements as parameters {string} {string}")
    public void addRequirementsAsParameters(String username, String password) {
        RestAssured.baseURI = ENDPOINT;
        request = given().queryParam("username", username).queryParam("password", password);
    }

    @When("user calls login api by get http request")
    public void userCallsLoginApiByGetHttpRequest() {
        response = request.when().get("user/login");
    }

    @And("message should include {string}")
    public void messageShouldInclude(String msg) {
        String getPetResponse = response.asString();
        JsonPath js2 = new JsonPath(getPetResponse);
        String getName = js2.getString("message");
        Assert.assertTrue(getName.contains("logged in user session"));
    }

    @When("I log out from the system")
    public void iLogOutFromTheSystem() {
        RestAssured.baseURI = ENDPOINT;
        response = given().when().get("user/logout");
    }

    @When("I delete the added pet")
    public void iDeleteTheAddedPet() {

        String id = iCheckPetIdExtractedFromTheNewlyAddedPet();
        request = given().pathParam("petId", id).header("api_key", "special-key");
        response = request.delete("pet/{petId}");
    }

    @Then("Api call should be with  {int} error code")
    public void apiCallShouldBeWithErrorCode(int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode());
    }

    @When("I place an order for a pet")
    public void iPlaceAnOrderForAPet() {
        String id = iCheckPetIdExtractedFromTheNewlyAddedPet();
        RestAssured.baseURI = ENDPOINT;
        response = given().header("Content-Type", "application/json").body(payload.PlaceOrder(id)).when().post("store/order");

    }

    @And("complete in response body is {string}")
    public void completeInResponseBodyIs(String complete) {
        String getPetResponse = response.asString();
        JsonPath js2 = new JsonPath(getPetResponse);
        String getName = js2.getString("complete");
        Assert.assertEquals(complete, getName);
    }

    @When("I delete the placed order")
    public void iDeleteThePlacedOrder() {
        String id = iCheckOrderIdExtractedFromThePlacedOrder();
        System.out.println("ddddd" + id);
        request = given().pathParam("orderId", id).header("api_key", "special-key");
        response = request.when().delete("store/order/{orderId}");
    }


    @Then("Api response should include that {string}")
    public void apiResponseShouldIncludeThat(String message) {
        String getPetResponse = response.asString();
        JsonPath js2 = new JsonPath(getPetResponse);
        String getMessage = js2.getString("message");
        Assert.assertEquals(message, getMessage);
    }

    @Then("I check to find purchase order which is deleted in the previous step")
    public void iCheckToFindPurchaseOrderWhichIsDeletedInThePreviousStep() {
        String id = iCheckOrderIdExtractedFromThePlacedOrder();
        Assert.assertNull(id);
    }

    @When("I try to find the purchase order by Id")
    public void iTryToFindThePurchaseOrderById() {
        String id = iCheckOrderIdExtractedFromThePlacedOrder();
        RestAssured.baseURI = ENDPOINT;
        response = given().pathParam("orderId", id).when().get("store/order/{orderId}");
    }
}



