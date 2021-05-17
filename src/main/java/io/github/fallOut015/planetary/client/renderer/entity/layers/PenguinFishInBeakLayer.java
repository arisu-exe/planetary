package io.github.fallOut015.planetary.client.renderer.entity.layers;

import com.mojang.blaze3d.matrix.MatrixStack;
import io.github.fallOut015.planetary.client.renderer.entity.model.PenguinModel;
import io.github.fallOut015.planetary.entity.passive.PenguinEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PenguinFishInBeakLayer extends LayerRenderer<PenguinEntity, PenguinModel<PenguinEntity>> {
    public PenguinFishInBeakLayer(IEntityRenderer<PenguinEntity, PenguinModel<PenguinEntity>> entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, PenguinEntity entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if(entitylivingbaseIn.hasFish()) {
            ItemStack itemstack = entitylivingbaseIn.getFish();
            matrixStackIn.pushPose();
            matrixStackIn.scale(0.75f, 0.75f, 0.75f);
//			matrixStackIn.rotate(new Quaternion(45, 0, 45, true));
//			matrixStackIn.rotate(new Quaternion(0, 0, 45, true));
            matrixStackIn.translate(0, 0.5f, 0);
            matrixStackIn.mulPose(new Quaternion(Vector3f.ZP, this.getParentModel().body.zRot, false));
            //Minecraft.getInstance().getItemRenderer().render(entitylivingbaseIn, itemstack, ItemCameraTransforms.TransformType.GROUND, false, matrixStackIn, bufferIn, packedLightIn);
            matrixStackIn.popPose();
        }
    }
}