 package fr.imag.adele.cadse.advancedcadseg;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

/**
	@generated
*/
public class Activator extends Plugin {

	/**
		@generated
	*/
	public static String PLUGIN_ID = "Model.Workspace.AdvancedCadseG";

	/**
		@generated
	*/
	private static Activator _default;

	/**
		@generated
	*/
	public Activator() {
		Activator._default = this;
	}
	
	/**
		@generated
	*/
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}
	
	/**
		@generated
	*/
	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
	}

	/**
		@generated
	*/
	public static Activator getDefault() {
		return _default;
	}
	
	/**
		@generated
	*/
	public void log(IStatus status) {
		this.getLog().log(status);
	}
}
