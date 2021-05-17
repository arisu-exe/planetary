package io.github.fallOut015.planetary.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import io.github.fallOut015.planetary.MainPlanetary;
import io.github.fallOut015.planetary.client.renderer.entity.model.NetherFishModel;
import io.github.fallOut015.planetary.entity.monster.NetherFishEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class NetherFishRenderer extends MobRenderer<NetherFishEntity, NetherFishModel<NetherFishEntity>> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(MainPlanetary.MODID, "textures/entity/nether_fish.png");

    public NetherFishRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new NetherFishModel<>(), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(NetherFishEntity entity) {
        return TEXTURE;
    }
    @Override
    protected void scale(NetherFishEntity entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        super.scale(entitylivingbaseIn, matrixStackIn, partialTickTime);

        matrixStackIn.pushPose();
        matrixStackIn.scale(1.2f, 1.2f, 1.2f);
        matrixStackIn.popPose();
    }
}