package org.example.object;


import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ObjectCompareTest {

    @Test
    @DisplayName("Compare two constants strings ")
    void compareTwoConstantsStrings() {
        String s1 = "Lecce";
        String s2 = new String(s1);
        // Assert.assertTrue(s1 == s2);
        Assert.assertSame(s1, s2);
    }
}
