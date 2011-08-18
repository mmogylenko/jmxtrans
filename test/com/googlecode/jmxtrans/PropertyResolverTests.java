package com.googlecode.jmxtrans;

import org.junit.Assert;
import org.junit.Test;

import com.googlecode.jmxtrans.util.PropertyResolver;

public class PropertyResolverTests {

    @Test
    public void testProps() {
        System.setProperty("myhost", "w2");
        System.setProperty("myport", "1099");

        String s1 = "${xxx} : ${yyy}";
        String s2 = PropertyResolver.resolveProps(s1);
        Assert.assertEquals(s1, s2);

        s1 = "${myhost} : ${myport}";
        s2 = PropertyResolver.resolveProps(s1);
        Assert.assertEquals("w2 : 1099", s2);

        s1 = "${myhost} : ${myaltport:2099}";
        s2 = PropertyResolver.resolveProps(s1);
        Assert.assertEquals("w2 : 2099", s2);
    }
}