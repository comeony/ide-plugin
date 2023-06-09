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

package com.mindspore.ide.toolkit.wizard;

import com.intellij.ide.util.projectWizard.AbstractNewProjectStep;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.ui.LabeledComponent;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.openapi.ui.VerticalFlowLayout;
import com.intellij.platform.DirectoryProjectGenerator;
import com.intellij.ui.DocumentAdapter;
import com.jetbrains.python.newProject.steps.ProjectSpecificSettingsStep;
import com.mindspore.ide.toolkit.common.utils.OSInfoUtils;
import com.mindspore.ide.toolkit.common.utils.PathUtils;
import com.mindspore.ide.toolkit.common.utils.RegularUtils;
import com.mindspore.ide.toolkit.ui.wizard.WizardMsSettingProjectPeer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;

import java.awt.BorderLayout;
import java.nio.file.Files;
import java.nio.file.Path;

public class CustomMSProjectStep extends ProjectSpecificSettingsStep {
    private WizardMsSettingProjectPeer projectPeer;

    /**
     * constructor
     *
     * @param projectGenerator project generator
     * @param callback         call back
     * @param projectPeer      peer
     */
    public CustomMSProjectStep(@NotNull DirectoryProjectGenerator projectGenerator,
        AbstractNewProjectStep.@NotNull AbstractCallback callback,
        WizardMsSettingProjectPeer projectPeer) {
        super(projectGenerator, callback);
        this.projectPeer = projectPeer;
    }

    @Override
    protected JPanel createBasePanel() {
        BorderLayout layout = new BorderLayout();
        JPanel locationPanel = new JPanel(layout);
        JPanel panel = new JPanel(new VerticalFlowLayout(0, 2));
        LabeledComponent<TextFieldWithBrowseButton> location = this.createLocationComponent();
        setProjectPath();
        locationPanel.add(location, "Center");
        panel.add(locationPanel);
        panel.add(projectPeer.getMainPanel());
        return panel;
    }

    @Override
    protected @Nullable JPanel createAdvancedSettings() {
        return null;
    }

    @Override
    public boolean checkValid() {
        OSInfoUtils osInfoUtils = OSInfoUtils.INSTANCE;
        if (!(osInfoUtils.isLinux() || osInfoUtils.isWindows() || osInfoUtils.isMacOsX86())) {
            setWarningText("os not support");
            return false;
        }

        if (RegularUtils.isEmpty(projectPeer.getCondaPath())
                || !Files.exists(Path.of(projectPeer.getCondaPath()))
                || !(projectPeer.getCondaPath().endsWith("conda.exe")
                || projectPeer.getCondaPath().endsWith("conda"))) {
            setWarningText("Conda executable not exist or wrong");
            return false;
        }

        if (myLocationField.getText().endsWith(" ")) {
            setWarningText("Project Location end with space!");
            return false;
        } else {
            setWarningText("Project Location has been fixed!");
        }

        if (osInfoUtils.isLinux() && !PathUtils.judgeIsChildPath(MiniCondaService
                .getCondaEnvsPath(projectPeer.getCondaPath()), projectPeer.getCondaEnvPath())) {
            setWarningText("This environment path is invalid."
                    + " Please choose new environment location in Conda install path.");
            return false;
        }

        if (projectPeer.isUsingNewCondaEnv()) {
            if (RegularUtils.isEmpty(projectPeer.getCondaEnvPath())) {
                setWarningText("Env location is empty");
                return false;
            }
            if (Files.exists(Path.of(projectPeer.getCondaEnvPath()))) {
                setWarningText("Env location exists!");
                return false;
            }
        } else {
            if (projectPeer.getExistSdkString().isEmpty()) {
                setWarningText("Please choose a conda env!");
                return false;
            }
            if (!Files.exists(Path.of(projectPeer.getExistSdk().getHomePath()))) {
                setWarningText("Selected interpreter is broken."
                        + " Please choose another one or create a new environment!");
                return false;
            }
        }

        return true;
    }

    @Override
    public
    @Nullable
    Sdk getSdk() {
        if (projectPeer.isUsingNewCondaEnv()) {
            return MsCondaEnvService.newLazySdk(
                    projectPeer.getCondaPath(),
                    projectPeer.getCondaEnvPath(),
                    projectPeer.getPythonVersion());
        } else {
            return projectPeer.getExistSdk();
        }
    }

    private void setProjectPath() {
        myLocationField.getTextField().getDocument().addDocumentListener(new DocumentAdapter() {
            @Override
            protected void textChanged(@NotNull DocumentEvent event) {
                projectPeer.setCondaEnvPath(getProjectNameByOs(myLocationField.getText()));
            }
        });
        projectPeer.setCondaEnvPath(getProjectNameByOs(myLocationField.getText()));
    }

    private static String getProjectNameByOs(String projectPath) {
        return Path.of(RegularUtils.normalizeFilePath(projectPath)).getFileName().toString();
    }
}
