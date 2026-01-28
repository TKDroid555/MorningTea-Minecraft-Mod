package io.github.TKDroid555.Items.custom;

import io.github.TKDroid555.Effects.ModEffects;
import io.github.TKDroid555.Items.enums.ModArmorMaterial;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class NapkinItem extends ArmorItem {

    public NapkinItem(Properties properties)
    { super(ModArmorMaterial.NAPKIN, Type.CHESTPLATE, properties);}

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if (level.isClientSide) return;

        player.addEffect(new MobEffectInstance(ModEffects.APPETITE_EFFECT.get(),30, 0, false, false, true));
    }
}
