package mod.alexndr.simpleores.init;

import mod.alexndr.simpleores.SimpleOres;
import mod.alexndr.simpleores.config.SimpleOresConfig;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

public final class CreativeTabs
{

	// formerly MOD_ITEM_GROUP
	public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = 
			DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SimpleOres.MODID);

	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SIMPLEORES_TAB
			= CREATIVE_MODE_TABS.register("simpleores_tab",
			() -> CreativeModeTab.builder()
					.title(Component.translatable("item_group." + SimpleOres.MODID + ".simpleores_tab"))
					.icon(() -> new ItemStack(ModItems.copper_pickaxe.get()))
					.displayItems((parameters, output) -> {
						output.acceptAll(ModBlocks.BLOCKS.getEntries().stream()
								.map(DeferredHolder::get)
								.map(b -> (new ItemStack(b.asItem())))
								.toList()
						);
						List<ItemStack> acceptableItems = new ArrayList<ItemStack>(
								ModItems.ITEMS.getEntries().stream()
									.map(DeferredHolder::get)
									.map(ItemStack::new)
									.toList());
						if (!SimpleOresConfig.ShowTestBucket) {
							ItemStack found_item = null;
							for (var foo : acceptableItems) {
								if (foo.getItem() == ModItems.test_bucket.get()) {
									found_item = foo;
								}
							}
							acceptableItems.remove(found_item);
						}
						output.acceptAll(acceptableItems);
					}).build());

}  // end class ModTabGroup
