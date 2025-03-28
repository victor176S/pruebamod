package net.victor.pruebamod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.tutorial.TutorialManager;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.victor.pruebamod.PruebaMod;
import net.victor.pruebamod.PruebaModClient;
import net.victor.pruebamod.item.custom.MetalDetectorItem;

//aqui se registran los items

public class ModItems {

    /*aqui se asigna la id del item, lo que aparece en rosa por lo general es a como te vas a referir al objeto
    dentro del programa, lo verde es el nombre que sale cuando pones el raton encima con el F3 + H puesto,
    aunque tambien es a como se refiere en los archivos jsons de la carpeta resources

    cada item va desde public hasta FabricItemSettings()));
    puedes copiar y pegar lo antes nombrado para registrar un item nuevo*/

    public static final Item COPPERY_IRON = registerItem("coppery_iron_ingot", new Item(new FabricItemSettings()));
    public static final Item RAW_COPPERY_IRON = registerItem("raw_coppery_iron", new Item(new FabricItemSettings()));

    public static final Item METAL_DETECTOR = registerItem("metal_detector",
            new MetalDetectorItem(new FabricItemSettings().maxDamage(64)));

    public static final Item TOMATO = registerItem("tomato", new Item(new FabricItemSettings().food(ModFoodComponents.TOMATO)));

    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries){
        /*por cada item añadido tienes que poner entries.add(nombre en mayusculas que aparece a la derecha de
        Item en las lineas de arriba*/
        entries.add(COPPERY_IRON);
        entries.add(RAW_COPPERY_IRON);
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(PruebaMod.MOD_ID, name),item);
    }

    public static void registerModItems(){
        PruebaMod.LOGGER.info("Registrando Items para el mod " + PruebaMod.MOD_ID);

        /*aqui se asigna a que apartado de creativo quieres que se ponga, el nombre en rosa es el nombre del apartado del mc vanilla
        */
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }

}
