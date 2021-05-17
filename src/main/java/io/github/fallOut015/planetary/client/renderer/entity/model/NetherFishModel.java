package io.github.fallOut015.planetary.client.renderer.entity.model;

// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import io.github.fallOut015.planetary.entity.monster.NetherFishEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class NetherFishModel<T extends NetherFishEntity> extends EntityModel<T> {
    private final ModelRenderer body;
    private final ModelRenderer rightFin;
    private final ModelRenderer leftFin;
    private final ModelRenderer tail;
    private final ModelRenderer head;

    public NetherFishModel() {
        this.texWidth = 32;
        this.texHeight = 32;

        body = new ModelRenderer(this);
        body.setPos(0.0F, 21.6667F, 0.0F);
        body.texOffs(0, 0).addBox(-1.0F, -1.6667F, -4.0F, 2.0F, 4.0F, 8.0F, 0.0F, false);
        body.texOffs(0, 0).addBox(0.0F, -3.6667F, -2.0F, 0.0F, 2.0F, 4.0F, 0.0F, false);

        rightFin = new ModelRenderer(this);
        rightFin.setPos(-1.0F, 1.8333F, -2.2493F);
        body.addChild(rightFin);
        setRotationAngle(rightFin, 0.0F, 0.3927F, 0.0F);
        rightFin.texOffs(0, 0).addBox(-2.0776F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);

        leftFin = new ModelRenderer(this);
        leftFin.setPos(1.0F, 1.8333F, -2.2493F);
        body.addChild(leftFin);
        setRotationAngle(leftFin, 0.0F, -0.3927F, 0.0F);
        leftFin.texOffs(0, 0).addBox(-0.0776F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);

        tail = new ModelRenderer(this);
        tail.setPos(0.0F, 22.0F, 4.0F);
        tail.texOffs(0, 8).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 0.0F, false);
        tail.texOffs(0, 12).addBox(0.0F, -2.0F, 4.0F, 0.0F, 4.0F, 2.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setPos(0.0F, 23.0F, -4.0F);
        head.texOffs(8, 12).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
        head.texOffs(8, 12).addBox(0.0F, 0.0F, -7.0F, 0.0F, 1.0F, 6.0F, 0.0F, false);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        this.tail.yRot = MathHelper.cos(limbSwing * 0.75f) * limbSwingAmount;
        this.body.yRot = MathHelper.cos(limbSwing * 0.5f) * limbSwingAmount * 0.75f;
        this.leftFin.yRot = MathHelper.sin(limbSwing) * limbSwingAmount * 2f + 0.3927F;
        this.rightFin.yRot = MathHelper.cos(limbSwing) * limbSwingAmount * 2f + 0.3927F;
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        tail.render(matrixStack, buffer, packedLight, packedOverlay);
        head.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}