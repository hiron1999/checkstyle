package com.puppycrawl.tools.checkstyle.checks;

import com.puppycrawl.tools.checkstyle.BaseCheckTestCase;
import com.puppycrawl.tools.checkstyle.DefaultConfiguration;

public class IllegalInstantiationCheckTest
    extends BaseCheckTestCase
{
    public void testIt() throws Exception
    {
        final DefaultConfiguration checkConfig =
            createCheckConfig(IllegalInstantiationCheck.class);
        checkConfig.addAttribute(
            "classes",
            "java.lang.Boolean,"
                + "com.puppycrawl.tools.checkstyle.InputModifier,"
                + "java.io.File,"
                + "java.awt.Color");
        final String[] expected = {
            "19:21: Instantiation of java.lang.Boolean should be avoided.",
            "24:21: Instantiation of java.lang.Boolean should be avoided.",
            "31:16: Instantiation of java.lang.Boolean should be avoided.",
            "38:21: Instantiation of " +
                "com.puppycrawl.tools.checkstyle.InputModifier " +
                "should be avoided.",
            "41:18: Instantiation of java.io.File should be avoided.",
            "44:21: Instantiation of java.awt.Color should be avoided."
        };
        verify(checkConfig, getPath("InputSemantic.java"), expected);
    }
}
