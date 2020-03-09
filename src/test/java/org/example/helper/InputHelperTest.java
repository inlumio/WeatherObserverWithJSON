package org.example.helper;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class InputHelperTest {

    @Test
    public void selectCity() {
        InputHelper inputHelper = new InputHelper(BundleHelper.getBundle());
        List<String> list = inputHelper.selectCity();
    }

    @Test
    public void checkInput() {
    }
}