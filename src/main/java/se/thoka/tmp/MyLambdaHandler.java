package se.thoka.tmp;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import io.micronaut.context.ApplicationContext;
import io.micronaut.function.aws.proxy.MicronautLambdaHandler;

public class MyLambdaHandler extends MicronautLambdaHandler {

  public MyLambdaHandler() throws ContainerInitializationException {
    super(ApplicationContext.builder().eagerInitSingletons(true));
  }

}
