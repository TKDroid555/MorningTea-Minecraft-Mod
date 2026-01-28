package io.github.TKDroid555.Items.custom;

import io.github.TKDroid555.Effects.ModEffects;
import io.github.TKDroid555.Items.enums.ModArmorMaterial;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class NapkinItem extends ArmorItem {

    public NapkinItem(Properties properties)
    { super(ModArmorMaterial.NAPKIN, Type.CHESTPLATE, properties);}

    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if (level.isClientSide) return;

        player.addEffect(new MobEffectInstance(ModEffects.APPETITE_EFFECT.get(),30, 0, false, false, true));
    }

    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> components, TooltipFlag p_41424_) {
        super.appendHoverText(p_41421_, p_41422_, components, p_41424_);
        components.add(Component.translatable("item.morning_tea.napkin.tooltip").withStyle(ChatFormatting.GRAY));
    }
}
