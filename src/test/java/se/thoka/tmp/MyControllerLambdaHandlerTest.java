package se.thoka.tmp;

import static org.assertj.core.api.Assertions.assertThat;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.model.AwsProxyResponse;
import io.micronaut.http.HttpStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class MyControllerLambdaHandlerTest {

  MyLambdaHandler unitUnderTest;

  @BeforeEach
  void beforeEach() throws ContainerInitializationException {
    unitUnderTest = new MyLambdaHandler();
  }

  @AfterEach
  void afterEach() {
    unitUnderTest.close();
  }

  /**
   * Same test case as {@link MyControllerMicronautTest#getStatusMutableHttpResponse_ShouldReturn202Accepted()}
   */
  @Test
  @Disabled("Expected: 202 Accepted, Actual: 200 OK")
  void getStatusMutableHttpResponse_ShouldReturn202Accepted() {
    // Given
    AwsProxyRequest request = new AwsProxyRequest();
    request.setHttpMethod("GET");
    request.setPath("/test/status-mutable-http-response");

    // When
    AwsProxyResponse response = unitUnderTest.handleRequest(request, null);

    // Then
    assertThat(response.getBody()).isEqualTo("Testing getStatusMutableHttpResponse");
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.ACCEPTED.getCode());
  }

  /**
   * Same test case as {@link MyControllerMicronautTest#getStatusHttpResponse_ShouldReturn202Accepted()}
   */
  @Test
  @Disabled("Expected: 202 Accepted, Actual: 200 OK")
  void getStatusHttpResponse_ShouldReturn202Accepted() {
    // Given
    AwsProxyRequest request = new AwsProxyRequest();
    request.setHttpMethod("GET");
    request.setPath("/test/status-http-response");

    // When
    AwsProxyResponse response = unitUnderTest.handleRequest(request, null);

    // Then
    assertThat(response.getBody()).isEqualTo("Testing getStatusHttpResponse");
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.ACCEPTED.getCode());
  }

  @Test
  void getAnnotatedStatus_ShouldReturn202Accepted() {
    // Given
    AwsProxyRequest request = new AwsProxyRequest();
    request.setHttpMethod("GET");
    request.setPath("/test/status-annotated");

    // When
    AwsProxyResponse response = unitUnderTest.handleRequest(request, null);

    // Then
    assertThat(response.getBody()).isEqualTo("Testing getStatusAnnotated");
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.ACCEPTED.getCode());
  }

}