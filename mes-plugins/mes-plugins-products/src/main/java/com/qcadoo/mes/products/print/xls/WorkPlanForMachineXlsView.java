/**
 * ***************************************************************************
 * Copyright (c) 2010 Qcadoo Limited
 * Project: Qcadoo MES
 * Version: 0.2.0
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

package com.qcadoo.mes.products.print.xls;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.qcadoo.mes.api.Entity;
import com.qcadoo.mes.api.TranslationService;
import com.qcadoo.mes.products.print.pdf.util.PdfUtil;
import com.qcadoo.mes.products.print.xls.util.XlsCopyUtil;

public final class WorkPlanForMachineXlsView extends AbstractExcelView {

    @Autowired
    private TranslationService translationService;

    @Override
    protected void buildExcelDocument(final Map<String, Object> model, final HSSFWorkbook workbook,
            final HttpServletRequest request, final HttpServletResponse response) throws Exception {
        Locale locale = PdfUtil.retrieveLocaleFromRequestCookie(request);
        Entity entity = (Entity) model.get("entity");
        XlsCopyUtil.copyXlsContent(
                entity,
                workbook,
                response,
                "for_machine",
                PdfUtil.prepareFileNameForResponse(entity,
                        translationService.translate("products.workPlan.report.fileName", locale),
                        translationService.translate("products.workPlan.report.fileName.suffix.forMachine", locale)));
    }

}
