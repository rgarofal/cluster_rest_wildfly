package restapi.rs;

import java.util.HashSet;
import java.util.Set;

import javax.faces.annotation.ApplicationMap;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import restapi.config.JacksonConfig;

//[rg] Con questa annotazione non serve specificare l'entry point dei servizi REST sul web.xml
//     Questa classe permette di registare e caricare le classi che poi verranno usate 
@ApplicationPath("/cluapi")
public class APICluster extends Application{
	@Override
	public Set<Class<?>> getClasses() {
         Set<Class <?>> set = new HashSet<>(2);
         // Provider per gestire mappaggio Messaggi in JSON 
         set.add(JacksonConfig.class);
         set.add (ClusterResource.class);
         return set;
	}
}
