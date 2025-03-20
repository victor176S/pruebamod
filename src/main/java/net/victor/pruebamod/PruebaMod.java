package net.victor.pruebamod;

import net.fabricmc.api.ModInitializer;

import net.victor.pruebamod.block.ModBlocks;
import net.victor.pruebamod.item.ModItemGroups;
import net.victor.pruebamod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PruebaMod implements ModInitializer {
	public static final String MOD_ID = "pruebamod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}