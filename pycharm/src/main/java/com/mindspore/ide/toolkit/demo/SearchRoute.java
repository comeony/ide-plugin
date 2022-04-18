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

package com.mindspore.ide.toolkit.demo;

/**
 * Route entities
 *
 * @since 2022-04-18
 */
public enum SearchRoute {
    AI_SEARCH(""),
    FUSION_SEARCH(""),
    FUSION_SEARCH_WITH16("");

    private String server;

    SearchRoute(String server) {
        this.server = server;
    }

    public String getServer() {
        return server;
    }
}