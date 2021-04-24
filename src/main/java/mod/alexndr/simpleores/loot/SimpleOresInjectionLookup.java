package mod.alexndr.simpleores.loot;

import mod.alexndr.simplecorelib.helpers.InjectionTableLookup;

@SuppressWarnings("serial")
public class SimpleOresInjectionLookup extends InjectionTableLookup
{

    public SimpleOresInjectionLookup()
    {
        super();
        
        this.put("bastion_bridge", "bastion");
        this.put("bastion_hoglin_stable", "bastion");
        this.put("bastion_other", "bastion");
        this.put("bastion_treasure", "bastion");
        this.put("nether_bridge", "bastion");
        
        // just use 'simple_dungeon' for all this.
        this.put("shipwreck_supply", "simple_dungeon");
        this.put("shipwreck_map", "simple_dungeon");
        this.put("shipwreck_treasure", "simple_dungeon");
        
        this.put("stronghold_crossing", "simple_dungeon");
        this.put("stronghold_corridor", "simple_dungeon");
        
        this.put("underwater_ruin_small", "simple_dungeon");
        this.put("underwater_ruin_big", "simple_dungeon");
        
        // these tables all present as themselves.
        this.put("abandoned_mineshaft", "abandoned_mineshaft");
        this.put("buried_treasure", "buried_treasure");
        this.put("desert_pyramid", "desert_pyramid");
        this.put("igloo_chest", "igloo_chest");
        this.put("jungle_temple", "jungle_temple");
        this.put("ruined_portal", "ruined_portal");
        this.put("simple_dungeon", "simple_dungeon");
        this.put("spawn_bonus_chest", "spawn_bonus_chest");
        
        // villagers
        this.put("village_armorer", "village_armorer");
        this.put("village_fletcher", "village_fletcher");
        this.put("village_mason", "village_mason");
        this.put("village_shepherd", "village_shepherd");
        this.put("village_toolsmith", "village_toolsmith");
        this.put("village_weaponsmith", "village_weaponsmith");
        
    } // end ctor

} // end class
