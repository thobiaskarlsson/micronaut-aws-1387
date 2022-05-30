package se.thoka.tmp;

import static org.assertj.core.api.Assertions.assertThat;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpMethod;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MutableHttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

@MicronautTest
class MyControllerMicronautTest {

  @Inject
  @Client("/")
  HttpClient client;

  @Test
  void getStatusMutableHttpResponse_ShouldReturn202Accepted() {
    // Given
    MutableHttpRequest<Object> request = HttpRequest.create(HttpMethod.GET, "/test/status-mutable-http-response");

    // When
    HttpResponse<String> response = client.toBlocking().exchange(request, Argument.of(String.class));

    // Then
    assertThat(response.getBody()).hasValue("Testing getStatusMutableHttpResponse");
    assertThat(response.getStatus().getCode()).isEqualTo(HttpStatus.ACCEPTED.getCode());
  }

  @Test
  void getStatusHttpResponse_ShouldReturn202Accepted() {
    // Given
    MutableHttpRequest<Object> request = HttpRequest.create(HttpMethod.GET, "/test/status-http-response");

    // When
    HttpResponse<String> response = client.toBlocking().exchange(request, Argument.of(String.class));

    // Then
    assertThat(response.getBody()).hasValue("Testing getStatusHttpResponse");
    assertThat(response.getStatus().getCode()).isEqualTo(HttpStatus.ACCEPTED.getCode());
  }

  @Test
  void getAnnotatedStatus_ShouldReturn202Accepted() {
    // Given
    MutableHttpRequest<Object> request = HttpRequest.create(HttpMethod.GET, "/test/status-annotated");

    // When
    HttpResponse<String> response = client.toBlocking().exchange(request, Argument.of(String.class));

    // Then
    assertThat(response.getBody()).hasValue("Testing getStatusAnnotated");
    assertThat(response.getStatus().getCode()).isEqualTo(HttpStatus.ACCEPTED.getCode());
  }
}
