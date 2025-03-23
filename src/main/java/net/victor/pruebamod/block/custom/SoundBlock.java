package net.victor.pruebamod.block.custom;

/*este es el archivo especifico de este bloque custom, en el que se definen sus funciones,
hay que hacer uno por cada bloque custom*/

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.item.Item;
import org.jetbrains.annotations.Nullable;

import java.util.List;

//se crea la clase del bloque para después poder añadirlo en ModItemGroups

public class SoundBlock extends Block {
    public SoundBlock(Settings settings){
        super(settings);
    }

    /* en este caso el bloque reproduce el sonido de xilofono del bloque de notas
     al darle click derecho */

    @Override
    public ActionResult onUse (BlockState state, World world, BlockPos pos
            ,PlayerEntity player, Hand hand, BlockHitResult hit){
        world.playSound(player, pos, SoundEvents.BLOCK_NOTE_BLOCK_XYLOPHONE.value(), SoundCategory.BLOCKS, 1f , 1f);
        return  ActionResult.SUCCESS;


    }

    //esto es para ponerle una descripcion a los items, en este caso, NO se puede traducir
    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.literal("This is a xylophone block"));
        super.appendTooltip(stack, world, tooltip, options);
    }
}
