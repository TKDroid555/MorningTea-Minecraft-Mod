package io.github.TKDroid555.Items.custom;

import io.github.TKDroid555.Effects.ModEffects;
import io.github.TKDroid555.sounds.items.ModSounds;
import net.minecraft.ChatFormatting;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.fluids.capability.wrappers.FluidBucketWrapper;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BitterLeafTeaItem extends Item {
    public BitterLeafTeaItem(Properties properties) {super(properties);}
    private static final int DRINK_DURATION = 32;

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
        if (!level.isClientSide)
        {
            if (livingEntity instanceof Player player)
            {
                player.addEffect(new MobEffectInstance(ModEffects.APPETITE_EFFECT.get(),2400, 0, false, false, true));
            }
        }
        if (livingEntity instanceof ServerPlayer serverplayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverplayer, itemStack);
            serverplayer.awardStat(Stats.ITEM_USED.get(this));
        }

        if (livingEntity instanceof Player player && !player.getAbilities().instabuild) {
            itemStack.shrink(1);

            ItemStack bottle = new ItemStack(Items.GLASS_BOTTLE);

            if (itemStack.isEmpty()) {
                return bottle;
            }

            if (!player.getInventory().add(bottle)) {
                player.drop(bottle, false);
            }
        }

        return itemStack.isEmpty() ? new ItemStack(Items.GLASS_BOTTLE) : itemStack;
    }

    public int getUseDuration(ItemStack p_42933_) {
        return 32;
    }

    public UseAnim getUseAnimation(ItemStack p_42931_) {
        return UseAnim.DRINK;
    }

    @Override
    public SoundEvent getDrinkingSound() {
        return ModSounds.TEA_DRINK.get();
    }

    public InteractionResultHolder<ItemStack> use(Level p_42927_, Player p_42928_, InteractionHand p_42929_) {
        return ItemUtils.startUsingInstantly(p_42927_, p_42928_, p_42929_);
    }

    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
        return new FluidBucketWrapper(stack);
    }

    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> components, TooltipFlag p_41424_) {
        super.appendHoverText(p_41421_, p_41422_, components, p_41424_);
        components.add(Component.translatable("item.morning_tea.bitter_leaf_tea.tooltip").withStyle(ChatFormatting.BLUE));
    }
}
