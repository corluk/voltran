package io.voltran.maven;
 
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * Says "Hello World!" to the user.
 *
 */
@Mojo( name = "voltran")
public class VoltranMojo extends AbstractMojo
{
    /**
     * The module-path to locate modules.
     */

    @Parameter(property = "voltran.module-path", required = true, readonly = true)
    private String modulePath;


    public void execute() throws MojoExecutionException
    {
        if (modulePath == null) {
            throw new MojoExecutionException( "module-path configuration must be defined." );
        }

        getLog().info( "Module path :" + modulePath );

    }

    public String getModulePath() {
        return modulePath;
    }
}
