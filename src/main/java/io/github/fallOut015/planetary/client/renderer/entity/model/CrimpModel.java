package io.github.fallOut015.planetary.client.renderer.entity.model;

// Made with Blockbench 3.6.3
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import io.github.fallOut015.planetary.entity.passive.CrimpEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class CrimpModel<T extends CrimpEntity> extends EntityModel<T> {
    private final ModelRenderer body;
    private final ModelRenderer legA;
    private final ModelRenderer legB;
    private final ModelRenderer legC;
    private final ModelRenderer legD;
    private final ModelRenderer legE;
    private final ModelRenderer legF;
    private final ModelRenderer legG;
    private final ModelRenderer legH;
    private final ModelRenderer shell;
    private final ModelRenderer partA;
    private final ModelRenderer partB;
    private final ModelRenderer partC;
    private final ModelRenderer partD;
    private final ModelRenderer partE;
    private final ModelRenderer antennae;
    private final ModelRenderer right;
    private final ModelRenderer frontright;
    private final ModelRenderer left;
    private final ModelRenderer frontleft;

    public CrimpModel() {
        this.texWidth = 32;
        this.texHeight = 48;

        body = new ModelRenderer(this);
        body.setPos(0.0F, 24.0F, 0.0F);
        setRotationAngle(body, 0.0F, 3.1416F, 0.0F);
        body.texOffs(0, 11).addBox(-4.0F, -1.5F, -5.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
        body.texOffs(0, 0).addBox(-4.0F, -2.5F, -4.0F, 8.0F, 2.0F, 9.0F, 0.0F, false);

        legA = new ModelRenderer(this);
        legA.setPos(4.0F, -1.5F, 3.0F);
        body.addChild(legA);
        setRotationAngle(legA, -0.1309F, -0.3054F, 0.2182F);
        legA.texOffs(18, 11).addBox(-0.5F, 0.25F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

        legB = new ModelRenderer(this);
        legB.setPos(-4.0F, -1.5F, 3.0F);
        body.addChild(legB);
        setRotationAngle(legB, -0.1309F, 0.3054F, -0.2182F);
        legB.texOffs(18, 11).addBox(-1.5F, 0.25F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

        legC = new ModelRenderer(this);
        legC.setPos(-4.0F, -1.5F, 1.0F);
        body.addChild(legC);
        setRotationAngle(legC, -0.1309F, 0.1396F, -0.2182F);
        legC.texOffs(18, 11).addBox(-1.5F, 0.25F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

        legD = new ModelRenderer(this);
        legD.setPos(4.0F, -1.5F, 1.0F);
        body.addChild(legD);
        setRotationAngle(legD, -0.1309F, -0.1396F, 0.2182F);
        legD.texOffs(18, 11).addBox(-0.5F, 0.25F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

        legE = new ModelRenderer(this);
        legE.setPos(-4.0F, -1.5F, -1.0F);
        body.addChild(legE);
        setRotationAngle(legE, -0.1309F, -0.1396F, -0.2182F);
        legE.texOffs(18, 11).addBox(-1.5F, 0.25F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

        legF = new ModelRenderer(this);
        legF.setPos(4.0F, -1.5F, -1.0F);
        body.addChild(legF);
        setRotationAngle(legF, -0.1309F, 0.1396F, 0.2182F);
        legF.texOffs(18, 11).addBox(-0.5F, 0.25F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

        legG = new ModelRenderer(this);
        legG.setPos(-4.0F, -1.5F, -3.0F);
        body.addChild(legG);
        setRotationAngle(legG, -0.1309F, -0.3054F, -0.2182F);
        legG.texOffs(18, 11).addBox(-1.5F, 0.25F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

        legH = new ModelRenderer(this);
        legH.setPos(4.0F, -1.5F, -3.0F);
        body.addChild(legH);
        setRotationAngle(legH, -0.1309F, 0.3054F, 0.2182F);
        legH.texOffs(18, 11).addBox(-0.5F, 0.25F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

        shell = new ModelRenderer(this);
        shell.setPos(0.0F, -1.5F, -5.0F);
        body.addChild(shell);


        partA = new ModelRenderer(this);
        partA.setPos(0.0F, 0.0F, 0.0F);
        shell.addChild(partA);
        setRotationAngle(partA, 0.3054F, 0.0F, 0.0F);
        partA.texOffs(0, 13).addBox(-5.0F, -0.5F, -1.0F, 10.0F, 1.0F, 2.0F, 0.0F, false);

        partB = new ModelRenderer(this);
        partB.setPos(0.5F, -1.0F, 1.0F);
        shell.addChild(partB);
        setRotationAngle(partB, 0.1745F, 0.0F, 0.0F);
        partB.texOffs(0, 16).addBox(-6.0F, 0.0F, -1.0F, 11.0F, 1.0F, 3.0F, 0.0F, false);

        partC = new ModelRenderer(this);
        partC.setPos(0.0F, 0.0F, 0.0F);
        shell.addChild(partC);
        partC.texOffs(0, 20).addBox(-6.0F, -1.5F, 2.0F, 12.0F, 1.0F, 4.0F, 0.0F, false);

        partD = new ModelRenderer(this);
        partD.setPos(-0.5F, -0.5F, 3.0F);
        shell.addChild(partD);
        setRotationAngle(partD, -0.0873F, 0.0F, 0.0F);
        partD.texOffs(0, 25).addBox(-5.0F, -1.5F, 2.0F, 11.0F, 1.0F, 4.0F, 0.0F, false);

        partE = new ModelRenderer(this);
        partE.setPos(-0.5F, -0.5F, 9.0F);
        shell.addChild(partE);
        setRotationAngle(partE, -0.1745F, 0.0F, 0.0F);
        partE.texOffs(0, 30).addBox(-4.5F, -1.0F, -1.0F, 10.0F, 1.0F, 3.0F, 0.0F, false);

        antennae = new ModelRenderer(this);
        antennae.setPos(0.0F, 0.0F, 0.0F);
        body.addChild(antennae);


        right = new ModelRenderer(this);
        right.setPos(1.5F, -1.5F, 6.0F);
        antennae.addChild(right);
        right.texOffs(0, 34).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 0.1F, 4.0F, 0.0F, false);

        frontright = new ModelRenderer(this);
        frontright.setPos(1.0F, 0.0F, 3.0F);
        right.addChild(frontright);
        setRotationAngle(frontright, 0.0F, 0.8727F, 0.0F);
        frontright.texOffs(10, 34).addBox(-0.1984F, 0.05F, -1.7962F, 1.0F, 0.1F, 3.0F, 0.0F, false);

        left = new ModelRenderer(this);
        left.setPos(-1.5F, -1.5F, 6.0F);
        antennae.addChild(left);
        left.texOffs(0, 34).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 0.1F, 4.0F, 0.0F, false);

        frontleft = new ModelRenderer(this);
        frontleft.setPos(1.0F, 0.0F, 3.0F);
        left.addChild(frontleft);
        setRotationAngle(frontleft, 0.0F, -0.8727F, 0.0F);
        frontleft.texOffs(10, 34).addBox(-2.0858F, 0.05F, -0.2469F, 1.0F, 0.1F, 3.0F, 0.0F, false);
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        body.render(matrixStack, buffer, packedLight, packedOverlay);
    }
    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.legA.yRot = MathHelper.cos(limbSwing * 3.6662F) * 1.4F * limbSwingAmount;
        this.legB.yRot = MathHelper.cos(limbSwing * 3.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.legC.yRot = MathHelper.cos(limbSwing * 3.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.legD.yRot = MathHelper.cos(limbSwing * 3.6662F) * 1.4F * limbSwingAmount;
        this.legE.yRot = MathHelper.cos(limbSwing * 3.6662F) * 1.4F * limbSwingAmount;
        this.legF.yRot = MathHelper.cos(limbSwing * 3.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.legG.yRot = MathHelper.cos(limbSwing * 3.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.legH.yRot = MathHelper.cos(limbSwing * 3.6662F) * 1.4F * limbSwingAmount;

        this.left.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 0.9F * limbSwingAmount;
        this.right.xRot = MathHelper.cos(limbSwing * 0.6662F) * 0.9F * limbSwingAmount;
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}