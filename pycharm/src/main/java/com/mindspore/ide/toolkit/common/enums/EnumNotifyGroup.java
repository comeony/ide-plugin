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

package com.mindspore.ide.toolkit.common.enums;

public enum EnumNotifyGroup {
    MIND_SPORE(EnumProperties.MIND_SPORE_PROPERTIES.getProperty("project.ward.name"),
            EnumProperties.MIND_SPORE_PROPERTIES.getProperty("project.ward.name"),
            EnumProperties.MIND_SPORE_PROPERTIES.getProperty("project.ward.name"));

    private String displayId;

    private String title;

    private String description;

    EnumNotifyGroup(String displayId, String title, String description) {
        this.displayId = displayId;
        this.title = title;
        this.description = description;
    }

    public String getDisplayId() {
        return displayId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}