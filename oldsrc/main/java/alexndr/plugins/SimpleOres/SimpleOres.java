package alexndr.plugins.SimpleOres;

import alexndr.api.logger.LogHelper;
import alexndr.api.registry.Plugin;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @author AleXndrTheGr8st
 */
@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION, 
	 dependencies = ModInfo.DEPENDENCIES, acceptedMinecraftVersions=ModInfo.ACCEPTED_VERSIONS,
	 updateJSON=ModInfo.VERSIONURL)
public class SimpleOres 
{
	@Mod.Instance
	public static SimpleOres instance;
	
	@SidedProxy(clientSide = "alexndr.plugins.SimpleOres.ProxyClient", 
		    	serverSide = "alexndr.plugins.SimpleOres.ProxyCommon")
	public static ProxyCommon proxy;
	
	public static Plugin plugin = new Plugin(ModInfo.ID, ModInfo.NAME);
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) 
	{
		LogHelper.info(ModInfo.ID,"Loading...");
		proxy.preInit(event);
	} // end preInit
	
	@EventHandler
	public void init(FMLInitializationEvent event) 
	{
		proxy.load(event);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) 
	{
		proxy.postInit(event);
		LogHelper.info(ModInfo.ID, "Loading Complete!");
	}

} // end class
