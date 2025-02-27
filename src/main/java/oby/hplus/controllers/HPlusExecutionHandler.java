package oby.hplus.controllers;




import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.graphql.execution.ErrorType;
import org.springframework.stereotype.Component;



@Component
public class HPlusExecutionHandler extends DataFetcherExceptionResolverAdapter {
    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
       ErrorType error = null;
       
       if (ex instanceof DataIntegrityViolationException) {
            error = ErrorType.BAD_REQUEST;
       }else {
           error = ErrorType.INTERNAL_ERROR;
       }
       return GraphqlErrorBuilder.newError(env)
               .errorType(error)
               .message("Recivied Message"+ ex.getMessage())
               .build();
    }
}
