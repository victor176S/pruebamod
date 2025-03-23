package net.victor.pruebamod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.victor.pruebamod.PruebaMod;
import net.minecraft.text.Text;
import net.victor.pruebamod.block.ModBlocks;

/*este archivo es para hacer tus propios apartado en el menu de creativo, la funcion del grupo va desde ItemGroup hasta .build());
 si no sabes (como yo) crear un grupo desde 0 de memoria, te recomiendo copiar y pegar lo dicho arriba y modificarlo a gusto
 Lo que va despues del ItemGroup es el nombre de la funcion por si te tienes que referir a la funcion del grupo,
 el nombre en verde de la linea de "PruebaMod.MOD_ID tiene que ser el mismo que el de itemgroup"
 el nombre en Text.translatable es el nombre que van a usar los archivos de traduccion para traducir el nombre del apartado,
 hay que intentar que sea igual, que el anterior nombrado
 el nombre en rosa en la linea de .icon, es el item que aparecerá en el apartado de creativo*/

public class ModItemGroups {
    public static final ItemGroup COPPERY_IRON = Registry.register(Registries.ITEM_GROUP,
            //en esta linea de abajo va la imagen del apartado
            new Identifier(PruebaMod.MOD_ID,"coppery_iron"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.coppery_iron"))
                    .icon(() -> new ItemStack(ModItems.COPPERY_IRON)).entries((displayContext, entries) -> {
                        //este nombre rosa de arriba es el icono del apartado
                        //items del apartado de creativo

                        //estos de aqui abajo son ejemplos de como se añaden items
                        entries.add(ModItems.COPPERY_IRON);
                        entries.add(ModItems.RAW_COPPERY_IRON);

                        //estos de aqui abajo son ejemplos de como se añaden items
                        entries.add(ModBlocks.COPPERY_IRON_BLOCK);
                        entries.add(ModBlocks.RAW_COPPERY_IRON_BLOCK);
                        entries.add(ModBlocks.COPPERY_IRON_ORE);

                    }).build());
    //aqui arriba se ponen los items que quieres que aparezcan en el apartado con entries.add(ModItems.NOMBRE);

    public static final ItemGroup MetalDetector = Registry.register(Registries.ITEM_GROUP,
            //en esta linea de abajo va la imagen del apartado
            new Identifier(PruebaMod.MOD_ID,"metal_detector"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.metal_detector"))
                    .icon(() -> new ItemStack(ModItems.METAL_DETECTOR)).entries((displayContext, entries) -> {

                        entries.add(ModItems.METAL_DETECTOR);

                    }).build());

    public static final ItemGroup SoundBlock = Registry.register(Registries.ITEM_GROUP,
            //en esta linea de abajo va la imagen del apartado
            new Identifier(PruebaMod.MOD_ID,"sound_block"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.sound_block"))
                    .icon(() -> new ItemStack(ModBlocks.SOUND_BLOCK)).entries((displayContext, entries) -> {

                        entries.add(ModBlocks.SOUND_BLOCK);

                    }).build());

    //aqui hay un ejemplo de apartado de creativo en el que su nombre no coincide con el nombre del item

    public static final ItemGroup FOODS = Registry.register(Registries.ITEM_GROUP,
            //en esta linea de abajo va la imagen del apartado
            new Identifier(PruebaMod.MOD_ID,"foods"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.foods"))
                    .icon(() -> new ItemStack(ModItems.TOMATO)).entries((displayContext, entries) -> {

                        entries.add(ModItems.TOMATO);

                    }).build());

    public static final ItemGroup FUELS = Registry.register(Registries.ITEM_GROUP,
            //en esta linea de abajo va la imagen del apartado
            new Identifier(PruebaMod.MOD_ID,"fuels"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.fuels"))
                    .icon(() -> new ItemStack(ModBlocks.ULTRA_COMPACTED_COAL_BLOCK)).entries((displayContext, entries) -> {

                        entries.add(ModBlocks.ULTRA_COMPACTED_COAL_BLOCK);

                    }).build());

//estos son los logs, solo cambia PruebaMod por el nombre que tengas en el archivo que esta en net.tunombre.nombremod
//que solo tenga el nombre del mod
    public static void  registerItemGroups(){
        PruebaMod.LOGGER.info("Registrando Grupos de Items para " + PruebaMod.MOD_ID);
    }
}
