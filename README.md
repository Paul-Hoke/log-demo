# Log Demo Project
The purpose of this project is to demonstrate an API enpoint that accepts a string (message) parameter that is then parsed for various PII information, masks any sensetive data it finds, then logs and returnes the sanitized input to the requestor.

In this example we are scanning for various known credit card patterns.  We use a regex to find these.  When logging we leverage the ability for logback to display 'markers'.  We apply specific markers when we see any input we think contains PII.  These markers can be leveraged by the various log aggregation services like Kibana / Datadog / Splunk to easily find any message that has had to be sanitized without having to parse the entire log message for the masked input.

## Project Setup
### Java Version: 21
### Maven Version: 3.8.7
This project should be able to be run successfully and accessed via localhost on port 8080 without any additional configuration

## Run the project
`mvn clean spring-boot:run`

## Access the API
http://localhost:8080/logMessage?message=Some%20test%20Message

## Test the project
`mvn clean test`

For ease of use I have included the word 'test' to be masked.  See the tests for other CC numbers that will also be masked.

## Room for improvement
* A more robust solution may be to create our own log appender instead of relying on markers if our masking process needs to be more complex.
* Come up with some strategies to better identify PII data that doesn't follow a consistent pattern that can be found via regex
* Implement some authentication layer, I was not able to include that with the limited time on this project
* Add swagger documentation
