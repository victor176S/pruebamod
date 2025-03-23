package net.victor.pruebamod.block;

/*aquí se añaden los bloques del mod, en los cuales se pueden definir las propiedades del minecraft vanilla,
las funciones custom se ponen en el archivo del bloque custom específico (mirar SoundBlock)*/

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.victor.pruebamod.PruebaMod;
import net.victor.pruebamod.block.custom.SoundBlock;

/*en new Block(FabricBlockSettings() se puede poner justo despues de settings .copyOf(Blocks.IRON_BLOCK)
para copiar las propiedades del bloque de hierro, se aplica a todos los demas bloques tambien

se puede poner fuera del parentesis de (Blocks.BLOQUE_DE_EJEMPLO) alguna de las propiedades de un bloque
seguida por un punto para aplicarle esa en vez de la que ya tiene, como en el ejemplo

con .create() se pueden crear las propiedades de un bloque desde 0
*/

public class ModBlocks {
    public static final Block COPPERY_IRON_BLOCK = registerBlock("coppery_iron_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block RAW_COPPERY_IRON_BLOCK = registerBlock("raw_coppery_iron_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block COPPERY_IRON_ORE = registerBlock("coppery_iron_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(2f), UniformIntProvider.create(2, 5)));

    public static final Block SOUND_BLOCK = registerBlock("sound_block",
            new SoundBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));


    //estas dos funciones registran todos los bloques e items respectivamente en el juego, son obligatorias

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(PruebaMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(PruebaMod.MOD_ID, name),
            new BlockItem(block, new FabricItemSettings()));


    }

    public static void registerModBlocks(){
        PruebaMod.LOGGER.info("Registrando Bloques para " + PruebaMod.MOD_ID);
    }
}
/*para hacer un bloque correctamente se tiene que modificar el ModBlocks (block/ModBlocks), el ModItemGroups (item/ModItemGroups),
y en la carpeta assets/nombre_mod_ejemplo tienes que crear un json en blockstates, models/block, models/item con el nombre del bloque,
luego modificarlos de la manera que se marque en los jsons ya hechos y poner la textura del bloque en textures/block */