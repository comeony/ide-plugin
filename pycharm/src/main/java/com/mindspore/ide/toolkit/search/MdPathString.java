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

package com.mindspore.ide.toolkit.search;

import com.google.gson.JsonParseException;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * read md file content
 *
 * @since 1.0
 */
@Slf4j
public class MdPathString {
    /**
     * pytorch api content
     */
    public static final String PYTORCH_MD_STR = readMdFile(MdPathString.SLASH + "markdown"
            + MdPathString.SLASH + "pytorch_api_mapping.md");

    /**
     * tensorflow api content
     */
    public static final String TENSORFLOW_MD_STR = readMdFile(MdPathString.SLASH + "markdown"
            + MdPathString.SLASH + "tensorflow_api_mapping.md");

    private static final String SLASH = "/";

    private static String readMdFile(String mdPath) {
        StringBuilder stringBuilder = new StringBuilder();
        try (InputStream inputStream = MdPathString.class.getResourceAsStream(mdPath);
            InputStreamReader fileReader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            boolean isFirstLine = true;
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                if (!isFirstLine) {
                    stringBuilder.append(System.getProperty("line.separator"));
                } else {
                    isFirstLine = false;
                }
                stringBuilder.append(line);
            }
        } catch (IOException | JsonParseException exception) {
            log.info(exception.getMessage());
        }
        return stringBuilder.toString();
    }
}