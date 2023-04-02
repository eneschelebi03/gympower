package com.example.gympower;

import com.example.gympower.model.entity.Category;
import com.example.gympower.model.entity.Picture;
import com.example.gympower.model.entity.enums.ProductCategoriesEnum;
import com.example.gympower.model.entity.enums.SpecialFeaturesEnum;
import com.example.gympower.model.entity.products.ExclusiveOffer;
import com.example.gympower.model.entity.products.supplements.Cut;
import com.example.gympower.model.entity.products.supplements.Flavor;
import com.example.gympower.model.entity.products.supplements.SpecialFeature;
import com.example.gympower.model.entity.products.supplements.Supplement;
import com.example.gympower.model.entity.products.wear.Color;
import com.example.gympower.model.entity.products.wear.Size;
import com.example.gympower.model.entity.products.wear.Wear;
import com.example.gympower.repository.*;
import com.example.gympower.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Component
public class GympowerAppInit implements CommandLineRunner {

    private final SupplementRepository supplementRepository;

    private final PictureRepository pictureRepository;

    private final CutRepository cutRepository;

    private final WearRepository wearRepository;
    private final FlavorRepository flavorRepository;
    private final SpecialFeatureRepository specialFeatureRepository;
    private final CategoryRepository categoryRepository;
    private final SizeRepository sizeRepository;
    private final ColorRepository colorRepository;

    private final ExclusiveOfferRepository exclusiveOfferRepository;

    private final UserService userService;

    public GympowerAppInit(SupplementRepository supplementRepository, PictureRepository pictureRepository, CutRepository cutRepository, WearRepository wearRepository, FlavorRepository flavorRepository, SpecialFeatureRepository specialFeatureRepository, CategoryRepository categoryRepository, SizeRepository sizeRepository, ColorRepository colorRepository, ExclusiveOfferRepository exclusiveOfferRepository, UserService userService) {
        this.supplementRepository = supplementRepository;
        this.pictureRepository = pictureRepository;
        this.cutRepository = cutRepository;
        this.wearRepository = wearRepository;
        this.flavorRepository = flavorRepository;
        this.specialFeatureRepository = specialFeatureRepository;
        this.categoryRepository = categoryRepository;
        this.sizeRepository = sizeRepository;
        this.colorRepository = colorRepository;
        this.exclusiveOfferRepository = exclusiveOfferRepository;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        supplementsInit();
        wearInit();
        initUsers();
    }

    private void supplementsInit() {
        Cut cut25 = new Cut()
                .setUnit("KG")
                .setQuantity(2.5)
                .setCost(BigDecimal.valueOf(41.32))
                .setPrice(BigDecimal.valueOf(129.99))
                .setProduced(100);

        Cut cut1 = new Cut()
                .setUnit("KG")
                .setQuantity(1)
                .setCost(BigDecimal.valueOf(35.86))
                .setPrice(BigDecimal.valueOf(47.89))
                .setProduced(100);

        Cut cut500 = new Cut()
                .setUnit("G")
                .setQuantity(500)
                .setCost(BigDecimal.valueOf(16.42))
                .setPrice(BigDecimal.valueOf(23.99))
                .setProduced(100);

        Cut cut5 = new Cut()
                .setUnit("KG")
                .setQuantity(5)
                .setCost(BigDecimal.valueOf(173.74))
                .setPrice(BigDecimal.valueOf(199.99))
                .setProduced(100);

        Cut cut60 = new Cut()
                .setUnit("G")
                .setQuantity(60)
                .setCost(BigDecimal.valueOf(1.58))
                .setPrice(BigDecimal.valueOf(3.39))
                .setProduced(100);

        Cut cut40 = new Cut()
                .setUnit("G")
                .setQuantity(40)
                .setCost(BigDecimal.valueOf(0.97))
                .setPrice(BigDecimal.valueOf(2.89))
                .setProduced(100);

        Cut cut100g = new Cut()
                .setQuantity(100)
                .setUnit("G")
                .setCost(BigDecimal.valueOf(17.89))
                .setPrice(BigDecimal.valueOf(25.99))
                .setProduced(100);

        Cut cutBox = new Cut()
                .setQuantity(0)
                .setUnit("12 x 65")
                .setCost(BigDecimal.valueOf(15.86))
                .setPrice(BigDecimal.valueOf(21.99))
                .setProduced(100);

        Cut cut60serv = new Cut()
                .setQuantity(60)
                .setUnit("servings")
                .setCost(BigDecimal.valueOf(27.46))
                .setPrice(BigDecimal.valueOf(36.99))
                .setProduced(100);

        Cut cut60tab = new Cut()
                .setQuantity(60)
                .setUnit("tablets")
                .setCost(BigDecimal.valueOf(14.23))
                .setPrice(BigDecimal.valueOf(19.99))
                .setProduced(100);

        Cut cut100tab = new Cut()
                .setQuantity(100)
                .setUnit("tablets")
                .setCost(BigDecimal.valueOf(22.23))
                .setPrice(BigDecimal.valueOf(34.99))
                .setProduced(100);

        Cut cut90caps = new Cut()
                .setQuantity(90)
                .setUnit("capsules")
                .setCost(BigDecimal.valueOf(24.67))
                .setPrice(BigDecimal.valueOf(29.99))
                .setProduced(100);

        Cut cut250caps = new Cut()
                .setQuantity(250)
                .setUnit("capsules")
                .setCost(BigDecimal.valueOf(40.24))
                .setPrice(BigDecimal.valueOf(52.99))
                .setProduced(100);

        Cut cut250tabs = new Cut()
                .setQuantity(250)
                .setUnit("tablets")
                .setCost(BigDecimal.valueOf(78.97))
                .setPrice(BigDecimal.valueOf(89.99))
                .setProduced(100);

        Cut cut240tabs = new Cut()
                .setQuantity(240)
                .setUnit("tablets")
                .setCost(BigDecimal.valueOf(91.14))
                .setPrice(BigDecimal.valueOf(98.99))
                .setProduced(100);

        Cut cut120tabs = new Cut()
                .setQuantity(120)
                .setUnit("tablets")
                .setCost(BigDecimal.valueOf(47.72))
                .setPrice(BigDecimal.valueOf(55.99))
                .setProduced(100);


        cut25 = this.cutRepository.save(cut25);
        cut1 = this.cutRepository.save(cut1);
        cut500 = this.cutRepository.save(cut500);
        cut5 = this.cutRepository.save(cut5);
        cut60 = this.cutRepository.save(cut60);
        cut40 = this.cutRepository.save(cut40);
        cut100g = this.cutRepository.save(cut100g);
        cutBox = this.cutRepository.save(cutBox);
        cut60serv = this.cutRepository.save(cut60serv);
        cut60tab = this.cutRepository.save(cut60tab);
        cut100tab = this.cutRepository.save(cut100tab);
        cut90caps = this.cutRepository.save(cut90caps);
        cut250caps = this.cutRepository.save(cut250caps);
        cut250tabs = this.cutRepository.save(cut250tabs);
        cut240tabs = this.cutRepository.save(cut240tabs);
        cut120tabs = this.cutRepository.save(cut120tabs);


        Picture proteinPic = new Picture()
                .setTitle("Protein")
                .setUrl("/pictures/wheyProtein.webp");
        Picture proteinPicSide = new Picture()
                .setTitle("Protein")
                .setUrl("/pictures/wheyProteinSide.webp");
        Picture theWhey = new Picture()
                .setTitle("Advanced Protein")
                .setUrl("/pictures/TheWhey.webp");
        Picture barPicture = new Picture()
                .setTitle("ChocoStorm Bar")
                .setUrl("/pictures/barChoco.webp");
        Picture barPictureAtr = new Picture()
                .setTitle("ChocoStorm Bar Attractive")
                .setUrl("/pictures/barChocoAtr.webp");
        Picture  barPicture2 = new Picture()
                .setTitle("Layered Bar Pack")
                .setUrl("/pictures/layeredBarPack.webp");
        Picture barPicture3 = new Picture()
                .setTitle("Layered Bar Pack Piece")
                .setUrl("/pictures/layeredBarPiece.webp");
        Picture barPicturePack = new Picture()
                .setTitle("Layered Bar")
                .setUrl("/pictures/layeredBarAtr.webp");
        Picture barPictureCoffee = new Picture()
                .setTitle("CoffeeStorm Bar Pack")
                .setUrl("/pictures/Protein_Bar_Coffe.jpeg");
        Picture wafflePicturePack = new Picture()
                .setTitle("Waffle Pack")
                .setUrl("/pictures/protein waffles.jpg");
        Picture wafflePicturePack2 = new Picture()
                .setTitle("Waffle Pack 2")
                .setUrl("/pictures/protein waffles 2.jpg");
        Picture waffleOnePiece = new Picture()
                .setTitle("Waffle One Piece")
                .setUrl("/pictures/protein waffle.jpg");
        Picture waffleCreamPack = new Picture()
                .setTitle("Waffle Cream Pack")
                .setUrl("/pictures/cream waffle pack.jpg");
        Picture waffleCreamPack2 = new Picture()
                .setTitle("Waffle Cream Pack")
                .setUrl("/pictures/cream waffle pack 2.jpg");
        Picture waffleCreamPiece = new Picture()
                .setTitle("Waffle Cream Piece")
                .setUrl("/pictures/waffle cream piece.jpg");

        Picture vegProElderflower = new Picture()
                .setTitle("Vegan protein elderflower")
                .setUrl("/pictures/vegan protein elderflower.png");

        Picture vegProElderflower2 = new Picture()
                .setTitle("Waffle Cream Piece")
                .setUrl("/pictures/vegan protein elderflower 2.jpg");

        Picture vegProToffeeApple = new Picture()
                .setTitle("vegan protein toffee apple")
                .setUrl("/pictures/veg pro toffee apple.jpg");

        Picture vegProStrawberry = new Picture()
                .setTitle("Vegan protein strawberry")
                .setUrl("/pictures/veg pro strawberry.png");

        Picture vegProStrawberry2 = new Picture()
                .setTitle("Vegan protein strawberry 2")
                .setUrl("/pictures/veg pro strawberry 2.png");

        Picture vegProLime = new Picture()
                .setTitle("Vegan Protein lime")
                .setUrl("/pictures/vegan protein lime.png");

        Picture vegProLime2 = new Picture()
                .setTitle("Vegan Protein lime")
                .setUrl("/pictures/vegan protein lime2.png");

        Picture vitaminCPic = new Picture()
                .setTitle("VitaminC")
                .setUrl("/pictures/vitaminC.jpg");

        Picture vitaminDPic = new Picture()
                .setTitle("VitaminC")
                .setUrl("/pictures/vitaminD.jpg");

        Picture multivitaminPic = new Picture()
                .setTitle("Daily Multivitamin Tablets")
                .setUrl("/pictures/daily_multivitamin.jpg");

        Picture omega3Pic = new Picture()
                .setTitle("Omega-3 Essentials")
                .setUrl("/pictures/omega3.jpg");

        Picture creatineTabsPic = new Picture()
                .setTitle("Creatine Tabs")
                .setUrl("/pictures/creatineTabs.jpg");

        Picture alphaMenPic = new Picture()
                .setTitle("Alpha Men Multivitamin")
                .setUrl("/pictures/alphaMen.jpg");

        Picture vitaminDiscount = new Picture()
                .setTitle("Vitamin Offer")
                .setUrl("/pictures/vitamins_discount.png");

        proteinPic = this.pictureRepository.save(proteinPic);
        proteinPicSide = this.pictureRepository.save(proteinPicSide);
        theWhey = this.pictureRepository.save(theWhey);

        barPicture = this.pictureRepository.save(barPicture);
        barPictureAtr = this.pictureRepository.save(barPictureAtr);
        barPicture2 = this.pictureRepository.save(barPicture2);
        barPicture3 = this.pictureRepository.save(barPicture3);
        barPicturePack = this.pictureRepository.save(barPicturePack);
        barPictureCoffee = this.pictureRepository.save(barPictureCoffee);

        wafflePicturePack = this.pictureRepository.save(wafflePicturePack);
        wafflePicturePack2 = this.pictureRepository.save(wafflePicturePack2);
        waffleOnePiece = this.pictureRepository.save(waffleOnePiece);
        waffleCreamPack = this.pictureRepository.save(waffleCreamPack);
        waffleCreamPack2 = this.pictureRepository.save(waffleCreamPack2);
        waffleCreamPiece = this.pictureRepository.save(waffleCreamPiece);

        vegProElderflower = this.pictureRepository.save(vegProElderflower);
        vegProElderflower2 = this.pictureRepository.save(vegProElderflower2);
        vegProToffeeApple = this.pictureRepository.save(vegProToffeeApple);
        vegProStrawberry = this.pictureRepository.save(vegProStrawberry);
        vegProStrawberry2 = this.pictureRepository.save(vegProStrawberry2);
        vegProLime = this.pictureRepository.save(vegProLime);
        vegProLime2 = this.pictureRepository.save(vegProLime2);

        vitaminCPic = this.pictureRepository.save(vitaminCPic);
        vitaminDPic = this.pictureRepository.save(vitaminDPic);
        multivitaminPic = this.pictureRepository.save(multivitaminPic);
        omega3Pic = this.pictureRepository.save(omega3Pic);
        creatineTabsPic = this.pictureRepository.save(creatineTabsPic);
        alphaMenPic = this.pictureRepository.save(alphaMenPic);

        vitaminDiscount = this.pictureRepository.save(vitaminDiscount);

        Flavor flavor1 = new Flavor()
                .setFlavorName("Banana")
                .setPictures(Set.of(proteinPic, proteinPicSide))
                .setCuts(Set.of(cut25, cut1, cut500, cut5))
                .setAvailable(true);
        Flavor flavor2 = new Flavor()
                .setFlavorName("Banana Creme")
                .setPictures(Set.of(proteinPic, proteinPicSide))
                .setCuts(Set.of(cut25, cut1, cut500))
                .setAvailable(true);
        Flavor flavor3 = new Flavor()
                .setFlavorName("Biscuits With Creme")
                .setPictures(Set.of(proteinPic, proteinPicSide))
                .setCuts(Set.of(cut25, cut1, cut500, cut5))
                .setAvailable(true);
        Flavor flavor4 = new Flavor()
                .setFlavorName("Caramel Toffee Fudge")
                .setPictures(Set.of(proteinPic, proteinPicSide))
                .setCuts(Set.of(cut1, cut500))
                .setAvailable(true);
        Flavor flavor5 = new Flavor()
                .setFlavorName("Chocolate")
                .setPictures(Set.of(proteinPic, proteinPicSide))
                .setCuts(Set.of(cut25, cut1, cut500, cut5))
                .setAvailable(true);
        Flavor flavor6 = new Flavor()
                .setFlavorName("Chocolate Peanut Butter")
                .setPictures(Set.of(proteinPic, proteinPicSide))
                .setCuts(Set.of(cut1, cut500))
                .setAvailable(true);
        Flavor flavor7 = new Flavor()
                .setFlavorName("Cookies Creme")
                .setPictures(Set.of(proteinPic, proteinPicSide))
                .setCuts(Set.of(cut25, cut1, cut500, cut5))
                .setAvailable(true);
        Flavor flavor8 = new Flavor()
                .setFlavorName("Delicious Strawberry")
                .setPictures(Set.of(proteinPic, proteinPicSide))
                .setCuts(Set.of(cut25, cut1, cut500, cut5))
                .setAvailable(true);
        Flavor flavor9 = new Flavor()
                .setFlavorName("Don't Know")
                .setPictures(Set.of(proteinPic, proteinPicSide))
                .setCuts(Set.of(cut25, cut1))
                .setAvailable(true);
        Flavor flavor10 = new Flavor()
                .setFlavorName("Double Rich Chocolate")
                .setPictures(Set.of(proteinPic, proteinPicSide))
                .setCuts(Set.of(cut1, cut500))
                .setAvailable(true);
        Flavor flavor11 = new Flavor()
                .setFlavorName("Vanilla Ice Cream")
                .setPictures(Set.of(proteinPic, proteinPicSide))
                .setCuts(Set.of(cut25, cut1, cut500, cut5))
                .setAvailable(true);

        Flavor flavor12 = new Flavor()
                .setFlavorName("Cookies Cream")
                .setPictures(Set.of(theWhey))
                .setCuts(Set.of(cut25, cut1, cut500))
                .setAvailable(true);
        Flavor flavor13 = new Flavor()
                .setFlavorName("Caramel Toffee Fudge")
                .setPictures(Set.of(theWhey))
                .setCuts(Set.of(cut1, cut500))
                .setAvailable(true);
        Flavor flavor14 = new Flavor()
                .setFlavorName("Double Rich Chocolate")
                .setPictures(Set.of(theWhey))
                .setCuts(Set.of(cut1, cut500, cut5))
                .setAvailable(true);
        Flavor flavor15 = new Flavor()
                .setFlavorName("Chocolate Peanut Butter")
                .setPictures(Set.of(theWhey))
                .setCuts(Set.of(cut1, cut500))
                .setAvailable(true);

        Flavor barFlavor1 = new Flavor()
                .setFlavorName("Double Rich Chocolate")
                .setPictures(Set.of(barPicture, barPictureAtr))
                .setCuts(Set.of(cut40))
                .setAvailable(true);
        Flavor barFlavor2 = new Flavor()
                .setFlavorName("Chocolate Peanut Pretzel")
                .setPictures(Set.of(barPicture2, barPicturePack, barPicture3))
                .setCuts(Set.of(cut40, cutBox))
                .setAvailable(true);
        Flavor barFlavor3 = new Flavor()
                .setFlavorName("Cookies Cream")
                .setPictures(Set.of(barPictureCoffee))
                .setCuts(Set.of(cutBox))
                .setAvailable(true);
        Flavor waffleFlavorChoc = new Flavor()
                .setFlavorName("Chocolate")
                .setCuts(Set.of(cut60, cutBox))
                .setPictures(Set.of(wafflePicturePack, wafflePicturePack2, waffleOnePiece))
                .setAvailable(true);
        Flavor waffleFlavorCream = new Flavor()
                .setFlavorName("Chocolate")
                .setPictures(Set.of(waffleCreamPack, waffleCreamPack2, waffleCreamPiece))
                .setCuts(Set.of(cut60, cutBox))
                .setAvailable(true);
        Flavor appleElderFlower = new Flavor()
                .setFlavorName("Apple & Elderflower")
                .setPictures(Set.of(vegProElderflower, vegProElderflower2))
                .setCuts(Set.of(cut25, cut1, cut500, cut5))
                .setAvailable(true);
        Flavor lemonLime = new Flavor()
                .setFlavorName("Lemon & Lime")
                .setPictures(Set.of(vegProLime, vegProLime2))
                .setCuts(Set.of(cut25, cut1, cut500, cut5))
                .setAvailable(true);
        Flavor strawberry = new Flavor()
                .setFlavorName("Strawberry")
                .setPictures(Set.of(vegProStrawberry, vegProStrawberry2))
                .setCuts(Set.of(cut25, cut1, cut500))
                .setAvailable(true);
        Flavor toffeeApple = new Flavor()
                .setFlavorName("Toffee Apple")
                .setPictures(Set.of(vegProToffeeApple))
                .setCuts(Set.of(cut25, cut1))
                .setAvailable(true);

        Flavor orangeD = new Flavor()
                .setFlavorName("Orange")
                .setPictures(Set.of(vitaminDPic))
                .setCuts(Set.of(cut60serv))
                .setAvailable(true);

        Flavor noFlavor = new Flavor()
                .setFlavorName("null")
                .setPictures(Set.of(vitaminCPic))
                .setCuts(Set.of(cut100g))
                .setAvailable(true);

        Flavor noFlavor2 = new Flavor()
                .setFlavorName("null")
                .setPictures(Set.of(multivitaminPic))
                .setCuts(Set.of(cut60tab, cut100tab))
                .setAvailable(true);

        Flavor noFlavor3 = new Flavor()
                .setFlavorName("null")
                .setPictures(Set.of(omega3Pic))
                .setCuts(Set.of(cut90caps, cut250caps))
                .setAvailable(true);

        Flavor noFlavor4 = new Flavor()
                .setFlavorName("null")
                .setPictures(Set.of(creatineTabsPic))
                .setCuts(Set.of(cut250tabs))
                .setAvailable(true);

        Flavor noFlavor5 = new Flavor()
                .setFlavorName("null")
                .setPictures(Set.of(alphaMenPic))
                .setCuts(Set.of(cut120tabs, cut240tabs))
                .setAvailable(true);

        flavor1 = this.flavorRepository.save(flavor1);
        flavor2 = this.flavorRepository.save(flavor2);
        flavor3 = this.flavorRepository.save(flavor3);
        flavor4 = this.flavorRepository.save(flavor4);
        flavor5 = this.flavorRepository.save(flavor5);
        flavor6 = this.flavorRepository.save(flavor6);
        flavor7 = this.flavorRepository.save(flavor7);
        flavor8 = this.flavorRepository.save(flavor8);
        flavor9 = this.flavorRepository.save(flavor9);
        flavor10 = this.flavorRepository.save(flavor10);
        flavor11 = this.flavorRepository.save(flavor11);

        flavor12 = this.flavorRepository.save(flavor12);
        flavor13 = this.flavorRepository.save(flavor13);
        flavor14 = this.flavorRepository.save(flavor14);
        flavor15 = this.flavorRepository.save(flavor15);

        barFlavor1 = this.flavorRepository.save(barFlavor1);
        barFlavor2 = this.flavorRepository.save(barFlavor2);
        barFlavor3 = this.flavorRepository.save(barFlavor3);

        waffleFlavorChoc = this.flavorRepository.save(waffleFlavorChoc);
        waffleFlavorCream = this.flavorRepository.save(waffleFlavorCream);

        appleElderFlower = this.flavorRepository.save(appleElderFlower);
        strawberry = this.flavorRepository.save(strawberry);
        lemonLime = this.flavorRepository.save(lemonLime);
        toffeeApple = this.flavorRepository.save(toffeeApple);

        orangeD = this.flavorRepository.save(orangeD);

        noFlavor = this.flavorRepository.save(noFlavor);
        noFlavor2 = this.flavorRepository.save(noFlavor2);
        noFlavor3 = this.flavorRepository.save(noFlavor3);
        noFlavor4 = this.flavorRepository.save(noFlavor4);
        noFlavor5 = this.flavorRepository.save(noFlavor5);

        SpecialFeature glutenFree = new SpecialFeature()
                .setFeature(SpecialFeaturesEnum.GLUTEN_FREE);
        SpecialFeature vegetarian = new SpecialFeature()
                .setFeature(SpecialFeaturesEnum.VEGETARIAN);
        SpecialFeature vegan = new SpecialFeature()
                .setFeature(SpecialFeaturesEnum.VEGAN);

        glutenFree = this.specialFeatureRepository.save(glutenFree);
        vegetarian = this.specialFeatureRepository.save(vegetarian);
        vegan = this.specialFeatureRepository.save(vegan);


        Category categorySupp = new Category()
                .setCategoryName(ProductCategoriesEnum.SUPPLEMENT)
                .setDescription("You can choose from our extremely wide specter of supplements that are tested " +
                        "and widely chosen amongst the gym society");

        Category categoryProtein = new Category()
                .setCategoryName(ProductCategoriesEnum.PROTEIN)
                .setDescription("The best way to improve the `quality of your training and gain muscle faster.");

        Category categoryBar = new Category()
                .setCategoryName(ProductCategoriesEnum.BAR)
                .setDescription("You feel hungry but don't want to eat too much. We have the perfect healthy snack!");

        Category categoryVitamin = new Category()
                .setCategoryName(ProductCategoriesEnum.VITAMIN)
                .setDescription("Vitamins are important for your trainings and overall well-being. You can choose from our wide range " +
                        "of vitamins.");

        categorySupp = this.categoryRepository.save(categorySupp);
        categoryProtein = this.categoryRepository.save(categoryProtein);
        categoryBar = this.categoryRepository.save(categoryBar);
        categoryVitamin = this.categoryRepository.save(categoryVitamin);


        Supplement protein = new Supplement()
                .setSpecialFeatures(Set.of(vegetarian, glutenFree))
                .setFlavors(Set.of(flavor1, flavor2, flavor3, flavor4, flavor5,
                        flavor6, flavor7, flavor8, flavor9, flavor10, flavor11));
        protein.setName("PowerStorm Whey Protein");
        protein.setDescription("With our number one selling product you can enjoy more gains " +
                "in the gym while having a doze of your protein shake with your favourite flavor");
        protein.setCategories(Set.of(categoryProtein, categorySupp));
        protein.setRating(4.94);
        protein.setSlogan("The GymRats' choice");

        Supplement protein88 = new Supplement()
                .setSpecialFeatures(Set.of(glutenFree))
                .setFlavors(Set.of(flavor12, flavor13, flavor14, flavor15));

        protein88.setName("PowerStorm Whey Protein 88");
        protein88.setDescription("One of the company's bestsellers. Unmatched experience and results");
        protein88.setCategories(Set.of(categoryProtein, categorySupp));
        protein88.setRating(4.78);
        protein88.setSlogan("The GymRats' choice");

        Supplement barChoco = new Supplement()
                .setSpecialFeatures(Set.of(glutenFree, vegan))
                .setFlavors(Set.of(barFlavor1));

        barChoco.setName("PowerStorm Choco Protein Bar");
        barChoco.setDescription("The perfect choice for the moments when you want to have something sweet but also want to be healthy");
        barChoco.setCategories(Set.of(categoryBar, categorySupp));
        barChoco.setRating(4.86);
        barChoco.setSlogan("A healthy breakfast");

        Supplement barBiscuit = new Supplement()
                .setSpecialFeatures(Set.of(glutenFree, vegan))
                .setFlavors(Set.of(barFlavor2, barFlavor3));

        barBiscuit.setName("PowerStorm 3 Layers Protein Bar");
        barBiscuit.setDescription("3 layers of pleasure for your cutting gym diet");
        barBiscuit.setCategories(Set.of(categoryBar, categorySupp));
        barBiscuit.setRating(4.93);
        barBiscuit.setSlogan("A healthy breakfast");

        Supplement proteinWaffle = new Supplement()
                .setSpecialFeatures(Set.of(vegetarian))
                .setFlavors(Set.of(waffleFlavorChoc, waffleFlavorCream));

        proteinWaffle.setName("Protein StormWaffle");
        proteinWaffle.setDescription("Containing 15g of protein per snack, the waffles are little muscle gainers");
        proteinWaffle.setCategories(Set.of(categoryBar, categorySupp));
        proteinWaffle.setRating(4.89);
        proteinWaffle.setSlogan("High Protein Waffles With Different Flavors");


        Supplement veganProtein = new Supplement()
                .setSpecialFeatures(Set.of(vegetarian, vegan, glutenFree))
                .setFlavors(Set.of(appleElderFlower, lemonLime, strawberry, toffeeApple));

        veganProtein.setName("Pure Vegan Protein");
        veganProtein.setDescription("Revolution in the classic protein supplements' world. A fruity alternative to the protein shakes");
        veganProtein.setCategories(Set.of(categoryBar, categorySupp));
        veganProtein.setRating(4.92);
        veganProtein.setSlogan("First pure vegan protein in the world!");


        Supplement vitaminC = new Supplement()
                .setSpecialFeatures(Set.of(vegan, vegetarian, glutenFree))
                .setFlavors(Set.of(noFlavor));

        vitaminC.setName("Vitamin C");
        vitaminC.setDescription("Vitamin C is important for all your fitness ambitions as it supports your body’s " +
                "immune system after working out1. Our vegetarian and vegan-friendly powder is ideal for anyone looking " +
                "to increase their vitamin C intake in a fuss-free way.");

        vitaminC.setCategories(Set.of(categoryVitamin, categorySupp));
        vitaminC.setRating(4.91);
        vitaminC.setSlogan("Important vitamin powder giving you a range of everyday health benefits");


        Supplement vitaminD = new Supplement()
                .setSpecialFeatures(null)
                .setFlavors(Set.of(orangeD));

        vitaminD.setName("Vitamin D");
        vitaminD.setDescription("It’s not always easy to get your daily fix of vitamin D as" +
                " it mainly comes from sun exposure, and isn’t present in many foods.\n" +
                "\n" +
                "Our chewable Vitamin D Gummies are the tastiest way to stay topped up on this essential vitamin.");

        vitaminD.setCategories(Set.of(categoryVitamin, categorySupp));
        vitaminD.setRating(4.83);
        vitaminD.setSlogan("A delicious source of vitamin D, designed to support immune function.");


        Supplement multivitamin = new Supplement()
                .setSpecialFeatures(null)
                .setFlavors(Set.of(noFlavor2));

        multivitamin.setName("Daily Multivitamin Tablets");
        multivitamin.setDescription("Each tablet is packed with seven essential vitamins including " +
                "vitamin A, C, D3, E, thiamine, riboflavin and niacin — helping to support your everyday wellbeing and keep up " +
                "with a hectic training schedule.");

        multivitamin.setCategories(Set.of(categoryVitamin, categorySupp));
        multivitamin.setRating(4.72);
        multivitamin.setSlogan("A blend of seven essential vitamins in one convenient tablet");


        Supplement omega3 = new Supplement()
                .setSpecialFeatures(null)
                .setFlavors(Set.of(noFlavor3));

        omega3.setName("Essential Omega-3");
        omega3.setDescription("Omega-3s are essential polyunsaturated fatty acids that your body can’t make itself," +
                " so you have to get them from your diet. They’re found naturally in fish oil — meaning it can be difficult " +
                "to get enough of it from what you eat alone, if you don’t eat enough fish in your diet.");

        omega3.setCategories(Set.of(categoryVitamin, categorySupp));
        omega3.setRating(4.93);
        omega3.setSlogan("Essential fatty acid that supports heart health");


        Supplement creatineTabs = new Supplement()
                .setSpecialFeatures(Set.of(vegan, vegetarian))
                .setFlavors(Set.of(noFlavor4));

        creatineTabs.setName("Creatine Monohydrate Tablets");
        creatineTabs.setDescription("Our creatine monohydrate tablets are a super-convenient way" +
                " to get the scientifically proven benefits of creatine, helping you to improve" +
                " your performance workout after workout.");
        creatineTabs.setCategories(Set.of(categoryVitamin, categorySupp));
        creatineTabs.setRating(4.93);
        creatineTabs.setSlogan("Perfect for those looking to increase physical performance");


        Supplement alphaMen = new Supplement()
                .setSpecialFeatures(null)
                .setFlavors(Set.of(noFlavor5));

        alphaMen.setName("Alpha Men Multivitamin Tablets");
        alphaMen.setDescription("Our ultra formula of essential vitamins and minerals including calcium, " +
                "vitamin D, selenium, vitamin B5, biotin, as well as energising natural extracts — boosting " +
                "your everyday wellbeing while training hard, and dealing with the stresses and strains of a busy lifestyle.");
        alphaMen.setCategories(Set.of(categoryVitamin, categorySupp));
        alphaMen.setRating(4.74);
        alphaMen.setSlogan("Super multivitamin for staying active every day");


        this.supplementRepository.save(protein);
        this.supplementRepository.save(protein88);
        this.supplementRepository.save(veganProtein);

        this.supplementRepository.save(barChoco);
        this.supplementRepository.save(barBiscuit);
        this.supplementRepository.save(proteinWaffle);

        this.supplementRepository.save(vitaminC);
        this.supplementRepository.save(vitaminD);
        this.supplementRepository.save(multivitamin);

        this.supplementRepository.save(omega3);
        this.supplementRepository.save(creatineTabs);
        this.supplementRepository.save(alphaMen);

        ExclusiveOffer vitaminOffer = new ExclusiveOffer()
                .setTitle("Vitamins discount")
                .setDiscountPercent(10)
                .setDiscountedCategories(Set.of(categorySupp, categoryVitamin))
                .setStartDate(LocalDate.of(2022, 12, 10))
                .setEndDate(LocalDate.of(2022, 12, 22))
                .setActive(true)
                .setExclusivePicture(vitaminDiscount);

        this.exclusiveOfferRepository.save(vitaminOffer);
    }

    private void wearInit() {

        Size sizeXXS = new Size()
                .setName("XXS")
                .setItemsProduced(100)
                .setActive(true);
        Size sizeXS = new Size()
                .setName("XS")
                .setItemsProduced(100)
                .setActive(true);
        Size sizeS = new Size()
                .setName("S")
                .setItemsProduced(100)
                .setActive(true);
        Size sizeM = new Size()
                .setName("M")
                .setItemsProduced(100)
                .setActive(true);
        Size sizeL = new Size()
                .setName("L")
                .setItemsProduced(100)
                .setActive(true);
        Size sizeXL = new Size()
                .setName("XL")
                .setItemsProduced(100)
                .setActive(true);
        Size sizeXXL = new Size()
                .setName("XXL")
                .setItemsProduced(100)
                .setActive(true);
        Size sizeXXXL = new Size()
                .setName("XXXL")
                .setItemsProduced(100)
                .setActive(true);
        Size uk36 = new Size()
                .setName("UK 3 - 6")
                .setItemsProduced(100)
                .setActive(true);
        Size uk68 = new Size()
                .setName("UK 6 - 8")
                .setItemsProduced(100)
                .setActive(true);
        Size uk912 = new Size()
                .setName("UK 9 - 12")
                .setItemsProduced(100)
                .setActive(true);

        sizeXXS = this.sizeRepository.save(sizeXXS);
        sizeXS = this.sizeRepository.save(sizeXS);
        sizeS = this.sizeRepository.save(sizeS);
        sizeM = this.sizeRepository.save(sizeM);
        sizeL = this.sizeRepository.save(sizeL);
        sizeXL = this.sizeRepository.save(sizeXL);
        sizeXXL = this.sizeRepository.save(sizeXXL);
        sizeXXXL = this.sizeRepository.save(sizeXXXL);

        uk36 = this.sizeRepository.save(uk36);
        uk68 = this.sizeRepository.save(uk68);
        uk912 = this.sizeRepository.save(uk912);

        Category categoryWear = new Category()
                .setCategoryName(ProductCategoriesEnum.WEAR)
                .setDescription("Choose from our wide range of sports clothing");

        Category categoryMen = new Category()
                .setCategoryName(ProductCategoriesEnum.MENS)
                .setDescription("The best for the men");

        Category categoryWomen = new Category()
                .setCategoryName(ProductCategoriesEnum.WOMENS)
                .setDescription("The best for the women");

        Category categoryTShirt = new Category()
                .setCategoryName(ProductCategoriesEnum.T_SHIRT)
                .setDescription("To feel the movement freely");

        Category categoryLongSleeve = new Category()
                .setCategoryName(ProductCategoriesEnum.LONG_SLEEVE)
                .setDescription("Made from lightweight and stretch material");

        Category categoryHoodie = new Category()
                .setCategoryName(ProductCategoriesEnum.HOODIE)
                .setDescription("Made from quality and breathing materials, so you can feel comfy in every situation.");

        Category categoryJoggers = new Category()
                .setCategoryName(ProductCategoriesEnum.JOGGING)
                .setDescription("Fulfill every need of the training person.");

        Category categoryShorts = new Category()
                .setCategoryName(ProductCategoriesEnum.SHORTS)
                .setDescription("Made mainly for training since they are made from breathing materials");

        Category categoryJacket = new Category()
                .setCategoryName(ProductCategoriesEnum.JACKET)
                .setDescription("You want to go out? You go out? We have a jacket for every situation");

        Category categoryZipTop = new Category()
                .setCategoryName(ProductCategoriesEnum.ZIP_TOP);

        Category categorySportsBra = new Category()
                .setCategoryName(ProductCategoriesEnum.SPORTS_BRA)
                .setDescription("Our comfortable sport bras are filling you with confidence every step of your way");

        Category categoryGilet = new Category()
                .setCategoryName(ProductCategoriesEnum.GILET)
                .setDescription("Colder weather is no more an issue with our collection of gilets");

        Category categorySocks = new Category()
                .setCategoryName(ProductCategoriesEnum.SOCKS)
                .setDescription(null);

        Category categoryUnderWear = new Category()
                .setCategoryName(ProductCategoriesEnum.UNDERWEAR)
                .setDescription("It is important to have comfortable underwear that helps the air circulation and prevents from sweating");

        Category categoryLeggings = new Category()
                .setCategoryName(ProductCategoriesEnum.LEGGINGS)
                .setDescription("The gym leggings are a total hit. You can wear them in the gym, while jogging, " +
                        "during yoga session or any other sports activity");

        categoryWear = this.categoryRepository.save(categoryWear);
        categoryMen = this.categoryRepository.save(categoryMen);
        categoryWomen = this.categoryRepository.save(categoryWomen);
        categoryTShirt = this.categoryRepository.save(categoryTShirt);
        categoryLongSleeve = this.categoryRepository.save(categoryLongSleeve);
        categoryHoodie = this.categoryRepository.save(categoryHoodie);
        categoryJoggers = this.categoryRepository.save(categoryJoggers);
        categoryShorts = this.categoryRepository.save(categoryShorts);
        categoryJacket = this.categoryRepository.save(categoryJacket);
        categoryZipTop = this.categoryRepository.save(categoryZipTop);
        categorySportsBra = this.categoryRepository.save(categorySportsBra);
        categoryGilet = this.categoryRepository.save(categoryGilet);
        categorySocks = this.categoryRepository.save(categorySocks);
        categoryUnderWear = this.categoryRepository.save(categoryUnderWear);
        categoryLeggings = this.categoryRepository.save(categoryLeggings);

        Picture longSleeveTShirtBlue = new Picture()
                .setTitle("Long Sleeve T-Shirt Blue")
                .setUrl("/pictures/longSleeveTShirtBlue.jpg");

        Picture longSleeveTShirtBlueBack = new Picture()
                .setTitle("Long Sleeve T-Shirt Blue Back")
                .setUrl("/pictures/longSleeveTShirtBlueBack.jpg");

        Picture longSleeveTShirtDanger = new Picture()
                .setTitle("Long Sleeve T-Shirt Danger")
                .setUrl("/pictures/longSleeveTShirtDanger.jpg");

        Picture longSleeveTShirtDangerBack = new Picture()
                .setTitle("Long Sleeve T-Shirt Danger Back")
                .setUrl("/pictures/longSleeveTShirtDangerBack.jpg");

        Picture longSleeveTShirtWhite = new Picture()
                .setTitle("Long Sleeve T-Shirt White")
                .setUrl("/pictures/longSleeveTShirtWhite.jpg");

        Picture longSleeveTShirtWhiteBack = new Picture()
                .setTitle("Long Sleeve T-Shirt White")
                .setUrl("/pictures/longSleeveTShirtWhiteBack.jpg");

        Picture longSleeveTShirtBlack = new Picture()
                .setTitle("Long Sleeve T-Shirt Black")
                .setUrl("/pictures/longSleeveTShirtBlack.jpg");

        Picture longSleeveTShirtBlackBack = new Picture()
                .setTitle("Long Sleeve T-Shirt Black Back")
                .setUrl("/pictures/longSleeveTShirtBlackBack.jpg");

        Picture shortSleeveTShirtBlack = new Picture()
                .setTitle("Short Sleeve T-Shirt Black")
                .setUrl("/pictures/shortSleeveTShirtBlack.jpg");

        Picture shortSleeveTShirtBlackBack = new Picture()
                .setTitle("Short Sleeve T-Shirt Black Back")
                .setUrl("/pictures/shortSleeveTShirtBlackBack.jpg");

        Picture shortSleeveTShirtBlue = new Picture()
                .setTitle("Short Sleeve T-Shirt Blue")
                .setUrl("/pictures/shortSleeveTShirtBlue.jpg");

        Picture shortSleeveTShirtBlueBack = new Picture()
                .setTitle("Short Sleeve T-Shirt Blue Back")
                .setUrl("/pictures/shortSleeveTShirtBlueBack.jpg");

        Picture shortSleeveTShirtCherry = new Picture()
                .setTitle("Short Sleeve T-Shirt Cherry")
                .setUrl("/pictures/shortSleeveTShirtCherry.jpg");

        Picture shortSleeveTShirtCherryBack = new Picture()
                .setTitle("Short Sleeve T-Shirt Cherry Back")
                .setUrl("/pictures/shortSleeveTShirtCherryBack.jpg");

        Picture shortSleeveTShirtDanger = new Picture()
                .setTitle("Short Sleeve T-Shirt Danger")
                .setUrl("/pictures/shortSleeveTShirtDanger.jpg");

        Picture shortSleeveTShirtDangerBack = new Picture()
                .setTitle("Short Sleeve T-Shirt Danger Back")
                .setUrl("/pictures/shortSleeveTShirtDangerBack.jpg");

        Picture shortSleeveTShirtWhite = new Picture()
                .setTitle("Short Sleeve T-Shirt White")
                .setUrl("/pictures/shortSleeveTShirtWhite.jpg");

        Picture shortSleeveTShirtWhiteBack = new Picture()
                .setTitle("Short Sleeve T-Shirt White Back")
                .setUrl("/pictures/shortSleeveTShirtWhiteBack.jpg");

        Picture shortSleeveTShirtGreen = new Picture()
                .setTitle("Short Sleeve T-Shirt Green")
                .setUrl("/pictures/shortSleeveTShirtGreen.jpg");

        Picture shortSleeveTShirtGreenBack = new Picture()
                .setTitle("Short Sleeve T-Shirt Green Back")
                .setUrl("/pictures/shortSleeveTShirtGreenBack.jpg");

        Picture menHoodieBlack = new Picture()
                .setTitle("Men Hoodie Black")
                .setUrl("/pictures/menHoodieBlack.webp");

        Picture menHoodieBlackBack = new Picture()
                .setTitle("Men Hoodie Black Back")
                .setUrl("/pictures/menHoodieBlackBack.webp");

        Picture menHoodieGrey = new Picture()
                .setTitle("Men Hoodie Grey")
                .setUrl("/pictures/menHoodieGrey.jpg");

        Picture menHoodieGreyBack = new Picture()
                .setTitle("Men Hoodie Grey Back")
                .setUrl("/pictures/menHoodieGreyBack.jpg");

        Picture menHoodieNavy = new Picture()
                .setTitle("Men Hoodie Navy")
                .setUrl("/pictures/menHoodieNavy.jpg");

        Picture menHoodieNavyBack = new Picture()
                .setTitle("Men Hoodie Navy Back")
                .setUrl("/pictures/menHoodieNavyBack.jpg");

        Picture menJoggersBlack = new Picture()
                .setTitle("Men Joggers Black")
                .setUrl("/pictures/mensJoggersBlack.webp");

        Picture menJoggersBlackBack = new Picture()
                .setTitle("Men Joggers Black Back")
                .setUrl("/pictures/mensJoggersBlackBack.webp");

        Picture menJoggersBlackAttractive = new Picture()
                .setTitle("Men Joggers Black Attractive")
                .setUrl("/pictures/mensJoggersBlackAtr.webp");

        Picture menJoggersNavy = new Picture()
                .setTitle("Men Joggers Navy")
                .setUrl("/pictures/menJoggersNavy.jpg");

        Picture menJoggersNavyBack = new Picture()
                .setTitle("Men Joggers Navy Back")
                .setUrl("/pictures/menJoggersNavyBack.jpg");

        Picture menJoggersNavyAttractive = new Picture()
                .setTitle("Men Joggers Navy Attractive")
                .setUrl("/pictures/menJoggersNavyAtr.jpg");

        Picture menJoggersStorm = new Picture()
                .setTitle("Men Joggers Storm")
                .setUrl("/pictures/menJoggersStorm.jpg");

        Picture menJoggersStormBack = new Picture()
                .setTitle("Men Joggers Storm Back")
                .setUrl("/pictures/menJoggersStormBack.jpg");

        Picture menJoggersStormAttractive = new Picture()
                .setTitle("Men Joggers Storm Attractive")
                .setUrl("/pictures/menJoggersStormAtr.jpg");

        Picture menShortsCarbon = new Picture()
                .setTitle("Men Shorts Carbon")
                .setUrl("/pictures/mensShortsCarbon.jpg");

        Picture menShortsCarbonBack = new Picture()
                .setTitle("Men Shorts Carbon Back")
                .setUrl("/pictures/mensShortsCarbonBack.jpg");

        Picture menShortsCarbonAtr = new Picture()
                .setTitle("Men Shorts Carbon Attractive")
                .setUrl("/pictures/mensShortsCarbonAtr.jpg");

        Picture menShortsPetrolBlue = new Picture()
                .setTitle("Men Shorts PetrolBlue")
                .setUrl("/pictures/mensShortsPetrolBlue.jpg");

        Picture menShortsPetrolBlueBack = new Picture()
                .setTitle("Men Shorts PetrolBlue Back")
                .setUrl("/pictures/mensShortsPetrolBlueBack.jpg");

        Picture menShortsPetrolBlueAtr = new Picture()
                .setTitle("Men Shorts PetrolBlue Attractive")
                .setUrl("/pictures/mensShortsPetrolBlueAtr.jpg");

        Picture menShortsPort = new Picture()
                .setTitle("Men Shorts Port")
                .setUrl("/pictures/mensShortsPort.jpg");

        Picture menShortsPortBack = new Picture()
                .setTitle("Men Shorts Port Back")
                .setUrl("/pictures/mensShortsPortBack.jpg");

        Picture menShortsPortAtr = new Picture()
                .setTitle("Men Shorts Port Attractive")
                .setUrl("/pictures/mensShortsPortAtr.jpg");

        Picture menShortsTeal = new Picture()
                .setTitle("Men Shorts Teal")
                .setUrl("/pictures/mensShortsTeal.jpg");

        Picture menShortsTealBack = new Picture()
                .setTitle("Men Shorts Teal Back")
                .setUrl("/pictures/mensShortsTealBack.jpg");

        Picture menShortsTealAtr = new Picture()
                .setTitle("Men Shorts Teal Attractive")
                .setUrl("/pictures/mensShortsTealAtr.jpg");

        Picture menJacketBlack = new Picture()
                .setTitle("Men Jacket Black")
                .setUrl("/pictures/menJacketBlack.webp");

        Picture menJacketBlackBack = new Picture()
                .setTitle("Men Jacket Black Back")
                .setUrl("/pictures/menJacketBlackBack.webp");

        Picture menJacketBlackAttr = new Picture()
                .setTitle("Men Jacket Black Attractive")
                .setUrl("/pictures/menJacketBlackAttr.webp");

        Picture womenShortsGreen = new Picture()
                .setTitle("Women Shorts Green")
                .setUrl("/pictures/womenShortsGreen.webp");

        Picture womenShortsGreenBack = new Picture()
                .setTitle("Women Shorts Green Back")
                .setUrl("/pictures/womenShortsGreenBack.webp");

        Picture womenShortsGreenAttr = new Picture()
                .setTitle("Women Shorts Green Attractive")
                .setUrl("/pictures/womenShortsGreenAtr.webp");

        Picture womenShortsGrey = new Picture()
                .setTitle("Women Shorts Grey")
                .setUrl("/pictures/womenShortsGrey.jpg");

        Picture womenShortsGreyBack = new Picture()
                .setTitle("Women Shorts Grey Back")
                .setUrl("/pictures/womenShortsGreyBack.jpg");

        Picture womenShortsGreyAttr = new Picture()
                .setTitle("Women Shorts Grey Attractive")
                .setUrl("/pictures/womenShortsGreyAtr.jpg");

        Picture womenZipTopBlack = new Picture()
                .setTitle("Women Zip Top Black")
                .setUrl("/pictures/womenZipTopBlack.webp");

        Picture womenZipTopBlackBack = new Picture()
                .setTitle("Women Zip Top Black Back")
                .setUrl("/pictures/womenZipTopBlackBack.webp");

        Picture womenZipTopBlackAttr = new Picture()
                .setTitle("Women Zip Top Black Attractive")
                .setUrl("/pictures/womenZipTopAtr.webp");

        Picture womenZipTopBlue = new Picture()
                .setTitle("Women Zip Top Blue")
                .setUrl("/pictures/womenZipTopBlue.jpg");

        Picture womenZipTopBlueBack = new Picture()
                .setTitle("Women Zip Top Blue Back")
                .setUrl("/pictures/womenZipTopBlueBack.jpg");

        Picture womenZipTopBlueAttr = new Picture()
                .setTitle("Women Zip Top Blue Attractive")
                .setUrl("/pictures/womenZipTopBlueAtr.jpg");

        Picture womenSportsBraBlack = new Picture()
                .setTitle("Women Sports Bra Black")
                .setUrl("/pictures/womenSportsBraBlack.jpg");

        Picture womenSportsBraBlackBack = new Picture()
                .setTitle("Women Sports Bra Black Back")
                .setUrl("/pictures/womenSportsBraBlackBack.jpg");

        Picture womenSportsBraBlackAttr = new Picture()
                .setTitle("Women Sports Bra Black Attractive")
                .setUrl("/pictures/womenSportsBraBlackAtr.jpg");

        Picture womenSportsBraPlum = new Picture()
                .setTitle("Women Sports Bra Plum")
                .setUrl("/pictures/womenSportsBraPlum.jpg");

        Picture womenSportsBraPlumBack = new Picture()
                .setTitle("Women Sports Bra Plum Back")
                .setUrl("/pictures/womenSportsBraPlumBack.jpg");

        Picture womenSportsBraPlumAttr = new Picture()
                .setTitle("Women Sports Bra Plum Attractive")
                .setUrl("/pictures/womenSportsBraPlumAtr.jpg");

        Picture womenSportsBraShadowBlue = new Picture()
                .setTitle("Women Sports Bra Shadow Blue")
                .setUrl("/pictures/womenSportsBraShadowBlue.jpg");

        Picture womenSportsBraShadowBlueBack = new Picture()
                .setTitle("Women Sports Bra Shadow Blue Back")
                .setUrl("/pictures/womenSportsBraShadowBlueBack.jpg");

        Picture womenSportsBraShadowBlueAttr = new Picture()
                .setTitle("Women Sports Bra Shadow Blue Attractive")
                .setUrl("/pictures/womenSportsBraShadowBlueAtr.jpg");

        Picture womenSportsBraStoneBlue = new Picture()
                .setTitle("Women Sports Bra Stone Blue")
                .setUrl("/pictures/womenSportsBraStoneBlue.jpg");

        Picture womenSportsBraStoneBlueBack = new Picture()
                .setTitle("Women Sports Bra Stone Blue Back")
                .setUrl("/pictures/womenSportsBraStoneBlueBack.jpg");

        Picture womenSportsBraStoneBlueAttr = new Picture()
                .setTitle("Women Sports Bra Stone Blue Attractive")
                .setUrl("/pictures/womenSportsBraStoneBlueAtr.jpg");

        Picture womenSportsBraStorm = new Picture()
                .setTitle("Women Sports Bra Storm")
                .setUrl("/pictures/womenSportsBraStorm.jpg");

        Picture womenSportsBraStormBack = new Picture()
                .setTitle("Women Sports Bra Storm Back")
                .setUrl("/pictures/womenSportsBraStormBack.jpg");

        Picture womenSportsBraStormAttr = new Picture()
                .setTitle("Women Sports Bra Storm Attractive")
                .setUrl("/pictures/womenSportsBraStormAtr.jpg");

        Picture womenGiletBlack = new Picture()
                .setTitle("Women Gilet Black")
                .setUrl("/pictures/womenGiletBlack.webp");

        Picture womenGiletBlackBack = new Picture()
                .setTitle("Women Gilet Black Back")
                .setUrl("/pictures/womenGiletBlackBack.webp");

        Picture womenSock = new Picture()
                .setTitle("Women Sock")
                .setUrl("/pictures/womenSock.jpg");

        Picture womenSockBlack = new Picture()
                .setTitle("Women Sock Black")
                .setUrl("/pictures/womenSockBlack.jpg");

        Picture womenSocksBlack = new Picture()
                .setTitle("Women Socks Black")
                .setUrl("/pictures/womenSocksBlack.jpg");

        Picture womenSocksBlackWhite = new Picture()
                .setTitle("Women Socks Black White")
                .setUrl("/pictures/womenSocksBlackWhite.jpg");

        Picture womenSocksBlackWhitePiece = new Picture()
                .setTitle("Women Sock Black White")
                .setUrl("/pictures/womenSocksBlackWhitePiece.jpg");

        Picture womenLeggingsIceBlue = new Picture()
                .setTitle("Women Leggings Ice Blue")
                .setUrl("/pictures/womenLeggingsIceBlue.webp");

        Picture womenLeggingsIceBlueBack = new Picture()
                .setTitle("Women Leggings Ice Blue Back")
                .setUrl("/pictures/womenLeggingsIceBlueBack.webp");

        Picture womenLeggingsChalkPurple = new Picture()
                .setTitle("Women Leggings Chalk Purple")
                .setUrl("/pictures/womenLeggingsChalkPurple.jpg");

        Picture womenLeggingsChalkPurpleBack = new Picture()
                .setTitle("Women Leggings Chalk Purple Back")
                .setUrl("/pictures/womenLeggingsChalkPurpleBack.jpg");

        Picture womenLeggingsNavy = new Picture()
                .setTitle("Women Leggings Navy")
                .setUrl("/pictures/womenLeggingsNavy.jpg");

        Picture womenLeggingsNavyBack = new Picture()
                .setTitle("Women Leggings Navy Back")
                .setUrl("/pictures/womenLeggingsNavyBack.jpg");

        Picture womenLeggingsNavyAtr = new Picture()
                .setTitle("Women Leggings Navy Attractive")
                .setUrl("/pictures/womenLeggingsNavyAtr.jpg");

        Picture hoodieDiscount = new Picture()
                .setTitle("Hoodie and T-Shirt Discount")
                .setUrl("/pictures/hoodie_discount.jpg");

        Picture mensShortsDiscount = new Picture()
                .setTitle("Mens Shorts discount")
                .setUrl("/pictures/shorts_discount.jpg");

        Picture mensTShirtsDiscount = new Picture()
                .setTitle("Mens TShirt Discount")
                .setUrl("/pictures/shirts_discount.webp");

        Picture womenLeggingsDiscount = new Picture()
                .setTitle("Women Leggings Discount")
                .setUrl("/pictures/leggings_discount.jpg");

        longSleeveTShirtBlue = this.pictureRepository.save(longSleeveTShirtBlue);
        longSleeveTShirtBlueBack = this.pictureRepository.save(longSleeveTShirtBlueBack);
        longSleeveTShirtBlack = this.pictureRepository.save(longSleeveTShirtBlack);
        longSleeveTShirtBlackBack = this.pictureRepository.save(longSleeveTShirtBlackBack);
        longSleeveTShirtWhite = this.pictureRepository.save(longSleeveTShirtWhite);
        longSleeveTShirtWhiteBack = this.pictureRepository.save(longSleeveTShirtWhiteBack);
        longSleeveTShirtDanger = this.pictureRepository.save(longSleeveTShirtDanger);
        longSleeveTShirtDangerBack = this.pictureRepository.save(longSleeveTShirtDangerBack);

        shortSleeveTShirtBlack = this.pictureRepository.save(shortSleeveTShirtBlack);
        shortSleeveTShirtBlackBack = this.pictureRepository.save(shortSleeveTShirtBlackBack);
        shortSleeveTShirtBlue = this.pictureRepository.save(shortSleeveTShirtBlue);
        shortSleeveTShirtBlueBack = this.pictureRepository.save(shortSleeveTShirtBlueBack);
        shortSleeveTShirtCherry = this.pictureRepository.save(shortSleeveTShirtCherry);
        shortSleeveTShirtCherryBack = this.pictureRepository.save(shortSleeveTShirtCherryBack);
        shortSleeveTShirtDanger = this.pictureRepository.save(shortSleeveTShirtDanger);
        shortSleeveTShirtDangerBack = this.pictureRepository.save(shortSleeveTShirtDangerBack);
        shortSleeveTShirtWhite = this.pictureRepository.save(shortSleeveTShirtWhite);
        shortSleeveTShirtWhiteBack = this.pictureRepository.save(shortSleeveTShirtWhiteBack);
        shortSleeveTShirtGreen = this.pictureRepository.save(shortSleeveTShirtGreen);
        shortSleeveTShirtGreenBack = this.pictureRepository.save(shortSleeveTShirtGreenBack);


        menHoodieBlack = this.pictureRepository.save(menHoodieBlack);
        menHoodieBlackBack = this.pictureRepository.save(menHoodieBlackBack);
        menHoodieGrey = this.pictureRepository.save(menHoodieGrey);
        menHoodieGreyBack = this.pictureRepository.save(menHoodieGreyBack);
        menHoodieNavy = this.pictureRepository.save(menHoodieNavy);
        menHoodieNavyBack = this.pictureRepository.save(menHoodieNavyBack);

        menJoggersBlack = this.pictureRepository.save(menJoggersBlack);
        menJoggersBlackBack = this.pictureRepository.save(menJoggersBlackBack);
        menJoggersBlackAttractive = this.pictureRepository.save(menJoggersBlackAttractive);
        menJoggersNavy = this.pictureRepository.save(menJoggersNavy);
        menJoggersNavyBack = this.pictureRepository.save(menJoggersNavyBack);
        menJoggersNavyAttractive = this.pictureRepository.save(menJoggersNavyAttractive);
        menJoggersStorm = this.pictureRepository.save(menJoggersStorm);
        menJoggersStormBack = this.pictureRepository.save(menJoggersStormBack);
        menJoggersStormAttractive = this.pictureRepository.save(menJoggersStormAttractive);

        menShortsCarbon = this.pictureRepository.save(menShortsCarbon);
        menShortsCarbonBack = this.pictureRepository.save(menShortsCarbonBack);
        menShortsCarbonAtr = this.pictureRepository.save(menShortsCarbonAtr);
        menShortsPetrolBlue = this.pictureRepository.save(menShortsPetrolBlue);
        menShortsPetrolBlueBack = this.pictureRepository.save(menShortsPetrolBlueBack);
        menShortsPetrolBlueAtr = this.pictureRepository.save(menShortsPetrolBlueAtr);
        menShortsPort = this.pictureRepository.save(menShortsPort);
        menShortsPortBack = this.pictureRepository.save(menShortsPortBack);
        menShortsPortAtr = this.pictureRepository.save(menShortsPortAtr);
        menShortsTeal = this.pictureRepository.save(menShortsTeal);
        menShortsTealBack = this.pictureRepository.save(menShortsTealBack);
        menShortsTealAtr = this.pictureRepository.save(menShortsTealAtr);

        menJacketBlack = this.pictureRepository.save(menJacketBlack);
        menJacketBlackBack = this.pictureRepository.save(menJacketBlackBack);
        menJacketBlackAttr = this.pictureRepository.save(menJacketBlackAttr);

        womenShortsGreen = this.pictureRepository.save(womenShortsGreen);
        womenShortsGreenBack = this.pictureRepository.save(womenShortsGreenBack);
        womenShortsGreenAttr = this.pictureRepository.save(womenShortsGreenAttr);
        womenShortsGrey = this.pictureRepository.save(womenShortsGrey);
        womenShortsGreyBack = this.pictureRepository.save(womenShortsGreyBack);
        womenShortsGreyAttr = this.pictureRepository.save(womenShortsGreyAttr);

        womenZipTopBlack = this.pictureRepository.save(womenZipTopBlack);
        womenZipTopBlackBack = this.pictureRepository.save(womenZipTopBlackBack);
        womenZipTopBlackAttr = this.pictureRepository.save(womenZipTopBlackAttr);
        womenZipTopBlue = this.pictureRepository.save(womenZipTopBlue);
        womenZipTopBlueBack = this.pictureRepository.save(womenZipTopBlueBack);
        womenZipTopBlueAttr = this.pictureRepository.save(womenZipTopBlueAttr);

        womenSportsBraBlack = this.pictureRepository.save(womenSportsBraBlack);
        womenSportsBraBlackBack = this.pictureRepository.save(womenSportsBraBlackBack);
        womenSportsBraBlackAttr = this.pictureRepository.save(womenSportsBraBlackAttr);
        womenSportsBraPlum = this.pictureRepository.save(womenSportsBraPlum);
        womenSportsBraPlumBack = this.pictureRepository.save(womenSportsBraPlumBack);
        womenSportsBraPlumAttr = this.pictureRepository.save(womenSportsBraPlumAttr);
        womenSportsBraShadowBlue = this.pictureRepository.save(womenSportsBraShadowBlue);
        womenSportsBraShadowBlueBack = this.pictureRepository.save(womenSportsBraShadowBlueBack);
        womenSportsBraShadowBlueAttr = this.pictureRepository.save(womenSportsBraShadowBlueAttr);
        womenSportsBraStoneBlue = this.pictureRepository.save(womenSportsBraStoneBlue);
        womenSportsBraStoneBlueBack = this.pictureRepository.save(womenSportsBraStoneBlueBack);
        womenSportsBraStoneBlueAttr = this.pictureRepository.save(womenSportsBraStoneBlueAttr);
        womenSportsBraStorm = this.pictureRepository.save(womenSportsBraStorm);
        womenSportsBraStormBack = this.pictureRepository.save(womenSportsBraStormBack);
        womenSportsBraStormAttr = this.pictureRepository.save(womenSportsBraStormAttr);

        womenGiletBlack = this.pictureRepository.save(womenGiletBlack);
        womenGiletBlackBack = this.pictureRepository.save(womenGiletBlackBack);

        womenSock = this.pictureRepository.save(womenSock);
        womenSocksBlack = this.pictureRepository.save(womenSocksBlack);
        womenSockBlack = this.pictureRepository.save(womenSockBlack);
        womenSocksBlackWhite = this.pictureRepository.save(womenSocksBlackWhite);
        womenSocksBlackWhitePiece = this.pictureRepository.save(womenSocksBlackWhitePiece);

        womenLeggingsIceBlue = this.pictureRepository.save(womenLeggingsIceBlue);
        womenLeggingsIceBlueBack = this.pictureRepository.save(womenLeggingsIceBlueBack);
        womenLeggingsChalkPurple = this.pictureRepository.save(womenLeggingsChalkPurple);
        womenLeggingsChalkPurpleBack = this.pictureRepository.save(womenLeggingsChalkPurpleBack);
        womenLeggingsNavy = this.pictureRepository.save(womenLeggingsNavy);
        womenLeggingsNavyBack = this.pictureRepository.save(womenLeggingsNavyBack);
        womenLeggingsNavyAtr = this.pictureRepository.save(womenLeggingsNavyAtr);

        womenLeggingsDiscount = this.pictureRepository.save(womenLeggingsDiscount);
        mensShortsDiscount = this.pictureRepository.save(mensShortsDiscount);
        mensTShirtsDiscount = this.pictureRepository.save(mensTShirtsDiscount);
        hoodieDiscount = this.pictureRepository.save(hoodieDiscount);



        Color colorBlue = new Color()
                .setColorName("Intense Blue")
                .setColorCode("#0064A2")
                .setPictures(Set.of(longSleeveTShirtBlue, longSleeveTShirtBlueBack))
                .setSizes(Set.of(sizeXXS, sizeXS, sizeS, sizeM, sizeL, sizeXL, sizeXXL, sizeXXXL))
                .setCost(BigDecimal.valueOf(4.97))
                .setPrice(BigDecimal.valueOf(7.99))
                .setAvailable(true);

        Color colorDanger = new Color()
                .setColorName("Danger")
                .setColorCode("#F32013")
                .setPictures(Set.of(longSleeveTShirtDanger, longSleeveTShirtDangerBack))
                .setSizes(Set.of(sizeXXS, sizeXS, sizeS, sizeM, sizeL, sizeXL, sizeXXL, sizeXXXL))
                .setCost(BigDecimal.valueOf(5.81))
                .setPrice(BigDecimal.valueOf(9.99))
                .setAvailable(true);

        Color colorWhite = new Color()
                .setColorName("White")
                .setColorCode("#F1F2F1")
                .setPictures(Set.of(longSleeveTShirtWhite, longSleeveTShirtWhiteBack))
                .setSizes(Set.of(sizeXXS, sizeXS, sizeS, sizeM, sizeL, sizeXL, sizeXXL, sizeXXXL))
                .setCost(BigDecimal.valueOf(5.86))
                .setPrice(BigDecimal.valueOf(9.99))
                .setAvailable(true);

        Color colorBlack = new Color()
                .setColorName("Black")
                .setColorCode("#2D2C2F")
                .setPictures(Set.of(longSleeveTShirtBlack, longSleeveTShirtBlackBack))
                .setSizes(Set.of(sizeXXS, sizeXS, sizeS, sizeM, sizeL, sizeXL, sizeXXL, sizeXXXL))
                .setCost(BigDecimal.valueOf(5.86))
                .setPrice(BigDecimal.valueOf(9.99))
                .setAvailable(true);


        Color blackMarl = new Color()
                .setColorName("Black Marl")
                .setColorCode("#2D2C2F")
                .setPictures(Set.of(shortSleeveTShirtBlack, shortSleeveTShirtBlackBack))
                .setSizes(Set.of(sizeXS, sizeS, sizeM, sizeL, sizeXXXL))
                .setCost(BigDecimal.valueOf(12.46))
                .setPrice(BigDecimal.valueOf(22.00))
                .setAvailable(true);

        Color blueMarl = new Color()
                .setColorName("Cobalt Marl")
                .setColorCode("#3E55AB")
                .setPictures(Set.of(shortSleeveTShirtBlue, shortSleeveTShirtBlueBack))
                .setSizes(Set.of(sizeS, sizeM, sizeL, sizeXL))
                .setCost(BigDecimal.valueOf(12.43))
                .setPrice(BigDecimal.valueOf(22.00))
                .setAvailable(true);

        Color cherryMarl = new Color()
                .setColorName("Cherry Marl")
                .setColorCode("#702F3B")
                .setPictures(Set.of(shortSleeveTShirtCherry, shortSleeveTShirtCherryBack))
                .setSizes(Set.of(sizeS, sizeM, sizeL, sizeXL))
                .setCost(BigDecimal.valueOf(12.52))
                .setPrice(BigDecimal.valueOf(22.00))
                .setAvailable(true);

        Color dangerMarl = new Color()
                .setColorName("Danger Marl")
                .setColorCode("#CC333D")
                .setPictures(Set.of(shortSleeveTShirtDanger, shortSleeveTShirtDangerBack))
                .setSizes(Set.of(sizeXS, sizeS, sizeM, sizeL, sizeXL, sizeXXL))
                .setCost(BigDecimal.valueOf(12.21))
                .setPrice(BigDecimal.valueOf(22.00))
                .setAvailable(true);

        Color chromeMarl = new Color()
                .setColorName("Chrome Marl")
                .setColorCode("#BABBBD")
                .setPictures(Set.of(shortSleeveTShirtWhite, shortSleeveTShirtWhiteBack))
                .setSizes(Set.of(sizeXXS, sizeS, sizeM, sizeXL))
                .setCost(BigDecimal.valueOf(12.78))
                .setPrice(BigDecimal.valueOf(22.00))
                .setAvailable(true);


        Color armyGreenMarl = new Color()
                .setColorName("Army Green Marl")
                .setColorCode("#60614C")
                .setPictures(Set.of(shortSleeveTShirtGreen, shortSleeveTShirtGreenBack))
                .setSizes(Set.of(sizeXS, sizeS, sizeM, sizeL, sizeXL, sizeXXL, sizeXXXL))
                .setCost(BigDecimal.valueOf(12.43))
                .setPrice(BigDecimal.valueOf(22.00))
                .setAvailable(true);

        Color blackHoodie = new Color()
                .setColorName("Black")
                .setColorCode("#2D2C2F")
                .setPictures(Set.of(menHoodieBlack, menHoodieBlackBack))
                .setSizes(Set.of(sizeXXS, sizeS, sizeM, sizeL, sizeXL, sizeXXL, sizeXXXL))
                .setCost(BigDecimal.valueOf(12.76))
                .setPrice(BigDecimal.valueOf(23.99))
                .setAvailable(true);

        Color greyMarlHoodie = new Color()
                .setColorName("Grey Marl")
                .setColorCode("#959C99")
                .setPictures(Set.of(menHoodieGrey, menHoodieGreyBack))
                .setSizes(Set.of(sizeXXS, sizeS, sizeXL, sizeXXL))
                .setCost(BigDecimal.valueOf(12.81))
                .setPrice(BigDecimal.valueOf(23.99))
                .setAvailable(true);

        Color navyHoodie = new Color()
                .setColorName("Navy")
                .setColorCode("#28334A")
                .setPictures(Set.of(menHoodieNavy, menHoodieNavyBack))
                .setSizes(Set.of(sizeXS, sizeS, sizeM, sizeXL, sizeXXXL))
                .setCost(BigDecimal.valueOf(12.86))
                .setPrice(BigDecimal.valueOf(23.99))
                .setAvailable(true);

        Color blackMenJoggers = new Color()
                .setColorName("Black")
                .setColorCode("#2D2C2F")
                .setPictures(Set.of(menJoggersBlack, menJoggersBlackBack, menJoggersBlackAttractive))
                .setSizes(Set.of(sizeXXS, sizeS, sizeM, sizeXL, sizeXXL, sizeXXXL))
                .setCost(BigDecimal.valueOf(17.48))
                .setPrice(BigDecimal.valueOf(30.00))
                .setAvailable(true);

        Color navyMenJoggers = new Color()
                .setColorName("Navy")
                .setColorCode("#28334A")
                .setPictures(Set.of(menJoggersNavy, menJoggersNavyBack, menJoggersNavyAttractive))
                .setSizes(Set.of(sizeXXS, sizeXS, sizeS, sizeM, sizeXL, sizeXXL))
                .setCost(BigDecimal.valueOf(18.28))
                .setPrice(BigDecimal.valueOf(30.00))
                .setAvailable(true);

        Color stormMenJoggers = new Color()
                .setColorName("Storm")
                .setColorCode("#8D8F8F")
                .setPictures(Set.of(menJoggersStorm, menJoggersStormBack, menJoggersStormAttractive))
                .setSizes(Set.of(sizeXXS, sizeXS, sizeM, sizeXL, sizeXXL, sizeXXXL))
                .setCost(BigDecimal.valueOf(19.54))
                .setPrice(BigDecimal.valueOf(30.00))
                .setAvailable(true);

        Color carbonMenShorts = new Color()
                .setColorName("Carbon")
                .setColorCode("#5F5E62")
                .setPictures(Set.of(menShortsCarbon, menShortsCarbonBack, menShortsCarbonAtr))
                .setSizes(Set.of(sizeXXS, sizeXS, sizeM, sizeXL, sizeXXL))
                .setCost(BigDecimal.valueOf(8.62))
                .setPrice(BigDecimal.valueOf(10.99))
                .setAvailable(true);

        Color blueMenShorts = new Color()
                .setColorName("Blue Petrol")
                .setColorCode("#00589B")
                .setPictures(Set.of(menShortsPetrolBlue, menShortsPetrolBlueBack, menShortsPetrolBlueAtr))
                .setSizes(Set.of(sizeXS, sizeM, sizeXXL, sizeXXXL))
                .setCost(BigDecimal.valueOf(8.67))
                .setPrice(BigDecimal.valueOf(10.99))
                .setAvailable(true);

        Color portMenShorts = new Color()
                .setColorName("Port")
                .setColorCode("#532E3B")
                .setPictures(Set.of(menShortsPort, menShortsPortBack, menShortsPortAtr))
                .setSizes(Set.of(sizeXXS, sizeXS, sizeM, sizeL, sizeXL, sizeXXL))
                .setCost(BigDecimal.valueOf(8.69))
                .setPrice(BigDecimal.valueOf(10.99))
                .setAvailable(true);

        Color tealMenShorts = new Color()
                .setColorName("Teal")
                .setColorCode("#00656E")
                .setPictures(Set.of(menShortsTeal, menShortsTealBack, menShortsTealAtr))
                .setSizes(Set.of(sizeXXS, sizeXS, sizeM, sizeL, sizeXL, sizeXXL, sizeXXXL))
                .setCost(BigDecimal.valueOf(8.69))
                .setPrice(BigDecimal.valueOf(10.99))
                .setAvailable(true);

        Color blackMenJacket = new Color()
                .setColorName("Black")
                .setColorCode("#2D2C2F")
                .setPictures(Set.of(menJacketBlack, menJacketBlackBack, menJacketBlackAttr))
                .setSizes(Set.of(sizeXXS, sizeXS, sizeS, sizeM, sizeL, sizeXL, sizeXXL, sizeXXXL))
                .setCost(BigDecimal.valueOf(29.81))
                .setPrice(BigDecimal.valueOf(49.99))
                .setAvailable(true);

        Color greenWomenShorts = new Color()
                .setColorName("Leaf Green Tie Die")
                .setColorCode("#4b5335")
                .setPictures(Set.of(womenShortsGreen, womenShortsGreenBack, womenShortsGreenAttr))
                .setSizes(Set.of(sizeXXS, sizeXS, sizeS, sizeM, sizeL, sizeXL, sizeXXL))
                .setCost(BigDecimal.valueOf(16.86))
                .setPrice(BigDecimal.valueOf(19.99))
                .setAvailable(true);

        Color greyWomenShorts = new Color()
                .setColorName("Black Tie Die")
                .setColorCode("#2D2C2F")
                .setPictures(Set.of(womenShortsGrey, womenShortsGreyBack, womenShortsGreyAttr))
                .setSizes(Set.of(sizeXXS, sizeXS, sizeS, sizeM, sizeL, sizeXL, sizeXXL))
                .setCost(BigDecimal.valueOf(16.84))
                .setPrice(BigDecimal.valueOf(19.99))
                .setAvailable(true);

        Color blackWomenZipTop = new Color()
                .setColorName("Black")
                .setColorCode("#2D2C2F")
                .setPictures(Set.of(womenZipTopBlack, womenZipTopBlackBack, womenZipTopBlackAttr))
                .setSizes(Set.of(sizeXXS, sizeXS, sizeS, sizeM, sizeL, sizeXL, sizeXXL))
                .setCost(BigDecimal.valueOf(27.43))
                .setPrice(BigDecimal.valueOf(34.99))
                .setAvailable(true);

        Color blueWomenZipTop = new Color()
                .setColorName("Shadow Blue")
                .setColorCode("#4e5368")
                .setPictures(Set.of(womenZipTopBlue, womenZipTopBlueBack, womenZipTopBlueAttr))
                .setSizes(Set.of(sizeXXS, sizeXS, sizeS, sizeM, sizeL, sizeXL, sizeXXL))
                .setCost(BigDecimal.valueOf(28.62))
                .setPrice(BigDecimal.valueOf(37.99))
                .setAvailable(true);

        Color blackWomenSportsBra = new Color()
                .setColorName("Black")
                .setColorCode("#2D2C2F")
                .setPictures(Set.of(womenSportsBraBlack, womenSportsBraBlackBack, womenSportsBraBlackAttr))
                .setSizes(Set.of(sizeXXS, sizeXS, sizeS, sizeM, sizeL, sizeXL, sizeXXL))
                .setCost(BigDecimal.valueOf(13.21))
                .setPrice(BigDecimal.valueOf(16.99))
                .setAvailable(true);

        Color plumWomenSportsBra = new Color()
                .setColorName("Plum")
                .setColorCode("#46394b")
                .setPictures(Set.of(womenSportsBraPlum, womenSportsBraPlumBack, womenSportsBraPlumAttr))
                .setSizes(Set.of(sizeXXS, sizeXS, sizeS, sizeM, sizeL, sizeXL, sizeXXL))
                .setCost(BigDecimal.valueOf(14.24))
                .setPrice(BigDecimal.valueOf(19.99))
                .setAvailable(true);

        Color shadowBlueWomenSportsBra = new Color()
                .setColorName("Shadow Blue")
                .setColorCode("#4e5368")
                .setPictures(Set.of(womenSportsBraShadowBlue, womenSportsBraShadowBlueBack, womenSportsBraShadowBlueAttr))
                .setSizes(Set.of(sizeXS, sizeS, sizeM, sizeL, sizeXL, sizeXXL))
                .setCost(BigDecimal.valueOf(14.24))
                .setPrice(BigDecimal.valueOf(19.99))
                .setAvailable(true);

        Color stoneBlueWomenSportsBra = new Color()
                .setColorName("Stone Blue")
                .setColorCode("#587284")
                .setPictures(Set.of(womenSportsBraStoneBlue, womenSportsBraStoneBlueBack, womenSportsBraStoneBlueAttr))
                .setSizes(Set.of(sizeXS, sizeS, sizeM, sizeL, sizeXL, sizeXXL))
                .setCost(BigDecimal.valueOf(13.47))
                .setPrice(BigDecimal.valueOf(16.99))
                .setAvailable(true);

        Color stormWomenSportsBra = new Color()
                .setColorName("Storm")
                .setColorCode("#8D8F8F")
                .setPictures(Set.of(womenSportsBraStorm, womenSportsBraStormBack, womenSportsBraStormAttr))
                .setSizes(Set.of(sizeXS, sizeS, sizeM, sizeL, sizeXL))
                .setCost(BigDecimal.valueOf(13.47))
                .setPrice(BigDecimal.valueOf(16.99))
                .setAvailable(true);

        Color blackWomenGilet = new Color()
                .setColorName("Black")
                .setColorCode("#2D2C2F")
                .setPictures(Set.of(womenGiletBlackBack, womenGiletBlack))
                .setSizes(Set.of(sizeXS, sizeS, sizeM, sizeL, sizeXL, sizeXXL))
                .setCost(BigDecimal.valueOf(37.85))
                .setPrice(BigDecimal.valueOf(44.99))
                .setAvailable(true);

        Color blackWomenSocks = new Color()
                .setColorName("Black")
                .setColorCode("#2D2C2F")
                .setPictures(Set.of(womenSocksBlack, womenSock, womenSockBlack))
                .setSizes(Set.of(uk36, uk68, uk912))
                .setCost(BigDecimal.valueOf(7.42))
                .setPrice(BigDecimal.valueOf(12.00))
                .setAvailable(true);

        Color whiteWomenSocks = new Color()
                .setColorName("White")
                .setColorCode("#F1F2F1")
                .setPictures(Set.of(womenSocksBlackWhitePiece, womenSocksBlackWhite, womenSock))
                .setSizes(Set.of(uk68, uk912))
                .setCost(BigDecimal.valueOf(7.93))
                .setPrice(BigDecimal.valueOf(12.00))
                .setAvailable(true);

        Color iceBlueWomenLeggings = new Color()
                .setColorName("Ice Blue")
                .setColorCode("#879BA3")
                .setPictures(Set.of(womenLeggingsIceBlue, womenLeggingsIceBlueBack))
                .setSizes(Set.of(sizeXXS, sizeXS, sizeS, sizeM, sizeL, sizeXL, sizeXXL))
                .setCost(BigDecimal.valueOf(16.03))
                .setPrice(BigDecimal.valueOf(20.99))
                .setAvailable(true);

        Color navyWomenLeggings = new Color()
                .setColorName("Navy")
                .setColorCode("#27293D")
                .setPictures(Set.of(womenLeggingsNavy, womenLeggingsNavyBack, womenLeggingsNavyAtr))
                .setSizes(Set.of(sizeXS, sizeS, sizeM, sizeL))
                .setCost(BigDecimal.valueOf(17.12))
                .setPrice(BigDecimal.valueOf(22.99))
                .setAvailable(true);

        Color chalkPurpleWomenLeggings = new Color()
                .setColorName("Chalk Purple")
                .setColorCode("#7C83BC")
                .setPictures(Set.of(womenLeggingsChalkPurple, womenLeggingsChalkPurpleBack))
                .setSizes(Set.of(sizeXXS, sizeXS, sizeS, sizeM, sizeL, sizeXL, sizeXXL))
                .setCost(BigDecimal.valueOf(16.21))
                .setPrice(BigDecimal.valueOf(20.99))
                .setAvailable(true);


        colorBlue = this.colorRepository.save(colorBlue);
        colorWhite = this.colorRepository.save(colorWhite);
        colorDanger = this.colorRepository.save(colorDanger);
        colorBlack = this.colorRepository.save(colorBlack);

        blackMarl = this.colorRepository.save(blackMarl);
        blueMarl = this.colorRepository.save(blueMarl);
        cherryMarl = this.colorRepository.save(cherryMarl);
        armyGreenMarl = this.colorRepository.save(armyGreenMarl);
        chromeMarl = this.colorRepository.save(chromeMarl);
        dangerMarl = this.colorRepository.save(dangerMarl);

        blackHoodie = this.colorRepository.save(blackHoodie);
        greyMarlHoodie = this.colorRepository.save(greyMarlHoodie);
        navyHoodie = this.colorRepository.save(navyHoodie);

        blackMenJoggers = this.colorRepository.save(blackMenJoggers);
        navyMenJoggers = this.colorRepository.save(navyMenJoggers);
        stormMenJoggers = this.colorRepository.save(stormMenJoggers);

        carbonMenShorts = this.colorRepository.save(carbonMenShorts);
        blueMenShorts = this.colorRepository.save(blueMenShorts);
        portMenShorts = this.colorRepository.save(portMenShorts);
        tealMenShorts = this.colorRepository.save(tealMenShorts);

        blackMenJacket = this.colorRepository.save(blackMenJacket);

        greenWomenShorts = this.colorRepository.save(greenWomenShorts);
        greyWomenShorts = this.colorRepository.save(greyWomenShorts);

        blackWomenZipTop = this.colorRepository.save(blackWomenZipTop);
        blueWomenZipTop = this.colorRepository.save(blueWomenZipTop);

        blackWomenSportsBra = this.colorRepository.save(blackWomenSportsBra);
        plumWomenSportsBra = this.colorRepository.save(plumWomenSportsBra);
        shadowBlueWomenSportsBra = this.colorRepository.save(shadowBlueWomenSportsBra);
        stoneBlueWomenSportsBra = this.colorRepository.save(stoneBlueWomenSportsBra);
        stormWomenSportsBra = this.colorRepository.save(stormWomenSportsBra);

        blackWomenGilet = this.colorRepository.save(blackWomenGilet);

        blackWomenSocks = this.colorRepository.save(blackWomenSocks);
        whiteWomenSocks = this.colorRepository.save(whiteWomenSocks);

        iceBlueWomenLeggings = this.colorRepository.save(iceBlueWomenLeggings);
        chalkPurpleWomenLeggings = this.colorRepository.save(chalkPurpleWomenLeggings);
        navyWomenLeggings = this.colorRepository.save(navyWomenLeggings);



        Wear longSleeveTShirt = new Wear()
                .setFabric("90% polyester 10% elastane")
                .setAvailableColors(Set.of(colorBlack, colorDanger, colorWhite, colorBlue));

        longSleeveTShirt.setName("MP Men's Infinity Mark Graphic Training Long Sleeve T-Shirt");
        longSleeveTShirt.setCategories(Set.of(categoryWear, categoryMen, categoryTShirt, categoryLongSleeve));
        longSleeveTShirt.setDescription("Mix up your training wardrobe with our long sleeved t-shirt, we've got you covered.");
        longSleeveTShirt.setRating(5.00);
        longSleeveTShirt.setSlogan("Graphic training long sleeve t-Shirt");

        Wear shortSleeveTShirt = new Wear()
                .setFabric("81% viscose 14% polyester 5% elastane")
                .setAvailableColors(Set.of(armyGreenMarl, blackMarl, cherryMarl, chromeMarl, blueMarl, dangerMarl));

        shortSleeveTShirt.setName("MP Men's Performance Short Sleeve T-Shirt");
        shortSleeveTShirt.setCategories(Set.of(categoryWear, categoryMen, categoryTShirt, categoryLongSleeve));
        shortSleeveTShirt.setDescription("""
                It's our mission to make sure you're covered throughout all types of training — which is where our Performance range comes in.

                This short-sleeved t-shirt is made with soft-touch stretch fabric and features raglan sleeves to offer both comfort and maximum range of movement as you push for your goals.""");
        shortSleeveTShirt.setRating(4.87);
        shortSleeveTShirt.setSlogan("Muscle-fit t-shirt");

        Wear menHoodie = new Wear()
                .setFabric("66% Cotton 32% Polyester, 2% Viscose")
                .setAvailableColors(Set.of(blackHoodie, greyMarlHoodie, navyHoodie));

        menHoodie.setName("MP Men's Rest Day Hoodie");
        menHoodie.setCategories(Set.of(categoryWear, categoryMen, categoryHoodie));
        menHoodie.setDescription("""
                It's our mission to make sure you're covered throughout all types of training — which is where our Performance range comes in.

                This short-sleeved t-shirt is made with soft-touch stretch fabric and features raglan sleeves to offer both comfort and maximum range of movement as you push for your goals.""");
        menHoodie.setRating(4.96);
        menHoodie.setSlogan("Muscle-fit t-shirt");

        Wear mensJoggers = new Wear()
                .setFabric("93% polyester 7% elastane")
                .setAvailableColors(Set.of(blackMenJoggers, navyMenJoggers, stormMenJoggers));

        mensJoggers.setName("MP Men's Training Joggers");
        mensJoggers.setCategories(Set.of(categoryWear, categoryMen, categoryJoggers));
        mensJoggers.setDescription("""
                Whatever your workout plan, our Essentials training range is designed to form the basis of your training wardrobe. 

                The perfect day to day training wear, our slim fit Essentials Training Joggers feature side welt pockets to store your valuables whilst you work out, cover-stitched seams for added comfort and zero distractions, and an embroidered MP logo to the thigh.""");
        mensJoggers.setRating(4.72);
        mensJoggers.setSlogan("Men's slim fit training joggers with pockets");

        Wear mensShorts = new Wear()
                .setFabric("100% Polyester")
                .setAvailableColors(Set.of(carbonMenShorts, blueMenShorts, portMenShorts, tealMenShorts));

        mensShorts.setName("MP Men's Repeat Mark Graphic Training Shorts");
        mensShorts.setCategories(Set.of(categoryWear, categoryMen, categoryShorts));
        mensShorts.setDescription("""
                Complete your workout wardrobe with our Graphic Training pieces. Designed for the gym floor, they offer everything you need for everyday sessions.
                                
                The Repeat Mark Graphic Training Shorts are a gym essential and feature a grown-on elasticated waistband with branded drawcords for comfort, and a graphic print and MP logo. Side seam pockets keep your valuables safe whilst you train.""");
        mensShorts.setRating(4.61);
        mensShorts.setSlogan("MRegular fit shorts with 7 inch inseam");

        Wear mensJacket = new Wear()
                .setFabric(null)
                .setAvailableColors(Set.of(blackMenJacket));

        mensJacket.setName("MP Men's Velocity Ultra Jacket");
        mensJacket.setCategories(Set.of(categoryWear, categoryMen, categoryJacket, categoryZipTop));
        mensJacket.setDescription("Whether you’re out on a run, or smashing it in the gym, our Velocity Ultra jacket " +
                "is made to move with you, wherever, whenever. Designed with stretch woven fabric and a ventilating " +
                "mesh vent to the back, for a comfortable and functional fit.");
        mensJacket.setRating(4.73);
        mensJacket.setSlogan("Men's tretch woven training jacket with zip pockets");

        Wear womenBootyShorts = new Wear()
                .setFabric(null)
                .setAvailableColors(Set.of(greenWomenShorts, greyWomenShorts));

        womenBootyShorts.setName("MP Women's Shape Seamless Booty Shorts");
        womenBootyShorts.setCategories(Set.of(categoryWear, categoryWomen, categoryShorts));
        womenBootyShorts.setDescription("""
                Level up your gym wardrobe with our seamless booty shorts. Designed with sweat wicking material to keep you cool and fresh during your workout.\s

                This garment has undergone a specific tie dye process to create a patterned effect. Due to the nature of this process, appearance can vary from garment to garment making each set unique!""");
        womenBootyShorts.setRating(4.79);
        womenBootyShorts.setSlogan("Seamless booty shorts");

        Wear womenZipTop = new Wear()
                .setFabric(null)
                .setAvailableColors(Set.of(blueWomenZipTop, blackWomenZipTop));

        womenZipTop.setName("MP Women's Velocity Ultra Reflective 1/4 Zip Top");
        womenZipTop.setCategories(Set.of(categoryWear, categoryWomen, categoryZipTop));
        womenZipTop.setDescription("Perfect for layering, designed in a breathable and " +
                "flattering silhouette. Featuring reflective detailing.");
        womenZipTop.setRating(4.63);
        womenZipTop.setSlogan("Women's slim fit 1/4 zip");

        Wear womenSportsBra = new Wear()
                .setFabric(null)
                .setAvailableColors(Set.of(blackWomenSportsBra, shadowBlueWomenSportsBra,
                        stoneBlueWomenSportsBra, plumWomenSportsBra, stormWomenSportsBra));

        womenSportsBra.setName("MP Women's Velocity Sports Bra");
        womenSportsBra.setCategories(Set.of(categoryWear, categoryWomen, categorySportsBra));
        womenSportsBra.setDescription("Feel comfortable and confident in our supportive sports bra which " +
                "has your back every step of the way. Designed with a racerback for unrestrictive movement.");
        womenSportsBra.setRating(4.77);
        womenSportsBra.setSlogan("Women's mid-support sports bra");

        Wear womenGilet = new Wear()
                .setFabric(null)
                .setAvailableColors(Set.of(blackWomenGilet));

        womenGilet.setName("MP Women's Velocity Ultra Cropped Gilet");
        womenGilet.setCategories(Set.of(categoryWear, categoryWomen, categoryGilet));
        womenGilet.setDescription("A stylish cropped design in a water repellent fabric. " +
                "This gilet is the perfect piece to layer up your look. Complete with zip pockets " +
                "to offer a safe space for storage.");
        womenGilet.setRating(4.41);
        womenGilet.setSlogan("Women's cropped gilet");

        Wear womenSocks = new Wear()
                .setFabric("63 cotton%, 34% polyamide, 3% elastane")
                .setAvailableColors(Set.of(blackWomenSocks, whiteWomenSocks));

        womenSocks.setName("MP Women's Crew Socks (3 Pack)");
        womenSocks.setCategories(Set.of(categoryWear, categoryWomen, categorySocks, categoryUnderWear));
        womenSocks.setDescription("Lightweight, comfortable, and built to last– the perfect" +
                " choice for everyday wear. These Crew Socks also have ribbed cuffs to keep them in place, and an " +
                "arch band for support.");
        womenSocks.setRating(5.00);
        womenSocks.setSlogan("Essential crew socks");

        Wear womenLeggings = new Wear()
                .setFabric("""
                        Body: 92% Nylon 8% Elastane

                        Waistband: 83% Nylon 17% Elastane""")
                .setAvailableColors(Set.of(iceBlueWomenLeggings, chalkPurpleWomenLeggings, navyWomenLeggings));

        womenLeggings.setName("MP Women's Composure Seamless Leggings");
        womenLeggings.setCategories(Set.of(categoryWear, categoryWomen, categoryLeggings));
        womenLeggings.setDescription("Designed with a high rise, supportive waistband, these seamless leggings " +
                "are a must have! Stretchy and super soft fabric to ensure a comfortable session.");
        womenLeggings.setRating(4.00);
        womenLeggings.setSlogan("Women's high waist soft touch seamless leggings");

        this.wearRepository.save(longSleeveTShirt);
        this.wearRepository.save(shortSleeveTShirt);
        this.wearRepository.save(menHoodie);

        this.wearRepository.save(mensJoggers);
        this.wearRepository.save(mensShorts);
        this.wearRepository.save(mensJacket);

        this.wearRepository.save(womenBootyShorts);
        this.wearRepository.save(womenZipTop);
        this.wearRepository.save(womenSportsBra);

        this.wearRepository.save(womenGilet);
        this.wearRepository.save(womenSocks);
        this.wearRepository.save(womenLeggings);

        ExclusiveOffer hoodieOffer = new ExclusiveOffer()
                .setTitle("Hoodie Offer")
                .setDiscountPercent(15)
                .setDiscountedCategories(Set.of(categoryHoodie))
                .setStartDate(LocalDate.of(2022, 12, 4))
                .setEndDate(LocalDate.of(2022, 12, 20))
                .setActive(true)
                .setExclusivePicture(hoodieDiscount);

        ExclusiveOffer menShortsOffer = new ExclusiveOffer()
                .setTitle("Mens Shorts Offer")
                .setDiscountPercent(15)
                .setDiscountedCategories(Set.of(categoryMen, categoryShorts))
                .setStartDate(LocalDate.of(2022, 12, 4))
                .setEndDate(LocalDate.of(2022, 12, 20))
                .setActive(true)
                .setExclusivePicture(mensShortsDiscount);

        ExclusiveOffer menTShirtsOffer = new ExclusiveOffer()
                .setTitle("Mens TShirts Offer")
                .setDiscountPercent(15)
                .setDiscountedCategories(Set.of(categoryMen, categoryTShirt))
                .setStartDate(LocalDate.of(2022, 12, 5))
                .setEndDate(LocalDate.of(2022, 12, 24))
                .setActive(true)
                .setExclusivePicture(mensTShirtsDiscount);

        ExclusiveOffer womenLeggingsOffer = new ExclusiveOffer()
                .setTitle("Women Leggings Offer")
                .setDiscountPercent(15)
                .setDiscountedCategories(Set.of(categoryWomen, categoryLeggings))
                .setStartDate(LocalDate.of(2022, 12, 2))
                .setEndDate(LocalDate.of(2022, 12, 27))
                .setActive(true)
                .setExclusivePicture(womenLeggingsDiscount);

        this.exclusiveOfferRepository.save(hoodieOffer);
        this.exclusiveOfferRepository.save(menShortsOffer);
        this.exclusiveOfferRepository.save(menTShirtsOffer);
        this.exclusiveOfferRepository.save(womenLeggingsOffer);
    }

    private void initUsers() {
        this.userService.init();
    }

}

