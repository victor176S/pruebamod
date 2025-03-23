package net.victor.pruebamod.item.custom;

//este es el archivo de este item custom, habrá que crear un archivo con el nombre del item por cada objeto que se quiera añadir

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

//aqui se empieza a crear el objeto

public class MetalDetectorItem extends Item{
    public MetalDetectorItem(Settings settings){
        super(settings);
    }

    /*aqui pone que al darle click derecho a un bloque, que sea en el mundo y en client side,
    se detecte la posicion del bloque clickado, y se recoja del jugador, si no se clickea un
    bloque, no se encontrará (esto esta puesto por defecto para que no detecte bloques cuando no
    se han clickado*/

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (!context.getWorld().isClient()){
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            /*se coge la posicion clickada y se recorre hasta el 0 (con positionClicked.down), pero se añaden
            64 por las alturas negativas, se define state de la clase BlockState que coge el contexto del mundo
             coge el estado del bloque clickado, pero el de abajo por el down(i)*/

            for(int i = 0; i<=positionClicked.getY()+ 64; i++){
                BlockState state = context.getWorld().getBlockState((positionClicked).down(i));

                /* si se encuentra un bloque valioso, (funcion definida a parte en la linea 68)
                se pondrá en el chat la posicion, al jugador, del bloque, y encontrar bloque se
                pondra en verdadero*/

                if(isValuableBlock(state)){
                    outputValuableCoordinates(positionClicked.down(i), player, state.getBlock());
                    foundBlock = true;
                    
                    break;
                }
            }

            //esto pasa si no se encuentra ningun bloque valioso

            if(!foundBlock){
                player.sendMessage(Text.literal("No Valuables Found!"));
            }
        }

        //esto es para que le baje uno de durabilidad del detector del metal

        context.getStack().damage(1, context.getPlayer(),
                playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));

        return ActionResult.SUCCESS;
    }

    /* esta es la funcion que devuelve por el chat las coordenadas del bloque de esta manera:
    se utiliza la posicion del bloque, que jugador lo hace, y el bloque que se detecta
    (variables de la clase), luego, al jugador, se envia el mensaje por chat, y pone
    "Encontrado bloque (se recoge del bloque, como item, el nombre, y se pasa como una
    variable string (texto que es procesable por el programa), que está la posicion X, Y, Z
    del bloque, sin overlay*/

    private void outputValuableCoordinates(BlockPos blockPos, PlayerEntity player, Block block) {
        player.sendMessage(Text.literal("Found " + block.asItem().getName().getString()+ " at " +
                "(" + blockPos.getX() + ", " + blockPos.getY() + "," + blockPos.getZ() + ")"), false);

    }

    /*aqui se pone lo que se consideran bloques valiosos, ahora mismo estan los ores de hierro y diamante,
    el || expresa un Y en español, que quiere decir que incluye a ambos */

    private boolean isValuableBlock(BlockState state) {
        return state.isOf(Blocks.IRON_ORE) || state.isOf(Blocks.DIAMOND_ORE);
    }

    //esto es para ponerle una descripcion a los items, en este caso, se puede traducir

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.pruebamod.metal_detector.tooltip"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
