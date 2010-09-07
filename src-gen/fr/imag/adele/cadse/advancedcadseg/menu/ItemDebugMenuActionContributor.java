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
 *
 * Copyright (C) 2006-2010 Adele Team/LIG/Grenoble University, France
 */
package fr.imag.adele.cadse.advancedcadseg.menu;

import java.net.URL;

import fr.imag.adele.cadse.core.CadseException;
import fr.imag.adele.cadse.core.IItemNode;
import fr.imag.adele.cadse.core.IMenuAction;
import fr.imag.adele.cadse.core.Item;
import fr.imag.adele.cadse.core.Link;
import fr.imag.adele.cadse.core.Menu;
import fr.imag.adele.cadse.core.transaction.delta.ItemDelta;
import fr.imag.adele.cadse.core.transaction.delta.LinkDelta;
import fr.imag.adele.cadse.core.impl.internal.delta.DeleteOperationImpl;
import fr.imag.adele.cadse.core.transaction.LogicalWorkspaceTransaction;
import fr.imag.adele.cadse.core.ui.AbstractActionContributor;
import fr.imag.adele.cadse.core.ui.IActionContributor;
import fr.imag.adele.cadse.core.ui.view.ViewDescription;

/**
 * @generated
 */
public class ItemDebugMenuActionContributor  extends AbstractActionContributor {

	/**
	 * @generated
	 */
	public ItemDebugMenuActionContributor() {
	}

	@Override
	public void contributeMenuAction(ViewDescription viewDescription, Menu menu, IItemNode[] selection) {
		Menu menuDebug = (Menu) menu.find("menu-debug");
		if (menuDebug == null) {
			menuDebug = new Menu("menu-debug", "Debug", null);
			menu.insert(IMenuAction.CONTEXT_3_MENU, menuDebug, true);
		}

		for (final IItemNode n : selection) {
			final Item item = n.getItem();
			if (item == null)
				continue;
			menuDebug.insert(null, new IMenuAction() {

				@Override
				public void run(IItemNode[] selection) throws CadseException {
					Link l = n.getLink();
					if (l == null)
						return;
					LogicalWorkspaceTransaction t = l.getSource().getLogicalWorkspace().createTransaction();
					ItemDelta s = t.getItem(l.getSourceId());
					LinkDelta ld = s.getOutgoingLink(l.getLinkType(), l.getDestinationId());
					ld.delete(new DeleteOperationImpl(null, null, 0));
					t.commit();
				}

				@Override
				public String getLabel() {
					return "My action " + item.getDisplayName();
				}

				@Override
				public String getImage() {
					return null;
				}
			}, true);
		}
	}
}
