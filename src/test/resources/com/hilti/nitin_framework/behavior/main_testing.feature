Feature: Framework is able to test messaging
  Scenario: Testing of a producer by the framework
    Given I have a Kafka producer of topic "test_topic1"
    When I setup the Manager of Framework with Tech "Kafka", topic "test_topic1"
    And I start consumer of the Manager of Framework
    And I publish a message "Test Message 1" with my producer
    Then I validate that message "Test Message 1" is consumed by Manager of Framework

  Scenario: Testing of a consumer by the framework
    Given I have a Kafka consumer of topic "test_topic1"
    When I setup the Manager of Framework with Tech "Kafka", topic "test_topic1"
    And I start my consumer
    And I publish a message "Test Message 1" with Manager of Framework
    And I save the message my consumer received
    Then I validate that my saved message was produced by Manager of Framework