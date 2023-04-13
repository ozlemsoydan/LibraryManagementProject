package com.ozlemaglar.LibraryManagementProject.util;

import io.micrometer.common.util.StringUtils;

public class DataCheck {

    public void idNullCheck(String id) throws Exception {
            if (StringUtils.isEmpty(id)) {
                throw new Exception("id boş olamaz");
            }
    }
}
