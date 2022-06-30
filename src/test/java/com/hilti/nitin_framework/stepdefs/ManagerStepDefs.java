package com.hilti.nitin_framework.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManagerStepDefs {

    @Given("I have a Kafka producer of topic {string}")
    public void i_have_a_Kafka_producer_of_topic(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I setup the Manager of Framework with Tech {string}, topic {string}")
    public void i_setup_the_Manager_of_Framework_with_Tech_topic(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I start consumer of the Manager of Framework")
    public void i_start_consumer_of_the_Manager_of_Framework() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I publish a message {string} with my producer")
    public void i_publish_a_message_with_my_producer(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("I validate that message {string} is consumed by Manager of Framework")
    public void i_validate_that_message_is_consumed_by_Manager_of_Framework(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



    // scenario 2
    @Given("I have a Kafka consumer of topic {string}")
    public void i_have_a_Kafka_consumer_of_topic(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I start my consumer")
    public void i_start_my_consumer() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I publish a message {string} with Manager of Framework")
    public void i_publish_a_message_with_Manager_of_Framework(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I save the message my consumer received")
    public void i_save_the_message_my_consumer_received() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("I validate that my saved message was produced by Manager of Framework")
    public void i_validate_that_my_saved_message_was_produced_by_Manager_of_Framework() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
