package mod.alexndr.simpleores;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import mod.alexndr.simplecorelib.api.helpers.LootUtils;
import mod.alexndr.simpleores.config.SimpleOresConfig;
import mod.alexndr.simpleores.init.ModItems;
import mod.alexndr.simpleores.loot.SimpleOresInjectionLookup;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.npc.VillagerTrades.ItemListing;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.BasicItemListing;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

/**
 * Subscribe to events from the FORGE EventBus that should be handled on both PHYSICAL sides in this class
 *
 */
@EventBusSubscriber(modid = SimpleOres.MODID, bus = EventBusSubscriber.Bus.FORGE)
public final class ForgeEventSubscriber
{
	@SuppressWarnings("unused")
    private static final Logger LOGGER = LogManager.getLogger(SimpleOres.MODID + " Forge Event Subscriber");
	private static final SimpleOresInjectionLookup lootLookupMap = new SimpleOresInjectionLookup();
	
    /**
     * add mod loot to loot tables. Code heavily based on Botania's LootHandler, which
     * neatly solves the problem when I couldn't figure it out.
     */
    @SubscribeEvent
    public static void LootLoad(final LootTableLoadEvent event)
    {
        if (SimpleOresConfig.addModLootToChests)
        {
            LootUtils.LootLoadHandler(SimpleOres.MODID, event, lootLookupMap);
        } // end-if config allows
    } // end LootLoad()
    
    

    /**
     * Intercept villager trades list and modify it.
     */
    @SubscribeEvent
    public static void onVillagerTrades(VillagerTradesEvent evt)
    {
        if (evt.getType() == VillagerProfession.ARMORER)
        {
            Int2ObjectMap<List<ItemListing>> trades = evt.getTrades();
            // novice trades
            trades.get(1).add(new BasicItemListing( new ItemStack(Items.EMERALD, 3), 
                    new ItemStack(ModItems.copper_helmet.get()), 12, 1, 0.2F));
            trades.get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 7),
                    new ItemStack(ModItems.copper_chestplate.get()), 12, 1, 0.2F));
            trades.get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 5),
                    new ItemStack(ModItems.copper_leggings.get()), 12, 1, 0.2F));
            trades.get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModItems.copper_boots.get()), 12, 1, 0.2F));

            // apprentice trades
            trades.get(2).add(new BasicItemListing(new ItemStack(Items.COPPER_INGOT, 4),
                    new ItemStack(Items.EMERALD), 12, 10, 0.05F));
            trades.get(2).add(new BasicItemListing(new ItemStack(ModItems.tin_ingot.get(), 4),
                    new ItemStack(Items.EMERALD), 12, 10, 0.05F));
            trades.get(2).add(new BasicItemListing( new ItemStack(Items.EMERALD, 3), 
                    new ItemStack(ModItems.tin_leggings.get()), 12, 5, 0.2F));
            trades.get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1),
                    new ItemStack(ModItems.tin_boots.get()), 12, 5, 0.2F));
            
            // journeyman trades
            trades.get(3).add(new BasicItemListing(new ItemStack(ModItems.mythril_ingot.get()),
                    new ItemStack(Items.EMERALD), 12, 20, 0.05F));
            trades.get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 1),
                    new ItemStack(ModItems.tin_helmet.get()), 12, 10, 0.2F));
            trades.get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3),
                    new ItemStack(ModItems.tin_chestplate.get()), 12, 10, 0.2F));
            
            // expert trades
            trades.get(4).add(new VillagerTrades.EnchantedItemForEmeralds(ModItems.mythril_leggings.get(), 
                    14, 3, 15, 0.2F));
            trades.get(4).add(new VillagerTrades.EnchantedItemForEmeralds(ModItems.mythril_boots.get(), 
                    8, 3, 15, 0.2F));
            
            // master trades
            trades.get(4).add(new VillagerTrades.EnchantedItemForEmeralds(ModItems.mythril_helmet.get(), 
                    8, 3, 30, 0.2F));
            trades.get(4).add(new VillagerTrades.EnchantedItemForEmeralds(ModItems.mythril_chestplate.get(), 
                    16, 3, 30, 0.2F));
            
        } // end if ARMORER
        
        else if (evt.getType() == VillagerProfession.TOOLSMITH)
        {
            Int2ObjectMap<List<ItemListing>> trades = evt.getTrades();
            
            // novice - nothing added.

            // apprentice
            trades.get(2).add(new BasicItemListing(new ItemStack(Items.COPPER_INGOT, 4),
                    new ItemStack(Items.EMERALD), 12, 10, 0.05F));
            trades.get(2).add(new BasicItemListing(new ItemStack(ModItems.tin_ingot.get(), 4),
                    new ItemStack(Items.EMERALD), 12, 10, 0.05F));
            trades.get(2).add(new BasicItemListing( new ItemStack(Items.EMERALD, 1), 
                    new ItemStack(ModItems.copper_axe.get()), 12, 1, 0.2F));
            trades.get(2).add(new BasicItemListing( new ItemStack(Items.EMERALD, 1), 
                    new ItemStack(ModItems.copper_shovel.get()), 12, 1, 0.2F));
            trades.get(2).add(new BasicItemListing( new ItemStack(Items.EMERALD, 1), 
                    new ItemStack(ModItems.copper_hoe.get()), 12, 1, 0.2F));
            trades.get(2).add(new BasicItemListing( new ItemStack(Items.EMERALD, 1), 
                    new ItemStack(ModItems.copper_pickaxe.get()), 12, 1, 0.2F));
            trades.get(2).add(new BasicItemListing( new ItemStack(Items.EMERALD, 1), 
                    new ItemStack(ModItems.tin_axe.get()), 12, 1, 0.2F));
            trades.get(2).add(new BasicItemListing( new ItemStack(Items.EMERALD, 1), 
                    new ItemStack(ModItems.tin_shovel.get()), 12, 1, 0.2F));
            trades.get(2).add(new BasicItemListing( new ItemStack(Items.EMERALD, 1), 
                    new ItemStack(ModItems.tin_hoe.get()), 12, 1, 0.2F));
            trades.get(2).add(new BasicItemListing( new ItemStack(Items.EMERALD, 1), 
                    new ItemStack(ModItems.tin_pickaxe.get()), 12, 1, 0.2F));
            
            // journeyman
            trades.get(3).add(new BasicItemListing(new ItemStack(ModItems.mythril_ingot.get()),
                    new ItemStack(Items.EMERALD), 12, 20, 0.05F));
            trades.get(3).add(new VillagerTrades.EnchantedItemForEmeralds(ModItems.mythril_axe.get(), 
                    2, 3, 10, 0.2F));
            trades.get(3).add(new VillagerTrades.EnchantedItemForEmeralds(ModItems.mythril_shovel.get(), 
                    3, 3, 10, 0.2F));
            trades.get(3).add(new VillagerTrades.EnchantedItemForEmeralds(ModItems.mythril_pickaxe.get(), 
                    3, 3, 10, 0.2F));
            trades.get(3).add(new BasicItemListing( new ItemStack(Items.EMERALD, 1), 
                    new ItemStack(ModItems.mythril_hoe.get()), 3, 10, 0.2F));
            
            // expert trades
            trades.get(4).add(new BasicItemListing(new ItemStack(ModItems.adamantium_ingot.get(), 1),
                    new ItemStack(Items.EMERALD, 2), 12, 30, 0.05F));
            trades.get(4).add(new VillagerTrades.EnchantedItemForEmeralds(ModItems.adamantium_axe.get(), 
                    12, 3, 15, 0.2F));
            trades.get(4).add(new VillagerTrades.EnchantedItemForEmeralds(ModItems.adamantium_shovel.get(), 
                    5, 3, 15, 0.2F));

            // master trades
            trades.get(5).add(new VillagerTrades.EnchantedItemForEmeralds(ModItems.adamantium_pickaxe.get(), 
                    13, 3, 30, 0.2F));
        } // end-if TOOLSMITH
        else if (evt.getType() == VillagerProfession.WEAPONSMITH)
        {
            Int2ObjectMap<List<ItemListing>> trades = evt.getTrades();
            
            // novice
            trades.get(1).add(new BasicItemListing( new ItemStack(Items.EMERALD, 3), 
                    new ItemStack(ModItems.mythril_axe.get()), 12, 1, 0.2F));
            trades.get(1).add(new VillagerTrades.EnchantedItemForEmeralds(ModItems.mythril_sword.get(), 
                    2, 3, 1, 0.05F));
           
            // apprentice
            trades.get(2).add(new BasicItemListing(new ItemStack(Items.COPPER_INGOT, 4),
                    new ItemStack(Items.EMERALD), 12, 10, 0.05F));
            trades.get(2).add(new BasicItemListing(new ItemStack(ModItems.tin_ingot.get(), 4),
                    new ItemStack(Items.EMERALD), 12, 10, 0.05F));
            
            // journeyman
            trades.get(3).add(new BasicItemListing(new ItemStack(ModItems.mythril_ingot.get()),
                    new ItemStack(Items.EMERALD), 12, 20, 0.05F));
            
            // expert trades
            trades.get(4).add(new BasicItemListing(new ItemStack(ModItems.adamantium_ingot.get()),
                    new ItemStack(Items.EMERALD), 12, 30, 0.05F));
            trades.get(4).add(new VillagerTrades.EnchantedItemForEmeralds(ModItems.adamantium_axe.get(), 
                    12, 3, 15, 0.2F));

            // master trades
            trades.get(5).add(new VillagerTrades.EnchantedItemForEmeralds(ModItems.adamantium_sword.get(), 
                    8, 3, 30, 0.2F));

        } // end-if WEAPONSMITH
    } // end onVillagerTrades()
    
    /**
     * intercept wandering trader trades list and modify it.
     * NOTE: currently don't add any trades from SimpleOres to wandering trader.
     */
//    @SubscribeEvent
//    public static void onWandererTrades(WandererTradesEvent evt)
//    {
//        List<ItemListing> trades = evt.getGenericTrades();
//        List<ItemListing> rare_trades = evt.getRareTrades();
//        
//    } // end onWandererTrades

} // end-class
