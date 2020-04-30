package mod.alexndr.simpleores.api.config;

/**
 * Provides some necessary functions that our configs will need to respond to 
 * various condition checks.
 *
 */
public interface ISimpleConfig
{
    /**
     * get the value of flag "n".
     * @param n - name of flag
     * @return boolean value.
     */
    public boolean getFlag(String n);
    
    /**
     * clear the flag collection.
     */
    public void clear();
    
    /**
     * add a flag to the flag collection
     * @param n - name of flag
     * @param val - boolean value of flag
     */
    public void putFlag(String n, boolean val);
} // end interface
