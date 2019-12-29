package net.fexcraft.mod.bgm;

import org.apache.logging.log4j.Logger;

import net.fexcraft.lib.mc.network.SimpleUpdateHandler;
import net.fexcraft.lib.mc.registry.FCLRegistry;
import net.fexcraft.lib.mc.registry.FCLRegistry.AutoRegisterer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;

@Mod(modid = BGM.MODID, name = BGM.NAME, version = BGM.VERSION, dependencies = "required-after:fcl", acceptedMinecraftVersions = "*", acceptableRemoteVersions = "*")
public class BGM {
	
	public static final String VERSION = "@VERSION@";
	public static final String MODID = "bgm";
	public static final String NAME = "Board Game Mod";
	public static final String ADMIN_PERM = "bgm.admin";
	public static final String PREFIX = "&1[&2BGM&1]";
	//
	@Mod.Instance(MODID)
	public static BGM INSTANCE;
	public static AutoRegisterer REG;
    public static Logger LOGGER;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event){
        LOGGER = event.getModLog(); REG = FCLRegistry.newAutoRegistry(MODID);
	}
	
	@Mod.EventHandler
	public void properInit(FMLInitializationEvent event){
		//
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event){
		SimpleUpdateHandler.register(MODID, 1, VERSION);
		SimpleUpdateHandler.setUpdateMessage(MODID, PREFIX + " &7New Version available! &0(&8" + SimpleUpdateHandler.getLatestVersionOf(MODID) + "&0)");
	}
	
	@Mod.EventHandler
	public void serverStarting(FMLServerStartingEvent event){
		//
	}
	
	@Mod.EventHandler
	public void serverStarted(FMLServerStartedEvent event){
		//
	}
	
	@Mod.EventHandler
	public void serverStopping(FMLServerStoppingEvent event){
		//
	}

}
