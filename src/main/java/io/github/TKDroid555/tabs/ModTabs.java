package io.github.TKDroid555.tabs;

import io.github.TKDroid555.Items.ModItems;
import io.github.TKDroid555.MorningTea;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MorningTea.MODID);

    public static final RegistryObject<CreativeModeTab> MORNING_TEA_TAB =
            TABS.register("morning_tea_tab", () ->
                    CreativeModeTab.builder()
                            .title(Component.translatable("creativetab.morning_tea"))
                            .icon(() -> new ItemStack(ModItems.BITTER_LEAF_TEA.get()))
                            .displayItems((params, output) -> {
                                //Add items to creative menus here
                                output.accept(ModItems.BITTER_LEAF_TEA.get());
                                output.accept(ModItems.BOOZE.get());
                                output.accept(ModItems.BEER.get());
                                output.accept(ModItems.NAPKIN.get());
                            })
                            .build()
            );

    public static void register(IEventBus eventBus)
    {TABS.register(eventBus);}
}
