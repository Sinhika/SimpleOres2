package mod.alexndr.simpleores.loot;

import mod.alexndr.simplecorelib.helpers.InjectionTableLookup;

@SuppressWarnings("serial")
public class SimpleOresInjectionLookup extends InjectionTableLookup
{

    public SimpleOresInjectionLookup()
    {
        super();
        this.replace("nether_bridge", "bastion");
        
        // just use 'simple_dungeon' for all this.
        this.replace("shipwreck_supply", "simple_dungeon");
        this.replace("shipwreck_map", "simple_dungeon");
        this.replace("shipwreck_treasure", "simple_dungeon");
        this.replace("stronghold_crossing", "simple_dungeon");
        this.replace("stronghold_corridor", "simple_dungeon");
        this.replace("stronghold_library", "simple_dungeon");
        this.replace("underwater_ruin_small", "simple_dungeon");
        this.replace("underwater_ruin_big", "simple_dungeon");
        
        // we don't have a 'village_house' table.
        this.replace("village_savanna_house", null);
        this.replace("village_plains_house", null);
        this.replace("village_desert_house", null);
        this.replace("village_snowy_house", null);
        this.replace("village_taiga_house", null);
        
        // these tables all present as themselves.
        this.remove("igloo_chest");
        this.remove("village_armorer");
        this.remove("village_fletcher");
        this.remove("village_mason");
        this.remove("village_shepherd");
        this.remove("village_toolsmith");
        this.remove("village_weaponsmith");
    }

} // end class
