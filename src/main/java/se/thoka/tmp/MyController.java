package se.thoka.tmp;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.annotation.Status;

@Controller("/test")
public class MyController {

  @Produces(MediaType.TEXT_PLAIN)
  @Get("/status-mutable-http-response")
  public MutableHttpResponse<String> getStatusMutableHttpResponse() {
    return HttpResponse.status(HttpStatus.ACCEPTED)
        .body("Testing getStatusMutableHttpResponse");
  }

  @Produces(MediaType.TEXT_PLAIN)
  @Get("/status-http-response")
  public HttpResponse<String> getStatusHttpResponse() {
    return HttpResponse.status(HttpStatus.ACCEPTED)
        .body("Testing getStatusHttpResponse");
  }

  @Produces(MediaType.TEXT_PLAIN)
  @Get("/status-annotated")
  @Status(HttpStatus.ACCEPTED)
  public String getStatusAnnotated() {
    return "Testing getStatusAnnotated";
  }

}
