/* 
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package fr.imag.adele.cadse.advancedcadseg.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.ITreeContentProvider;

import fr.imag.adele.cadse.advancedcadseg.Activator;
import fr.imag.adele.cadse.cadseg.ItemShortNameComparator;
import fr.imag.adele.cadse.core.CadseGCST;
import fr.imag.adele.cadse.core.CadseRuntime;
import fr.imag.adele.cadse.core.CadseUtil;
import fr.imag.adele.cadse.core.Item;
import fr.imag.adele.cadse.core.ItemType;
import fede.workspace.model.manager.properties.impl.ic.IC_LinkForBrowser_Combo_List;
import fede.workspace.model.manager.properties.impl.ic.ItemTreeContentProvider;

/**
 * The Class IC_SuperTypeForBrowser_Combo.
 */
@SuppressWarnings("deprecation")
public final class IC_InstanceOfForBrowser_Combo extends IC_LinkForBrowser_Combo_List {

	/**
	 * Instantiates a new i c_ super type for browser_ combo.
	 * 
	 * @param title
	 *            the title
	 * @param message
	 *            the message
	 */
	public IC_InstanceOfForBrowser_Combo(String title, String message) {
		super(title, message, CadseGCST.ITEM_lt_INSTANCE_OF);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fede.workspace.model.manager.properties.impl.ic.IC_LinkForBrowser_Combo_List#getTreeContentProvider()
	 */
	@Override
	protected ITreeContentProvider getTreeContentProvider() {
		return new ItemTreeContentProvider(new ItemShortNameComparator(), CadseGCST.CADSE_RUNTIME_lt_ITEM_TYPES,
				CadseGCST.CADSE_RUNTIME_lt_EXTENDS, CadseGCST.ITEM_lt_INSTANCE_OF);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fede.workspace.model.manager.properties.impl.ic.IC_LinkForBrowser_Combo_List#validate(java.lang.Object[])
	 */
	@Override
	public IStatus validate(Object[] selection) {
		if (selection != null && selection.length == 1) {
			Object sel = selection[0];
			if (sel instanceof ItemType) {
				return Status.OK_STATUS;
			}
		}
		return new Status(Status.ERROR, Activator.PLUGIN_ID, "select an item type");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fede.workspace.model.manager.properties.impl.ic.IC_LinkForBrowser_Combo_List#getInputValues()
	 */
	@Override
	protected Object getInputValues() {
		Item theItemType = getItem();
		List<CadseRuntime> allcadse = new ArrayList<CadseRuntime>();
		CadseRuntime[] cr = theItemType.getLogicalWorkspace().getCadseRuntime();
		for (int i = 0; i < cr.length; i++) {
			if (cr[i].isExecuted())
				allcadse.add(cr[i]);
		}
		Item[] ret = allcadse.toArray(new Item[allcadse.size()]);
		Arrays.sort(ret, new ItemShortNameComparator());
		return ret;
	}
	
	@Override
	protected Object createGoodObject(Object object) {
		ItemType it = (ItemType) getItem();
		it.setType((ItemType) object);
		return it.getOutgoingLink(CadseGCST.ITEM_lt_INSTANCE_OF);
	}
}