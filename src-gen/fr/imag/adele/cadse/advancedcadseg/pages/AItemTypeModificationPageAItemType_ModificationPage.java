package fr.imag.adele.cadse.advancedcadseg.pages;

import fede.workspace.model.manager.properties.impl.ic.IC_LinkForBrowser_Combo_List;
import fede.workspace.model.manager.properties.impl.mc.LinkModelController;
import fede.workspace.model.manager.properties.impl.mc.StringToBooleanModelControler;
import fede.workspace.model.manager.properties.impl.ui.DBrowserUI;
import fede.workspace.model.manager.properties.impl.ui.DCheckBoxUI;
import fede.workspace.model.manager.properties.impl.ui.DTextUI;
import fr.imag.adele.cadse.core.CadseGCST;
import fr.imag.adele.cadse.core.Item;
import fr.imag.adele.cadse.core.impl.ui.MC_AttributesItem;
import fr.imag.adele.cadse.core.impl.ui.PageImpl;
import fr.imag.adele.cadse.core.ui.EPosLabel;

/**
 @generated
 */
public class AItemTypeModificationPageAItemType_ModificationPage extends
		PageImpl {

	/**
	    @generated
	 */
	public Item item;

	/**
	    @generated
	 */
	protected DTextUI fieldItemFactory;

	/**
	    @generated
	 */
	protected DCheckBoxUI fieldIsMetaItemType;

	/**
	    @generated
	 */
	protected DBrowserUI fieldInstanceOf;

	/**
	    @generated
	 */
	protected AItemTypeModificationPageAItemType_ModificationPage(String id,
			String label, String title, String description,
			boolean isPageComplete, int hspan) {
		super(id, label, title, description, isPageComplete, hspan);
	}

	/**
	    @generated
	 */
	public AItemTypeModificationPageAItemType_ModificationPage(Item item) {
		super("modification-page-AItemType", "AItemType", "AItemType", "",
				false, 3);
		this.item = item;
		this.fieldItemFactory = createFieldItemFactory();
		this.fieldIsMetaItemType = createFieldIsMetaItemType();
		this.fieldInstanceOf = createFieldInstanceOf();
		setActionPage(null);
		addLast(this.fieldItemFactory, this.fieldIsMetaItemType,
				this.fieldInstanceOf);

		registerListener();
	}

	protected void registerListener() {
		// add init and register
	}

	/**
	    @generated
	 */
	public DTextUI createFieldItemFactory() {
		return new DTextUI(CadseGCST.ITEM_TYPE_at_ITEM_FACTORY, "item-factory",
				EPosLabel.left, new MC_AttributesItem(), null, 1, "", false,
				false, false);
	}

	/**
	    @generated
	 */
	public DCheckBoxUI createFieldIsMetaItemType() {
		StringToBooleanModelControler mc = new StringToBooleanModelControler();
		return new DCheckBoxUI(CadseGCST.ITEM_TYPE_at_IS_META_ITEM_TYPE,
				"is-meta-item-type", EPosLabel.none, mc, null);
	}

	/**
	    @not generated
	 */
	public DBrowserUI createFieldInstanceOf() {
		IC_LinkForBrowser_Combo_List ic = new IC_InstanceOfForBrowser_Combo(
				"Select a value.", "Select a value.");
		LinkModelController mc = new LinkModelController(true, null,
				CadseGCST.ITEM_lt_INSTANCE_OF) ;
		return new DBrowserUI(CadseGCST.ITEM_lt_INSTANCE_OF.getName(),
				"type", EPosLabel.left, mc, ic);
	}

}
