package se.thoka.tmp;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Status;
import io.micronaut.http.simple.SimpleHttpResponseFactory;

@Controller("/test")
public class MyController {

  @Get("/status-mutable-http-response")
  public MutableHttpResponse<String> getStatusMutableHttpResponse() {
    return new SimpleHttpResponseFactory()
        .status(HttpStatus.ACCEPTED)
        .body("Testing getStatusMutableHttpResponse");
  }

  @Get("/status-http-response")
  public HttpResponse<String> getStatusHttpResponse() {
    return HttpResponse.status(HttpStatus.ACCEPTED)
        .body("Testing getStatusHttpResponse");
  }

  @Get("/status-annotated")
  @Status(HttpStatus.ACCEPTED)
  public String getStatusAnnotated() {
    return "Testing getStatusAnnotated";
  }

}
