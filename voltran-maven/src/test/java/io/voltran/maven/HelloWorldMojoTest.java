package io.voltran.maven;

import org.apache.maven.plugin.testing.AbstractMojoTestCase;
import org.junit.Test;

import java.io.File;

public class HelloWorldMojoTest
        extends AbstractMojoTestCase
{
    /** {@inheritDoc} */
    protected void setUp()
            throws Exception
    {
        // required
        super.setUp();

    }

    /** {@inheritDoc} */
    protected void tearDown()
            throws Exception
    {
        // required
        super.tearDown();

    }

    /**
     * @throws Exception if any
     */
    @Test
    public void testSomething()
            throws Exception
    {

        File testPom = getTestFile(
                                 "src/test/resources/unit/project-to-test/pom.xml" );
        assertNotNull( testPom );
        assertTrue( testPom.exists() );

        HelloWorldMojo myMojo = (HelloWorldMojo) lookupMojo( "say", testPom );
        assertNotNull( myMojo );
        myMojo.execute();
    }

    /**
     * @throws Exception if any
     */
    @Test
    public void testLoadingGreetingsParameter()
            throws Exception
    {

        File testPom = getTestFile(
                "src/test/resources/unit/project-to-test/pom.xml" );
        assertNotNull( testPom );
        assertTrue( testPom.exists() );

        HelloWorldMojo myMojo = (HelloWorldMojo) lookupMojo( "say", testPom );
        assertNotNull( myMojo );

        myMojo.execute();
        assertEquals("Hello, JUG Istanbul!", myMojo.getGreetings());
    }
}