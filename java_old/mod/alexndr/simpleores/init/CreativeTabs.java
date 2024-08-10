package mod.alexndr.simpleores.init;

import mod.alexndr.simpleores.SimpleOres;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public final class CreativeTabs
{

	// formerly MOD_ITEM_GROUP
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = 
			DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SimpleOres.MODID);
	
	public static final RegistryObject<CreativeModeTab> SIMPLEORES_TAB = CREATIVE_MODE_TABS.register("simplecore_tab",
			() -> CreativeModeTab.builder()
				.title(Component.translatable("item_group." + SimpleOres.MODID + ".simplecore_tab"))
				.icon(() -> new ItemStack(ModItems.copper_pickaxe.get()))
				.displayItems((parameters, output) -> {
					output.acceptAll(ModBlocks.BLOCKS.getEntries().stream()
										.map(RegistryObject::get)
										.map(b -> (new ItemStack(b.asItem())))
										.toList()
										);
					output.acceptAll(ModItems.ITEMS.getEntries().stream()
							.map(RegistryObject::get)
							.map(b -> (new ItemStack(b)))
							.toList()
							);
				}).build());

}  // end class ModTabGroup
