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


import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;

import fr.imag.adele.fede.workspace.as.initmodel.jaxb.CCadse;
import fr.imag.adele.fede.workspace.as.initmodel.jaxb.CItemType;
import fr.imag.adele.cadse.cadseg.managers.CadseDefinitionManager;
import fr.imag.adele.cadse.cadseg.managers.CadseG_WLWCListener;
import fr.imag.adele.cadse.cadseg.managers.dataModel.ItemTypeManager;
import fr.imag.adele.cadse.core.CadseException;
import fr.imag.adele.cadse.core.CadseGCST;
import fr.imag.adele.cadse.core.IItemNode;
import fr.imag.adele.cadse.core.Item;
import fr.imag.adele.cadse.core.ItemType;
import fr.imag.adele.cadse.core.Menu;
import fr.imag.adele.cadse.core.transaction.LogicalWorkspaceTransaction;
import fr.imag.adele.cadse.core.ui.AbstractActionContributor;
import fr.imag.adele.cadse.core.ui.IActionContributor;
import fr.imag.adele.cadse.core.ui.MenuAction;
import fr.imag.adele.cadse.core.ui.view.ViewDescription;


import fr.imag.adele.cadse.core.transaction.delta.ItemDelta;

/**
    @generated
*/
public class AdvancedMenuActionContributor extends AbstractActionContributor {

	private final class SyncCadseXML extends MenuAction {
		@Override
		public String getLabel() {
			return "sync with cadse.xml";
		}

		@Override
		public void run(IItemNode[] selection) throws CadseException {
			for (IItemNode n : selection) {
				Item item = n.getItem();
				if (item == null) return;
				if (item instanceof ItemType) {
					Item cadseDefinition = item.getPartParent(CadseGCST.CADSE_DEFINITION);
					if (cadseDefinition == null) return;
					IProject p = cadseDefinition.getMainMappingContent(IProject.class);
					IFile model = p.getFile("model/cadse.xml");
					LogicalWorkspaceTransaction t = item.getLogicalWorkspace().createTransaction();
					if (!model.exists()) return;
					try {
						CCadse cadseXml = read(model.getContents());
						Map<String, CItemType> xmlType = new HashMap<String, CItemType>();
						for (CItemType cit : cadseXml.getItemType()) {
							xmlType.put(cit.getName(), cit);
						}
						Item[] allTypes = ItemTypeManager.getAllAllItemType(cadseDefinition, null);
						for (Item it : allTypes) {
							CItemType cit = xmlType.get(it.getName());
							if (cit == null) continue;
							sync(t, it, cit);
						}
					} catch (JAXBException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return;
					} catch (CoreException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return;
					}
					
				}
				
				break;
			}
			
		}
		
		private void sync(LogicalWorkspaceTransaction t, Item it, CItemType cit) throws CadseException {
			ItemDelta itDelta = t.getItem(it.getId());
			itDelta.setAttribute(CadseGCST.TYPE_DEFINITION_at_ID_RUNTIME_, cit.getId().toString());
			itDelta.setAttribute(CadseGCST.ITEM_TYPE_at_ITEM_FACTORY_, cit.getFactoryClass());
		}

		public CCadse read(InputStream s) throws JAXBException {
			JAXBContext jc = JAXBContext.newInstance("fr.imag.adele.fede.workspace.as.initmodel.jaxb", this.getClass()
					.getClassLoader());
			Unmarshaller m = jc.createUnmarshaller();
			return (CCadse) m.unmarshal(s);
		}
	}



	/**
	    @generated
	*/
	public AdvancedMenuActionContributor() {
	}
	
	
	
	@Override
	public void contributeMenuAction(ViewDescription viewDescription,
			Menu menu, IItemNode[] selection) {
		menu.addToGroup(Menu.CONTEXT_2_MENU, new SyncCadseXML(), true);
		
	}
}

