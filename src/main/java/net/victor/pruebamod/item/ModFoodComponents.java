package net.victor.pruebamod.item;

//aqui se crean las nuevas comidas

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;

/*aqui hay un ejemplo de comida que es un snack, por lo que se come rapido,
que rellena 3 puntos de hambre (1 muslito = 2 puntos) y da 0,25 de saturacion (medio muslito),
da efecto de pocion de suerte, que dura 200 ticks, tiene una probabilidad del 25% de aplicarse,
para mirar mas propiedades (en intellij) manten ctrl y dale click izq a FoodComponent, el que está
a la izq del nombre en rosa*/

public class ModFoodComponents {
    public static final FoodComponent TOMATO = new FoodComponent.Builder().snack().hunger(3).saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 200), 0.25f).build();

}
