/*
 * Copyright 2021-2022 Huawei Technologies Co., Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mindspore.ide.toolkit.common.exceptions;

import com.mindspore.ide.toolkit.common.enums.EnumError;
import org.junit.Assert;
import org.junit.Test;

/**
 * PythonCommand Test
 *
 * @since 2022-1-27
 */
public class MsToolKitExceptionTest {
    @Test
    public void initTest() {
        MsToolKitException msToolKitException = new MsToolKitException(EnumError.IO_EXCEPTION);
        Assert.assertNotNull(msToolKitException);
        Assert.assertEquals(msToolKitException.getErrMsg(), "io Exception!");
        Assert.assertEquals(msToolKitException.getErrCode(), "ERROR_000002");
        Assert.assertNull(msToolKitException.getSolution());

        MsToolKitException msToolKitException1 = new MsToolKitException("MsToolKitException");
        Assert.assertNotNull(msToolKitException1);
    }
}