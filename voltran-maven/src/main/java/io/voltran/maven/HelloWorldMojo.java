package io.voltran.maven;
 
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * Says "Hello World!" to the user.
 *
 */
@Mojo( name = "say")
public class HelloWorldMojo extends AbstractMojo
{
    /**
     * The greeting to display.
     */

    @Parameter(property = "say.greetings")
    private String greetings;


    public void execute() throws MojoExecutionException
    {
        getLog().info( greetings );
    }

    public String getGreetings() {
        return greetings;
    }
}
