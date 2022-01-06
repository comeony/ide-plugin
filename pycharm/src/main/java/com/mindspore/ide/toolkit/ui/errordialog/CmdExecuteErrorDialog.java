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

package com.mindspore.ide.toolkit.ui.errordialog;

import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.Messages;
import com.intellij.ui.components.JBLabel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JComponent;

/**
 * cmd execute error dialog
 *
 * @since 1.0
 */
public class CmdExecuteErrorDialog extends DialogWrapper {
    private JPanel cmdMainPanel;
    private JTextArea outPutInfo;
    private JPanel outPutContainer;
    private JPanel commandContainer;
    private JTextPane commandTextContainer;
    private JPanel resultContainer;
    private JTextPane result;
    private JPanel detailContainer;
    private JTextArea detailsInfo;
    private JPanel messageContainer;
    private JBLabel detailsTextInfo;
    private JTextPane messages;
    private JBLabel messageLabel;

    /**
     * constructor for dialog info
     *
     * @param dialogInfo dialog info
     */
    public CmdExecuteErrorDialog(@NotNull CmdDialogInfo dialogInfo) {
        super(false);
        init();
        setResizable(false);
        setTitle(dialogInfo.getTitle());
        final String message = dialogInfo.getDescription();
        final String solution = dialogInfo.getSolution();
        final String command = dialogInfo.getCommand();
        final String output = dialogInfo.getOutput();
        final boolean isExtendedInfo = command != null || output != null || solution != null;
        commandContainer.setVisible(command != null);
        outPutContainer.setVisible(output != null);
        resultContainer.setVisible(solution != null);
        detailContainer.setVisible(!isExtendedInfo);
        messageContainer.setVisible(isExtendedInfo);
        if (isExtendedInfo) {
            messages.setText(message);
            messageLabel.setIcon(Messages.getErrorIcon());
        } else {
            detailsInfo.setText(message);
            detailsTextInfo.setIcon(Messages.getErrorIcon());
        }
        if (solution != null) {
            result.setText(solution);
        }
        if (output != null) {
            outPutInfo.setText(output);
        }
        if (command != null) {
            commandTextContainer.setText(command);
        }
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        return cmdMainPanel;
    }
}

