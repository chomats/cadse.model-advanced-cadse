package fr.imag.adele.cadse.advancedcadseg.menu;

import java.net.URL;

import fr.imag.adele.cadse.core.CadseException;
import fr.imag.adele.cadse.core.IItemNode;
import fr.imag.adele.cadse.core.IMenuAction;
import fr.imag.adele.cadse.core.Item;
import fr.imag.adele.cadse.core.Link;
import fr.imag.adele.cadse.core.Menu;
import fr.imag.adele.cadse.core.delta.ItemDelta;
import fr.imag.adele.cadse.core.delta.LinkDelta;
import fr.imag.adele.cadse.core.impl.internal.delta.DeleteOperationImpl;
import fr.imag.adele.cadse.core.transaction.LogicalWorkspaceTransaction;
import fr.imag.adele.cadse.core.ui.IActionContributor;
import fr.imag.adele.cadse.core.ui.view.ViewDescription;

/**
 * @generated
 */
public class ItemDebugMenuActionContributor implements IActionContributor {

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
				public URL getImage() {
					return null;
				}
			}, true);
		}
	}
}
