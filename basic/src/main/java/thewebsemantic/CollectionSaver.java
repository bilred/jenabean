package thewebsemantic;

import java.util.Collection;

import thewebsemantic.lazy.Lazy;

import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;

public class CollectionSaver extends Saver {

	@Override
	public void save(Bean2RDF writer, Resource subject, Property property, Object o) {
		if (o instanceof Lazy) {
			Lazy lazy = (Lazy)o;
			if (! lazy.isConnected())
				return;
			else if (! lazy.modified() )
				return;
		}	
		writer.updateCollection(subject, property, (Collection<Object>)o);
	}

}