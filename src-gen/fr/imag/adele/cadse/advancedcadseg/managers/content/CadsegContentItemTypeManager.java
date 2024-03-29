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
package fr.imag.adele.cadse.advancedcadseg.managers.content;


import fr.imag.adele.cadse.advancedcadseg.AdvancedCadseGCST;
import fr.imag.adele.cadse.core.CadseException;
import fr.imag.adele.cadse.cadseg.managers.dataModel.ItemTypeManager;
import fr.imag.adele.cadse.core.Item;
import fr.imag.adele.cadse.core.ItemType;
import fr.imag.adele.cadse.core.Link;
import fr.imag.adele.cadse.core.LinkType;



/**
    @generated
*/
public class CadsegContentItemTypeManager extends ItemTypeManager {

	/**
	    @generated
	*/
	public CadsegContentItemTypeManager() {
		super();
	}

	/**
		@generated
	*/
	@Override
	public String computeQualifiedName(Item item, String name, Item parent, LinkType lt) {
		StringBuilder sb = new StringBuilder();
		try {
			Object value;
			Item currentItem;
			sb.append(parent.getQualifiedName());
			if (sb.length() != 0) {
				sb.append(".");
			}
			sb.append(name);
			return sb.toString();
		} catch (Throwable e) {
			e.printStackTrace();
			return "error";
		}
	}

	/**
		@generated
	*/
	@Override
	public String getDisplayName(Item item) {
		try {
			Object value;
			return item.getName();
		} catch (Throwable e) {
			e.printStackTrace();
			return "error";
		}
	}

	/**
		get a link 'runtime-type' from 'CadsegContentItemType' to 'CadsegContentItem'.
		@generated
	*/
	static public Link getRuntimeTypeLink(Item cadsegContentItemType) {
		return cadsegContentItemType.getOutgoingLink(AdvancedCadseGCST.CADSEG_CONTENT_ITEM_TYPE_lt_RUNTIME_TYPE);
	}

	/**
		get all link destination 'runtime-type' from 'CadsegContentItemType' to 'CadsegContentItem'.
		@generated
	*/
	static public Item getRuntimeTypeAll(Item cadsegContentItemType) {
		return cadsegContentItemType.getOutgoingItem(AdvancedCadseGCST.CADSEG_CONTENT_ITEM_TYPE_lt_RUNTIME_TYPE, false);
	}

	/**
		get resolved link destination 'runtime-type' from 'CadsegContentItemType' to 'CadsegContentItem'.
		@generated
	*/
	static public Item getRuntimeType(Item cadsegContentItemType) {
		return cadsegContentItemType.getOutgoingItem(AdvancedCadseGCST.CADSEG_CONTENT_ITEM_TYPE_lt_RUNTIME_TYPE, true);
	}

	/**
		set a link 'runtime-type' from 'CadsegContentItemType' to 'CadsegContentItem'.
		@generated
	*/
	static public void setRuntimeType(Item cadsegContentItemType, Item value) throws CadseException {
		cadsegContentItemType.setOutgoingItem(AdvancedCadseGCST.CADSEG_CONTENT_ITEM_TYPE_lt_RUNTIME_TYPE,value);
	}

}

