package io.github.fallOut015.planetary.client.renderer.entity.model;

// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import io.github.fallOut015.planetary.entity.passive.PenguinEntity;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PenguinModel<T extends PenguinEntity> extends AgeableModel<T> {
    public final ModelRenderer body;
    private final ModelRenderer leftFoot;
    private final ModelRenderer rightFoot;
    private final ModelRenderer leftArm;
    private final ModelRenderer rightArm;
    private final ModelRenderer head;
    private final ModelRenderer beakUpper;
    private final ModelRenderer beakLower;

    public PenguinModel() {
        this.texWidth = 32;
        this.texHeight = 32;

        body = new ModelRenderer(this);
        body.setPos(0.0F, 24.0F, 0.0F);
        body.texOffs(0, 0).addBox(-3.0F, -13.0F, -3.0F, 6.0F, 12.0F, 4.0F, 0.0F, false);

        leftFoot = new ModelRenderer(this);
        leftFoot.setPos(2.0F, -1.0F, 0.0F);
        body.addChild(leftFoot);
        leftFoot.texOffs(0, 16).addBox(-1.0F, 0.0F, -4.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);

        rightFoot = new ModelRenderer(this);
        rightFoot.setPos(-2.0F, -1.0F, 0.0F);
        body.addChild(rightFoot);
        rightFoot.texOffs(12, 16).addBox(-1.0F, 0.0F, -4.0F, 2.0F, 1.0F, 4.0F, 0.0F, false);

        leftArm = new ModelRenderer(this);
        leftArm.setPos(4.5F, -11.5F, -0.5F);
        body.addChild(leftArm);
        setRotationAngle(leftArm, 0.0F, 0.0F, -0.1309F);
        leftArm.texOffs(24, 0).addBox(-1.4914F, -0.6305F, -1.5F, 1.0F, 9.0F, 3.0F, 0.0F, false);

        rightArm = new ModelRenderer(this);
        rightArm.setPos(-4.5F, -11.5F, -0.5F);
        body.addChild(rightArm);
        setRotationAngle(rightArm, 0.0F, 0.0F, 0.1309F);
        rightArm.texOffs(24, 12).addBox(0.4914F, -0.6305F, -1.5F, 1.0F, 9.0F, 3.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setPos(0.0F, -13.5F, -0.25F);
        body.addChild(head);
        head.texOffs(0, 21).addBox(-2.0F, -3.5F, -1.75F, 4.0F, 4.0F, 3.0F, 0.0F, false);

        beakUpper = new ModelRenderer(this);
        beakUpper.setPos(0.0F, -1.5F, -1.75F);
        head.addChild(beakUpper);
        beakUpper.texOffs(0, 28).addBox(-1.0F, -0.5F, -2.0F, 2.0F, 0.5F, 2.0F, 0.0F, false);

        beakLower = new ModelRenderer(this);
        beakLower.setPos(0.0F, -1.5F, -1.75F);
        head.addChild(beakLower);
        beakLower.texOffs(0, 28).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 0.5F, 2.0F, 0.0F, false);
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        if(this.young) {
            matrixStack.pushPose();
            matrixStack.scale(0.5f, 0.5f, 0.5f);
            matrixStack.translate(0, 1.5f, 0);
        }
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        if(this.young) {
            matrixStack.popPose();
        }
    }
    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        if(entityIn.hasFish()) {
            this.beakUpper.xRot = -0.5f;
            this.beakLower.xRot = 0.5f;
            this.head.xRot = -0.5f;
        } else {
            this.beakUpper.xRot = 0;
            this.beakLower.xRot = 0;
            this.head.xRot = 0;
        }

        this.body.zRot = MathHelper.clamp(MathHelper.cos(limbSwing * 2.6648f) * 0.4f * limbSwingAmount, -0.1816687434911728f, 0.1816687434911728f); // w a d d l e
        this.leftArm.zRot = MathHelper.clamp(-2f * limbSwingAmount - 0.1309F, -0.7432956695556641f, -0.1309F);
        this.rightArm.zRot = MathHelper.clamp(2f * limbSwingAmount + 0.1309F, 0.1309F, 0.7432956695556641f);
        this.leftFoot.xRot = MathHelper.cos(limbSwing * 2.8662F) * 0.8f * limbSwingAmount;
        this.rightFoot.xRot = MathHelper.cos(limbSwing * 2.8662F) * -0.8f * limbSwingAmount;
    }
    @Override
    protected Iterable<ModelRenderer> headParts() {
        return ImmutableList.of(this.head, this.beakLower, this.beakUpper);
    }
    @Override
    protected Iterable<ModelRenderer> bodyParts() {
        return ImmutableList.of(this.body, this.rightArm, this.leftArm, this.rightFoot, this.leftFoot);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}