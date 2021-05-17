package io.github.fallOut015.planetary.client.renderer.entity;

import io.github.fallOut015.planetary.MainPlanetary;
import io.github.fallOut015.planetary.client.renderer.entity.model.JellyfishModel;
import io.github.fallOut015.planetary.entity.passive.JellyfishEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class JellyfishRenderer extends MobRenderer<JellyfishEntity, JellyfishModel<JellyfishEntity>> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(MainPlanetary.MODID, "textures/entity/jellyfish.png");

    public JellyfishRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new JellyfishModel<>(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(JellyfishEntity entity) {
        return TEXTURE;
    }
}