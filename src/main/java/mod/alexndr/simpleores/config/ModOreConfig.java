package mod.alexndr.simpleores.config;

import net.minecraft.world.gen.placement.TopSolidRangeConfig;

public class ModOreConfig
{
    protected TopSolidRangeConfig cfg;
    protected int vein_size;
    protected int vein_count;
    
    public ModOreConfig(TopSolidRangeConfig cfg, int vein_size, int vein_count)
    {
        this.cfg = cfg;
        this.vein_size = vein_size;
        this.vein_count = vein_count;
    }

    public TopSolidRangeConfig getCfg()
    {
        return cfg;
    }

    public int getVein_size()
    {
        return vein_size;
    }

    public int getVein_count()
    {
        return vein_count;
    } 
    
    
} // end class ModOreConfig
