package restapi.config;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.fasterxml.jackson.annotation.*;

@Provider
public class JacksonConfig implements  ContextResolver<ObjectMapper> {
	private final ObjectMapper objectMapper;

    public JacksonConfig() throws Exception
    {
        objectMapper = new ObjectMapper()
                .disable( SerializationFeature.WRITE_DATES_AS_TIMESTAMPS )
                .disable( SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS )
                .setSerializationInclusion( JsonInclude.Include.NON_NULL )
                .registerModule( new JSR310Module() );
        		
//        		new ObjectMapper.configure(
//                           SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    @Override
    public ObjectMapper getContext(Class<?> arg0)
    {
        return objectMapper;
    }
}
