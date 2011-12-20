/**
 * ***************************************************************************
 * Copyright (c) 2010 Qcadoo Limited
 * Project: Qcadoo MES
 * Version: 1.1.1
 *
 * This file is part of Qcadoo.
 *
 * Qcadoo is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation; either version 3 of the License,
 * or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 * ***************************************************************************
 */
package com.qcadoo.mes.productionCounting.internal.states;

import com.qcadoo.view.api.ComponentState.MessageType;

public class ChangeRecordStateMessage {

    private String referenceToField;

    private String message;

    private MessageType type;

    private final String[] vars;

    public ChangeRecordStateMessage(final String message, final String referenceToField, final MessageType type,
            final String... vars) {
        this.message = message;
        this.referenceToField = referenceToField;
        this.type = type;
        this.vars = vars;
    }

    public static ChangeRecordStateMessage errorForComponent(final String message, final String referenceToField,
            final String... vars) {
        return new ChangeRecordStateMessage(message, referenceToField, MessageType.FAILURE, vars);
    }

    public static ChangeRecordStateMessage error(final String message, final String... vars) {
        return new ChangeRecordStateMessage(message, null, MessageType.FAILURE, vars);
    }

    public static ChangeRecordStateMessage info(final String message, final String... vars) {
        return new ChangeRecordStateMessage(message, null, MessageType.INFO, vars);
    }

    public static ChangeRecordStateMessage success(final String message, final String... vars) {
        return new ChangeRecordStateMessage(message, null, MessageType.INFO, vars);
    }

    public String getMessage() {
        return message;
    }

    public String getReferenceToField() {
        return referenceToField;
    }

    public void setReferenceToField(String referenceToField) {
        this.referenceToField = referenceToField;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String[] getVars() {
        return vars;
    }

}