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

package com.mindspore.ide.toolkit.hdc;

import com.intellij.execution.Executor;
import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.RunProfileState;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.project.Project;
import com.jetbrains.python.run.PythonRunConfiguration;
import org.jetbrains.annotations.NotNull;

/**
 * MsRunConfiguration
 *
 * @since 2022-04-18
 */
public class MsRunConfiguration extends PythonRunConfiguration {
    /**
     * construction method
     *
     * @param project              project
     * @param configurationFactory configurationFactory
     * @param parameter            parameter
     */
    protected MsRunConfiguration(Project project, ConfigurationFactory configurationFactory,
            String parameter) {
        super(project, configurationFactory);
        super.setScriptParameters(parameter);
    }

    @Override
    public RunProfileState getState(@NotNull Executor executor, @NotNull ExecutionEnvironment env) {
        return new MsPythonScriptCommandLineState(this, env, this.getProject());
    }
}