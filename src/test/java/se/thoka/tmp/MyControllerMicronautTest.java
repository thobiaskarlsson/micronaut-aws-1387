package se.thoka.tmp;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@MicronautTest
class MyControllerMicronautTest {

  @Inject
  @Client("/")
  HttpClient client;

  @Test
  void getStatusMutableHttpResponse_ShouldReturn202Accepted() {
    // Given
    HttpRequest<?> request = HttpRequest.GET("/test/status-mutable-http-response").accept(MediaType.TEXT_PLAIN);

    // When
    HttpResponse<String> response = client.toBlocking().exchange(request, Argument.of(String.class));

    // Then
    assertThat(response.getStatus().getCode()).isEqualTo(HttpStatus.ACCEPTED.getCode());
    assertTrue(response.getBody().isPresent());
    assertEquals("Testing getStatusMutableHttpResponse", response.getBody().get());
  }

  @Test
  void getStatusHttpResponse_ShouldReturn202Accepted() {
    // Given
    HttpRequest<?> request = HttpRequest.GET("/test/status-http-response").accept(MediaType.TEXT_PLAIN);

    // When
    HttpResponse<String> response = client.toBlocking().exchange(request, Argument.of(String.class));

    // Then
    assertEquals(response.getStatus().getCode(), HttpStatus.ACCEPTED.getCode());
    assertTrue(response.getBody().isPresent());
    assertEquals("Testing getStatusHttpResponse", response.getBody().get());

  }

  @Test
  void getAnnotatedStatus_ShouldReturn202Accepted() {
    // Given
    HttpRequest<?> request = HttpRequest.GET("/test/status-annotated").accept(MediaType.TEXT_PLAIN);

    // When
    HttpResponse<String> response = client.toBlocking().exchange(request, Argument.of(String.class));

    // Then
    assertEquals(response.getStatus().getCode(), HttpStatus.ACCEPTED.getCode());
    assertTrue(response.getBody().isPresent());
    assertEquals("Testing getStatusAnnotated", response.getBody().get());
  }
}
