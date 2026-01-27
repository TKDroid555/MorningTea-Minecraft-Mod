package io.github.TKDroid555.Items.custom;

import io.github.TKDroid555.sounds.items.ModSounds;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class BitterLeafTeaItem extends MilkBucketItem {
    public BitterLeafTeaItem(Properties properties) {super(properties);}

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
        if (!level.isClientSide)
        {
            livingEntity.addEffect(new MobEffectInstance(
                    MobEffects.HUNGER,
                    100,
                    255,
                    false,
                    false
            ));
        }
        if (livingEntity instanceof ServerPlayer serverplayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayer, itemStack);
            serverplayer.awardStat(Stats.ITEM_USED.get(this));
        }

        if (livingEntity instanceof Player && !((Player)livingEntity).getAbilities().instabuild) {
            itemStack.shrink(1);
        }

        return itemStack.isEmpty() ? new ItemStack(Items.GLASS_BOTTLE) : itemStack;
    }

    @Override
    public SoundEvent getDrinkingSound() {
        return ModSounds.TEA_DRINK.get();
    }
}
