package com.github.kongchen.swagger.docgen.mavenplugin;

import com.github.kongchen.swagger.docgen.AbstractDocumentSource;
import com.github.kongchen.swagger.docgen.reader.AEMReader;
import com.google.common.collect.Sets;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.logging.Log;

import javax.ws.rs.Path;
import java.util.Set;

/**
 * @author chekong
 * 05/13/2013
 */
public class AemMavenDocumentSource extends AbstractDocumentSource<AEMReader> {

    public AemMavenDocumentSource(ApiSource apiSource, Log log, String encoding) throws MojoFailureException {
        super(log, apiSource, encoding);
    }

    @Override
    protected Set<Class<?>> getValidClasses() {
        return Sets.union(
                super.getValidClasses(),
                apiSource.getValidClasses(Path.class));
    }

    @Override
    protected AEMReader createReader() {
        return new AEMReader(swagger, LOG);
    }
}

