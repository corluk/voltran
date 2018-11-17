package io.voltran.maven;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.testing.AbstractMojoTestCase;
import org.junit.Test;

import java.io.File;
import java.lang.management.MemoryPoolMXBean;

public class VoltranMojoTest
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

    @Test
    public void test_should_be_executed()
            throws Exception
    {

        File testPom = getTestFile(
                                 "src/test/resources/unit/project-to-test/pom.xml" );
        assertNotNull( testPom );
        assertTrue( testPom.exists() );

        VoltranMojo voltran = (VoltranMojo) lookupMojo("voltran", testPom);
        assertNotNull( voltran );
        voltran.execute();
    }


    @Test
    public void test_should_set_context_path_param()
            throws Exception
    {
        // Given
        File testPom = getTestFile(
                "src/test/resources/unit/project-to-test/pom.xml" );
        VoltranMojo voltranMojo = (VoltranMojo) lookupMojo("voltran", testPom);

        // When
        voltranMojo.execute();

        // Then
        assertEquals("/voltran/module-path", voltranMojo.getModulePath());
    }

    @Test
    public void test_should_throw_MojoExecutionException_if_no_modulepath_defined() throws Exception
    {
        // Given
        MojoExecutionException exception = null;
        File testPom = getTestFile(
                "src/test/resources/unit/modulepath-not-defined/pom.xml" );
        VoltranMojo voltranMojo = (VoltranMojo) lookupMojo("voltran", testPom);

        // When
        try {
            voltranMojo.execute();
        }catch (MojoExecutionException ex) {
            exception = ex;
        }

        // Then
        assertNotNull(exception);
        assertEquals("module-path configuration must be defined.", exception.getMessage());
    }
}