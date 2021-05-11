package com.yungnickyoung.minecraft.betterdungeons.init;

import com.yungnickyoung.minecraft.betterdungeons.BetterDungeons;
import com.yungnickyoung.minecraft.betterdungeons.world.processor.BannerProcessor;
import com.yungnickyoung.minecraft.betterdungeons.world.processor.CeilingLampPropProcessor;
import com.yungnickyoung.minecraft.betterdungeons.world.processor.CeilingPropProcessor;
import com.yungnickyoung.minecraft.betterdungeons.world.processor.WaterloggedProcessor;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.template.IStructureProcessorType;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ModProcessors {
    public static IStructureProcessorType<WaterloggedProcessor> WATERLOGGED_PROCESSOR = () -> WaterloggedProcessor.CODEC;
    public static IStructureProcessorType<CeilingPropProcessor> SMALL_DUNGEON_CEILING_PROP_PROCESSOR = () -> CeilingPropProcessor.CODEC;
    public static IStructureProcessorType<CeilingLampPropProcessor> SMALL_DUNGEON_CEILING_LAMP_PROCESSOR = () -> CeilingLampPropProcessor.CODEC;
    public static IStructureProcessorType<BannerProcessor> SMALL_DUNGEON_BANNER_PROCESSOR = () -> BannerProcessor.CODEC;

    public static void init() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ModProcessors::commonSetup);
    }

    private static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            Registry.register(Registry.STRUCTURE_PROCESSOR, new ResourceLocation(BetterDungeons.MOD_ID, "waterlogged_processor"), WATERLOGGED_PROCESSOR);
            Registry.register(Registry.STRUCTURE_PROCESSOR, new ResourceLocation(BetterDungeons.MOD_ID, "small_dungeon_ceiling_prop_processor"), SMALL_DUNGEON_CEILING_PROP_PROCESSOR);
            Registry.register(Registry.STRUCTURE_PROCESSOR, new ResourceLocation(BetterDungeons.MOD_ID, "small_dungeon_ceiling_lamp_processor"), SMALL_DUNGEON_CEILING_LAMP_PROCESSOR);
            Registry.register(Registry.STRUCTURE_PROCESSOR, new ResourceLocation(BetterDungeons.MOD_ID, "small_dungeon_banner_processor"), SMALL_DUNGEON_BANNER_PROCESSOR);
        });
    }
}
