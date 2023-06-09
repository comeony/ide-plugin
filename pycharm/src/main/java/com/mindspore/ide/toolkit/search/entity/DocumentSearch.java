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

package com.mindspore.ide.toolkit.search.entity;

import com.intellij.openapi.actionSystem.AnAction;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class DocumentSearch {
    private final Object value;

    private final String pattern;

    private final int matchingDegree;

    public DocumentSearch(@NotNull Object value, @NotNull String pattern) {
        this(value, pattern, Integer.MAX_VALUE);
    }

    public DocumentSearch(@NotNull Object value, @NotNull String pattern, int matchingDegree) {
        this.value = value;
        this.pattern = pattern;
        this.matchingDegree = matchingDegree;
    }

    public Object getValue() {
        return value;
    }

    public String getPattern() {
        return pattern;
    }

    public int getMatchingDegree() {
        return matchingDegree;
    }

    public String getValueText() {
        if (value instanceof DocumentValue) {
            return ((DocumentValue) value).getTitle();
        }
        if (value instanceof AnAction) {
            return ((AnAction) value).getTemplatePresentation().getText();
        }
        if (value instanceof Map.Entry) {
            return ((Map.Entry<String, String>) value).getKey();
        }
        return "";
    }

    @Override
    public String toString() {
        return getValueText();
    }
}