package fr.imag.adele.cadse.advancedcadseg.pages.content;

import fede.workspace.model.manager.properties.impl.ic.IC_LinkForBrowser_Combo_List;
import fede.workspace.model.manager.properties.impl.mc.LinkModelController;
import fede.workspace.model.manager.properties.impl.ui.DBrowserUI;
import fr.imag.adele.cadse.advancedcadseg.AdvancedCadseGCST;
import fr.imag.adele.cadse.core.IItemNode;
import fr.imag.adele.cadse.core.Item;
import fr.imag.adele.cadse.core.ItemType;
import fr.imag.adele.cadse.core.Link;
import fr.imag.adele.cadse.core.LinkType;
import fr.imag.adele.cadse.core.impl.ui.PageImpl;
import fr.imag.adele.cadse.core.ui.EPosLabel;
import fr.imag.adele.cadse.core.ui.IActionPage;
import fr.imag.adele.cadse.core.ui.IPage;
import fr.imag.adele.cadse.core.ui.PageFactory;
import fr.imag.adele.cadse.core.ui.UIField;
import fr.imag.adele.cadse.ui.field.core.FieldsCore;

/**
 @generated
 */
public class CadsegContentItemTypeModificationPageCadsegContentItemType_ModificationPage
		extends PageImpl {

	/**
	    @generated
	 */
	public Item item;

	/**
	    @generated
	 */
	protected DBrowserUI fieldRuntimeType;

	/**
	    @generated
	 */
	protected CadsegContentItemTypeModificationPageCadsegContentItemType_ModificationPage(
			String id, String label, String title, String description,
			boolean isPageComplete, int hspan) {
		super(id, label, title, description, isPageComplete, hspan);
	}

	/**
	    @generated
	 */
	public CadsegContentItemTypeModificationPageCadsegContentItemType_ModificationPage(
			Item item) {
		super("modification-page-CadsegContentItemType",
				"CadsegContentItemType", "CadsegContentItemType", "", false, 3);
		this.item = item;
		this.fieldRuntimeType = createFieldRuntimeType();
		setActionPage(null);
		addLast(this.fieldRuntimeType);

		registerListener();
	}

	protected void registerListener() {
		// add init and register
	}

	/**
	    @generated
	 */
	public DBrowserUI createFieldRuntimeType() {
		IC_LinkForBrowser_Combo_List ic = new IC_LinkForBrowser_Combo_List(
				"Select a value.", "Select a value.",
				AdvancedCadseGCST.CADSEG_CONTENT_ITEM_TYPE_lt_RUNTIME_TYPE);
		LinkModelController mc = new LinkModelController(true, null,
				AdvancedCadseGCST.CADSEG_CONTENT_ITEM_TYPE_lt_RUNTIME_TYPE);
		return new DBrowserUI(
				AdvancedCadseGCST.CADSEG_CONTENT_ITEM_TYPE_lt_RUNTIME_TYPE
						.getName(), "runtime-type", EPosLabel.left, mc, ic);
	}

}
