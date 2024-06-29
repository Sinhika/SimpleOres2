package mod.alexndr.simpleores.config;

import net.neoforged.neoforge.common.NeoForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;


/**
 * This holds the Client & Server Configs and the Client & Server ConfigSpecs.
 * It can be merged into the main ExampleModConfig class, but is separate because of personal preference and to keep the code organised
 *
 * @author Cadiboo
 */
public final class ConfigHolder
{
    public static final NeoForgeConfigSpec CLIENT_SPEC;
	public static final NeoForgeConfigSpec SERVER_SPEC;
    static final ClientConfig CLIENT;
	public static final ServerConfig SERVER;
	static {
        {
            final Pair<ClientConfig, NeoForgeConfigSpec> specPair = new NeoForgeConfigSpec.Builder().configure(ClientConfig::new);
            CLIENT = specPair.getLeft();
            CLIENT_SPEC = specPair.getRight();
        }
		{
			final Pair<ServerConfig, NeoForgeConfigSpec> specPair = new NeoForgeConfigSpec.Builder().configure(ServerConfig::new);
			SERVER = specPair.getLeft();
			SERVER_SPEC = specPair.getRight();
		}
	}
} // end class
