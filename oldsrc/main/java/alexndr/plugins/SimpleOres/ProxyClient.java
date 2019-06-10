package alexndr.plugins.SimpleOres;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;


@Mod.EventBusSubscriber(Side.CLIENT)
public class ProxyClient extends alexndr.plugins.SimpleOres.ProxyCommon 
{
	@Override
	public void preInit(FMLPreInitializationEvent event) 
	{
		super.preInit(event);
	} // end preInit
	
	@Override
    public void load(FMLInitializationEvent event)
    {
		super.load(event);
    } // end load
    
	@Override
    public void postInit(FMLPostInitializationEvent event) 
    { 
		super.postInit(event);
    } // end postInit()    

	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) 
	{
    	ModItems.registerModels();
    	ModBlocks.registerModels();
	}

} // end class()
