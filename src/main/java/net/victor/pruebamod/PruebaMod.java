package net.victor.pruebamod;

import net.fabricmc.api.ModInitializer;

import net.victor.pruebamod.block.ModBlocks;
import net.victor.pruebamod.item.ModItemGroups;
import net.victor.pruebamod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//archivo principal del mod

public class PruebaMod implements ModInitializer {
	public static final String MOD_ID = "pruebamod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");

		/*si no tienes alguna de estas cosas, será mejor que lo quites, si no, dejalo asi*/

		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}